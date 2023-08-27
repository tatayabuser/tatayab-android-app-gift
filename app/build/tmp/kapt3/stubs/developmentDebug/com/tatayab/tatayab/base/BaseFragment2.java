package com.tatayab.tatayab.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0017\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u00a2\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0004J\u0006\u0010\u001c\u001a\u00020\fJ\b\u0010\u001d\u001a\u00020\fH\u0007J\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\b\u0010 \u001a\u00020!H&J\u0012\u0010\"\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\nH\u0016J$\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020(2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020!H\u0004J\u0018\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u000204H\u0004J\u001a\u00105\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u000204H\u0004J\u0018\u00106\u001a\u00020\n2\u0006\u0010.\u001a\u00020(2\u0006\u00102\u001a\u00020\fH\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u00067"}, d2 = {"Lcom/tatayab/tatayab/base/BaseFragment2;", "Landroidx/fragment/app/Fragment;", "()V", "baseViewModelFactory", "Lcom/tatayab/tatayab/injection/ViewModelFactory;", "getBaseViewModelFactory", "()Lcom/tatayab/tatayab/injection/ViewModelFactory;", "setBaseViewModelFactory", "(Lcom/tatayab/tatayab/injection/ViewModelFactory;)V", "addCustomLogToCrashlytics", "", "country", "", "langCode", "userId", "email", "userName", "addObjectToFireBase", "fireBaseLog", "Lcom/tatayab/model/ResponseLogOnFireBase;", "key", "firstTimeCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "firstTimeCreated$app_developmentDebug", "formatePhoneErrorMessage", "validateMessage", "getLangCode", "getUniqueDeviceID", "isInteger", "str", "layoutId", "", "onActivityCreated", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setProgress", "visibility", "showCustomSuccessDialog", "message", "mMessageType", "Lcom/tatayab/tatayab/util/DialogUtil$MessageType;", "showCustomTopMessage", "showErrorDialog", "app_developmentDebug"})
public abstract class BaseFragment2 extends androidx.fragment.app.Fragment {
    @javax.inject.Inject
    public com.tatayab.tatayab.injection.ViewModelFactory baseViewModelFactory;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragment2() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.injection.ViewModelFactory getBaseViewModelFactory() {
        return null;
    }
    
    public final void setBaseViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.injection.ViewModelFactory p0) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLangCode() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract int layoutId();
    
    public final void addObjectToFireBase(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ResponseLogOnFireBase fireBaseLog, @org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public void onBackPressed() {
    }
    
    public final boolean firstTimeCreated$app_developmentDebug(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return false;
    }
    
    protected final void setProgress(int visibility) {
    }
    
    public final void addCustomLogToCrashlytics(@org.jetbrains.annotations.NotNull
    java.lang.String country, @org.jetbrains.annotations.NotNull
    java.lang.String langCode, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String userName) {
    }
    
    protected final void showErrorDialog(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    protected final void showCustomSuccessDialog(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    protected final void showCustomTopMessage(@org.jetbrains.annotations.Nullable
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    public final java.lang.String getUniqueDeviceID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected final java.lang.String formatePhoneErrorMessage(@org.jetbrains.annotations.NotNull
    java.lang.String validateMessage) {
        return null;
    }
    
    public final boolean isInteger(@org.jetbrains.annotations.Nullable
    java.lang.String str) {
        return false;
    }
}