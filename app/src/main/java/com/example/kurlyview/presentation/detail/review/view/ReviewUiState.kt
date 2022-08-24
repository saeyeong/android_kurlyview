package com.example.kurlyview.presentation.detail.review.view

import com.example.kurlyview.domain.ProductReviews
import com.example.kurlyview.domain.Review
import kotlin.contracts.contract

data class ReviewUiState(
    val header: ReviewHeaderUiState? = null,
    val review: Review? = null
)

fun ProductReviews.toUiState(): ReviewUiState {
    return ReviewUiState(
        header = ReviewHeaderUiState(
            productId = this.id,
            score = this.score,
            reviewThumbnail = this.mediaReviews,
            order = "",
            filter = ""
        )
    )
}

fun Review.toReviewUiState(): ReviewUiState {
    return ReviewUiState(
            review = this
        )
}