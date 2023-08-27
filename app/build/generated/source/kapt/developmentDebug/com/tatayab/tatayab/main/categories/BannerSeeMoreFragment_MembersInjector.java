package com.tatayab.tatayab.main.categories;

import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BannerSeeMoreFragment_MembersInjector
    implements MembersInjector<BannerSeeMoreFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  public BannerSeeMoreFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
  }

  public static MembersInjector<BannerSeeMoreFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider) {
    return new BannerSeeMoreFragment_MembersInjector(baseViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(BannerSeeMoreFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
  }
}
