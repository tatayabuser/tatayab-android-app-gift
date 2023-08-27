package com.tatayab.tatayab.main.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnGiftListener
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_product_gift.view.chooseButton
import kotlinx.android.synthetic.main.item_product_gift.view.itemView
import kotlinx.android.synthetic.main.item_product_gift.view.price
import kotlinx.android.synthetic.main.item_product_gift.view.productGiftImage
import kotlinx.android.synthetic.main.item_product_gift.view.productSelectedImage
import kotlinx.android.synthetic.main.item_product_gift.view.selectedItemView
import kotlinx.android.synthetic.main.item_product_gift.view.title

class GiftAdapter2 ( private val listener: OnGiftListener,
private val decimalNumbers: Int
) : RecyclerView.Adapter<GiftAdapter2.ProductViewHolder>() {

    private var items: ArrayList<ProductX>? = null
    private var currencyCode: String? = null
    private var selectedGiftProductIDc: String? = null

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items?.get(position)

        with(holder) {
            bindTo(product = product)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_gift_2, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(
        currencyCode: String,
        items: ArrayList<ProductX>,
        selectedGiftProductIDc: String?
    ) {
        this.items = items
        this.currencyCode = currencyCode
        this.selectedGiftProductIDc = selectedGiftProductIDc
        if(currencyCode.isNullOrBlank() && items.isNullOrEmpty().not()){
            this.currencyCode = items?.get(0)!!.currencyCode
            MemoryCacheManager.addCurrencyCode(currencyCode)
        }
        notifyDataSetChanged()
    }
    fun updateSelectedGiftProductID(
        selectedGiftProductIDc: String?
    ) {
        this.selectedGiftProductIDc = selectedGiftProductIDc
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val price = view.price
        private val chooseButton = view.chooseButton
        private val productName = view.title
        private val image = view.productGiftImage
        private val productSelectedImage = view.productSelectedImage
        private val selectedItemView = view.selectedItemView
        private val itemMainView = view.itemView


        private var product: ProductX? = null
        fun bindTo(product: ProductX?) {
            this.product = product
            val context = view.context

            productName.text = product?.title
            if(product?.price != null && product.price > 0){
                price.text =
                    context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(product?.price!!.toFloat(), decimalNumbers),
                        currencyCode
                    )}else{
                price.text =context.getString(R.string.free)
            }
//            Glide.with(context)
//                .load(product.image)
//                .apply(getPlaceholder())
//                .into(image)
            try {
                Picasso.get()
                    .load(product?.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            if (!selectedGiftProductIDc.isNullOrEmpty() && product?.product_id.equals(
                    selectedGiftProductIDc
                )
            ) {

//                productSelectedImage.visibility = View.VISIBLE
                selectedItemView.visibility = View.VISIBLE
                chooseButton.visibility = View.GONE
                itemMainView.setBackgroundDrawable(context.resources.getDrawable(R.drawable.gift_selected_bg))
            } else {
//                productSelectedImage.visibility = View.GONE
                selectedItemView.visibility = View.GONE
                chooseButton.visibility = View.VISIBLE
                itemMainView.setBackgroundDrawable(context.resources.getDrawable(R.drawable.gift_gray_bg))
            }
            chooseButton.setOnClickListener {
                listener?.onGetButtonClicked(product?.product_id!!)


                if(product?.product_id.equals(
                        selectedGiftProductIDc)){
                    selectedGiftProductIDc =""
                    notifyDataSetChanged()
                    listener?.onDeleteButtonClicked(product?.product_id!!)

                }else {
                    if(selectedGiftProductIDc ==null) {
                        selectedGiftProductIDc = product?.product_id
                        notifyDataSetChanged()
                        listener?.onAddButtonClicked(product!!)
                    }else{
                        listener?.onDeleteButtonClicked(selectedGiftProductIDc!!)
                        listener?.updateGift(product!!)
                        selectedGiftProductIDc = product?.product_id
                        notifyDataSetChanged()
                    }
                }
            }

        }
    }


    override fun getItemCount(): Int {
        return items?.size ?: 0
    }


}