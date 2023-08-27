package com.tatayab.tatayab.splash;

import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory;
import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CountryFragment_MembersInjector implements MembersInjector<CountryFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<CountriesFragmentViewModelFactory.Factory>
      viewModelFactoryCountriesProvider;

  public CountryFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<CountriesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.viewModelFactoryCountriesProvider = viewModelFactoryCountriesProvider;
  }

  public static MembersInjector<CountryFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<CountriesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider) {
    return new CountryFragment_MembersInjector(
        viewModelFactoryProvider, mainViewModelFactoryProvider, viewModelFactoryCountriesProvider);
  }

  @Override
  public void injectMembers(CountryFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectViewModelFactoryCountries(instance, viewModelFactoryCountriesProvider.get());
  }

  public static void injectMainViewModelFactory(
      CountryFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectViewModelFactoryCountries(
      CountryFragment instance,
      CountriesFragmentViewModelFactory.Factory viewModelFactoryCountries) {
    instance.viewModelFactoryCountries = viewModelFactoryCountries;
  }
}
