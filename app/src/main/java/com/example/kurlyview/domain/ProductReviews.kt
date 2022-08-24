package com.example.kurlyview.domain


data class ProductReviews(
    val id: Int,
    val score: String,
    val mediaReviews: List<ReviewThumbnail>,
)