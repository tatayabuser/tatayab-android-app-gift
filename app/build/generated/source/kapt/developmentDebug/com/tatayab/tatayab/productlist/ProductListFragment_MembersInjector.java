package com.tatayab.tatayab.productlist;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
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
public final class ProductListFragment_MembersInjector
    implements MembersInjector<ProductListFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public ProductListFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ProductListFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<ProductListFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new ProductListFragment_MembersInjector(
        baseViewModelFactoryProvider, mainViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ProductListFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      ProductListFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectViewModelFactory(
      ProductListFragment instance, ProductListFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
