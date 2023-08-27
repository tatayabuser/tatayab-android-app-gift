package com.tatayab.tatayab.base;

import java.lang.System;

@android.annotation.SuppressLint(value = {"Registered"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0004J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0004J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0004J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\'2\u0006\u0010 \u001a\u00020\u000bH\u0004J \u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tatayab/tatayab/base/BaseActivity2;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/tatayab/tatayab/firebase/NotificationHandler$NotificationListener;", "()V", "dataBundle", "Landroid/os/Bundle;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getCurrentLang", "", "getUniqueDeviceID", "handelNotificationDeepLink", "initNotificationDialog", "isDeeplinkContainsLocalLogic", "", "deepLink", "isInteger", "str", "onCreate", "savedInstanceState", "onPause", "onResume", "openMainActivityDeepLink", "bundle", "progressStatus", "viewStatus", "", "setContentView", "layoutResID", "showCustomSuccessDialog", "message", "mMessageType", "Lcom/tatayab/tatayab/util/DialogUtil$MessageType;", "showCustomTopMessage", "showDialog", "showErrorDialog", "view", "Landroid/view/View;", "showNotificationDialog", "title", "app_developmentDebug"})
public class BaseActivity2 extends androidx.appcompat.app.AppCompatActivity implements com.tatayab.tatayab.firebase.NotificationHandler.NotificationListener {
    private android.os.Bundle dataBundle;
    private java.util.HashMap _$_findViewCache;
    
    @javax.inject.Inject
    public BaseActivity2() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull
    android.content.Context newBase) {
    }
    
    @java.lang.Override
    public void setContentView(int layoutResID) {
    }
    
    private final void initNotificationDialog() {
    }
    
    private final void handelNotificationDeepLink() {
    }
    
    private final void openMainActivityDeepLink(android.os.Bundle bundle) {
    }
    
    private final java.lang.String getCurrentLang() {
        return null;
    }
    
    protected final void progressStatus(int viewStatus) {
    }
    
    protected final void showErrorDialog(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    protected final void showCustomTopMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    protected final void showCustomSuccessDialog(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    protected final void showDialog(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @java.lang.Override
    public void showNotificationDialog(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    android.os.Bundle dataBundle) {
    }
    
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    public final java.lang.String getUniqueDeviceID() {
        return null;
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    public final boolean isDeeplinkContainsLocalLogic(@org.jetbrains.annotations.NotNull
    java.lang.String deepLink) {
        return false;
    }
    
    public final boolean isInteger(@org.jetbrains.annotations.Nullable
    java.lang.String str) {
        return false;
    }
}