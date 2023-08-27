package com.tatayab.tatayab.productreviews;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory;
import com.tatayab.presentation.product.ProductReviewsViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductReviewsFragment_MembersInjector
    implements MembersInjector<ProductReviewsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<ProductReviewsViewModelFactory.Factory> viewModelFactoryProvider;

  private final Provider<ProductDetailsFragmentViewModelFactory.Factory>
      detailsViewModelFactoryProvider;

  public ProductReviewsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<ProductReviewsViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<ProductDetailsFragmentViewModelFactory.Factory> detailsViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.detailsViewModelFactoryProvider = detailsViewModelFactoryProvider;
  }

  public static MembersInjector<ProductReviewsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<ProductReviewsViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<ProductDetailsFragmentViewModelFactory.Factory> detailsViewModelFactoryProvider) {
    return new ProductReviewsFragment_MembersInjector(
        baseViewModelFactoryProvider,
        mainViewModelFactoryProvider,
        viewModelFactoryProvider,
        detailsViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ProductReviewsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectDetailsViewModelFactory(instance, detailsViewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      ProductReviewsFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectViewModelFactory(
      ProductReviewsFragment instance, ProductReviewsViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }

  public static void injectDetailsViewModelFactory(
      ProductReviewsFragment instance,
      ProductDetailsFragmentViewModelFactory.Factory detailsViewModelFactory) {
    instance.detailsViewModelFactory = detailsViewModelFactory;
  }
}
