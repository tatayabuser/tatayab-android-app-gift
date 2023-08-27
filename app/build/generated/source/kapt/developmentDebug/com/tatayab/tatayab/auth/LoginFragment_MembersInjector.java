package com.tatayab.tatayab.auth;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public LoginFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new LoginFragment_MembersInjector(
        viewModelFactoryProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      LoginFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
