package com.tatayab.tatayab.listener

import com.tatayab.model.responses.CountryResponse


interface OnOptionSelectedFromSheet {

    fun OnOptionSelected(indexPosition : Int ,optionId:Int, varaintId : Int)
}