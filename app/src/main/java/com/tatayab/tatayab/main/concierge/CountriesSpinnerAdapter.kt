package com.tatayab.tatayab.main.concierge

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import com.tatayab.model.responses.CountryResponse
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.country_spinner_item.view.*

 class CountriesSpinnerAdapter(
    cnt: Context,
    data: List<CountryResponse>
) : ArrayAdapter<CountryResponse>(cnt,0,data) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val country = getItem(position)
        val view =recycledView ?:LayoutInflater.from(context).inflate(
            R.layout.country_spinner_item ,
            parent,
            false
        )
        view.spinner_country_name.text = country?.name
        view.spinner_country_name.gravity=Gravity.CENTER_VERTICAL
        return view
    }

}