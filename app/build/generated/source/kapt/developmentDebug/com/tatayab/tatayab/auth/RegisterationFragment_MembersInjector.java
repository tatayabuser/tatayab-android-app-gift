package com.tatayab.tatayab.auth;

import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RegisterationFragment_MembersInjector
    implements MembersInjector<RegisterationFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public RegisterationFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<RegisterationFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new RegisterationFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(RegisterationFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
