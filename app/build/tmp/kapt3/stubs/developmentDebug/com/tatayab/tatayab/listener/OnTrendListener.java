package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tatayab/tatayab/listener/OnTrendListener;", "", "onTrendSelected", "", "trendUrl", "", "title", "app_developmentDebug"})
public abstract interface OnTrendListener {
    
    public abstract void onTrendSelected(@org.jetbrains.annotations.Nullable
    java.lang.String trendUrl, @org.jetbrains.annotations.Nullable
    java.lang.String title);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}