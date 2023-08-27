package com.tatayab.tatayab.checkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.AddToWishListResponse
import com.tatayab.model.responses.CheckOutProductsModel
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.tatayab.R
 import com.tatayab.tatayab.listener.OnCheckoutProductSelected
import kotlinx.android.synthetic.main.item_checkout_product_per_country.view.*
import kotlinx.android.synthetic.main.item_subtotal_per_country.view.item_country_logo
import kotlinx.android.synthetic.main.item_subtotal_per_country.view.tv_country_name

class ProductsForCountriesAdapter(
    var listener: OnCheckoutProductSelected,
    var currencyCode: String,
    private val decimalNumbers: Int,
    var getAddToWishListResult: SingleLiveEvent<Resource<AddToWishListResponse>>
) :
    RecyclerView.Adapter<ProductsForCountriesAdapter.ProductViewHolder>() {

    private var items: ArrayList<CheckOutProductsModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_checkout_product_per_country, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = items?.get(position)

        with(holder) {
            bindTo(model)
        }
    }

    fun setData(items: List<CheckOutProductsModel>?) {
        this.items = items as ArrayList<CheckOutProductsModel>?
        notifyDataSetChanged()
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val countryIcon = view.item_country_logo
        private val countryName = view.tv_country_name
        private val deliveryTextView = view.deliveryTextView
        private val productsRecyclerView = view.productsRecyclerView


        private var model: CheckOutProductsModel? = null
        fun bindTo(model: CheckOutProductsModel?) {
            this.model = model
            val context = view.context
            model?.let { it ->
                it?.wh_country?.let {
                    var whList = it?.split("-")
                    if(!whList.isNullOrEmpty() && whList.size == 2){
                        var countryCode = whList.get(0)
                        var countryNameValue =MemoryCacheManager.getCountryNameByCode(countryCode)
                        if(countryNameValue.isNullOrBlank()){
                            countryName.text = it
                        }else{
                            countryName.text = countryNameValue

                        }
                    }else {
                        countryName.text = it
                    }
                }
                if (it?.delivery_msg.isNullOrBlank()){
                    //Expected delivery: 1-3 Days
                    deliveryTextView.text =getDeliveryDate(context ,it?.deliveryFrom.toString() , it?.deliveryTo.toString())
//                    context.getString(R.string.delivery_part_1)+" "+it?.deliveryFrom+"-"+it?.deliveryTo.plus(" ").plus(
//                        context.getString(R.string.delivery_part_3))
                }else {
                    deliveryTextView.text = it?.delivery_msg
                }
                if(MemoryCacheManager?.countriesList.isNullOrEmpty().not() && it?.countryCourseCode.isNullOrBlank().not()){
                    it?.wh_flag = getFlagFromCountries(it?.countryCourseCode)
                }
//                Glide.with(context)
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

                it?.products.let {
                    if (it != null && it.isNotEmpty()) {
                        val mProductsAdapter =
                            ProductsAdapter(
                                listener,
                                currencyCode,
                                decimalNumbers,
                                getAddToWishListResult
                            )
                        productsRecyclerView.layoutManager = LinearLayoutManager(context)
                        productsRecyclerView.adapter = mProductsAdapter
                        mProductsAdapter.setData(it)

                    }
                }

            }
        }
    }
    private fun getDeliveryDate(context: Context, fromDate : String, toDate: String): String {
        var deliveryDate = ""
        try {
            if(fromDate.isNullOrBlank() && toDate.isNullOrBlank().not()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+toDate)
            } else  if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+fromDate)
            }else if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank().not()){
                deliveryDate =  context.getString(R.string.delivery_part_1)
                    .plus(" "+fromDate).plus(" - ").plus(toDate)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return deliveryDate
    }
    private fun getFlagFromCountries(countryCourseCode: String?): String? {
        //					"source_code": "KW-WH"
        var countryCodeSplitList = countryCourseCode?.split("-")
        var countryCode = if(countryCodeSplitList.isNullOrEmpty()) "" else countryCodeSplitList[0]
        MemoryCacheManager?.countriesList?.map {
            if(countryCode.equals(it?.code)){
                return it?.flag
            }
        }
        return ""
    }


}