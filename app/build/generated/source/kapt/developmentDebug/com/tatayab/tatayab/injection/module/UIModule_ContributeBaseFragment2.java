package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.base.BaseFragment2;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeBaseFragment2 {
  private UIModule_ContributeBaseFragment2() {}

  @Binds
  @IntoMap
  @ClassKey(BaseFragment2.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseFragment2Subcomponent.Builder builder);

  @Subcomponent
  public interface BaseFragment2Subcomponent extends AndroidInjector<BaseFragment2> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseFragment2> {}
  }
}
