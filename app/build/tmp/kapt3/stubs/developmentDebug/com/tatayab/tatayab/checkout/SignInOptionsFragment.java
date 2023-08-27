package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001PB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002JB\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u00010\u001d2\b\u00109\u001a\u0004\u0018\u00010\u001d2\b\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\"\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u0002032\u0006\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020*H\u0016J\u0012\u0010C\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010F\u001a\u00020*2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020EH\u0016J\u0012\u0010K\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020N2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010O\u001a\u00020*H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/tatayab/tatayab/checkout/SignInOptionsFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "Lcom/tatayab/tatayab/util/NavigationResult;", "()V", "callbackManager", "Lcom/facebook/CallbackManager;", "fromCheckout", "", "getFromCheckout", "()Z", "fromCheckout$delegate", "Lkotlin/Lazy;", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "registerType", "", "socialToken", "userName", "userSocialLoginViewModelFactory", "Lcom/tatayab/presentation/auth/UserSocialLoginViewModelFactory$Factory;", "getUserSocialLoginViewModelFactory", "()Lcom/tatayab/presentation/auth/UserSocialLoginViewModelFactory$Factory;", "setUserSocialLoginViewModelFactory", "(Lcom/tatayab/presentation/auth/UserSocialLoginViewModelFactory$Factory;)V", "viewModel", "Lcom/tatayab/presentation/auth/UserSocialLoginViewModel;", "checkDeclinedPermissionAreEmpty", "createCartForUser", "", "getUserProfileWithGraphRequest", "accessToken", "Lcom/facebook/AccessToken;", "handleSignInResult", "completedTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "layoutId", "", "loginWithEmail", "loginWithParameters", "loginWithSocial", "email", "phone", "firstname", "reg_type", "social_id", "langCode", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "error", "Lcom/facebook/FacebookException;", "onNavigationResult", "result", "onSuccess", "onViewCreated", "view", "Landroid/view/View;", "returnToCheckout", "Companion", "app_developmentDebug"})
public final class SignInOptionsFragment extends com.tatayab.tatayab.base.BaseFragment implements com.facebook.FacebookCallback<com.facebook.login.LoginResult>, com.tatayab.tatayab.util.NavigationResult {
    private com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    private com.facebook.CallbackManager callbackManager;
    private java.lang.String socialToken = "";
    private java.lang.String userName = "";
    private java.lang.String registerType = "";
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    @javax.inject.Inject
    public com.tatayab.presentation.auth.UserSocialLoginViewModelFactory.Factory userSocialLoginViewModelFactory;
    private com.tatayab.presentation.auth.UserSocialLoginViewModel viewModel;
    private final kotlin.Lazy fromCheckout$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.checkout.SignInOptionsFragment.Companion Companion = null;
    private static final int RC_SIGN_IN = 9001;
    private java.util.HashMap _$_findViewCache;
    
    public SignInOptionsFragment() {
        super();
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
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.auth.UserSocialLoginViewModelFactory.Factory getUserSocialLoginViewModelFactory() {
        return null;
    }
    
    public final void setUserSocialLoginViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.auth.UserSocialLoginViewModelFactory.Factory p0) {
    }
    
    private final boolean getFromCheckout() {
        return false;
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void createCartForUser() {
    }
    
    private final void returnToCheckout() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loginWithParameters() {
    }
    
    private final boolean checkDeclinedPermissionAreEmpty() {
        return false;
    }
    
    private final void getUserProfileWithGraphRequest(com.facebook.AccessToken accessToken) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void handleSignInResult(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    com.facebook.login.LoginResult result) {
    }
    
    @java.lang.Override
    public void onCancel() {
    }
    
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.Nullable
    com.facebook.FacebookException error) {
    }
    
    private final void loginWithSocial(java.lang.String email, java.lang.String phone, java.lang.String firstname, java.lang.String reg_type, java.lang.String social_id, java.lang.String langCode) {
    }
    
    private final void loginWithEmail() {
    }
    
    @java.lang.Override
    public void onNavigationResult(@org.jetbrains.annotations.NotNull
    android.os.Bundle result) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tatayab/tatayab/checkout/SignInOptionsFragment$Companion;", "", "()V", "RC_SIGN_IN", "", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}