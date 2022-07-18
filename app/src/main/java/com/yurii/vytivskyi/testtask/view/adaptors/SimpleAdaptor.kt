package com.yurii.vytivskyi.testtask.view.adaptors

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yurii.vytivskyi.testtask.R
import com.yurii.vytivskyi.testtask.data.db.Data
import com.yurii.vytivskyi.testtask.databinding.RecyclerViewItemBinding
import com.yurii.vytivskyi.testtask.view.MainActivity

class SimpleAdaptor(
    private val mainL: List<Data?>, private val activity: MainActivity,
    val mItemClickListener: ItemClickListener
) : RecyclerView.Adapter<SimpleAdaptor.ViewHolder>() {

    interface ItemClickListener {
        fun onClick(id: String) {
        }
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = RecyclerViewItemBinding.bind(item)
        fun bind(data: Data?) = with(binding) {
            Glide.with(activity).load(data?.images?.original?.url).into(imageView)
        }

        init {
            item.setOnClickListener {
                mainL[absoluteAdapterPosition]?.id?.let { it -> mItemClickListener.onClick(it) }
                Log.d("myLog", "${mainL[absoluteAdapterPosition]?.id}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mainL[position])
    }

    override fun getItemCount(): Int {
        return mainL.size
    }
}