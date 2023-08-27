package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.base.BaseFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeBaseFragment.BaseFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeBaseFragment {
  private UIModule_ContributeBaseFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BaseFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface BaseFragmentSubcomponent extends AndroidInjector<BaseFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseFragment> {}
  }
}
