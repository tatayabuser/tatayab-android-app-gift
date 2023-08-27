package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tatayab/tatayab/listener/OnGiftListener;", "", "onAddButtonClicked", "", "mProductX", "Lcom/tatayab/model/ProductX;", "onDeleteButtonClicked", "mProductID", "", "onGetButtonClicked", "onGetButtonClicked2", "updateGift", "app_developmentDebug"})
public abstract interface OnGiftListener {
    
    public abstract void onAddButtonClicked(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX mProductX);
    
    public abstract void updateGift(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX mProductX);
    
    public abstract void onDeleteButtonClicked(@org.jetbrains.annotations.NotNull
    java.lang.String mProductID);
    
    public abstract void onGetButtonClicked(@org.jetbrains.annotations.NotNull
    java.lang.String mProductID);
    
    public abstract void onGetButtonClicked2(@org.jetbrains.annotations.NotNull
    java.lang.String mProductID);
}