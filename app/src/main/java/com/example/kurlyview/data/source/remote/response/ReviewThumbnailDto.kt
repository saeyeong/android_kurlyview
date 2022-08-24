package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.ReviewThumbnail

data class ReviewThumbnailDto(
    var id: Int? = null,
    var thumbnail: String? = null,
    var url: String? = null
)

fun ReviewThumbnailDto.toEntity(): ReviewThumbnail? {
    return ReviewThumbnail(
        id = this.id ?: return null,
        thumbnail = this.thumbnail ?: "",
        url = this.url ?: return null
    )
}