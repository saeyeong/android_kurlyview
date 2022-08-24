package com.example.kurlyview.data

import androidx.paging.*
import com.example.kurlyview.data.source.remote.KurlyviewApiServiceProvider
import com.example.kurlyview.data.source.remote.request.ReviewOrderingDto
import com.example.kurlyview.data.source.remote.request.toDto
import com.example.kurlyview.data.source.remote.response.LoginDto
import com.example.kurlyview.data.source.remote.response.toEntity
import com.example.kurlyview.domain.*
import com.example.kurlyview.presentation.detail.review.view.ReviewUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

object ReviewRepository {
    private val service = KurlyviewApiServiceProvider.get()

    suspend fun login(userDeviceId: String): Flow<LoginDto> {
        return flow {
            emit(service.login(userDeviceId))
        }
    }

    suspend fun getProduct(productId: Int): Flow<Product> {
        return flow {
            service.getProduct(productId).toEntity()?.let { emit(it) }
        }
    }

    suspend fun getReviewInfo(reviewOrderingInfo: ReviewOrderingInfo): Flow<ProductReviews> {
        return flow {
            service.getReviewInfo(reviewOrderingInfo.toDto(
                start = 0,
                size = 8
            )).toEntity()?.let {
                emit(it)
            }
        }
    }

    suspend fun searchReview(reviewOrderingDto: ReviewOrderingDto): SearchedReviews? {
        val a = service.searchReview(reviewOrderingDto)

        return a.toEntity()
    }

    fun getSearchReview(reviewOrderingInfo: ReviewOrderingInfo): Flow<PagingData<ReviewUiState>> {
        return Pager(
            config = PagingConfig(
                pageSize = 8,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SearchReviewPagingSource(reviewOrderingInfo) }
        ).flow
    }

    suspend fun getReview(reviewId: Int): Flow<Review> {
        return flow {
            service.getReview(reviewId).toEntity()?.let { emit(it) }
        }
    }

    suspend fun getReviewThumbnails(reviewOrderingDto: ReviewOrderingDto): ReviewThumbnails? {
        return service.getReviewThumbnails(reviewOrderingDto).toEntity()
    }

    fun getMediaReviews(reviewOrderingInfo: ReviewOrderingInfo): Flow<PagingData<ReviewThumbnail>> {
        return Pager(
            config = PagingConfig(
                pageSize = 8,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ReviewThumbnailPagingSource(reviewOrderingInfo) }
        ).flow
    }
}