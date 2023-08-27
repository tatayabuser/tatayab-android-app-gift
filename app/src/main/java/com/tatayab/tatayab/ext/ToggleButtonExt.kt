package com.tatayab.tatayab.ext

import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.appcompat.widget.AppCompatToggleButton

 fun AppCompatToggleButton.makeAnimation() {

     val  scaleAnimation = ScaleAnimation(
         0.7f,
         1.0f,
         0.7f,
         1.0f,
         Animation.ZORDER_NORMAL,
         0.7f,
         Animation.ZORDER_NORMAL,
         0.7f
     )
     scaleAnimation.setDuration(500)
     val bounceInterpolator = BounceInterpolator()
     scaleAnimation.setInterpolator(bounceInterpolator)
    this.startAnimation(scaleAnimation)
 }
