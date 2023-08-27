package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductX
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.presentation.product.Constants
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListenerInHome
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter
import com.tatayab.tatayab.util.TextUtil
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.block_products.view.*
import timber.log.Timber


class ProductsViewHolder(private val view: View, private val decimalNumber: Int) :
    RecyclerView.ViewHolder(view) {
    private val title = view.tv_title
    private val description = view.tv_description
    private val see_more = view.tv_see_more
    val recyclerViewProducts: RecyclerView = view.rv_products

    companion object {
        lateinit var layoutManager: LinearLayoutManager
    }

    private lateinit var productsAdapter: ProductsAdapter

    fun bind(
        currencyCode: String,
        listener: OnProductListenerInHome,
        compositeBlockItem: CompositeBlockItem
    ) {
        val context = itemView.context
        var productList: List<ProductX?> = ArrayList()
        if (!compositeBlockItem.productsResponse?.products.isNullOrEmpty()) {
            productList = compositeBlockItem.productsResponse?.products!!
        }
        val params = itemView.layoutParams

        var currentHeight = (((ViewUtil.getScreenWidth()))) + 10
        if (currentHeight < (300 * context.getResources().displayMetrics.density).toInt())
            currentHeight = (300 * context.getResources().displayMetrics.density).toInt()
        params?.height = currentHeight

        val allDescriptions = TextUtil.splitTitle(compositeBlockItem.sectionName?.trim())
        try {
            title.text = allDescriptions?.get(0)
            description.text = compositeBlockItem.subTitle
        } catch (e: Exception) {
        }

        if (compositeBlockItem?.catId != null &&compositeBlockItem.catId != 0 && !productList.isNullOrEmpty())
            see_more.visibility = View.VISIBLE
        else{
            see_more.visibility = View.GONE
        }

        see_more.setSafeOnClickListener {
            listener.onSeeMoreProduct(
                Constants.CATEGORY,
                compositeBlockItem.catId.toString(),
                allDescriptions?.get(0)
            )
        }

        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerViewProducts.setHasFixedSize(true)
        recyclerViewProducts.isNestedScrollingEnabled = false
        recyclerViewProducts.layoutManager = layoutManager
        productsAdapter = ProductsAdapter(
            listener,
            slideTwo = false,
            multiOffer = true,
            decimalNumbers = decimalNumber
        )
        recyclerViewProducts.adapter = productsAdapter
        productsAdapter.setData(currencyCode, productList)
        try {
            if (recyclerViewProducts != null) {
                recyclerViewProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val lastPosition = layoutManager.findLastVisibleItemPosition()
                        compositeBlockItem?.lastPosition = lastPosition
                    }
                })
                if (compositeBlockItem != null && compositeBlockItem.productsResponse != null && compositeBlockItem?.productsResponse?.products != null &&
                    compositeBlockItem.productsResponse?.products?.size!! > compositeBlockItem?.lastPosition!! - 1 && compositeBlockItem?.lastPosition!! > 0
                ) {
                    recyclerViewProducts.scrollToPosition(compositeBlockItem?.lastPosition!! - 1)
                }
            }
        } catch (e: Exception) {
             e.printStackTrace()
            Timber.d("onScroll$e.")

        }
        /*itemView.setSafeOnClickListener {
            listener.onSupplierSelected(supplier.supplier_id, supplier.name)
        }*/
    }
}