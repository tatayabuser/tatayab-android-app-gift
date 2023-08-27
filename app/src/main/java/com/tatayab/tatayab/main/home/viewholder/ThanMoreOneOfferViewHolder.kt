package com.tatayab.tatayab.main.home.viewholder

import android.content.Context
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnTrendListener
import com.tatayab.tatayab.main.home.adapter.SupplierGridViwAdapter
import com.tatayab.tatayab.util.TextUtil
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.item_block_more_offer.view.*
import kotlinx.android.synthetic.main.item_block_offer_gridview.view.*


class ThanMoreOneOfferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val bannerImage = view.iv_banner
    private val title = view.tv_title
    private val description = view.tv_description
    private val bannerGridView = view.offerGridView
    private val singleOfferView = view.singleOfferView
    private val sectionTitle = view.tv_section_title


    fun bind(
        blockLayoutResponse: List<Banner>?,
        name: String,
        listener: OnTrendListener
    ) {
        if (blockLayoutResponse.isNullOrEmpty()) return
        val context = itemView.context
        var bannerList = ArrayList<Banner>()
        bannerList.addAll(blockLayoutResponse)
        try {
            sectionTitle.text = name
            if (isEvenNUmber(blockLayoutResponse?.size)) {
                singleOfferView.visibility = View.GONE
                initGridView(bannerList, context, listener)
            } else {
                singleOfferView.visibility = View.VISIBLE
                bannerImage.setImageResource(R.drawable.default_image2)
                title.text = bannerList?.get(0)!!.title
//                Glide.with(context)
//                    .load(blockLayoutResponse?.get(0)?.image)
//                    .apply(getPlaceholder())
//                    .into(bannerImage)
                try {
                    Picasso.get()
                        .load(blockLayoutResponse?.get(0)?.image)
                        .placeholder(R.drawable.default_image2).into(bannerImage)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

                bannerList.removeAt(0)
                initGridView(bannerList, context, listener)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        singleOfferView.setSafeOnClickListener {
            listener.onTrendSelected(
                blockLayoutResponse?.get(0)?.url,
                blockLayoutResponse?.get(0)?.title
            )
        }
    }

    private fun initGridView(
        bannerList: java.util.ArrayList<Banner>,
        context: Context,
        listener: OnTrendListener
    ) {
        val mSupplierGridViwAdapter = SupplierGridViwAdapter(context)
        bannerGridView.adapter = mSupplierGridViwAdapter
        mSupplierGridViwAdapter.setData(bannerList)
        bannerGridView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            if (bannerList?.get(position)?.url.isNullOrBlank().not()) {
                listener?.onTrendSelected(
                    bannerList?.get(position)?.url,
                    bannerList?.get(position)?.title?.toString()
                )
            }
        })
    }

    private fun isEvenNUmber(size: Int?): Boolean {
        return (size!! % 2) == 0
    }
}