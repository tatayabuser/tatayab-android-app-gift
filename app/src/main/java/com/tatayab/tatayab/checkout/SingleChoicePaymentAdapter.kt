package com.tatayab.tatayab.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.PaymentMethod
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.drawableStart
import com.tatayab.tatayab.listener.OnPaymentListener
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.list_item_new_payment.view.*


class SingleChoicePaymentAdapter(
    private val listener: OnPaymentListener,
    private val decimalNumbers: Int
) : RecyclerView.Adapter<SingleChoicePaymentAdapter.SingleViewHolder>() {
    // if checkedPosition = -1, there is no default selection
// if checkedPosition = 0, 1st item is selected by default
    private var checkedPosition = 0
    private var coefficient: Float? = null
    private var paymentMethods: List<PaymentMethod>? = null
    private var countryCode: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_new_payment, parent, false)
        /*val params = view.layoutParams
        params.width = ((ViewUtil.getScreenWidth() / 2.7) - 15).toInt()
        view.layoutParams = params*/
        return SingleViewHolder(view)

    }


    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {

        //Timber.d("Binding view holder at position $position")
        val paymentMethod = paymentMethods?.get(position)
        holder.bind(paymentMethod!!, countryCode!!, coefficient!!, position)
    }


    override fun getItemCount(): Int {
        return paymentMethods?.size ?: 0
    }

    fun setPaymentMethods(
        coefficient: Float,
        countryCode: String,
        paymentMethods: List<PaymentMethod>
    ) {
        this.paymentMethods = paymentMethods
        if (paymentMethods != null && paymentMethods.size > 0) {
            this.paymentMethods?.get(0)?.isChecked = true
        }
        this.countryCode = countryCode
        this.coefficient = coefficient
        notifyDataSetChanged()
    }

    inner class SingleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var paymentMethod: PaymentMethod? = null
        private var countryCode: String? = null
        private var coefficient: Float? = null
        private val context = itemView.context
        fun bind(
            paymentMethod: PaymentMethod,
            countryCode: String,
            coefficient: Float,
            position: Int
        ) {
            this.paymentMethod = paymentMethod
            this.countryCode = countryCode
            this.coefficient = coefficient

            itemView.setOnClickListener(this);
            itemView.radio.setOnClickListener(this);
            itemView.radio.isChecked = paymentMethod.isChecked
            itemView.tv_payment_name.text = paymentMethod.payment
            setPaymentIcon()
            setRadioImg(position)
            /* Glide.with(context).load(paymentMethod.image.icon.httpsImagePath)
                 .into(itemView.iv_payment_img)*/

            if (paymentMethod.fSurcharge.toFloat() > 0.0) {
                itemView.tv_sur_charge.visibility = View.VISIBLE
                itemView.tv_sur_charge.text =
                    context.getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(paymentMethod.fSurcharge.toFloat() / coefficient,decimalNumbers),
                        countryCode
                    )
            }
        }


        private fun setChecked(value: Boolean) {
            //radioButton.isChecked = value
            this.paymentMethod?.isChecked = value
        }

        override fun onClick(v: View?) {
            val adapterPosition = adapterPosition
            if (adapterPosition == checkedPosition) {
                return
            } else {
                // notifyItemChanged(adapterPosition)

                if (checkedPosition != -1) paymentMethods?.get(checkedPosition)?.isChecked = false
                checkedPosition = adapterPosition
                setChecked(true)

                notifyDataSetChanged()
            }

            listener.onPaymentChecked(paymentMethods?.get(adapterPosition)!!)
        }

        private fun setPaymentIcon(){
            when(paymentMethod?.paymentId){
                "12" -> itemView.tv_payment_name.drawableStart = context.resources.getDrawable(R.drawable.ic_k_net)
                "16" -> itemView.tv_payment_name.drawableStart = context.resources.getDrawable(R.drawable.ic_cod)
                "14" -> itemView.tv_payment_name.drawableStart = context.resources.getDrawable(R.drawable.ic_wallet)
                "13" -> itemView.tv_payment_name.drawableStart = context.resources.getDrawable(R.drawable.ic_pay_master_card)
                else -> itemView.tv_payment_name.drawableStart = context.resources.getDrawable(R.drawable.ic_wallet)
            }
        }

        private fun setRadioImg(position: Int){
            if(checkedPosition == position){
                itemView.radio_payment.setImageResource(R.drawable.is_primary_img)
            }else{
                itemView.radio_payment.setImageResource(R.drawable.not_primary_img)
            }
        }
    }


    val selected: PaymentMethod?
        get() = if (checkedPosition != -1 && paymentMethods!=null&& paymentMethods!!.size>0) {
            paymentMethods?.get(checkedPosition)
        } else null


}