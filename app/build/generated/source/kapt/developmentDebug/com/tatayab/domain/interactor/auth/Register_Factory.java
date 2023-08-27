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
public final class Register_Factory implements Factory<Register> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public Register_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public Register get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static Register provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Register(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static Register_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Register_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static Register newRegister(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new Register(tatayabRepository, postExecutionThread);
  }
}
