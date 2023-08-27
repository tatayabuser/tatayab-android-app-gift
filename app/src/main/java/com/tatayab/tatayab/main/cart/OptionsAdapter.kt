package com.tatayab.tatayab.main.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductOptionsDetailed
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSelectedOptionListener
import kotlinx.android.synthetic.main.list_item_options.view.*


//typealias OnProductListener = (productId) -> Unit

class OptionsAdapter(
    private val listener: OnSelectedOptionListener
) : RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {

    private var items: MutableList<ProductOptionsDetailed>? = null

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val option = items?.get(position)

        with(holder) {
            bindTo(option = option)
            option?.let { option ->

                itemView.setSafeOnClickListener {

                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_options, parent, false)
        return OptionsViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(items: MutableMap<String, ProductOptionsDetailed>?) {
        this.items = items?.values?.toMutableList();
        notifyDataSetChanged()
    }


    inner class OptionsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


        private val optionName = view.tv_option_name
        //private val image = view.iv_product_img
        //private val amountCounter = (view.tv_quantity_value as ValueCounterView)


        private var optionDetails: ProductOptionsDetailed? = null
        fun bindTo(option: ProductOptionsDetailed?) {
            this.optionDetails = option
            val context = view.context
            optionName.text = optionDetails?.optionName.plus(" - ")
                .plus(optionDetails?.variants?.values?.first()?.variant_name)

        }

    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }


}