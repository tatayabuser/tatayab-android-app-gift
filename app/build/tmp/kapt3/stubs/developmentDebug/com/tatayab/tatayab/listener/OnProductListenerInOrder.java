package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/listener/OnProductListenerInOrder;", "", "onProductSelected", "", "productId", "", "onSupplierSelected", "supplier_id", "supplier_name", "onTrackExternalOrder", "url", "app_developmentDebug"})
public abstract interface OnProductListenerInOrder {
    
    public abstract void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId);
    
    public abstract void onSupplierSelected(@org.jetbrains.annotations.Nullable
    java.lang.String supplier_id, @org.jetbrains.annotations.Nullable
    java.lang.String supplier_name);
    
    public abstract void onTrackExternalOrder(@org.jetbrains.annotations.Nullable
    java.lang.String url);
}