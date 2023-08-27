package com.tatayab.domain.interactor.auth;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetUserTokenExecution_Factory implements Factory<GetUserTokenExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetUserTokenExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetUserTokenExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserTokenExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserTokenExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetUserTokenExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserTokenExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserTokenExecution newGetUserTokenExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetUserTokenExecution(tatayabRepository, postExecutionThread);
  }
}
