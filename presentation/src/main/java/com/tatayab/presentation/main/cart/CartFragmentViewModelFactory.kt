package com.tatayab.presentation.main.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.interactor.user.GetCurrentUser
import com.tatayab.domain.repository.TatayabRepository

class CartFragmentViewModelFactory @AssistedInject constructor(
    private val mUpdateOrderInCart: UpdateCartItemAmount,
    private val mDeleteOrderFromCart: DeleteOrderFromCart,
    private val getCartContent: GetCartContent,
    private val getCurrentUser: GetCurrentUser,
    private val mCashBackExecution: CashBackExecution,
    private val addOrderToCart: AddOrderToCart,
    private val repository: TatayabRepository,
    @Assisted val languageCode:String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartFragmentViewModel(mUpdateOrderInCart,
            mDeleteOrderFromCart,
            getCartContent,getCurrentUser,mCashBackExecution,addOrderToCart,
            repository, languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): CartFragmentViewModelFactory
    }
}