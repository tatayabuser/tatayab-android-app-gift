package com.tatayab.presentation.address

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.address.*
import com.tatayab.domain.interactor.auth.Register
import com.tatayab.domain.interactor.cart.AddBillingAddressToCartExecution
import com.tatayab.domain.interactor.cart.AddGuestEmailToCartExecution
import com.tatayab.domain.interactor.cart.AddShippingAddressToCartExecution
import com.tatayab.domain.repository.TatayabRepository


class AddressFragmentViewModelFactory @AssistedInject constructor(
    private val addAddress: AddAddress,
    private val mGetCities: GetCities,
    private val mGetArea: GetArea,
    private val getAddresses: GetCustomerAddresses,
    private val deleteAddress: DeleteAddress,
    private val repository: TatayabRepository,
    private val selectUserAddress: Register,
    private val getGuestLastAddress: GetGuestLastAddress,
    private val saveGuestAddress: SaveGuestAddress,
    private val mAddShippingAddressToCartExecution: AddShippingAddressToCartExecution,
    private val mAddBillingAddressToCartExecution: AddBillingAddressToCartExecution,
    private val mAddGuestEmailToCartExecution: AddGuestEmailToCartExecution,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddressFragmentViewModel(
            addAddress,
            mGetCities,
            mGetArea,
            getAddresses,
            deleteAddress,
            repository,
            selectUserAddress,
            getGuestLastAddress,
            saveGuestAddress,
            mAddShippingAddressToCartExecution,mAddBillingAddressToCartExecution,mAddGuestEmailToCartExecution,
            languageCode
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): AddressFragmentViewModelFactory
    }
}