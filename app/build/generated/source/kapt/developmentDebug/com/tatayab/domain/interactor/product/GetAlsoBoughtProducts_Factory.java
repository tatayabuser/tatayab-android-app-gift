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
public final class GetAlsoBoughtProducts_Factory implements Factory<GetAlsoBoughtProducts> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetAlsoBoughtProducts_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetAlsoBoughtProducts get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetAlsoBoughtProducts provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAlsoBoughtProducts(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetAlsoBoughtProducts_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAlsoBoughtProducts_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetAlsoBoughtProducts newGetAlsoBoughtProducts(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetAlsoBoughtProducts(tatayabRepository, postExecutionThread);
  }
}
