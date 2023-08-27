package com.tatayab.presentation.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Review
import com.tatayab.presentation.product.Constants.SORT_BY
import com.tatayab.presentation.product.Constants.SORT_ORDER
import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.Transformations.switchMap
import com.tatayab.domain.paging.ReviewsDataSourceFactory


private const val PAGE_SIZE = 10

class ProductReviewsFragmentViewModel constructor(
    tatayabRepository: TatayabRepository,
    productId: String
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val repositry = tatayabRepository
    private val product = productId

    var filterKeys: MutableLiveData<HashMap<String, String>> = MutableLiveData()

    val meta = HashMap<String, String>()
    val config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)
        .setInitialLoadSizeHint(PAGE_SIZE)
        .setEnablePlaceholders(true)
        .build()

    var reviewsDataSourceFactory: ReviewsDataSourceFactory? = null

    var reviewsLiveData: LiveData<PagedList<Review>>? = null

    fun loadReviews(sorttype: String, sortOrder: String) {

        meta.put(SORT_BY, sorttype)
        meta.put(SORT_ORDER, sortOrder)
        filterKeys.value = meta

        reviewsLiveData = switchMap(filterKeys) { input ->
            reviewsDataSourceFactory =
                ReviewsDataSourceFactory(repositry, compositeDisposable, product, input)
            LivePagedListBuilder(reviewsDataSourceFactory!!, config).build()
        }
    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
