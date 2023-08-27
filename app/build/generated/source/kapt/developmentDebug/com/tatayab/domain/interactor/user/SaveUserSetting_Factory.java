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
public final class SaveUserSetting_Factory implements Factory<SaveUserSetting> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveUserSetting_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveUserSetting get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveUserSetting provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveUserSetting(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveUserSetting_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveUserSetting_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveUserSetting newSaveUserSetting(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveUserSetting(projectsRepository, postExecutionThread);
  }
}
