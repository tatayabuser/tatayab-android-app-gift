package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnConciergeListener
import kotlinx.android.synthetic.main.item_concierge.view.*


class ConciergeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
     private val conciergeButtonAction = view.conciergeButtonAction


    fun bind(
        listener: OnConciergeListener
    ) {
        val context = itemView.context
        conciergeButtonAction.setSafeOnClickListener {
            listener.onConciergeButtonClicked()
        }
    }
}