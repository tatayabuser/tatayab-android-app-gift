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
public final class ForgetPasswordFragment_MembersInjector
    implements MembersInjector<ForgetPasswordFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public ForgetPasswordFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ForgetPasswordFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new ForgetPasswordFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ForgetPasswordFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
