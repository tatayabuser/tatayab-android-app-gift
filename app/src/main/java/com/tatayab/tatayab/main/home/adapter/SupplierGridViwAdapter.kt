package com.tatayab.tatayab.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Banner
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import kotlinx.android.synthetic.main.fragment_concierge.*

class SupplierGridViwAdapter (   private val context: Context): BaseAdapter() {
    private var bannerList = ArrayList<Banner>()
    private var layoutInflater: LayoutInflater? = null
    private lateinit var bannerImage: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView

    fun setData(items: List<Banner>?) {
        this.bannerList = items as ArrayList<Banner>
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return bannerList?.size!!
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.item_block_more_offer_grid, null)
        }
        bannerImage= convertView?.findViewById(R.id.iv_banner)!!
        title= convertView?.findViewById(R.id.tv_title)!!
        description= convertView?.findViewById(R.id.tv_description)!!

        bannerImage.setImageResource(R.drawable.default_image2)
         title.text = bannerList?.get(position)!!.title

//        Glide.with(context)
//            .load(bannerList?.get(position)?.image)
//            .apply(getPlaceholder())
//            .into(bannerImage)

        try {
            Picasso.get()
                .load(bannerList?.get(position)?.image)
                .placeholder(R.drawable.default_image2).into(bannerImage)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return convertView
    }
}