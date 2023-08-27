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
public final class GetGeneratedToken_Factory implements Factory<GetGeneratedToken> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetGeneratedToken_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetGeneratedToken get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetGeneratedToken provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetGeneratedToken(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetGeneratedToken_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetGeneratedToken_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetGeneratedToken newGetGeneratedToken(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetGeneratedToken(tatayabRepository, postExecutionThread);
  }
}
