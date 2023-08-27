package com.tatayab.tatayab.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001+B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020\rH\u0016J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020\rH\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\rH\u0016J\u0014\u0010\u0018\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140*R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tatayab/tatayab/splash/HorizontalCitiesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/splash/HorizontalCitiesAdapter$ViewHolder;", "cityListener", "Lcom/tatayab/tatayab/listener/OnCityListener;", "langauge", "", "mcontext", "Landroid/content/Context;", "(Lcom/tatayab/tatayab/listener/OnCityListener;Ljava/lang/String;Landroid/content/Context;)V", "getCityListener", "()Lcom/tatayab/tatayab/listener/OnCityListener;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CityModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "layoutId", "getLayoutId", "setLayoutId", "mPreviousIndex", "getMPreviousIndex", "setMPreviousIndex", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "searchedItems", "", "ViewHolder", "app_developmentDebug"})
public final class HorizontalCitiesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.splash.HorizontalCitiesAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.tatayab.listener.OnCityListener cityListener = null;
    private final java.lang.String langauge = null;
    private final android.content.Context mcontext = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.responses.CityModel> items;
    private int layoutId = com.tatayab.tatayab.R.layout.list_item_supported_city;
    private int mPreviousIndex = -1;
    private int index = -1;
    
    public HorizontalCitiesAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnCityListener cityListener, @org.jetbrains.annotations.NotNull
    java.lang.String langauge, @org.jetbrains.annotations.NotNull
    android.content.Context mcontext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.listener.OnCityListener getCityListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.responses.CityModel> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.CityModel> p0) {
    }
    
    public final int getLayoutId() {
        return 0;
    }
    
    public final void setLayoutId(int p0) {
    }
    
    public final int getMPreviousIndex() {
        return 0;
    }
    
    public final void setMPreviousIndex(int p0) {
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.CityModel> searchedItems) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.splash.HorizontalCitiesAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.splash.HorizontalCitiesAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tatayab/tatayab/splash/HorizontalCitiesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/splash/HorizontalCitiesAdapter;Landroid/view/View;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "country", "Lcom/tatayab/model/responses/CityModel;", "countryFlag", "Landroid/widget/ImageView;", "countryName", "Landroid/widget/TextView;", "bind", "", "app_developmentDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.tatayab.model.responses.CityModel country;
        private final android.widget.TextView countryName = null;
        private final android.widget.ImageView countryFlag = null;
        private final android.content.Context context = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.tatayab.model.responses.CityModel country) {
        }
    }
}