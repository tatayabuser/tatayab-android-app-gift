package com.tatayab.domain.interactor.productotions;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetProductOptions_Factory implements Factory<GetProductOptions> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetProductOptions_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetProductOptions get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductOptions provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductOptions(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetProductOptions_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetProductOptions_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetProductOptions newGetProductOptions(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetProductOptions(tatayabRepository, postExecutionThread);
  }
}
