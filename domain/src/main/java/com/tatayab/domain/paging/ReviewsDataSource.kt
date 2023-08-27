package com.tatayab.domain.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.tatayab.domain.State
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Review
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ReviewsDataSource @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    private val productId :String,
    @Inject val options:HashMap<String,String>
) : PageKeyedDataSource<Int, Review>() {
    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null
    @SuppressLint("CheckResult")

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Review> ) {
        updateState(State.LOADING)
        try {
            compositeDisposable.add(
                tatayabRepository.getProductReviwers(productId,options,0, params.requestedLoadSize)
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

                    .subscribe(
                        { response ->
                            updateState(State.DONE)
                            callback.onResult(response.reviews, null, 1)
                        },
                        {
                            updateState(State.ERROR)
                            setRetry(Action { loadInitial(params, callback) })
                        }
                    )
            )
        }catch (e:Exception){
            Log.e("ex ",e.localizedMessage)
        }
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Review>) {
        updateState(State.LOADING)
        try {
            compositeDisposable.add(
                tatayabRepository.getProductReviwers(productId,
                    options,
                    params.key,
                    params.requestedLoadSize
                )
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                    .subscribe(
                        { response ->
                            updateState(State.DONE)
                            callback.onResult(response.reviews,params.key + 1)

                        },
                        {
                            Log.d("errors in suppliers",it.message.toString())
                            updateState(State.ERROR)
                            setRetry(Action { loadAfter(params, callback) })
                        }
                    )
            )
        }catch (e:Exception){
            Log.e("ex ",e.localizedMessage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Review>) {
    }

    private fun updateState(state: State) {
        this.state.postValue(state)
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}