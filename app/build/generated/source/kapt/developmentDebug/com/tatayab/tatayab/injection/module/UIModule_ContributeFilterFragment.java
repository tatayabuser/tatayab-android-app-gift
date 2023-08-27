package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.filter.FilterFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeFilterFragment.FilterFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeFilterFragment {
  private UIModule_ContributeFilterFragment() {}

  @Binds
  @IntoMap
  @ClassKey(FilterFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      FilterFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface FilterFragmentSubcomponent extends AndroidInjector<FilterFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FilterFragment> {}
  }
}
