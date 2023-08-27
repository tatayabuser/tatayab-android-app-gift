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
public final class Logout_Factory implements Factory<Logout> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public Logout_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public Logout get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static Logout provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Logout(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static Logout_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new Logout_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static Logout newLogout(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new Logout(projectsRepository, postExecutionThread);
  }
}
