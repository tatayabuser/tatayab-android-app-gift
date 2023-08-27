package com.tatayab.presentation.wishlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.tatayab.domain.interactor.wishlist.GetUserWishList
import com.tatayab.domain.interactor.wishlist.WishListActions
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.WishItem
import com.tatayab.model.requests.WishListActionRequest
import com.tatayab.model.responses.AddToWishListResponse
import com.tatayab.model.responses.WishListProduct
import com.tatayab.model.responses.WishListResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject

private const val PAGE_SIZE = 10

class WishlistFragmentViewModel @Inject constructor(
    private val repository: TatayabRepository,
    private val removeFromWishList: WishListActions,
    private val getUserWishList: GetUserWishList,
    private val languageCode: String
) : BaseViewModel(repository) {

    private val compositeDisposable = CompositeDisposable()

    val totalRowsLiveData = MutableLiveData<Pair<Boolean, Int>>()

    private val wishListLiveData = MutableLiveData<Resource<List<WishListProduct?>?>>()

    val gettotalRowsWishLoadLiveData: LiveData<Pair<Boolean, Int>>
        get() = totalRowsLiveData

    val getWishListLiveData: LiveData<Resource<List<WishListProduct?>?>>
        get() = wishListLiveData


    val userNotLogin: MutableLiveData<Boolean> = MutableLiveData()

    private val removeFromWishListLiveData = MutableLiveData<Resource<AddToWishListResponse>>()

    val config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)
        .setInitialLoadSizeHint(PAGE_SIZE)
        .setEnablePlaceholders(true)
        .build()

    var userId: MutableLiveData<String> = MutableLiveData()

    val meta = HashMap<String, String>()
    var isGraphEnabled = false

    private fun getWishListID() =
        repository.getUserFromCache().toObservable().map { t -> t.withList_id }.blockingSingle()


    fun getWishList() {

        if (!isUserLogin(isGraphEnabled))
            userNotLogin.postValue(false)
        else {
            val addToWishListRequest = WishListActionRequest(
                userId = repository.getUserFromCache().toObservable()
                    .map { t -> t.user_id.toString() }.blockingSingle()!!,
                action = "list",
                lang_code = languageCode,
                country_code = getCountryCode(),isGraphEnable = isGraphEnabled
            )
            wishListLiveData.postValue(Resource(ResourceState.LOADING))
            getUserWishList.execute(
                GetWishListSubscriber(),
                GetUserWishList.Params.forUser(
                    addToWishListRequest
                )
            )
        }
    }

    val getRemoveFromWishListLiveData: LiveData<Resource<AddToWishListResponse>>
        get() = removeFromWishListLiveData


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun deleteWishListItem(
        options: Map<String, String>?,
        index: Int, productID: String, productWishListId: String?
    ) {
        removeFromWishListLiveData.postValue(Resource(status = ResourceState.LOADING))

        val userId =
            repository.getUserFromCache().toObservable().map { t -> t.user_id }.blockingSingle()
        val request = WishListActionRequest(
            product_id = productID,
            product_options = options,
            userId = userId.toString(),
            country_code = getCountryCode(),
            lang_code = languageCode,
            action = "delete",
            sku = productID,
            wishListId = if(MemoryCacheManager.getUserData()?.withList_id.isNullOrBlank()) getWishListID() else MemoryCacheManager.getUserData()?.withList_id,
            productWishListId = productWishListId,isGraphEnable = isGraphEnabled
        )

        removeFromWishList.execute(
            AddToWishListSubscriber(index, productID),
            WishListActions.Params.forProduct(request)
        )
    }

    inner class AddToWishListSubscriber(private val position: Int, private val productId: String) :
        DisposableObserver<AddToWishListResponse>() {
        override fun onError(e: Throwable) {
            removeFromWishListLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AddToWishListResponse) {
            Log.d("response", t.toString())
            t.productID = productId
            t.productPosition = position
            removeFromWishListLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = t
                )
            )
        }

        override fun onComplete() {
        }

    }

    fun deleteFromWishListInCache(productId: String): Completable {
        return repository.deleteWishItemFromCache(
            productId,
            getCountryCode()
        )
    }


    fun updateCachedWishList(products: List<WishListProduct?>) {
        removeAllWishListFromCachedForCurrentCountry()
        for (item in products) {
            if (item?.product_id != null)
                insertToWishListInCache(
                    item.product_id
                )
        }

    }

    private fun removeAllWishListFromCachedForCurrentCountry() {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute(Runnable {
            repository.deleteAllWishListForCountryFromCache(getCountryCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { error -> Log.e("WishAction/remove*/", error.toString()) })
        })
    }

    fun insertToWishListInCache(productId: String) {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute(Runnable {
            repository.insertWishItemToChace(
                WishItem(
                    getUserId(),
                    productId,
                    getCountryCode()
                )
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }, { error -> Log.e("WishAction/insert/", error.toString()) })
        })
    }

    inner class GetWishListSubscriber : DisposableObserver<WishListResponse>() {
        override fun onNext(t: WishListResponse) {
            t.let {
                wishListLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS, data = t.products
                    )
                )
            }
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            wishListLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }
}