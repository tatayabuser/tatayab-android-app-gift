package com.tatayab.tatayab.livechat;

import com.tatayab.tatayab.base.BaseActivity_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LiveChatActivity_MembersInjector implements MembersInjector<LiveChatActivity> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public LiveChatActivity_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<LiveChatActivity> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new LiveChatActivity_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(LiveChatActivity instance) {
    BaseActivity_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
