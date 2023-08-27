package com.tatayab.domain.interactor.product;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetAddNotifyMeAction_Factory implements Factory<GetAddNotifyMeAction> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetAddNotifyMeAction_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetAddNotifyMeAction get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetAddNotifyMeAction provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAddNotifyMeAction(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetAddNotifyMeAction_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAddNotifyMeAction_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static GetAddNotifyMeAction newGetAddNotifyMeAction(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new GetAddNotifyMeAction(tatayabRepository, postExecutionThread);
  }
}
