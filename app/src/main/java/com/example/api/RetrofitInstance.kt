package com.example.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.tvmaze.com/"

object RetrofitInstance {
    private val client= OkHttpClient.Builder().build()
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val api:quadbAPI by lazy {
        retrofit.create(quadbAPI::class.java)
    }
}