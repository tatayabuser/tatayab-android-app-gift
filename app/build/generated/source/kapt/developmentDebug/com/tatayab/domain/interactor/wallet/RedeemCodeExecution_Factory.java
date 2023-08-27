package com.tatayab.domain.interactor.wallet;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedeemCodeExecution_Factory implements Factory<RedeemCodeExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public RedeemCodeExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public RedeemCodeExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static RedeemCodeExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new RedeemCodeExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static RedeemCodeExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new RedeemCodeExecution_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static RedeemCodeExecution newRedeemCodeExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new RedeemCodeExecution(tatayabRepository, postExecutionThread);
  }
}
