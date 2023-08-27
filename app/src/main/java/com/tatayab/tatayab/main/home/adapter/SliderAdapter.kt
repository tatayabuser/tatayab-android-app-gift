package com.tatayab.tatayab.main.home.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnTrendListener
import kotlinx.android.synthetic.main.list_item_block_slider.view.*

class SliderAdapter(private val listener: OnTrendListener) : PagerAdapter() {


    private var items: List<Banner>? = null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val context = container.context

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.list_item_block_slider, container, false)
        val imgSlider = view.img_slider

        println("TATAYAB:// SLIDER// " + items?.get(position)?.image)
//        Glide.with(context)
//            .load(items?.get(position)?.image)
//            .apply(getPlaceholder()).dontAnimate()
//            .into(imgSlider)
        try {
            Picasso.get()
                .load(items?.get(position)?.image)
                .placeholder(R.drawable.default_image2).into(imgSlider)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        if (App.getPref().currentLanguage.toString().equals("ar", true)) {
            imgSlider.setRotationY(180F)
        }

        view.setSafeOnClickListener {
            if (items?.get(position)?.url.isNullOrBlank().not()) {
                listener.onTrendSelected(items?.get(position)?.url, items?.get(position)?.banner)
            }
        }
        container.addView(view)
        return view
    }

    fun setData(items: List<Banner>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items?.size ?: 0

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}