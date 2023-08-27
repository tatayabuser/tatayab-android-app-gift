package com.tatayab.tatayab.deeplink;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\"H\u0002J\u0012\u0010\'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020)H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/tatayab/tatayab/deeplink/DeepLinkActivity;", "Lcom/tatayab/tatayab/base/BaseActivity2;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "categoryName", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "checkIntent", "", "intent", "Landroid/content/Intent;", "getCategoryName", "deepLink", "getDeepLink", "getDeepLinkQueryParameter", "key", "handelCustomDeeplink", "uri", "handelExtractUrl", "type", "id", "handleDeeplinkLocal", "Landroid/net/Uri;", "url", "handleShareCartDeeplink", "initDynamicLink", "deepLinkURI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openMainActivityDeepLink", "bundle", "app_developmentDebug"})
public final class DeepLinkActivity extends com.tatayab.tatayab.base.BaseActivity2 {
    private final java.lang.String TAG = null;
    private java.lang.String categoryName = "";
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    private java.util.HashMap _$_findViewCache;
    
    public DeepLinkActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handelCustomDeeplink(java.lang.String uri) {
    }
    
    private final void checkIntent(android.content.Intent intent) {
    }
    
    private final void initDynamicLink(android.net.Uri deepLinkURI) {
    }
    
    private final void handleShareCartDeeplink(android.net.Uri deepLink) {
    }
    
    private final void getCategoryName(java.lang.String deepLink) {
    }
    
    public final void handelExtractUrl(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String id) {
    }
    
    private final void handleDeeplinkLocal(android.net.Uri deepLink) {
    }
    
    private final void handleDeeplinkLocal(java.lang.String url) {
    }
    
    private final void openMainActivityDeepLink(android.os.Bundle bundle) {
    }
    
    @androidx.annotation.Nullable
    private final java.lang.String getDeepLink() {
        return null;
    }
    
    private final java.lang.String getDeepLinkQueryParameter(java.lang.String key) {
        return null;
    }
}