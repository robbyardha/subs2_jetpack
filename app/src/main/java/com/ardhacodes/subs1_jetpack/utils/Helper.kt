package com.ardhacodes.subs1_jetpack.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {
    const val EXTRA_MOVIE = "MOVIE"
    const val EXTRA_TV_SHOW = "TV_SHOW"

    fun setImageGlide(context: Context, imagePath: String, imageView: ImageView){
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}