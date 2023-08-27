package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.cart.ReferCartFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeReferCartFragment {
  private UIModule_ContributeReferCartFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ReferCartFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReferCartFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ReferCartFragmentSubcomponent extends AndroidInjector<ReferCartFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ReferCartFragment> {}
  }
}
