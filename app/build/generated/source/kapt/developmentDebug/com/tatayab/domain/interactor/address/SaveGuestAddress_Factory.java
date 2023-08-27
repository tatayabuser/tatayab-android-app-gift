package com.tatayab.domain.interactor.address;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SaveGuestAddress_Factory implements Factory<SaveGuestAddress> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SaveGuestAddress_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SaveGuestAddress get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveGuestAddress provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveGuestAddress(
        projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SaveGuestAddress_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SaveGuestAddress_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static SaveGuestAddress newSaveGuestAddress(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new SaveGuestAddress(projectsRepository, postExecutionThread);
  }
}
