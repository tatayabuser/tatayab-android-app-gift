package com.tatayab.tatayab.checkout;

import com.tatayab.presentation.address.AddressFragmentViewModelFactory;
import com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory;
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
public final class CheckoutFragment_MembersInjector implements MembersInjector<CheckoutFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<CheckoutFragmentViewModelFactory.Factory> viewModelFactoryCheckoutProvider;

  private final Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider;

  public CheckoutFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<CheckoutFragmentViewModelFactory.Factory> viewModelFactoryCheckoutProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.viewModelFactoryCheckoutProvider = viewModelFactoryCheckoutProvider;
    this.viewModelFactoryAddressProvider = viewModelFactoryAddressProvider;
  }

  public static MembersInjector<CheckoutFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<CheckoutFragmentViewModelFactory.Factory> viewModelFactoryCheckoutProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    return new CheckoutFragment_MembersInjector(
        viewModelFactoryProvider,
        mainViewModelFactoryProvider,
        viewModelFactoryCheckoutProvider,
        viewModelFactoryAddressProvider);
  }

  @Override
  public void injectMembers(CheckoutFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectViewModelFactoryCheckout(instance, viewModelFactoryCheckoutProvider.get());
    injectViewModelFactoryAddress(instance, viewModelFactoryAddressProvider.get());
  }

  public static void injectMainViewModelFactory(
      CheckoutFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectViewModelFactoryCheckout(
      CheckoutFragment instance,
      CheckoutFragmentViewModelFactory.Factory viewModelFactoryCheckout) {
    instance.viewModelFactoryCheckout = viewModelFactoryCheckout;
  }

  public static void injectViewModelFactoryAddress(
      CheckoutFragment instance, AddressFragmentViewModelFactory.Factory viewModelFactoryAddress) {
    instance.viewModelFactoryAddress = viewModelFactoryAddress;
  }
}
