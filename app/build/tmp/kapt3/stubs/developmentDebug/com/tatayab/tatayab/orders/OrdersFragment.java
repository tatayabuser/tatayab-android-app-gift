package com.tatayab.tatayab.orders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010#\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\'"}, d2 = {"Lcom/tatayab/tatayab/orders/OrdersFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnOrderListener;", "()V", "ordersAdapter", "Lcom/tatayab/tatayab/orders/OrdersAdapter;", "getOrdersAdapter", "()Lcom/tatayab/tatayab/orders/OrdersAdapter;", "setOrdersAdapter", "(Lcom/tatayab/tatayab/orders/OrdersAdapter;)V", "viewModel", "Lcom/tatayab/presentation/orders/OrdersFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/orders/OrdersFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/orders/OrdersFragmentViewModel;)V", "viewModelFactory", "Lcom/tatayab/presentation/orders/OrdersFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/orders/OrdersFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/orders/OrdersFragmentViewModelFactory$Factory;)V", "layoutId", "", "onOrderSelected", "", "orderId", "", "onOrderTracking", "orderDate", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupViewData", "data", "Landroidx/paging/PagedList;", "Lcom/tatayab/model/responses/Order;", "app_developmentDebug"})
public final class OrdersFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnOrderListener {
    public com.tatayab.presentation.orders.OrdersFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.orders.OrdersFragmentViewModelFactory.Factory viewModelFactory;
    public com.tatayab.tatayab.orders.OrdersAdapter ordersAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public OrdersFragment() {
        super();
    }
    
    @java.lang.Override
    public void onOrderTracking(@org.jetbrains.annotations.NotNull
    java.lang.String orderId, @org.jetbrains.annotations.NotNull
    java.lang.String orderDate) {
    }
    
    @java.lang.Override
    public void onOrderSelected(@org.jetbrains.annotations.NotNull
    java.lang.String orderId) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.orders.OrdersFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrdersFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.orders.OrdersFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrdersFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.orders.OrdersAdapter getOrdersAdapter() {
        return null;
    }
    
    public final void setOrdersAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.orders.OrdersAdapter p0) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewData(androidx.paging.PagedList<com.tatayab.model.responses.Order> data) {
    }
}