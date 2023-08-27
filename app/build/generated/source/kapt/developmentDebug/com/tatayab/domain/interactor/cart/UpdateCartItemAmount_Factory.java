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
public final class UpdateCartItemAmount_Factory implements Factory<UpdateCartItemAmount> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public UpdateCartItemAmount_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public UpdateCartItemAmount get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static UpdateCartItemAmount provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new UpdateCartItemAmount(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static UpdateCartItemAmount_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new UpdateCartItemAmount_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static UpdateCartItemAmount newUpdateCartItemAmount(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new UpdateCartItemAmount(tatayabRepository, postExecutionThread);
  }
}
