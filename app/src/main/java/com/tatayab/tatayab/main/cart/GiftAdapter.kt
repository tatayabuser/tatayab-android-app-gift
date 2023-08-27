package com.tatayab.tatayab.main.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.listener.OnGiftListener
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_product_gift.view.*


class GiftAdapter(
    private val listener: OnGiftListener,
    private val decimalNumbers: Int
) : RecyclerView.Adapter<GiftAdapter.ProductViewHolder>() {

    private var items: ArrayList<ProductX>? = null
    private var currencyCode: String? = null
    private var selectedGiftProductID: String? = null

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
        selectedGiftProductID: String?
    ) {
        this.items = items
        this.currencyCode = currencyCode
        this.selectedGiftProductID = selectedGiftProductID
        if(currencyCode.isNullOrBlank() && items.isNullOrEmpty().not()){
            this.currencyCode = items?.get(0)!!.currencyCode
            MemoryCacheManager.addCurrencyCode(currencyCode)
        }
        notifyDataSetChanged()
    }
    fun updateSelectedGiftProductID(
        selectedGiftProductID: String?
    ) {
         this.selectedGiftProductID = selectedGiftProductID
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

            if (!selectedGiftProductID.isNullOrEmpty() && product?.product_id.equals(
                    selectedGiftProductID
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
                listener?.onGetButtonClicked2(product?.product_id!!)
                if(product?.product_id.equals(
                        selectedGiftProductID)){
                    selectedGiftProductID =""
                    notifyDataSetChanged()
                    listener?.onDeleteButtonClicked(product?.product_id!!)
                }else {
                    if(selectedGiftProductID ==null) {
                        selectedGiftProductID = product?.product_id
                        notifyDataSetChanged()
                        listener?.onAddButtonClicked(product!!)
                    }else{
                        listener?.onDeleteButtonClicked(selectedGiftProductID!!)
                        listener?.updateGift(product!!)
                        selectedGiftProductID = product?.product_id
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