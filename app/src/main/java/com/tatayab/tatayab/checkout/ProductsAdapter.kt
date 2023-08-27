package com.tatayab.tatayab.checkout

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.Product
import com.tatayab.model.responses.AddToWishListResponse
import com.tatayab.model.responses.CheckOutProductModel
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCheckoutProductSelected
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_product.view.*
import java.lang.Exception

class ProductsAdapter(
    var listener: OnCheckoutProductSelected,
    var currencyCode: String,
    private val decimalNumbers: Int,
    var wishListLiveData: SingleLiveEvent<Resource<AddToWishListResponse>>
) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private var items: List<CheckOutProductModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = items?.get(position)

        with(holder) {
            bindTo(model, position)
        }
    }

    fun setData(items: List<CheckOutProductModel>?) {
        this.items = items
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val productImageView = view.iv_product_img
        private val supplierNameTextView = view.supplierNameTextView
        private val productOldPriceTextView = view.productOldPriceTextView
        private val productTitleTextView = view.productTitleTextView
        private val productPriceTextView = view.productPriceTextView
        private val productAmountTextView = view.productAmountTextView
        private val addToWishList = view.btn_favorite


        private var model: CheckOutProductModel? = null
        fun bindTo(model: CheckOutProductModel?, position: Int) {
            try {
                this.model = model
                val context = view.context
                addToWishList.visibility = View.INVISIBLE
                model.let { checkOutProductModel ->
                    if(model?.currencyCode.isNullOrBlank().not()){
                        currencyCode = model?.currencyCode.toString()
                    }
                    supplierNameTextView.text = checkOutProductModel?.brand
                    productTitleTextView.text = checkOutProductModel?.name
                    productAmountTextView.text =
                        context.getText(R.string.amount).toString().plus(" ")
                            .plus(checkOutProductModel?.amount)

                    productPriceTextView.text = context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(model?.price!!.toFloat(), decimalNumbers),
                        currencyCode
                    )
                    if (model.originalPrice != null && model.originalPrice!!.toInt() > 0 && model.originalPrice!! > model?.price!! ) {
                        productOldPriceTextView.paintFlags = productOldPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                        productPriceTextView.setTextColor(context.resources.getColor(R.color.red))
                        productOldPriceTextView.visibility = View.VISIBLE
                        productOldPriceTextView.text =
                                context.getString(
                                    R.string.currency,
                                    NumbersUtil.formatNumber(model.originalPrice!!, decimalNumbers),
                                    currencyCode
                                )
                    }else{
                        productOldPriceTextView.visibility = View.GONE
                    }

//                    if(model.isGift == 1){
//                        addToWishList.visibility = View.GONE
//                    }else{
//                        addToWishList.visibility = View.VISIBLE
//                    }
                    wishListLiveData.observe(context as LifecycleOwner, Observer { wishListResult ->
                        when (wishListResult.status) {
                            ResourceState.SUCCESS -> {
                                wishListResult.data?.productPosition?.let {
                                    if (it >= 0 && !items.isNullOrEmpty() && items?.size!!> wishListResult.data?.productPosition!!) {
                                        items?.get(wishListResult.data?.productPosition!!)?.isInWishList =
                                            wishListResult.data?.newStatues == 1
                                        notifyItemChanged(it)
                                    }
                                }
                            }
                            else -> {}
                        }
                    })

//                    Glide.with(context)
//                        .load(checkOutProductModel?.image)
//                        .apply(getPlaceholder())
//                        .into(productImageView)
                    try {
                        Picasso.get()
                            .load(checkOutProductModel?.image)
                            .placeholder(R.drawable.default_image2).into(productImageView)

                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }

                    addToWishList.isChecked = checkOutProductModel?.isInWishList == true
                    addToWishList.setSafeOnClickListener {
                        listener.addToWishList(
                            position,
                            Product(
                                product_id = checkOutProductModel?.ref.toString(),
                                product = checkOutProductModel?.name,
                                product_code = checkOutProductModel?.code,
                                is_In_WishList = checkOutProductModel?.isInWishList!!
                            )
                        )
                    }
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}