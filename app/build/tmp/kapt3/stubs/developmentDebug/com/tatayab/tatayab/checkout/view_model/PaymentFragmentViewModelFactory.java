package com.tatayab.tatayab.checkout.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/tatayab/domain/repository/TatayabRepository;", "mRestoreCartExecution", "Lcom/tatayab/domain/interactor/cart/RestoreCartExecution;", "languageCode", "", "(Lcom/tatayab/domain/repository/TatayabRepository;Lcom/tatayab/domain/interactor/cart/RestoreCartExecution;Ljava/lang/String;)V", "getLanguageCode", "()Ljava/lang/String;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Factory", "app_developmentDebug"})
public final class PaymentFragmentViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    private final com.tatayab.domain.repository.TatayabRepository repository = null;
    private final com.tatayab.domain.interactor.cart.RestoreCartExecution mRestoreCartExecution = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String languageCode = null;
    
    @com.squareup.inject.assisted.AssistedInject
    public PaymentFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.domain.repository.TatayabRepository repository, @org.jetbrains.annotations.NotNull
    com.tatayab.domain.interactor.cart.RestoreCartExecution mRestoreCartExecution, @org.jetbrains.annotations.NotNull
    @com.squareup.inject.assisted.Assisted
    java.lang.String languageCode) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLanguageCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    @com.squareup.inject.assisted.AssistedInject.Factory
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory$Factory;", "", "create", "Lcom/tatayab/tatayab/checkout/view_model/PaymentFragmentViewModelFactory;", "languageCode", "", "app_developmentDebug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory create(@org.jetbrains.annotations.NotNull
        java.lang.String languageCode);
    }
}