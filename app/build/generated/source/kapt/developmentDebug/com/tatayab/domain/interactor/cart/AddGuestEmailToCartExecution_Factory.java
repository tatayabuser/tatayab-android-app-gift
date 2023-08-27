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
public final class AddGuestEmailToCartExecution_Factory
    implements Factory<AddGuestEmailToCartExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddGuestEmailToCartExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddGuestEmailToCartExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddGuestEmailToCartExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddGuestEmailToCartExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddGuestEmailToCartExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddGuestEmailToCartExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddGuestEmailToCartExecution newAddGuestEmailToCartExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new AddGuestEmailToCartExecution(tatayabRepository, postExecutionThread);
  }
}
