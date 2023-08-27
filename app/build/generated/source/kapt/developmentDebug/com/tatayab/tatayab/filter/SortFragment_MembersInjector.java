package com.tatayab.tatayab.filter;

import com.tatayab.presentation.product.ProductListFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SortFragment_MembersInjector implements MembersInjector<SortFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public SortFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SortFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new SortFragment_MembersInjector(baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SortFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      SortFragment instance, ProductListFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
