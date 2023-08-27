package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&J.\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tatayab/tatayab/listener/OnCartListener;", "", "addToWishlist", "", "position", "", "product", "Lcom/tatayab/model/Product;", "onOptionsClicked", "Lcom/tatayab/model/MapValueXXX;", "onProductClicked", "cartId", "", "productId", "options", "", "onProductDelete", "Lcom/tatayab/model/responses/CartOrderResponse;", "index", "openGiftView", "removeFromWishlist", "updateGiftId", "app_developmentDebug"})
public abstract interface OnCartListener {
    
    public abstract void onProductDelete(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CartOrderResponse product, int index);
    
    public abstract void onProductClicked(@org.jetbrains.annotations.NotNull
    java.lang.String cartId, @org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options);
    
    public abstract void onOptionsClicked(@org.jetbrains.annotations.Nullable
    com.tatayab.model.MapValueXXX product);
    
    public abstract void addToWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product);
    
    public abstract void removeFromWishlist(int index, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product);
    
    public abstract void updateGiftId(@org.jetbrains.annotations.NotNull
    java.lang.String productId);
    
    public abstract void openGiftView();
}