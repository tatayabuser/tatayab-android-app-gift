package com.tatayab.tatayab.main.concierge;

import com.tatayab.presentation.addconcierge.ConciergeViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConciergeFragment_MembersInjector implements MembersInjector<ConciergeFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<ConciergeViewModelFactory.Factory> mConciergeViewModelFactoryProvider;

  public ConciergeFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ConciergeViewModelFactory.Factory> mConciergeViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.mConciergeViewModelFactoryProvider = mConciergeViewModelFactoryProvider;
  }

  public static MembersInjector<ConciergeFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<ConciergeViewModelFactory.Factory> mConciergeViewModelFactoryProvider) {
    return new ConciergeFragment_MembersInjector(
        baseViewModelFactoryProvider, mConciergeViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ConciergeFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectMConciergeViewModelFactory(instance, mConciergeViewModelFactoryProvider.get());
  }

  public static void injectMConciergeViewModelFactory(
      ConciergeFragment instance, ConciergeViewModelFactory.Factory mConciergeViewModelFactory) {
    instance.mConciergeViewModelFactory = mConciergeViewModelFactory;
  }
}
