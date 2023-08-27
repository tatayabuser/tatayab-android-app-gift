package com.tatayab.tatayab.main.categories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.ContentModel
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import kotlinx.android.synthetic.main.item_banner_general.view.*
import kotlinx.android.synthetic.main.list_item_block_slider.view.*

class CategorySliderAdapter(
    private val listener: OnCategoryListener
) : PagerAdapter() {


    private var items: List<ContentModel>? = null
    private var catId: String = ""

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val context = container.context

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.banner_slider, container, false)
        val imgSlider = view.img_slider

//        Glide.with(context)
//            .load(items?.get(position)?.image)
//            .apply(getPlaceholder())
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
            listener.onBannerSelected(catId, items?.get(position)?.url.toString())
        }
        container.addView(view)
        return view
    }

    fun setData(items: List<ContentModel>, catId: String) {
        this.items = items
        this.catId = catId
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items?.size ?: 0

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}