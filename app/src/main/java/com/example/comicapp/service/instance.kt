package com.example.comicapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object instance{

    val BASE_URL = "https://api.mangadex.org"

    val instance: api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)
    }

}