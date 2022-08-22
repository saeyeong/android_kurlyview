package com.example.kurlyview.domain

data class RecipeReview(
    val title: String,
    val description: String,
    val createdAt: String,
    val writer: String,
    val totalTime: Long,
    val ingredients: List<String>,
    val directions: List<String>,
    val content: Media?,
    val relatedProducts: List<Product>?
): Review()