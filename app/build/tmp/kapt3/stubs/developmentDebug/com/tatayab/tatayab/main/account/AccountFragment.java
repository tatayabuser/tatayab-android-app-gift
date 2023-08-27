package com.tatayab.tatayab.main.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,H\u0002J\u0018\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,H\u0002J,\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/0*j\b\u0012\u0004\u0012\u00020/`,2\u0006\u00100\u001a\u00020\f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001bH\u0002J\"\u00102\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,2\b\u00101\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000206H\u0002J\"\u00107\u001a\u0002062\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u0002062\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020>H\u0016J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020CH\u0016J\u001a\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0006\u0010G\u001a\u000206J\b\u0010H\u001a\u000206H\u0002J\u0010\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020\fH\u0002J\b\u0010K\u001a\u000206H\u0002J\b\u0010L\u001a\u000206H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u0006M"}, d2 = {"Lcom/tatayab/tatayab/main/account/AccountFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/util/NavigationResult;", "Lcom/tatayab/tatayab/listener/OnAccountItemClick;", "()V", "adapter", "Lcom/tatayab/tatayab/main/account/AccountBlockAdapter;", "getAdapter", "()Lcom/tatayab/tatayab/main/account/AccountBlockAdapter;", "setAdapter", "(Lcom/tatayab/tatayab/main/account/AccountBlockAdapter;)V", "isUpdateCountry", "", "isUpdateToken", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "userEmail", "", "getUserEmail", "()Ljava/lang/String;", "setUserEmail", "(Ljava/lang/String;)V", "userName", "getUserName", "setUserName", "viewModel", "Lcom/tatayab/presentation/account/AccountFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/account/AccountFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/account/AccountFragmentViewModel;)V", "getAccountItems", "Ljava/util/ArrayList;", "Lcom/tatayab/model/account/ItemValue;", "Lkotlin/collections/ArrayList;", "getContactItems", "getItemsForLogin", "Lcom/tatayab/model/account/AccountItem;", "isLogin", "countryName", "getSettingItems", "layoutId", "", "logoutFun", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationResult", "result", "onSettingItemSelected", "actionType", "Lcom/tatayab/model/account/ViewTypeAction;", "onViewCreated", "view", "Landroid/view/View;", "openWalletAutomatic", "rateApp", "setAccountFragment", "isLoggedIn", "shareApp", "showLogoutConfirmationDialog", "app_developmentDebug"})
public final class AccountFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.util.NavigationResult, com.tatayab.tatayab.listener.OnAccountItemClick {
    @javax.inject.Inject
    public com.tatayab.presentation.account.AccountFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.main.account.AccountBlockAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private java.lang.String userName = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String userEmail = "";
    private boolean isUpdateToken = false;
    private boolean isUpdateCountry = false;
    private java.util.HashMap _$_findViewCache;
    
    public AccountFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.account.AccountFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.account.AccountFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.main.account.AccountBlockAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.main.account.AccountBlockAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserEmail() {
        return null;
    }
    
    public final void setUserEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onNavigationResult(@org.jetbrains.annotations.NotNull
    android.os.Bundle result) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void logoutFun() {
    }
    
    private final void rateApp() {
    }
    
    private final void shareApp() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showLogoutConfirmationDialog() {
    }
    
    private final void setAccountFragment(boolean isLoggedIn) {
    }
    
    private final java.util.ArrayList<com.tatayab.model.account.AccountItem> getItemsForLogin(boolean isLogin, java.lang.String countryName) {
        return null;
    }
    
    private final java.util.ArrayList<com.tatayab.model.account.ItemValue> getSettingItems(java.lang.String countryName) {
        return null;
    }
    
    private final java.util.ArrayList<com.tatayab.model.account.ItemValue> getAccountItems() {
        return null;
    }
    
    private final java.util.ArrayList<com.tatayab.model.account.ItemValue> getContactItems() {
        return null;
    }
    
    @java.lang.Override
    public void onSettingItemSelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.account.ViewTypeAction actionType) {
    }
    
    public final void openWalletAutomatic() {
    }
}