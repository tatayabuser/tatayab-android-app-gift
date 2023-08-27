package com.tatayab.domain.interactor.address;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetGuestLastAddress_Factory implements Factory<GetGuestLastAddress> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetGuestLastAddress_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetGuestLastAddress get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetGuestLastAddress provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetGuestLastAddress(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetGuestLastAddress_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetGuestLastAddress_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetGuestLastAddress newGetGuestLastAddress(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetGuestLastAddress(tatayabRepository, postExecutionThread);
  }
}
