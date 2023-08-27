package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004032\u0006\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u00107\u001a\u0004\u0018\u000108H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010;\u001a\u00020\u0017J\"\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010A\u001a\u00020=H\u0002J\b\u0010B\u001a\u00020=H\u0003J\b\u0010C\u001a\u00020\u0014H\u0016J\"\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020=H\u0016J\u001a\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010N\u001a\u00020\u00172\b\u0010O\u001a\u0004\u0018\u00010\u0004H\u0003J\b\u0010P\u001a\u00020=H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0012\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/tatayab/tatayab/checkout/PaymentFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "()V", "P_Tag", "", "getP_Tag", "()Ljava/lang/String;", "PaymentFragmentViewModelFactor", "Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory$Factory;", "getPaymentFragmentViewModelFactor", "()Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory$Factory;", "setPaymentFragmentViewModelFactor", "(Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory$Factory;)V", "cam_file_data", "file_data", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "file_path", "", "file_req_code", "", "file_type", "isEntryLoaded", "", "()Z", "setEntryLoaded", "(Z)V", "isPayLoaded", "setPayLoaded", "logParams", "Landroid/os/Bundle;", "getLogParams", "()Landroid/os/Bundle;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "multiple_files", "orderData", "Lcom/tatayab/model/responses/CreateOrderResponse;", "getOrderData", "()Lcom/tatayab/model/responses/CreateOrderResponse;", "orderData$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModel;", "checkForSuccess", "Lkotlin/Pair;", "uri", "ttmPgstats", "result", "create_image", "Ljava/io/File;", "decodeBase64", "coded", "file_permission", "handleError", "", "errorCode", "description", "failingUrl", "initAction", "intComponent", "layoutId", "onActivityResult", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onBackPressed", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "shouldOverrideUrlLoading", "url", "updateCartId", "app_developmentDebug"})
public final class PaymentFragment extends com.tatayab.tatayab.base.BaseFragment {
    private final java.lang.String file_type = "*/*";
    private boolean multiple_files = true;
    private java.lang.String cam_file_data;
    private android.webkit.ValueCallback<android.net.Uri> file_data;
    private android.webkit.ValueCallback<android.net.Uri[]> file_path;
    private final int file_req_code = 1;
    private com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    private com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    @javax.inject.Inject
    public com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory.Factory PaymentFragmentViewModelFactor;
    @org.jetbrains.annotations.NotNull
    private final android.os.Bundle logParams = null;
    private final kotlin.Lazy orderData$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String P_Tag = "Payment url: ";
    private boolean isEntryLoaded = false;
    private boolean isPayLoaded = false;
    private java.util.HashMap _$_findViewCache;
    
    public PaymentFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory.Factory getPaymentFragmentViewModelFactor() {
        return null;
    }
    
    public final void setPaymentFragmentViewModelFactor(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.os.Bundle getLogParams() {
        return null;
    }
    
    private final com.tatayab.model.responses.CreateOrderResponse getOrderData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getP_Tag() {
        return null;
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initAction() {
    }
    
    public final boolean isEntryLoaded() {
        return false;
    }
    
    public final void setEntryLoaded(boolean p0) {
    }
    
    public final boolean isPayLoaded() {
        return false;
    }
    
    public final void setPayLoaded(boolean p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void intComponent() {
    }
    
    private final java.lang.String decodeBase64(java.lang.String coded) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"InvalidAnalyticsName"})
    private final boolean shouldOverrideUrlLoading(java.lang.String url) {
        return false;
    }
    
    private final void handleError(int errorCode, java.lang.String description, java.lang.String failingUrl) {
    }
    
    private final kotlin.Pair<java.lang.Boolean, java.lang.String> checkForSuccess(android.net.Uri uri, java.lang.String ttmPgstats, java.lang.String result) {
        return null;
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    public final boolean file_permission() {
        return false;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    private final java.io.File create_image() throws java.io.IOException {
        return null;
    }
    
    private final void updateCartId() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
}