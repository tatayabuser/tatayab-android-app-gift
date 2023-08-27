package com.tatayab.tatayab.productreviews.addreview;

import com.tatayab.presentation.addreview.AddReviewViewModel;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddReviewFragment_MembersInjector implements MembersInjector<AddReviewFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<AddReviewViewModel> mViewModelProvider;

  public AddReviewFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddReviewViewModel> mViewModelProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mViewModelProvider = mViewModelProvider;
  }

  public static MembersInjector<AddReviewFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<AddReviewViewModel> mViewModelProvider) {
    return new AddReviewFragment_MembersInjector(viewModelFactoryProvider, mViewModelProvider);
  }

  @Override
  public void injectMembers(AddReviewFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMViewModel(instance, mViewModelProvider.get());
  }

  public static void injectMViewModel(AddReviewFragment instance, AddReviewViewModel mViewModel) {
    instance.mViewModel = mViewModel;
  }
}
