package com.tatayab.domain.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.tatayab.domain.State
import com.tatayab.domain.interactor.product.GetSpecificProducts
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.ProductX
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ProductDataSource @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    val options: Map<String, String>,
    private val statLiveData: MutableLiveData<Pair<Int?, State>>,
    val recentView: Boolean = false,
    val productIds: String = ""
) : PageKeyedDataSource<Int, ProductX>() {

    var state: MutableLiveData<Pair<Int?, State>> = MutableLiveData()
    private var retryCompletable: Completable? = null

    @SuppressLint("CheckResult")
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ProductX>
    ) {
        statLiveData.postValue(Pair(first = -1, second = State.LOADING))

        if (recentView) {

            compositeDisposable.add(
                tatayabRepository.getSpecificProducts(
                    "kw",
                    lang_code = "en",
                    pid = productIds,
                    page = 0,
                    items_per_page = 100,
                    action = "list"
                )
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                    .subscribe(
                        { response ->
                            //updateState(Pair(response.total_rows,State.DONE))
                            statLiveData.postValue(
                                Pair(
                                    first = response.total_rows,
                                    second = State.DONE
                                )
                            )
                            callback.onResult(response.products!!, null, null)
                        },
                        {
                            statLiveData.postValue(Pair(first = -1, second = State.ERROR))
                            setRetry(Action { loadInitial(params, callback) })
                        }
                    )
            )


        } else {
            try {
                compositeDisposable.add(
                    tatayabRepository.getProductForCategory(options, 0, params.requestedLoadSize)
                        .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                        .subscribe(
                            { response ->
                                //updateState(Pair(response.total_rows,State.DONE))
                                statLiveData.postValue(
                                    Pair(
                                        first = response.total_rows,
                                        second = State.DONE
                                    )
                                )
                                callback.onResult(response.products!!, null, 1)
                            },
                            {
                                statLiveData.postValue(Pair(first = -1, second = State.ERROR))
                                setRetry(Action { loadInitial(params, callback) })
                            }
                        )
                )
            } catch (e: Exception) {
                Log.e("ex ", e.localizedMessage)

            }
        }

    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ProductX>) {
        statLiveData.postValue(Pair(first = -1, second = State.LOADING))
        // updateState(Pair(-1,State.LOADING))
        try {

            compositeDisposable.add(
                tatayabRepository.getProductForCategory(
                    options,
                    params.key,
                    params.requestedLoadSize
                )
                    .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                    .subscribe(
                        { response ->
                            statLiveData?.postValue(Pair(first = response.total_rows, second = State.DONE))
                            //updateState(Pair(response.total_rows,State.DONE))
                            callback.onResult(
                                response.products!!,
                                params.key + 1
                            )
                        },
                        {
                            statLiveData?.postValue(Pair(first = 1, second = State.EMPTY))
                            setRetry(Action { loadAfter(params, callback) })
                        }
                    )
            )
        } catch (e: Exception) {
            Log.e("ex ", e.localizedMessage)
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ProductX>) {
    }

    private fun updateState(state: Pair<Int?, State>) {
        this.state.postValue(state)
    }

    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(
                retryCompletable!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({}, { error -> Log.e("retry" , error.toString()) })
            )
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}