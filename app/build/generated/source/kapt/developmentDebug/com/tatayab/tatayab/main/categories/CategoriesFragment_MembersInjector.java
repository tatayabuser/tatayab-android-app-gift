package com.tatayab.tatayab.main.categories;

import com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CategoriesFragment_MembersInjector
    implements MembersInjector<CategoriesFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<CategoryFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public CategoriesFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<CategoryFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<CategoriesFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<CategoryFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new CategoriesFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(CategoriesFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      CategoriesFragment instance, CategoryFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
