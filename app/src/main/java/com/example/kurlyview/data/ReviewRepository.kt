package com.example.kurlyview.data

import com.example.kurlyview.data.source.KurlyviewApiServiceProvider
import com.example.kurlyview.data.source.response.toEntity
import com.example.kurlyview.domain.Product
import com.example.kurlyview.domain.ProductReviews
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object ReviewRepository {
    private val service = KurlyviewApiServiceProvider.get()

    suspend fun getProduct(productId: Int): Flow<Product> {
        return flow {
            service.getProduct(productId).toEntity()?.let { emit(it) }
        }
    }

    suspend fun getReview(productId: Int): Flow<ProductReviews> {
        return flow {
            service.getReview(productId).toEntity()
        }
    }
}