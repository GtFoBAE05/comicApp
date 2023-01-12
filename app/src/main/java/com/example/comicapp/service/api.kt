package com.example.comicapp.service

import com.example.comicapp.model.manga
import com.example.comicapp.model.response
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface api {

    @GET("manga?order[rating]=desc&includes[]=author&includes[]=artist&includes[]=cover_art")
    fun getTopManga(): Call<response>

}