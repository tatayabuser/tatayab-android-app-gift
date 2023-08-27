package com.tatayab.tatayab.aboutus;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsFragment_MembersInjector implements MembersInjector<AboutUsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider;

  public AboutUsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<AboutUsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    return new AboutUsFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(AboutUsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      AboutUsFragment instance, MainActivityViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
