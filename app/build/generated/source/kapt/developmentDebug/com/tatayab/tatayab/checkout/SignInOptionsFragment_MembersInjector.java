package com.tatayab.tatayab.checkout;

import com.tatayab.presentation.auth.UserSocialLoginViewModelFactory;
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
public final class SignInOptionsFragment_MembersInjector
    implements MembersInjector<SignInOptionsFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<UserSocialLoginViewModelFactory.Factory>
      userSocialLoginViewModelFactoryProvider;

  public SignInOptionsFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<UserSocialLoginViewModelFactory.Factory> userSocialLoginViewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.userSocialLoginViewModelFactoryProvider = userSocialLoginViewModelFactoryProvider;
  }

  public static MembersInjector<SignInOptionsFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<UserSocialLoginViewModelFactory.Factory> userSocialLoginViewModelFactoryProvider) {
    return new SignInOptionsFragment_MembersInjector(
        viewModelFactoryProvider,
        mainViewModelFactoryProvider,
        userSocialLoginViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SignInOptionsFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectUserSocialLoginViewModelFactory(instance, userSocialLoginViewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      SignInOptionsFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectUserSocialLoginViewModelFactory(
      SignInOptionsFragment instance,
      UserSocialLoginViewModelFactory.Factory userSocialLoginViewModelFactory) {
    instance.userSocialLoginViewModelFactory = userSocialLoginViewModelFactory;
  }
}
