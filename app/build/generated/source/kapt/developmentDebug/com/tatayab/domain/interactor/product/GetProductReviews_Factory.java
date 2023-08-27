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
public final class GetProductReviews_Factory implements Factory<GetProductReviews> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetProductReviews_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetProductReviews get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductReviews provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductReviews(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetProductReviews_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductReviews_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductReviews newGetProductReviews(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetProductReviews(tatayabRepository, postExecutionThread);
  }
}
