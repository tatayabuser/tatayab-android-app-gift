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
public final class GetUserWishList_Factory implements Factory<GetUserWishList> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetUserWishList_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetUserWishList get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserWishList provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserWishList(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetUserWishList_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserWishList_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserWishList newGetUserWishList(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetUserWishList(tatayabRepository, postExecutionThread);
  }
}
