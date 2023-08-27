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
public final class GetCities_Factory implements Factory<GetCities> {
  private final Provider<TatayabRepository> projectsRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetCities_Factory(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.projectsRepositoryProvider = projectsRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetCities get() {
    return provideInstance(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCities provideInstance(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCities(projectsRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetCities_Factory create(
      Provider<TatayabRepository> projectsRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCities_Factory(projectsRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCities newGetCities(
      TatayabRepository projectsRepository, PostExecutionThread postExecutionThread) {
    return new GetCities(projectsRepository, postExecutionThread);
  }
}
