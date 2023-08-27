package com.tatayab.tatayab.main.categories

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
import com.tatayab.tatayab.listener.OnCategoryListener
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.list_item_subcategory2.view.*


class SubCategoryAdapter(
    private val listener: OnCategoryListener,
    private val hasSubCat: Boolean,
    private val isBestSeller: Boolean
) :
    RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    private var items: List<Child>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (!hasSubCat) {
            if (isBestSeller)
                return ViewHolder(parent.inflate(R.layout.list_item_best_seller))
            else
                return ViewHolder(parent.inflate(R.layout.list_item_subcategory2))

        } else
            return ViewHolder(parent.inflate(R.layout.list_item_subcategory))

    }

    fun setData(
        items: List<Child>
    ) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!items.isNullOrEmpty() && items?.size!! > position) {
            items?.get(position)?.let {
                holder.bind(it, listener, position)
            }
        }
    }

    override fun getItemCount(): Int {
        if (items.isNullOrEmpty()) return 0
        else if (isBestSeller) return 3
        else return items?.size!!
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: Child

        fun bind(
            child: Child,
            listener: OnCategoryListener,
            position: Int
        ) {
            this.category = child
            val context = itemView.context
            itemView.tv_subcategory_name.text = child.name

//            Glide.with(context)
//                .load(child.image_path)
//                .apply(getPlaceholder())
//                .into(itemView.iv_subcategory_image)

            try {
                Picasso.get()
                    .load(child.image_path)
                    .placeholder(R.drawable.default_image2).into(itemView.iv_subcategory_image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            itemView.setSafeOnClickListener {
                if (isBestSeller) {
                    listener.onBannerSelected(child.category_id, child.url.toString())
                } else {
                    listener.onSubCategorySelected(child.category_id, child.name)
                }
            }

        }
    }
}