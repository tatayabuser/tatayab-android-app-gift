package com.tatayab.tatayab.wallet;

import com.tatayab.presentation.wallet.WalletViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TransactionFragment_MembersInjector
    implements MembersInjector<TransactionFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<WalletViewModelFactory.Factory> viewModelFactoryProvider;

  public TransactionFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WalletViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<TransactionFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<WalletViewModelFactory.Factory> viewModelFactoryProvider) {
    return new TransactionFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(TransactionFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      TransactionFragment instance, WalletViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
