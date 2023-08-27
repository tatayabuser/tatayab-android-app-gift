package com.tatayab.tatayab.addresses;

import com.tatayab.presentation.address.AddressFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddAddressFragment_MembersInjector
    implements MembersInjector<AddAddressFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider;

  public AddAddressFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelFactoryAddressProvider = viewModelFactoryAddressProvider;
  }

  public static MembersInjector<AddAddressFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryAddressProvider) {
    return new AddAddressFragment_MembersInjector(
        viewModelFactoryProvider, viewModelFactoryAddressProvider);
  }

  @Override
  public void injectMembers(AddAddressFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModelFactoryAddress(instance, viewModelFactoryAddressProvider.get());
  }

  public static void injectViewModelFactoryAddress(
      AddAddressFragment instance,
      AddressFragmentViewModelFactory.Factory viewModelFactoryAddress) {
    instance.viewModelFactoryAddress = viewModelFactoryAddress;
  }
}
