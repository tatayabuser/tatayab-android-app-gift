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
public final class SearchSuggestionListExecution_Factory
    implements Factory<SearchSuggestionListExecution> {
  private final Provider<TatayabRepository> tatayabRepositoryProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public SearchSuggestionListExecution_Factory(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.tatayabRepositoryProvider = tatayabRepositoryProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public SearchSuggestionListExecution get() {
    return provideInstance(tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SearchSuggestionListExecution provideInstance(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SearchSuggestionListExecution(
        tatayabRepositoryProvider.get(), postExecutionThreadProvider.get());
  }

  public static SearchSuggestionListExecution_Factory create(
      Provider<TatayabRepository> tatayabRepositoryProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new SearchSuggestionListExecution_Factory(
        tatayabRepositoryProvider, postExecutionThreadProvider);
  }

  public static SearchSuggestionListExecution newSearchSuggestionListExecution(
      TatayabRepository tatayabRepository, PostExecutionThread postExecutionThread) {
    return new SearchSuggestionListExecution(tatayabRepository, postExecutionThread);
  }
}
