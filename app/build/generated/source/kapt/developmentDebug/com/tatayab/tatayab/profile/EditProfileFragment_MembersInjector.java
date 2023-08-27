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
public final class EditProfileFragment_MembersInjector
    implements MembersInjector<EditProfileFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<ProfileFragmentViewModel> viewModelProvider;

  public EditProfileFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<EditProfileFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    return new EditProfileFragment_MembersInjector(viewModelFactoryProvider, viewModelProvider);
  }

  @Override
  public void injectMembers(EditProfileFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModel(instance, viewModelProvider.get());
  }

  public static void injectViewModel(
      EditProfileFragment instance, ProfileFragmentViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
