package com.tatayab.domain.interactor.orders;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetOrderTracking_Factory implements Factory<GetOrderTracking> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetOrderTracking_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetOrderTracking get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrderTracking provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrderTracking(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetOrderTracking_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrderTracking_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrderTracking newGetOrderTracking(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetOrderTracking(tatayabRepository, postExecutionThread);
  }
}
