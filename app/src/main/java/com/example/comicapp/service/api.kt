package com.example.comicapp.service

import com.example.comicapp.model.manga
import com.example.comicapp.model.responseAuthor
import com.example.comicapp.model.responseManga
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface api {

    @GET("manga?order[rating]=desc&includes[]=author&includes[]=cover_art")
    fun getTopRatingManga(): Call<responseManga>

    @GET("manga?order[followedCount]=desc&includes[]=author&includes[]=cover_art&limit=5")
    fun getMostFollowedManga():Call<responseManga>

    @GET("author")
    fun getTopAuthor():Call<responseAuthor>

}