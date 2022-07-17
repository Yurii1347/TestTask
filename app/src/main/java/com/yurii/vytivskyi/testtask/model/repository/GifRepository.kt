package com.yurii.vytivskyi.testtask.model.repository

import com.yurii.vytivskyi.testtask.data.GIF2
import retrofit2.Response

interface GifRepository {

    suspend fun getGif(): Response<GIF2>

}