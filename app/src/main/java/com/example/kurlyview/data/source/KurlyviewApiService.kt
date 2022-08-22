package com.example.kurlyview.data.source

import com.example.kurlyview.data.source.response.ProductReviewsDto
import retrofit2.http.GET

interface KurlyviewApiService {

    @GET
    suspend fun getReviews(productId: Int): ProductReviewsDto

    @GET
    suspend fun getMediaReviews(productId: Int): ProductReviewsDto //모든 미디어 리뷰
}