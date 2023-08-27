package com.tatayab.tatayab.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.model.MainPair
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnTrendListener
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.list_item_trend.view.*

class TrendsAdapter(
    private val listener: OnTrendListener,
    minHeight: Float
) : RecyclerView.Adapter<TrendsAdapter.ViewHolder>() {
    private var items: List<Banner>? = null
    val viewTypeWithNormal:Int = 1
    val viewTypeWithUnNormal:Int = 2
    val viewItemHeight:Int = minHeight.toInt()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == viewTypeWithNormal) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.first_list_item_trend, parent, false)
            val params = view.layoutParams
            params.width = (ViewUtil.getScreenWidth() / 2) - (view.marginStart*2)
            params.height = viewItemHeight*2 + view.marginTop
            view.layoutParams = params
            return ViewHolder(view)
        }
        else
        {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item_trend, parent, false)
            val params = view.layoutParams
            params.width = (ViewUtil.getScreenWidth() / 4) - (view.marginStart*2)
            params.height = viewItemHeight
            view.layoutParams = params

            return ViewHolder(view)
        }
    }

    fun setData(items: List<Banner>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position%5==0)
            return  viewTypeWithNormal
        else
            return  viewTypeWithUnNormal
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           // holder.mView.trend_item_container.minHeight= holder.itemView.height*2
        items?.get(position)?.let { holder.bind(it, listener) }
    }

    override fun getItemCount():Int= items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var banner: Banner
        var  mView=itemView
        fun bind(
            banner: Banner,
            listener: OnTrendListener
        ) {

            this.banner = banner
            val context = itemView.context

            try {
//                Glide.with(context)
//                    .load(items?.get(position)?.image)
//                    .apply(getPlaceholder())
//                    .into(itemView.iv_trend_img)

                try {
                    Picasso.get()
                        .load(items?.get(position)?.image)
                        .placeholder(R.drawable.default_image2).into(itemView.iv_trend_img)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            } catch (e: Exception) {
            }

            itemView.setSafeOnClickListener {
                   listener.onTrendSelected(banner.url.toString(),banner?.banner)
            }

        }

    }
}