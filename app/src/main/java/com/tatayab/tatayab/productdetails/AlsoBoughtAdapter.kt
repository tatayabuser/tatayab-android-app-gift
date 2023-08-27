package com.tatayab.tatayab.productdetails

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.getStringLocale
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListener
import com.tatayab.tatayab.util.NumbersUtil
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.list_item_grid_product.view.*


class AlsoBoughtAdapter(
    private val listener: OnProductListener,
    private val decimalNumbers: Int
) : RecyclerView.Adapter<AlsoBoughtAdapter.ProductViewHolder>() {

    private var items: List<ProductX?>? = null
    private var currencyCode: String? = null


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val product = items?.get(position)

        with(holder) {
            bindTo(product, currencyCode!!)
            product?.let { product ->

                itemView.setOnClickListener {
                    listener.onProductSelected(product.product_id)
                }

                itemView.btn_favorite.setSafeOnClickListener {
                    itemView.btn_favorite.isChecked = false
                    if (product.has_options == 0) {
                        listener.addToWishlist(
                            position,
                            Product(
                                product_id = product.product_id,
                                is_In_WishList = product.inWishlist > 0,
                                product = product.title
                            )
                        )
                        //itemView.btn_favorite.makeAnimation()
                    } else {
                        listener.onProductSelected(product.product_id)
                    }
                }

                itemView.btn_add_to_cart.setOnClickListener {
                    listener.onAddToCart(
                        product
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_grid_product, parent, false)
        val params = view.layoutParams
        params.width = ((ViewUtil.getScreenWidth() / 2.2) - 15).toInt()
        params.height = ((ViewUtil.getScreenWidth() / 1.5) + 15).toInt()
        view.layoutParams = params

        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun changeWishListState(position: Int, isChecked: Boolean) {
        try {
            if (position < items?.size!!) {
                items?.get(position)?.inWishlist = if (isChecked) 1 else 0
                notifyItemChanged(position)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun setData(currencyCode: String, items: List<ProductX?>) {
        this.items = items
        this.currencyCode = currencyCode
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


        private val offCircle = view.tv_price_off
        private val basePrice = view.tv_product_actual_price
        private val price = view.tv_product_price
        private val productName = view.tv_product_name
        private val soldOutStock = view.out_of_stock
        private val btn_add_to_cart = view.btn_add_to_cart
        private val outOfStockImage = view.outOfStockImage

        //private val productDescription = view.tv_product_description
        private val freeDelivery = view.tv_free_delivery
        private val image = view.iv_product_img
        private val addfav = view.btn_favorite

        private var product: ProductX? = null
        private var currencyCode: String? = null
        fun bindTo(product: ProductX?, currencyCode: String) {
            this.product = product
            this.currencyCode = currencyCode
            val context = view.context
//            itemView.btn_add_to_cart.setText(R.string.add_to_cart)
//            if (productx!!.fullDetails.has_options!!)
//                itemView.btn_add_to_cart.setText(R.string.select_option)

            try {
                basePrice.paintFlags = basePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                if (product?.discount_perc!! > 0) {
                    offCircle.visibility = View.VISIBLE
//                    offCircle.text = context.getStringLocale(
//                        R.string.off,
//                        product.discount_perc!!.toInt()
//                    )
                    var discountPer:Int? = 0
                    discountPer = product?.percent_off?.toInt()
                    offCircle.text = context.getString(R.string.off).plus(" $discountPer").plus("%")

                    price.setTextColor(context.resources.getColor(R.color.red))
                    basePrice.visibility = View.VISIBLE
                    basePrice.text = context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(product.old_price!!, decimalNumbers),
                        currencyCode
                    )
                } else {
                    offCircle.visibility = View.GONE
                    basePrice.visibility = View.GONE
                    price.setTextColor(context.resources.getColor(R.color.dark_blue))

                }
                // check free delivery
                if (product.is_free_delivery > 0) {
                    freeDelivery.visibility = View.VISIBLE
                } else
                    freeDelivery.visibility = View.INVISIBLE


                productName.text = product.title
                //productDescription.text = productx.fullDetails.product
                price.text =
                    context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(
                            product.price,
                            decimalNumbers
                        ),
                        currencyCode
                    )
                //itemView.tv_Product_name.text = product.product
                try {
                    Picasso.get()
                        .load( product.image)
                        .placeholder(R.drawable.default_image2).into(image)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

//                Glide.with(context)
//                    .load(
//                        product.image
//                    ).apply(getPlaceholder())
//                    .into(image)
                addfav.isChecked = product.inWishlist > 0

                if (product.can_buy!! == 0) {
                    btn_add_to_cart.isEnabled = false
                    soldOutStock.visibility = View.VISIBLE
                    outOfStockImage.visibility = View.VISIBLE
                } else {
                    btn_add_to_cart.isEnabled = true
                    soldOutStock.visibility = View.GONE
                    outOfStockImage.visibility = View.GONE
                }
            } catch (e: Exception) {
                Log.d("bind error", "")
            }
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

}