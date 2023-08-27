package com.tatayab.tatayab.addtocartdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.Option
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnOptionSelectedFromSheet
import kotlinx.android.synthetic.main.list_item_options_sheet.view.*


//typealias OnProductListener = (productId) -> Unit

class OptionsSheetAdapter(
    private val listener : OnOptionSelectedFromSheet,
    private var items:  List<Option>
) : RecyclerView.Adapter<OptionsSheetAdapter.OptionsViewHolder>() {

     var optionsitems:  List<Option>? = items

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val option = items.get(position)

        with(holder) {
            bindTo(option = option,position = position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_options_sheet, parent, false)
        return OptionsViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(items: List<Option>) {
        this.items = items
        notifyDataSetChanged()
    }


    inner class OptionsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


        private val optionName = view.tv_option_name
        private val rv_options = view.rv_varaints
        //private val image = view.iv_product_img
        //private val amountCounter = (view.tv_quantity_value as ValueCounterView)


        fun bindTo(option: Option?,position: Int) {
            val context = view.context
            if (option?.isSelected!!)
                optionName.setTextColor(context.resources.getColor(R.color.dark_blue) )

            optionName.text = option?.name
            var variantsSheetAdapter :OptionsVariantsSheetAdapter? = null
            if (option?.variants != null)
              variantsSheetAdapter  = OptionsVariantsSheetAdapter(listener,option.variants,option.id,position)
            rv_options.adapter = variantsSheetAdapter
        }

    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }


}