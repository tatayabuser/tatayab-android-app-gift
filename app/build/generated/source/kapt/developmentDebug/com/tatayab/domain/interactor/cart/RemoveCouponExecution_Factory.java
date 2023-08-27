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
public final class RemoveCouponExecution_Factory implements Factory<RemoveCouponExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public RemoveCouponExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public RemoveCouponExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static RemoveCouponExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new RemoveCouponExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static RemoveCouponExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new RemoveCouponExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static RemoveCouponExecution newRemoveCouponExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new RemoveCouponExecution(tatayabRepository, postExecutionThread);
  }
}
