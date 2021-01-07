package com.sasquer.imagesgallery.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sasquer.imagesgallery.R
import com.squareup.picasso.Picasso

@BindingAdapter("visibility")
fun View.bindVisibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("bindImage")
fun ImageView.bindImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_placeholder_image)
        .error(R.drawable.ic_error_image)
        .into(this)
}