package com.tatayab.tatayab.checkout;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GiftOptionsFragment_MembersInjector
    implements MembersInjector<GiftOptionsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<CartFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public GiftOptionsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<CartFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<GiftOptionsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<CartFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new GiftOptionsFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(GiftOptionsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      GiftOptionsFragment instance, CartFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }

  public static void injectMainViewModelFactory(
      GiftOptionsFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
