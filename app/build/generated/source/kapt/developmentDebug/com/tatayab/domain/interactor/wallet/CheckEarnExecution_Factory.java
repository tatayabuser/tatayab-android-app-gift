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
public final class CheckEarnExecution_Factory implements Factory<CheckEarnExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public CheckEarnExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public CheckEarnExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CheckEarnExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CheckEarnExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static CheckEarnExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CheckEarnExecution_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CheckEarnExecution newCheckEarnExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new CheckEarnExecution(tatayabRepository, postExecutionThread);
  }
}
