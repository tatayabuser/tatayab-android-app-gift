package com.tatayab.tatayab.main.categories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u001cR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tatayab/tatayab/main/categories/DetailsCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/main/categories/DetailsCategoryAdapter$ViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnCategoryListener;", "(Lcom/tatayab/tatayab/listener/OnCategoryListener;)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/SubCategoriesResponse;", "addBannerItem", "", "item", "getBannerType", "", "categoryType", "Lcom/tatayab/model/responses/BannerType;", "getItemCount", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "", "ViewHolder", "ViewHolderType", "app_developmentDebug"})
public final class DetailsCategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.main.categories.DetailsCategoryAdapter.ViewHolder> {
    private final com.tatayab.tatayab.listener.OnCategoryListener listener = null;
    private java.util.ArrayList<com.tatayab.model.responses.SubCategoriesResponse> items;
    
    public DetailsCategoryAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCategoryListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.main.categories.DetailsCategoryAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.SubCategoriesResponse> items) {
    }
    
    public final void addBannerItem(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.SubCategoriesResponse item) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.categories.DetailsCategoryAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    private final int getBannerType(com.tatayab.model.responses.BannerType categoryType) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tatayab/tatayab/main/categories/DetailsCategoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tatayab/tatayab/main/categories/DetailsCategoryAdapter;Landroid/view/View;)V", "category", "Lcom/tatayab/model/responses/SubCategoriesResponse;", "bind", "", "listener", "Lcom/tatayab/tatayab/listener/OnCategoryListener;", "position", "", "app_developmentDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.tatayab.model.responses.SubCategoriesResponse category;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.tatayab.model.responses.SubCategoriesResponse category, @org.jetbrains.annotations.NotNull
        com.tatayab.tatayab.listener.OnCategoryListener listener, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tatayab/tatayab/main/categories/DetailsCategoryAdapter$ViewHolderType;", "", "value", "", "(Ljava/lang/String;II)V", "SUB_CATEGORY", "TOP_SELLER", "BEST_SELLER", "EDITOR_CHOICE_BANNER", "app_developmentDebug"})
    public static enum ViewHolderType {
        /*public static final*/ SUB_CATEGORY /* = new SUB_CATEGORY(0) */,
        /*public static final*/ TOP_SELLER /* = new TOP_SELLER(0) */,
        /*public static final*/ BEST_SELLER /* = new BEST_SELLER(0) */,
        /*public static final*/ EDITOR_CHOICE_BANNER /* = new EDITOR_CHOICE_BANNER(0) */;
        
        ViewHolderType(int value) {
        }
    }
}