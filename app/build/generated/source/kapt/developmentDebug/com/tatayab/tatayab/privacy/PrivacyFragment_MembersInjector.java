package com.tatayab.tatayab.privacy;

import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivacyFragment_MembersInjector implements MembersInjector<PrivacyFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public PrivacyFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<PrivacyFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new PrivacyFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(PrivacyFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
