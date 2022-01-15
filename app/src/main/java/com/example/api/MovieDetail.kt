package com.example.api

data class MovieDetail(
    val url:String,
    val name:String,
    val language:String,
    val image:Image?,
    val summary:String
)