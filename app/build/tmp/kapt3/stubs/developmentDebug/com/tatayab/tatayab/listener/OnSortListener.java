package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tatayab/tatayab/listener/OnSortListener;", "", "onSortOptionChecked", "", "sortItem", "Lcom/tatayab/model/filter/SortItem;", "app_developmentDebug"})
public abstract interface OnSortListener {
    
    public abstract void onSortOptionChecked(@org.jetbrains.annotations.NotNull
    com.tatayab.model.filter.SortItem sortItem);
}