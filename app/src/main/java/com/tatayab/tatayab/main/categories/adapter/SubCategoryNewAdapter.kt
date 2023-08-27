package com.tatayab.tatayab.main.categories.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.BannerType
import com.tatayab.model.responses.SubCategoriesResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import kotlinx.android.synthetic.main.item_main_category.view.*
import kotlinx.android.synthetic.main.item_top_seller.view.*
 import kotlinx.android.synthetic.main.list_item_subcategory2.view.*


class SubCategoryNewAdapter(
    private val listener: OnCategoryListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = ArrayList<SubCategoriesResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ViewHolderType.HAS_CHILD.ordinal) {
            return ViewHolderWithChild(parent.inflate(R.layout.item_top_seller))
        } else
            return ViewHolderWithMainCat(parent.inflate(R.layout.item_main_category))
     }

    fun setData(items: List<SubCategoriesResponse>) {
        this.items = items as ArrayList<SubCategoriesResponse>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items?.get(position)?.let {
            if (holder.itemViewType == ViewHolderType.HAS_CHILD.ordinal) {
                val subCategoryHolder: ViewHolderWithChild = holder as ViewHolderWithChild
                subCategoryHolder.bind(it, listener, position)
            } else {
                val subCategoryHolder: ViewHolderWithMainCat = holder as ViewHolderWithMainCat
                subCategoryHolder.bind(it, listener, position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items.get(position).childs.isNullOrEmpty().not()) {
            return ViewHolderType.HAS_CHILD.ordinal
        } else {
            return ViewHolderType.WITH_OUT_CHILD.ordinal
        }
    }


    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolderWithChild(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: SubCategoriesResponse

        fun bind(
            category: SubCategoriesResponse,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = category
            val context = itemView.context
            try {
                itemView.tv_category_name.text = category?.name
                val mCategoryChildAdapter = CategoryChildAdapter(listener)
                if (category?.childs.isNullOrEmpty().not()) {
                    mCategoryChildAdapter.setData(category.childs!!)
                }
                itemView.subcategories.adapter = mCategoryChildAdapter
                itemView.tv_view_all.setSafeOnClickListener {
                    listener.onSubCategorySelected(
                        category.category_uid,
                        category.name
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    inner class ViewHolderWithMainCat(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: SubCategoriesResponse

        fun bind(
            category: SubCategoriesResponse,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = category
            val context = itemView.context
            try {
                 val mCategoryChildAdapter = CategoryAdapter(listener)
                if (category?.mainCategoriesList.isNullOrEmpty().not()) {
                    mCategoryChildAdapter.setData(category.mainCategoriesList!!)
                }
                itemView.categoriesRecyclerView.adapter = mCategoryChildAdapter

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    inner class ViewHolderWithOutChild(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: SubCategoriesResponse

        fun bind(
            category: SubCategoriesResponse,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = category
            val context = itemView.context
            try {
                itemView?.tv_subcategory_name.text = category?.name
                try {
                    Picasso.get()
                        .load(category.image_path)
                        .placeholder(R.drawable.default_image2).into(itemView.iv_subcategory_image)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

                itemView.setOnClickListener {
                    listener.onSubCategorySelected(
                        category.category_uid,
                        category.name
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getBannerType(categoryType: BannerType): Int {
        return if (categoryType.ordinal == ViewHolderType.HAS_CHILD.ordinal) {
            ViewHolderType.HAS_CHILD.ordinal
        } else {
            ViewHolderType.WITH_OUT_CHILD.ordinal
        }
    }


    enum class ViewHolderType(value: Int) {
        HAS_CHILD(1), WITH_OUT_CHILD(2)
    }
}