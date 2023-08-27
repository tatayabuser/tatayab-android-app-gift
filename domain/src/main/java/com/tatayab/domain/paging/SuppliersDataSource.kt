package com.tatayab.domain.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.tatayab.domain.State
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Supplier
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SuppliersDataSource @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    private val languageCode: String
) : PageKeyedDataSource<Int, Supplier>() {

    var state: MutableLiveData<State> = MutableLiveData()
    //var totalCaptureResultCount = 0
    private var retryCompletable: Completable? = null
    private val sortedMap:HashMap<String,String> = HashMap<String,String>()
    @SuppressLint("CheckResult")
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Supplier>
    ) {
        updateState(State.LOADING)
        try {
            compositeDisposable.add(
                tatayabRepository.getSuppliers(0, params.requestedLoadSize, languageCode, sortedMap)
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                    .subscribe(
                        { response ->
                            updateState(State.DONE)
                            response.suppliers?.let { callback.onResult(it, null, 1) }
                        },
                        {
                            updateState(State.ERROR)
                            setRetry(Action { loadInitial(params, callback) })
                        }
                    )
            )
        } catch (e: Exception) {
            Log.e("ex ", e.localizedMessage)
        }
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Supplier>) {
        updateState(State.LOADING)
        try {
            compositeDisposable.add(
                tatayabRepository.getSuppliers(
                    params.key,
                    params.requestedLoadSize,
                    languageCode,
                    sortedMap
                )
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                    .subscribe(
                        { response ->
                            updateState(State.DONE)
                            response.suppliers?.let {
                                callback.onResult(
                                    it,
                                    params.key + 1
                                )
                            }
                        },
                        {
                            updateState(State.ERROR)
                            setRetry(Action { loadAfter(params, callback) })
                        }

                    )
            )
        } catch (e: Exception) {
            Log.e("ex ", e.localizedMessage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Supplier>) {
    }

    private fun updateState(state: State) {
        this.state.postValue(state)
    }


    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}