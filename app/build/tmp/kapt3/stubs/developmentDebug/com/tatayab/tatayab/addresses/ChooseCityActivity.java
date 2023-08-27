package com.tatayab.tatayab.addresses;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0012\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tatayab/tatayab/addresses/ChooseCityActivity;", "Lcom/tatayab/tatayab/base/BaseActivity;", "Lcom/tatayab/tatayab/listener/CityListener;", "()V", "adapter", "Lcom/tatayab/tatayab/addresses/CityAdapter;", "getAdapter", "()Lcom/tatayab/tatayab/addresses/CityAdapter;", "setAdapter", "(Lcom/tatayab/tatayab/addresses/CityAdapter;)V", "areaList", "", "Lcom/tatayab/model/responses/AreaModel;", "getAreaList", "()Ljava/util/List;", "setAreaList", "(Ljava/util/List;)V", "citiesList", "Lcom/tatayab/model/responses/CityModel;", "getCitiesList", "setCitiesList", "isForArea", "", "()Z", "setForArea", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/SelectCityOrAreaModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "viewModel", "Lcom/tatayab/presentation/address/ChooseCityActivityViewModel;", "initEventAction", "", "initSubscribtions", "initView", "onCitySelected", "city", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_developmentDebug"})
public final class ChooseCityActivity extends com.tatayab.tatayab.base.BaseActivity implements com.tatayab.tatayab.listener.CityListener {
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.tatayab.model.responses.CityModel> citiesList;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.tatayab.model.responses.AreaModel> areaList;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.tatayab.model.responses.SelectCityOrAreaModel> items;
    private boolean isForArea = false;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.addresses.CityAdapter adapter;
    private com.tatayab.presentation.address.ChooseCityActivityViewModel viewModel;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.addresses.ChooseCityActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CITIES_LIST_HOLDER = "CITIES_LIST_HOLDER";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CITIE_HOLDER = "CITIE_HOLDER";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String AREA_LIST_HOLDER = "AREA_LIST_HOLDER";
    private static final int START_FORE_RESULT_ID_HOLDER = 33456;
    private java.util.HashMap _$_findViewCache;
    
    public ChooseCityActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.responses.CityModel> getCitiesList() {
        return null;
    }
    
    public final void setCitiesList(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.CityModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.responses.AreaModel> getAreaList() {
        return null;
    }
    
    public final void setAreaList(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.AreaModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.tatayab.model.responses.SelectCityOrAreaModel> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.SelectCityOrAreaModel> p0) {
    }
    
    public final boolean isForArea() {
        return false;
    }
    
    public final void setForArea(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.addresses.CityAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.addresses.CityAdapter p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initSubscribtions() {
    }
    
    private final void initEventAction() {
    }
    
    private final void initView() {
    }
    
    @java.lang.Override
    public void onCitySelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.SelectCityOrAreaModel city) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tatayab/tatayab/addresses/ChooseCityActivity$Companion;", "", "()V", "AREA_LIST_HOLDER", "", "getAREA_LIST_HOLDER", "()Ljava/lang/String;", "CITIES_LIST_HOLDER", "getCITIES_LIST_HOLDER", "CITIE_HOLDER", "getCITIE_HOLDER", "START_FORE_RESULT_ID_HOLDER", "", "getSTART_FORE_RESULT_ID_HOLDER", "()I", "getInstance", "Landroid/content/Intent;", "activity", "Landroid/content/Context;", "citiesList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/CityModel;", "Lkotlin/collections/ArrayList;", "areaList", "Lcom/tatayab/model/responses/AreaModel;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCITIES_LIST_HOLDER() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCITIE_HOLDER() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAREA_LIST_HOLDER() {
            return null;
        }
        
        public final int getSTART_FORE_RESULT_ID_HOLDER() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Intent getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context activity, @org.jetbrains.annotations.Nullable
        java.util.ArrayList<com.tatayab.model.responses.CityModel> citiesList, @org.jetbrains.annotations.Nullable
        java.util.ArrayList<com.tatayab.model.responses.AreaModel> areaList) {
            return null;
        }
    }
}