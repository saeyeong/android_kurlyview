package com.example.kurlyview.domain

data class RecipeReview(
    override val id: Int,
    override val title: String,
    override val body: String,
    override val createDt: String,
    override val writer: String,
    val totalTime: Long,
    val ingredients: List<String>,
    val directions: List<String>,
    val url: List<String>?,
    val relatedProducts: List<Product>?
): Review