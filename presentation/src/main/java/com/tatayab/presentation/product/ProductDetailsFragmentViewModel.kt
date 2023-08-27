package com.tatayab.presentation.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.product.*
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState

import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.requests.ProductActionRequest
import com.tatayab.model.responses.*
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.product.Constants.COUNTRY_CODE
import com.tatayab.presentation.product.Constants.DESC
import com.tatayab.presentation.product.Constants.POPULARITY
import com.tatayab.presentation.product.Constants.SORT_BY
import com.tatayab.presentation.product.Constants.SORT_ORDER
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ProductDetailsFragmentViewModel @Inject constructor(
    private val getProductDetails: GetProductDetails,
    private val customerAlsoBought: GetAlsoBoughtProducts,
    private val getProductReviews: GetProductReviews,
    private val repository: TatayabRepository,
    private val getAddNotifyMeAction: GetAddNotifyMeAction,
    var productId: String,
    private var languageCode: String

) : BaseViewModel(repository) {

    private val productLiveData = MutableLiveData<Resource<Pair<String, ProductDetailsResponse>>>()
    private val ProductReviewsLiveData = MutableLiveData<Resource<ProductReviewsResponse>>()
    private val customerAlsoBoughtLiveData =
        MutableLiveData<Resource<Pair<String, ProductsListResponse>>>()
    private val addNotifyMeLiveData = MutableLiveData<Resource<NormalResponse>>()

    val getAddNotifyMeLiveData: LiveData<Resource<NormalResponse>>
        get() = addNotifyMeLiveData

    var productReviewsResponse: ProductReviewsResponse? = null

    private val cartCountLiveData = MutableLiveData<Resource<Int>>()


    fun getProductDetails(productUID:String?="") {

        getProductDetails.execute(
            GetProductDetailsSubscriber(),
            GetProductDetails.Params.forProduct(
                productId = productId,
                currencyId = getCurrencyId(),
                languageCode = languageCode,
                countryCode = getCountryCode()
            )
        )

        val parameters: HashMap<String, String> = hashMapOf<String, String>()

        var productID :String= if(productUID.isNullOrBlank())productId else productUID.toString()
        parameters[Constants.PRODUCT_ID] = productID
        parameters[Constants.CURRENCY_ID] = getCurrencyId()
        parameters[Constants.USER_ID] = getUserId()
        parameters[Constants.ACTION] = Constants.LASO_BOUGHT_ACTION
        parameters[Constants.LANG_CODE] = languageCode

        customerAlsoBought.execute(
            GetCustomerAlsoBoughtSubscriber(),
            GetAlsoBoughtProducts.Params.forProduct(
                parameters
            )
        )

        getProductReviews()
    }

    fun getProductReviews() {
        val map = HashMap<String, String>()
        map[SORT_BY] = POPULARITY
        map[SORT_ORDER] = DESC
        map[COUNTRY_CODE] = getCountryCode()
        getProductReviews.execute(
            GetProductReviewsResponseSubscriber(),
            GetProductReviews.Params.forProduct(productId = productId, options = map)
        )
    }

    fun addNotifyMeForProduct(productActionRequest: ProductActionRequest) {
        getAddNotifyMeAction.execute(
            AddNotifyMeForProductSubscriber(),
            GetAddNotifyMeAction.Params.forProduct(productActionRequest)
        )
    }

    fun getProductDetailsLiveData(): MutableLiveData<Resource<Pair<String, ProductDetailsResponse>>> {
        return productLiveData
    }


    fun getAlsoBoughtLiveData(): MutableLiveData<Resource<Pair<String, ProductsListResponse>>> {
        return customerAlsoBoughtLiveData
    }

    fun getCartCountLiveData(): MutableLiveData<Resource<Int>> {
        return cartCountLiveData
    }

    fun getProductReviewstLiveData(): MutableLiveData<Resource<ProductReviewsResponse>> {
        return ProductReviewsLiveData
    }

    override fun onCleared() {
        getProductDetails.dispose()
        customerAlsoBought.dispose()
        getProductReviews.dispose()
        super.onCleared()
    }

    fun isArabicLangauge():Boolean{
        return languageCode.equals("ar",true)
    }

    inner class GetProductDetailsSubscriber() :
        DisposableObserver<ProductDetailsResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: ProductDetailsResponse) {
            Log.e("es", "")
            t.let {
                var currencyCode = getCurrencyCode()
                if(currencyCode.isNullOrBlank()){
                    currencyCode = t?.currency.toString()
                }
                productLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        Pair(currencyCode, t)
                    )
                )
            }
        }


        override fun onError(e: Throwable) {
            productLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )
        }
    }

    inner class GetCustomerAlsoBoughtSubscriber() :
        DisposableObserver<ProductsListResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: ProductsListResponse) {
            Log.e("es", "")
            t.let {
                customerAlsoBoughtLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        Pair(getCurrencyCode(), t)
                    )
                )
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                customerAlsoBoughtLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }



    inner class GetProductReviewsResponseSubscriber() :
        DisposableObserver<ProductReviewsResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: ProductReviewsResponse) {
            Log.e("es", "")
            t.let {
                productReviewsResponse = t
                ProductReviewsLiveData.postValue(Resource(ResourceState.SUCCESS, t))
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                ProductReviewsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }


    inner class AddNotifyMeForProductSubscriber() :
        DisposableObserver<NormalResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: NormalResponse) {
            Log.e("es", "")
            t.let {
                if (it.success == 1)
                    addNotifyMeLiveData.postValue(Resource(ResourceState.SUCCESS, it))
                else
                    addNotifyMeLiveData.postValue(Resource(ResourceState.ERROR, it))
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                ProductReviewsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    inner class CartRemoveSubscriber(private val productId: String) :
        DisposableObserver<Int>() {
        override fun onError(e: Throwable) {
            Log.d("CartRemove/error", e.message.toString())
        }

        override fun onNext(t: Int) {
            cartCountLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = t  // set cart count
                )
            )
        }

        override fun onComplete() {
        }

    }
}
