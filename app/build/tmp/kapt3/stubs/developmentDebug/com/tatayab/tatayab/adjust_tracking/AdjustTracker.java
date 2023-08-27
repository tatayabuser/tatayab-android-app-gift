package com.tatayab.tatayab.adjust_tracking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tatayab/tatayab/adjust_tracking/AdjustTracker;", "", "()V", "Companion", "app_developmentDebug"})
public final class AdjustTracker {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.adjust_tracking.AdjustTracker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VIEW_PRODUCT_EVENT = "e4y91j";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ADD_TO_CART_EVENT = "3k0s6l";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VIEW_CART_EVENT = "dg1tw4";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHECK_OUT_EVENT = "wiouwu";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PURCHASE_EVENT = "zey0to";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FIRST_ORDER_EVENT = "aj10gi";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SIGNUP_EVENT = "vgmz0a";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String product_ID = "product_id";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String Product_Price = "product_price";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String Currency = "currency";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String Total_Paid_Amount = "Total Paid Amount";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String OrderId = "OrderId";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String userId = "";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String userEmail = "";
    @org.jetbrains.annotations.Nullable
    private static com.tatayab.tatayab.adjust_tracking.AdjustAttributionModel mAdjustAttributionModel;
    
    public AdjustTracker() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0002J<\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00042\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040-j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`.2\b\b\u0002\u0010/\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010!\u00a8\u00060"}, d2 = {"Lcom/tatayab/tatayab/adjust_tracking/AdjustTracker$Companion;", "", "()V", "ADD_TO_CART_EVENT", "", "getADD_TO_CART_EVENT", "()Ljava/lang/String;", "CHECK_OUT_EVENT", "getCHECK_OUT_EVENT", "Currency", "FIRST_ORDER_EVENT", "getFIRST_ORDER_EVENT", "OrderId", "PURCHASE_EVENT", "getPURCHASE_EVENT", "Product_Price", "SIGNUP_EVENT", "getSIGNUP_EVENT", "Total_Paid_Amount", "VIEW_CART_EVENT", "getVIEW_CART_EVENT", "VIEW_PRODUCT_EVENT", "getVIEW_PRODUCT_EVENT", "mAdjustAttributionModel", "Lcom/tatayab/tatayab/adjust_tracking/AdjustAttributionModel;", "getMAdjustAttributionModel", "()Lcom/tatayab/tatayab/adjust_tracking/AdjustAttributionModel;", "setMAdjustAttributionModel", "(Lcom/tatayab/tatayab/adjust_tracking/AdjustAttributionModel;)V", "product_ID", "userEmail", "getUserEmail", "setUserEmail", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "addGeneralCallbackParameter", "", "adjustEvent", "Lcom/adjust/sdk/AdjustEvent;", "orderTotal", "trackEvent", "eventId", "parameters", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "currency", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVIEW_PRODUCT_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getADD_TO_CART_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVIEW_CART_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCHECK_OUT_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPURCHASE_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getFIRST_ORDER_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSIGNUP_EVENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserId() {
            return null;
        }
        
        public final void setUserId(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserEmail() {
            return null;
        }
        
        public final void setUserEmail(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tatayab.tatayab.adjust_tracking.AdjustAttributionModel getMAdjustAttributionModel() {
            return null;
        }
        
        public final void setMAdjustAttributionModel(@org.jetbrains.annotations.Nullable
        com.tatayab.tatayab.adjust_tracking.AdjustAttributionModel p0) {
        }
        
        public final void trackEvent(@org.jetbrains.annotations.NotNull
        java.lang.String eventId, @org.jetbrains.annotations.NotNull
        java.util.HashMap<java.lang.String, java.lang.String> parameters, @org.jetbrains.annotations.NotNull
        java.lang.String currency) {
        }
        
        private final void addGeneralCallbackParameter(com.adjust.sdk.AdjustEvent adjustEvent, java.lang.String orderTotal) {
        }
    }
}