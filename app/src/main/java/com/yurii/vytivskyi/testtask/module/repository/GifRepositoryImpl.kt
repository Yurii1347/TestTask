package com.yurii.vytivskyi.testtask.module.repository

import com.yurii.vytivskyi.testtask.Constants
import com.yurii.vytivskyi.testtask.data.db.GIF2
import com.yurii.vytivskyi.testtask.module.APIs.APInterface
import com.yurii.vytivskyi.testtask.module.repository.GifRepository
import retrofit2.Response

class GifRepositoryImpl(private val apiInterface: APInterface) : GifRepository {

    override suspend fun getGif(): Response<GIF2> {

        return apiInterface.getGif(Constants.api_key)

    }
}