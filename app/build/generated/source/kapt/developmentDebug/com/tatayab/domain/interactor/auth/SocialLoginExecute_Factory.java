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
public final class SocialLoginExecute_Factory implements Factory<SocialLoginExecute> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SocialLoginExecute_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SocialLoginExecute get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SocialLoginExecute provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SocialLoginExecute(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SocialLoginExecute_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SocialLoginExecute_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SocialLoginExecute newSocialLoginExecute(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new SocialLoginExecute(tatayabRepository, postExecutionThread);
  }
}
