package com.tatayab.domain.interactor.wallet;

import com.tatayab.domain.executor.PostExecutionThread;
import com.tatayab.domain.repository.TatayabRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class InviteFriendExecution_Factory implements Factory<InviteFriendExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public InviteFriendExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public InviteFriendExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static InviteFriendExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new InviteFriendExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static InviteFriendExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new InviteFriendExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static InviteFriendExecution newInviteFriendExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new InviteFriendExecution(tatayabRepository, postExecutionThread);
  }
}
