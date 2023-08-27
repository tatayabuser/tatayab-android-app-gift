package com.tatayab.tatayab.addresses;

import com.tatayab.tatayab.base.BaseActivity_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChooseCityActivity_MembersInjector
    implements MembersInjector<ChooseCityActivity> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public ChooseCityActivity_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ChooseCityActivity> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new ChooseCityActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ChooseCityActivity instance) {
    BaseActivity_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
