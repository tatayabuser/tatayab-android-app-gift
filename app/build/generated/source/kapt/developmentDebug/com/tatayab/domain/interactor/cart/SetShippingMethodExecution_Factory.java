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
public final class SetShippingMethodExecution_Factory
    implements Factory<SetShippingMethodExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SetShippingMethodExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SetShippingMethodExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SetShippingMethodExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SetShippingMethodExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SetShippingMethodExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SetShippingMethodExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SetShippingMethodExecution newSetShippingMethodExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new SetShippingMethodExecution(tatayabRepository, postExecutionThread);
  }
}
