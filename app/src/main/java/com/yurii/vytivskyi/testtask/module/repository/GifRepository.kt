package com.yurii.vytivskyi.testtask.module.repository

import com.yurii.vytivskyi.testtask.data.db.GIF2
import retrofit2.Response

interface GifRepository {

    suspend fun getGif(): Response<GIF2>

}

