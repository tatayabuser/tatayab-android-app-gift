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
public final class SaveCountryExecution_Factory implements Factory<SaveCountryExecution> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveCountryExecution_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveCountryExecution get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveCountryExecution provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveCountryExecution(
        projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveCountryExecution_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveCountryExecution_Factory(
        projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveCountryExecution newSaveCountryExecution(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveCountryExecution(projectsRepository, postExecutionThread);
  }
}
