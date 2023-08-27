package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tatayab/tatayab/util/FirebaseConfigUtil;", "", "()V", "conciergeLiveData", "Lcom/tatayab/presentation/SingleLiveEvent;", "", "getConciergeLiveData", "()Lcom/tatayab/presentation/SingleLiveEvent;", "Landroidx/lifecycle/LiveData;", "getGetConciergeLiveData", "()Landroidx/lifecycle/LiveData;", "mFirebaseConfigListener", "Lcom/tatayab/tatayab/util/FirebaseConfigListener;", "convertStringToContactNumbersList", "", "contactNumbersList", "", "convertStringToCountriesList", "tabbyCountriesListText", "getRandomWhatsAppNumber", "setListener", "firebaseConfigListener", "syncWithFirebaseCofig", "activity", "Landroid/app/Activity;", "Companion", "app_developmentDebug"})
public final class FirebaseConfigUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.FirebaseConfigUtil.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String whatsAppContacts = "+96599991181/+96592222982";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String WHATSAPP_NUMBERS_KEY = "whatsapp_numbers";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TABBY_AVAILABLE_COUNTRIES_KEY = "tabby_available_countries";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CONTACT_US_PHONE_NUMBERS_KEY = "contactUsPhoneNumbers";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CONCIERGE_KEY = "concierge_status";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RATE_APP_FROM_SUCCESS_SCREEN_KEY = "rate_app_from_success_screen";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String share_cart_enabled_android_KEY = "share_cart_enabled_android";
    private static boolean CONCIERGE_VALUE = false;
    private static boolean SHARE_CART_ENABLED = false;
    private static boolean RATE_APP_FROM_SUCCESS_SCREEN_VALUE = true;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String ENABLE_GRAPH_QUERIES_KEY = "is_call_qraphQl_APIs_Android";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String ENABLE_GRAPH_QUERIES_KEY_DUMMY = "AKL_is_call_qraphQl_APIs_Android";
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<com.tatayab.model.responses.TabbyCountryModel> tabbyCountriesList;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<com.tatayab.model.responses.ContactNumberPerCountryModel> mContactNumberPerCountryList;
    private com.tatayab.tatayab.util.FirebaseConfigListener mFirebaseConfigListener;
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.presentation.SingleLiveEvent<java.lang.Boolean> conciergeLiveData = null;
    
    public FirebaseConfigUtil() {
        super();
    }
    
    public void setListener(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.FirebaseConfigListener firebaseConfigListener) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.SingleLiveEvent<java.lang.Boolean> getConciergeLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getGetConciergeLiveData() {
        return null;
    }
    
    public final void syncWithFirebaseCofig(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    private final void convertStringToCountriesList(java.lang.String tabbyCountriesListText) {
    }
    
    private final void convertStringToContactNumbersList(java.lang.String contactNumbersList) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRandomWhatsAppNumber() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0014\u0010)\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R \u0010+\u001a\b\u0012\u0004\u0012\u00020,0#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\u0012\u00a8\u00062"}, d2 = {"Lcom/tatayab/tatayab/util/FirebaseConfigUtil$Companion;", "", "()V", "CONCIERGE_KEY", "", "getCONCIERGE_KEY", "()Ljava/lang/String;", "CONCIERGE_VALUE", "", "getCONCIERGE_VALUE", "()Z", "setCONCIERGE_VALUE", "(Z)V", "CONTACT_US_PHONE_NUMBERS_KEY", "getCONTACT_US_PHONE_NUMBERS_KEY", "ENABLE_GRAPH_QUERIES_KEY", "getENABLE_GRAPH_QUERIES_KEY", "setENABLE_GRAPH_QUERIES_KEY", "(Ljava/lang/String;)V", "ENABLE_GRAPH_QUERIES_KEY_DUMMY", "getENABLE_GRAPH_QUERIES_KEY_DUMMY", "setENABLE_GRAPH_QUERIES_KEY_DUMMY", "RATE_APP_FROM_SUCCESS_SCREEN_KEY", "getRATE_APP_FROM_SUCCESS_SCREEN_KEY", "RATE_APP_FROM_SUCCESS_SCREEN_VALUE", "getRATE_APP_FROM_SUCCESS_SCREEN_VALUE", "setRATE_APP_FROM_SUCCESS_SCREEN_VALUE", "SHARE_CART_ENABLED", "getSHARE_CART_ENABLED", "setSHARE_CART_ENABLED", "TABBY_AVAILABLE_COUNTRIES_KEY", "getTABBY_AVAILABLE_COUNTRIES_KEY", "WHATSAPP_NUMBERS_KEY", "getWHATSAPP_NUMBERS_KEY", "mContactNumberPerCountryList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/ContactNumberPerCountryModel;", "getMContactNumberPerCountryList", "()Ljava/util/ArrayList;", "setMContactNumberPerCountryList", "(Ljava/util/ArrayList;)V", "share_cart_enabled_android_KEY", "getShare_cart_enabled_android_KEY", "tabbyCountriesList", "Lcom/tatayab/model/responses/TabbyCountryModel;", "getTabbyCountriesList", "setTabbyCountriesList", "whatsAppContacts", "getWhatsAppContacts", "setWhatsAppContacts", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getWhatsAppContacts() {
            return null;
        }
        
        public final void setWhatsAppContacts(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getWHATSAPP_NUMBERS_KEY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTABBY_AVAILABLE_COUNTRIES_KEY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCONTACT_US_PHONE_NUMBERS_KEY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCONCIERGE_KEY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getRATE_APP_FROM_SUCCESS_SCREEN_KEY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getShare_cart_enabled_android_KEY() {
            return null;
        }
        
        public final boolean getCONCIERGE_VALUE() {
            return false;
        }
        
        public final void setCONCIERGE_VALUE(boolean p0) {
        }
        
        public final boolean getSHARE_CART_ENABLED() {
            return false;
        }
        
        public final void setSHARE_CART_ENABLED(boolean p0) {
        }
        
        public final boolean getRATE_APP_FROM_SUCCESS_SCREEN_VALUE() {
            return false;
        }
        
        public final void setRATE_APP_FROM_SUCCESS_SCREEN_VALUE(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getENABLE_GRAPH_QUERIES_KEY() {
            return null;
        }
        
        public final void setENABLE_GRAPH_QUERIES_KEY(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getENABLE_GRAPH_QUERIES_KEY_DUMMY() {
            return null;
        }
        
        public final void setENABLE_GRAPH_QUERIES_KEY_DUMMY(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.tatayab.model.responses.TabbyCountryModel> getTabbyCountriesList() {
            return null;
        }
        
        public final void setTabbyCountriesList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.tatayab.model.responses.TabbyCountryModel> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.tatayab.model.responses.ContactNumberPerCountryModel> getMContactNumberPerCountryList() {
            return null;
        }
        
        public final void setMContactNumberPerCountryList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.tatayab.model.responses.ContactNumberPerCountryModel> p0) {
        }
    }
}