package com.tatayab.tatayab.listener

import com.tatayab.model.home.CompositeBlockItem


interface OnBlockLoadListener {
    fun loadBlock(item: CompositeBlockItem,position: Int)
}