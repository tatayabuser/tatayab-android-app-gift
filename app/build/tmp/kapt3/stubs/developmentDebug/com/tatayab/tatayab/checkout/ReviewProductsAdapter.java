package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tatayab/tatayab/checkout/ReviewProductsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/checkout/ReviewProductsAdapter$ProductViewHolder;", "decimalNumbers", "", "(I)V", "currencyCode", "", "items", "", "Lcom/tatayab/model/responses/CartOrderResponse;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "ProductViewHolder", "app_developmentDebug"})
public final class ReviewProductsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.checkout.ReviewProductsAdapter.ProductViewHolder> {
    private final int decimalNumbers = 0;
    private java.util.List<com.tatayab.model.responses.CartOrderResponse> items;
    private java.lang.String currencyCode;
    
    public ReviewProductsAdapter(int decimalNumbers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.checkout.ReviewProductsAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
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
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.checkout.ReviewProductsAdapter.ProductViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.lang.String currencyCode, @org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.CartOrderResponse> items) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tatayab/tatayab/checkout/ReviewProductsAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/checkout/ReviewProductsAdapter;Landroid/view/View;)V", "amountCounter", "Lcom/tatayab/tatayab/main/ValueCounterView;", "basePrice", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "price", "product", "Lcom/tatayab/model/responses/CartOrderResponse;", "productName", "supplierName", "bindTo", "", "app_developmentDebug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.appcompat.widget.AppCompatTextView price = null;
        private final androidx.appcompat.widget.AppCompatTextView productName = null;
        private final androidx.appcompat.widget.AppCompatImageView image = null;
        private final androidx.appcompat.widget.AppCompatTextView supplierName = null;
        private final androidx.appcompat.widget.AppCompatTextView basePrice = null;
        private final com.tatayab.tatayab.main.ValueCounterView amountCounter = null;
        private com.tatayab.model.responses.CartOrderResponse product;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.CartOrderResponse product) {
        }
    }
}