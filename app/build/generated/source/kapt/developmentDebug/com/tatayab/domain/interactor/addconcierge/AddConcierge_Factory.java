package com.tatayab.domain.interactor.addconcierge;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddConcierge_Factory implements Factory<AddConcierge> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AddConcierge_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AddConcierge get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddConcierge provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddConcierge(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static AddConcierge_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AddConcierge_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static AddConcierge newAddConcierge(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new AddConcierge(tatayabRepository, postExecutionThread);
  }
}
