package com.yurii.vytivskyi.testtask.model.repository

import com.yurii.vytivskyi.testtask.Constants
import com.yurii.vytivskyi.testtask.data.GIF2
import com.yurii.vytivskyi.testtask.model.APIs.APIinterface
import retrofit2.Response

class GifRepositoryImpl : GifRepository {

    private val apiInterface = APIinterface.create()

    override suspend fun getGif(): Response<GIF2> {

        return apiInterface.getGif(Constants.api_key)

    }
}