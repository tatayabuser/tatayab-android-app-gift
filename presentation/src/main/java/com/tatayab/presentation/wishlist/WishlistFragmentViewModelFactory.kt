package com.tatayab.presentation.wishlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.wishlist.GetUserWishList
import com.tatayab.domain.interactor.wishlist.WishListActions
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class WishlistFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    private val removeFromWishList: WishListActions,
    private val getUserWishList: GetUserWishList,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WishlistFragmentViewModel(
            repository,
            removeFromWishList,getUserWishList,languageCode =  languageCode) as T

    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): WishlistFragmentViewModelFactory
    }
}