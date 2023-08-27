package com.tatayab.domain.interactor.main;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCategoryBanner_Factory implements Factory<GetCategoryBanner> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetCategoryBanner_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetCategoryBanner get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCategoryBanner provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCategoryBanner(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetCategoryBanner_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCategoryBanner_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCategoryBanner newGetCategoryBanner(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetCategoryBanner(tatayabRepository, postExecutionThread);
  }
}
