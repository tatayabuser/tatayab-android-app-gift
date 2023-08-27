package com.tatayab.tatayab.base;

import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseFragment2_MembersInjector implements MembersInjector<BaseFragment2> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  public BaseFragment2_MembersInjector(Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
  }

  public static MembersInjector<BaseFragment2> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    return new BaseFragment2_MembersInjector(baseViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(BaseFragment2 instance) {
    injectBaseViewModelFactory(instance, baseViewModelFactoryProvider.get());
  }

  public static void injectBaseViewModelFactory(
      BaseFragment2 instance, ViewModelFactory baseViewModelFactory) {
    instance.baseViewModelFactory = baseViewModelFactory;
  }
}
