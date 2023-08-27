package com.tatayab.tatayab.supplier;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020 H\u0016J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\"H\u0002J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010\'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u001a\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/tatayab/tatayab/supplier/SupplierFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnSupplierListener;", "()V", "mAdapter", "Lcom/tatayab/tatayab/supplier/SupplierAdapter;", "suppliersAdapter", "Lcom/tatayab/tatayab/supplier/SuppliersAdapter;", "viewModel", "Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModel;)V", "viewModelFactory", "Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModelFactory$Factory;)V", "initReyclerView", "", "mSuppliersList", "", "Lcom/tatayab/model/responses/SupplierResponse;", "isArabicChar", "", "chr", "", "isLetters", "char", "layoutId", "", "moveHashListToLast", "Ljava/util/ArrayList;", "supplierList", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupplierSelected", "supplierId", "supplierName", "onViewCreated", "view", "Landroid/view/View;", "removeSpacesFromName", "supplier", "app_developmentDebug"})
public final class SupplierFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnSupplierListener {
    private com.tatayab.tatayab.supplier.SupplierAdapter mAdapter;
    public com.tatayab.presentation.suppliers.SuppliersFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory.Factory viewModelFactory;
    private final com.tatayab.tatayab.supplier.SuppliersAdapter suppliersAdapter = null;
    private java.util.HashMap _$_findViewCache;
    
    public SupplierFragment() {
        super();
    }
    
    @java.lang.Override
    public void onSupplierSelected(@org.jetbrains.annotations.NotNull
    java.lang.String supplierId, @org.jetbrains.annotations.NotNull
    java.lang.String supplierName) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.suppliers.SuppliersFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.suppliers.SuppliersFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.util.ArrayList<com.tatayab.model.responses.SupplierResponse> moveHashListToLast(java.util.ArrayList<com.tatayab.model.responses.SupplierResponse> supplierList) {
        return null;
    }
    
    private final void removeSpacesFromName(com.tatayab.model.responses.SupplierResponse supplier) {
    }
    
    public final boolean isLetters(@org.jetbrains.annotations.NotNull
    java.lang.String p0_1526187) {
        return false;
    }
    
    private final boolean isArabicChar(java.lang.String chr) {
        return false;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initReyclerView(java.util.List<com.tatayab.model.responses.SupplierResponse> mSuppliersList) {
    }
}