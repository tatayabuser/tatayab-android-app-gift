package com.tatayab.tatayab.main.cart

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.Product
import com.tatayab.model.responses.CartOrderResponse
import com.tatayab.presentation.OperationType
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCartListener
import com.tatayab.tatayab.listener.OnUpdateAmountListener
import com.tatayab.tatayab.main.ValueCounterView
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.btn_favorite
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.container
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.countryView
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.delete
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.deliveryDateView
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.deliveryImageView
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.deliveryTextView
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.editGiftEnable
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.item_country_logo
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.iv_delete
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.iv_product_img
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.swip_item
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_country_name
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_product_actual_price
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_product_name
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_product_price
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_quantity_value
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.tv_supplier_name
import kotlinx.android.synthetic.main.item_cart_per_countery_2.view.btn_gift_options

class CartAdapter2(
    private val listener: OnCartListener,
    private val updateAmountListener: OnUpdateAmountListener,
    private val countryCode: String
) : RecyclerView.Adapter<CartAdapter2.ProductViewHolder>() {

    private var items: ArrayList<CartOrderResponse>? = null
    private var currencyCode: String? = null
    private var decimalNumbers: Int = 1
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items?.get(position)

        with(holder) {
            product?.let { product ->


                bindTo(product = product)
                itemView.iv_delete.setSafeOnClickListener {
                    itemView.swip_item.close(false)
                    //itemView.swip_item.dragLock(true)
                    listener.onProductDelete(
                        product.product_id!!,
                        product = product,
                        index = position
                    )
                }
                itemView.container.setSafeOnClickListener {
                    if (product.isGift != 1) {
                        listener.onProductClicked(
                            cartId = product.product_id!!,
                            productId = product.product_id!!,
                            options = product.productOptions
                        )
                    }
                }
                itemView.tv_quantity_value.setOnValueClickListener { operationType, value ->
                    updateAmountListener.onUpdateAmount(
                        operationType = operationType,
                        productId = product.product_id!!,
                        product = product,
                        value = value,
                        position = position
                    )
                }

                itemView.btn_gift_options.setOnClickListener {

                    listener.openGiftView()

                  /*  if(product?.countryId == countryCode) {
                        listener.openGiftView()
                    }else{

                    }*/

                  /*  if(product?.isFirstItemPerCountry == true  && product?.countryId == countryCode){
                        itemView.editGiftEnable.isEnabled=true
                        listener.openGiftView()
                    }else{
                        itemView.editGiftEnable.isEnabled=false
                    }*/

                }

                itemView.btn_favorite.setSafeOnClickListener {
                    itemView.btn_favorite.isChecked = false
                    if (product.inWishlist!!)
                        listener.removeFromWishlist(
                            position, Product(
                                product_id = product.product_id,
                                selected_options = product.productOptions,
                                supplier_id = product.supplier_id,
                                supplier_name = product.supplier_name,
                                product = product.title
                            )
                        )
                    else
                        listener.addToWishlist(
                            position,
                            Product(
                                product_id = product.product_id,
                                selected_options = product.productOptions,
                                supplier_id = product.supplier_id,
                                supplier_name = product.supplier_name,
                                product = product.title
                            )
                        )
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart_per_countery_2, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun changeWishListState(position: Int, isChecked: Boolean) {
        items?.get(position)?.inWishlist = isChecked
    }

    fun setData(currencyCode: String, items: List<CartOrderResponse>, decimalNumbers: Int) {
        this.items = items as ArrayList
        this.currencyCode = currencyCode
        this.decimalNumbers = decimalNumbers
        notifyDataSetChanged()
    }

    fun getGiftIDIfExist():String?{
        if(items.isNullOrEmpty().not()){
            items?.map {
                if(it?.isGift == 1) return it?.product_id.toString()
            }
        }

        return null
    }

    fun addGiftItem(giftItem : CartOrderResponse) {
        if(items.isNullOrEmpty().not()) items?.add(giftItem)
        notifyDataSetChanged()
    }



    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val price = view.tv_product_price
        private val deleteView = view.delete
        private val productName = view.tv_product_name
        private val image = view.iv_product_img
        private val supplierName = view.tv_supplier_name
        private val basePrice = view.tv_product_actual_price
        private val addtoFav = view.btn_favorite
        private val editGiftEnable = view.editGiftEnable
        private val amountCounter = (view.tv_quantity_value) as ValueCounterView
        /////////////// country and delivery date
        private val countryView = view.countryView
        private val countryLogoImageView = view.item_country_logo
        private val countryNameTextView = view.tv_country_name
        private val deliveryDateView = view.deliveryDateView
        private val deliveryImageView = view.deliveryImageView
        private val deliveryTextView = view.deliveryTextView
        private val btn_gift_options=view.btn_gift_options

        private var product: CartOrderResponse? = null
        fun bindTo(product: CartOrderResponse?) {
            this.product = product
            val context = view.context

            if(product?.currencyId.isNullOrBlank().not()){currencyCode = product?.currencyId.toString()}
            supplierName.text = product?.supplier_name
            amountCounter.value = product?.amount!!
            productName.text = product.title
            addtoFav.isChecked = product.inWishlist!!
            if (product.isGift == 1) {
                amountCounter.visibility = View.INVISIBLE
//                editGiftEnable.visibility = View.VISIBLE
                deleteView.visibility = View.GONE
                addtoFav.visibility = View.INVISIBLE
                listener?.updateGiftId(product?.product_id!!)
            } else {
            /*  editGiftEnable.visibility = View.GONE
                amountCounter.visibility = View.VISIBLE
                deleteView.visibility = View.VISIBLE
                addtoFav.visibility = View.VISIBLE*/
            }
            if(currencyCode.isNullOrBlank()){
                currencyCode = product?.currencyId.toString()
            }
            if (product.disc_perc != null) {
                if (product.disc_perc?.toInt()!! > 0) {
                    basePrice.paintFlags = basePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    price.setTextColor(context.resources.getColor(R.color.red))
                    basePrice.visibility = View.VISIBLE
                    basePrice.text =
                        context.getString(
                            R.string.currency,
                            NumbersUtil.formatNumber(product.original_price!!, decimalNumbers),
                            currencyCode
                        )
                }
            }
            price.text = context.getString(
                R.string.currency,
                NumbersUtil.formatNumber(product.price!!.toFloat(), decimalNumbers),
                currencyCode
            )
//            Glide.with(context)
//                .load(product.image)
//                .apply(getPlaceholder())
//                .into(image)

            btn_gift_options.setOnClickListener {
                updateAmountListener.getGiftOptions()
            }


            try {
                Picasso.get()
                    .load(product.image)
                    .placeholder(R.drawable.default_image2).into(image)

                if(product?.isFirstItemPerCountry == true && product?.mShippingDetailsModel != null){

                    countryView.visibility = View.VISIBLE
                    deliveryDateView.visibility = View.VISIBLE
                    if(MemoryCacheManager?.countriesList.isNullOrEmpty().not() && product?.countryId.isNullOrBlank().not()){
                        Picasso.get()
                            .load(getFlagFromCountries(product?.countryId))
                            .placeholder(R.drawable.ic_kuwait).into(countryLogoImageView)
                    }
                    deliveryTextView.text =getDeliveryDate(context ,product?.mShippingDetailsModel?.delivery_from_str.toString() , product?.mShippingDetailsModel?.delivery_to_str.toString())
                    var countryNameValue = MemoryCacheManager.getCountryNameByCode(product?.countryId.toString())
                    countryNameTextView.text = countryNameValue
                    deliveryDateView.visibility = View.GONE

                }else{
                    countryView.visibility = View.GONE
                    deliveryDateView.visibility = View.GONE
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            if(product?.isFirstItemPerCountry == true  && product?.countryId == countryCode){
                btn_gift_options.isEnabled=true
            }else{
                btn_gift_options.isEnabled=false
                btn_gift_options.setBackgroundColor(context.resources.getColor(R.color.gray_dark))
            }

        }
    }

    private fun getDeliveryDate(context: Context, fromDate : String, toDate: String): String {
        var deliveryDate = ""
        try {
            if(fromDate.isNullOrBlank() && toDate.isNullOrBlank().not()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+toDate)
            } else  if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+fromDate)
            }else if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank().not()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+fromDate).plus(" - ").plus(toDate)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return deliveryDate
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun removeItem(position: Int) {
        if (position >= items!!.size) return
        position.also { pos ->
            items?.removeAt(pos)
            notifyItemRemoved(pos)
            notifyItemChanged(pos)
            notifyItemRangeChanged(pos, 1)
        }
    }

    private fun getFlagFromCountries(countryCourseCode: String?): String? {
        //					"source_code": "KW-WH"
        var countryCodeSplitList = countryCourseCode?.split("-")
        var countryCode = if(countryCodeSplitList.isNullOrEmpty()) "" else countryCodeSplitList[0]
        MemoryCacheManager?.countriesList?.map {
            if(countryCode.equals(it?.code)){
                return it?.flag
            }
        }
        return ""
    }
    fun updateItem(operationType: OperationType, productId: String, position: Int) {
        if (items.isNullOrEmpty() || items?.size!! <= position) return
        val product = items?.get(position)
        if (operationType == OperationType.ADD) {
            product?.amount = product?.amount?.plus(1)
        } else {
            product?.amount = product?.amount?.minus(1)
        }
        notifyItemChanged(position)
    }

    fun getData(): List<CartOrderResponse>? {
        return items
    }

}