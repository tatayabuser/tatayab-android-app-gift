package com.tatayab.tatayab.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.CheckoutLabelModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_label.view.*
import java.lang.Exception

class CheckOutLabelsAdapter(var currencyCode: String, private val decimalNumbers: Int) :
    RecyclerView.Adapter<CheckOutLabelsAdapter.LabelViewHolder>() {

    private var items: MutableList<CheckoutLabelModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_label, parent, false)
        return LabelViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: LabelViewHolder, position: Int) {
        val model = items?.get(position)

        with(holder) {
            bindTo(model)
        }
    }

    fun setData(items: List<CheckoutLabelModel>?) {
        try {
            var filteredList: ArrayList<CheckoutLabelModel> = ArrayList()
            items?.map {
//                if (it?.value != null && it?.value!! > 0) {
                if (it?.value != null) {
                    if(it?.value!! > 0) {
                        filteredList.add(it)
                    }else if(it?.name.equals(Constants.SHIPPING_COST_KEY)) {
                        filteredList.add(it)
                    }
                }
            }
            this.items = filteredList as MutableList<CheckoutLabelModel>?
            if (currencyCode.isNullOrBlank() && items?.isNullOrEmpty()!!.not()) {
                items?.map {
                    if (it?.currencyCode.isNullOrBlank().not()) {
                        currencyCode = it?.currencyCode!!
                    }
                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        notifyDataSetChanged()
    }


    inner class LabelViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val labelKeyTextView = view.labelKeyTextView
        private val labelValueTextView = view.labelValueTextView


        private var model: CheckoutLabelModel? = null
        fun bindTo(model: CheckoutLabelModel?) {
            this.model = model
            val context = view.context

            model.let {
                if (it?.name.isNullOrBlank().not() && it?.name.equals(Constants.TAXES_KEY))
                    labelKeyTextView.text = context.getString(R.string.taxes)
                else if (it?.name.isNullOrBlank()
                        .not() && it?.name.equals(Constants.SHIPPING_COST_KEY)
                ) {
                    labelKeyTextView.text = context.getString(R.string.shipping_cost)
                } else if (it?.name.isNullOrBlank()
                        .not() && it?.name.equals(Constants.CREDIT_KEY)
                ) {
                    labelKeyTextView.text = context.getString(R.string.credit_checkout)
                } else if (it?.name.isNullOrBlank()
                        .not() && it?.name.equals(Constants.TOTAL_PRICE_KEY)
                ) {
                    if(it?.hasTaxes == true){
                        labelKeyTextView.text = context.getString(R.string.total_with_vat)
                    }else{
                        labelKeyTextView.text = context.getString(R.string.checkout_total)
                    }
                }
                else if (it?.name.isNullOrBlank()
                        .not() && it?.name.equals(Constants.SUB_TOTAL_KEY)
                ) {
//                    if(it?.hasTaxes == true){
//                        labelKeyTextView.text = context.getString(R.string.subtotal_with_taxes)
//                    }else{
                        labelKeyTextView.text = context.getString(R.string.subtotal)
//                    }
                } else if (it?.name.isNullOrBlank()
                        .not() && it?.name.equals(Constants.GIFT_COST_KEY)
                ) {
                    labelKeyTextView.text = context.getString(R.string.wrap_cost)
                } else
                    labelKeyTextView.text = it?.name

                labelValueTextView.text = context.getString(
                    R.string.currency,
                    NumbersUtil.formatNumber(it?.value!!.toFloat(), decimalNumbers),
                    currencyCode
                )
                if (it.sign?.equals("-", true)!!) {
                    labelValueTextView.text = "-" + labelValueTextView.text
                    labelValueTextView.setTextColor(ContextCompat.getColor(context, R.color.red))
                }
            }
        }
    }


}