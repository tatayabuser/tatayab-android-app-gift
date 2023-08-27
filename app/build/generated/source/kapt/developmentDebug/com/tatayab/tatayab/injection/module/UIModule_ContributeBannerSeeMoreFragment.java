package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.categories.BannerSeeMoreFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeBannerSeeMoreFragment {
  private UIModule_ContributeBannerSeeMoreFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BannerSeeMoreFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BannerSeeMoreFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface BannerSeeMoreFragmentSubcomponent
      extends AndroidInjector<BannerSeeMoreFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BannerSeeMoreFragment> {}
  }
}
