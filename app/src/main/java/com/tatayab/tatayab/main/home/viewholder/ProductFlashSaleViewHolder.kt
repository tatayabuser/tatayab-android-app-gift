package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductX
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.presentation.product.Constants.FLASH_SALE
import com.tatayab.presentation.product.Constants.RECENT_VIEW
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnProductListenerInHome
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter
import com.tatayab.tatayab.util.TextUtil
import com.tatayab.tatayab.util.ViewUtil
import kotlinx.android.synthetic.main.block_flash_products.view.*
import kotlinx.android.synthetic.main.block_flash_products.view.timer
import kotlinx.android.synthetic.main.block_flash_products.view.tv_see_more
import kotlinx.android.synthetic.main.block_flash_products.view.tv_title
import timber.log.Timber


class ProductFlashSaleViewHolder(
    private val view: View,
    private val decimalNumber: Int,
    time: String = ""
) :
    RecyclerView.ViewHolder(view) {
    private val title = view.tv_title
    private val timer = view.timer
    private val see_more = view.tv_see_more
    val recyclerViewProducts: RecyclerView = view.rv_flash_products

    companion object {
        lateinit var layoutManager: LinearLayoutManager
    }

    private lateinit var productSlideTwoAdapter: ProductsAdapter
    //val snapHelper: SnapHelper = MultiSnapHelper()

    fun bind(
        currencyCode: String,
        listener: OnProductListenerInHome,
        compositeBlockItem: CompositeBlockItem,
        flashTimeLiveData: LiveData<Pair<Boolean, String>>
    ) {

        val context = itemView.context
        var productList: List<ProductX?> = ArrayList()
        productList = compositeBlockItem.productsResponse?.products ?: ArrayList()

        timer.text = compositeBlockItem.reminderTime

        val params = itemView.layoutParams
        var currentHeight = (((ViewUtil.getScreenWidth()))) + 10
        if (currentHeight < (380 * context.resources.displayMetrics.density).toInt())
            currentHeight = (380 * context.resources.displayMetrics.density).toInt()

        params?.height = currentHeight
        itemView.layoutParams = params

        val allDescriptions = TextUtil.splitTitle(compositeBlockItem.sectionName)
        try {
            title.text = allDescriptions?.get(0)
        } catch (e: Exception) {
        }
        if (compositeBlockItem?.catId == null || compositeBlockItem?.catId == 0){
            see_more.visibility = View.GONE
        }else{
            see_more?.visibility = View.VISIBLE
        }
        see_more.setSafeOnClickListener {
            listener.onSeeMoreProduct(
                "action",
                FLASH_SALE,
                title.text.toString()
            )

        }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerViewProducts.setHasFixedSize(false)
        recyclerViewProducts.isNestedScrollingEnabled = false
        recyclerViewProducts.layoutManager = layoutManager

        flashTimeLiveData.observe(context as LifecycleOwner, Observer { flashTime ->
            if (!flashTime.first)
                timer.text = flashTime.second
            //  } else
            //    listener.
        })

        productSlideTwoAdapter = ProductsAdapter(
            listener,
            slideTwo = false,
            multiOffer = false,
            recentView = compositeBlockItem.sectionName == RECENT_VIEW,
            decimalNumbers = decimalNumber
        )

        recyclerViewProducts.adapter = productSlideTwoAdapter
        productSlideTwoAdapter.setData(currencyCode, productList)

        if (compositeBlockItem?.catId != null &&compositeBlockItem.catId != 0 && !productList.isNullOrEmpty())
            see_more.visibility = View.VISIBLE
        else{
            see_more.visibility = View.GONE
        }
//        if (productList.size >= 15)
//            see_more.visibility = View.VISIBLE

        try {
            recyclerViewProducts.addOnScrollListener(object :
                RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val manager = recyclerViewProducts.layoutManager as LinearLayoutManager;
                    val lastPosition = manager.findLastVisibleItemPosition()
                    compositeBlockItem.lastPosition = lastPosition
                }

            })
            if (compositeBlockItem.productsResponse != null && compositeBlockItem.productsResponse?.products != null &&
                compositeBlockItem.productsResponse?.products?.size!! > compositeBlockItem.lastPosition - 1 && compositeBlockItem.lastPosition > 0
            ) {
                recyclerViewProducts.scrollToPosition(compositeBlockItem.lastPosition - 1)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.d("Scroll$e.")

        }
    }
}
