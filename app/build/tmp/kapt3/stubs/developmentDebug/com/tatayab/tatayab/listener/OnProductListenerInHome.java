package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J,\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH&J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tatayab/tatayab/listener/OnProductListenerInHome;", "", "addToWishlist", "", "position", "", "product", "Lcom/tatayab/model/ProductX;", "productsAdapter", "Lcom/tatayab/tatayab/main/home/adapter/ProductsAdapter;", "onAddToCart", "amount", "maxQty", "image", "Landroid/widget/ImageView;", "onProductSelected", "productId", "", "mProduct", "onSeeMoreProduct", "type", "categoryId", "categoryName", "removeFromWishlist", "app_developmentDebug"})
public abstract interface OnProductListenerInHome {
    
    public abstract void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    com.tatayab.model.ProductX mProduct, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter);
    
    public abstract void onProductSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter);
    
    public abstract void onSeeMoreProduct(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String categoryId, @org.jetbrains.annotations.Nullable
    java.lang.String categoryName);
    
    public abstract void addToWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter);
    
    public abstract void removeFromWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.home.adapter.ProductsAdapter productsAdapter);
    
    public abstract void onAddToCart(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX product, int amount, int maxQty, @org.jetbrains.annotations.Nullable
    android.widget.ImageView image);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}