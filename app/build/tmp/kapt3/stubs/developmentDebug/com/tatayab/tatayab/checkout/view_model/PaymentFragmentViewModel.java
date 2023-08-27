package com.tatayab.tatayab.checkout.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0006\u0010\u0013\u001a\u00020\u0011R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModel;", "Lcom/tatayab/presentation/base/BaseViewModel;", "repository", "Lcom/tatayab/domain/repository/TatayabRepository;", "mRestoreCartExecution", "Lcom/tatayab/domain/interactor/cart/RestoreCartExecution;", "languageCode", "", "(Lcom/tatayab/domain/repository/TatayabRepository;Lcom/tatayab/domain/interactor/cart/RestoreCartExecution;Ljava/lang/String;)V", "getRestoreCartLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tatayab/presentation/state/Resource;", "", "getGetRestoreCartLiveData", "()Landroidx/lifecycle/MutableLiveData;", "restoreCartLiveData", "callRestoreCartAPI", "", "cartId", "restoreCart", "RestoreCartSubscriber", "app_developmentDebug"})
public final class PaymentFragmentViewModel extends com.tatayab.presentation.base.BaseViewModel {
    private final com.tatayab.domain.repository.TatayabRepository repository = null;
    private final com.tatayab.domain.interactor.cart.RestoreCartExecution mRestoreCartExecution = null;
    private final java.lang.String languageCode = null;
    private final androidx.lifecycle.MutableLiveData<com.tatayab.presentation.state.Resource<java.lang.Boolean>> restoreCartLiveData = null;
    
    @javax.inject.Inject
    public PaymentFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.domain.repository.TatayabRepository repository, @org.jetbrains.annotations.NotNull
    com.tatayab.domain.interactor.cart.RestoreCartExecution mRestoreCartExecution, @org.jetbrains.annotations.NotNull
    java.lang.String languageCode) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.tatayab.presentation.state.Resource<java.lang.Boolean>> getGetRestoreCartLiveData() {
        return null;
    }
    
    public final void restoreCart() {
    }
    
    private final void callRestoreCartAPI(java.lang.String cartId) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModel$RestoreCartSubscriber;", "Lio/reactivex/observers/DisposableObserver;", "Lcom/tatayab/model/responses/graph_responses/RestoreCartResponse;", "(Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModel;)V", "onComplete", "", "onError", "e", "", "onNext", "t", "app_developmentDebug"})
    public final class RestoreCartSubscriber extends io.reactivex.observers.DisposableObserver<com.tatayab.model.responses.graph_responses.RestoreCartResponse> {
        
        public RestoreCartSubscriber() {
            super();
        }
        
        @java.lang.Override
        public void onNext(@org.jetbrains.annotations.NotNull
        com.tatayab.model.responses.graph_responses.RestoreCartResponse t) {
        }
        
        @java.lang.Override
        public void onError(@org.jetbrains.annotations.NotNull
        java.lang.Throwable e) {
        }
        
        @java.lang.Override
        public void onComplete() {
        }
    }
}