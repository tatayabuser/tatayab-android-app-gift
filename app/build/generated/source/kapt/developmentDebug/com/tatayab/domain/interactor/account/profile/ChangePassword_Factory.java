package com.tatayab.domain.interactor.account.profile;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChangePassword_Factory implements Factory<ChangePassword> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ChangePassword_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ChangePassword get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ChangePassword provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ChangePassword(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ChangePassword_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ChangePassword_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ChangePassword newChangePassword(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new ChangePassword(tatayabRepository, postExecutionThread);
  }
}
