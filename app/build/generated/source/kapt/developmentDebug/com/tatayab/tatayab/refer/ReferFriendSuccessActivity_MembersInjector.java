package com.tatayab.tatayab.refer;

import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReferFriendSuccessActivity_MembersInjector
    implements MembersInjector<ReferFriendSuccessActivity> {
  private final Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider;

  public ReferFriendSuccessActivity_MembersInjector(
      Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ReferFriendSuccessActivity> create(
      Provider<ReferFriendSuccessViewModelFactory.Factory> viewModelFactoryProvider) {
    return new ReferFriendSuccessActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ReferFriendSuccessActivity instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      ReferFriendSuccessActivity instance,
      ReferFriendSuccessViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
