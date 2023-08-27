package com.tatayab.tatayab.main.categories.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.tatayab.model.responses.Child
import com.tatayab.model.responses.ShopContentModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import kotlinx.android.synthetic.main.item_shop_brand.view.*
import kotlinx.android.synthetic.main.list_item_subcategory2.view.*


class ShopByBrandAdapter(
    private val listener: OnCategoryListener) :
    RecyclerView.Adapter<ShopByBrandAdapter.ViewHolder>() {

    private var items: List<ShopContentModel>? = null
    private var catId:String = ""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_shop_brand))
    }
    fun setData(
        items: List<ShopContentModel>,
        catId:String
    ) {
        this.items = items
        this.catId = catId
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { holder.bind(it, listener, position) }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: ShopContentModel

        fun bind(
            mShopContentModel: ShopContentModel,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = mShopContentModel
            val context = itemView.context
            itemView.bannerTitle.text = mShopContentModel.title

            itemView.setSafeOnClickListener {
                var url = "/suppliers/"+category.id+"/"+category.title
                listener.onBannerSelected(catId,url)
            }

        }
    }
}