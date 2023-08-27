package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J8\u0010\u000f\u001a\u00020\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tatayab/tatayab/listener/OnWishListListener;", "", "moveToCart", "", "product", "Lcom/tatayab/model/ProductX;", "options", "", "", "index", "", "image", "Landroid/widget/ImageView;", "onProductClicked", "productId", "onProductDelete", "productID", "productWishListId", "onSupplierSelected", "supplier_id", "supplier_name", "app_developmentDebug"})
public abstract interface OnWishListListener {
    
    public abstract void onProductDelete(@org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options, int index, @org.jetbrains.annotations.NotNull
    java.lang.String productID, @org.jetbrains.annotations.Nullable
    java.lang.String productWishListId);
    
    public abstract void onProductClicked(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options);
    
    public abstract void moveToCart(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options, int index, @org.jetbrains.annotations.Nullable
    android.widget.ImageView image);
    
    public abstract void onSupplierSelected(@org.jetbrains.annotations.Nullable
    java.lang.String supplier_id, @org.jetbrains.annotations.Nullable
    java.lang.String supplier_name);
}