package com.example.kurlyview.domain

data class TextReview(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val createdAt: String,
    override val writer: String
) : Review