package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/listener/OnOptionListener;", "", "onOptionItemClick", "", "optionIndex", "", "optionName", "", "variants", "", "Lcom/tatayab/model/Variant;", "app_developmentDebug"})
public abstract interface OnOptionListener {
    
    public abstract void onOptionItemClick(int optionIndex, @org.jetbrains.annotations.NotNull
    java.lang.String optionName, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.Variant> variants);
}