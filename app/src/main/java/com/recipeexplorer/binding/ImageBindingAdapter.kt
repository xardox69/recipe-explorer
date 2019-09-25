package com.recipeexplorer.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}