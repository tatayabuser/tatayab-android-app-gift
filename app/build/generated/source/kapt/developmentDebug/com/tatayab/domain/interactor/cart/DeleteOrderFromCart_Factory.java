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
public final class DeleteOrderFromCart_Factory implements Factory<DeleteOrderFromCart> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public DeleteOrderFromCart_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public DeleteOrderFromCart get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static DeleteOrderFromCart provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new DeleteOrderFromCart(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static DeleteOrderFromCart_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new DeleteOrderFromCart_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static DeleteOrderFromCart newDeleteOrderFromCart(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new DeleteOrderFromCart(tatayabRepository, postExecutionThread);
  }
}
