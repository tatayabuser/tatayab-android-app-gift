package com.tatayab.tatayab.currencies;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0016\u0010\u001d\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tatayab/tatayab/currencies/CurrenciesFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/listener/OnCurrencyListener;", "()V", "currenciesAdapter", "Lcom/tatayab/tatayab/currencies/CurrenciesAdapter;", "viewModel", "Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModel;)V", "viewModelFactoryCountries", "Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModelFactory$Factory;", "getViewModelFactoryCountries", "()Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModelFactory$Factory;", "setViewModelFactoryCountries", "(Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModelFactory$Factory;)V", "layoutId", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCurrencySelected", "currencyId", "Lcom/tatayab/model/responses/CurrencyResponse;", "restartWithCurrentCurrency", "setupViewData", "data", "", "app_developmentDebug"})
public final class CurrenciesFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.listener.OnCurrencyListener {
    public com.tatayab.presentation.curriencies.CurrenciesFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory.Factory viewModelFactoryCountries;
    private com.tatayab.tatayab.currencies.CurrenciesAdapter currenciesAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public CurrenciesFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.curriencies.CurrenciesFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.curriencies.CurrenciesFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory.Factory getViewModelFactoryCountries() {
        return null;
    }
    
    public final void setViewModelFactoryCountries(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public void onCurrencySelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CurrencyResponse currencyId) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void restartWithCurrentCurrency() {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewData(java.util.List<com.tatayab.model.responses.CurrencyResponse> data) {
    }
}