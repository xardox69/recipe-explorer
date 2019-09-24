package com.recipeexplorer.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl


object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(view: ImageView, url: GlideUrl) {
        Glide.with(view.context).load(url).into(view)
    }
}