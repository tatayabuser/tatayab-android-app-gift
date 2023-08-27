package com.tatayab.tatayab.main.categories.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.Child
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnBannerSeeMoreListener
import com.tatayab.tatayab.listener.OnCategoryListener
import kotlinx.android.synthetic.main.item_banner_general.view.*
import kotlinx.android.synthetic.main.list_item_category.view.*
import kotlinx.android.synthetic.main.list_item_subcategory2.view.*


class BannerSeeMoreAdapter(
    private val listener: OnBannerSeeMoreListener
) :
    RecyclerView.Adapter<BannerSeeMoreAdapter.ViewHolder>() {

    private var items = ArrayList<Child>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_banner_general))
    }

    fun setData(items: List<Child>) {
        this.items = items as ArrayList<Child>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let {
            val subCategoryHolder: ViewHolder = holder as ViewHolder
            subCategoryHolder.bind(it, listener, position)

        }
    }


    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var child: Child

        fun bind(
            child: Child,
            listener: OnBannerSeeMoreListener,
            position: Int
        ) {

            this.child = child
            val context = itemView.context
            child?.let {
//                Glide.with(context)
//                    .load(it.image_path)
//                    .apply(getPlaceholder())
//                    .into(itemView.bannerimage)
                try {
                    Picasso.get()
                        .load(it.image_path)
                        .placeholder(R.drawable.default_image2).into(itemView.bannerimage)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            itemView.setSafeOnClickListener {
                listener.onBannerSelected(child.category_id, child.url.toString())
            }
        }
    }


    enum class ViewHolderType(value: Int) {
        TOP_SELLER(2), BEST_SELLER(1), EDITOR_CHOICE_BANNER(3)
    }
}