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
public final class AddressesFragment_MembersInjector implements MembersInjector<AddressesFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryaddressProvider;

  public AddressesFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryaddressProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelFactoryaddressProvider = viewModelFactoryaddressProvider;
  }

  public static MembersInjector<AddressesFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddressFragmentViewModelFactory.Factory> viewModelFactoryaddressProvider) {
    return new AddressesFragment_MembersInjector(
        viewModelFactoryProvider, viewModelFactoryaddressProvider);
  }

  @Override
  public void injectMembers(AddressesFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModelFactoryaddress(instance, viewModelFactoryaddressProvider.get());
  }

  public static void injectViewModelFactoryaddress(
      AddressesFragment instance, AddressFragmentViewModelFactory.Factory viewModelFactoryaddress) {
    instance.viewModelFactoryaddress = viewModelFactoryaddress;
  }
}
