package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.aboutus.AboutUsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeAboutUsFragment {
  private UIModule_ContributeAboutUsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AboutUsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AboutUsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface AboutUsFragmentSubcomponent extends AndroidInjector<AboutUsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AboutUsFragment> {}
  }
}
