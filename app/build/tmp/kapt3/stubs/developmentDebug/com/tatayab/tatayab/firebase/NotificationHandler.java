package com.tatayab.tatayab.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J4\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001aH\u0007R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tatayab/tatayab/firebase/NotificationHandler;", "", "()V", "mNotificationListener", "Lcom/tatayab/tatayab/firebase/NotificationHandler$NotificationListener;", "getMNotificationListener$annotations", "getMNotificationListener", "()Lcom/tatayab/tatayab/firebase/NotificationHandler$NotificationListener;", "setMNotificationListener", "(Lcom/tatayab/tatayab/firebase/NotificationHandler$NotificationListener;)V", "token", "Landroidx/lifecycle/MutableLiveData;", "", "getToken", "()Landroidx/lifecycle/MutableLiveData;", "generateBitmapFromVectorDrawable", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "drawableId", "", "sendNotification", "", "messageBody", "title", "data", "", "NotificationListener", "app_developmentDebug"})
public final class NotificationHandler {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.firebase.NotificationHandler INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.lifecycle.MutableLiveData<java.lang.String> token = null;
    @org.jetbrains.annotations.Nullable
    private static com.tatayab.tatayab.firebase.NotificationHandler.NotificationListener mNotificationListener;
    
    private NotificationHandler() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final com.tatayab.tatayab.firebase.NotificationHandler.NotificationListener getMNotificationListener() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    @java.lang.Deprecated
    public static void getMNotificationListener$annotations() {
    }
    
    public static final void setMNotificationListener(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.firebase.NotificationHandler.NotificationListener p0) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void sendNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String messageBody, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.String> data) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Bitmap generateBitmapFromVectorDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, int drawableId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tatayab/tatayab/firebase/NotificationHandler$NotificationListener;", "", "showNotificationDialog", "", "title", "", "message", "dataBundle", "Landroid/os/Bundle;", "app_developmentDebug"})
    public static abstract interface NotificationListener {
        
        public abstract void showNotificationDialog(@org.jetbrains.annotations.NotNull
        java.lang.String title, @org.jetbrains.annotations.NotNull
        java.lang.String message, @org.jetbrains.annotations.NotNull
        android.os.Bundle dataBundle);
    }
}