package com.example.kurlyview.presentation.detail.review.view

import com.example.kurlyview.domain.ReviewThumbnail

data class ReviewHeaderUiState(
    val productId: Int,
    val score: String,
    val reviewThumbnail: List<ReviewThumbnail>,
    val filter: String,
    val order: String
)