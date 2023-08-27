package com.tatayab.tatayab.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0010H\u0016J\u0012\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00101\u001a\u00020(2\u0006\u00102\u001a\u0002032\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u000e\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0010J\b\u00106\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tatayab/tatayab/auth/LoginFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "()V", "EMAIL", "", "FILEDS", "GRAPH_PATH", "MOBILE_NUMBER", "PUBLIC_PROFILE", "SUCCESS", "USER_FIRST_NAME", "USER_ID", "USER_LAST_NAME", "callbackManager", "Lcom/facebook/CallbackManager;", "loginCode", "", "getLoginCode", "()Ljava/lang/Integer;", "loginCode$delegate", "Lkotlin/Lazy;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "passHidden", "", "twitterAuthClient", "Lcom/twitter/sdk/android/core/identity/TwitterAuthClient;", "viewModel", "Lcom/tatayab/presentation/auth/UserLoginViewModel;", "initComponent", "", "layoutId", "moveAfterLoginStep", "userProfile", "Lcom/tatayab/model/responses/AuthenticationResponse;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "setProgressState", "state", "validateData", "app_developmentDebug"})
public final class LoginFragment extends com.tatayab.tatayab.base.BaseFragment {
    private final java.lang.String MOBILE_NUMBER = "verified_mobile_phone";
    private final java.lang.String EMAIL = "email";
    private final java.lang.String PUBLIC_PROFILE = "public_profile";
    private final java.lang.String USER_ID = "id";
    private final java.lang.String USER_FIRST_NAME = "first_name";
    private final java.lang.String USER_LAST_NAME = "last_name";
    private final java.lang.String FILEDS = "fields";
    private final java.lang.String GRAPH_PATH = "me/permissions";
    private final java.lang.String SUCCESS = "success";
    private boolean passHidden = true;
    private com.facebook.CallbackManager callbackManager;
    private com.twitter.sdk.android.core.identity.TwitterAuthClient twitterAuthClient;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    private final kotlin.Lazy loginCode$delegate = null;
    private com.tatayab.presentation.auth.UserLoginViewModel viewModel;
    private java.util.HashMap _$_findViewCache;
    
    public LoginFragment() {
        super();
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    private final java.lang.Integer getLoginCode() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void moveAfterLoginStep(com.tatayab.model.responses.AuthenticationResponse userProfile) {
    }
    
    private final boolean validateData() {
        return false;
    }
    
    private final void initComponent() {
    }
    
    public final void setProgressState(int state) {
    }
}