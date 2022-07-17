package com.yurii.vytivskyi.testtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.yurii.vytivskyi.testtask.databinding.ActivityGifBinding
import com.yurii.vytivskyi.testtask.viewmodel.ViewModel

class GifActivity : AppCompatActivity() {

    lateinit var binding: ActivityGifBinding

    private val mViewModel: ViewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGifBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        mViewModel.getGifDetail(id)
        initObserver()

    }

    private fun initObserver() {
        mViewModel.gifsDetail.observe(this@GifActivity) {
            Glide.with(this).load(it).into(binding.imageView2)
            Log.d("lol", it)
        }
    }
}