package com.yurii.vytivskyi.testtask

import com.yurii.vytivskyi.testtask.module.repository.GifRepositoryImpl
import com.yurii.vytivskyi.testtask.module.APIs.APInterface
import com.yurii.vytivskyi.testtask.module.repository.GifRepository
import com.yurii.vytivskyi.testtask.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(APInterface.BASE_URL)
            .build()
            .create(APInterface::class.java)
    }

    single<GifRepository> {
        GifRepositoryImpl(get())
    }

    viewModel() {
        MainViewModel(get())
    }

}