package com.tatayab.tatayab.listener

import com.tatayab.model.requests.AddressRequest


interface OnAddressListener {
    fun onDeleteAddress(addressId: String,index:Int,isPrimary:String , isLastAddress: Boolean)
    fun onEditAddress(userAddress: AddressRequest)
    fun onAddressSelected(position: Int,userAddress: AddressRequest)
    fun onMakeAddressPrimary(position: Int,userAddress: AddressRequest)
    fun showShouldEditAddressMessage()
}