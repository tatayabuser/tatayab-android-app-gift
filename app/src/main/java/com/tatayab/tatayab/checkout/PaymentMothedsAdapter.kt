package com.tatayab.tatayab.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CheckOutPaymentModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.addto_cart_with_options_sheet.*
import kotlinx.android.synthetic.main.item_payment.view.*
import java.lang.Exception

class PaymentMethodsAdapter(var currencyCode: String, private val decimalNumbers: Int) :
    RecyclerView.Adapter<PaymentMethodsAdapter.PaymentViewHolder>() {

    private var items: List<CheckOutPaymentModel>? = null
    private var listener: PaymentListener? = null

    fun setListener(listener: PaymentListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val model = items?.get(position)

        with(holder) {
            bindTo(model)
        }
    }

    fun setData(items: List<CheckOutPaymentModel>?) {
        this.items = items
        notifyDataSetChanged()
    }


    inner class PaymentViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val paymentIcon = view.methodImageView
        private val paymentTitle = view.tv_payment_name
        private val paymentFees = view.tv_payment_fees
        private val selectionIcon = view.radio_payment
        private val item = view.paymentItemView


        private var model: CheckOutPaymentModel? = null
        fun bindTo(model: CheckOutPaymentModel?) {
            this.model = model
            val context = view.context

            model.let {
                paymentTitle.text = it?.name
                try {
                    if (!model?.fees.isNullOrEmpty()) {
                        paymentFees.visibility = View.VISIBLE
                        paymentFees.text = context.getString(
                            R.string.currency,
                            model?.fees,
                            ""
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

//                Glide.with(context)
//                    .load(it?.image)
//                    .apply(getPlaceholder())
//                    .into(paymentIcon)
                try {
                    Picasso.get()
                        .load(it?.image)
                        .placeholder(R.drawable.default_image2).into(paymentIcon)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

                if (it?.is_selected == 1) {
                    selectionIcon.setImageResource(R.drawable.is_primary)
                    listener.let {
                        it!!.onPaymentMethodDefaultSelected(model!!)
                    }
                } else {
                    selectionIcon.setImageResource(R.drawable.not_primary_img)
                }
                item.setSafeOnClickListener {
                    if (model?.is_selected == 0) {
                        listener.let {
                            it!!.onPaymentMethodSelected(model)
                        }
                    }
                }
            }
        }
    }


}