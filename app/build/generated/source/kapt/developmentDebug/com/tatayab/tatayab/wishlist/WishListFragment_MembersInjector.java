package com.tatayab.tatayab.wishlist;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WishListFragment_MembersInjector implements MembersInjector<WishListFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<WishlistFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public WishListFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WishlistFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<WishListFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WishlistFragmentViewModelFactory.Factory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new WishListFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(WishListFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      WishListFragment instance, WishlistFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }

  public static void injectMainViewModelFactory(
      WishListFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
