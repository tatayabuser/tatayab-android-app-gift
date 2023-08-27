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
public final class ShippingMethodsExecution_Factory implements Factory<ShippingMethodsExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ShippingMethodsExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ShippingMethodsExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ShippingMethodsExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ShippingMethodsExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ShippingMethodsExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ShippingMethodsExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ShippingMethodsExecution newShippingMethodsExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new ShippingMethodsExecution(tatayabRepository, postExecutionThread);
  }
}
