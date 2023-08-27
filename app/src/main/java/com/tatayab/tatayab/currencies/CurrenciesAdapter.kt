package com.tatayab.tatayab.currencies

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCurrencyListener
import kotlinx.android.synthetic.main.list_item_currency.view.*

class CurrenciesAdapter(private val listener: OnCurrencyListener) :

    RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {
    private var items: List<CurrencyResponse>? = null
    var layoutId:Int=R.layout.list_item_currency

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(parent.inflate(layoutId))
    }

    fun setData(items: List<CurrencyResponse>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { holder.bind(it, listener) }
    }

    override fun getItemCount():Int= items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var currency: CurrencyResponse
        private val currencyname = view.currency_name

        fun bind(
            currency: CurrencyResponse,
            listener: OnCurrencyListener ) {
            this.currency = currency
            val context = itemView.context
            currencyname.text=currency.currency_code
            itemView.selected_currency.isChecked=currency.isChecked!!

            itemView.setSafeOnClickListener {
                if (!itemView.selected_currency.isChecked)
                listener.onCurrencySelected(currency)
            }

            itemView.selected_currency.setSafeOnClickListener {
                    listener.onCurrencySelected(currency)
            }
        }
    }
}