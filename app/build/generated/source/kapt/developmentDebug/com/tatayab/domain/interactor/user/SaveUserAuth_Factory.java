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
public final class SaveUserAuth_Factory implements Factory<SaveUserAuth> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveUserAuth_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveUserAuth get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveUserAuth provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveUserAuth(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveUserAuth_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveUserAuth_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveUserAuth newSaveUserAuth(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveUserAuth(projectsRepository, postExecutionThread);
  }
}
