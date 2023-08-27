package com.tatayab.tatayab.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J)\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010$H\u0002\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\'H\u0016J8\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010$2\u0006\u0010,\u001a\u00020\'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0016\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202J\"\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\'2\u0006\u00105\u001a\u00020\'2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J&\u0010?\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010$H\u0016J8\u0010@\u001a\u00020\u001d2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010$2\u0006\u0010,\u001a\u00020\'2\u0006\u0010A\u001a\u00020\u001f2\b\u0010B\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010C\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010\u001f2\b\u0010E\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020H2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010I\u001a\u00020\u001d2\u0010\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010K\u0018\u00010JH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/tatayab/tatayab/wishlist/WishListFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnWishListListener;", "()V", "listener", "Lcom/tatayab/tatayab/listener/OnCategoryNavigationListener;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "viewModel", "Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;)V", "viewModelFactory", "Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModelFactory$Factory;)V", "wishlistAdapter", "Lcom/tatayab/tatayab/wishlist/WishListProductsAdapter;", "deleteWishItemFromCache", "", "productId", "", "getOptions", "", "Lcom/tatayab/model/OptionsMap;", "selectedOptions", "", "(Ljava/util/Map;)[Lcom/tatayab/model/OptionsMap;", "layoutId", "", "moveToCart", "product", "Lcom/tatayab/model/ProductX;", "options", "index", "image", "Landroid/widget/ImageView;", "notifyHomeWithChanges", "prductID", "newStatues", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onProductClicked", "onProductDelete", "productID", "productWishListId", "onSupplierSelected", "supplier_id", "supplier_name", "onViewCreated", "view", "Landroid/view/View;", "setupViewData", "", "Lcom/tatayab/model/responses/WishListProduct;", "app_developmentDebug"})
public final class WishListFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnWishListListener {
    @javax.inject.Inject
    public com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory.Factory viewModelFactory;
    private com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    public com.tatayab.presentation.wishlist.WishlistFragmentViewModel viewModel;
    private com.tatayab.tatayab.listener.OnCategoryNavigationListener listener;
    private com.tatayab.tatayab.wishlist.WishListProductsAdapter wishlistAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public WishListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.wishlist.WishlistFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wishlist.WishlistFragmentViewModel p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void setupViewData(java.util.List<com.tatayab.model.responses.WishListProduct> data) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onProductDelete(@org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options, int index, @org.jetbrains.annotations.NotNull
    java.lang.String productID, @org.jetbrains.annotations.Nullable
    java.lang.String productWishListId) {
    }
    
    private final void deleteWishItemFromCache(java.lang.String productId) {
    }
    
    @java.lang.Override
    public void onProductClicked(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options) {
    }
    
    private final com.tatayab.model.OptionsMap[] getOptions(java.util.Map<java.lang.String, java.lang.String> selectedOptions) {
        return null;
    }
    
    @java.lang.Override
    public void moveToCart(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options, int index, @org.jetbrains.annotations.Nullable
    android.widget.ImageView image) {
    }
    
    @java.lang.Override
    public void onSupplierSelected(@org.jetbrains.annotations.Nullable
    java.lang.String supplier_id, @org.jetbrains.annotations.Nullable
    java.lang.String supplier_name) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDetach() {
    }
    
    public final void notifyHomeWithChanges(@org.jetbrains.annotations.NotNull
    java.lang.String prductID, boolean newStatues) {
    }
}