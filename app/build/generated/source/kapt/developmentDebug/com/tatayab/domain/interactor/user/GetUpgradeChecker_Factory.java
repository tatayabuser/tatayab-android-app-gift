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
public final class GetUpgradeChecker_Factory implements Factory<GetUpgradeChecker> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetUpgradeChecker_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetUpgradeChecker get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUpgradeChecker provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUpgradeChecker(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetUpgradeChecker_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUpgradeChecker_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUpgradeChecker newGetUpgradeChecker(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetUpgradeChecker(tatayabRepository, postExecutionThread);
  }
}
