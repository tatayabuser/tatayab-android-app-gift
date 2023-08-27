package com.tatayab.domain.interactor.user;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ExtractDeepLinkExecution_Factory implements Factory<ExtractDeepLinkExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public ExtractDeepLinkExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public ExtractDeepLinkExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ExtractDeepLinkExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ExtractDeepLinkExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static ExtractDeepLinkExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new ExtractDeepLinkExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static ExtractDeepLinkExecution newExtractDeepLinkExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new ExtractDeepLinkExecution(tatayabRepository, postExecutionThread);
  }
}
