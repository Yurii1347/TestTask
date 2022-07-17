package com.yurii.vytivskyi.testtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yurii.vytivskyi.testtask.data.Data
import com.yurii.vytivskyi.testtask.model.repository.GifRepository
import com.yurii.vytivskyi.testtask.model.repository.GifRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ViewModel {
    private val mGifRepository: GifRepository = GifRepositoryImpl()

    private val _gifs = MutableLiveData<List<Data?>>()
    val gifs: LiveData<List<Data?>> = _gifs

    private val _gifsDetail = MutableLiveData<String>()
    val gifsDetail: LiveData<String> = _gifsDetail

    suspend fun getGif() {
        val result = mGifRepository.getGif()
        withContext(Dispatchers.IO) {
            _gifs.postValue(result.body()?.data)
        }
    }

    fun getGifDetail(id: String?) {
        _gifsDetail.postValue(
            "https://media2.giphy.com/media/$id" +
                    "/giphy.gif?cid=6bccd99dfaxh2iw1nobzphvcwir413zb35d4vaefx83d5yzr&rid=giphy.gif&ct=g"
        )
    }

}