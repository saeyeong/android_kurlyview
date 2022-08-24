package com.example.kurlyview.domain

data class MediaReview(
    override val id: Int,
    override val title: String,
    override val body: String,
    override val createDt: String,
    override val writer: String,
    val thumbnail: String,
    val url: List<String>
): Review