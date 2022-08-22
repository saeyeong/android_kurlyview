package com.example.kurlyview.data.source.response

import com.example.kurlyview.domain.Media


data class MediaDto(
    var photoUrl: String? = null,
    var videoUrl: String? = null,
)

fun MediaDto.toEntity(): Media? {
    return Media(
        photoUrl = this.photoUrl ?: return null,
        videoUrl = this.videoUrl ?: return null
    )
}