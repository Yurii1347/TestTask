package com.yurii.vytivskyi.testtask.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yurii.vytivskyi.testtask.databinding.ActivityGifBinding
import com.yurii.vytivskyi.testtask.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GifActivity : AppCompatActivity() {

    lateinit var binding: ActivityGifBinding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGifBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        viewModel.getGifDetail(id)
        initObserver()

    }

    private fun initObserver() {
        viewModel.gifsDetail.observe(this@GifActivity) {
            Glide.with(this).load(it).into(binding.imageView2)
            Log.d("lol", it)
        }
    }
}