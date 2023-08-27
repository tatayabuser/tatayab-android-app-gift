package com.tatayab.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.addreview.AddReviewToProduct
import com.tatayab.domain.interactor.auth.Login
import com.tatayab.domain.interactor.auth.Logout
import com.tatayab.domain.interactor.auth.UpdateUserTokenWithLangaugAndCountryExecution
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.main.CountryCurrencyExecution
import com.tatayab.domain.interactor.product.ProductGiftUserCase
import com.tatayab.domain.interactor.productotions.GetProductOptions
import com.tatayab.domain.interactor.user.*
import com.tatayab.domain.interactor.wallet.GetWalletExecution
import com.tatayab.domain.interactor.wishlist.WishListActions
import com.tatayab.domain.repository.TatayabRepository


@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory @AssistedInject constructor(
    private val addOrderToCart: AddOrderToCart,
    private val wishListActions: WishListActions,
    private val mGetOrdersCountInCartExecute: GetOrdersCountInCartExecute,
    private val clearCachedAndRemoteCart: ClearCachedAndRemoteCart,
    private val repository: TatayabRepository,
    private val setFirebaseToken: SetFirebaseToken,
    private val getGeneratedToken: GetGeneratedToken,
    private val mExtractDeepLinkExecution: ExtractDeepLinkExecution,
    private val addReview: AddReviewToProduct,
    private val getProductOptions: GetProductOptions,
    private val mPromotionExecution: PromotionExecution,
    private val mCountryExecution: GetCountries,
    private val mSaveCountryExecution: SaveCountryExecution,
    private val mUpdateUserTokenWithLangaugAndCountryExecution: UpdateUserTokenWithLangaugAndCountryExecution,
    private val mProductGiftUserCase: ProductGiftUserCase,
    private val mSaveCurrentLangauge: SaveCurrentLangauge,
    private val mCreateUserCartExecution: CreateUserCartExecution,
    private val mCreateGuestCartExecution: CreateGuestCartExecution,
    private val mAddItemToCartQueryCartExecution: AddItemToCartQueryCartExecution,
    private val login: Login,
    private val mRestoreCartExecution: RestoreCartExecution,
    private val mMergeCartsExecution: MergeCartsExecution,
    private val mCountryCurrencyExecution: CountryCurrencyExecution,
    private val mGetWalletExecution: GetWalletExecution,
    private val logout: Logout,
    @Assisted val languageCode:String,
    private val mCheckTokenExecution: CheckTokenExecution

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

         val t = MainActivityViewModel(
            addOrderToCart,
            wishListActions,
            mGetOrdersCountInCartExecute,
            clearCachedAndRemoteCart,
            repository,
            setFirebaseToken,
            getGeneratedToken,
            mExtractDeepLinkExecution,
            addReview,
            getProductOptions,
            mPromotionExecution,
            mCountryExecution,
            mSaveCountryExecution,
            mUpdateUserTokenWithLangaugAndCountryExecution,
             mProductGiftUserCase,
            mSaveCurrentLangauge,
             mCreateUserCartExecution,
             mCreateGuestCartExecution,
             mAddItemToCartQueryCartExecution,login,mRestoreCartExecution,mMergeCartsExecution,mCountryCurrencyExecution
           ,mGetWalletExecution,logout, languageCode,mCheckTokenExecution
        ) as T

        return t
     }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): MainActivityViewModelFactory
    }
}

