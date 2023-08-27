package com.tatayab.tatayab.productdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tatayab/tatayab/productdetails/ChooseOptionActivity;", "Lcom/tatayab/tatayab/base/BaseActivity;", "Lcom/tatayab/tatayab/listener/OnOptionVariantSelected;", "()V", "adapter", "Lcom/tatayab/tatayab/productdetails/OptionsVariantsAdapter;", "getAdapter", "()Lcom/tatayab/tatayab/productdetails/OptionsVariantsAdapter;", "setAdapter", "(Lcom/tatayab/tatayab/productdetails/OptionsVariantsAdapter;)V", "clickOption", "", "getClickOption", "()Ljava/lang/Integer;", "setClickOption", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "varientList", "", "Lcom/tatayab/model/Variant;", "getVarientList", "()Ljava/util/List;", "setVarientList", "(Ljava/util/List;)V", "viewModel", "Lcom/tatayab/presentation/address/ChooseCityActivityViewModel;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionSelected", "optionindex", "varientindex", "Companion", "app_developmentDebug"})
public final class ChooseOptionActivity extends com.tatayab.tatayab.base.BaseActivity implements com.tatayab.tatayab.listener.OnOptionVariantSelected {
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.tatayab.model.Variant> varientList;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer clickOption = 0;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.productdetails.OptionsVariantsAdapter adapter;
    private com.tatayab.presentation.address.ChooseCityActivityViewModel viewModel;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.productdetails.ChooseOptionActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VARIENTS_LIST_HOLDER = "VARIENTS_LIST_HOLDER";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VARINBT_INDEX = "VARINBT_INDEX";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String OPTION_INDEX = "OPTION_INDEX";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PRODUCT_NAME = "PRODUCT_NAME";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PRODUCT_IMAGE = "PRODUCT_IMAGE";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BRAND_NAME = "BRAND_NAME";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String OPTION_NAME = "OPTION_NAME";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String OPTION_Click = "OPTION_Click";
    private static final int START_FORE_RESULT_ID_HOLDER = 55555;
    private java.util.HashMap _$_findViewCache;
    
    public ChooseOptionActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.Variant> getVarientList() {
        return null;
    }
    
    public final void setVarientList(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.Variant> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getClickOption() {
        return null;
    }
    
    public final void setClickOption(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.productdetails.OptionsVariantsAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.productdetails.OptionsVariantsAdapter p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    @java.lang.Override
    public void onOptionSelected(int optionindex, int varientindex) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JR\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006\u00a8\u0006&"}, d2 = {"Lcom/tatayab/tatayab/productdetails/ChooseOptionActivity$Companion;", "", "()V", "BRAND_NAME", "", "getBRAND_NAME", "()Ljava/lang/String;", "OPTION_Click", "getOPTION_Click", "OPTION_INDEX", "getOPTION_INDEX", "OPTION_NAME", "getOPTION_NAME", "PRODUCT_IMAGE", "getPRODUCT_IMAGE", "PRODUCT_NAME", "getPRODUCT_NAME", "START_FORE_RESULT_ID_HOLDER", "", "getSTART_FORE_RESULT_ID_HOLDER", "()I", "VARIENTS_LIST_HOLDER", "getVARIENTS_LIST_HOLDER", "VARINBT_INDEX", "getVARINBT_INDEX", "getInstance", "Landroid/content/Intent;", "activity", "Landroid/content/Context;", "variantsList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/Variant;", "Lkotlin/collections/ArrayList;", "productName", "productImage", "brandName", "optionName", "optionClick", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVARIENTS_LIST_HOLDER() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVARINBT_INDEX() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getOPTION_INDEX() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPRODUCT_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPRODUCT_IMAGE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getBRAND_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getOPTION_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getOPTION_Click() {
            return null;
        }
        
        public final int getSTART_FORE_RESULT_ID_HOLDER() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Intent getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context activity, @org.jetbrains.annotations.Nullable
        java.util.ArrayList<com.tatayab.model.Variant> variantsList, @org.jetbrains.annotations.NotNull
        java.lang.String productName, @org.jetbrains.annotations.NotNull
        java.lang.String productImage, @org.jetbrains.annotations.NotNull
        java.lang.String brandName, @org.jetbrains.annotations.NotNull
        java.lang.String optionName, int optionClick) {
            return null;
        }
    }
}