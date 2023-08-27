package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tatayab/tatayab/injection/module/CacheModule;", "", "()V", "providesTatayabCache", "Lcom/tatayab/data/repository/TatayabCache;", "tatayabCache", "Lcom/tatayab/cache/TatayabCacheImpl;", "providesTatayabPrefrencesDatabase", "Lcom/tatayab/cache/db/TatayabPrefrencesDatabase;", "context", "Landroid/content/Context;", "providesTatayabRoomDatabase", "Lcom/tatayab/cache/db/TatayabRoomDatabase;", "app_developmentDebug"})
@dagger.Module
public final class CacheModule {
    
    public CacheModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.cache.db.TatayabPrefrencesDatabase providesTatayabPrefrencesDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.cache.db.TatayabRoomDatabase providesTatayabRoomDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.data.repository.TatayabCache providesTatayabCache(@org.jetbrains.annotations.NotNull
    com.tatayab.cache.TatayabCacheImpl tatayabCache) {
        return null;
    }
}