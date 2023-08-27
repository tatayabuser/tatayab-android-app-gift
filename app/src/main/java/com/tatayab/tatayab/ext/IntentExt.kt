package com.tatayab.tatayab.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

internal inline fun <reified A : AppCompatActivity> intentOf(context: Context): Intent {
    return Intent(context, A::class.java)
}

internal inline fun <reified A : AppCompatActivity> intentOfWithBundle(context: Context, bundle: Bundle): Intent {
    return Intent(context, A::class.java).putExtras(bundle)
}


