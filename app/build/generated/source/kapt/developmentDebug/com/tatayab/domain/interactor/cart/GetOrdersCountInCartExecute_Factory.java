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
public final class GetOrdersCountInCartExecute_Factory
    implements Factory<GetOrdersCountInCartExecute> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetOrdersCountInCartExecute_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetOrdersCountInCartExecute get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrdersCountInCartExecute provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrdersCountInCartExecute(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetOrdersCountInCartExecute_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetOrdersCountInCartExecute_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetOrdersCountInCartExecute newGetOrdersCountInCartExecute(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetOrdersCountInCartExecute(tatayabRepository, postExecutionThread);
  }
}
