package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductX
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.presentation.product.Constants
import com.tatayab.presentation.product.Constants.CATEGORY
import com.tatayab.presentation.product.Constants.RECENT_VIEW
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListenerInHome
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter
import com.tatayab.tatayab.util.TextUtil
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.block_slide_two.view.*
import kotlinx.android.synthetic.main.block_slide_two.view.tv_description
import kotlinx.android.synthetic.main.block_slide_two.view.tv_see_more
import kotlinx.android.synthetic.main.block_slide_two.view.tv_title
import timber.log.Timber


class ProductSlideTwoViewHolder(private val view: View, private val decimalNumber: Int) :
    RecyclerView.ViewHolder(view) {
    private val title = view.tv_title
    private val description = view.tv_description
    private val see_more = view.tv_see_more

    val recyclerViewProducts: RecyclerView = view.rv_slide_two

    companion object {
        lateinit var layoutManager: LinearLayoutManager
    }

    private lateinit var productSlideTwoAdapter: ProductsAdapter
    //val snapHelper: SnapHelper = MultiSnapHelper()

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
        var currentHeight = (((ViewUtil.getScreenWidth())) * 0.8).toInt() + 80
        if (currentHeight < (380 * context.resources.displayMetrics.density).toInt())
            currentHeight = (380 * context.resources.displayMetrics.density).toInt()

        params?.height = currentHeight
        itemView.layoutParams = params

        val allDescriptions = TextUtil.splitTitle(compositeBlockItem.sectionName)
        try {
            if (compositeBlockItem.sectionName == Constants.RECENT_VIEW) {
                title.text = context.getText(R.string.rencent_view_title)
                description.text = context.getText(R.string.rencent_view_description)
            } else {
                try{
                    title.text = allDescriptions?.get(0) ?: ""
                    if(compositeBlockItem?.subTitle.isNullOrBlank()) {
                        description.text = if (allDescriptions?.size!! > 1) allDescriptions?.get(1) else ""
                    }else{
                        description.text = compositeBlockItem?.subTitle.toString()
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {

        }

        see_more.setSafeOnClickListener {
            if (compositeBlockItem.sectionName == RECENT_VIEW)
                listener.onSeeMoreProduct(
                    RECENT_VIEW,
                    compositeBlockItem.obIds,
                    title.text.toString()
                )
            else
                listener.onSeeMoreProduct(
                    CATEGORY,
                    compositeBlockItem.catId.toString(),
                    title.text.toString()
                )
        }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerViewProducts.setHasFixedSize(false)
        recyclerViewProducts.isNestedScrollingEnabled = false
        recyclerViewProducts.layoutManager = layoutManager
//        if (recyclerViewProducts.onFlingListener == null)
//            snapHelper.attachToRecyclerView(recyclerViewProducts)

        productSlideTwoAdapter = ProductsAdapter(
            listener,
            slideTwo = true,
            multiOffer = false,
            recentView = compositeBlockItem.sectionName == RECENT_VIEW,
            decimalNumbers = decimalNumber
        )

        recyclerViewProducts.adapter = productSlideTwoAdapter
        productSlideTwoAdapter.setData(currencyCode, productList)


        if (compositeBlockItem?.catId != null &&compositeBlockItem.catId > 0 && !productList.isNullOrEmpty()) {
            see_more.visibility = View.VISIBLE
        }else{
            see_more.visibility = View.GONE
        }

        if (compositeBlockItem.isLoaded)
            itemView.setBackgroundColor(context.resources.getColor(R.color.white))
        try {
            if (recyclerViewProducts != null && layoutManager != null) {
                recyclerViewProducts.addOnScrollListener(object :
                    RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        var manager = recyclerViewProducts.layoutManager as LinearLayoutManager;
                        val lastPosition = manager.findLastVisibleItemPosition()
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
            Timber.d("Scroll$e.")

        }
    }
}