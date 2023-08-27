package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnTrendListener
import com.tatayab.tatayab.main.home.adapter.SliderAdapter
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.block_slider.view.*
import java.util.*


class SliderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val viewPager = view.vp_slider
    private val indicatorLayout = view.tab_layout
    private lateinit var sliderAdapter: SliderAdapter
    fun bind(
        compositeBock: CompositeBlockItem?,
        listener: OnTrendListener
    ) {
        val bannersList = compositeBock?.blockLayoutResponse
        val context = itemView.context
        sliderAdapter = SliderAdapter(listener)
        if (!bannersList.isNullOrEmpty()) {
            viewPager.setBackgroundColor(context.resources.getColor(R.color.white))
            sliderAdapter.setData(bannersList)
        }
        viewPager.pageMargin = 100
        viewPager.adapter = sliderAdapter
        val params = viewPager.layoutParams
        params?.height = (((ViewUtil.getScreenWidth())) * 0.62).toInt()
        viewPager.layoutParams = params

        if (!bannersList.isNullOrEmpty())
         viewPager.currentItem =
            if (compositeBock.lastPosition < bannersList.size) compositeBock.lastPosition else 0

        viewPager.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(currntPagePosition: Int) {
                compositeBock?.lastPosition = currntPagePosition
             }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
            }

            override fun onPageScrollStateChanged(num: Int) {
            }
        })
        indicatorLayout.setupWithViewPager(viewPager)
        if(App.getPref().currentLanguage.toString().equals("ar",true)){
            viewPager.rotationY = 180F
        }
    }

}