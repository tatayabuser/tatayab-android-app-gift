package com.tatayab.tatayab.main.categories

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.tatayab.model.responses.CategoryItem
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListener
import com.tatayab.tatayab.listener.OnCategoryListenerInHome
import kotlinx.android.synthetic.main.list_item_side_category.view.*


class MasterCategoryAdapter(
    private val listener: OnCategoryListener
) :
    RecyclerView.Adapter<MasterCategoryAdapter.ViewHolder>() {

    private var items: List<CategoryItem>? = null
    private var selectedItem: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_side_category))
    }

    fun setData(items: List<CategoryItem>) {
        this.items = items
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

        private lateinit var category: CategoryItem

        fun bind(
            category: CategoryItem,
            listener: OnCategoryListener,
            position: Int
        ) {

            this.category = category
            val context = itemView.context

            if (selectedItem == position) {
                itemView.setBackgroundColor(context.resources.getColor(R.color.dark_blue))
                itemView.tv_category_name.setTextColor(context.resources.getColor(R.color.white))
            } else {
                itemView.setBackgroundColor(context.resources.getColor(R.color.original_gray))
                itemView.tv_category_name.setTextColor(context.resources.getColor(R.color.dark_blue))
            }

            itemView.tv_category_name.text = category.name

            itemView.setSafeOnClickListener {
                var categoryId:String? = category.category_id
                if(Constants.ENABLE_GRAPH_QUERIES_CALLS){
                    categoryId = category.category_uid
                }
                if(categoryId.isNullOrBlank()) categoryId = ""
                selectedItem = position
                notifyDataSetChanged()
                listener.onCategorySelected(categoryId!!, category.name)
            }

        }
    }
}