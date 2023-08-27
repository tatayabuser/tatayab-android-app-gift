package com.tatayab.tatayab.splash

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CountryResponse
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCountryListener
import com.tatayab.tatayab.util.ImageUtil
import kotlinx.android.synthetic.main.list_item_supported_country.view.*
import java.lang.Exception

class HorizontalCountriesAdapter(
    val countryListener: OnCountryListener
) : RecyclerView.Adapter<HorizontalCountriesAdapter.ViewHolder>() {

    var items: ArrayList<CountryResponse> = ArrayList()
    var layoutId: Int = R.layout.list_item_supported_country


    fun setItems(searchedItems: MutableList<CountryResponse>) {
        if(searchedItems.isNullOrEmpty()) return
        else {
            items = ArrayList(searchedItems)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var country: CountryResponse
        private val countryName = view.country_name
        private val countryFlag = view.img_logo

        fun bind(
            country: CountryResponse
        ) {
            try {
                this.country = country
                val context = itemView.context
                if (country.name.equals(context.getString(R.string.other))) {
                    countryName.text = context.getText(R.string.other)
                    countryFlag.setImageResource(R.drawable.ic_world)
                } else {
                    countryName.text = country.name + ""
//              countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))

                    if (TextUtils.isEmpty(country.flag)) {
                        countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
                    } else {
//                        Glide.with(context)
//                            .load(country.flag)
//                            .apply(
//                                RequestOptions()
//                                    .placeholder(R.drawable.ic_country_logo)
//                                    .error(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
//                            )
//                            .into(countryFlag)

                        try {
                            Picasso.get()
                                .load(country.flag)
                                .placeholder(R.drawable.ic_country_logo).into(countryFlag)

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
                        }
                    }
                    if (country.isChecked) {
                        countryName.setTextColor(context.resources.getColor(R.color.black))
                        countryFlag.setBackgroundResource(R.drawable.circle_selected)
                        countryName.textSize = 14f
                    } else {
                        countryName.setTextColor(context.resources.getColor(R.color.dark_blue))
                        countryFlag.setBackgroundResource(R.drawable.circle_unselected)
                        countryName.textSize = 11f
                    }
                }

                countryFlag.setSafeOnClickListener {
                    countryListener.onCountrySelected(country)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = if (!items.isNullOrEmpty()) items.size else 0


}
