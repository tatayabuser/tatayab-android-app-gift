package com.tatayab.domain.interactor.wishlist;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WishListActions_Factory implements Factory<WishListActions> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public WishListActions_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public WishListActions get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static WishListActions provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new WishListActions(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static WishListActions_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new WishListActions_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static WishListActions newWishListActions(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new WishListActions(tatayabRepository, postExecutionThread);
  }
}
