package com.tatayab.tatayab;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u000234B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010\'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00065"}, d2 = {"Lcom/tatayab/tatayab/App;", "Landroidx/multidex/MultiDexApplication;", "Ldagger/android/HasActivityInjector;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "androidFragmentInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidFragmentInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidFragmentInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "androidInjector", "Landroid/app/Activity;", "getAndroidInjector", "setAndroidInjector", "appSettings", "Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "getAppSettings", "()Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "setAppSettings", "(Lcom/tatayab/tatayab/util/SharedPrefAppSettings;)V", "component", "Lcom/tatayab/tatayab/injection/ApplicationComponent;", "getComponent", "()Lcom/tatayab/tatayab/injection/ApplicationComponent;", "component$delegate", "Lkotlin/Lazy;", "activityInjector", "Ldagger/android/AndroidInjector;", "attachBaseContext", "", "base", "Landroid/content/Context;", "configureLeakCanary", "isEnabled", "", "enableTls12", "initAdjust", "initInSiderSDK", "initInsiderCallBacks", "initializeSmartLook", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "setUpFacebookIntegration", "setupDagger", "setupTimber", "setupTwitterIntegration", "supportFragmentInjector", "AdjustLifecycleCallbacks", "Companion", "app_developmentDebug"})
public final class App extends androidx.multidex.MultiDexApplication implements dagger.android.HasActivityInjector, dagger.android.support.HasSupportFragmentInjector {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy component$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.App.Companion Companion = null;
    private static com.tatayab.tatayab.util.SharedPrefAppSettings prefAppSettings;
    @javax.inject.Inject
    public dagger.android.DispatchingAndroidInjector<androidx.fragment.app.Fragment> androidFragmentInjector;
    @javax.inject.Inject
    public dagger.android.DispatchingAndroidInjector<android.app.Activity> androidInjector;
    @javax.inject.Inject
    public com.tatayab.tatayab.util.SharedPrefAppSettings appSettings;
    
    public App() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.injection.ApplicationComponent getComponent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final dagger.android.DispatchingAndroidInjector<androidx.fragment.app.Fragment> getAndroidFragmentInjector() {
        return null;
    }
    
    public final void setAndroidFragmentInjector(@org.jetbrains.annotations.NotNull
    dagger.android.DispatchingAndroidInjector<androidx.fragment.app.Fragment> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final dagger.android.DispatchingAndroidInjector<android.app.Activity> getAndroidInjector() {
        return null;
    }
    
    public final void setAndroidInjector(@org.jetbrains.annotations.NotNull
    dagger.android.DispatchingAndroidInjector<android.app.Activity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.util.SharedPrefAppSettings getAppSettings() {
        return null;
    }
    
    public final void setAppSettings(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.SharedPrefAppSettings p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public dagger.android.AndroidInjector<android.app.Activity> activityInjector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public dagger.android.AndroidInjector<androidx.fragment.app.Fragment> supportFragmentInjector() {
        return null;
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull
    android.content.Context base) {
    }
    
    @java.lang.Override
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void initInSiderSDK() {
    }
    
    private final void initInsiderCallBacks() {
    }
    
    private final void initAdjust() {
    }
    
    private final void initializeSmartLook() {
    }
    
    private final void enableTls12() {
    }
    
    private final void configureLeakCanary(boolean isEnabled) {
    }
    
    private final void setUpFacebookIntegration() {
    }
    
    private final void setupTwitterIntegration() {
    }
    
    private final void setupDagger() {
    }
    
    private final void setupTimber() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tatayab/tatayab/App$AdjustLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "p0", "p1", "onActivityStarted", "onActivityStopped", "app_developmentDebug"})
    static final class AdjustLifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        
        public AdjustLifecycleCallbacks() {
            super();
        }
        
        @java.lang.Override
        public void onActivityResumed(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
        
        @java.lang.Override
        public void onActivityPaused(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
        
        @java.lang.Override
        public void onActivityStopped(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
        
        @java.lang.Override
        public void onActivitySaveInstanceState(@org.jetbrains.annotations.NotNull
        android.app.Activity p0, @org.jetbrains.annotations.NotNull
        android.os.Bundle p1) {
        }
        
        @java.lang.Override
        public void onActivityDestroyed(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
        
        @java.lang.Override
        public void onActivityCreated(@org.jetbrains.annotations.NotNull
        android.app.Activity activity, @org.jetbrains.annotations.Nullable
        android.os.Bundle savedInstanceState) {
        }
        
        @java.lang.Override
        public void onActivityStarted(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tatayab/tatayab/App$Companion;", "", "()V", "prefAppSettings", "Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "getPref", "init", "", "settings", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void init(@org.jetbrains.annotations.NotNull
        com.tatayab.tatayab.util.SharedPrefAppSettings settings) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.tatayab.tatayab.util.SharedPrefAppSettings getPref() {
            return null;
        }
    }
}