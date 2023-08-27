package com.tatayab.tatayab.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u00100\u001a\u000201H\u0016J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020OH\u0002J\u0016\u0010S\u001a\u00020L2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020O0\u0006H\u0002J\u0016\u0010U\u001a\u00020L2\f\u0010V\u001a\b\u0012\u0004\u0012\u0002060\u0006H\u0002J\b\u0010W\u001a\u00020LH\u0002J\b\u0010X\u001a\u00020LH\u0002J\b\u0010Y\u001a\u00020.H\u0016J*\u0010Z\u001a\u00020L2\u0006\u0010N\u001a\u00020O2\u0006\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020.2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010_\u001a\u00020LH\u0016J\u0012\u0010`\u001a\u00020L2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020LH\u0016J\b\u0010d\u001a\u00020LH\u0016J\"\u0010e\u001a\u00020L2\u0006\u0010f\u001a\u00020<2\b\u0010g\u001a\u0004\u0018\u00010O2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010e\u001a\u00020L2\u0006\u0010f\u001a\u00020<2\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010h\u001a\u00020L2\u0006\u0010M\u001a\u00020.H\u0016J\b\u0010i\u001a\u00020LH\u0016J \u0010j\u001a\u00020L2\u0006\u0010f\u001a\u00020<2\u0006\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020<H\u0016J\u0010\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020<H\u0016J$\u0010o\u001a\u00020L2\u0006\u0010k\u001a\u00020<2\b\u0010p\u001a\u0004\u0018\u00010<2\b\u0010q\u001a\u0004\u0018\u00010<H\u0016J\b\u0010r\u001a\u00020LH\u0016J\u001a\u0010s\u001a\u00020L2\u0006\u0010t\u001a\u00020u2\b\u0010a\u001a\u0004\u0018\u00010bH\u0017J \u0010v\u001a\u00020L2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u00100\u001a\u000201H\u0016J\u0006\u0010w\u001a\u00020LJ\u0016\u0010x\u001a\u00020L2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010z\u001a\u00020L2\u0006\u0010{\u001a\u00020\rJ\u000e\u0010|\u001a\u00020L2\u0006\u0010{\u001a\u00020\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\'\u001a\u00020(8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006}"}, d2 = {"Lcom/tatayab/tatayab/search/SearchFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/listener/OnSearchListener;", "Lcom/tatayab/tatayab/listener/OnProductListenerInHome;", "()V", "currentProductList", "", "Lcom/tatayab/model/SearchProductModel;", "getCurrentProductList", "()Ljava/util/List;", "setCurrentProductList", "(Ljava/util/List;)V", "isFavoriteIconEvent", "", "isStopPassed", "()Z", "setStopPassed", "(Z)V", "loading", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mRecommendedLayoutManager", "getMRecommendedLayoutManager", "setMRecommendedLayoutManager", "mSearchSuggestionAdapter", "Lcom/tatayab/tatayab/search/adapter/SearchSuggestionAdapter;", "mSuggestionLayoutManager", "getMSuggestionLayoutManager", "setMSuggestionLayoutManager", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "pageCount", "", "pastVisiblesItems", "productsAdapter", "Lcom/tatayab/tatayab/main/home/adapter/ProductsAdapter;", "searchAdapter", "Lcom/tatayab/tatayab/search/adapter/SearchAdapter;", "searchSuggestionTextList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/SearchModel;", "getSearchSuggestionTextList", "()Ljava/util/ArrayList;", "setSearchSuggestionTextList", "(Ljava/util/ArrayList;)V", "searchText", "", "searchviewModelFactory", "Lcom/tatayab/presentation/product/SearchFragmentViewModelFactory$Factory;", "getSearchviewModelFactory", "()Lcom/tatayab/presentation/product/SearchFragmentViewModelFactory$Factory;", "setSearchviewModelFactory", "(Lcom/tatayab/presentation/product/SearchFragmentViewModelFactory$Factory;)V", "totalItemCount", "viewModel", "Lcom/tatayab/presentation/search/SearchFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/search/SearchFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/search/SearchFragmentViewModel;)V", "visibleItemCount", "addToWishlist", "", "position", "product", "Lcom/tatayab/model/ProductX;", "convertProductxToProduct", "Lcom/tatayab/model/Product;", "mProductx", "displayRecomandedProducts", "productsList", "displaySearchSuggestion", "searchSuggestionList", "initRecyclerListener", "initSearchSuggestionRecycler", "layoutId", "onAddToCart", "amount", "maxQty", "image", "Landroid/widget/ImageView;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onProductSelected", "productId", "mProduct", "onRemovedSuggestionClicked", "onResume", "onSearchSelected", "type", "name", "onSearchSuggestionSelected", "searchSuggestionText", "onSeeMoreProduct", "categoryId", "categoryName", "onStop", "onViewCreated", "view", "Landroid/view/View;", "removeFromWishlist", "showKeyBoard", "updateProductListView", "productList", "updateRecommendedProductsVisibility", "visible", "updateSearchSuggestionVisibility", "app_developmentDebug"})
public final class SearchFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.listener.OnSearchListener, com.tatayab.tatayab.listener.OnProductListenerInHome {
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.LinearLayoutManager mRecommendedLayoutManager;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.LinearLayoutManager mSuggestionLayoutManager;
    public com.tatayab.presentation.search.SearchFragmentViewModel viewModel;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    private boolean isFavoriteIconEvent = false;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    @javax.inject.Inject
    public com.tatayab.presentation.product.SearchFragmentViewModelFactory.Factory searchviewModelFactory;
    private com.tatayab.tatayab.search.adapter.SearchAdapter searchAdapter;
    private com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter;
    private com.tatayab.tatayab.search.adapter.SearchSuggestionAdapter mSearchSuggestionAdapter;
    private boolean loading = false;
    private int pastVisiblesItems = 0;
    private int visibleItemCount = 0;
    private int totalItemCount = 0;
    private int pageCount = 0;
    private java.lang.String searchText = "";
    private boolean isStopPassed = false;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.SearchModel> searchSuggestionTextList;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.tatayab.model.SearchProductModel> currentProductList;
    private java.util.HashMap _$_findViewCache;
    
    public SearchFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.recyclerview.widget.LinearLayoutManager getMRecommendedLayoutManager() {
        return null;
    }
    
    public final void setMRecommendedLayoutManager(@org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.recyclerview.widget.LinearLayoutManager getMLayoutManager() {
        return null;
    }
    
    public final void setMLayoutManager(@org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.recyclerview.widget.LinearLayoutManager getMSuggestionLayoutManager() {
        return null;
    }
    
    public final void setMSuggestionLayoutManager(@org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.LinearLayoutManager p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.search.SearchFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.search.SearchFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.product.SearchFragmentViewModelFactory.Factory getSearchviewModelFactory() {
        return null;
    }
    
    public final void setSearchviewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.SearchFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    public final boolean isStopPassed() {
        return false;
    }
    
    public final void setStopPassed(boolean p0) {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRecyclerListener() {
    }
    
    private final void initSearchSuggestionRecycler() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void displayRecomandedProducts(java.util.List<com.tatayab.model.ProductX> productsList) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.SearchModel> getSearchSuggestionTextList() {
        return null;
    }
    
    public final void setSearchSuggestionTextList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.SearchModel> p0) {
    }
    
    private final void displaySearchSuggestion(java.util.List<com.tatayab.model.SearchModel> searchSuggestionList) {
    }
    
    @java.lang.Override
    public void onSearchSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @java.lang.Override
    public void onSearchSuggestionSelected(@org.jetbrains.annotations.NotNull
    java.lang.String searchSuggestionText) {
    }
    
    @java.lang.Override
    public void onRemovedSuggestionClicked(int position) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.SearchProductModel> getCurrentProductList() {
        return null;
    }
    
    public final void setCurrentProductList(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.SearchProductModel> p0) {
    }
    
    private final void updateProductListView(java.util.List<com.tatayab.model.SearchProductModel> productList) {
    }
    
    public final void updateSearchSuggestionVisibility(boolean visible) {
    }
    
    public final void updateRecommendedProductsVisibility(boolean visible) {
    }
    
    @java.lang.Override
    public void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    com.tatayab.model.ProductX mProduct, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter) {
    }
    
    @java.lang.Override
    public void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter) {
    }
    
    private final com.tatayab.model.Product convertProductxToProduct(com.tatayab.model.ProductX mProductx) {
        return null;
    }
    
    @java.lang.Override
    public void onSeeMoreProduct(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String categoryId, @org.jetbrains.annotations.Nullable
    java.lang.String categoryName) {
    }
    
    @java.lang.Override
    public void addToWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter) {
    }
    
    @java.lang.Override
    public void removeFromWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter) {
    }
    
    @java.lang.Override
    public void onAddToCart(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, int amount, int maxQty, @org.jetbrains.annotations.Nullable
    android.widget.ImageView image) {
    }
    
    public final void showKeyBoard() {
    }
}