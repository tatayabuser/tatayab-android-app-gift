package com.tatayab.tatayab.ext

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View

val Context.networkInfo: NetworkInfo? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo