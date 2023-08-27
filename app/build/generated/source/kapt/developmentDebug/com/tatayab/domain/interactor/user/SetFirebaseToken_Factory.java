package com.tatayab.domain.interactor.user;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetFirebaseToken_Factory implements Factory<SetFirebaseToken> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SetFirebaseToken_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SetFirebaseToken get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SetFirebaseToken provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SetFirebaseToken(
        projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SetFirebaseToken_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SetFirebaseToken_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SetFirebaseToken newSetFirebaseToken(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SetFirebaseToken(projectsRepository, postExecutionThread);
  }
}
