package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tatayab/tatayab/listener/OnAddressListener;", "", "onAddressSelected", "", "position", "", "userAddress", "Lcom/tatayab/model/requests/AddressRequest;", "onDeleteAddress", "addressId", "", "index", "isPrimary", "isLastAddress", "", "onEditAddress", "onMakeAddressPrimary", "showShouldEditAddressMessage", "app_developmentDebug"})
public abstract interface OnAddressListener {
    
    public abstract void onDeleteAddress(@org.jetbrains.annotations.NotNull
    java.lang.String addressId, int index, @org.jetbrains.annotations.NotNull
    java.lang.String isPrimary, boolean isLastAddress);
    
    public abstract void onEditAddress(@org.jetbrains.annotations.NotNull
    com.tatayab.model.requests.AddressRequest userAddress);
    
    public abstract void onAddressSelected(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.requests.AddressRequest userAddress);
    
    public abstract void onMakeAddressPrimary(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.requests.AddressRequest userAddress);
    
    public abstract void showShouldEditAddressMessage();
}