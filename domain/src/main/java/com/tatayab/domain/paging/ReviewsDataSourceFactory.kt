package com.tatayab.domain.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Review
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class ReviewsDataSourceFactory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    private val compositeDisposable: CompositeDisposable,
    val productId:String,
    val options:HashMap<String, String>
) : DataSource.Factory<Int, Review>() {

    val reviewsLiveData = MutableLiveData<ReviewsDataSource>()

    override fun create(): DataSource<Int, Review> {
        val dataSource = ReviewsDataSource(tatayabRepository, compositeDisposable,productId,options)
        this.reviewsLiveData.postValue(dataSource)
        return dataSource
    }

}