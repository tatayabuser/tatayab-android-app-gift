package com.tatayab.tatayab.productdetails

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.tatayab.model.Review
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.productreviews.ReviewViewHolder


class ProductReviewsAdapter() : RecyclerView.Adapter<ReviewViewHolder>() {

    private var allReviewrs: List<Review>? = null

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        allReviewrs?.get(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ReviewViewHolder {

        return ReviewViewHolder(parent.inflate(R.layout.list_item_product_review))
    }


    override fun getItemCount(): Int = allReviewrs?.size ?: 0

    fun setData( reviewrs: List<Review>?) {
        this.allReviewrs = reviewrs
        notifyDataSetChanged()
    }


}