package com.example.kurlyview.domain

data class TextReview(
    override val id: Int,
    override val title: String,
    override val body: String,
    override val createDt: String,
    override val writer: String
) : Review