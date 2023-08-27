package com.tatayab.tatayab.splash

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CountryResponse
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCountryListener
import kotlinx.android.synthetic.main.list_item_select_country.view.*
import com.tatayab.tatayab.R
import com.tatayab.tatayab.util.ImageUtil

class CountriesAdapter(
    private var searchedItems: MutableList<CountryResponse>,
    val countryListener: OnCountryListener
) :RecyclerView.Adapter<CountriesAdapter.ViewHolder>(), Filterable {

    private val items = ArrayList(searchedItems)
    var layoutId: Int = com.tatayab.tatayab.R.layout.list_item_select_country
    var currentCountrySelected: CountryResponse? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var country: CountryResponse
        private val countryName = view.country_name
        private val countryFlag = view.list_item_country_logo
        private val selectedCountryRadioButton = view.selectedCountryRadioButton

        fun bind(
            country: CountryResponse/*,
            listener: OnCountryListener*/
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
                countryName.setTextAppearance(context, R.style.textFontBoldStyle);
                selectedCountryRadioButton.visibility = View.VISIBLE
            } else {
                countryName.setTextColor(context.resources.getColor(R.color.dark_blue))
                countryName.textSize = 13f
                selectedCountryRadioButton.visibility = View.GONE
                countryName.setTextAppearance(context, R.style.customFont_gotham_medium);
            }
            itemView.setSafeOnClickListener {
                countryListener.onCountrySelected(country)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchedItems[position])
    }

    override fun getItemCount(): Int = searchedItems.size


    fun setData(items: MutableList<CountryResponse>, country: CountryResponse) {
        this.searchedItems = items
        this.currentCountrySelected = country
        notifyDataSetChanged()
    }

    fun search(s: String?) {
        filter.filter(s?.trim())
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(p0: CharSequence?): FilterResults {
                searchedItems.clear()
                if (p0.isNullOrBlank()) {
                    searchedItems.addAll(items)
                } else {
                    val searchResults = items.filter {
                        it.name!!.contains(p0, true)
                    }
                    searchedItems.addAll(searchResults)
                }
                return filterResults.also {
                    it.count = searchedItems.size
                    it.values = searchedItems
                }
            }


            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                 notifyDataSetChanged()
            }
        }
    }

}
