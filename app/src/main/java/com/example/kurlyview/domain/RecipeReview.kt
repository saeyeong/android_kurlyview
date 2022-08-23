package com.example.kurlyview.domain

data class RecipeReview(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val createdAt: String,
    override val writer: String,
    val totalTime: Long,
    val ingredients: List<String>,
    val directions: List<String>,
    val content: Media?,
    val relatedProducts: List<Product>?
): Review