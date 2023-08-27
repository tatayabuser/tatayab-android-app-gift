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
public final class ForgetPassword_Factory implements Factory<ForgetPassword> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ForgetPassword_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ForgetPassword get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ForgetPassword provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ForgetPassword(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ForgetPassword_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ForgetPassword_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ForgetPassword newForgetPassword(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new ForgetPassword(tatayabRepository, postExecutionThread);
  }
}
