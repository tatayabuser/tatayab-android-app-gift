package com.tatayab.tatayab.productlist

import android.graphics.Paint
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.getStringLocale
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_grid_product.view.*

class ProductViewHolder(private val view: View, private val decimalNumbers: Int) :
    RecyclerView.ViewHolder(view) {


    private val offCircle = view.tv_price_off
    private val basePrice = view.tv_product_actual_price
    private val price = view.tv_product_price
    private val productName = view.tv_product_name
    private val freeDelivery = view.tv_free_delivery
    private val image = view.iv_product_img
    private val addToCart = view.btn_add_to_cart
    private val outOfStock = view.out_of_stock
    private val addtoFav = view.btn_favorite
    private val supplierName = view.tv_supplier_name
    private val outOfStockImage = view.outOfStockImage


    private var product: ProductX? = null
    private var currencyCode: String? = null
    fun bindTo(product: ProductX?, currencyCode: String, isProductList: Boolean) {
        val context = view.context
        this.product = product
        this.currencyCode = currencyCode
        product?.let {
            product.old_price?.let {
                if (product.discount_perc!! > 0 || NumbersUtil.hasPriceOff(
                        product?.price?.toFloat() ?: 0f,
                        product?.old_price?.toFloat() ?: 0f
                    )) {
                    offCircle.visibility = View.VISIBLE
//                    offCircle.text = context.getStringLocale(
//                        R.string.off,
//                        product.discount_perc!!.toInt()
//                    )
                    var discountPer = product?.percent_off?.toInt()
                    offCircle.text=context.getString(R.string.off).plus(" "+discountPer.toString()).plus("%")
//                    offCircle.text=context.getStringLocale(
//                        R.string.off,
//                                NumbersUtil.calculateOffPercent(
//                                product?.price?.toFloat() ?: 0f,
//                        product?.old_price?.toFloat() ?: 0f
//                    )
//                    )
                    basePrice.paintFlags = basePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//            if(isProductList){
//                basePrice.visibility = View.INVISIBLE
//            }else{
                    price.setTextColor(context.resources.getColor(R.color.red))
                    basePrice.visibility = View.VISIBLE
                    //      }
                     basePrice.text =
                        context.getString(
                            R.string.currency, NumbersUtil.formatNumber(
                                product.old_price!!,
                                decimalNumbers
                            ), product.currency ?: currencyCode
                        )
                }
            }

            // check free delivery
            if (product.is_free_delivery > 0)
                freeDelivery.visibility = View.VISIBLE
            else
                freeDelivery.visibility = View.INVISIBLE

            addtoFav.isChecked = product.inWishlist > 0

            if (product.can_buy == 0) {
                addToCart.isEnabled = false
                outOfStock.visibility = View.VISIBLE
                outOfStockImage.visibility = View.VISIBLE
            }
            productName.text = if (product.title.isNullOrBlank()) "" else product.title.toString()
            supplierName.text = if (product.supplier_name.isNullOrBlank()) "" else product.supplier_name.toString()
            price.text = context.getString(
                R.string.currency,
                NumbersUtil.formatNumber(product.price, decimalNumbers),
                product.currency ?: currencyCode
            )
            //itemView.tv_Product_name.text = product.product
//            Glide.with(context)
//                .load(
//                    product.image
//                ).apply(getPlaceholder())
//                .into(image)

            try {
                Picasso.get()
                    .load( product.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

    }

}
