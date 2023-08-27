package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/tatayab/tatayab/util/NumbersUtil;", "", "()V", "calculateOffPercent", "", "price", "", "basePrice", "formatNumber", "", "number", "decimal", "formatNumberDigit", "formatNumberString", "hasPriceOff", "", "isInStock", "actions", "amount", "minAmount", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Z", "maxAmount", "maxQty", "minQuantity", "minQty", "app_developmentDebug"})
public final class NumbersUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.NumbersUtil INSTANCE = null;
    
    private NumbersUtil() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final int calculateOffPercent(float price, float basePrice) {
        return 0;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean hasPriceOff(float price, float basePrice) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isInStock(@org.jetbrains.annotations.Nullable
    java.lang.String actions, @org.jetbrains.annotations.Nullable
    java.lang.Integer amount, @org.jetbrains.annotations.Nullable
    java.lang.Integer minAmount) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int maxAmount(int maxQty, int amount) {
        return 0;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int minQuantity(int minQty) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String formatNumber(float number) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String formatNumber(float number, int decimal) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String formatNumberString(int number, int decimal) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final int formatNumberDigit(int number, int decimal) {
        return 0;
    }
}