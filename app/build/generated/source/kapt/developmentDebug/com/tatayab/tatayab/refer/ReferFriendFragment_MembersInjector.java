package com.tatayab.tatayab.refer;

import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReferFriendFragment_MembersInjector
    implements MembersInjector<ReferFriendFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider;

  public ReferFriendFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ReferFriendFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider) {
    return new ReferFriendFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ReferFriendFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      ReferFriendFragment instance, ReferFriendSuccessViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
