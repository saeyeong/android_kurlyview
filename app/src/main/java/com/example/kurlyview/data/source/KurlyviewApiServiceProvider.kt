package com.example.kurlyview.data.source

import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

object KurlyviewApiServiceProvider {

    private const val API_SERVER_URL = ""

    private var apiService = createApiService()
    private lateinit var retrofit: Retrofit


    fun get() = apiService

    private fun createApiService(): KurlyviewApiService {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        retrofit = Retrofit.Builder()
            .baseUrl(API_SERVER_URL)
            .client(createOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(KurlyviewApiService::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { printBodyLog(it) }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

        return builder.build()
    }

    private fun printBodyLog(message: String?) {
        if (message.isNullOrBlank()) {
            Timber.i(message)
        } else {
            try {
                val source: Buffer = Buffer().writeUtf8(message)
                val adapter = Moshi.Builder().build().adapter(Any::class.java).indent("    ")
                val result = adapter.toJson(
                    JsonReader.of(source).readJsonValue()
                )
                Timber.i(
                    "HTTP BODY" +
                            "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯" +
                            "\n$result" +
                            "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"
                )
            } catch (e: Exception) {
                Timber.i(message)
            }
        }
    }
}