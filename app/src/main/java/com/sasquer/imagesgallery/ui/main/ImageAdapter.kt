package com.sasquer.imagesgallery.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.databinding.ListItemImageBinding

class ImageAdapter : ListAdapter<ImageInfo, ImageAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemImageBinding = DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.list_item_image, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ListItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageInfo) {
            binding.item = item
        }
    }

    companion object {
        @JvmStatic
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<ImageInfo>() {
            override fun areContentsTheSame(oldItem: ImageInfo, newItem: ImageInfo): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: ImageInfo, newItem: ImageInfo): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}