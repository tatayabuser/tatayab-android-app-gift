package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tatayab/tatayab/injection/module/AppSettingsModule;", "", "()V", "provideAppSettings", "Lcom/tatayab/tatayab/util/SharedPrefAppSettings;", "context", "Landroid/content/Context;", "app_developmentDebug"})
@dagger.Module
public final class AppSettingsModule {
    
    public AppSettingsModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.tatayab.tatayab.util.SharedPrefAppSettings provideAppSettings(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}