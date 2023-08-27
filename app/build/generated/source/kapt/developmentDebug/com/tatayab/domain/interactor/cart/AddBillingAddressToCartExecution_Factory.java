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
public final class AddBillingAddressToCartExecution_Factory
    implements Factory<AddBillingAddressToCartExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddBillingAddressToCartExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddBillingAddressToCartExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddBillingAddressToCartExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddBillingAddressToCartExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddBillingAddressToCartExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddBillingAddressToCartExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddBillingAddressToCartExecution newAddBillingAddressToCartExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new AddBillingAddressToCartExecution(tatayabRepository, postExecutionThread);
  }
}
