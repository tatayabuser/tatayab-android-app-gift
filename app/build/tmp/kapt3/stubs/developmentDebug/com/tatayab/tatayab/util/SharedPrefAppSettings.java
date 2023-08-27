package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0015J\b\u0010\u0010\u001a\u00020\u0015H\u0002J\b\u0010\'\u001a\u00020\u000eH\u0002J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010\u0012\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010,\u001a\u00020#J\u0006\u0010-\u001a\u00020#R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00158V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006/"}, d2 = {"Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "Lcom/tatayab/tatayab/util/AppSettings;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "androidConfiguration", "Landroid/content/res/Configuration;", "getAndroidConfiguration", "()Landroid/content/res/Configuration;", "setAndroidConfiguration", "(Landroid/content/res/Configuration;)V", "getContext", "()Landroid/content/Context;", "value", "Lcom/tatayab/tatayab/util/Language;", "currentLanguage", "getCurrentLanguage", "()Lcom/tatayab/tatayab/util/Language;", "setCurrentLanguage", "(Lcom/tatayab/tatayab/util/Language;)V", "currentLanguageCache", "", "firstUserToken", "getFirstUserToken", "()Ljava/lang/String;", "setFirstUserToken", "(Ljava/lang/String;)V", "firstUserTokenCache", "sharedPref", "Landroid/content/SharedPreferences;", "getSharedPref", "()Landroid/content/SharedPreferences;", "setSharedPref", "(Landroid/content/SharedPreferences;)V", "changeLanguage", "", "activityToBeRestarted", "Landroidx/fragment/app/FragmentActivity;", "selectedLang", "getDefaultLanguage", "isArabic", "", "restartApp", "language", "toggleLanguage", "validateLanguage", "Companion", "app_developmentDebug"})
public final class SharedPrefAppSettings implements com.tatayab.tatayab.util.AppSettings {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private android.content.SharedPreferences sharedPref;
    @org.jetbrains.annotations.NotNull
    private android.content.res.Configuration androidConfiguration;
    private com.tatayab.tatayab.util.Language currentLanguageCache;
    private java.lang.String firstUserTokenCache;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.SharedPrefAppSettings.Companion Companion = null;
    private static final java.lang.String FIRST_UER_TOKEN_KEY = "FIRST_UER_TOKEN_KEY";
    private static final java.lang.String APP_LANGUAGE_KEY = "app_language";
    private static final java.lang.String LOCAL_LANG_AR = "ar";
    private static final java.lang.String LOCAL_LANG_EN = "en";
    
    @javax.inject.Inject
    public SharedPrefAppSettings(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences getSharedPref() {
        return null;
    }
    
    public final void setSharedPref(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.res.Configuration getAndroidConfiguration() {
        return null;
    }
    
    public final void setAndroidConfiguration(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.util.Language getCurrentLanguage() {
        return null;
    }
    
    @java.lang.Override
    public void setCurrentLanguage(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.Language value) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getFirstUserToken() {
        return null;
    }
    
    @java.lang.Override
    public void setFirstUserToken(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    private final com.tatayab.tatayab.util.Language getDefaultLanguage() {
        return null;
    }
    
    public final void validateLanguage() {
    }
    
    public final void toggleLanguage() {
    }
    
    public final void restartApp(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activityToBeRestarted) {
    }
    
    public final void changeLanguage(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activityToBeRestarted, @org.jetbrains.annotations.NotNull
    java.lang.String selectedLang) {
    }
    
    public final boolean isArabic() {
        return false;
    }
    
    private final java.lang.String getCurrentLanguage() {
        return null;
    }
    
    private final void setCurrentLanguage(java.lang.String language) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tatayab/tatayab/util/SharedPrefAppSettings$Companion;", "", "()V", "APP_LANGUAGE_KEY", "", "FIRST_UER_TOKEN_KEY", "LOCAL_LANG_AR", "LOCAL_LANG_EN", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}