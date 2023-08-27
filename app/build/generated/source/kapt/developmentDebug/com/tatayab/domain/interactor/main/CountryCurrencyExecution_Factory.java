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
public final class CountryCurrencyExecution_Factory implements Factory<CountryCurrencyExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public CountryCurrencyExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public CountryCurrencyExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CountryCurrencyExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CountryCurrencyExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static CountryCurrencyExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new CountryCurrencyExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static CountryCurrencyExecution newCountryCurrencyExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new CountryCurrencyExecution(tatayabRepository, postExecutionThread);
  }
}
