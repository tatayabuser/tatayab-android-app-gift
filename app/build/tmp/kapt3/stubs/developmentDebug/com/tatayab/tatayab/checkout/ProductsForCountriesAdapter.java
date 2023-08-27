package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00011B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0002\u0010\rJ \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010%\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\'\u001a\u00020\bH\u0016J\u001c\u0010(\u001a\u00020)2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\'\u001a\u00020\bH\u0016J\u001c\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0016\u0010/\u001a\u00020)2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00062"}, d2 = {"Lcom/tatayab/tatayab/checkout/ProductsForCountriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/checkout/ProductsForCountriesAdapter$ProductViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnCheckoutProductSelected;", "currencyCode", "", "decimalNumbers", "", "getAddToWishListResult", "Lcom/tatayab/presentation/SingleLiveEvent;", "Lcom/tatayab/presentation/state/Resource;", "Lcom/tatayab/model/responses/AddToWishListResponse;", "(Lcom/tatayab/tatayab/listener/OnCheckoutProductSelected;Ljava/lang/String;ILcom/tatayab/presentation/SingleLiveEvent;)V", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "getGetAddToWishListResult", "()Lcom/tatayab/presentation/SingleLiveEvent;", "setGetAddToWishListResult", "(Lcom/tatayab/presentation/SingleLiveEvent;)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CheckOutProductsModel;", "Lkotlin/collections/ArrayList;", "getListener", "()Lcom/tatayab/tatayab/listener/OnCheckoutProductSelected;", "setListener", "(Lcom/tatayab/tatayab/listener/OnCheckoutProductSelected;)V", "getDeliveryDate", "context", "Landroid/content/Context;", "fromDate", "toDate", "getFlagFromCountries", "countryCourseCode", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "", "ProductViewHolder", "app_developmentDebug"})
public final class ProductsForCountriesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.checkout.ProductsForCountriesAdapter.ProductViewHolder> {
    @org.jetbrains.annotations.NotNull
    private com.tatayab.tatayab.listener.OnCheckoutProductSelected listener;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currencyCode;
    private final int decimalNumbers = 0;
    @org.jetbrains.annotations.NotNull
    private com.tatayab.presentation.SingleLiveEvent<com.tatayab.presentation.state.Resource<com.tatayab.model.responses.AddToWishListResponse>> getAddToWishListResult;
    private java.util.ArrayList<com.tatayab.model.responses.CheckOutProductsModel> items;
    
    public ProductsForCountriesAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCheckoutProductSelected listener, @org.jetbrains.annotations.NotNull
    java.lang.String currencyCode, int decimalNumbers, @org.jetbrains.annotations.NotNull
    com.tatayab.presentation.SingleLiveEvent<com.tatayab.presentation.state.Resource<com.tatayab.model.responses.AddToWishListResponse>> getAddToWishListResult) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.listener.OnCheckoutProductSelected getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCheckoutProductSelected p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.SingleLiveEvent<com.tatayab.presentation.state.Resource<com.tatayab.model.responses.AddToWishListResponse>> getGetAddToWishListResult() {
        return null;
    }
    
    public final void setGetAddToWishListResult(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.SingleLiveEvent<com.tatayab.presentation.state.Resource<com.tatayab.model.responses.AddToWishListResponse>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.checkout.ProductsForCountriesAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
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
    com.tatayab.tatayab.checkout.ProductsForCountriesAdapter.ProductViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.CheckOutProductsModel> items) {
    }
    
    private final java.lang.String getDeliveryDate(android.content.Context context, java.lang.String fromDate, java.lang.String toDate) {
        return null;
    }
    
    private final java.lang.String getFlagFromCountries(java.lang.String countryCourseCode) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tatayab/tatayab/checkout/ProductsForCountriesAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/checkout/ProductsForCountriesAdapter;Landroid/view/View;)V", "countryIcon", "Lde/hdodenhof/circleimageview/CircleImageView;", "kotlin.jvm.PlatformType", "countryName", "Landroid/widget/TextView;", "deliveryTextView", "model", "Lcom/tatayab/model/responses/CheckOutProductsModel;", "productsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindTo", "", "app_developmentDebug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final de.hdodenhof.circleimageview.CircleImageView countryIcon = null;
        private final android.widget.TextView countryName = null;
        private final android.widget.TextView deliveryTextView = null;
        private final androidx.recyclerview.widget.RecyclerView productsRecyclerView = null;
        private com.tatayab.model.responses.CheckOutProductsModel model;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.CheckOutProductsModel model) {
        }
    }
}