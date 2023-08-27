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
public final class Login_Factory implements Factory<Login> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public Login_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public Login get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static Login provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Login(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static Login_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Login_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static Login newLogin(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new Login(tatayabRepository, postExecutionThread);
  }
}
