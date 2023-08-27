package com.tatayab.tatayab.main.categories.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.BannerType
import com.tatayab.model.responses.CategoryModel

import com.tatayab.model.responses.Child
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import kotlinx.android.synthetic.main.item_editor_choice.view.*
import kotlinx.android.synthetic.main.list_item_subcategory2.view.*
import kotlinx.android.synthetic.main.list_item_subcategory2.view.iv_subcategory_image
import java.lang.Exception


class CategoryAdapter(
    private val listener: OnCategoryListener
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var items: List<CategoryModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_sub_category))
    }

    fun setData(
        items: List<CategoryModel>
    ) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            if (!items.isNullOrEmpty() && items?.size!! > position)
                items?.get(position)?.let { holder.bind(it, listener, position) }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return if(items.isNullOrEmpty()) 0  else  items?.size!!
     }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: CategoryModel

        fun bind(
            mCategoryModel: CategoryModel,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = mCategoryModel
            val context = itemView.context
            itemView?.tv_subcategory_name.text = category.name

            try {
                Picasso.get()
                    .load(category.image_path)
                    .placeholder(R.drawable.default_image2).into(itemView.iv_subcategory_image)

                itemView.setOnClickListener {
                    listener.onSubCategorySelected(
                        category.category_uid,
                        category.name
                    )
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }



        }
    }
}