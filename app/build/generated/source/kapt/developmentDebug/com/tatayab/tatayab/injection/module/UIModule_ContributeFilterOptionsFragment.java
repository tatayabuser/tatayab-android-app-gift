package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.filter.FilterOptionsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeFilterOptionsFragment {
  private UIModule_ContributeFilterOptionsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(FilterOptionsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      FilterOptionsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface FilterOptionsFragmentSubcomponent
      extends AndroidInjector<FilterOptionsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FilterOptionsFragment> {}
  }
}
