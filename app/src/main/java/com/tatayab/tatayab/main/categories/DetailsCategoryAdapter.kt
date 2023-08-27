package com.tatayab.tatayab.main.categories

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tatayab.model.responses.BannerType
import com.tatayab.model.responses.SubCategoriesResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import com.tatayab.tatayab.main.categories.DetailsCategoryAdapter.ViewHolderType.*
import com.tatayab.tatayab.main.categories.adapter.EditorChoiceAdapter
import com.tatayab.tatayab.main.categories.adapter.TopSellerAdapter
import kotlinx.android.synthetic.main.item_banner_choice.view.*
import kotlinx.android.synthetic.main.list_item_category.view.*
import kotlinx.android.synthetic.main.list_item_category.view.tv_view_all
import kotlinx.android.synthetic.main.list_item_side_category.view.tv_category_name
import java.lang.Exception


class DetailsCategoryAdapter(
    private val listener: OnCategoryListener
) :
    RecyclerView.Adapter<DetailsCategoryAdapter.ViewHolder>() {
     private var items = ArrayList<SubCategoriesResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == TOP_SELLER.ordinal) {
             return ViewHolder(parent.inflate(R.layout.item_top_seller))
        } else if (viewType == EDITOR_CHOICE_BANNER.ordinal) {
             return ViewHolder(parent.inflate(R.layout.item_edit_choice))
        } else
            return ViewHolder(parent.inflate(R.layout.list_item_category))
    }

    fun setData(items: List<SubCategoriesResponse>) {
        this.items = items as ArrayList<SubCategoriesResponse>
        notifyDataSetChanged()
    }

    fun addBannerItem(item: SubCategoriesResponse) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let {
            val subCategoryHolder: ViewHolder = holder as ViewHolder
            subCategoryHolder.bind(it, listener, position)

        }
    }

    override fun getItemViewType(position: Int): Int {
         if (items.get(position).categoryType == null)
            return ViewHolderType.SUB_CATEGORY.ordinal
        else if (items.get(position).categoryType?.ordinal == BannerType.top_selling_banners.ordinal) {
            return ViewHolderType.TOP_SELLER.ordinal
        } else if (items.get(position).categoryType?.ordinal == BannerType.slider_banners.ordinal) {
            return ViewHolderType.BEST_SELLER.ordinal
        } else if (items.get(position).categoryType?.ordinal == BannerType.editor_choice_banners.ordinal) {
            return ViewHolderType.EDITOR_CHOICE_BANNER.ordinal
        } else {
            return ViewHolderType.SUB_CATEGORY.ordinal
        }
    }


    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var category: SubCategoriesResponse

        fun bind(
            category: SubCategoriesResponse,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = category
            val context = itemView.context
            try {
                if ((category?.hasSubCat != null && category?.hasSubCat!!) || category?.childs.isNullOrEmpty()) {
                    itemView.tv_category_name.visibility = View.GONE
                    itemView.tv_view_all.visibility = View.GONE
                } else {
                    itemView.tv_category_name.visibility = View.GONE
                    itemView.tv_view_all.visibility = View.GONE
                    itemView.tv_category_name.text = category.name
                }
                if (category.categoryType == BannerType.top_selling_banners) {
                    val topSellerAdapter = TopSellerAdapter(listener)
                    if (category?.childs.isNullOrEmpty().not()) {
                        topSellerAdapter.setData(category.childs!!)
                    }
                    itemView.subcategories.adapter = topSellerAdapter
                    if (!category.childs.isNullOrEmpty() && category.childs!!.size > 2) {
                        itemView.tv_view_all.visibility = View.VISIBLE
                    } else {
                        itemView.tv_view_all.visibility = View.INVISIBLE
                    }
                } else if (category.categoryType == BannerType.editor_choice_banners) {
                    val mEditorChoiceAdapter = EditorChoiceAdapter(listener)
                    if (category.childs.isNullOrEmpty().not()) {  mEditorChoiceAdapter.setData(category.childs!!)}
                    itemView.subcategories.adapter = mEditorChoiceAdapter
                    if (!category.childs.isNullOrEmpty() && category.childs!!.size > 1) {
                        itemView.tv_view_all.visibility = View.VISIBLE
                    } else {
                        itemView.tv_view_all.visibility = View.INVISIBLE
                    }
                } else if (category.categoryType == BannerType.best_sellers_banners && category.childs.isNullOrEmpty().not()) {
                    val subCategoryAdapter = SubCategoryAdapter(
                        listener,
                        category.hasSubCat,
                        category.categoryType == BannerType.best_sellers_banners
                    )
                    subCategoryAdapter.setData(category.childs!!)
                    itemView.subcategories.adapter = subCategoryAdapter
                    if (!category.childs.isNullOrEmpty() && category.childs!!.size > 3) {
                        itemView.tv_view_all.visibility = View.VISIBLE
                    } else {
                        itemView.tv_view_all.visibility = View.INVISIBLE
                    }
                } else {
                    val subCategoryAdapter = SubCategoryAdapter(
                        listener,
                        category.hasSubCat,
                        category.categoryType == BannerType.best_sellers_banners
                    )
                    if (category?.childs.isNullOrEmpty().not()) {
                        subCategoryAdapter.setData(category.childs!!)
                    }
                    itemView.subcategories.adapter = subCategoryAdapter
                }

                itemView.tv_view_all.setSafeOnClickListener {
                    if (category.categoryType?.ordinal == SUB_CATEGORY.ordinal) {
                        listener.onSubCategorySelected(
                            category.category_uid,
                            category.name
                        )
                    } else {
                        if (category?.childs.isNullOrEmpty().not()) {
                            listener.onBannerSeeMoreSelected(
                                category.category_uid ?: "0",
                                category.childs!!,
                                category.name,
                                getBannerType(category.categoryType)
                            )
                        }
                    }
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    private fun getBannerType(categoryType: BannerType?): Int {
        if (categoryType == null) return 3
        if (categoryType.ordinal == BannerType.top_selling_banners.ordinal) {
            return 2
        } else if (categoryType.ordinal == BannerType.best_sellers_banners.ordinal) {
            return 3
        } else if (categoryType.ordinal == BannerType.editor_choice_banners.ordinal) {
            return 1
        } else {
            return 3
        }
    }


    enum class ViewHolderType(value: Int) {
        SUB_CATEGORY(1), TOP_SELLER(2), BEST_SELLER(3), EDITOR_CHOICE_BANNER(4)
    }
}