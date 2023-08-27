package com.tatayab.tatayab.wallet;

import com.tatayab.presentation.wallet.WalletViewModel;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletFragment_MembersInjector implements MembersInjector<WalletFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<WalletViewModel> viewModelProvider;

  public WalletFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WalletViewModel> viewModelProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<WalletFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WalletViewModel> viewModelProvider) {
    return new WalletFragment_MembersInjector(baseViewModelFactoryProvider, viewModelProvider);
  }

  @Override
  public void injectMembers(WalletFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModel(instance, viewModelProvider.get());
  }

  public static void injectViewModel(WalletFragment instance, WalletViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
