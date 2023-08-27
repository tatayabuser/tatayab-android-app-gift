package com.tatayab.presentation.search

import android.util.Log
import com.tatayab.domain.interactor.product.GetProductsWithSearch
import com.tatayab.domain.interactor.product.SearchRecommanededProductsListExecution
import com.tatayab.domain.interactor.product.SearchSuggestionListExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.ProductX
import com.tatayab.model.SearchModel
import com.tatayab.model.SearchProductModel
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.model.responses.SearchProductListResponse
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class SearchFragmentViewModel @Inject constructor(
    private val getProductsWithSearch: GetProductsWithSearch,
    private val langCode: String,
    private val repository: TatayabRepository,
    private val mSearchSuggestionListExecution: SearchSuggestionListExecution,
    private val mSearchRecommanededProductsListExecution: SearchRecommanededProductsListExecution
) : BaseViewModel(repository) {

    private var totalProductList: ArrayList<SearchProductModel> = ArrayList<SearchProductModel>()
    private var recomandedProductList: ArrayList<ProductX> = ArrayList<ProductX>()
    private var searchSuggestionsLiveData = SingleLiveEvent<Resource<List<SearchModel>>>()
    private val productsLiveData = SingleLiveEvent<Resource<List<SearchProductModel>>>()
    private val recomandedProductsLiveData = SingleLiveEvent<Resource<List<ProductX>>>()
    val getProductsLiveData: SingleLiveEvent<Resource<List<SearchProductModel>>>
        get() = productsLiveData
    val getRecomandedProductsLiveData: SingleLiveEvent<Resource<List<ProductX>>>
        get() = recomandedProductsLiveData
    val getSearchSuggestionsLiveData: SingleLiveEvent<Resource<List<SearchModel>>>
        get() = searchSuggestionsLiveData

    var isSearchingNow = false
    var pageCount = 0

    fun getSuggestionSections() {
        getSearchSuggestionsListFromCache()
//        getRecomandedProducts()
    }

    fun startSearch(query: String, isFirstLoadForTheText: Boolean, isSaveSearchText: Boolean) {
        if (!isSearchingNow) {
            if (isFirstLoadForTheText) {
                totalProductList.clear()
                pageCount = 0
            }
            productsLiveData.postValue(Resource(ResourceState.LOADING))
            getProductsWithSearch.execute(
                ProductsSubscriber(),
                GetProductsWithSearch.Params.forProduct(query, pageCount, langCode)
            )
            isSearchingNow = true
            if (isSaveSearchText) saveSearchSuggestionTextToCache(query)
        }
    }

    fun getRecomandedProducts() {
        recomandedProductsLiveData.postValue(Resource(ResourceState.LOADING))
        mSearchRecommanededProductsListExecution.execute(
            RecomandedProductsSubscriber(),
            SearchRecommanededProductsListExecution.Params.forSuggestionList(
                langCode
            )
        )
    }


    inner class ProductsSubscriber() :
        DisposableObserver<SearchProductListResponse>() {
        override fun onComplete() {}

        override fun onNext(t: SearchProductListResponse) {
            isSearchingNow = false
            Log.e("curriencies", "")
            t?.let {
                if(it?.status!! >= 1) {
                    it.products?.let {
                        if (it.isNotEmpty())
                            pageCount++

                        totalProductList.addAll(it as Collection<SearchProductModel>)
                        productsLiveData.postValue(
                            Resource(
                                data = totalProductList,
                                status = ResourceState.SUCCESS
                            )
                        )
                    }
                }else{
                    productsLiveData.postValue(
                        Resource(
                            ResourceState.ERROR)
                    )
                }

            }
        }

        override fun onError(e: Throwable) {
            isSearchingNow = false
            if (e is NoConnectivityException) {
                Log.e("curriencieserror", "222");
            } else {
                productsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    inner class RecomandedProductsSubscriber() :
        DisposableObserver<ProductsListResponse>() {
        override fun onComplete() {}

        override fun onNext(t: ProductsListResponse) {
            t.let {
                it.products?.let {
                    recomandedProductList.addAll(it as Collection<ProductX>)
                    recomandedProductsLiveData.postValue(
                        Resource(
                            data = recomandedProductList,
                            status = ResourceState.SUCCESS
                        )
                    )
                }
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("curriencieserror", "222");
            } else {
                recomandedProductsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }


    override fun onCleared() {
        getProductsWithSearch.dispose()
        mSearchSuggestionListExecution.dispose()
        mSearchRecommanededProductsListExecution.dispose()
        super.onCleared()
    }

    fun saveSearchSuggestionTextToCache(searchText: String) {
        repository.saveSearchSuggestionToCache(SearchModel(searchText))
    }

    fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>) {
        repository.saveSearchSuggestionListToCache(suggestionList)
    }

    fun getSearchSuggestionsListFromCache() {
        searchSuggestionsLiveData.postValue(Resource(ResourceState.LOADING))
        mSearchSuggestionListExecution.execute(
            SearchSuggestionListSubscriber(),
            SearchSuggestionListExecution.Params.forSuggestionList(langCode)
        )
    }

    inner class SearchSuggestionListSubscriber() :
        DisposableObserver<List<SearchModel>>() {
        override fun onComplete() {}

        override fun onNext(searSuggestionList: List<SearchModel>) {
            searSuggestionList?.let {
                searchSuggestionsLiveData.postValue(
                    Resource(
                        data = it,
                        status = ResourceState.SUCCESS
                    )
                )
            }
        }

        override fun onError(e: Throwable) {
            searchSuggestionsLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )

        }
    }


}