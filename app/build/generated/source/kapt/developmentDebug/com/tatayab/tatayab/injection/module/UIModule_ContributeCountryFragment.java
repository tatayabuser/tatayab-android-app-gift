package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.splash.CountryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeCountryFragment.CountryFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCountryFragment {
  private UIModule_ContributeCountryFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CountryFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CountryFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CountryFragmentSubcomponent extends AndroidInjector<CountryFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CountryFragment> {}
  }
}
