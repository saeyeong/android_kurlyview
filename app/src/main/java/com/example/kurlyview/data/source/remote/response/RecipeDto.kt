package com.example.kurlyview.data.source.remote.response


data class RecipeDto(
    var totalTime: Long? = null,
    var ingredients: List<String>? = null,
    var directions: List<String>? = null,
    var relatedProducts: List<ProductDto>? = null
)