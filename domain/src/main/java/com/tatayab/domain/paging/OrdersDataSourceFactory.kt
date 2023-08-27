package com.tatayab.domain.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tatayab.domain.State
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.Order
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject



class OrdersDataSourceFactory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    private val userId: String,
    private val languageCode: String,
    private val statLiveData: MutableLiveData<Pair<Int, State>>

) : DataSource.Factory<Int, Order>() {

    val ordersLiveData = MutableLiveData<OrdersDataSource>()

    override fun create(): DataSource<Int, Order> {
        val dataSource = OrdersDataSource(tatayabRepository, compositeDisposable,userId,languageCode,statLiveData)
        this.ordersLiveData.postValue(dataSource)
        return dataSource
    }
}