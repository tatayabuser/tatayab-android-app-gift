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
public final class GetArea_Factory implements Factory<GetArea> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetArea_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetArea get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetArea provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetArea(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetArea_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetArea_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetArea newGetArea(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new GetArea(projectsRepository, postExecutionThread);
  }
}
