package com.example.kurlyview.domain

data class TextReview(
    val title: String,
    val description: String,
    val createdAt: String,
    val writer: String,
) : Review()