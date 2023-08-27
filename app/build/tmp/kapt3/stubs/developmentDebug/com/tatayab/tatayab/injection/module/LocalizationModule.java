package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/injection/module/LocalizationModule;", "", "()V", "getLocalizedResources", "Landroid/content/res/Resources;", "context", "Landroid/content/Context;", "locale", "Ljava/util/Locale;", "providesArabicResources", "providesEnglishResources", "app_developmentDebug"})
@dagger.Module
public final class LocalizationModule {
    
    public LocalizationModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @LanguageKey(value = com.tatayab.tatayab.util.Language.English)
    @dagger.multibindings.IntoMap
    @dagger.Provides
    public final android.content.res.Resources providesEnglishResources(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @LanguageKey(value = com.tatayab.tatayab.util.Language.Arabic)
    @dagger.multibindings.IntoMap
    @dagger.Provides
    public final android.content.res.Resources providesArabicResources(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    private final android.content.res.Resources getLocalizedResources(android.content.Context context, java.util.Locale locale) {
        return null;
    }
}