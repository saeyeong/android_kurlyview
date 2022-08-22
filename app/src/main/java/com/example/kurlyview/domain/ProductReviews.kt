package com.example.kurlyview.domain

data class ProductReviews(
    val bestReviews: List<Review>,
    val mediaReviews: List<Review>,
    val orderingReviews: OrderingReviews
)