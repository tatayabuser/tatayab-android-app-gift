package com.tatayab.tatayab.filter.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\bR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tatayab/tatayab/filter/adapter/FilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/filter/adapter/FilterAdapter$FilterViewHolder;", "()V", "filterList", "", "Lcom/tatayab/model/filter/ParentData;", "mFilterListener", "Lcom/tatayab/tatayab/filter/adapter/FilterListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFilterList", "list", "setListener", "mListener", "FilterViewHolder", "app_developmentDebug"})
public final class FilterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.filter.adapter.FilterAdapter.FilterViewHolder> {
    private java.util.List<com.tatayab.model.filter.ParentData> filterList;
    private com.tatayab.tatayab.filter.adapter.FilterListener mFilterListener;
    
    public FilterAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.filter.adapter.FilterAdapter.FilterViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.filter.adapter.FilterAdapter.FilterViewHolder holder, int position) {
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.filter.adapter.FilterListener mListener) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public void setFilterList(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.filter.ParentData> list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tatayab/tatayab/filter/adapter/FilterAdapter$FilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tatayab/tatayab/filter/adapter/FilterAdapter;Landroid/view/View;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "filterTitleTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "filterValueTextView", "item", "Lcom/tatayab/model/filter/ParentData;", "vItem", "Landroid/widget/RelativeLayout;", "bind", "", "app_developmentDebug"})
    public final class FilterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final androidx.appcompat.widget.AppCompatTextView filterTitleTextView = null;
        private final androidx.appcompat.widget.AppCompatTextView filterValueTextView = null;
        private final android.widget.RelativeLayout vItem = null;
        private com.tatayab.model.filter.ParentData item;
        private final android.content.Context context = null;
        
        public FilterViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable
        com.tatayab.model.filter.ParentData item) {
        }
    }
}