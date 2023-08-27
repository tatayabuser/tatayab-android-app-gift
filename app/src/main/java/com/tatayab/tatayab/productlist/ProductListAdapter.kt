package com.tatayab.tatayab.productlist

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.makeAnimation
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListener
import kotlinx.android.synthetic.main.list_item_grid_product.view.*



class ProductListAdapter(
    private val listener: OnProductListener,
    private val decimalNumbers: Int
) : PagedListAdapter<ProductX, ProductViewHolder>(
    PRODUCT_COMPARATOR
) {

    var layoutId: Int = R.layout.list_item_product
    var currencyCode: String? = null


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        with(holder) {
            bindTo(product, currencyCode!!, true)

            product.let { product ->
                itemView.setOnClickListener {
                    product?.product_id?.let { it1 -> listener.onProductSelected(it1) }
                }

                itemView.btn_favorite.setSafeOnClickListener {
                    itemView.btn_favorite.isChecked = false
                    if (product?.has_options!! > 0)
                        listener.onProductSelected(product.product_id)
                    else {
                        listener.addToWishlist(
                            position, Product(
                                product_id = product.product_id, is_In_WishList =
                                product.inWishlist == 1, supplier_id = product.supplier_id,
                                supplier_name = product.supplier_name,
                                product = product.title
                            )
                        )
                        itemView.btn_favorite.makeAnimation()
                    }
                }

                itemView.btn_add_to_cart.setSafeOnClickListener {
                    if(product?.has_options == 1){
                        listener.onProductSelected(product.product_id)
                    }else {
                        listener.onAddToCart(
                            product!!
                        )
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(layoutId, parent, false)

        return ProductViewHolder(view, decimalNumbers)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun changeWishListState(position: Int, isChecked: Boolean) {
        try {
            if (position >= 0) {
                this.getItem(position)?.inWishlist = if (isChecked) 1 else 0
                notifyItemChanged(position)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setProductList(products : List<ProductX>) {
        notifyDataSetChanged()
    }


    companion object {
        private val PRODUCT_COMPARATOR = object : DiffUtil.ItemCallback<ProductX>() {
            override fun areItemsTheSame(oldItem: ProductX, newItem: ProductX): Boolean =
                TextUtils.equals(
                    oldItem.product_id,
                    newItem.product_id
                )

            override fun areContentsTheSame(
                oldItem: ProductX,
                newItem: ProductX
            ): Boolean =
                oldItem == newItem
        }

    }

}