package com.example.kurlyview.presentation.detail.review.view

import com.example.kurlyview.domain.Review

data class ReviewUiState(
    val header: ReviewHeaderUiState? = null,
    val review: Review? = null
)