package com.tatayab.tatayab.search;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.presentation.product.SearchFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<SearchFragmentViewModelFactory.Factory> searchviewModelFactoryProvider;

  public SearchFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<SearchFragmentViewModelFactory.Factory> searchviewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.searchviewModelFactoryProvider = searchviewModelFactoryProvider;
  }

  public static MembersInjector<SearchFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<SearchFragmentViewModelFactory.Factory> searchviewModelFactoryProvider) {
    return new SearchFragment_MembersInjector(
        viewModelFactoryProvider, mainViewModelFactoryProvider, searchviewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SearchFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectSearchviewModelFactory(instance, searchviewModelFactoryProvider.get());
  }

  public static void injectMainViewModelFactory(
      SearchFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectSearchviewModelFactory(
      SearchFragment instance, SearchFragmentViewModelFactory.Factory searchviewModelFactory) {
    instance.searchviewModelFactory = searchviewModelFactory;
  }
}
