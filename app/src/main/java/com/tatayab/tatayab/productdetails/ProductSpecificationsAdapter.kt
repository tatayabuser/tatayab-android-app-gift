package com.tatayab.tatayab.productdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.ProductSpecific
import com.tatayab.model.responses.graph_responses.GraphProductSpecificationsEnum
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.item_product_specific.view.*

class ProductSpecificationsAdapter(
) : RecyclerView.Adapter<ProductSpecificationsAdapter.ProductViewHolder>() {

    var items: ArrayList<ProductSpecific>? = null
    var mContext: Context?= null
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val option = items?.get(position)

        with(holder) {
            bindTo(option)
            option?.let { product ->
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_specific, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(
        items: ArrayList<ProductSpecific>,
        context: Context
    ) {
        this.mContext = context
        this.items = items
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val productSpecificName = view.specific_title
        private val productSpecificValue = view.specific_value
        private var options: ProductSpecific? = null
        fun bindTo(
            specific: ProductSpecific?
        ) {
            this.options = specific
            productSpecificName.text = if (specific?.label != null) specific.label
            else {
                when (specific?.productSpecificType) {
                    GraphProductSpecificationsEnum.PRODUCT_TYPE -> mContext?.getString(R.string.type)
                    GraphProductSpecificationsEnum.PRODUCT_SUPPLIER -> mContext?.getString(R.string.brand_title)
                    GraphProductSpecificationsEnum.PRODUCT_SIZE -> mContext?.getString(R.string.product_size)
                    GraphProductSpecificationsEnum.PRODUCT_COLOR -> mContext?.getString(R.string.product_color)
                    GraphProductSpecificationsEnum.PRODUCT_GENDER -> mContext?.getString(R.string.product_gender)
                    else -> ""
                }
            }
            productSpecificValue.text = specific?.value ?: ""

        }
    }

    override fun getItemCount(): Int = items?.size ?: 0


}