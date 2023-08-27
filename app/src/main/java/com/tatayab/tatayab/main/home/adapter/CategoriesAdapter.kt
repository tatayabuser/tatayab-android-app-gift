package com.tatayab.tatayab.main.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

import com.tatayab.model.Category
import com.tatayab.model.responses.CategoryItem
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListenerInHome
import kotlinx.android.synthetic.main.list_item_block_category.view.*
import kotlinx.android.synthetic.main.list_item_side_category.view.tv_category_name


class CategoriesAdapter(
    private val listener: OnCategoryListenerInHome
) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var items: ArrayList<CategoryItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_block_category))
    }

    fun setData(itemsList: ArrayList<CategoryItem>?) {
        this.items = itemsList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        items?.get(position)?.let {
            holder.bind(it, listener)
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: CategoryItem

        fun bind(
            category: CategoryItem,
            listener: OnCategoryListenerInHome
        ) {
            this.category = category
            val context = itemView.context

            itemView.tv_category_name.text = category.name
            //itemView.tv_category_name.visibility=View.GONE
//            try {
//                Glide.with(context)
//                    .load(category.image)
//                    .into(itemView.iv_category_img)
//            } catch (e: Exception) {
//            }

            try {
                Picasso.get()
                    .load(category.image)
                    .placeholder(R.drawable.default_image2).into(itemView.iv_category_img)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            itemView.setSafeOnClickListener {
                var catID = category?.category_uid
                if (catID.isNullOrBlank()) {
                    catID = category?.category_id
                }
                listener.onCategorySelected(
                    catID!!,
                    category.name
                )
            }

        }


    }
}