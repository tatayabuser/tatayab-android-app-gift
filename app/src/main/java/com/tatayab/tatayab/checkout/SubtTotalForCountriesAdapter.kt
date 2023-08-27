package com.tatayab.tatayab.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CheckOutChildModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import kotlinx.android.synthetic.main.item_subtotal_per_country.view.*

class SubtTotalForCountriesAdapter(var currencyCode: String, private  val decimalNumbers: Int) :
    RecyclerView.Adapter<SubtTotalForCountriesAdapter.SubTotalViewHolder>() {

    private var items: ArrayList<CheckOutChildModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTotalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_subtotal_per_country, parent, false)
        return SubTotalViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: SubTotalViewHolder, position: Int) {
        val model = items?.get(position)

        with(holder) {
            bindTo(model)
        }
    }

    fun setData(items: List<CheckOutChildModel>?) {
        this.items = items as ArrayList<CheckOutChildModel>?
        notifyDataSetChanged()
    }


    inner class SubTotalViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val countryIcon = view.item_country_logo
        private val countryName = view.tv_country_name
        private val labelsRecyclerView = view.subTotalRecyclerView


        private var model: CheckOutChildModel? = null
        fun bindTo(model: CheckOutChildModel?) {
            this.model = model
            val context = view.context

            model.let {
                countryName.text = it?.wh_country
//                 Glide.with(context)
//                    .load(it?.wh_flag)
//                    .apply(getPlaceholder())
//                    .into(countryIcon)
                try {
                    Picasso.get()
                        .load(it?.wh_flag)
                        .placeholder(R.drawable.default_image2).into(countryIcon)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }


                it?.labels.let {
                    if(it!= null && it.size > 0){
                        var mCheckOutLabelsAdapter = CheckOutLabelsAdapter(currencyCode,decimalNumbers)
                        labelsRecyclerView.layoutManager = LinearLayoutManager(context)
                        labelsRecyclerView.adapter = mCheckOutLabelsAdapter
                        mCheckOutLabelsAdapter.setData(it)

                    }
                }

            }
        }
    }


}