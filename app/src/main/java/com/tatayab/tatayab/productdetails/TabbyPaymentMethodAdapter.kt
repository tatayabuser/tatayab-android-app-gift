package com.tatayab.tatayab.productdetails

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.responses.CountryContentModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.item_tabby.view.*
import kotlinx.android.synthetic.main.option_varaint_sheet_item.view.*

class TabbyPaymentMethodAdapter(
    private val decimalNumbers: Int
) :
    RecyclerView.Adapter<TabbyPaymentMethodAdapter.TabbyViewHolder>() {

    var items: ArrayList<CountryContentModel> = ArrayList()
    var isArabicLanguage = false
    var price = 0f
    var currencyCode = ""
    var mTabbyListener: TabbyListener? = null
    override fun onBindViewHolder(holder: TabbyViewHolder, position: Int) {
        holder.bindTo(items.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabbyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tabby, parent, false)
        return TabbyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(
        items: ArrayList<CountryContentModel>,
        price: Float,
        isArabicLanguage: Boolean,
        currencyCode: String,
        mTabbyListener: TabbyListener
    ) {
        this.mTabbyListener = mTabbyListener
        this.items = items
        this.price = price
        this.currencyCode = currencyCode
        this.isArabicLanguage = isArabicLanguage
        notifyDataSetChanged()
    }

    inner class TabbyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val tabbyTitle = view.tabby_way_title
        val tabbyDesc = view.tabby_way_desc
        val tabbyImage = view.tabby_image
        val seeMoreTextView = view.tabby_see_more
        private var mCountryContentModel: CountryContentModel? = null
        fun bindTo(
            mCountryContentModel: CountryContentModel?
        ) {
            this.mCountryContentModel = mCountryContentModel
            val context = view.context
            var quarterOfPrice = 0f
            var finalQuarterPrice = ""
            if (mCountryContentModel?.numberOfPayments != null && mCountryContentModel?.numberOfPayments!! > 0) {
                quarterOfPrice = price / mCountryContentModel?.numberOfPayments!!
                if (quarterOfPrice > 0) {
                    finalQuarterPrice =
                        NumbersUtil.formatNumber(quarterOfPrice, decimalNumbers).toString().plus(currencyCode)
                }
            }

            if (isArabicLanguage) {
                tabbyTitle.text = mCountryContentModel?.title_ar
                tabbyDesc.text = mCountryContentModel?.subTitle_ar.toString()
                if (mCountryContentModel?.numberOfPayments != null && mCountryContentModel?.numberOfPayments!! > 0 && mCountryContentModel?.subTitle_ar?.contains(
                        "*X*"
                    )!!
                ) {
                    tabbyDesc.text =
                        mCountryContentModel?.subTitle_ar?.replace("*X*", finalQuarterPrice)

                    if (mCountryContentModel?.numberOfPayments != null && mCountryContentModel?.numberOfPayments!! > 0) {
                        tabbyDesc.text = tabbyDesc.text.toString()
                            .replace("*Y*", " " + mCountryContentModel?.numberOfPayments + " ")
                    }
                }
            } else {
                tabbyDesc.text = mCountryContentModel?.subTitle_en.toString()
                if (mCountryContentModel?.numberOfPayments != null && mCountryContentModel?.numberOfPayments!! > 0 && mCountryContentModel?.subTitle_ar?.contains(
                        "*X*"
                    )!!
                ) {
                    tabbyDesc.text =
                        mCountryContentModel?.subTitle_en?.replace("*X*", finalQuarterPrice)

                    if (mCountryContentModel?.numberOfPayments != null && mCountryContentModel?.numberOfPayments!! > 0) {
                        tabbyDesc.text = tabbyDesc.text.toString()
                            .replace("*Y*", " " + mCountryContentModel?.numberOfPayments + " ")
                    }
                }

                tabbyTitle.text = mCountryContentModel?.title_en
            }
            seeMoreTextView.setPaintFlags(seeMoreTextView.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
            seeMoreTextView.setOnClickListener {
                if (isArabicLanguage) {
                    if (!mCountryContentModel?.seeMoreUrl_ar.isNullOrEmpty()) {
                        mTabbyListener?.onSeeMoreClicked(mCountryContentModel?.seeMoreUrl_ar!!)
                    }
                } else {
                    if (!mCountryContentModel?.seeMoreUrl_en.isNullOrEmpty()) {
                        mTabbyListener?.onSeeMoreClicked(mCountryContentModel?.seeMoreUrl_en!!)
                    }
                }
            }

            try {
                Picasso.get()
                    .load(mCountryContentModel?.image)
                    .placeholder(R.drawable.default_image2).into(tabbyImage)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
//            Glide.with(context)
//                .load(
//                    mCountryContentModel?.image
//                ).apply(getPlaceholder())
//                .into(tabbyImage)
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

}