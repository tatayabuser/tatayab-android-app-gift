package com.tatayab.tatayab.ordertracking

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.StatuesHistory
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setPlaceholderWithSmallIcon
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListenerInOrder
import kotlinx.android.synthetic.main.list_item_track_order.view.*
import timber.log.Timber

class OrderTrackingAdapter(val listener: OnProductListenerInOrder?) : RecyclerView.Adapter<OrderTrackingAdapter.ViewHolder>() {


    override fun getItemCount(): Int = items?.size ?: 0

    private var items: List<StatuesHistory>? = null
    private var urlTracking: String? = null


    val layoutId: Int = R.layout.list_item_track_order


    fun setData(items: List<StatuesHistory>,url:String?) {
        this.items = items
        this.urlTracking = url
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items?.get(position)!!)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val checkImg = view.check_img
        private val statuesIcon = view.statues_icon
        private val statuesTitle = view.statues_title
        private val statuesProgress = view.statues_delimiter
        private val statuesDescription = view.statues_description
        private val trackOrder = view.track


        fun bind(statues: StatuesHistory) {
            val context = itemView.context
            statuesTitle.text = statues.title
            statuesDescription.text = statues.desc

            if (statues.skey.equals("c",true))
                trackOrder.visibility = View.VISIBLE

            trackOrder.setSafeOnClickListener {
                if (statues.skey.equals("c",true)) {
                    listener?.onTrackExternalOrder(urlTracking)
                }
            }
            try {
                try {
                    Picasso.get()
                        .load(statues.icon)
                        .placeholder(R.drawable.default_image2).into(statuesIcon)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
//                Glide.with(context).load(statues.icon)
//                    .apply(setPlaceholderWithSmallIcon())
//                    .into(statuesIcon)

                when (statues.color) {
                    "green" -> {
                        checkImg.background = ContextCompat.getDrawable(
                            context,
                            R.drawable.order_checked
                        )
                    }
                    "gray" -> {
                        checkImg.background = ContextCompat.getDrawable(
                            context,
                            R.drawable.circle_process
                        )
                    }
                    else -> {
                        checkImg.setImageResource(R.drawable.cancel)
                        checkImg.background = ContextCompat.getDrawable(
                            context,
                            R.drawable.circle_cancel
                        )
                    }
                }
                if (adapterPosition + 1 == items?.size)
                    statuesProgress.visibility = View.GONE

//                if (statues.title == "shipping")

            } catch (e: Exception) {
                Timber.d(e.toString())
            }
        }

    }

}