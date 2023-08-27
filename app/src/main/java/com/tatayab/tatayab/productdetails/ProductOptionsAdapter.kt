package com.tatayab.tatayab.productdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductOptionsDetailed
import com.tatayab.model.responses.ProductOptions
import com.tatayab.model.Variant
import com.tatayab.tatayab.R
import com.tatayab.tatayab.addresses.ChooseCityActivity
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOptionListener
import kotlinx.android.synthetic.main.item_product_options.view.*
import kotlinx.android.synthetic.main.option_varaint_sheet_item.view.*
import timber.log.Timber

class ProductOptionsAdapter(
    private val listener: OnOptionListener
) : RecyclerView.Adapter<ProductOptionsAdapter.ProductViewHolder>() {

    var items: ArrayList<ProductOptions>? = null
    var selectedOptions: HashMap<String, String>? = null

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val option = items?.get(position)

        with(holder) {
            bindTo(option, listener)


            product_option.setSafeOnClickListener {
                if (items?.get(position)?.variants != null)
                    listener.onOptionItemClick(
                        position,
                        items?.get(position)?.option_name!!,
                        items?.get(position)?.variants!!
                    )
            }
            option?.let { product ->
            }
        }
    }

    fun setVariantValue(optionIndex: Int, variantIndex: Int) {
        items?.get(optionIndex)?.isSelected = true
        items?.get(optionIndex)?.selectedIndex = variantIndex
        selectedOptions?.put(items?.get(optionIndex)?.option_id!!, items?.get(optionIndex)?.variants?.get(variantIndex)?.variant_id!!)
        notifyItemChanged(optionIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_options, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(
        items: ArrayList<ProductOptions>,
        options: Map<String, String>? = null
    ) {
        this.items = items
        this.selectedOptions = options as HashMap<String, String>?
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        //  private val product_options = view.options
        val option_title = view.option_title
        val product_option = view.product_option
        val option = view.option
        val option_selected_value = view.option_selected_value
        val option_selected_img = view.option_img
        val dark_view = view.dark_view
        private var options: ProductOptions? = null
        fun bindTo(
            options: ProductOptions?,
            listener: OnOptionListener
        ) {
            this.options = options
            val context = view.context
            selectedOptions?.let {
                if (it.containsKey(options?.option_id)) {
                    options?.isSelected = true
                    options?.selectedIndex =
                        getVariantPosition(
                            it[options?.option_id],
                            options?.variants!!
                    )
                }
            }


            if (options?.isSelected!!) {
                option.visibility = View.VISIBLE
                option_selected_img.visibility = View.VISIBLE
                option_selected_value.text =
                    options.variants.get(options.selectedIndex).variant_name

                try {
                    Picasso.get()
                        .load(options.variants.get(options.selectedIndex).image_pair?.icon?.imagePath)
                        .placeholder(R.drawable.default_image2).into(option_selected_img)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
//                Glide.with(context)
//                    .load(
//                        options.variants.get(options.selectedIndex).image_pair?.icon?.imagePath)
//                    .apply(getPlaceholder())
//                    .into(option_selected_img)
            }
            option_title.text = options.option_name


        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    fun getVariantPosition(variantId: String?, variants: ArrayList<Variant>): Int {
        variants.forEachIndexed { index, variant ->
            if (variant.variant_id == variantId) {
                return index
            }
        }
        return 0
    }

}