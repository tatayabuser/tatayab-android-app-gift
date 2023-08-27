package com.tatayab.presentation.filter

import com.tatayab.model.filter.ParentData
import com.tatayab.model.filter.Prices
import com.tatayab.model.filter.SortItem

object FilterFactory {


    private var filterValues: List<ParentData>? = null
    private var filtersMapValues: HashMap<String,String> = hashMapOf()
    private var sortValues: List<SortItem>? = null
    private var price: Prices? = Prices("", "")  // user set
    private var priceRange: Prices? = null // max price from backend
    private var free_deliver: Boolean? = null
    private var discount: Boolean? = null

    @JvmStatic
    fun getSort(list: List<SortItem>?): List<SortItem> {
        return if (sortValues != null) {
            sortValues!!
        } else {
            sortValues = list
            sortValues!!
        }
    }

    @JvmStatic
    fun getFiltersMapValues()= filtersMapValues

    @JvmStatic
    fun setFiltersMapValues(filters:Map<String,String>){
        filtersMapValues = filters as HashMap<String, String>
    }

    @JvmStatic
    fun setSelectedSortOption(id: String , check :Boolean) {
        sortValues?.filter { it.checked }?.takeIf { it.isNotEmpty() }?.map {it.checked = false}
        sortValues?.filter { it.itemId.toString() == id }?.get(0)?.checked = check
    }

    @JvmStatic
    fun getSelectedSortOption():SortItem?
    {
        return if (!sortValues.isNullOrEmpty())
            sortValues?.filter{ it.checked }?.takeIf {it.isNotEmpty() }?.get(0)
        else
            null
    }

    @JvmStatic
    fun getSelectedSortOptionsAsMap(): Map<String, String> {
        val sortOptions = HashMap<String, String>()
        if (!sortValues.isNullOrEmpty()) {
            var sortOption = getSelectedSortOption()?.sortOption.toString()
            var sortType = getSelectedSortOption()?.sortType.toString()
            if (sortOption.isNullOrBlank().not())
                sortOptions["sort_by"] = sortOption
            if (sortType.isNullOrBlank().not())
                sortOptions["sort_order"] =sortType
        }
        return sortOptions
    }

    @JvmStatic
    fun getSelectedFilterOptionsAsMap():Map<String,String>
    {
        val sortOptions =  HashMap<String,String>()
        if (!sortValues.isNullOrEmpty()) {
            sortOptions["sort_by"] = getSelectedSortOption()?.sortOption.toString()
            sortOptions["sort_order"] = getSelectedSortOption()?.sortType.toString()
        }
        return  sortOptions
    }

    @JvmStatic
    fun getFilter(list: List<ParentData>): List<ParentData> {
        return if (filterValues != null) {
            filterValues!!
        } else {
            filterValues = list
            filterValues!!
        }
    }

    @JvmStatic
    fun setPrice(pair: Prices) {
        price = pair
    }

    @JvmStatic
    fun setPriceRange(pair: Prices?) {
        if (priceRange == null)
        priceRange = pair
    }

    @JvmStatic
    fun setFreeDelivery(value: Boolean) {
        free_deliver = value
    }

    @JvmStatic
    fun setDiscount(value: Boolean) {
        discount = value
    }

    @JvmStatic
    fun getFreeDelivery(): Boolean? = free_deliver

    @JvmStatic
    fun getDiscount(): Boolean? = discount


    @JvmStatic
    fun getPrice(): Prices? {
        return price
    }

    @JvmStatic
    fun getPriceRange(): Prices? {
        return priceRange
    }

    @JvmStatic
    fun getFilterValues(): List<ParentData>? {
        return filterValues
    }

    @JvmStatic
    fun setSelectedFilterOption(list: List<ParentData>?) {
        filterValues = list
    }


    @JvmStatic
    fun resetSort() {
        sortValues = null
    }

    @JvmStatic
    fun resetFilter() {
        filterValues = null
        price = null
        free_deliver = null
        priceRange = null
        discount = null
        filtersMapValues.clear()
    }
}