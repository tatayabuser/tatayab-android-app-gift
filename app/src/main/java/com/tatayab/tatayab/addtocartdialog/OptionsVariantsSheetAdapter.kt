package com.tatayab.tatayab.addtocartdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.OptionVariant
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOptionSelectedFromSheet
import kotlinx.android.synthetic.main.option_varaint_sheet_item.view.*


class OptionsVariantsSheetAdapter(
    private val listener: OnOptionSelectedFromSheet,
    private val items: List<OptionVariant>,
    private val optionId: Int,
    private val optionPosition: Int
) : RecyclerView.Adapter<OptionsVariantsSheetAdapter.OptionViewHolder>() {

    override fun getItemCount(): Int = items.size ?: 0
    var mSelectedItem = -1

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
         val variant = items.get(position)

        with(holder) {
            bindTo(variant,position)
            variant.let { variant ->
                itemView.setSafeOnClickListener {
                    listener.OnOptionSelected(optionPosition,optionId,variant.id)
                    mSelectedItem = position
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.option_varaint_sheet_item, parent, false)

        return OptionViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner class OptionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val context: Context = view.context
        var variant: OptionVariant? = null
        fun bindTo(variant1: OptionVariant?, position: Int) {
            this.variant = variant1
            try {
                if (position == mSelectedItem) {
                    itemView.background = ContextCompat.getDrawable(context,R.drawable.round_selected_option)
                    view.rb_option_selected.isChecked = true
                } else {
                    itemView.background = ContextCompat.getDrawable(context, R.drawable.round_unselected_option)
                    view.rb_option_selected.isChecked = false
                }
            } catch (e: Exception) {
            }

            view.spinner_option_name.text = variant?.name
//            Glide.with(context)
//                .load(
//                    variant?.image
//                )
//                .apply(getPlaceholder())
//                .into(view.option_image)
            try {
                Picasso.get()
                    .load(variant?.image)
                    .placeholder(R.drawable.default_image2).into(view.option_image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }


}