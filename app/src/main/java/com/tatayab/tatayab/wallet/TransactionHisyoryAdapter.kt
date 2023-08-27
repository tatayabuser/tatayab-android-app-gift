package com.tatayab.tatayab.wallet

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.TransactionModel
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.fragment_privacy.view.*
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.android.synthetic.main.list_item_address.view.*


class TransactionHisyoryAdapter(
    private val langauge: String
) : RecyclerView.Adapter<TransactionHisyoryAdapter.TrnsactionViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0

    private var items: ArrayList<TransactionModel>? = null


    override fun onBindViewHolder(holder: TrnsactionViewHolder, position: Int) {
        val mTransactionModel = items?.get(position)

        with(holder) {
            bindTo(mTransactionModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrnsactionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)

        return TrnsactionViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: ArrayList<TransactionModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class TrnsactionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val transactionTitle = view.transactionTitle
        private val transactionDate = view.transactionDate
        private val transactionExpireDate = view.transactionExpireDate
        private val transactionState = view.stateTextView
        private val balanceTextView = view.balanceTextView

        var mTransactionModel: TransactionModel? = null
        fun bindTo(mTransactionModel: TransactionModel?) {
            this.mTransactionModel = mTransactionModel
            val context = view.context
            transactionTitle.text = mTransactionModel?.title
            transactionDate.text = mTransactionModel?.date
            if (mTransactionModel?.expiry_date.isNullOrEmpty()) {
                transactionExpireDate.visibility = View.GONE
            } else {
                transactionExpireDate.text = mTransactionModel?.expiry_date
                transactionExpireDate.visibility = View.VISIBLE
            }
            if (mTransactionModel?.operation.equals("-", true)) {
                balanceTextView.setTextColor(context.resources.getColor(R.color.red))
//                balanceTextView.text = mTransactionModel?.operation.plus(mTransactionModel?.amount)
                balanceTextView.text = mTransactionModel?.amount.toString()
            } else {
                balanceTextView.setTextColor(context.resources.getColor(R.color.black))
                balanceTextView.text = mTransactionModel?.amount
            }
            if (mTransactionModel?.status.isNullOrBlank().not()) {
                transactionState.visibility = View.VISIBLE
                transactionState.text = mTransactionModel?.status.toString()
            } else {
                transactionState.visibility = View.GONE
            }


        }
    }


}