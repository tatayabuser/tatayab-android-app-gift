package com.tatayab.tatayab.main.cart;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\tJ\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010%\u001a\u00020\u00112\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bJ$\u0010,\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0016H\u0016J\u001e\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/tatayab/tatayab/main/cart/CartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/main/cart/CartAdapter$ProductViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnCartListener;", "updateAmountListener", "Lcom/tatayab/tatayab/listener/OnUpdateAmountListener;", "(Lcom/tatayab/tatayab/listener/OnCartListener;Lcom/tatayab/tatayab/listener/OnUpdateAmountListener;)V", "currencyCode", "", "decimalNumbers", "", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CartOrderResponse;", "Lkotlin/collections/ArrayList;", "addGiftItem", "", "giftItem", "changeWishListState", "position", "isChecked", "", "getData", "", "getDeliveryDate", "context", "Landroid/content/Context;", "fromDate", "toDate", "getFlagFromCountries", "countryCourseCode", "getGiftIDIfExist", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "setData", "setHasStableIds", "hasStableIds", "updateItem", "operationType", "Lcom/tatayab/presentation/OperationType;", "productId", "ProductViewHolder", "app_developmentDebug"})
public final class CartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.main.cart.CartAdapter.ProductViewHolder> {
    private final com.tatayab.tatayab.listener.OnCartListener listener = null;
    private final com.tatayab.tatayab.listener.OnUpdateAmountListener updateAmountListener = null;
    private java.util.ArrayList<com.tatayab.model.responses.CartOrderResponse> items;
    private java.lang.String currencyCode;
    private int decimalNumbers = 1;
    
    public CartAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCartListener listener, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnUpdateAmountListener updateAmountListener) {
        super();
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.cart.CartAdapter.ProductViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.main.cart.CartAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
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
    java.util.List<com.tatayab.model.responses.CartOrderResponse> items, int decimalNumbers) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGiftIDIfExist() {
        return null;
    }
    
    public final void addGiftItem(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CartOrderResponse giftItem) {
    }
    
    private final java.lang.String getDeliveryDate(android.content.Context context, java.lang.String fromDate, java.lang.String toDate) {
        return null;
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override
    public void setHasStableIds(boolean hasStableIds) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void removeItem(int position) {
    }
    
    private final java.lang.String getFlagFromCountries(java.lang.String countryCourseCode) {
        return null;
    }
    
    public final void updateItem(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.OperationType operationType, @org.jetbrains.annotations.NotNull
    java.lang.String productId, int position) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.responses.CartOrderResponse> getData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tatayab/tatayab/main/cart/CartAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/main/cart/CartAdapter;Landroid/view/View;)V", "addtoFav", "Landroidx/appcompat/widget/AppCompatToggleButton;", "kotlin.jvm.PlatformType", "amountCounter", "Lcom/tatayab/tatayab/main/ValueCounterView;", "basePrice", "Landroidx/appcompat/widget/AppCompatTextView;", "countryLogoImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "countryNameTextView", "Landroid/widget/TextView;", "countryView", "Landroid/widget/LinearLayout;", "deleteView", "Landroid/widget/FrameLayout;", "deliveryDateView", "deliveryImageView", "Landroid/widget/ImageView;", "deliveryTextView", "editGiftEnable", "Landroidx/appcompat/widget/AppCompatButton;", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "price", "product", "Lcom/tatayab/model/responses/CartOrderResponse;", "productName", "supplierName", "bindTo", "", "app_developmentDebug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.appcompat.widget.AppCompatTextView price = null;
        private final android.widget.FrameLayout deleteView = null;
        private final androidx.appcompat.widget.AppCompatTextView productName = null;
        private final androidx.appcompat.widget.AppCompatImageView image = null;
        private final androidx.appcompat.widget.AppCompatTextView supplierName = null;
        private final androidx.appcompat.widget.AppCompatTextView basePrice = null;
        private final androidx.appcompat.widget.AppCompatToggleButton addtoFav = null;
        private final androidx.appcompat.widget.AppCompatButton editGiftEnable = null;
        private final com.tatayab.tatayab.main.ValueCounterView amountCounter = null;
        private final android.widget.LinearLayout countryView = null;
        private final de.hdodenhof.circleimageview.CircleImageView countryLogoImageView = null;
        private final android.widget.TextView countryNameTextView = null;
        private final android.widget.LinearLayout deliveryDateView = null;
        private final android.widget.ImageView deliveryImageView = null;
        private final android.widget.TextView deliveryTextView = null;
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