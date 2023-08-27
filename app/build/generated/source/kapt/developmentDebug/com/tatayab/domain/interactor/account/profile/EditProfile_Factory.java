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
public final class EditProfile_Factory implements Factory<EditProfile> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public EditProfile_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public EditProfile get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static EditProfile provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new EditProfile(tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static EditProfile_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new EditProfile_Factory(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static EditProfile newEditProfile(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new EditProfile(tatayabRepository, postExecutionThread);
  }
}
