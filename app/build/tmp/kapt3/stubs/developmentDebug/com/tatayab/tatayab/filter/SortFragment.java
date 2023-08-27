package com.tatayab.tatayab.filter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010!\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tatayab/tatayab/filter/SortFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnSortListener;", "()V", "sortAdapter", "Lcom/tatayab/tatayab/filter/adapter/SortAdapter;", "sortList", "", "Lcom/tatayab/model/filter/SortItem;", "getSortList", "()Ljava/util/List;", "sortList$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tatayab/presentation/product/ProductListFragmentViewModel;", "viewModelFactory", "Lcom/tatayab/presentation/product/ProductListFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/product/ProductListFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/product/ProductListFragmentViewModelFactory$Factory;)V", "intComponent", "", "layoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSortOptionChecked", "sortItem", "onViewCreated", "view", "Landroid/view/View;", "setupViewWithData", "list", "app_developmentDebug"})
public final class SortFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnSortListener {
    private com.tatayab.presentation.product.ProductListFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.product.ProductListFragmentViewModelFactory.Factory viewModelFactory;
    private final com.tatayab.tatayab.filter.adapter.SortAdapter sortAdapter = null;
    private final kotlin.Lazy sortList$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public SortFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.product.ProductListFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.ProductListFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    private final java.util.List<com.tatayab.model.filter.SortItem> getSortList() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewWithData(java.util.List<com.tatayab.model.filter.SortItem> list) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void intComponent() {
    }
    
    @java.lang.Override
    public void onSortOptionChecked(@org.jetbrains.annotations.NotNull
    com.tatayab.model.filter.SortItem sortItem) {
    }
}