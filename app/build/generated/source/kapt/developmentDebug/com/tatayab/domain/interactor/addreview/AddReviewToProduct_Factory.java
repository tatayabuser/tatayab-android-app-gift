package com.tatayab.domain.interactor.addreview;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddReviewToProduct_Factory implements Factory<AddReviewToProduct> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddReviewToProduct_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddReviewToProduct get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddReviewToProduct provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddReviewToProduct(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddReviewToProduct_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddReviewToProduct_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddReviewToProduct newAddReviewToProduct(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new AddReviewToProduct(tatayabRepository, postExecutionThread);
  }
}
