package com.tatayab.tatayab.orderdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u001c\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u000203H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u00064"}, d2 = {"Lcom/tatayab/tatayab/orderdetails/OrderDetailsFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "()V", "lastchecked", "", "getLastchecked", "()I", "setLastchecked", "(I)V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "orderId$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;)V", "viewModelFactory", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModelFactory$Factory;)V", "layoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onProductSelected", "productId", "onSupplierSelected", "supplier_id", "supplier_name", "onTrackExternalOrder", "url", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "setupViewData", "data", "Lcom/tatayab/model/responses/OrderDetailsResponse;", "app_developmentDebug"})
public final class OrderDetailsFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnProductListenerInOrder {
    public com.tatayab.presentation.orders.OrderDetailsFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory.Factory viewModelFactory;
    private int lastchecked = com.tatayab.tatayab.R.id.order_invoice;
    private final kotlin.Lazy orderId$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public OrderDetailsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.orders.OrderDetailsFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrderDetailsFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory.Factory p0) {
    }
    
    public final int getLastchecked() {
        return 0;
    }
    
    public final void setLastchecked(int p0) {
    }
    
    private final java.lang.String getOrderId() {
        return null;
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewData(com.tatayab.model.responses.OrderDetailsResponse data) {
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override
    public void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId) {
    }
    
    @java.lang.Override
    public void onSupplierSelected(@org.jetbrains.annotations.Nullable
    java.lang.String supplier_id, @org.jetbrains.annotations.Nullable
    java.lang.String supplier_name) {
    }
    
    @java.lang.Override
    public void onTrackExternalOrder(@org.jetbrains.annotations.Nullable
    java.lang.String url) {
    }
}