package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.ReviewThumbnails

data class ReviewThumbnailsDto(
    var content: List<ReviewThumbnailDto>? = null,
    var first: Boolean? = null,
    var last: Boolean? = null,
    var size: Int? = null
)

fun ReviewThumbnailsDto.toEntity(): ReviewThumbnails? {
    return ReviewThumbnails(
        content = this.content?.mapNotNull { it.toEntity() } ?: return null,
        first = this.first ?: return null,
        last = this.last ?: return null,
        size = this.size ?: return null
    )
}