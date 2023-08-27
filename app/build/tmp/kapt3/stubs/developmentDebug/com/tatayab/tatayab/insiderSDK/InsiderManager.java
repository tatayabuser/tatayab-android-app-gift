package com.tatayab.tatayab.insiderSDK;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tatayab/tatayab/insiderSDK/InsiderManager;", "", "()V", "Companion", "CustomEvent", "app_developmentDebug"})
public class InsiderManager {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.insiderSDK.InsiderManager.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    private static java.util.List<com.tatayab.model.responses.CartOrderResponse> ITEMS_PURCHASED;
    
    public InsiderManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tatayab/tatayab/insiderSDK/InsiderManager$CustomEvent;", "", "(Ljava/lang/String;I)V", "category_visited", "subcategory_visited", "searched", "add_to_fav", "remove_from_fav", "login", "register", "logout", "coupon_used", "session_start", "session_start_from_push", "app_developmentDebug"})
    public static enum CustomEvent {
        /*public static final*/ category_visited /* = new category_visited() */,
        /*public static final*/ subcategory_visited /* = new subcategory_visited() */,
        /*public static final*/ searched /* = new searched() */,
        /*public static final*/ add_to_fav /* = new add_to_fav() */,
        /*public static final*/ remove_from_fav /* = new remove_from_fav() */,
        /*public static final*/ login /* = new login() */,
        /*public static final*/ register /* = new register() */,
        /*public static final*/ logout /* = new logout() */,
        /*public static final*/ coupon_used /* = new coupon_used() */,
        /*public static final*/ session_start /* = new session_start() */,
        /*public static final*/ session_start_from_push /* = new session_start_from_push() */;
        
        CustomEvent() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JO\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\rJY\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010!JO\u0010\"\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u0015J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J(\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0016J8\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\r2&\u0010.\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010/j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`0H\u0016J\u0016\u00101\u001a\u00020\u000b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\u001d\u00106\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u00107R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u00068"}, d2 = {"Lcom/tatayab/tatayab/insiderSDK/InsiderManager$Companion;", "", "()V", "ITEMS_PURCHASED", "", "Lcom/tatayab/model/responses/CartOrderResponse;", "getITEMS_PURCHASED", "()Ljava/util/List;", "setITEMS_PURCHASED", "(Ljava/util/List;)V", "addProductToCart", "", "productID", "", "productName", "taxonomy", "", "imageURL", "price", "", "currency", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "addUser", "email", "phone", "userId", "cartCleared", "changeCountry", "countryValue", "changeLanguage", "languageValue", "itemPurchased", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "openProductDetails", "removeProductFromCar", "sendCenterMessage", "limit", "", "startDate", "Ljava/util/Date;", "endtDate", "sendCenterMessageListener", "Lcom/tatayab/tatayab/insiderSDK/SendCenterMessageListener;", "sendCustomEvent", "eventname", "parameters", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "visitCartPage", "insiderProductsList", "Ljava/util/ArrayList;", "Lcom/useinsider/insider/InsiderProduct;", "visitHomePage", "visitListingPage", "([Ljava/lang/String;)V", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public java.util.List<com.tatayab.model.responses.CartOrderResponse> getITEMS_PURCHASED() {
            return null;
        }
        
        public void setITEMS_PURCHASED(@org.jetbrains.annotations.Nullable
        java.util.List<com.tatayab.model.responses.CartOrderResponse> p0) {
        }
        
        public void addProductToCart(@org.jetbrains.annotations.Nullable
        java.lang.String productID, @org.jetbrains.annotations.Nullable
        java.lang.String productName, @org.jetbrains.annotations.Nullable
        java.lang.String[] taxonomy, @org.jetbrains.annotations.Nullable
        java.lang.String imageURL, @org.jetbrains.annotations.Nullable
        java.lang.Double price, @org.jetbrains.annotations.Nullable
        java.lang.String currency) {
        }
        
        public void removeProductFromCar(@org.jetbrains.annotations.Nullable
        java.lang.String productID) {
        }
        
        public void addUser(@org.jetbrains.annotations.NotNull
        java.lang.String email, @org.jetbrains.annotations.NotNull
        java.lang.String phone, @org.jetbrains.annotations.NotNull
        java.lang.String userId) {
        }
        
        public void cartCleared() {
        }
        
        public void visitListingPage(@org.jetbrains.annotations.Nullable
        java.lang.String[] taxonomy) {
        }
        
        public void visitHomePage() {
        }
        
        public void visitCartPage(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.useinsider.insider.InsiderProduct> insiderProductsList) {
        }
        
        public void sendCustomEvent(@org.jetbrains.annotations.NotNull
        java.lang.String eventname, @org.jetbrains.annotations.Nullable
        java.util.HashMap<java.lang.String, java.lang.Object> parameters) {
        }
        
        public void sendCenterMessage(int limit, @org.jetbrains.annotations.NotNull
        java.util.Date startDate, @org.jetbrains.annotations.NotNull
        java.util.Date endtDate, @org.jetbrains.annotations.NotNull
        com.tatayab.tatayab.insiderSDK.SendCenterMessageListener sendCenterMessageListener) {
        }
        
        public void openProductDetails(@org.jetbrains.annotations.Nullable
        java.lang.String productID, @org.jetbrains.annotations.Nullable
        java.lang.String productName, @org.jetbrains.annotations.Nullable
        java.lang.String[] taxonomy, @org.jetbrains.annotations.Nullable
        java.lang.String imageURL, @org.jetbrains.annotations.Nullable
        java.lang.Double price, @org.jetbrains.annotations.Nullable
        java.lang.String currency) {
        }
        
        public void itemPurchased(@org.jetbrains.annotations.Nullable
        java.lang.String orderId, @org.jetbrains.annotations.Nullable
        java.lang.String productID, @org.jetbrains.annotations.Nullable
        java.lang.String productName, @org.jetbrains.annotations.Nullable
        java.lang.String[] taxonomy, @org.jetbrains.annotations.Nullable
        java.lang.String imageURL, @org.jetbrains.annotations.Nullable
        java.lang.Double price, @org.jetbrains.annotations.Nullable
        java.lang.String currency) {
        }
        
        public final void changeLanguage(@org.jetbrains.annotations.NotNull
        java.lang.String languageValue) {
        }
        
        public final void changeCountry(@org.jetbrains.annotations.NotNull
        java.lang.String countryValue) {
        }
    }
}