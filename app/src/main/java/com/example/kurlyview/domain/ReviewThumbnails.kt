package com.example.kurlyview.domain

data class ReviewThumbnails(
    val content: List<ReviewThumbnail>,
    val first: Boolean,
    val last: Boolean,
    val size: Int
)