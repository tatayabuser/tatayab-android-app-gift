package com.tatayab.tatayab.productdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import kotlinx.android.synthetic.main.list_item_block_slider.view.*

class ImagesAdapter : PagerAdapter() {


    private var items: List<String>? = null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val context = container.context

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.product_images_item, container, false)
        val imgSlider = view.img_slider

//        Glide.with(context)
//            .load(items?.get(position))
//             .into(imgSlider)

        try {
            Picasso.get()
                .load( items?.get(position))
                .placeholder(R.drawable.default_image2).into(imgSlider)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        if (App.getPref().currentLanguage.toString().equals("ar", true)) {
            imgSlider.rotationY = 180F
        }


        container.addView(view)
        return view
    }

    fun setData(items: List<String>?) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items?.size ?: 0


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}