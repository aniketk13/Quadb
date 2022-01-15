package com.example.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface quadbAPI {
    @GET("search/shows")
    suspend fun getMovies(@Query("q") query:String="all"):List<Movies>

    @GET
    suspend fun getSelectedMovie(@Url url: String):MovieDetail


}