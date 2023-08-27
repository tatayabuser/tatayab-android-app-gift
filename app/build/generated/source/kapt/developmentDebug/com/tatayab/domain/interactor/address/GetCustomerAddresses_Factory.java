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
public final class GetCustomerAddresses_Factory implements Factory<GetCustomerAddresses> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetCustomerAddresses_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetCustomerAddresses get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCustomerAddresses provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCustomerAddresses(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetCustomerAddresses_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetCustomerAddresses_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetCustomerAddresses newGetCustomerAddresses(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetCustomerAddresses(tatayabRepository, postExecutionThread);
  }
}
