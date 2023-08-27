package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tatayab/tatayab/listener/OnOrderListener;", "", "onOrderSelected", "", "orderId", "", "onOrderTracking", "orderDate", "app_developmentDebug"})
public abstract interface OnOrderListener {
    
    public abstract void onOrderSelected(@org.jetbrains.annotations.NotNull
    java.lang.String orderId);
    
    public abstract void onOrderTracking(@org.jetbrains.annotations.NotNull
    java.lang.String orderId, @org.jetbrains.annotations.NotNull
    java.lang.String orderDate);
}