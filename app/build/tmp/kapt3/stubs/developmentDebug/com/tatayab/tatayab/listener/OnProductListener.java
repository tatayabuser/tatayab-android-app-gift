package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tatayab/tatayab/listener/OnProductListener;", "", "addToWishlist", "", "position", "", "product", "Lcom/tatayab/model/Product;", "onAddToCart", "Lcom/tatayab/model/ProductX;", "onProductSelected", "productId", "", "app_developmentDebug"})
public abstract interface OnProductListener {
    
    public abstract void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId);
    
    public abstract void addToWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product);
    
    public abstract void onAddToCart(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product);
}