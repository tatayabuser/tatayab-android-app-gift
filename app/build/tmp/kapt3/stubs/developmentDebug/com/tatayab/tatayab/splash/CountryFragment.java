package com.tatayab.tatayab.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0016J\u0012\u0010\'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tatayab/tatayab/splash/CountryFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/listener/OnCountryListener;", "()V", "adapter", "Lcom/tatayab/tatayab/splash/CountriesAdapter;", "countriesList", "", "Lcom/tatayab/model/responses/CountryResponse;", "[Lcom/tatayab/model/responses/CountryResponse;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "viewModel", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;)V", "viewModelFactoryCountries", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;", "getViewModelFactoryCountries", "()Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;", "setViewModelFactoryCountries", "(Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;)V", "layoutId", "", "onCountrySelected", "", "country", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "app_developmentDebug"})
public final class CountryFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.listener.OnCountryListener {
    private com.tatayab.tatayab.splash.CountriesAdapter adapter;
    private com.tatayab.model.responses.CountryResponse[] countriesList;
    public com.tatayab.presentation.countries.CountriesFragmentViewModel viewModel;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    @javax.inject.Inject
    public com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory viewModelFactoryCountries;
    private java.util.HashMap _$_findViewCache;
    
    public CountryFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.countries.CountriesFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.countries.CountriesFragmentViewModel p0) {
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
    public final com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory getViewModelFactoryCountries() {
        return null;
    }
    
    public final void setViewModelFactoryCountries(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
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
    public void onCountrySelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CountryResponse country) {
    }
}