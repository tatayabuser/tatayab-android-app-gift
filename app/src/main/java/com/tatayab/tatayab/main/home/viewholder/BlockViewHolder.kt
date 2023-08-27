package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.Banner
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.tatayab.listener.*

class BlockViewHolder(private val view: View, private val decimalNumber: Int) :
    RecyclerView.ViewHolder(view) {
    lateinit var viewHolder: RecyclerView.ViewHolder


    fun bindToSlider(
        blockLayoutResponse: CompositeBlockItem?,
        trendListener: OnTrendListener
    ) {
        viewHolder = SliderViewHolder(view)
        (viewHolder as SliderViewHolder).bind(blockLayoutResponse, trendListener)
    }

    fun bindSlideTwoProducts(
        currencyCode: String,
        compositeBlockItem: CompositeBlockItem?,
        productListener: OnProductListenerInHome
    ) {
        viewHolder = ProductSlideTwoViewHolder(view, decimalNumber)
        if (compositeBlockItem == null) return


        (viewHolder as ProductSlideTwoViewHolder).bind(
            currencyCode,
            productListener,
            compositeBlockItem
        )
    }


    fun bindFlashSaleProducts(
        currencyCode: String,
        compositeBlockItem: CompositeBlockItem?,
        productListener: OnProductListenerInHome,
        flashTimeLiveData: LiveData<Pair<Boolean, String>>
    ) {
        viewHolder = ProductFlashSaleViewHolder(view, decimalNumber)
        if (compositeBlockItem == null) return

        (viewHolder as ProductFlashSaleViewHolder).bind(
            currencyCode,
            productListener,
            compositeBlockItem,
            flashTimeLiveData
        )
    }

    fun bindProducts(
        currencyCode: String,
        compositeBlockItem: CompositeBlockItem?,
        productListener: OnProductListenerInHome
    ) {
        if (compositeBlockItem == null) return

        viewHolder = ProductsViewHolder(view, decimalNumber)
        (viewHolder as ProductsViewHolder).bind(
            currencyCode,
            productListener,
            compositeBlockItem
        )
        //viewHolder.recyclerViewProducts.setRecycledViewPool(viewPool);
    }

    fun bindToOneOffer(
        blockLayoutResponse: List<Banner>?,
        name: String,
        subTitle: String?="",
        trendListener: OnTrendListener
    ) {

        viewHolder = OneOfferViewHolder(view)
        (viewHolder as OneOfferViewHolder).bind(blockLayoutResponse, name,subTitle, trendListener)
    }

    fun bindConcierge(
        blockLayoutResponse: CompositeBlockItem?,
        trendListener: OnConciergeListener
    ) {

        viewHolder = ConciergeViewHolder(view)
        (viewHolder as ConciergeViewHolder).bind(trendListener)
    }
    fun bindToMoreThanOneOffer(
        blockLayoutResponse: List<Banner>?,
        name: String,
        trendListener: OnTrendListener
    ) {
         viewHolder = ThanMoreOneOfferViewHolder(view)
        (viewHolder as ThanMoreOneOfferViewHolder).bind(blockLayoutResponse, name, trendListener)
    }

    fun bindToFreeDelivery(blockLayoutResponse: List<Banner>?, sectionName: String) {
        viewHolder =
            FreeDeliveryViewHolder(view)
        (viewHolder as FreeDeliveryViewHolder).bind(blockLayoutResponse, sectionName)
    }

    fun bindToCategory(
        compositeBlockItem: CompositeBlockItem?,
        categoryListener: OnCategoryListenerInHome,
        seeMoreListener: OnSeeMoreCategoryListener
    ) {
        viewHolder =
            CategoryViewHolder(view)
        (viewHolder as CategoryViewHolder).bind(
            compositeBlockItem,
            seeMoreListener,
            categoryListener
        )
        //viewHolder.recyclerViewCategory.setRecycledViewPool(viewPool);

    }

    fun bindToSupplier(
        compositeBlockItem: CompositeBlockItem?,
        supplierListener: OnSupplierListener,
        seeMoreListener: OnSeeMoreSupplierListener,
        viewPool: RecyclerView.RecycledViewPool
    ) {
        viewHolder = SupplierViewHolder(view)
        (viewHolder as SupplierViewHolder).bind(
            compositeBlockItem,
            supplierListener,
            seeMoreListener
        )
        //viewHolder.recyclerViewSuppliers.setRecycledViewPool(viewPool);

    }


}
