package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001xB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020BH\u0002J\b\u0010H\u001a\u00020BH\u0002J\u0010\u0010I\u001a\u00020B2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020B2\u0006\u0010J\u001a\u00020KH\u0002J\u0018\u0010M\u001a\u0004\u0018\u00010,2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020,0OH\u0002J\b\u0010P\u001a\u00020BH\u0002J \u0010Q\u001a\u00020B2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u00072\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010U\u001a\u00020B2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010OH\u0002J\b\u0010X\u001a\u00020BH\u0002J\b\u0010Y\u001a\u00020BH\u0002J\b\u0010Z\u001a\u00020BH\u0002J\b\u0010[\u001a\u00020DH\u0016J\b\u0010\\\u001a\u00020BH\u0002J\u0018\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020.2\u0006\u0010_\u001a\u00020\u0012H\u0002J\u0012\u0010`\u001a\u00020B2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u00020B2\u0006\u0010d\u001a\u00020,H\u0016J\u0010\u0010e\u001a\u00020B2\u0006\u0010d\u001a\u00020,H\u0016J\b\u0010f\u001a\u00020BH\u0016J\u001a\u0010g\u001a\u00020B2\u0006\u0010h\u001a\u00020K2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010i\u001a\u00020BH\u0002J\u0010\u0010j\u001a\u00020B2\u0006\u0010k\u001a\u00020.H\u0002J\u0010\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020nH\u0002J\b\u0010o\u001a\u00020BH\u0002J\u0010\u0010p\u001a\u00020B2\u0006\u0010q\u001a\u00020DH\u0002J\u0010\u0010r\u001a\u00020\u00122\u0006\u0010s\u001a\u00020\u0010H\u0002J\u0006\u0010t\u001a\u00020BJ\b\u0010u\u001a\u00020BH\u0002J\u0010\u0010v\u001a\u00020B2\u0006\u0010m\u001a\u00020nH\u0002J\b\u0010w\u001a\u00020BH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006y"}, d2 = {"Lcom/tatayab/tatayab/checkout/CheckoutFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/checkout/PaymentListener;", "Lcom/tatayab/tatayab/listener/OnCheckoutProductSelected;", "()V", "addToWishListResultToAdapter", "Lcom/tatayab/presentation/SingleLiveEvent;", "Lcom/tatayab/presentation/state/Resource;", "Lcom/tatayab/model/responses/AddToWishListResponse;", "addressViewModel", "Lcom/tatayab/presentation/address/AddressFragmentViewModel;", "getAddressViewModel", "()Lcom/tatayab/presentation/address/AddressFragmentViewModel;", "setAddressViewModel", "(Lcom/tatayab/presentation/address/AddressFragmentViewModel;)V", "avalAmount", "", "go", "", "getGo", "()Z", "go$delegate", "Lkotlin/Lazy;", "mCheckOutAddressModel", "Lcom/tatayab/model/responses/CheckOutAddressModel;", "mPaymentMethodsAdapter", "Lcom/tatayab/tatayab/checkout/PaymentMethodsAdapter;", "mProductsForCountriesAdapter", "Lcom/tatayab/tatayab/checkout/ProductsForCountriesAdapter;", "mSubTotalAdapter", "Lcom/tatayab/tatayab/checkout/CheckOutLabelsAdapter;", "mSubTotalForCountriesAdapter", "Lcom/tatayab/tatayab/checkout/SubtTotalForCountriesAdapter;", "mTotalAdapter", "Lcom/tatayab/tatayab/checkout/CheckOutTotalLabelsAdapter;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "paymentMethodSelected", "Lcom/tatayab/model/responses/CheckOutPaymentModel;", "totalAmount", "", "viewModel", "Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModel;)V", "viewModelFactoryAddress", "Lcom/tatayab/presentation/address/AddressFragmentViewModelFactory$Factory;", "getViewModelFactoryAddress", "()Lcom/tatayab/presentation/address/AddressFragmentViewModelFactory$Factory;", "setViewModelFactoryAddress", "(Lcom/tatayab/presentation/address/AddressFragmentViewModelFactory$Factory;)V", "viewModelFactoryCheckout", "Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModelFactory$Factory;", "getViewModelFactoryCheckout", "()Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModelFactory$Factory;", "setViewModelFactoryCheckout", "(Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModelFactory$Factory;)V", "addToWishList", "", "position", "", "product", "Lcom/tatayab/model/Product;", "changeAddress", "checkContinuaOrBack", "collapse", "v", "Landroid/view/View;", "expand", "getFreeMethod", "it", "", "gotoAddAddress", "handelAndUpdateData", "Lcom/tatayab/model/responses/ReviewCartResponse;", "mActionName", "Lcom/tatayab/tatayab/checkout/CheckoutFragment$ActionName;", "handleAddressesResponse", "addresses", "Lcom/tatayab/model/requests/AddressRequest;", "initActions", "initView", "initViewModels", "layoutId", "navigateToLogin", "notifyHomeWithChanges", "productID", "newStatues", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPaymentMethodDefaultSelected", "model", "onPaymentMethodSelected", "onResume", "onViewCreated", "view", "recallCheckoutApi", "reloadCheckoutData", "addressId", "returnWithSuccessOrder", "orderResponse", "Lcom/tatayab/model/responses/CreateOrderResponse;", "setAdapters", "setProgressView", "visible", "shouldAddCredit", "totalCost", "showLoginDialog", "showLoginScreen", "showPaymentScreen", "updateCartId", "ActionName", "app_developmentDebug"})
public final class CheckoutFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.checkout.PaymentListener, com.tatayab.tatayab.listener.OnCheckoutProductSelected {
    private com.tatayab.model.responses.CheckOutPaymentModel paymentMethodSelected;
    private com.tatayab.model.responses.CheckOutAddressModel mCheckOutAddressModel;
    private com.tatayab.tatayab.checkout.PaymentMethodsAdapter mPaymentMethodsAdapter;
    private com.tatayab.tatayab.checkout.SubtTotalForCountriesAdapter mSubTotalForCountriesAdapter;
    private com.tatayab.tatayab.checkout.CheckOutLabelsAdapter mSubTotalAdapter;
    private com.tatayab.tatayab.checkout.CheckOutTotalLabelsAdapter mTotalAdapter;
    private com.tatayab.tatayab.checkout.ProductsForCountriesAdapter mProductsForCountriesAdapter;
    private java.lang.String totalAmount = "";
    public com.tatayab.presentation.checkout.CheckoutFragmentViewModel viewModel;
    private final com.tatayab.presentation.SingleLiveEvent<com.tatayab.presentation.state.Resource<com.tatayab.model.responses.AddToWishListResponse>> addToWishListResultToAdapter = null;
    private final kotlin.Lazy go$delegate = null;
    private float avalAmount = 0.0F;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    private com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory.Factory viewModelFactoryCheckout;
    public com.tatayab.presentation.address.AddressFragmentViewModel addressViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.address.AddressFragmentViewModelFactory.Factory viewModelFactoryAddress;
    private java.util.HashMap _$_findViewCache;
    
    public CheckoutFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.checkout.CheckoutFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.checkout.CheckoutFragmentViewModel p0) {
    }
    
    private final boolean getGo() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory.Factory getViewModelFactoryCheckout() {
        return null;
    }
    
    public final void setViewModelFactoryCheckout(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.address.AddressFragmentViewModel getAddressViewModel() {
        return null;
    }
    
    public final void setAddressViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.address.AddressFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.address.AddressFragmentViewModelFactory.Factory getViewModelFactoryAddress() {
        return null;
    }
    
    public final void setViewModelFactoryAddress(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.address.AddressFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    public final void showLoginDialog() {
    }
    
    private final void showLoginScreen() {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void recallCheckoutApi() {
    }
    
    private final void updateCartId() {
    }
    
    private final void initActions() {
    }
    
    private final void showPaymentScreen(com.tatayab.model.responses.CreateOrderResponse orderResponse) {
    }
    
    private final void returnWithSuccessOrder(com.tatayab.model.responses.CreateOrderResponse orderResponse) {
    }
    
    private final void checkContinuaOrBack() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleAddressesResponse(java.util.List<com.tatayab.model.requests.AddressRequest> addresses) {
    }
    
    private final void gotoAddAddress() {
    }
    
    private final void reloadCheckoutData(java.lang.String addressId) {
    }
    
    private final void navigateToLogin() {
    }
    
    private final void initViewModels() {
    }
    
    private final void handelAndUpdateData(com.tatayab.presentation.state.Resource<com.tatayab.model.responses.ReviewCartResponse> it, com.tatayab.tatayab.checkout.CheckoutFragment.ActionName mActionName) {
    }
    
    private final boolean shouldAddCredit(float totalCost) {
        return false;
    }
    
    private final com.tatayab.model.responses.CheckOutPaymentModel getFreeMethod(java.util.List<com.tatayab.model.responses.CheckOutPaymentModel> it) {
        return null;
    }
    
    private final void setAdapters() {
    }
    
    private final void setProgressView(int visible) {
    }
    
    private final void initView() {
    }
    
    private final void changeAddress() {
    }
    
    private final void collapse(android.view.View v) {
    }
    
    private final void expand(android.view.View v) {
    }
    
    @java.lang.Override
    public void onPaymentMethodSelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CheckOutPaymentModel model) {
    }
    
    @java.lang.Override
    public void onPaymentMethodDefaultSelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CheckOutPaymentModel model) {
    }
    
    private final void notifyHomeWithChanges(java.lang.String productID, boolean newStatues) {
    }
    
    @java.lang.Override
    public void addToWishList(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tatayab/tatayab/checkout/CheckoutFragment$ActionName;", "", "(Ljava/lang/String;I)V", "REVIEW", "APPLY_COUPON", "app_developmentDebug"})
    public static enum ActionName {
        /*public static final*/ REVIEW /* = new REVIEW() */,
        /*public static final*/ APPLY_COUPON /* = new APPLY_COUPON() */;
        
        ActionName() {
        }
    }
}