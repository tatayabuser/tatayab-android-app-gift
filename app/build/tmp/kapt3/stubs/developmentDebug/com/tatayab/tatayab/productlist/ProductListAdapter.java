package com.tatayab.tatayab.productlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0014\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tatayab/tatayab/productlist/ProductListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/tatayab/model/ProductX;", "Lcom/tatayab/tatayab/productlist/ProductViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnProductListener;", "decimalNumbers", "", "(Lcom/tatayab/tatayab/listener/OnProductListener;I)V", "currencyCode", "", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "layoutId", "getLayoutId", "()I", "setLayoutId", "(I)V", "changeWishListState", "", "position", "isChecked", "", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setProductList", "products", "", "Companion", "app_developmentDebug"})
public final class ProductListAdapter extends androidx.paging.PagedListAdapter<com.tatayab.model.ProductX, com.tatayab.tatayab.productlist.ProductViewHolder> {
    private final com.tatayab.tatayab.listener.OnProductListener listener = null;
    private final int decimalNumbers = 0;
    private int layoutId = com.tatayab.tatayab.R.layout.list_item_product;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currencyCode;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.productlist.ProductListAdapter.Companion Companion = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.tatayab.model.ProductX> PRODUCT_COMPARATOR = null;
    
    public ProductListAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnProductListener listener, int decimalNumbers) {
        super(null);
    }
    
    public final int getLayoutId() {
        return 0;
    }
    
    public final void setLayoutId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.productlist.ProductViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.productlist.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void changeWishListState(int position, boolean isChecked) {
    }
    
    public final void setProductList(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.ProductX> products) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tatayab/tatayab/productlist/ProductListAdapter$Companion;", "", "()V", "PRODUCT_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tatayab/model/ProductX;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}