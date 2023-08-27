package com.tatayab.tatayab.splash;

import com.tatayab.presentation.address.AddressFragmentViewModelFactory;
import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.splash.SplashFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashFragment_MembersInjector implements MembersInjector<SplashFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<SplashFragmentViewModelFactory.Factory> viewModelFactorySplashProvider;

  private final Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider;

  public SplashFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<SplashFragmentViewModelFactory.Factory> viewModelFactorySplashProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.viewModelFactorySplashProvider = viewModelFactorySplashProvider;
    this.viewModelFactoryAddressProvider = viewModelFactoryAddressProvider;
  }

  public static MembersInjector<SplashFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<SplashFragmentViewModelFactory.Factory> viewModelFactorySplashProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    return new SplashFragment_MembersInjector(
        viewModelFactoryProvider,
        mainViewModelFactoryProvider,
        viewModelFactorySplashProvider,
        viewModelFactoryAddressProvider);
  }

  @Override
  public void injectMembers(SplashFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectViewModelFactorySplash(instance, viewModelFactorySplashProvider.get());
    injectViewModelFactoryAddress(instance, viewModelFactoryAddressProvider.get());
  }

  public static void injectMainViewModelFactory(
      SplashFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectViewModelFactorySplash(
      SplashFragment instance, SplashFragmentViewModelFactory.Factory viewModelFactorySplash) {
    instance.viewModelFactorySplash = viewModelFactorySplash;
  }

  public static void injectViewModelFactoryAddress(
      SplashFragment instance, AddressFragmentViewModelFactory.Factory viewModelFactoryAddress) {
    instance.viewModelFactoryAddress = viewModelFactoryAddress;
  }
}
