package com.most4dev.countriesapp.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadIcon")
fun bindLoadIcon(imageView: ImageView, url: String?){
    url?.let {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

}