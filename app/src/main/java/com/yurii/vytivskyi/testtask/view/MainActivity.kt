package com.yurii.vytivskyi.testtask.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yurii.vytivskyi.testtask.databinding.ActivityMainBinding
import com.yurii.vytivskyi.testtask.view.adaptors.SimpleAdaptor
import com.yurii.vytivskyi.testtask.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SimpleAdaptor.ItemClickListener {
    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var mSimpleAdaptor: SimpleAdaptor
    private lateinit var mRecycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycleView()
        initObserver()

        lifecycleScope.launch {
            viewModel.getGif()
        }
    }

    private fun initObserver() {
        viewModel.apply {
            gifs.observe(this@MainActivity) {
                mSimpleAdaptor = SimpleAdaptor(it, this@MainActivity, this@MainActivity)
                mRecycleView.adapter = mSimpleAdaptor
            }
        }
    }

    private fun initRecycleView() {
        mRecycleView = binding.recycleView
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecycleView.layoutManager = GridLayoutManager(this, 1)
        } else
        {
            mRecycleView.layoutManager = GridLayoutManager(this, 3)
        }
    }

    override fun onClick(id: String) {
        val i = Intent(this@MainActivity, GifActivity::class.java)
        i.putExtra("id", id)
        startActivity(i)
    }

}