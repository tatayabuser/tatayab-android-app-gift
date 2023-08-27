package com.tatayab.tatayab.main.cart;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SharedCartActivity_MembersInjector
    implements MembersInjector<SharedCartActivity> {
  private final Provider<CartFragmentViewModelFactory.Factory> cartViewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public SharedCartActivity_MembersInjector(
      Provider<CartFragmentViewModelFactory.Factory> cartViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.cartViewModelFactoryProvider = cartViewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<SharedCartActivity> create(
      Provider<CartFragmentViewModelFactory.Factory> cartViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new SharedCartActivity_MembersInjector(
        cartViewModelFactoryProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SharedCartActivity instance) {
    injectCartViewModelFactory(instance, cartViewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectCartViewModelFactory(
      SharedCartActivity instance, CartFragmentViewModelFactory.Factory cartViewModelFactory) {
    instance.cartViewModelFactory = cartViewModelFactory;
  }

  public static void injectMainViewModelFactory(
      SharedCartActivity instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
