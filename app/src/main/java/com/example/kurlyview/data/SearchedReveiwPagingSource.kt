package com.example.kurlyview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kurlyview.data.source.remote.request.toDto
import com.example.kurlyview.domain.Review
import com.example.kurlyview.domain.ReviewOrderingInfo
import com.example.kurlyview.presentation.detail.review.view.ReviewUiState
import com.example.kurlyview.presentation.detail.review.view.toReviewUiState

class SearchReviewPagingSource(
    private val reviewOrderingInfo: ReviewOrderingInfo
) : PagingSource<Int, ReviewUiState>() {

    override fun getRefreshKey(state: PagingState<Int, ReviewUiState>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ReviewUiState> {
        val position = params.key ?: 0
        val response = ReviewRepository.searchReview(
            reviewOrderingInfo.toDto(position, params.loadSize)
        )
        val reviews = response?.content?.map { it.toReviewUiState()} ?: listOf()
        val nextKey = if (reviews.isEmpty()) {
            null
        } else {
            position + (params.loadSize / 8)
        }

        return LoadResult.Page(
            data = reviews,
            prevKey = if (position == 0) null else position - 1,
            nextKey = nextKey
        )
    }

}