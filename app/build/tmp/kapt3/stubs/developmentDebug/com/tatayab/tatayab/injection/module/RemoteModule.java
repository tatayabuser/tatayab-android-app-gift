package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tatayab/tatayab/injection/module/RemoteModule;", "", "()V", "bindTatayabRemote", "Lcom/tatayab/data/repository/TatayabRemote;", "tatayabRemote", "Lcom/tatayab/remote/TatayabRemoteImpl;", "provideConnectivityInterceptor", "Lcom/tatayab/remote/interceptor/ConnectivityInterceptor;", "context", "Landroid/content/Context;", "provideQraphQlTatayabService", "Lcom/tatayab/remote/service/QraphQlServiceEndPoint;", "repository", "Lcom/tatayab/data/source/TatayabCacheDataSource;", "provideSettingInterceptor", "Lcom/tatayab/remote/interceptor/SettingInterceptor;", "provideTatayabService", "Lcom/tatayab/remote/service/TatayabServiceEndPoint;", "provideUserTatayabService", "Lcom/tatayab/remote/service/UserTatayabServiceEndPoint;", "provideWalletTatayabService", "Lcom/tatayab/remote/service/WalletTatayabServiceEndPoint;", "app_developmentDebug"})
@dagger.Module
public final class RemoteModule {
    
    public RemoteModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.tatayab.remote.interceptor.ConnectivityInterceptor provideConnectivityInterceptor(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.tatayab.remote.interceptor.SettingInterceptor provideSettingInterceptor(@org.jetbrains.annotations.NotNull
    com.tatayab.data.source.TatayabCacheDataSource repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.remote.service.QraphQlServiceEndPoint provideQraphQlTatayabService(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.tatayab.data.source.TatayabCacheDataSource repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.remote.service.TatayabServiceEndPoint provideTatayabService(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.tatayab.data.source.TatayabCacheDataSource repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.remote.service.WalletTatayabServiceEndPoint provideWalletTatayabService(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.tatayab.data.source.TatayabCacheDataSource repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.remote.service.UserTatayabServiceEndPoint provideUserTatayabService(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.tatayab.data.source.TatayabCacheDataSource repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.tatayab.data.repository.TatayabRemote bindTatayabRemote(@org.jetbrains.annotations.NotNull
    com.tatayab.remote.TatayabRemoteImpl tatayabRemote) {
        return null;
    }
}