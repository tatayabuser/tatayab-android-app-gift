package com.tatayab.domain.interactor.filter;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetFilter_Factory implements Factory<GetFilter> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetFilter_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetFilter get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetFilter provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetFilter(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetFilter_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetFilter_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetFilter newGetFilter(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetFilter(tatayabRepository, postExecutionThread);
  }
}
