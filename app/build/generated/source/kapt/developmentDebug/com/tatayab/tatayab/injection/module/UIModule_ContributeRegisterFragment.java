package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.auth.RegisterFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeRegisterFragment {
  private UIModule_ContributeRegisterFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RegisterFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegisterFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface RegisterFragmentSubcomponent extends AndroidInjector<RegisterFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RegisterFragment> {}
  }
}
