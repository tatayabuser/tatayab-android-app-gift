package com.tatayab.tatayab.productdetails;

import com.tatayab.tatayab.base.BaseActivity_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChooseOptionActivity_MembersInjector
    implements MembersInjector<ChooseOptionActivity> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public ChooseOptionActivity_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ChooseOptionActivity> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new ChooseOptionActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ChooseOptionActivity instance) {
    BaseActivity_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
