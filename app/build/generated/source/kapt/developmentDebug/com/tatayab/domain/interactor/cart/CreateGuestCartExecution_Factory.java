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
public final class CreateGuestCartExecution_Factory implements Factory<CreateGuestCartExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public CreateGuestCartExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public CreateGuestCartExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CreateGuestCartExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CreateGuestCartExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static CreateGuestCartExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CreateGuestCartExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CreateGuestCartExecution newCreateGuestCartExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new CreateGuestCartExecution(tatayabRepository, postExecutionThread);
  }
}
