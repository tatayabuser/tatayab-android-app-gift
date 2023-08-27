package com.tatayab.tatayab.profile;

import com.tatayab.presentation.profile.ProfileFragmentViewModel;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChangePasswordFragment_MembersInjector
    implements MembersInjector<ChangePasswordFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<ProfileFragmentViewModel> viewModelProvider;

  public ChangePasswordFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<ChangePasswordFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    return new ChangePasswordFragment_MembersInjector(viewModelFactoryProvider, viewModelProvider);
  }

  @Override
  public void injectMembers(ChangePasswordFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModel(instance, viewModelProvider.get());
  }

  public static void injectViewModel(
      ChangePasswordFragment instance, ProfileFragmentViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
