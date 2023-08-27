package com.tatayab.domain.interactor.cart;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PaymentMethodExecution_Factory implements Factory<PaymentMethodExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public PaymentMethodExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public PaymentMethodExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static PaymentMethodExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new PaymentMethodExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static PaymentMethodExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new PaymentMethodExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static PaymentMethodExecution newPaymentMethodExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new PaymentMethodExecution(tatayabRepository, postExecutionThread);
  }
}
