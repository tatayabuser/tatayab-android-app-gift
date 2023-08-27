package com.tatayab.domain.interactor.curriencies;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCurrencies_Factory implements Factory<GetCurrencies> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetCurrencies_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetCurrencies get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCurrencies provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCurrencies(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetCurrencies_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCurrencies_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCurrencies newGetCurrencies(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetCurrencies(tatayabRepository, postExecutionThread);
  }
}
