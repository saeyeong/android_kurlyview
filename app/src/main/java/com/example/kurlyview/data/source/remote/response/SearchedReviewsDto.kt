package com.example.kurlyview.data.source.remote.response

import com.example.kurlyview.domain.Review
import com.example.kurlyview.domain.SearchedReviews

class SearchedReviewsDto {

    var content: List<ReviewDto>? = null
    var first: Boolean? = null
}

fun SearchedReviewsDto.toEntity(): SearchedReviews? {
    return SearchedReviews(
        content = this.content?.mapNotNull { it.toEntity() } ?: return null
    )
}