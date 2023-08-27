package com.tatayab.tatayab.filter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010\'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001c\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/tatayab/tatayab/filter/FilterOptionsFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/filter/adapter/OptionListener;", "()V", "filterOptionList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/filter/ChildData;", "Lkotlin/collections/ArrayList;", "mFilterOptionsAdapter", "Lcom/tatayab/tatayab/filter/adapter/FilterOptionsAdapter;", "optionItems", "", "getOptionItems", "()[Lcom/tatayab/model/filter/ChildData;", "optionItems$delegate", "Lkotlin/Lazy;", "parentIndex", "", "getParentIndex", "()Ljava/lang/String;", "parentIndex$delegate", "parentTitle", "getParentTitle", "parentTitle$delegate", "searchFilterOptionList", "selectAll", "", "type", "getType", "type$delegate", "changeItemState", "", "mChildData", "state", "filterOptions", "filterText", "intComponent", "layoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "selectOption", "unSelectOption", "app_developmentDebug"})
public final class FilterOptionsFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.filter.adapter.OptionListener {
    private com.tatayab.tatayab.filter.adapter.FilterOptionsAdapter mFilterOptionsAdapter;
    private java.util.ArrayList<com.tatayab.model.filter.ChildData> filterOptionList;
    private java.util.ArrayList<com.tatayab.model.filter.ChildData> searchFilterOptionList;
    private boolean selectAll = false;
    private final kotlin.Lazy type$delegate = null;
    private final kotlin.Lazy parentTitle$delegate = null;
    private final kotlin.Lazy parentIndex$delegate = null;
    private final kotlin.Lazy optionItems$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public FilterOptionsFragment() {
        super();
    }
    
    private final java.lang.String getType() {
        return null;
    }
    
    private final java.lang.String getParentTitle() {
        return null;
    }
    
    private final java.lang.String getParentIndex() {
        return null;
    }
    
    private final com.tatayab.model.filter.ChildData[] getOptionItems() {
        return null;
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void intComponent() {
    }
    
    private final void filterOptions(java.lang.String filterText) {
    }
    
    @java.lang.Override
    public void selectOption(@org.jetbrains.annotations.NotNull
    com.tatayab.model.filter.ChildData mChildData) {
    }
    
    private final void changeItemState(com.tatayab.model.filter.ChildData mChildData, boolean state) {
    }
    
    @java.lang.Override
    public void unSelectOption(@org.jetbrains.annotations.NotNull
    com.tatayab.model.filter.ChildData mChildData) {
    }
}