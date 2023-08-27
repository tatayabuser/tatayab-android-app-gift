package com.tatayab.tatayab.productdetails;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductDetailsFragment_MembersInjector
    implements MembersInjector<ProductDetailsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<ProductDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public ProductDetailsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ProductDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<ProductDetailsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ProductDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new ProductDetailsFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ProductDetailsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      ProductDetailsFragment instance,
      ProductDetailsFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }

  public static void injectMainViewModelFactory(
      ProductDetailsFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
