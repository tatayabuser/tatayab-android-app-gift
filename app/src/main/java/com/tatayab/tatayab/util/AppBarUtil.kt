package com.tatayab.tatayab.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.tatayab.tatayab.ext.changeImageWithAnimationIn
import com.tatayab.tatayab.ext.changeImageWithAnimationOut

class HomeAppBarOffsetListener(val img: ImageView, val imgResourceSmall: Int, val collapsingToolbarLayout: CollapsingToolbarLayout, val imgResourceLarge: Int,
                               val context: Context
): AppBarLayout.OnOffsetChangedListener{
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if(collapsingToolbarLayout.height + verticalOffset < collapsingToolbarLayout.scrimVisibleHeightTrigger){
            img.changeImageWithAnimationIn(context, imgResourceSmall)
        }else {
            img.changeImageWithAnimationOut(context, imgResourceLarge)
        }

    }


}