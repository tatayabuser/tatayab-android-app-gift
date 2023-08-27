package com.tatayab.tatayab.main.home.viewholder

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnTrendListener
import com.tatayab.tatayab.util.TextUtil
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.block_one_offer.view.*


class OneOfferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val bannerImage = view.iv_banner
    private val title = view.tv_title
    private val description = view.tv_description


    fun bind(
        blockLayoutResponse: List<Banner>?,
        name: String,
        subTitle: String? = "",
        listener: OnTrendListener
    ) {
        val context = itemView.context
        val params = bannerImage.layoutParams
        try {
            params?.height =
                ((ViewUtil.getScreenWidth())) - (32 * context.resources.displayMetrics.density).toInt()
            //params?.width = ((ViewUtil.getScreenWidth()))
            bannerImage.layoutParams = params

            bannerImage.setImageResource(R.drawable.default_image2)
            val allDescriptions = TextUtil.splitTitle(name)
            title.text = allDescriptions?.get(0)
           if(subTitle.isNullOrBlank()) {
               description.text = if (allDescriptions?.size!! > 1) allDescriptions?.get(1) else ""
           }else{
               description.text = subTitle
           }
//            Glide.with(context)
//                .load(blockLayoutResponse?.get(0)?.image)
//                .apply(getPlaceholder())
//                .into(bannerImage)
            try {
                Picasso.get()
                    .load(blockLayoutResponse?.get(0)?.image)
                    .placeholder(R.drawable.default_image2).into(bannerImage)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        itemView.setSafeOnClickListener {
            listener.onTrendSelected(blockLayoutResponse?.get(0)?.url, title.text.toString())
        }
    }
}