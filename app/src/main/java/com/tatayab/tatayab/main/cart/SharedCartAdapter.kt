package com.tatayab.tatayab.main.cart

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_cart.view.delete
import kotlinx.android.synthetic.main.list_item_cart.view.tv_product_actual_price
import kotlinx.android.synthetic.main.list_item_cart.view.tv_supplier_name
import kotlinx.android.synthetic.main.list_item_grid_product.view.iv_product_img
import kotlinx.android.synthetic.main.list_item_grid_product.view.tv_product_name
import kotlinx.android.synthetic.main.list_item_grid_product.view.tv_product_price
import kotlinx.android.synthetic.main.list_item_shared_cart.view.*


class SharedCartAdapter(
) : RecyclerView.Adapter<SharedCartAdapter.ProductViewHolder>() {

    private var items: ArrayList<ProductX?>? = null
    private var currencyCode: String? = null
    private var decimalNumbers: Int = 1
    private var isMergeProcessDone = false
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items?.get(position)

        with(holder) {
            bindTo(product = product)
            product?.let { product ->
                // actions
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_shared_cart, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(
        currencyCode: String,
        items: List<ProductX?>,
        decimalNumbers: Int,
        isMergeProcessDone: Boolean = false
    ) {
        this.items = items as ArrayList
        this.currencyCode = currencyCode
        this.decimalNumbers = decimalNumbers
        this.isMergeProcessDone = isMergeProcessDone
        notifyDataSetChanged()
    }

    fun setDataAfterMerging(
        items: List<ProductX?>,
        isMergeProcessDone: Boolean = false
    ) {
        this.items = items as ArrayList
        this.isMergeProcessDone = isMergeProcessDone
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val price = view.tv_product_price
        private val deleteView = view.delete
        private val productName = view.tv_product_name
        private val image = view.iv_product_img
        private val supplierName = view.tv_supplier_name
        private val basePrice = view.tv_product_actual_price
        private val tvAmount = view.tv_amount
        private val mergeStatusTextView = view.mergeStatusTextView
        private val mergeErrorReasonTextView = view.mergeErrorReasonTextView

        private var product: ProductX? = null
        fun bindTo(product: ProductX?) {
            this.product = product
            val context = view.context

            deleteView.visibility = View.GONE
            if (isMergeProcessDone) {
                mergeStatusTextView.visibility = View.VISIBLE
                if (product?.isMerged!!) {
                    mergeErrorReasonTextView.visibility = View.GONE
                    mergeStatusTextView.setTextColor(context.resources.getColor(R.color.green))
                    mergeStatusTextView.text = context.getString(R.string.merged)
                } else {
                    mergeStatusTextView.setTextColor(context.resources.getColor(R.color.red))
                    mergeStatusTextView.text = context.getString(R.string.not_merged)
                    if (!product?.mergingError.isNullOrEmpty()) {
                        mergeErrorReasonTextView.visibility = View.VISIBLE
                        mergeErrorReasonTextView.text = product?.mergingError.toString()
                    }
                }
            } else {
                mergeStatusTextView.visibility = View.GONE
                mergeErrorReasonTextView.visibility = View.GONE
            }

            supplierName.text = product?.supplier_name
            tvAmount.text = "x".plus(product?.amount)
            productName.text = product?.title
            if (product?.old_price != null) {
                if (product?.old_price?.toInt()!! > 0) {
                    basePrice.paintFlags = basePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    price.setTextColor(context.resources.getColor(R.color.red))
                    basePrice.visibility = View.VISIBLE
                    basePrice.text =
                        context.getString(
                            R.string.currency,
                            NumbersUtil.formatNumber(product.old_price!!, decimalNumbers),
                            currencyCode
                        )
                }
            }
            price.text = context.getString(
                R.string.currency,
                NumbersUtil.formatNumber(product?.price!!.toFloat(), decimalNumbers),
                currencyCode
            )
//            Glide.with(context)
//                .load(product.image)
//                .apply(getPlaceholder())
//                .into(image)
            try {
                Picasso.get()
                    .load(product.image)
                    .placeholder(R.drawable.default_image2).into(image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }


        }
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

}