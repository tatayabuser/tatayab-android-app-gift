package com.tatayab.tatayab.filter;

import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FilterOptionsFragment_MembersInjector
    implements MembersInjector<FilterOptionsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  public FilterOptionsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
  }

  public static MembersInjector<FilterOptionsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    return new FilterOptionsFragment_MembersInjector(baseViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(FilterOptionsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
  }
}
