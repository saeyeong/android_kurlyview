package com.example.kurlyview.domain


data class OrderingReviews(
    val reviews: List<Review>,
    val order: String,
    val filter: String
) {
    enum class Order {
        LATEST,
        USEFUL
    }
    enum class FILTER {
        ALL,
        RECIPE,
        MEDIA,
        TEXT
    }
}