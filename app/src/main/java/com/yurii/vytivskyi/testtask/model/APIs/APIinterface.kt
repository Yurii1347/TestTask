package com.yurii.vytivskyi.testtask.model.APIs

import com.yurii.vytivskyi.testtask.data.GIF2
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface {

    @GET("v1/gifs/trending")
    suspend fun getGif(@Query("api_key") sort: String): Response<GIF2>

    companion object {

        private const val BASE_URL = "https://api.giphy.com/"

        fun create(): APIinterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIinterface::class.java)
        }

    }

}