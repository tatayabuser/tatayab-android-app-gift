package com.tatayab.tatayab.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001*B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0015H\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\'J\u001c\u0010(\u001a\u00020\u001e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010)\u001a\u00020\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00060\u00060\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tatayab/tatayab/splash/CountriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/splash/CountriesAdapter$ViewHolder;", "Landroid/widget/Filterable;", "searchedItems", "", "Lcom/tatayab/model/responses/CountryResponse;", "countryListener", "Lcom/tatayab/tatayab/listener/OnCountryListener;", "(Ljava/util/List;Lcom/tatayab/tatayab/listener/OnCountryListener;)V", "getCountryListener", "()Lcom/tatayab/tatayab/listener/OnCountryListener;", "currentCountrySelected", "getCurrentCountrySelected", "()Lcom/tatayab/model/responses/CountryResponse;", "setCurrentCountrySelected", "(Lcom/tatayab/model/responses/CountryResponse;)V", "items", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "layoutId", "", "getLayoutId", "()I", "setLayoutId", "(I)V", "getFilter", "Landroid/widget/Filter;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "search", "s", "", "setData", "country", "ViewHolder", "app_developmentDebug"})
public final class CountriesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.splash.CountriesAdapter.ViewHolder> implements android.widget.Filterable {
    private java.util.List<com.tatayab.model.responses.CountryResponse> searchedItems;
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.tatayab.listener.OnCountryListener countryListener = null;
    private final java.util.ArrayList<com.tatayab.model.responses.CountryResponse> items = null;
    private int layoutId = com.tatayab.tatayab.R.layout.list_item_select_country;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.model.responses.CountryResponse currentCountrySelected;
    
    public CountriesAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.CountryResponse> searchedItems, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCountryListener countryListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.listener.OnCountryListener getCountryListener() {
        return null;
    }
    
    public final int getLayoutId() {
        return 0;
    }
    
    public final void setLayoutId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.model.responses.CountryResponse getCurrentCountrySelected() {
        return null;
    }
    
    public final void setCurrentCountrySelected(@org.jetbrains.annotations.Nullable
    com.tatayab.model.responses.CountryResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.splash.CountriesAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.splash.CountriesAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.CountryResponse> items, @org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CountryResponse country) {
    }
    
    public final void search(@org.jetbrains.annotations.Nullable
    java.lang.String s) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.widget.Filter getFilter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tatayab/tatayab/splash/CountriesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/splash/CountriesAdapter;Landroid/view/View;)V", "country", "Lcom/tatayab/model/responses/CountryResponse;", "countryFlag", "Lde/hdodenhof/circleimageview/CircleImageView;", "kotlin.jvm.PlatformType", "countryName", "Landroid/widget/TextView;", "selectedCountryRadioButton", "Landroidx/appcompat/widget/AppCompatRadioButton;", "bind", "", "app_developmentDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.tatayab.model.responses.CountryResponse country;
        private final android.widget.TextView countryName = null;
        private final de.hdodenhof.circleimageview.CircleImageView countryFlag = null;
        private final androidx.appcompat.widget.AppCompatRadioButton selectedCountryRadioButton = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.tatayab.model.responses.CountryResponse country) {
        }
    }
}