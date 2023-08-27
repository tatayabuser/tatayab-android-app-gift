package com.tatayab.domain.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.tatayab.domain.State
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.Order
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class OrdersDataSource @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    private val userId: String,
    private val languageCode: String,
    private val statLiveData: MutableLiveData<Pair<Int, State>>

) : PageKeyedDataSource<Int, Order>() {

    var state: MutableLiveData<Pair<Int,State>> = MutableLiveData()
    //var totalCaptureResultCount = 0
    private var retryCompletable: Completable? = null

    @SuppressLint("CheckResult")
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Order>
    ) {
        statLiveData.postValue(Pair(-1,State.LOADING))
        try {
            compositeDisposable.add(
                tatayabRepository.getUserOrders(userId,0, params.requestedLoadSize, languageCode)
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

                    .subscribe(
                        { response ->
                            updateState(Pair(response.orders.size,State.DONE))
                            statLiveData.postValue(Pair(response.orders.size,State.DONE))
                            callback.onResult(response.orders, null, 1)
                        },
                        {
                            statLiveData.postValue(Pair(-1,State.ERROR))
                            updateState(Pair(-1,State.ERROR))
                            setRetry(Action { loadInitial(params, callback) })
                        }
                    )
            )
        } catch (e: Exception) {
            Log.e("ex ", e.localizedMessage)
        }
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Order>) {
        updateState(Pair(-1,State.LOADING))
        try {
            compositeDisposable.add(
                tatayabRepository.getUserOrders(
                    userId,
                    params.key,
                    params.requestedLoadSize,
                    languageCode
                )
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

                    .subscribe(
                        { response ->
                            updateState(Pair(-1,State.DONE))
                            callback.onResult(
                                response.orders,
                                params.key + 1
                            )
                        },
                        {
                            updateState(Pair(-1,State.ERROR))
                            setRetry(Action { loadAfter(params, callback) })
                        }

                    )
            )
        } catch (e: Exception) {
            Log.e("ex ", e.localizedMessage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Order>) {
    }

    private fun updateState(state: Pair<Int,State>) {
        this.state.postValue(state)
    }


    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}