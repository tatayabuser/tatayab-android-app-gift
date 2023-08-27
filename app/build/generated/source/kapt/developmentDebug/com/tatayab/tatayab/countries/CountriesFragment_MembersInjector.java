package com.tatayab.tatayab.countries;

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
public final class CountriesFragment_MembersInjector implements MembersInjector<CountriesFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<CountriesFragmentViewModelFactory.Factory>
      viewModelFactoryCountriesProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public CountriesFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<CountriesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelFactoryCountriesProvider = viewModelFactoryCountriesProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<CountriesFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<CountriesFragmentViewModelFactory.Factory> viewModelFactoryCountriesProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new CountriesFragment_MembersInjector(
        viewModelFactoryProvider, viewModelFactoryCountriesProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(CountriesFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModelFactoryCountries(instance, viewModelFactoryCountriesProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectViewModelFactoryCountries(
      CountriesFragment instance,
      CountriesFragmentViewModelFactory.Factory viewModelFactoryCountries) {
    instance.viewModelFactoryCountries = viewModelFactoryCountries;
  }

  public static void injectMainViewModelFactory(
      CountriesFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
