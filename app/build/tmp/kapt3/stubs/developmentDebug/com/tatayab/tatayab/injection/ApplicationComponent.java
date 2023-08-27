package com.tatayab.tatayab.injection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/injection/ApplicationComponent;", "", "sharedPrefAppSettings", "Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "getSharedPrefAppSettings", "()Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "inject", "", "app", "Lcom/tatayab/tatayab/App;", "Builder", "app_developmentDebug"})
@javax.inject.Singleton
@dagger.Component(modules = {dagger.android.support.AndroidSupportInjectionModule.class, com.tatayab.tatayab.injection.module.ApplicationModule.class, com.tatayab.tatayab.injection.module.UIModule.class, com.tatayab.tatayab.injection.module.PresentationModule.class, com.tatayab.tatayab.injection.module.DataModule.class, com.tatayab.tatayab.injection.module.CacheModule.class, com.tatayab.tatayab.injection.module.RemoteModule.class, com.tatayab.tatayab.injection.AssistedInjectModule.class, com.tatayab.tatayab.injection.module.AppSettingsModule.class, com.tatayab.tatayab.injection.module.LocalizationModule.class})
public abstract interface ApplicationComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.App app);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.tatayab.tatayab.util.SharedPrefAppSettings getSharedPrefAppSettings();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tatayab/tatayab/injection/ApplicationComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/tatayab/tatayab/injection/ApplicationComponent;", "app_developmentDebug"})
    @dagger.Component.Builder
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull
        @dagger.BindsInstance
        public abstract com.tatayab.tatayab.injection.ApplicationComponent.Builder application(@org.jetbrains.annotations.NotNull
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.tatayab.tatayab.injection.ApplicationComponent build();
    }
}