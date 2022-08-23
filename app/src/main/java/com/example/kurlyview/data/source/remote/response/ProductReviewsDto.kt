package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.ProductReviews

class ProductReviewsDto {
    var bestReviews: List<ReviewDto>? = null
    var mediaReviews: List<ReviewDto>? = null // 최근 8개 사진&동영상 리뷰
    var orderingReviews: OrderingReviewsDto? = null
}

fun ProductReviewsDto.toEntity(): ProductReviews? {
    return ProductReviews(
        bestReviews = this.bestReviews?.mapNotNull { it.toEntity() } ?: return null,
        mediaReviews = this.mediaReviews?.mapNotNull { it.toEntity() } ?: return null,
        orderingReviews = this.orderingReviews?.toEntity() ?: return null
    )
}

