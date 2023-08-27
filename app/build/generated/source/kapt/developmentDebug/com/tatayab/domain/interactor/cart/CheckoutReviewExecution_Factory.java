package com.tatayab.domain.interactor.cart;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CheckoutReviewExecution_Factory implements Factory<CheckoutReviewExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public CheckoutReviewExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public CheckoutReviewExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CheckoutReviewExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CheckoutReviewExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static CheckoutReviewExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CheckoutReviewExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CheckoutReviewExecution newCheckoutReviewExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new CheckoutReviewExecution(tatayabRepository, postExecutionThread);
  }
}
