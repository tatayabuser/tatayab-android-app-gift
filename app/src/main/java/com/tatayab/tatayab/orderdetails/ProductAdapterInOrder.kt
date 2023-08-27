package com.tatayab.tatayab.orderdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.ProductInOrderDetails
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnProductListenerInOrder
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_product_in_order.view.*


class ProductAdapterInOrder(
    private val listener: OnProductListenerInOrder,
    private val decimalDigits: Int
    ) :
    RecyclerView.Adapter<ProductAdapterInOrder.ProductViewHolder>() {
    private var items: List<ProductInOrderDetails>? = null
    private var currencyCode: String? = null


    fun setData(currencyCode: String, items: List<ProductInOrderDetails>) {
        this.items = items
        this.currencyCode = currencyCode
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")

        val product = items?.get(position)

        with(holder) {
            bindTo(product)
            product?.let { product ->
                itemView.setOnClickListener {
                    listener.onProductSelected(product.product_id!!)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_product_in_order, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = items?.size ?: 0


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val price = view.tv_product_price
        private val basePrice = view.tv_old_price
        private val supplier = view.tv_subblier_name
        private val productName = view.tv_product_name
        private val productAmount = view.tv_product_amount_value
        private val image = view.iv_product_img
        private var product: ProductInOrderDetails? = null

        fun bindTo(product: ProductInOrderDetails?) {
            this.product = product
            val context = view.context

            productName.text = product?.name
            productAmount.text = product?.amount.toString()
            supplier.text = product?.supplier
            price.text = context.getString(
                R.string.currency,
                NumbersUtil.formatNumber(product?.price!!.toFloat(), decimalDigits),
                if(product?.currency.isNullOrBlank()) currencyCode else product.currency
            )

//            Glide.with(context)
//                .load(product.image)
//                .into(image)
            try {
                Picasso.get()
                    .load(product.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            itemView.setOnClickListener {
                listener.onProductSelected(product.product_id)
            }

            supplier.setOnClickListener {
             }

        }
    }

}

