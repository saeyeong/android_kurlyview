package com.example.kurlyview.data.source.response

import com.example.kurlyview.domain.Product

data class ProductDto(
    var name: String? = null,
    var imageUrl: String? = null,
    var price: Int? = null
)

fun ProductDto.toEntity(): Product? {
    return Product(
        name = this.name ?: return null,
        imageUrl = this.imageUrl ?: return null,
        price = this.price ?: return null
    )
}