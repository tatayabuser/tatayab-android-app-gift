package com.tatayab.tatayab.livechat;

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
public final class LivechatFragment_MembersInjector implements MembersInjector<LivechatFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<ProfileFragmentViewModel> viewModelProvider;

  public LivechatFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<LivechatFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<ProfileFragmentViewModel> viewModelProvider) {
    return new LivechatFragment_MembersInjector(viewModelFactoryProvider, viewModelProvider);
  }

  @Override
  public void injectMembers(LivechatFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModel(instance, viewModelProvider.get());
  }

  public static void injectViewModel(
      LivechatFragment instance, ProfileFragmentViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
