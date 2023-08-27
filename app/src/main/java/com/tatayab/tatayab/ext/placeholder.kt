package com.tatayab.tatayab.ext

import android.annotation.SuppressLint
import com.bumptech.glide.request.RequestOptions
import com.tatayab.tatayab.R


@SuppressLint("CheckResult")
fun getPlaceholder () : RequestOptions{
    val requestOptions = RequestOptions()
    requestOptions.placeholder(R.drawable.default_image2)
    requestOptions.error(R.drawable.default_image2)
    return requestOptions
}

@SuppressLint("CheckResult")
fun setPlaceholderWithSmallIcon () : RequestOptions{
    val requestOptions = RequestOptions()
    requestOptions.placeholder(R.drawable.default_image)
    requestOptions.error(R.drawable.default_image)
    return requestOptions
}