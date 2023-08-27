package com.tatayab.tatayab.main.home.viewholder

import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.R

import com.tatayab.tatayab.ext.getPlaceholder

import kotlinx.android.synthetic.main.block_free_delivery.view.*
import kotlinx.android.synthetic.main.list_item_trend.view.*


class FreeDeliveryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val tvFreeDelivery = view.tv_free_delivery
    private val image = view.iv_original
    fun bind(
        blockLayoutResponse: List<Banner>?,
        sectionName: String
    ) {
        val context = itemView.context
        tvFreeDelivery.text = sectionName
        changeFontColor(view)

        if (!blockLayoutResponse?.get(0)?.image.isNullOrEmpty()) {
            try {
//                Glide.with(context)
//                    .load(blockLayoutResponse?.get(0)?.image)
//                    .apply(getPlaceholder())
//                    .into(image)

                try {
                    Picasso.get()
                        .load(blockLayoutResponse?.get(0)?.image)
                        .placeholder(R.drawable.default_image2).into(image)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
                image.visibility = View.VISIBLE
            } catch (e: Exception) {
            }
        }

    }

    private fun changeFontColor(view: View) {

        var myColor:Int=0

        val timer = object: CountDownTimer(20000, 350) {
            override fun onTick(millisUntilFinished: Long) {
                if(myColor == 0) {
                    myColor =1
                    tvFreeDelivery.setTextColor(ContextCompat.getColor(this@FreeDeliveryViewHolder.view.context,R.color.white))
                }else{
                    myColor = 0
                    tvFreeDelivery.setTextColor(ContextCompat.getColor(this@FreeDeliveryViewHolder.view.context,R.color.free_delivery))
                }
                Log.d("TAG", "onTick: ${myColor}")
            }

            override fun onFinish() {
                start()
            }
        }
        timer.start()
    }
}