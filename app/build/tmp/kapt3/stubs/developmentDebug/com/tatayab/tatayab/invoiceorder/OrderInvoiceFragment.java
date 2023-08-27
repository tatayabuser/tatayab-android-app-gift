package com.tatayab.tatayab.invoiceorder;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020\u0011H\u0016J\u0012\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0005H\u0016J\u001c\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00100\u001a\u00020&2\u0006\u00101\u001a\u0002022\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u00103\u001a\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tatayab/tatayab/invoiceorder/OrderInvoiceFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "()V", "currencyCode", "", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "data", "Lcom/tatayab/model/responses/OrderDetailsResponse;", "getData", "()Lcom/tatayab/model/responses/OrderDetailsResponse;", "setData", "(Lcom/tatayab/model/responses/OrderDetailsResponse;)V", "decimalDigits", "", "getDecimalDigits", "()I", "setDecimalDigits", "(I)V", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "productAdapter", "Lcom/tatayab/tatayab/orderdetails/ProductAdapterInOrder;", "layoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onProductSelected", "productId", "onSupplierSelected", "supplier_id", "supplier_name", "onTrackExternalOrder", "url", "onViewCreated", "view", "Landroid/view/View;", "setUpData", "Companion", "app_developmentDebug"})
public final class OrderInvoiceFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.listener.OnProductListenerInOrder {
    @org.jetbrains.annotations.Nullable
    private com.tatayab.model.responses.OrderDetailsResponse data;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currencyCode = "";
    private int decimalDigits = 3;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    private com.tatayab.tatayab.orderdetails.ProductAdapterInOrder productAdapter;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public OrderInvoiceFragment() {
        super();
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.model.responses.OrderDetailsResponse getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    com.tatayab.model.responses.OrderDetailsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getDecimalDigits() {
        return 0;
    }
    
    public final void setDecimalDigits(int p0) {
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
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpData() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/invoiceorder/OrderInvoiceFragment$Companion;", "", "()V", "newInstance", "Lcom/tatayab/tatayab/invoiceorder/OrderInvoiceFragment;", "details", "Lcom/tatayab/model/responses/OrderDetailsResponse;", "currency", "", "decimalNumbers", "", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment newInstance(@org.jetbrains.annotations.NotNull
        com.tatayab.model.responses.OrderDetailsResponse details, @org.jetbrains.annotations.NotNull
        java.lang.String currency, int decimalNumbers) {
            return null;
        }
    }
}