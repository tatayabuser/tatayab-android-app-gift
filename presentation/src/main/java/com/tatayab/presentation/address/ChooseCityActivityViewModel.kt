package com.tatayab.presentation.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tatayab.model.responses.*
import javax.inject.Inject

class ChooseCityActivityViewModel @Inject constructor() : ViewModel() {

    private val itemsFilterLiveData = MutableLiveData<ArrayList<SelectCityOrAreaModel>>()
    private val itemsLiveData = MutableLiveData<ArrayList<SelectCityOrAreaModel>>()

    val getItemsFilterLiveData: LiveData<ArrayList<SelectCityOrAreaModel>>
        get() = itemsFilterLiveData

    val getItemsLiveData: LiveData<ArrayList<SelectCityOrAreaModel>>
        get() = itemsLiveData


    fun getListAfterFilteration(items: ArrayList<SelectCityOrAreaModel>, filterText: String) {
        var filterItems: ArrayList<SelectCityOrAreaModel> = ArrayList<SelectCityOrAreaModel>()

        items.let {
            items.forEach {
                if (it.name_ar?.contains(filterText)!! || it.name_en?.contains(
                        filterText,
                        true
                    )!!
                ) {
                    filterItems.add(it)
                }
            }
        }
        itemsFilterLiveData.postValue(filterItems)

    }

    fun getItems(
        citiesList: List<CityModel>?,
        areaList: List<AreaModel>?
    ) {
        var items: ArrayList<SelectCityOrAreaModel> = ArrayList<SelectCityOrAreaModel>()

        if (citiesList != null && citiesList!!.size > 0) {
            citiesList!!.forEach {
                items.add(SelectCityOrAreaModel(id= it.city_id,areaCount= it.area_count!!,code=it?.code, name_en = it.name_en, name_ar = it.name_ar))
            }
        } else if (areaList != null && areaList!!.size > 0) {
            areaList!!.forEach {
                items.add(SelectCityOrAreaModel(id=it.area_id, areaCount = 0, code = it?.code, name_en = it.name_en,name_ar= it.name_ar))
            }
        }

        itemsLiveData.postValue(items)
    }


}
