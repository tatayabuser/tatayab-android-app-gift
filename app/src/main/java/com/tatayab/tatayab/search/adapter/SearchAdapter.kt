package com.tatayab.tatayab.search.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.model.SearchProductModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSearchListener
import kotlinx.android.synthetic.main.list_item_search.view.*

class SearchAdapter(
    private val listener: OnSearchListener
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0
    private var searchText: String = ""
    private var searchTextWithHtml: String = ""
    private var searchTextWithHtmlBeforeAndroidN: String = ""

    private var items = ArrayList<SearchProductModel?>()

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        if (items.isNullOrEmpty() || items?.size!! <= position) return
        val product = items?.get(position)

        with(holder) {
            bindTo(product)
            product?.let { product ->
                itemView.setSafeOnClickListener {
                    if (product.product_sku!!.isNotEmpty())
                        listener.onSearchSelected(product.product_sku.toString())
                    else
                        listener.onSearchSelected(product.product_id.toString())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_search, parent, false)

        return SearchViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: List<SearchProductModel?>, searchText: String) {
        this.items.clear()
        this.items.addAll(items)
        this.searchText = searchText
        searchTextWithHtml =
            "<span style=\"background-color:#d6a59e;\"> <b>" + searchText + "</b></span>"
        searchTextWithHtmlBeforeAndroidN = "<font color='#d6a59e'><b>" + searchText + "</b></font>"
        notifyDataSetChanged()
    }


    inner class SearchViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val productImage = view.productImage
        private val soldOutImage = view.soldOutImage
        private val productTitle = view.productTitle
        private val productBrand = view.productBrand
        private var context = view.context

        private var product: SearchProductModel? = null
        fun bindTo(product: SearchProductModel?) {
            this.product = product
            product?.let {
                var productTitleWithHtml = it.title
                var productBrandWithHtml = it.supplier_name

                if (!productTitleWithHtml.isNullOrEmpty()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        productTitleWithHtml =
                            productTitleWithHtml.replace(searchText, searchTextWithHtml, true)
                    } else {
                        productTitleWithHtml.replace(
                            searchText,
                            searchTextWithHtmlBeforeAndroidN,
                            true
                        )
                    }
                }
                if (!productBrandWithHtml.isNullOrEmpty()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        productBrandWithHtml =
                            productBrandWithHtml.replace(searchText, searchTextWithHtml, true)
                    } else {
                        productBrandWithHtml.replace(
                            searchText,
                            searchTextWithHtmlBeforeAndroidN,
                            true
                        )
                    }
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    productTitle.setText(
                        Html.fromHtml(
                            productTitleWithHtml,
                            Html.FROM_HTML_MODE_COMPACT
                        )
                    )
                    productBrand.setText(
                        Html.fromHtml(
                            productBrandWithHtml,
                            Html.FROM_HTML_MODE_COMPACT
                        )
                    );
                } else {
                    productTitle.setText(Html.fromHtml(productTitleWithHtml));
                    productBrand.setText(Html.fromHtml(productBrandWithHtml));
                }
//                Glide.with(context)
//                    .load(it.image)
//                    .apply(
//                        RequestOptions()
//                            .placeholder(R.drawable.logo)
//                            .error(R.drawable.logo)
//                    ).into(productImage)

                try {
                    Picasso.get()
                        .load(it.image)
                        .placeholder(R.drawable.default_image2).into(productImage)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

                if(it?.can_buy == 0){
                    soldOutImage.visibility = View.VISIBLE
                }else{
                    soldOutImage.visibility = View.GONE
                }
            }

        }
    }


}