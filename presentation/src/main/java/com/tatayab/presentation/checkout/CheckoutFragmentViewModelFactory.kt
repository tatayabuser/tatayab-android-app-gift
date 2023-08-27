package com.tatayab.presentation.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.repository.TatayabRepository


class CheckoutFragmentViewModelFactory @AssistedInject constructor(
    private val applyCoupon: AddCouponExecution,
    private val mRemoveCouponExecution: RemoveCouponExecution,
    private val mPaymentMethodExecution: PaymentMethodExecution,
    private val createOrder: CreateOrderExecution,
    private val repository: TatayabRepository,
    private val mCheckoutReviewExecution: CheckoutReviewExecution,
    private val mSetShippingMethodExecution: SetShippingMethodExecution,
    private val mShippingMethodsExecution: ShippingMethodsExecution,
    private val mRestoreCartExecution: RestoreCartExecution,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CheckoutFragmentViewModel(
             applyCoupon,
            mRemoveCouponExecution,
            mPaymentMethodExecution,
            createOrder,
            repository,
            mCheckoutReviewExecution,mSetShippingMethodExecution,mShippingMethodsExecution,
            mRestoreCartExecution,languageCode
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): CheckoutFragmentViewModelFactory
    }
}