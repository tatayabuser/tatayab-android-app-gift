package com.tatayab.tatayab.deeplink;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DeepLinkActivity_MembersInjector implements MembersInjector<DeepLinkActivity> {
  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public DeepLinkActivity_MembersInjector(
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<DeepLinkActivity> create(
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new DeepLinkActivity_MembersInjector(mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(DeepLinkActivity instance) {
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      DeepLinkActivity instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
