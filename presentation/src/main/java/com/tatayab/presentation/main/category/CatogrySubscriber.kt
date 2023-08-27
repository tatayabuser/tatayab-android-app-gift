package com.tatayab.presentation.main.category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.CategoryResponse
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver


 class CategoriesSubscriber(private val categoriesLiveData:MutableLiveData<Resource<CategoryResponse>>) :
    DisposableObserver<BaseResponseModel<CategoryResponse>>() {
    override fun onComplete() {
    }
    override fun onNext(t: BaseResponseModel<CategoryResponse>) {
        Log.e("es", "")
        t.data?.let {
            if(it.categories.isNotEmpty())
               this.categoriesLiveData.postValue(Resource(ResourceState.SUCCESS, it))
        }
    }

    override fun onError(e: Throwable) {

        if (e is NoConnectivityException) {
            Log.e("", "222");
        } else {
            categoriesLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }


    }
}
