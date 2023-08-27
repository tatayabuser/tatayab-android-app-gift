package com.tatayab.presentation.main.cart

import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.presentation.base.BaseViewModel
import javax.inject.Inject

open class ReferCartFriendViewModel @Inject constructor(
     private val repository: TatayabRepository,
    private val languageCode: String
) : BaseViewModel(repository){

}