package com.tatayab.tatayab.countries

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.CountryResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCountryListener
import kotlinx.android.synthetic.main.list_item_country.view.*
import android.widget.RadioButton
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.tatayab.util.ImageUtil
import kotlinx.android.synthetic.main.list_item_country.view.country_name
import kotlinx.android.synthetic.main.list_item_select_country.view.*


class CountriesAdapter(private val listener: OnCountryListener ) :

    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    private var items: List<CountryResponse>? = null
    var layoutId: Int = R.layout.list_item_select_country


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    fun setData(items: List<CountryResponse>) {
        this.items = items
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { holder.bind(it, listener) }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var country: CountryResponse
        private val countryName = view.country_name
        private val countryFlag = view.list_item_country_logo
        private val selectedCountryRadioButton = view.selectedCountryRadioButton

        fun bind(
            country: CountryResponse,
            listener: OnCountryListener
        ) {
            this.country = country
            val context = itemView.context
            countryName.text = country.name
            if (TextUtils.isEmpty(country.flag)) {
                countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
            } else {
                try {
                    Picasso.get()
                        .load(country.flag)
                        .placeholder(R.drawable.ic_country_logo).into(countryFlag)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
                }

//                Glide.with(context)
//                    .load(country.flag)
//                    .apply(
//                        RequestOptions()
//                            .placeholder(R.drawable.ic_country_logo)
//                            .error(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
//                    )
//                    .into(countryFlag)
            }

            if (country.isChecked!!) {
                countryName.setTextColor(context.resources.getColor(R.color.black))
                countryName.textSize = 15f
                selectedCountryRadioButton.visibility = View.VISIBLE
                countryName.setTextAppearance(context, R.style.textFontBoldStyle);
            } else {
                countryName.setTextColor(context.resources.getColor(R.color.dark_blue))
                countryName.textSize = 13f
                selectedCountryRadioButton.visibility = View.INVISIBLE
                countryName.setTextAppearance(context, R.style.customFont_gotham_medium);
            }

            itemView.setSafeOnClickListener {
                listener.onCountrySelected(country)
            }


        }
    }
}