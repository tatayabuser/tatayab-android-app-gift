package com.tatayab.tatayab.main.cart;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006%"}, d2 = {"Lcom/tatayab/tatayab/main/cart/ReferCartFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "()V", "cartListItems", "", "getCartListItems", "()Ljava/lang/String;", "cartListItems$delegate", "Lkotlin/Lazy;", "currency", "getCurrency", "setCurrency", "(Ljava/lang/String;)V", "viewModel", "Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModel;", "viewModelFactory", "Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModelFactory$Factory;)V", "intComponent", "", "layoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "shareCartToFriends", "shortLink", "userName", "shareCartWithFriend", "userId", "cartItems", "app_developmentDebug"})
public final class ReferCartFragment extends com.tatayab.tatayab.base.BaseFragment2 {
    private com.tatayab.presentation.main.cart.ReferCartFriendViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory.Factory viewModelFactory;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currency;
    private final kotlin.Lazy cartListItems$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public ReferCartFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    private final java.lang.String getCartListItems() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void intComponent() {
    }
    
    public final void shareCartWithFriend(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    java.lang.String cartItems) {
    }
    
    private final void shareCartToFriends(java.lang.String shortLink, java.lang.String userName) {
    }
}