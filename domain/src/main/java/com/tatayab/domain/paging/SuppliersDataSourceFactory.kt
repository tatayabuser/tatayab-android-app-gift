package com.tatayab.domain.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Supplier
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject



class SuppliersDataSourceFactory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    private val languageCode:String

) : DataSource.Factory<Int, Supplier>() {

    val suppliersLiveData = MutableLiveData<SuppliersDataSource>()

    override fun create(): DataSource<Int, Supplier> {
        val dataSource = SuppliersDataSource(tatayabRepository, compositeDisposable,languageCode)
        this.suppliersLiveData.postValue(dataSource)
        return dataSource
    }
}