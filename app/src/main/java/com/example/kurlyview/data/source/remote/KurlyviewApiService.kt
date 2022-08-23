package com.example.kurlyview.data.source.remote

import com.example.kurlyview.data.source.remote.response.LoginDto
import com.example.kurlyview.data.source.remote.response.ProductDto
import com.example.kurlyview.data.source.remote.response.ProductReviewsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KurlyviewApiService {

    @GET("v1/login")
    suspend fun login(@Query("uuid") uuid: String): LoginDto

    @GET("v1/product/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): ProductDto

    @GET("v1/review/{productId}")
    suspend fun getReview(@Path("productId") productId: Int): ProductReviewsDto

    @GET
    suspend fun getMediaReviews(productId: Int): ProductReviewsDto //모든 미디어 리뷰
}