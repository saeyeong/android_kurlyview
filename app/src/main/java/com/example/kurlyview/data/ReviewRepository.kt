package com.example.kurlyview.data

import com.example.kurlyview.data.source.remote.KurlyviewApiServiceProvider
import com.example.kurlyview.data.source.remote.response.LoginDto
import com.example.kurlyview.data.source.remote.response.toEntity
import com.example.kurlyview.domain.Product
import com.example.kurlyview.domain.ProductReviews
import com.example.kurlyview.domain.Review
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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

    suspend fun getReview(reviewId: Int): Flow<List<Review>> {
        return flow {
            service.getReview(reviewId).mapNotNull { it.toEntity() }.let { emit(it) }
        }
    }
}