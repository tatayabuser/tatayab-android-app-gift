package com.tatayab.tatayab.checkout;

import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateProfileFragment_MembersInjector
    implements MembersInjector<UpdateProfileFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public UpdateProfileFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<UpdateProfileFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new UpdateProfileFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(UpdateProfileFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
