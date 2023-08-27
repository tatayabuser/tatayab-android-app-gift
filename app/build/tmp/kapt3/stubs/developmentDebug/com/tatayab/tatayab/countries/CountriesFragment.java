package com.tatayab.tatayab.countries;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u0010*\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010.\u001a\u00020%H\u0002J\u0016\u0010/\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u00061"}, d2 = {"Lcom/tatayab/tatayab/countries/CountriesFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "Lcom/tatayab/tatayab/listener/OnCountryListener;", "()V", "countriesList", "", "Lcom/tatayab/model/responses/CountryResponse;", "countryAdapter", "Lcom/tatayab/tatayab/countries/CountriesAdapter;", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "selectedCountry", "viewModel", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/countries/CountriesFragmentViewModel;)V", "viewModelFactoryCountries", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;", "getViewModelFactoryCountries", "()Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;", "setViewModelFactoryCountries", "(Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;)V", "layoutId", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCountrySelected", "country", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "restartWithCurrentCountry", "setupViewData", "data", "app_developmentDebug"})
public final class CountriesFragment extends com.tatayab.tatayab.base.BaseFragment implements com.tatayab.tatayab.listener.OnCountryListener {
    private com.tatayab.tatayab.countries.CountriesAdapter countryAdapter;
    private java.util.List<com.tatayab.model.responses.CountryResponse> countriesList;
    public com.tatayab.presentation.countries.CountriesFragmentViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory viewModelFactoryCountries;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    private com.tatayab.model.responses.CountryResponse selectedCountry;
    private java.util.HashMap _$_findViewCache;
    
    public CountriesFragment() {
        super();
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.countries.CountriesFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.countries.CountriesFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory getViewModelFactoryCountries() {
        return null;
    }
    
    public final void setViewModelFactoryCountries(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory p0) {
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
    
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onCountrySelected(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CountryResponse country) {
    }
    
    private final void restartWithCurrentCountry() {
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
    
    private final void setupViewData(java.util.List<com.tatayab.model.responses.CountryResponse> data) {
    }
}