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
public final class GetProductDetails_Factory implements Factory<GetProductDetails> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetProductDetails_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetProductDetails get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductDetails provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductDetails(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetProductDetails_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductDetails_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductDetails newGetProductDetails(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetProductDetails(tatayabRepository, postExecutionThread);
  }
}
