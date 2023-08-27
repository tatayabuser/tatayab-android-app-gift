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
public final class AddAddress_Factory implements Factory<AddAddress> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddAddress_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddAddress get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddAddress provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddAddress(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddAddress_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddAddress_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddAddress newAddAddress(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new AddAddress(projectsRepository, postExecutionThread);
  }
}
