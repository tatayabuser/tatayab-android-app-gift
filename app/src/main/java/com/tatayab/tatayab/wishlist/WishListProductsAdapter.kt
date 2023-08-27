package com.tatayab.tatayab.wishlist

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.model.responses.WishListProduct
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnWishListListener
import com.tatayab.tatayab.productdetails.ChooseOptionActivity
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.activity_choose_option.*
import kotlinx.android.synthetic.main.list_item_wishlist.view.*


class WishListProductsAdapter(
    private val listener: OnWishListListener,
    private val decimalNumbers: Int
) : RecyclerView.Adapter<WishListProductsAdapter.ProductViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0

    private var items: ArrayList<WishListProduct>? = null
    var currencyCode: String? = null

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val product = items?.get(position)

        with(holder) {
            bindTo(product, currencyCode!!)
            product?.let { product ->
                itemView.btn_favorite.setSafeOnClickListener {
                    if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
                        listener.onProductDelete(
                            product.selected_options,
                            position,
                            product.product_sku,
                            product.productWishListId
                        )
                    else
                        listener.onProductDelete(
                            product.selected_options,
                            position,
                            product.product_id,
                            product.productWishListId
                        )
                }
                itemView.btn_add_to_cart.setSafeOnClickListener {
                    listener.moveToCart(
                        product = ProductX(
                            product_id = if (Constants.ENABLE_GRAPH_QUERIES_CALLS) product.product_sku else product.product_id,
                            title = product.title,
                            has_options = if (product?.selected_options.isNullOrEmpty()) 1 else 0,
                            price = product.price,
                            source = product?.source
                        ),
                        options = product.selected_options,
                        index = position,
                        image = itemView.btn_add_to_cart
                    )
                }

                itemView.setSafeOnClickListener {
                    if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
                        listener.onProductClicked(product.product_sku, product.selected_options)
                    else
                        listener.onProductClicked(product.product_id, product.selected_options)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_wishlist, parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: ArrayList<WishListProduct>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setRemoveItem(index: Int) {
        if (index < this.items?.size!!) {
            this.items?.removeAt(index)
            notifyItemRemoved(index)
        }
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val price = view.tv_product_price
        private val supplier = view.tv_supplier_name
        private val productName = view.tv_product_name
        private val move_to_cart = view.btn_add_to_cart
        private val image = view.iv_product_img
        private val outOfStock = view.out_of_stock
        private val basePrice = view.tv_product_actual_price
        private var product: WishListProduct? = null
        private val outOfStockImage = view.outOfStockImage

        @SuppressLint("LogNotTimber")
        fun bindTo(product: WishListProduct?, currencyCode: String) {
            this.product = product
            val context = view.context
//            if (product?.isDeleted!!)
//                itemView.visibility = View.INVISIBLE

            if (product?.can_buy == 0) {
                move_to_cart.isEnabled = false
                outOfStock.visibility = View.VISIBLE
                outOfStockImage.visibility = View.VISIBLE
            }

            productName.text = product?.title
            supplier.text = product?.supplier_name
//            Glide.with(context)
//                .load(product?.image)
//                .apply(getPlaceholder())
//                .into(image)

            try {
                Picasso.get()
                    .load( product?.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            try {
                price.text = context.getString(
                    R.string.currency,
                    NumbersUtil.formatNumber(product?.price!!, decimalNumbers),
                    currencyCode
                )
            } catch (e: Exception) {
                Log.e("WListError ", e.message!!)
            }
        }
    }


}