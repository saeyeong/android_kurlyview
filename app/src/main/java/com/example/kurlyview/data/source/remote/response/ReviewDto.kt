package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.*

class ReviewDto {
    var title: String? = null
    var description: String? = null
    var content: MediaDto? = null
    var recipe: RecipeDto? = null
    var createdAt: String? = null
    var writer: String? = null
}

fun ReviewDto.toEntity(): Review? {
    return when {
        recipe != null -> RecipeReview(
            title = this.title ?: return null,
            description = this.description ?: return null,
            createdAt = this.createdAt ?: return null,
            writer = this.writer ?: return null,
            content = this.content?.toEntity(),
            totalTime = this.recipe?.totalTime ?: return null,
            ingredients = this.recipe?.ingredients ?: return null,
            directions = this.recipe?.directions ?: return null,
            relatedProducts = this.recipe?.relatedProducts?.mapNotNull { it.toEntity() } ?: return null
        )
        content != null -> MediaReview(
            title = this.title ?: return null,
            description = this.description ?: return null,
            createdAt = this.createdAt ?: return null,
            writer = this.writer ?: return null,
            content = this.content?.toEntity() ?: return null
        )
        else -> TextReview(
            title = this.title ?: return null,
            description = this.description ?: return null,
            createdAt = this.createdAt ?: return null,
            writer = this.writer ?: return null
        )
    }
}