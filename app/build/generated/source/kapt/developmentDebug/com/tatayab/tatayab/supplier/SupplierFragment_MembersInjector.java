package com.tatayab.tatayab.supplier;

import com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SupplierFragment_MembersInjector implements MembersInjector<SupplierFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<SuppliersFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public SupplierFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<SuppliersFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SupplierFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<SuppliersFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new SupplierFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SupplierFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      SupplierFragment instance, SuppliersFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
