package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.OrderingReviews

class OrderingReviewsDto {
    var reviews: List<ReviewDto>? = null
    var order: String? = null
    var filter: String? = null
}

fun OrderingReviewsDto.toEntity(): OrderingReviews? {
    return OrderingReviews(
        reviews = this.reviews?.mapNotNull { it.toEntity() } ?: return null,
        order = this.order ?: return null,
        filter = this.filter ?: return null
    )
}