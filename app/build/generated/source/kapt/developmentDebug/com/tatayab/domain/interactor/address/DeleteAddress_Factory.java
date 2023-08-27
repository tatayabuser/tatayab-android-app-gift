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
public final class DeleteAddress_Factory implements Factory<DeleteAddress> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public DeleteAddress_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public DeleteAddress get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static DeleteAddress provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new DeleteAddress(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static DeleteAddress_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new DeleteAddress_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static DeleteAddress newDeleteAddress(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new DeleteAddress(projectsRepository, postExecutionThread);
  }
}
