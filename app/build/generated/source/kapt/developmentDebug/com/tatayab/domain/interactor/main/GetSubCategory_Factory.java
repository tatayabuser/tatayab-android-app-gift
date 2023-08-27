package com.tatayab.domain.interactor.main;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetSubCategory_Factory implements Factory<GetSubCategory> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetSubCategory_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetSubCategory get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetSubCategory provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetSubCategory(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetSubCategory_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetSubCategory_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetSubCategory newGetSubCategory(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetSubCategory(tatayabRepository, postExecutionThread);
  }
}