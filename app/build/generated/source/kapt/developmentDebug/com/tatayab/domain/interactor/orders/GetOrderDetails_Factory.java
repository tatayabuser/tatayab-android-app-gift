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
public final class GetOrderDetails_Factory implements Factory<GetOrderDetails> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetOrderDetails_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetOrderDetails get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrderDetails provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrderDetails(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetOrderDetails_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrderDetails_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrderDetails newGetOrderDetails(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetOrderDetails(tatayabRepository, postExecutionThread);
  }
}
