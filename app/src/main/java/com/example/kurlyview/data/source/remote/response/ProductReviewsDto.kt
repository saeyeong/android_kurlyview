package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.ProductReviews

data class ProductReviewsDto(
    var productId: Int? = null,
    var score: String? = null,
    var medias: List<ReviewThumbnailDto>? = null // 최근 8개 사진&동영상 리뷰
)

fun ProductReviewsDto.toEntity(): ProductReviews? {
    return ProductReviews(
        id = this.productId ?: return null,
        score = this.score ?: return null,
        mediaReviews = this.medias?.mapNotNull {
            it.toEntity()
        } ?: return null,
    )
}

