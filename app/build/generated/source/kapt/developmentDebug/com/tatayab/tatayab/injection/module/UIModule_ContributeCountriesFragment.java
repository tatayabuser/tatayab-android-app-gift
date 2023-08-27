package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.countries.CountriesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCountriesFragment {
  private UIModule_ContributeCountriesFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CountriesFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CountriesFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CountriesFragmentSubcomponent extends AndroidInjector<CountriesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CountriesFragment> {}
  }
}
