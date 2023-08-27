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
public final class ClearCachedAndRemoteCart_Factory implements Factory<ClearCachedAndRemoteCart> {
  private final Provider<TatayabRepository> repositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ClearCachedAndRemoteCart_Factory(
      Provider<TatayabRepository> repositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.repositoryProvider = repositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ClearCachedAndRemoteCart get() {
    return provideInstance(repositoryProvider, postExecutionThreadProvider);
  }

  public static ClearCachedAndRemoteCart provideInstance(
      Provider<TatayabRepository> repositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ClearCachedAndRemoteCart(
        repositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ClearCachedAndRemoteCart_Factory create(
      Provider<TatayabRepository> repositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ClearCachedAndRemoteCart_Factory(repositoryProvider, postExecutionThreadProvider);
  }

  public static ClearCachedAndRemoteCart newClearCachedAndRemoteCart(
      TatayabRepository repository, PostExecutionThread postExecutionThread) {
    return new ClearCachedAndRemoteCart(repository, postExecutionThread);
  }
}
