package com.yurii.vytivskyi.testtask.module.APIs

import com.yurii.vytivskyi.testtask.data.db.GIF2
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APInterface {

    @GET("v1/gifs/trending")
    suspend fun getGif(@Query("api_key") sort: String): Response<GIF2>

    companion object {

         const val BASE_URL = "https://api.giphy.com/"

    }

}