package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tatayab/tatayab/listener/OnSearchListener;", "", "onRemovedSuggestionClicked", "", "position", "", "onSearchSelected", "productId", "", "type", "name", "onSearchSuggestionSelected", "searchText", "app_developmentDebug"})
public abstract interface OnSearchListener {
    
    public abstract void onSearchSelected(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String name);
    
    public abstract void onSearchSuggestionSelected(@org.jetbrains.annotations.NotNull
    java.lang.String searchText);
    
    public abstract void onRemovedSuggestionClicked(int position);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}