package com.tatayab.tatayab.orders

import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.Order
import com.tatayab.model.responses.ProductsImage
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOrderListener
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_order.view.*
import kotlinx.android.synthetic.main.list_item_order_items_image.view.*

class OrdersAdapter(private val listener: OnOrderListener, private val decimalNumbers: Int) :


    PagedListAdapter<Order, OrdersAdapter.ViewHolder>(ORDER_COMPARATOR) {
    val layoutId: Int = R.layout.list_item_order


    var currencyCode: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, listener)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var order: Order
        private val id = view.order_id_value
        private val amount = view.order_amount_value
        private val statues = view.order_statues_value
        private val date = view.order_date
        private val rv_images = view.rv_order_items_images
        val context = itemView.context

        fun bind(order: Order, listener: OnOrderListener) {
            try {
                this.order = order
                val context = itemView.context
                id.text = order.order_id
                rv_images.adapter = ImagesAdapter(order.products_image, order.order_id)
                date.text = order.date
                if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
                    amount.text = order.total.toString().plus(" ").plus(order.currency)
                else
                    amount.text = context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(order.total, decimal = decimalNumbers),
                        currencyCode
                    )
                statues.text = order.lastStatus.name

                when (order.lastStatus.name) {
                    "Completed" -> statues.setTextColor(context.resources.getColor(R.color.completed_status))
                    "Processing" -> statues.setTextColor(context.resources.getColor(R.color.processing_status))
                    "Pending" -> statues.setTextColor(context.resources.getColor(R.color.pending_status))
                    "Cancelled" -> statues.setTextColor(context.resources.getColor(R.color.cancelled_status))
                    else -> statues.setTextColor(context.resources.getColor(R.color.processing_status))
                }
                itemView.setSafeOnClickListener {
                    listener.onOrderSelected(
                        order.order_id
                    )
                }

            } catch (e: Exception) {
                Log.d("order Bind Exception ", e.toString())
            }
        }
    }

    companion object {
        private val ORDER_COMPARATOR = object : DiffUtil.ItemCallback<Order>() {
            override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean =
                TextUtils.equals(
                    oldItem.order_id,
                    newItem.order_id
                ) && TextUtils.equals(oldItem.order_id, newItem.order_id)

            override fun areContentsTheSame(
                oldItem: Order,
                newItem: Order
            ): Boolean =
                oldItem == newItem
        }
    }


    inner class ImagesAdapter(val productsImage: List<ProductsImage>, val orderId: String) :
        RecyclerView.Adapter<ImageViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            return ImageViewHolder(parent.inflate(R.layout.list_item_order_items_image))
        }

        override fun getItemCount(): Int {
            return productsImage.size
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            holder.bind(productsImage[position], orderId)

        }

    }

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val product_image = view.product_img

        fun bind(productImage: ProductsImage, orderId: String) {

            itemView.setSafeOnClickListener {
                listener.onOrderSelected(orderId)
            }

            val context = itemView.context
            product_image.setImageResource(R.drawable.address)
//            Glide.with(context)
//                .load(productImage.image)
//                .apply(getPlaceholder())
//                .into(product_image)

            try {
                Picasso.get()
                    .load(productImage.image)
                    .placeholder(R.drawable.default_image2).into(product_image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

}