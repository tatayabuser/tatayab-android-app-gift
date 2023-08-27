package com.tatayab.tatayab.checkout

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CartOrderResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.main.ValueCounterView
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_review_orders.view.*

class ReviewProductsAdapter(private  val decimalNumbers: Int) : RecyclerView.Adapter<ReviewProductsAdapter.ProductViewHolder>() {

    private var items: MutableList<CartOrderResponse>? = null
    private var currencyCode: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_review_orders, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items?.get(position)

        with(holder) {
            bindTo(product = product)
            product?.let { product ->

                /*itemView.iv_delete.setSafeOnClickListener {
                    listener.onProductDelete(
                        product.cartId,
                        product = product.cartValue,
                        index = position
                    )
                }*/
                /*itemView.container.setSafeOnClickListener {
                    listener.onProductClicked(
                        productId = product.cartValue.productId!!,
                        options = product.cartValue.productOptions
                    )

                }*/
                /*itemView.tv_quantity_value.setOnValueClickListener { operationType, value ->
                    updateAmountListener.onUpdateAmount(
                        operationType = operationType,
                        productId = product.cartId,
                        product = product.cartValue,
                        value = value,
                        position = position
                    )
                }*/
                /*itemView.tv_view_options.setSafeOnClickListener {
                    listener.onOptionsClicked(product.cartValue)
                }*/

            }
        }
    }

    fun setData(currencyCode: String, items: MutableList<CartOrderResponse>?) {
        this.items = items;
        this.currencyCode = currencyCode
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val price = view.tv_product_price
        private val productName = view.tv_product_name
        private val image = view.iv_product_img
        private val supplierName = view.tv_supplier_name
        private val basePrice = view.tv_product_actual_price
        private val amountCounter = (view.tv_quantity_value as ValueCounterView)


        private var product: CartOrderResponse? = null
        fun bindTo(product: CartOrderResponse?) {
            this.product = product
            val context = view.context

            /*if (this.product?.productOptions!!.isNotEmpty()) {
                viewOptions.visibility = View.VISIBLE
            } else {
                viewOptions.visibility = View.GONE
            }*/

            supplierName.text = product?.supplier_name
//            amountCounter.value = product?.availableAmount!!
            productName.text = product?.title

            basePrice.paintFlags = basePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            basePrice.text = context.getString(R.string.currency, product!!.price.toString(),currencyCode)
            price.text = context.getString(
                R.string.currency,
                NumbersUtil.formatNumber(product.price!!.toFloat(), decimalNumbers),
                currencyCode
            )
            try {
                Picasso.get()
                    .load(product.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

//            Glide.with(context)
//                .load(product.image)
//                .apply(getPlaceholder())
//                .into(image)
        }
    }



}