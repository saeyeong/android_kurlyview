package com.example.kurlyview.data

import com.example.kurlyview.data.response.OrderingReviewsDto
import com.example.kurlyview.data.response.ReviewsDto

interface ReviewApiService {

    fun getReviews(productId: Int): ReviewsDto

    fun getMediaReviews(productId: Int): ReviewsDto

    fun getOrderingReviews(order: String, filter: String): OrderingReviewsDto
}