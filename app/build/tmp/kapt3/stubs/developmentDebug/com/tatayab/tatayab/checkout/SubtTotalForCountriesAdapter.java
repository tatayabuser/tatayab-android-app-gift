package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tatayab/tatayab/checkout/SubtTotalForCountriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/checkout/SubtTotalForCountriesAdapter$SubTotalViewHolder;", "currencyCode", "", "decimalNumbers", "", "(Ljava/lang/String;I)V", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CheckOutChildModel;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "", "SubTotalViewHolder", "app_developmentDebug"})
public final class SubtTotalForCountriesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.checkout.SubtTotalForCountriesAdapter.SubTotalViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.lang.String currencyCode;
    private final int decimalNumbers = 0;
    private java.util.ArrayList<com.tatayab.model.responses.CheckOutChildModel> items;
    
    public SubtTotalForCountriesAdapter(@org.jetbrains.annotations.NotNull
    java.lang.String currencyCode, int decimalNumbers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.checkout.SubtTotalForCountriesAdapter.SubTotalViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
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
    com.tatayab.tatayab.checkout.SubtTotalForCountriesAdapter.SubTotalViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.CheckOutChildModel> items) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tatayab/tatayab/checkout/SubtTotalForCountriesAdapter$SubTotalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/checkout/SubtTotalForCountriesAdapter;Landroid/view/View;)V", "countryIcon", "Lde/hdodenhof/circleimageview/CircleImageView;", "kotlin.jvm.PlatformType", "countryName", "Landroid/widget/TextView;", "labelsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "model", "Lcom/tatayab/model/responses/CheckOutChildModel;", "bindTo", "", "app_developmentDebug"})
    public final class SubTotalViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final de.hdodenhof.circleimageview.CircleImageView countryIcon = null;
        private final android.widget.TextView countryName = null;
        private final androidx.recyclerview.widget.RecyclerView labelsRecyclerView = null;
        private com.tatayab.model.responses.CheckOutChildModel model;
        
        public SubTotalViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.CheckOutChildModel model) {
        }
    }
}