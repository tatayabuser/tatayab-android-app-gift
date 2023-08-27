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
public final class SaveFirebaseTokenExecution_Factory
    implements Factory<SaveFirebaseTokenExecution> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveFirebaseTokenExecution_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveFirebaseTokenExecution get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveFirebaseTokenExecution provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveFirebaseTokenExecution(
        projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveFirebaseTokenExecution_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveFirebaseTokenExecution_Factory(
        projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveFirebaseTokenExecution newSaveFirebaseTokenExecution(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveFirebaseTokenExecution(projectsRepository, postExecutionThread);
  }
}
