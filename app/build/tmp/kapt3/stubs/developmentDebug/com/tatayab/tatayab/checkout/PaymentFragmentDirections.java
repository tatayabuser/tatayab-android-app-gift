package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tatayab/tatayab/checkout/PaymentFragmentDirections;", "", "()V", "Companion", "OrderSuccessAction", "app_developmentDebug"})
public final class PaymentFragmentDirections {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.checkout.PaymentFragmentDirections.Companion Companion = null;
    
    private PaymentFragmentDirections() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J7\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tatayab/tatayab/checkout/PaymentFragmentDirections$OrderSuccessAction;", "Landroidx/navigation/NavDirections;", "orderId", "", "knetData", "Lcom/tatayab/model/KnetData;", "amount", "paymentStatus", "", "(Ljava/lang/String;Lcom/tatayab/model/KnetData;Ljava/lang/String;Z)V", "actionId", "", "getActionId", "()I", "getAmount", "()Ljava/lang/String;", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getKnetData", "()Lcom/tatayab/model/KnetData;", "getOrderId", "getPaymentStatus", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "app_developmentDebug"})
    static final class OrderSuccessAction implements androidx.navigation.NavDirections {
        @org.jetbrains.annotations.Nullable
        private final java.lang.String orderId = null;
        @org.jetbrains.annotations.Nullable
        private final com.tatayab.model.KnetData knetData = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String amount = null;
        private final boolean paymentStatus = false;
        private final int actionId = com.tatayab.tatayab.R.id.order_success_action;
        
        @org.jetbrains.annotations.NotNull
        public final com.tatayab.tatayab.checkout.PaymentFragmentDirections.OrderSuccessAction copy(@org.jetbrains.annotations.Nullable
        java.lang.String orderId, @org.jetbrains.annotations.Nullable
        com.tatayab.model.KnetData knetData, @org.jetbrains.annotations.Nullable
        java.lang.String amount, boolean paymentStatus) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public OrderSuccessAction(@org.jetbrains.annotations.Nullable
        java.lang.String orderId, @org.jetbrains.annotations.Nullable
        com.tatayab.model.KnetData knetData, @org.jetbrains.annotations.Nullable
        java.lang.String amount, boolean paymentStatus) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getOrderId() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tatayab.model.KnetData component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tatayab.model.KnetData getKnetData() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAmount() {
            return null;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean getPaymentStatus() {
            return false;
        }
        
        @java.lang.Override
        public int getActionId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.Suppress(names = {"CAST_NEVER_SUCCEEDS"})
        @java.lang.Override
        public android.os.Bundle getArguments() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tatayab/tatayab/checkout/PaymentFragmentDirections$Companion;", "", "()V", "orderSuccessAction", "Landroidx/navigation/NavDirections;", "orderId", "", "knetData", "Lcom/tatayab/model/KnetData;", "amount", "paymentStatus", "", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.navigation.NavDirections orderSuccessAction(@org.jetbrains.annotations.Nullable
        java.lang.String orderId, @org.jetbrains.annotations.Nullable
        com.tatayab.model.KnetData knetData, @org.jetbrains.annotations.Nullable
        java.lang.String amount, boolean paymentStatus) {
            return null;
        }
    }
}