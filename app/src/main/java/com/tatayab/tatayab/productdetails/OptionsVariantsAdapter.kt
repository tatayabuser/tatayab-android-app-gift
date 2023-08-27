package com.tatayab.tatayab.productdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Variant
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOptionVariantSelected
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.option_varaint_sheet_item.view.*


class OptionsVariantsAdapter(
    private val listener: OnOptionVariantSelected,
    private val clickOption : Int
) : RecyclerView.Adapter<OptionsVariantsAdapter.OptionViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0

    private var items: ArrayList<Variant>? = null

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
         val variant = items?.get(position)

        with(holder) {
            bindTo(variant)
            variant?.let { variant ->
                itemView.setSafeOnClickListener {
                    listener.onOptionSelected(clickOption,position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.option_varaint_item, parent, false)

        return OptionViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: ArrayList<Variant>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class OptionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.titleTextView
        val context = view.context

        var variant: Variant? = null
        fun bindTo(variant1: Variant?) {
            this.variant = variant1
            view.spinner_option_name.text = variant?.variant_name

            try {
                Picasso.get()
                    .load(variant?.variant_image ?:  variant?.image_pair?.icon?.imagePath)
                    .placeholder(R.drawable.default_image2).into(view.option_image)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
//            Glide.with(context)
//                .load(variant?.variant_image ?:  variant?.image_pair?.icon?.imagePath )
//                .apply(getPlaceholder())
//                .into(view.option_image)
        }
    }


}