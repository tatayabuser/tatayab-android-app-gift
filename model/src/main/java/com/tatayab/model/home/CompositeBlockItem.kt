package com.tatayab.model.home

import android.os.Parcelable
import com.tatayab.model.Banner
import com.tatayab.model.responses.*
import kotlinx.android.parcel.Parcelize
import java.lang.Exception

@Parcelize
class CompositeBlockItem : Parcelable {

    var viewTypeLayout: ViewTypeLayout = ViewTypeLayout.SLIDER
    //private set

    var blockLayoutResponse: List<Banner>? = null
    //    private set

    var categoryResponse: ArrayList<CategoryItem>? = null
    // private set

    var productsResponse: ProductsListResponse? = ProductsListResponse(products = listOf())
    // private set


    var suppliersResponse: SuppliersResponse? = null
    //private set

    var sectionName: String = ""
    var subTitle: String? = ""

    var type: String = ""
    var obIds: String? = ""
    var position: Int = 0
    var catId: Int = 0
    var isLoaded: Boolean = false
    var isLoadedNow: Boolean = false
    var lastPosition: Int = 0
    var flashEndTime: Int = 0
    var reminderTime: String? = ""
    var pid: String? = ""

    fun setType(type: String, obIds: String?): ViewTypeLayout {
        this.type = type
        when (type) {
            "short_list" -> return ViewTypeLayout.SLIDE_TWO
            "carousel" -> return ViewTypeLayout.SLIDER
            "original" -> return ViewTypeLayout.FREE_DELIVERY
            "abab_combined" -> {
                if (isMoreThanOneOffer(obIds)) {
                    return ViewTypeLayout.MORE_THAN_ONE_OFFER
                } else {
                    return ViewTypeLayout.ONE_OFFER
                }
            }
            "categories_multicolumn_list" -> return ViewTypeLayout.CATEGORIES
            "products_scroller_advanced" -> return ViewTypeLayout.PRODUCTS
            "flash_sale" -> return ViewTypeLayout.FLASH_SALE
            "our_brands" -> return ViewTypeLayout.SUPPLIER
        }
        return ViewTypeLayout.SLIDE_TWO
    }

    private fun isMoreThanOneOffer(obIds: String?): Boolean {
        obIds?:false
        try {
            val obIdsList = obIds?.split(",")
            return !obIdsList.isNullOrEmpty() && obIdsList.size > 1
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }


    companion object {
//        fun withBlock(
//            blockLayoutResponse: List<Banner>,
//            blocksList: HomeBlocksResponse,
//            catId: String
//        ): CompositeBlockItem {
//            val composite = CompositeBlockItem()
//            composite.blockLayoutResponse = blockLayoutResponse
//            composite.blockLayoutResponse?.catId = catId
//
//            val template = getTypeView(blocksList, List<Banner>)
//            when (template) {
//                "short_list" -> composite.viewTypeLayout = ViewTypeLayout.SLIDE_TWO
//                "carousel" -> composite.viewTypeLayout = ViewTypeLayout.SLIDER
//                "original" -> composite.viewTypeLayout = ViewTypeLayout.FREE_DELIVERY
//                "abab_combined" -> composite.viewTypeLayout = ViewTypeLayout.ONE_OFFER
//                "products_scroller_advanced" -> composite.viewTypeLayout = ViewTypeLayout.PRODUCTS
//            }
//            return composite
//        }
//
//        private fun getTypeView(
//            blocksList: HomeBlocksResponse,
//            blockLayoutResponse: List<Banner>
//        ): String {
//            return blocksList.sections?.filter { it.blockId == blockLayoutResponse.blockId }?.get(0)
//                ?.template.toString()
//        }


        fun withCategory(
            categoryResponse: ArrayList<CategoryItem>,
            blocksList: HomeBlocksResponse,
            key: String
        ): CompositeBlockItem {
            val composite = CompositeBlockItem()
            composite.categoryResponse = categoryResponse
            composite.sectionName = getSectionName(blocksList, key)
            composite.viewTypeLayout = ViewTypeLayout.CATEGORIES
            return composite
        }

        fun withSupplier(
            suppliersResponse: SuppliersResponse,
            blocksList: HomeBlocksResponse,
            key: String
        ): CompositeBlockItem {
            val composite = CompositeBlockItem()
            composite.suppliersResponse = suppliersResponse
            composite.sectionName = getSectionName(blocksList, key)
            composite.viewTypeLayout = ViewTypeLayout.SUPPLIER
            return composite
        }

        private fun getSectionName(
            blocksList: HomeBlocksResponse,
            blockId: String
        ): String {
            return blocksList.sections?.filter { it.blockId == blockId }?.get(0)?.name.toString()
        }
    }

}