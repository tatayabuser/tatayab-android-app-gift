package com.tatayab.presentation.main.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Banner
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.home.ViewTypeLayout
import com.tatayab.model.requests.Action
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.model.responses.SuppliersResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.product.Constants
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(
    private val repository: TatayabRepository,
    private val blocksList: Array<CompositeBlockItem>?,
    private val languageCode: String
) : BaseViewModel(repository) {

    private val blocksLiveData = MutableLiveData<Resource<Pair<String, CompositeBlockItem>>>()
    private val blockLiveData = MutableLiveData<Resource<CompositeBlockItem>>()
    private val updateRecentBlockLiveData = MutableLiveData<Boolean>()
    private val blocksItemsLiveData = MutableLiveData<Resource<List<CompositeBlockItem>>>()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var responseTime: Long = 0
    val getBlocksItemsLiveData: LiveData<Resource<List<CompositeBlockItem>>>
        get() = blocksItemsLiveData
val getUpdateRecentBlockLiveData: MutableLiveData<Boolean>
        get() = updateRecentBlockLiveData

    val getBlocksLiveData: LiveData<Resource<Pair<String, CompositeBlockItem>>>
        get() = blocksLiveData

    val getBlockLiveData: LiveData<Resource<CompositeBlockItem>>
        get() = blockLiveData

    var blocksItems: List<CompositeBlockItem>? = blocksList?.toList()

    fun updateBlocks(blocksItems: List<CompositeBlockItem>){
        this.blocksItems = blocksItems
    }
    init {
        getBlocksData()
    }

   fun getBlocksData(){
        if (!blocksItems.isNullOrEmpty()){
            blocksItems?.let {
                it.forEachIndexed { index, compositeBlockItem ->
                    if (!compositeBlockItem.isLoaded && !compositeBlockItem.isLoadedNow
                    ) {
                        getHomeBlock(
                            compositeBlockItem,
                            index
                        )
                        responseTime = getCurrentTime()
                        compositeBlockItem.isLoadedNow = true
                    }
                }
            }
        }
    }

    fun updateRecentViewBlock(){
        try{
            if(blocksItems.isNullOrEmpty().not()){
                var lastBlock =  blocksItems?.get(blocksItems!!.size-1)
                if(lastBlock?.sectionName.equals(Constants.RECENT_VIEW)){
                    getHomeBlock(
                        lastBlock!!,
                        blocksItems!!.size-1, true
                    )
                    // update adapter
                    updateRecentBlockLiveData?.value = true
                }
            }

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun checkCachTime() {
        try {
            if (isValidCache(responseTime)) {
                blocksItems?.map {
                    it.isLoaded = false
                    it.lastPosition = 0
                }
                if (blocksItems != null && blocksItems!!.isNotEmpty())
                         getHomeBlock(blocksItems?.get(0)!!, 0)
                // get first item
                responseTime = getCurrentTime()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("CheckResult")
    fun getHomeBlock(item: CompositeBlockItem, position: Int, isUpdateRecentView:Boolean? = false) {
       blocksLiveData.postValue(Resource(ResourceState.LOADING))
        item.position = position
        var request: Observable<*>? = null
        when (item.viewTypeLayout) {
            ViewTypeLayout.CATEGORIES -> {
                request = repository.getCategories2(
                    CategoryRequest(
                        country_code = getCountryCode(),
                        lang_code = languageCode,
                        with_images = "1",
                        homepage = "1"
                    )
                )
            }
            ViewTypeLayout.SLIDE_TWO -> {
                request = repository.getSpecificProducts(
                    getCountryCode(),
                    languageCode,
                    Action.list.toString(),
                    100,
                    0,
                    item.pid?:""
                )
            }
            ViewTypeLayout.PRODUCTS -> {
                request = repository.getSpecificProducts(
                    getCountryCode(),
                    languageCode,
                    Action.list.toString(),
                    100,
                    0,
                    item.pid?:""
                )
            }

            ViewTypeLayout.FLASH_SALE -> {
                val parameters: HashMap<String, String> =
                    hashMapOf<String, String>("action" to "flash_sale")
                request = repository.getProductForCategory(
                    parameters,
                    0,
                    15
                )
            }

            ViewTypeLayout.SUPPLIER -> {
                val sortedMap: HashMap<String, String> = HashMap()
                sortedMap["sort_by"] = "position"
                sortedMap["sort_order"] = "desc"
                request = repository.getSuppliers(0, 10, languageCode, sortedMap)
            }

            else -> {
                //// one offer block
                if(item?.obIds.isNullOrBlank().not()) {
                    request =
                        repository.blockLayout(
                            "",
                            item.obIds ?: "",
                            languageCode
                        )
                }
            }
        }

        request?.observeOn(AndroidSchedulers.mainThread())?.subscribeOn(Schedulers.io())
            ?.subscribe({
                when (it) {
                    is List<*> -> {
                        val list = it.filterIsInstance<Banner>()
                       // if (it is List<>)
                        if (!list.isNullOrEmpty())
                            item.blockLayoutResponse = list
                        else
                            item.categoryResponse = it as ArrayList<CategoryItem>?
                    }

                    is ProductsListResponse -> {
                        item.productsResponse = it
                        if (it.fs_end_time != null)
                            item.flashEndTime = it.fs_end_time!!.toInt()
                    }

                    is SuppliersResponse -> {
                        item.suppliersResponse = it
                    }
                    else -> {
                        Log.e("notType", "fff")
                    }
                }

                item.isLoaded = true
                item.isLoadedNow = false
                blockLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = item))
//                if (position < 4)
             getHomeBlock(blocksItems?.get(position + 1)!!, position + 1)

            }, {
                println(".... error : " + it.message)
            })
    }


    fun getCurrentTime(): Long {
        val timePerSecond = System.currentTimeMillis() / 1000
        return timePerSecond
    }

    fun isValidCache(responseTime: Long): Boolean {
        val timePerSecond = System.currentTimeMillis() / 1000
        val different = timePerSecond - responseTime
        val fefteenPerMillSecond = (15 * 60)    // 15 mins
        return different > fefteenPerMillSecond
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
