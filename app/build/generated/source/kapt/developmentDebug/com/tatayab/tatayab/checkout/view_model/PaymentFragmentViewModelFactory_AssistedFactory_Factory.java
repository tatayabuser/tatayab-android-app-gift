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
public final class PaymentFragmentViewModelFactory_AssistedFactory_Factory
    implements Factory<PaymentFragmentViewModelFactory_AssistedFactory> {
  private final Provider<TatayabRepository> repositoryProvider;

  private final Provider<RestoreCartExecution> mRestoreCartExecutionProvider;

  public PaymentFragmentViewModelFactory_AssistedFactory_Factory(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider) {
    this.repositoryProvider = repositoryProvider;
    this.mRestoreCartExecutionProvider = mRestoreCartExecutionProvider;
  }

  @Override
  public PaymentFragmentViewModelFactory_AssistedFactory get() {
    return provideInstance(repositoryProvider, mRestoreCartExecutionProvider);
  }

  public static PaymentFragmentViewModelFactory_AssistedFactory provideInstance(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider) {
    return new PaymentFragmentViewModelFactory_AssistedFactory(
        repositoryProvider, mRestoreCartExecutionProvider);
  }

  public static PaymentFragmentViewModelFactory_AssistedFactory_Factory create(
      Provider<TatayabRepository> repositoryProvider,
      Provider<RestoreCartExecution> mRestoreCartExecutionProvider) {
    return new PaymentFragmentViewModelFactory_AssistedFactory_Factory(
        repositoryProvider, mRestoreCartExecutionProvider);
  }

  public static PaymentFragmentViewModelFactory_AssistedFactory
      newPaymentFragmentViewModelFactory_AssistedFactory(
          Provider<TatayabRepository> repository,
          Provider<RestoreCartExecution> mRestoreCartExecution) {
    return new PaymentFragmentViewModelFactory_AssistedFactory(repository, mRestoreCartExecution);
  }
}
