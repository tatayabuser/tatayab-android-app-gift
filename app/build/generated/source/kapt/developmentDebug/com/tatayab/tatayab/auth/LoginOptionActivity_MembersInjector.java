package com.tatayab.tatayab.auth;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.MainActivity_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginOptionActivity_MembersInjector
    implements MembersInjector<LoginOptionActivity> {
  private final Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider;

  public LoginOptionActivity_MembersInjector(
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<LoginOptionActivity> create(
      Provider<MainActivityViewModelFactory.Factory> viewModelFactoryProvider) {
    return new LoginOptionActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(LoginOptionActivity instance) {
    MainActivity_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
