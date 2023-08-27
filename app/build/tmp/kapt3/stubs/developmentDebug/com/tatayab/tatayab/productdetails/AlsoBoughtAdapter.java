package com.tatayab.tatayab.productdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0014\u001a\u00020\u000e2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tatayab/tatayab/productdetails/AlsoBoughtAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/productdetails/AlsoBoughtAdapter$ProductViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnProductListener;", "decimalNumbers", "", "(Lcom/tatayab/tatayab/listener/OnProductListener;I)V", "currencyCode", "", "items", "", "Lcom/tatayab/model/ProductX;", "changeWishListState", "", "position", "isChecked", "", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "ProductViewHolder", "app_developmentDebug"})
public final class AlsoBoughtAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.productdetails.AlsoBoughtAdapter.ProductViewHolder> {
    private final com.tatayab.tatayab.listener.OnProductListener listener = null;
    private final int decimalNumbers = 0;
    private java.util.List<com.tatayab.model.ProductX> items;
    private java.lang.String currencyCode;
    
    public AlsoBoughtAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnProductListener listener, int decimalNumbers) {
        super();
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.productdetails.AlsoBoughtAdapter.ProductViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.productdetails.AlsoBoughtAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void changeWishListState(int position, boolean isChecked) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.lang.String currencyCode, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.ProductX> items) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tatayab/tatayab/productdetails/AlsoBoughtAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/productdetails/AlsoBoughtAdapter;Landroid/view/View;)V", "addfav", "Landroidx/appcompat/widget/AppCompatToggleButton;", "kotlin.jvm.PlatformType", "basePrice", "Landroidx/appcompat/widget/AppCompatTextView;", "btn_add_to_cart", "Landroidx/appcompat/widget/AppCompatImageView;", "currencyCode", "", "freeDelivery", "image", "offCircle", "outOfStockImage", "price", "product", "Lcom/tatayab/model/ProductX;", "productName", "soldOutStock", "Landroid/widget/ImageView;", "bindTo", "", "app_developmentDebug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.appcompat.widget.AppCompatTextView offCircle = null;
        private final androidx.appcompat.widget.AppCompatTextView basePrice = null;
        private final androidx.appcompat.widget.AppCompatTextView price = null;
        private final androidx.appcompat.widget.AppCompatTextView productName = null;
        private final android.widget.ImageView soldOutStock = null;
        private final androidx.appcompat.widget.AppCompatImageView btn_add_to_cart = null;
        private final androidx.appcompat.widget.AppCompatImageView outOfStockImage = null;
        private final androidx.appcompat.widget.AppCompatImageView freeDelivery = null;
        private final androidx.appcompat.widget.AppCompatImageView image = null;
        private final androidx.appcompat.widget.AppCompatToggleButton addfav = null;
        private com.tatayab.model.ProductX product;
        private java.lang.String currencyCode;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.ProductX product, @org.jetbrains.annotations.NotNull
        java.lang.String currencyCode) {
        }
    }
}