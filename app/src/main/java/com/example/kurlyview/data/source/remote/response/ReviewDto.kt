package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.*

class ReviewDto {
    var id: Int? = null
    var title: String? = null
    var body: String? = null
    var url: List<String>? = null
    var recipe: RecipeDto? = null
    var createDt: String? = null
    var writer: String? = null
}

fun ReviewDto.toEntity(): Review? {
    return when {
        recipe != null -> RecipeReview(
            id = this.id ?: return null,
            title = this.title ?: return null,
            body = this.body ?: return null,
            createDt = this.createDt ?: return null,
            writer = this.writer ?: return null,
            url = this.url?.mapNotNull { it } ?: return null,
            totalTime = this.recipe?.totalTime ?: return null,
            ingredients = this.recipe?.ingredients ?: return null,
            directions = this.recipe?.directions ?: return null,
            relatedProducts = this.recipe?.relatedProducts?.mapNotNull { it.toEntity() } ?: return null
        )
        url != null -> MediaReview(
            id = this.id ?: return null,
            title = this.title ?: return null,
            body = this.body ?: return null,
            createDt = this.createDt ?: return null,
            writer = this.writer ?: return null,
            url = this.url?.mapNotNull { it } ?: return null,
        )
        else -> TextReview(
            id = this.id ?: return null,
            title = this.title ?: return null,
            body = this.body ?: return null,
            createDt = this.createDt ?: return null,
            writer = this.writer ?: return null
        )
    }
}