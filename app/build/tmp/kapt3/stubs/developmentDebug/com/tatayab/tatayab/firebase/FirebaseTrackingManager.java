package com.tatayab.tatayab.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tatayab/tatayab/firebase/FirebaseTrackingManager;", "", "()V", "Companion", "app_developmentDebug"})
public final class FirebaseTrackingManager {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.firebase.FirebaseTrackingManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String add_to_cart = "add_to_cart";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String add_to_wishlist = "add_to_wishlist";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String share_product = "share_product";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String shop_by_brand = "shop_by_brand";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SEARCH_ACTION_EVENT = "search_actions";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SEARCH_PAGE_EVENT = "search_page";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String REMOVE_FROM_CART_EVENT = "remove_from_cart";
    
    public FirebaseTrackingManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u001c"}, d2 = {"Lcom/tatayab/tatayab/firebase/FirebaseTrackingManager$Companion;", "", "()V", "REMOVE_FROM_CART_EVENT", "", "getREMOVE_FROM_CART_EVENT", "()Ljava/lang/String;", "SEARCH_ACTION_EVENT", "getSEARCH_ACTION_EVENT", "SEARCH_PAGE_EVENT", "getSEARCH_PAGE_EVENT", "add_to_cart", "getAdd_to_cart", "add_to_wishlist", "getAdd_to_wishlist", "share_product", "getShare_product", "shop_by_brand", "getShop_by_brand", "addProductToCar", "", "context", "Landroid/content/Context;", "productId", "removeProductFromCar", "trackProductDetailsFromSearch", "action", "visitSearchScreen", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAdd_to_cart() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAdd_to_wishlist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getShare_product() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getShop_by_brand() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSEARCH_ACTION_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSEARCH_PAGE_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getREMOVE_FROM_CART_EVENT() {
            return null;
        }
        
        public final void trackProductDetailsFromSearch(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String productId, @org.jetbrains.annotations.Nullable
        java.lang.String action) {
        }
        
        public final void removeProductFromCar(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.Nullable
        java.lang.String productId) {
        }
        
        public final void addProductToCar(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.Nullable
        java.lang.String productId) {
        }
        
        public final void visitSearchScreen(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
}