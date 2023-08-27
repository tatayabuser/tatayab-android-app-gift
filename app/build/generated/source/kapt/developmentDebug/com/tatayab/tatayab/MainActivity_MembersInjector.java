package com.tatayab.tatayab;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider;

  public MainActivity_MembersInjector(
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    return new MainActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      MainActivity instance, MainActivityViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
