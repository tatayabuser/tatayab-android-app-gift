package com.tatayab.domain.interactor.product;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetProductsWithSearch_Factory implements Factory<GetProductsWithSearch> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetProductsWithSearch_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetProductsWithSearch get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductsWithSearch provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductsWithSearch(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetProductsWithSearch_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductsWithSearch_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductsWithSearch newGetProductsWithSearch(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetProductsWithSearch(tatayabRepository, postExecutionThread);
  }
}
