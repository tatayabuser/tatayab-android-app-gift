package com.tatayab.tatayab.currencies;

import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CurrenciesFragment_MembersInjector
    implements MembersInjector<CurrenciesFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<CurrenciesFragmentViewModelFactory.Factory>
      viewModelFactoryCountriesProvider;

  public CurrenciesFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<CurrenciesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelFactoryCountriesProvider = viewModelFactoryCountriesProvider;
  }

  public static MembersInjector<CurrenciesFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<CurrenciesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider) {
    return new CurrenciesFragment_MembersInjector(
        viewModelFactoryProvider, viewModelFactoryCountriesProvider);
  }

  @Override
  public void injectMembers(CurrenciesFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModelFactoryCountries(instance, viewModelFactoryCountriesProvider.get());
  }

  public static void injectViewModelFactoryCountries(
      CurrenciesFragment instance,
      CurrenciesFragmentViewModelFactory.Factory viewModelFactoryCountries) {
    instance.viewModelFactoryCountries = viewModelFactoryCountries;
  }
}
