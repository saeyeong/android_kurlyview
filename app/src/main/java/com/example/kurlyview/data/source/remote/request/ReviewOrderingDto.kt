package com.example.kurlyview.data.source.remote.request

import com.example.kurlyview.domain.ReviewOrderingInfo
import com.example.kurlyview.domain.ReviewInfo

data class ReviewOrderingDto(
    val order: String = "",
    val page: Int = 0,
    val search: ReviewSearchInfoDto,
    val size: Int = 0
)

data class ReviewSearchInfoDto(
    var productId: Int
)

fun ReviewOrderingInfo.toDto(start: Int, size: Int): ReviewOrderingDto {
    return ReviewOrderingDto(
        order = this.order,
        page = start,
        search = this.info.toDto(),
        size = size
    )
}

fun ReviewInfo.toDto(): ReviewSearchInfoDto {
    return ReviewSearchInfoDto(
        productId = this.productId
    )
}