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
public final class CreateUserCartExecution_Factory implements Factory<CreateUserCartExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public CreateUserCartExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public CreateUserCartExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CreateUserCartExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CreateUserCartExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static CreateUserCartExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CreateUserCartExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CreateUserCartExecution newCreateUserCartExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new CreateUserCartExecution(tatayabRepository, postExecutionThread);
  }
}
