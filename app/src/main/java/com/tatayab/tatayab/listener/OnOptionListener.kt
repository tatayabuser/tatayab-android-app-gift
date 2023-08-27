package com.tatayab.tatayab.listener

import com.tatayab.model.ProductOptionsDetailed
import com.tatayab.model.Variant


interface OnOptionListener {
    fun onOptionItemClick(optionIndex :Int,optionName:String,variants : List<Variant>)
}