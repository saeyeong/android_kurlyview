package com.example.kurlyview.domain

data class MediaReview(
    val title: String,
    val description: String,
    val createdAt: String,
    val writer: String,
    val content: Media
): Review()