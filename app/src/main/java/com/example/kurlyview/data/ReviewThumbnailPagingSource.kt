package com.example.kurlyview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kurlyview.data.source.remote.request.toDto
import com.example.kurlyview.domain.ReviewOrderingInfo
import com.example.kurlyview.domain.ReviewThumbnail

class ReviewThumbnailPagingSource(
    private val reviewOrderingInfo: ReviewOrderingInfo
) : PagingSource<Int, ReviewThumbnail>() {

    override fun getRefreshKey(state: PagingState<Int, ReviewThumbnail>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ReviewThumbnail> {
        val position = params.key ?: 0
        val response = ReviewRepository.getReviewThumbnails(
            reviewOrderingInfo.toDto(position, params.loadSize)
        )
        val reviewThumbnails = response?.content ?: listOf()
        val nextKey = if (reviewThumbnails.isEmpty()) {
            null
        } else {
            position + (params.loadSize / 8)
        }

        return LoadResult.Page(
            data = reviewThumbnails,
            prevKey = if (position == 0) null else position - 1,
            nextKey = nextKey
        )
    }

}