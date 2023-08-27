package com.tatayab.domain.interactor.account.profile;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetUserProfile_Factory implements Factory<GetUserProfile> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetUserProfile_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetUserProfile get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserProfile provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserProfile(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetUserProfile_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserProfile_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetUserProfile newGetUserProfile(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetUserProfile(tatayabRepository, postExecutionThread);
  }
}
