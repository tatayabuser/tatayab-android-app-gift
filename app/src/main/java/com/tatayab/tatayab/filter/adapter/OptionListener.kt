package com.tatayab.tatayab.filter.adapter

import com.tatayab.model.filter.ChildData

interface OptionListener {

    fun selectOption(mChildData : ChildData)
    fun unSelectOption(mChildData : ChildData)
}