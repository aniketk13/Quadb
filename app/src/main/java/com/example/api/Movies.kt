package com.example.api


data class Movies(
    val score:Float,
    val show: Details
)

data class Details(
    val id:Int,
    val url:String,
    val name:String,
    val image: Image?,
    val summary:String
)

data class Image(
    val medium:String
)