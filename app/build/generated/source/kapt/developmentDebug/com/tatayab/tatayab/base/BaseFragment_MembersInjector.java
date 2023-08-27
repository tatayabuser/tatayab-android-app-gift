package com.tatayab.tatayab.base;

import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseFragment_MembersInjector implements MembersInjector<BaseFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public BaseFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<BaseFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new BaseFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(BaseFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      BaseFragment instance, ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
