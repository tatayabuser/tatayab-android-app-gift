package com.tatayab.tatayab.addresses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.responses.SelectCityOrAreaModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.CityListener
import com.tatayab.tatayab.listener.OnAddressListener
import com.tatayab.tatayab.utils.Constants
import kotlinx.android.synthetic.main.fragment_privacy.view.*
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.list_item_address.view.*


class CityAdapter(
    private val listener: CityListener,
    private val langauge: String,
   private val context:Context
) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0

    private var items: ArrayList<SelectCityOrAreaModel>? = null


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
         val city = items?.get(position)

        with(holder) {
            bindTo(city)
            city?.let { city ->
                itemView.city_item.setSafeOnClickListener {
                    if (listener != null) listener.onCitySelected(city)

                    city?.code?.let {
                        Constants.updateCityCode(city.code!!, context)
                    }
                    city?.id?.let {
                        Constants.updateCityId(city.id.toString(),context)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)

        return CityViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: ArrayList<SelectCityOrAreaModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class CityViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.titleTextView

        var city: SelectCityOrAreaModel? = null
        fun bindTo(mSelectCityOrAreaModel: SelectCityOrAreaModel?) {
            this.city = mSelectCityOrAreaModel
            val context = view.context
            if (langauge.equals("ar", true))
                title.text = city?.name_ar
            else
                title.text = city?.name_en

        }
    }


}