package com.example.kurlyview.data.source.remote

import com.example.kurlyview.data.source.remote.request.ReviewOrderingDto
import com.example.kurlyview.data.source.remote.response.*
import retrofit2.http.*

interface KurlyviewApiService {

    @GET("v1/login")
    suspend fun login(@Query("uuid") uuid: String): LoginDto

    @POST("v1/review/info")
    suspend fun getReviewInfo(@Body reviewOrderingDto: ReviewOrderingDto): ProductReviewsDto

    @GET("v1/product/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): ProductDto

    @POST("v1/review/search")
    suspend fun searchReview(@Body reviewOrderingDto: ReviewOrderingDto): SearchedReviewsDto

    @GET("v1/review/{reviewId}")
    suspend fun getReview(@Path("reviewId") productId: Int): ReviewDto

    @POST("v1/review/search/medias")
    suspend fun getReviewThumbnails(@Body reviewOrderingDto: ReviewOrderingDto): ReviewThumbnailsDto
}