package com.example.kurlyview.data

import com.example.kurlyview.data.source.KurlyviewApiServiceProvider
import com.example.kurlyview.data.source.response.toEntity
import com.example.kurlyview.domain.OrderingReviews
import com.example.kurlyview.domain.ProductReviews

class ReviewRepository {
    private val service = KurlyviewApiServiceProvider.get()

    suspend fun getProductReview(productId: Int): ProductReviews {
        return service.getReviews(productId).toEntity() ?: ProductReviews(
            bestReviews = listOf(),
            mediaReviews = listOf(),
            orderingReviews = OrderingReviews(
                reviews = listOf(),
                order = OrderingReviews.Order.LATEST.name,
                filter = OrderingReviews.FILTER.ALL.name
            )
        )
    }
}