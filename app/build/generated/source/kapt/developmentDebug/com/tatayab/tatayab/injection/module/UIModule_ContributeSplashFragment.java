package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.splash.SplashFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeSplashFragment.SplashFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeSplashFragment {
  private UIModule_ContributeSplashFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SplashFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SplashFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SplashFragmentSubcomponent extends AndroidInjector<SplashFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SplashFragment> {}
  }
}
