package com.tatayab.presentation.orders

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tatayab.domain.State
import com.tatayab.domain.paging.OrdersDataSourceFactory
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.Order
import com.tatayab.presentation.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

private const val PAGE_SIZE = 10

class OrdersFragmentViewModel constructor(
    private val tatayabRepository: TatayabRepository,
    languageCode: String
) : BaseViewModel(tatayabRepository) {

    private val compositeDisposable = CompositeDisposable()

    val statLiveData: MutableLiveData<Pair<Int, State>> = MutableLiveData<Pair<Int, State>>()


    private val ordersDataSourceFactory =
        OrdersDataSourceFactory(
            tatayabRepository, compositeDisposable,
            tatayabRepository.getUserFromCache().toObservable().map { t -> t.user_id.toString() }
                .blockingSingle()!!, languageCode,
            statLiveData
        )

    private val config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)
        .setInitialLoadSizeHint(PAGE_SIZE)
        .setEnablePlaceholders(true)
        .build()

    var ordersLiveData =
        LivePagedListBuilder<Int, Order>(ordersDataSourceFactory, config).build()



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
