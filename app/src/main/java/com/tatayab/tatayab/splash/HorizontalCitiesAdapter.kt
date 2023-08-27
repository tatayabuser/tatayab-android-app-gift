package com.tatayab.tatayab.splash


import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.CityModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCityListener
import com.tatayab.tatayab.utils.Constants
import kotlinx.android.synthetic.main.list_item_supported_country.view.country_name
import kotlinx.android.synthetic.main.list_item_supported_country.view.img_logo


class HorizontalCitiesAdapter (
    val cityListener: OnCityListener,
    private val langauge: String,
    private val mcontext:Context
) : RecyclerView.Adapter<HorizontalCitiesAdapter.ViewHolder>() {

    var items: ArrayList<CityModel> = ArrayList()
    var layoutId: Int = R.layout.list_item_supported_city

   var  mPreviousIndex:Int = -1
    var index=-1


    fun setItems(searchedItems: MutableList<CityModel>) {
        if(searchedItems.isNullOrEmpty()) return
        else {
            items = ArrayList(searchedItems)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var country: CityModel
        private val countryName = view.country_name
        private val countryFlag = view.img_logo
        val context = view.context

        fun bind(
            country: CityModel
        ) {
            try {
                this.country = country
                val context = itemView.context
                if (country.name_en.equals(context.getString(R.string.other))) {
                    countryName.text = context.getText(R.string.other)
                    //countryFlag.setImageResource(R.drawable.ic_world)
                    countryFlag.visibility=View.GONE
                } else {

                    if (langauge.equals("ar", true))
                        countryName.text = country?.name_ar
                    else
                        countryName.text = country?.name_en
                    //countryName.text = country.name_en + ""
                    //countryFlag.visibility=View.GONE
//              countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))

                   /* if (TextUtils.isEmpty(country.flag)) {
                        countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
                    } else {
//

                        try {
                            Picasso.get()
                                .load(country.flag)
                                .placeholder(R.drawable.ic_country_logo).into(countryFlag)

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            countryFlag.setImageResource(ImageUtil.getCountryFlagByID(country.code?.toUpperCase()))
                        }
                    }*/
                   /* if (country.isChecked) {
                        countryName.setTextColor(context.resources.getColor(R.color.black))
                        countryFlag.setBackgroundResource(R.drawable.circle_selected)
                        countryName.textSize = 14f
                    } else {
                        countryName.setTextColor(context.resources.getColor(R.color.dark_blue))
                        countryFlag.setBackgroundResource(R.drawable.circle_unselected)
                        countryName.textSize = 11f
                    }*/




                }











                itemView.setSafeOnClickListener {

                    country.isSelected = true

                    index = position
                    notifyDataSetChanged()

                    country?.code?.let {
                        Constants.updateCityCode(country.code!!, context)
                    }
                    country?.city_id?.let {
                        Constants.updateCityId(country.city_id.toString(),context)
                    }

                    cityListener.onCitySelected(country)

                }

                if (index === position) {
                    countryName.setTextColor(context.resources.getColor(R.color.black))
                    countryName.setBackgroundResource(R.drawable.circle_selected)
                    countryName.textSize = 14f
                }else{
                    countryName.setTextColor(context.resources.getColor(R.color.dark_blue))
                    countryName.setBackgroundResource(R.drawable.circle_unselected)
                    countryName.textSize = 11f
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
        /*val countryName: TextView = holder.itemView.findViewById(R.id.country_name)
        val countryFlag: ImageView = holder.itemView.findViewById(R.id.img_logo)

        if(items[position].isSelected){
            countryName.setTextColor(mcontext.resources.getColor(R.color.black))
            countryName.setBackgroundResource(R.drawable.circle_selected)
            countryName.textSize = 14f
        } else {
            countryName.setTextColor(mcontext.resources.getColor(R.color.dark_blue))
            countryName.setBackgroundResource(R.drawable.circle_unselected)
            countryName.textSize = 11f
        }*/
    }

    override fun getItemCount(): Int = if (!items.isNullOrEmpty()) items.size else 0


}
