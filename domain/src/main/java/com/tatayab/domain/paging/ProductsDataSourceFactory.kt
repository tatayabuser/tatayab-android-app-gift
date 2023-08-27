package com.tatayab.domain.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tatayab.domain.State
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.ProductX
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductsDataSourceFactory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    val options: Map<String, String>,
    val languageCode: String,
    val userId: String,
    val recentView :Boolean = false,
    val productIds :String = "",
    val statLiveData: MutableLiveData<Pair<Int?, State>>
) : DataSource.Factory<Int, ProductX>() {

    val productsLiveData = MutableLiveData<ProductDataSource>()

    override fun create(): DataSource<Int, ProductX> {
        val dataSource = ProductDataSource(tatayabRepository, compositeDisposable,options,statLiveData,recentView,productIds)
        this.productsLiveData.postValue(dataSource)
        return dataSource
    }
}