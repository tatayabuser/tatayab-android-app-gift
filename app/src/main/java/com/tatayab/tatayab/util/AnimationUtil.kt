package com.tatayab.tatayab.util

import android.animation.*
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.fragment_product_list.*
import java.time.Duration

object AnimationUtil {

    @JvmStatic
    fun cartIconAnimatorSet(itemCount: View): AnimatorSet {
        val iconScaleAnimatorX = ObjectAnimator.ofFloat(itemCount, View.SCALE_X, 1f, 1.5f)
        iconScaleAnimatorX.duration = 200L
        iconScaleAnimatorX.repeatCount = 1
        iconScaleAnimatorX.repeatMode = ValueAnimator.REVERSE
        val iconScaleAnimatorY = ObjectAnimator.ofFloat(itemCount, View.SCALE_Y, 1f, 1.5f)
        iconScaleAnimatorY.duration = 200L
        iconScaleAnimatorY.repeatCount = 1
        iconScaleAnimatorY.repeatMode = ValueAnimator.REVERSE

        val iconAnimatorSet = AnimatorSet()
        iconAnimatorSet.play(iconScaleAnimatorX).with(iconScaleAnimatorY)
        return iconAnimatorSet
    }


    @JvmStatic
    private fun objectAnimatorOfFloat(
        view: View,
        duration: Long,
        propertyName: String,
        startValue: Float,
        endValue: Float
    ): ObjectAnimator? {
        val animator = ObjectAnimator.ofFloat(view, propertyName, startValue, endValue)
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = duration
        return animator
    }

    @JvmStatic
    fun getPositionOf(view: View?): IntArray {
        val position = intArrayOf(0, 0)
        view?.getLocationOnScreen(position)
        return position
    }

    @JvmStatic
    private fun setupViewToAnimate(
        imageView: ImageView,
        imageSize: Int,
        context: Context
    ): ImageView {
        val viewToAnimate = ImageView(context)
        viewToAnimate.setImageDrawable(imageView.drawable)
        //viewToAnimate.setImageResource(resources.getIdentifier(item.thumbnail, null, packageName))
        val layoutParams = imageView.layoutParams
        layoutParams.height = imageSize
        layoutParams.width = imageSize
        viewToAnimate.layoutParams = layoutParams
        viewToAnimate.alpha = 0f
        return viewToAnimate
    }

    @JvmStatic
    fun rotate(context: Context, imageView: ImageView, rotateAnimationFile: Int) {
        val rotate = AnimationUtils.loadAnimation(context, rotateAnimationFile)
        imageView.startAnimation(rotate);
    }


    fun springAnimateAddToCart(dialog: View, delay: Float = 7000f) {
        val anim: SpringAnimation = SpringAnimation(dialog, DynamicAnimation.TRANSLATION_Y, 0f)
            .setStartVelocity(delay)
        anim.spring.stiffness = SpringForce.STIFFNESS_LOW
        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY
        anim.start()
    }

    fun showErrorDialogAnimation(dialog: View) {
        val anim: SpringAnimation = SpringAnimation(dialog, DynamicAnimation.TRANSLATION_Y, 0f)
            .setStartVelocity(10000f)
        anim.spring.stiffness = SpringForce.STIFFNESS_LOW
        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY
        anim.start()
    }


    @JvmStatic
    fun animateAddToCart(
        productImage: ImageView,
        resources: Resources,
        itemCount: View,
        itemsRootView: ConstraintLayout,
        context: Context,
        duration: Long,
        update: () -> Unit
    ) {
        val productImagePosition = getPositionOf(productImage)
        val itemCountCirclePosition = getPositionOf(itemCount)

        val productImageSize = resources.getDimension(R.dimen._50sdp).toInt()

        val viewToAnimate = setupViewToAnimate(productImage, productImageSize, context)
        itemsRootView.addView(viewToAnimate)
        val xAnimator = objectAnimatorOfFloat(
            viewToAnimate,
            duration,
            "x",
            productImagePosition[0].toFloat(),
            itemCountCirclePosition[0].toFloat() - productImageSize / 2
        )
        val yAnimator = objectAnimatorOfFloat(
            viewToAnimate,
            duration,
            "y",
            productImagePosition[1].toFloat() - productImageSize,
            itemCountCirclePosition[1].toFloat() - productImageSize
        )

        val alphaAnimator = objectAnimatorOfFloat(viewToAnimate, duration, "alpha", 0f, 1f)


        AnimatorSet().apply {
            play(xAnimator).with(yAnimator).with(alphaAnimator)

            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    //cartIconAnimatorSet.start()
                    //itemCount?.setBounds(0,0,5,5)
                    //presenter.addItem(item)
                    update.invoke()
                    itemsRootView.removeView(viewToAnimate)
                }
            })

            start()
        }
    }
}

class TatayabAnimationListener(val img: ImageView, val imgRes: Int) :
    Animation.AnimationListener {
    override fun onAnimationEnd(p0: Animation?) {
        if ((img.tag as? Int) != imgRes) {
            img.setImageResource(imgRes)
            img.tag = imgRes
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationStart(p0: Animation?) {

    }


}