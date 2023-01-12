package com.most4dev.countriesapp.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadIcon")
fun bindLoadIcon(imageView: ImageView, url: String){
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}