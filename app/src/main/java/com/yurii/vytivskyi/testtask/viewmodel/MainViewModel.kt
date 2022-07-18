package com.yurii.vytivskyi.testtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yurii.vytivskyi.testtask.data.db.Data
import com.yurii.vytivskyi.testtask.module.repository.GifRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(
    private val mGifRepository: GifRepository)
    : ViewModel() {

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