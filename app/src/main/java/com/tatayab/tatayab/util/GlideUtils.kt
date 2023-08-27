package com.tatayab.tatayab.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder

object GlideUtils {

    @JvmStatic
    fun loadImage(context: Context, url: String, withProgress: Boolean, toImage: ImageView) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val requestOption = RequestOptions()
            .placeholder(circularProgressDrawable).centerCrop()

        try {
            Picasso.get()
                .load( url)
                .placeholder(R.drawable.default_image2).into(toImage)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
//        if (withProgress) {
//            Glide.with(context)
//                .load(url)
//                .apply(requestOption)
//                .into(toImage)
//        } else {
//            Glide.with(context)
//                .load(url)
//                .apply(getPlaceholder())
//                .into(toImage)
//        }
    }
}