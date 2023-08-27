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
public final class SaveCurrentLangauge_Factory implements Factory<SaveCurrentLangauge> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveCurrentLangauge_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveCurrentLangauge get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveCurrentLangauge provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveCurrentLangauge(
        projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveCurrentLangauge_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveCurrentLangauge_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveCurrentLangauge newSaveCurrentLangauge(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveCurrentLangauge(projectsRepository, postExecutionThread);
  }
}
