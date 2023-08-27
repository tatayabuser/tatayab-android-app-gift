package com.tatayab.tatayab.productreviews

import android.text.TextUtils
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.tatayab.model.Review
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate


class ReviewsAdapter() :
    PagedListAdapter<Review, ReviewViewHolder>(REVIEWE_COMPARATOR) {
    val layoutId: Int = R.layout.list_item_product_review

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    companion object {

        private val REVIEWE_COMPARATOR = object : DiffUtil.ItemCallback<Review>() {
            override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean =
                TextUtils.equals(
                    oldItem.post_id,
                    newItem.post_id
                ) && TextUtils.equals(oldItem.name, newItem.name)

            override fun areContentsTheSame(
                oldItem: Review,
                newItem: Review
            ): Boolean =
                oldItem == newItem
        }
    }
}