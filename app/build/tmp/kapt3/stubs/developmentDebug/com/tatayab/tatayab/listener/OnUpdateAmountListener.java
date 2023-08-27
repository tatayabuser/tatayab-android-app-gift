package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J0\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tatayab/tatayab/listener/OnUpdateAmountListener;", "", "getGiftOptions", "", "onUpdateAmount", "operationType", "Lcom/tatayab/presentation/OperationType;", "productId", "", "product", "Lcom/tatayab/model/responses/CartOrderResponse;", "value", "", "position", "app_developmentDebug"})
public abstract interface OnUpdateAmountListener {
    
    public abstract void onUpdateAmount(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.OperationType operationType, @org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CartOrderResponse product, int value, int position);
    
    public abstract void getGiftOptions();
}