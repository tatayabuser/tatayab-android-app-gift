package com.tatayab.presentation.main.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.main.GetCategory
import com.tatayab.domain.interactor.main.GetCategoryBanner
import com.tatayab.domain.interactor.main.GetSubCategory
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.CategoryBannerResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.Child
import com.tatayab.model.responses.SubCategoriesResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver

class CategoryFragmentViewModel constructor(
    private val repository: TatayabRepository,
    private var getCategory2: GetCategory,
    private var getSubCategory: GetSubCategory,
    private var mGetCategoryBanner: GetCategoryBanner,
    private val languageCode: String
) : BaseViewModel(repository) {

    private val categoriesLiveData = MutableLiveData<Resource<ArrayList<CategoryItem>>>()
    private val bannersLiveData = MutableLiveData<Resource<CategoryBannerResponse>>()
    private val subCategoriesLiveData =
        MutableLiveData<Resource<ArrayList<SubCategoriesResponse>>>()

    val getBannersLiveData: LiveData<Resource<CategoryBannerResponse>>
        get() = bannersLiveData

    val getCategoriesLiveData: LiveData<Resource<ArrayList<CategoryItem>>>
        get() = categoriesLiveData

    val getSubCategoriesLiveData: LiveData<Resource<ArrayList<SubCategoriesResponse>>>
        get() = subCategoriesLiveData


    init {
       // getCategories()
    }

     fun getCategories(langCode:String) {
         Log.d("TAG", "AmrgetCategories: ${langCode}")
        categoriesLiveData.postValue(Resource(ResourceState.LOADING))
        getCategory2.execute(
            CategoriesSubscriber(),
            GetCategory.Params.forCategory(
                CategoryRequest(
                    country_code = getCountryCode(),
                    lang_code = langCode
                    //lang_code = languageCode
                )
            )
        )
    }

    fun getSubCategories(categoryName : String,cat_Id: String, enableGraph: Boolean) {
        subCategoriesLiveData.postValue(Resource(ResourceState.LOADING))
//        if (!enableGraph) {
//            getCategoryBanner(cat_Id)
//        }
        getSubCategory.execute(
            SubCategoriesSubscriber(categoryName),
            GetSubCategory.Params.forCategory(
                CategoryRequest(
                    country_code = getCountryCode(),
                    lang_code = languageCode,
                    category_id = cat_Id
                )
            )
        )
    }

    fun getCategoryBanner(cat_Id: String) {
        mGetCategoryBanner.execute(
            CategoryBannerSubscriber(cat_Id),
            GetCategoryBanner.Params.forBanner(
                languageCode,
                cat_Id
            )
        )
    }

    inner class CategoryBannerSubscriber(catId: String) :
        DisposableObserver<CategoryBannerResponse>() {
        var categoryId = catId
        override fun onComplete() {
        }

        override fun onNext(it: CategoryBannerResponse) {
            it.data.catId = categoryId
            bannersLiveData.postValue(Resource(ResourceState.SUCCESS, it))
        }

        override fun onError(e: Throwable) {
            bannersLiveData.postValue(Resource(ResourceState.ERROR))
            e.printStackTrace()
        }

    }

    inner class CategoriesSubscriber() :
        DisposableObserver<ArrayList<CategoryItem>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<CategoryItem>) {
            Log.e("es", "")
            t.let {
                categoriesLiveData.postValue(Resource(ResourceState.SUCCESS, it))
            }
        }

        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                categoriesLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }


        }
    }


    inner class SubCategoriesSubscriber(val categoryName: String) :
        DisposableObserver<ArrayList<SubCategoriesResponse>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<SubCategoriesResponse>) {

            /// set all subcategories as childs of first subCategory
//            t.filter { !it.isBanner }.takeIf { !it.isNullOrEmpty() }?.first()?.apply {
//                 childs = t.filter { !it.isBanner }.map {
//                    Child(name = it.name, image_path = it.image_path, category_id = it.category_id, category_uid = it?.category_uid)
//                } as ArrayList<Child>
//            }

            subCategoriesLiveData.postValue(Resource(ResourceState.SUCCESS, t))


//            try {
//                Log.e("es", "")
//
//                t.let {
//                    var lastindex = -1  // first  item without childs to add in it
//                    it.forEach lit@{
//                        if (it.childs.size == 0) {
//                            if (lastindex == -1)
//                                lastindex = t.indexOf(it)
//                            if (t.get(lastindex).childs.size > 0) {
//                                if (t.get(lastindex).childs.contains(
//                                        Child(
//                                            category_id = it.category_id,
//                                            name = it.name,
//                                            image_path = it.image_path
//                                        )
//                                    )
//                                )
//                                    return@lit
//                                else
//                                    lastindex = t.indexOf(it)
//                            }
//
//                            t.get(lastindex).hasSubCat = true
//                            t.get(lastindex).childs.add(
//                                Child(
//                                    category_id = it.category_id,
//                                    name = it.name,
//                                    image_path = it.image_path
//                                )
//                            )
//
//                            if (t.size > 1 && lastindex + 1 != t.size) {
//                                t.subList(lastindex + 1, t.size)
//                                    .takeWhile { it.childs?.size == 0 }
//                                    .forEach {
//                                        t.get(lastindex).childs?.add(
//                                            Child(
//                                                category_id = it.category_id,
//                                                name = it.name,
//                                                image_path = it.image_path
//                                            )
//                                        )
//                                    }
//                            }
//                        }
//                    }
//                    subCategoriesLiveData.postValue(Resource(ResourceState.SUCCESS, it))
//                }
//
//            } catch (e: Exception) {
//                Log.d("parse error", e.toString())
//                subCategoriesLiveData.postValue(
//                    Resource(
//                        ResourceState.ERROR,
//                        message = e.localizedMessage
//                    )
//                )
//            }
        }

        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                subCategoriesLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }


        }
    }

}
