package com.tatayab.tatayab.main.account;

import com.tatayab.presentation.account.AccountFragmentViewModel;
import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AccountFragment_MembersInjector implements MembersInjector<AccountFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<AccountFragmentViewModel> viewModelProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  public AccountFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AccountFragmentViewModel> viewModelProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.viewModelProvider = viewModelProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
  }

  public static MembersInjector<AccountFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AccountFragmentViewModel> viewModelProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider) {
    return new AccountFragment_MembersInjector(
        viewModelFactoryProvider, viewModelProvider, mainViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(AccountFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectViewModel(instance, viewModelProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
  }

  public static void injectViewModel(AccountFragment instance, AccountFragmentViewModel viewModel) {
    instance.viewModel = viewModel;
  }

  public static void injectMainViewModelFactory(
      AccountFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }
}
