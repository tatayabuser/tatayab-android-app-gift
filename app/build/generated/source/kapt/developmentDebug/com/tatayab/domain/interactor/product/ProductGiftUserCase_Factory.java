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
public final class ProductGiftUserCase_Factory implements Factory<ProductGiftUserCase> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ProductGiftUserCase_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ProductGiftUserCase get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ProductGiftUserCase provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ProductGiftUserCase(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ProductGiftUserCase_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ProductGiftUserCase_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ProductGiftUserCase newProductGiftUserCase(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new ProductGiftUserCase(tatayabRepository, postExecutionThread);
  }
}
