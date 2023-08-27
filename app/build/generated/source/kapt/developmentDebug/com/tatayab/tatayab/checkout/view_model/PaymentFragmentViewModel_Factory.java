package com.tatayab.tatayab.checkout.view_model;

import com.tatayab.domain.interactor.cart.RestoreCartExecution;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PaymentFragmentViewModel_Factory implements Factory<PaymentFragmentViewModel> {
  private final Provider<TatayabRepository> repositoryProvider;

  private final Provider<RestoreCartExecution> mRestoreCartExecutionProvider;

  private final Provider<String> languageCodeProvider;

  public PaymentFragmentViewModel_Factory(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider,
      Provider<String> languageCodeProvider) {
    this.repositoryProvider = repositoryProvider;
    this.mRestoreCartExecutionProvider = mRestoreCartExecutionProvider;
    this.languageCodeProvider = languageCodeProvider;
  }

  @Override
  public PaymentFragmentViewModel get() {
    return provideInstance(repositoryProvider, mRestoreCartExecutionProvider, languageCodeProvider);
  }

  public static PaymentFragmentViewModel provideInstance(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider,
      Provider<String> languageCodeProvider) {
    return new PaymentFragmentViewModel(
        repositoryProvider.get(), mRestoreCartExecutionProvider.get(), languageCodeProvider.get());
  }

  public static PaymentFragmentViewModel_Factory create(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider,
      Provider<String> languageCodeProvider) {
    return new PaymentFragmentViewModel_Factory(
        repositoryProvider, mRestoreCartExecutionProvider, languageCodeProvider);
  }

  public static PaymentFragmentViewModel newPaymentFragmentViewModel(
      TatayabRepository repository,
      RestoreCartExecution mRestoreCartExecution,
      String languageCode) {
    return new PaymentFragmentViewModel(repository, mRestoreCartExecution, languageCode);
  }
}
