package com.tatayab.tatayab.util;

import java.lang.System;

/**
 * Sample sync adapter using {@link ProviderInstaller}.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tatayab/tatayab/util/SyncAdapter;", "Landroid/content/AbstractThreadedSyncAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onPerformSync", "", "account", "Landroid/accounts/Account;", "extras", "Landroid/os/Bundle;", "authority", "", "provider", "Landroid/content/ContentProviderClient;", "syncResult", "Landroid/content/SyncResult;", "app_developmentDebug"})
public final class SyncAdapter extends android.content.AbstractThreadedSyncAdapter {
    
    public SyncAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null, false);
    }
    
    @java.lang.Override
    public void onPerformSync(@org.jetbrains.annotations.NotNull
    android.accounts.Account account, @org.jetbrains.annotations.NotNull
    android.os.Bundle extras, @org.jetbrains.annotations.NotNull
    java.lang.String authority, @org.jetbrains.annotations.NotNull
    android.content.ContentProviderClient provider, @org.jetbrains.annotations.NotNull
    android.content.SyncResult syncResult) {
    }
}