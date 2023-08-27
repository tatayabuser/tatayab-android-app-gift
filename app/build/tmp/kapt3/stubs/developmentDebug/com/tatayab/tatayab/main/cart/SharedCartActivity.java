package com.tatayab.tatayab.main.cart;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u00104\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000206\u0018\u0001052\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\fH\u0002J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u000206H\u0002J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020<H\u0002J \u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0@2\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0@H\u0002J\u0006\u0010B\u001a\u00020<J\u0012\u0010C\u001a\u00020<2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\b\u0010F\u001a\u00020<H\u0002J\b\u0010G\u001a\u00020<H\u0002J\u0012\u0010H\u001a\u00020<2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R \u0010+\u001a\b\u0012\u0004\u0012\u00020(0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001a\u0010.\u001a\u00020/X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006K"}, d2 = {"Lcom/tatayab/tatayab/main/cart/SharedCartActivity;", "Lcom/tatayab/tatayab/base/BaseActivity2;", "()V", "cartAdapter", "Lcom/tatayab/tatayab/main/cart/SharedCartAdapter;", "cartViewModelFactory", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;", "getCartViewModelFactory", "()Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;", "setCartViewModelFactory", "(Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;)V", "currentCartProducts", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CartOrderResponse;", "Lkotlin/collections/ArrayList;", "getCurrentCartProducts", "()Ljava/util/ArrayList;", "setCurrentCartProducts", "(Ljava/util/ArrayList;)V", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "mergeItemPosition", "", "getMergeItemPosition", "()I", "setMergeItemPosition", "(I)V", "sharedCartModel", "Lcom/tatayab/model/ShareCartListModel;", "sharedProductsList", "Lcom/tatayab/model/ProductX;", "getSharedProductsList", "setSharedProductsList", "sharedProductsListDummy", "getSharedProductsListDummy", "setSharedProductsListDummy", "viewModel", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;)V", "convertObjectToHashMap", "", "", "options", "Lcom/tatayab/model/responses/SelectedOptionModel;", "getItemPositionFromsharedProductsList", "productId", "handelErrorUI", "", "handleShareCartDeeplink", "initView", "mergeWithShardCart", "", "newProductList", "onContinueButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startClearLogic", "startMergeCart", "updateView", "data", "Lcom/tatayab/model/responses/ProductsListResponse;", "app_developmentDebug"})
public final class SharedCartActivity extends com.tatayab.tatayab.base.BaseActivity2 {
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    public com.tatayab.presentation.main.cart.CartFragmentViewModel viewModel;
    private com.tatayab.tatayab.main.cart.SharedCartAdapter cartAdapter;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.responses.CartOrderResponse> currentCartProducts;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.ProductX> sharedProductsList;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.ProductX> sharedProductsListDummy;
    private int mergeItemPosition = 0;
    @javax.inject.Inject
    public com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory cartViewModelFactory;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    private com.tatayab.model.ShareCartListModel sharedCartModel;
    private java.util.HashMap _$_findViewCache;
    
    public SharedCartActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.cart.CartFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.CartFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.responses.CartOrderResponse> getCurrentCartProducts() {
        return null;
    }
    
    public final void setCurrentCartProducts(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.responses.CartOrderResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.ProductX> getSharedProductsList() {
        return null;
    }
    
    public final void setSharedProductsList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.ProductX> getSharedProductsListDummy() {
        return null;
    }
    
    public final void setSharedProductsListDummy(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    public final int getMergeItemPosition() {
        return 0;
    }
    
    public final void setMergeItemPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory getCartViewModelFactory() {
        return null;
    }
    
    public final void setCartViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void startClearLogic() {
    }
    
    private final void startMergeCart() {
    }
    
    private final int getItemPositionFromsharedProductsList(java.lang.String productId) {
        return 0;
    }
    
    private final void updateView(com.tatayab.model.responses.ProductsListResponse data) {
    }
    
    private final java.util.List<com.tatayab.model.ProductX> mergeWithShardCart(java.util.List<com.tatayab.model.ProductX> newProductList) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.String> convertObjectToHashMap(java.util.ArrayList<com.tatayab.model.responses.SelectedOptionModel> options) {
        return null;
    }
    
    private final void handleShareCartDeeplink() {
    }
    
    public final void onContinueButtonClicked() {
    }
    
    public final void handelErrorUI() {
    }
}