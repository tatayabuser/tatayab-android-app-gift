package com.tatayab.presentation.suppliers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import java.lang.Exception

private const val PAGE_SIZE = 500

class SuppliersFragmentViewModel constructor(
    private val tatayabRepository: TatayabRepository,
    private val languageCode: String,
    private val mGetSuppliers: GetSuppliers
) : ViewModel() {
    private val suppliersResponseLiveData = MutableLiveData<Resource<ArrayList<SupplierResponse>>>()

    val getSuppliersResponseLiveData: MutableLiveData<Resource<ArrayList<SupplierResponse>>>
        get() = suppliersResponseLiveData


    fun getSuppliers() {
        try {
            var brandList = suppliersResponseLiveData?.value?.data

            if (brandList.isNullOrEmpty()) {
                getBrandsFromServer()
            } else {
                suppliersResponseLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = brandList
                    )
                )
            }
        } catch (e: Exception) {
            getBrandsFromServer()
        }
    }

    fun getBrandsFromServer() {
        suppliersResponseLiveData.postValue(Resource(ResourceState.LOADING))
        val sortedMap: HashMap<String, String> = HashMap()
        sortedMap.put("sort_by", "position")
        sortedMap.put("sort_order", "desc")

        mGetSuppliers.execute(
            SuppliersSubscriber(),
            GetSuppliers.Params.forCategory(0, PAGE_SIZE, languageCode, sortedMap)
        )
    }


    fun getLangaugeCode(): String {
        return languageCode
    }

    inner class SuppliersSubscriber : DisposableObserver<ArrayList<SupplierResponse>>() {
        override fun onError(e: Throwable) {
            suppliersResponseLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: ArrayList<SupplierResponse>) {
            t.let {
                suppliersResponseLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = t
                    )
                )

            }

        }

        override fun onComplete() {
        }

    }

    override fun onCleared() {
        super.onCleared()
//        compositeDisposable.dispose()
    }

}
