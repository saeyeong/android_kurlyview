package com.example.kurlyview.presentation.detail.review.view

import com.example.kurlyview.domain.Media

data class ReviewHeaderUiState(
    val purchaseSatisfaction: String,
    val mediaReviewThumbnail: List<Media>,
    val filter: String,
    val order: String
)