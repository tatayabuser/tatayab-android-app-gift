package com.tatayab.domain.interactor.auth;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateUserTokenWithLangaugAndCountryExecution_Factory
    implements Factory<UpdateUserTokenWithLangaugAndCountryExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public UpdateUserTokenWithLangaugAndCountryExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public UpdateUserTokenWithLangaugAndCountryExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static UpdateUserTokenWithLangaugAndCountryExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new UpdateUserTokenWithLangaugAndCountryExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static UpdateUserTokenWithLangaugAndCountryExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new UpdateUserTokenWithLangaugAndCountryExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static UpdateUserTokenWithLangaugAndCountryExecution
      newUpdateUserTokenWithLangaugAndCountryExecution(
          TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new UpdateUserTokenWithLangaugAndCountryExecution(
        tatayabRepository, postExecutionThread);
  }
}
