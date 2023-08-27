package com.tatayab.tatayab.productdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\'\u001a\u00020\u0004H\u0016J\u001c\u0010(\u001a\u00020)2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\'\u001a\u00020\u0004H\u0016J\u001c\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004H\u0016J>\u0010/\u001a\u00020)2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Lcom/tatayab/tatayab/productdetails/TabbyPaymentMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/productdetails/TabbyPaymentMethodAdapter$TabbyViewHolder;", "decimalNumbers", "", "(I)V", "currencyCode", "", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "isArabicLanguage", "", "()Z", "setArabicLanguage", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CountryContentModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "mTabbyListener", "Lcom/tatayab/tatayab/productdetails/TabbyListener;", "getMTabbyListener", "()Lcom/tatayab/tatayab/productdetails/TabbyListener;", "setMTabbyListener", "(Lcom/tatayab/tatayab/productdetails/TabbyListener;)V", "price", "", "getPrice", "()F", "setPrice", "(F)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "TabbyViewHolder", "app_developmentDebug"})
public final class TabbyPaymentMethodAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.productdetails.TabbyPaymentMethodAdapter.TabbyViewHolder> {
    private final int decimalNumbers = 0;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.responses.CountryContentModel> items;
    private boolean isArabicLanguage = false;
    private float price = 0.0F;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currencyCode = "";
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.productdetails.TabbyListener mTabbyListener;
    
    public TabbyPaymentMethodAdapter(int decimalNumbers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.responses.CountryContentModel> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.CountryContentModel> p0) {
    }
    
    public final boolean isArabicLanguage() {
        return false;
    }
    
    public final void setArabicLanguage(boolean p0) {
    }
    
    public final float getPrice() {
        return 0.0F;
    }
    
    public final void setPrice(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.productdetails.TabbyListener getMTabbyListener() {
        return null;
    }
    
    public final void setMTabbyListener(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.productdetails.TabbyListener p0) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.productdetails.TabbyPaymentMethodAdapter.TabbyViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.productdetails.TabbyPaymentMethodAdapter.TabbyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.CountryContentModel> items, float price, boolean isArabicLanguage, @org.jetbrains.annotations.NotNull
    java.lang.String currencyCode, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.productdetails.TabbyListener mTabbyListener) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tatayab/tatayab/productdetails/TabbyPaymentMethodAdapter$TabbyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/productdetails/TabbyPaymentMethodAdapter;Landroid/view/View;)V", "mCountryContentModel", "Lcom/tatayab/model/responses/CountryContentModel;", "seeMoreTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", "getSeeMoreTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "tabbyDesc", "getTabbyDesc", "tabbyImage", "Landroid/widget/ImageView;", "getTabbyImage", "()Landroid/widget/ImageView;", "tabbyTitle", "getTabbyTitle", "bindTo", "", "app_developmentDebug"})
    public final class TabbyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.appcompat.widget.AppCompatTextView tabbyTitle = null;
        private final androidx.appcompat.widget.AppCompatTextView tabbyDesc = null;
        private final android.widget.ImageView tabbyImage = null;
        private final androidx.appcompat.widget.AppCompatTextView seeMoreTextView = null;
        private com.tatayab.model.responses.CountryContentModel mCountryContentModel;
        
        public TabbyViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getTabbyTitle() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getTabbyDesc() {
            return null;
        }
        
        public final android.widget.ImageView getTabbyImage() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getSeeMoreTextView() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.CountryContentModel mCountryContentModel) {
        }
    }
}