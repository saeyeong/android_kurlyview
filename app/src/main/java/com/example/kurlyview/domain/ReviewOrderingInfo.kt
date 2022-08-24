package com.example.kurlyview.domain


class ReviewOrderingInfo(
    val order: String = "",
    val info: ReviewInfo
)

data class ReviewInfo(
    val productId: Int
)