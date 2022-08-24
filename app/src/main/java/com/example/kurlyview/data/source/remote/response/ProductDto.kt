package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.Product

data class ProductDto(
    var title: String? = null,
    var urlList: List<String>? = null,
    var price: Int? = null
)

fun ProductDto.toEntity(): Product? {
    return Product(
        title = this.title ?: return null,
        urlList = this.urlList ?: return null,
        price = this.price ?: return null
    )
}