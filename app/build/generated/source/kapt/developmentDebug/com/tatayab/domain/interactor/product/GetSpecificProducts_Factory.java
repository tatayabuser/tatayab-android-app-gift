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
public final class GetSpecificProducts_Factory implements Factory<GetSpecificProducts> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetSpecificProducts_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetSpecificProducts get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetSpecificProducts provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetSpecificProducts(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetSpecificProducts_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetSpecificProducts_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetSpecificProducts newGetSpecificProducts(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetSpecificProducts(tatayabRepository, postExecutionThread);
  }
}
