package com.tatayab.tatayab.main.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductX
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListenerInHome
import com.tatayab.tatayab.productlist.ProductViewHolder
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.list_item_grid_product.view.*


class ProductsAdapter(
    private val listener: OnProductListenerInHome,
    private val slideTwo: Boolean = false,
    private val multiOffer: Boolean = false,
    private val recentView: Boolean = false,
    private val decimalNumbers: Int
) : RecyclerView.Adapter<ProductViewHolder>() {

    private var items: List<ProductX?>? = null
    private var currencyCode: String? = null


    fun setData(currencyCode: String, items: List<ProductX?>?) {
        var mitems = ArrayList<ProductX?>()
        items?.let {
            for(item in items){
                if(item?.can_buy == 1){
                   mitems.add(item)
                }
            }
        }
        this.items = mitems
        this.currencyCode = currencyCode
        notifyDataSetChanged()
    }


    fun changeFav(position: Int, isChecked: Boolean) {
        println("WishListAction / changeFav/ position : " + position + " , state : " + isChecked)
        items?.get(position)?.inWishlist = if (isChecked) 1 else 0
        notifyItemChanged(position)
    }



    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val product = items?.get(position)

        if (product?.can_buy == 1) {


            with(holder) {
                bindTo(product, currencyCode!!, false)
                itemView.btn_favorite.isChecked = product?.inWishlist == 1

                product.let { product ->
                    itemView.setOnClickListener {
                        listener.onProductSelected(
                            product?.product_id!!,
                            product,
                            this@ProductsAdapter
                        )
                    }

                    itemView.btn_favorite.setSafeOnClickListener {
                        itemView.btn_favorite.isChecked = false
                        if (product?.has_options!! == 1)
                            listener.onProductSelected(
                                product.product_id,
                                product,
                                this@ProductsAdapter
                            )
                        else {
                            if (product.inWishlist == 1) {
                                listener.removeFromWishlist(position, product, this@ProductsAdapter)
                            } else {
                                listener.addToWishlist(position, product, this@ProductsAdapter)
                            }
                        }
                    }

                    itemView.btn_add_to_cart.setSafeOnClickListener {
                        if (product?.has_options == 1) {
                            listener.onProductSelected(
                                product.product_id,
                                product,
                                this@ProductsAdapter
                            )
                        } else {
                            listener.onAddToCart(
                                product = product!!,
                                amount = 1,
                                maxQty = product.can_buy!!,
                                image = itemView.iv_product_img

                            )
                        }
                    }

                }
            }
        } else {
            Log.d("TAG", "Not in Stock no: ${product?.product_id}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view: View? = null

        view = when {
            slideTwo -> LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_slide_product, parent, false)
            multiOffer -> LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_multi_offer_product, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_grid_product, parent, false)
        }

        val params = view?.layoutParams
        var itemSize = 2.1
        if (slideTwo) {
            itemSize = 1.7
        }
        params?.width = ((ViewUtil.getScreenWidth() / itemSize)).toInt()
        view?.layoutParams = params
        return ProductViewHolder(view!!, decimalNumbers)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = items?.size ?: 0
}

