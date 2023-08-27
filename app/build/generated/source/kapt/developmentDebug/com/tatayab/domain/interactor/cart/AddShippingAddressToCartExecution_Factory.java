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
public final class AddShippingAddressToCartExecution_Factory
    implements Factory<AddShippingAddressToCartExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddShippingAddressToCartExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddShippingAddressToCartExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddShippingAddressToCartExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddShippingAddressToCartExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddShippingAddressToCartExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddShippingAddressToCartExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddShippingAddressToCartExecution newAddShippingAddressToCartExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new AddShippingAddressToCartExecution(tatayabRepository, postExecutionThread);
  }
}
