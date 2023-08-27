package com.tatayab.tatayab.ordertracking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tatayab/tatayab/ordertracking/OrderTrackingFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "()V", "listener", "Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "getListener", "()Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "setListener", "(Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;)V", "trackAdapter", "Lcom/tatayab/tatayab/ordertracking/OrderTrackingAdapter;", "viewModel", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;)V", "layoutId", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_developmentDebug"})
public final class OrderTrackingFragment extends com.tatayab.tatayab.base.BaseFragment {
    private com.tatayab.tatayab.ordertracking.OrderTrackingAdapter trackAdapter;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.presentation.orders.OrderDetailsFragmentViewModel viewModel;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.listener.OnProductListenerInOrder listener;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.ordertracking.OrderTrackingFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public OrderTrackingFragment() {
        super();
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.presentation.orders.OrderDetailsFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.Nullable
    com.tatayab.presentation.orders.OrderDetailsFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.listener.OnProductListenerInOrder getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.listener.OnProductListenerInOrder p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.tatayab.tatayab.ordertracking.OrderTrackingFragment newInstance(@org.jetbrains.annotations.Nullable
    com.tatayab.presentation.orders.OrderDetailsFragmentViewModel detailsViewmodel, @org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.listener.OnProductListenerInOrder orderlistener) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tatayab/tatayab/ordertracking/OrderTrackingFragment$Companion;", "", "()V", "newInstance", "Lcom/tatayab/tatayab/ordertracking/OrderTrackingFragment;", "detailsViewmodel", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModel;", "orderlistener", "Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.tatayab.tatayab.ordertracking.OrderTrackingFragment newInstance(@org.jetbrains.annotations.Nullable
        com.tatayab.presentation.orders.OrderDetailsFragmentViewModel detailsViewmodel, @org.jetbrains.annotations.Nullable
        com.tatayab.tatayab.listener.OnProductListenerInOrder orderlistener) {
            return null;
        }
    }
}