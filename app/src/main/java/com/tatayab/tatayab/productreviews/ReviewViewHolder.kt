package com.tatayab.tatayab.productreviews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.Review
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.util.DateUtil
import kotlinx.android.synthetic.main.list_item_product_review.view.*
import java.util.*

class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rateOwner = view.rate_owner
        private val rateDate = view.rate_date
        private val rateComent = view.rate_coment
        private val userRate = view.user_rate
        var mView = itemView

        fun bind(review: Review) {
            val context = itemView.context
            rateOwner.text = review.name
            rateComent.text = review.message
            if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
                rateDate.text =   review.date
            else
            rateDate.text = DateUtil.formatDateFromString(review.date, App.getPref().currentLanguage.locale.language)
            userRate.rating = review.rating_value.toFloat()
        }
    }
