package com.tatayab.presentation.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tatayab.domain.State
import com.tatayab.domain.interactor.filter.GetFilter
import com.tatayab.domain.interactor.product.GetSpecificProducts
import com.tatayab.domain.paging.ProductDataSource
import com.tatayab.domain.paging.ProductsDataSourceFactory
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.ProductX
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.filter.*
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.filter.FilterFactory
import com.tatayab.presentation.product.Constants.ACTION
import com.tatayab.presentation.product.Constants.LANG_CODE
import com.tatayab.presentation.product.Constants.LIST_ACTION
import com.tatayab.presentation.product.Constants.LIST_GRAPH_ACTION
import com.tatayab.presentation.product.Constants.LIST_GRAPH_ACTION_ID
import com.tatayab.presentation.product.Constants.USER_ID
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import java.util.ArrayList


private const val PAGE_SIZE = 10

class ProductListFragmentViewModel constructor(
    val tatayabRepository: TatayabRepository,
    private val getFilter: GetFilter,
    private val getSpecificProducts: GetSpecificProducts,
    private val categoryId: String,
    private val type: String,
    private val languageCode: String,
    private val graphAction : String
) : BaseViewModel(tatayabRepository) {

    private var userID: String = ""

    init {
        FilterFactory.resetSort()
        FilterFactory.resetFilter()
        userID = getUserId()
    }

    private val sortLiveData = MutableLiveData<List<SortItem>>()
    private val filterLiveData = MutableLiveData<Resource<Pair<List<ParentData>, Prices>>>()
    private val priceRangeLiveData = MutableLiveData<Prices>()
    private val ProductsListResponseLiveData = MutableLiveData<Resource<ProductsListResponse>>()
    var isReseted: Boolean = false

    var selectedParntFilterList: ArrayList<ParentData> = ArrayList()

    private val compositeDisposable = CompositeDisposable()
    private val currency: String = getCurrencyCode()
    val getSortLiveData: MutableLiveData<List<SortItem>>
        get() = sortLiveData

    val getProductsListResponseLiveData: MutableLiveData<Resource<ProductsListResponse>>
        get() = ProductsListResponseLiveData


    val getFilterLiveData: MutableLiveData<Resource<Pair<List<ParentData>, Prices>>>
        get() = filterLiveData

    val getPriceRangeLiveData: LiveData<Prices>
        get() = priceRangeLiveData

    private val config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)
        .setInitialLoadSizeHint(PAGE_SIZE)
        .setEnablePlaceholders(true)
        .build()

    val statLiveData: SingleLiveEvent<Pair<Int?, State>> = SingleLiveEvent<Pair<Int?, State>>()


    private var parameters: HashMap<String, String> =
        hashMapOf<String, String>(type to categoryId, "currency_id" to getCurrencyId())
    private var productsDataSourceFactory =
        ProductsDataSourceFactory(
            tatayabRepository,
            compositeDisposable,
            parameters,
            languageCode,
            userID,
            recentView = false,
            productIds = "",
            statLiveData = statLiveData
        )
    var productsLiveData =
        LivePagedListBuilder<Int, ProductX>(productsDataSourceFactory, config).build()

    var filterKeys: MutableLiveData<HashMap<String, String>> = MutableLiveData()

    fun getState(): LiveData<Pair<Int?, State>> = Transformations.switchMap<ProductDataSource,
            Pair<Int?, State>>(productsDataSourceFactory.productsLiveData, ProductDataSource::state)


    fun loadProducts(type: String, categoryId: String,graphActiond : String) {
        parameters.clear()
        parameters[type] = categoryId
//        parameters[CURRENCY_ID] = getCurrencyId()
        parameters[USER_ID] = userID
        if (type!="action")
        parameters[ACTION] = LIST_ACTION
        parameters[LIST_GRAPH_ACTION] = graphActiond
        parameters[LIST_GRAPH_ACTION_ID] = categoryId
        parameters[LANG_CODE] = languageCode
        if (FilterFactory.getSelectedSortOption() != null)
            parameters.putAll(FilterFactory.getSelectedSortOptionsAsMap())
        parameters.putAll(getFiltersMapValues())

        filterKeys.value = parameters
        productsLiveData = Transformations.switchMap(filterKeys) { input ->
            productsDataSourceFactory =
                ProductsDataSourceFactory(
                    tatayabRepository,
                    compositeDisposable,
                    parameters,
                    languageCode,
                    userID,
                    recentView = false,
                    productIds = "",
                    statLiveData = statLiveData
                )
            LivePagedListBuilder(productsDataSourceFactory, config).build()
        }
    }


    fun getSpecificProductsByIds(productsIds: String) {

        productsLiveData = Transformations.switchMap(filterKeys) { input ->
            productsDataSourceFactory =
                ProductsDataSourceFactory(
                    tatayabRepository,
                    compositeDisposable,
                    parameters,
                    languageCode,
                    userID,
                    recentView = true,
                    productIds = productsIds,
                    statLiveData = statLiveData
                )
            LivePagedListBuilder(productsDataSourceFactory, config).build()

        }
    }


    private fun getFiltersMapValues() = FilterFactory.getFiltersMapValues()
    fun setFiltersMapValues(filters: Map<String, String>) {
        FilterFactory.setFiltersMapValues(filters)
    }


    fun getSortOptions(default: List<SortItem>) {
        sortLiveData.postValue(FilterFactory.getSort(default))
    }

    private fun getSelectedPrices(): Prices? {
        return FilterFactory.getPrice()
    }

    private fun setPricesRange(price: Prices) {
        return FilterFactory.setPriceRange(price)
    }

    fun resetSort() = FilterFactory.resetSort()


    fun getFilterOptions(map: Map<String, String>, withCheckPrev: Boolean = true) {
        try {
            val featureMap = map.toMutableMap()
            featureMap["lang_code"] = languageCode

            if (!withCheckPrev || selectedParntFilterList.isNullOrEmpty()) {
                filterLiveData.postValue(Resource(status = ResourceState.LOADING))
                getFilter.execute(
                    GetFilterSubscriber(),
                    GetFilter.Params.forFilter(featureMap)
                )
            } else
                filterLiveData.postValue(
                    Resource(
                        data = Pair(
                            first = getSelectedFilterOption()!!,
                            second = getSelectedPrices()!!
                        ), status = ResourceState.SUCCESS
                    )
                )

        }catch (e:Exception){
            e.printStackTrace()
        }
    }


    fun setSelectedSortOption(item: SortItem) {
        FilterFactory.setSelectedSortOption(item.itemId.toString(), item.checked)
    }

    fun setSelectedFilterOption(groups: List<ParentData>?) {
        FilterFactory.setSelectedFilterOption(groups)
    }

    fun getSelectedFilterOption(): List<ParentData>? {
        return FilterFactory.getFilterValues()
    }

    fun resetFilter() {
        FilterFactory.resetFilter()
        selectedParntFilterList.clear()
         isReseted = true
        invalidateData()
    }

    private fun invalidateData() {
        productsLiveData.value?.dataSource?.invalidate()
    }

    fun getFilterDataFromResponse(response: FilterResponse): Pair<List<ParentData>, Prices> {
        val groupsData: MutableList<ParentData> = mutableListOf()
        setPricesRange(response.prices)  // that is set in the first time only
        if (isReseted) isReseted = false
        response.let {
            it.features.forEach { filterMap ->
                //val variantItems=it.variants
                val isExistsWithIndex = isFilterExistsInPreviosSelection(filterMap?.featureId!!)
                if (isExistsWithIndex > -1) {
                    filterMap.isSelectedBefore = true
                    val groupItem = ParentData(
                        filterMap?.featureName!!,
                        selectedParntFilterList.get(isExistsWithIndex).id,
                        selectedParntFilterList.get(isExistsWithIndex).items,
                        selectedParntFilterList.get(isExistsWithIndex).selectedItemsCount
                    )
                    groupsData.add(groupItem)

                } else {
                    val childs = filterMap.variants?.map { variant ->
                        ChildData(
                            variant.variantName,
                            variant.variantId,
                            filterMap.featureId,
                            variant.isChecked
                        )
                    }
                    val groupItem = ParentData(
                        filterMap?.featureName!!,
                        filterMap?.featureId!!,
                        childs as ArrayList<ChildData>?,
                        0
                    )
                    groupsData.add(groupItem)

                }

            }
        }
        return Pair(first = groupsData, second = response.prices)
    }

    fun isFilterExistsInPreviosSelection(parentId: String): Int {
        selectedParntFilterList.map {
            if (it.id == parentId && it.selectedItemsCount > 0)
                return selectedParntFilterList.indexOf(it)
        }
        return -1
    }

    inner class GetFilterSubscriber() :
        DisposableObserver<FilterResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: FilterResponse) {
            t.let {
                filterLiveData.postValue(
                    Resource(
                        data = getFilterDataFromResponse(it),
                        status = ResourceState.SUCCESS
                    )
                )
                setPrice(it.prices)
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222")
            } else {
                if (getSelectedFilterOption() != null && getSelectedPrices() != null)
                    filterLiveData.postValue(
                        Resource(
                            data = Pair(
                                first = getSelectedFilterOption()!!,
                                second = getSelectedPrices()!!
                            ), status = ResourceState.SUCCESS
                        )
                    )
            }
        }
    }

    override fun onCleared() {
        getFilter.dispose()
        compositeDisposable.dispose()
        FilterFactory.resetFilter()

        super.onCleared()
    }

    fun setPrice(price: Prices) {
        FilterFactory.setPrice(price)
    }

    fun getFreeDelivery(): Boolean? = FilterFactory.getFreeDelivery()
    fun getDiscount(): Boolean? = FilterFactory.getDiscount()
    fun setFreeDelivery(value: Boolean) {
        FilterFactory.setFreeDelivery(value)
    }

    fun setDiscount(value: Boolean) {
        FilterFactory.setDiscount(value)
    }
}
