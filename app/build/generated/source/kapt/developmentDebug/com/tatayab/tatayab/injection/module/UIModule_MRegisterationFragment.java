package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.auth.RegisterationFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_MRegisterationFragment {
  private UIModule_MRegisterationFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RegisterationFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegisterationFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface RegisterationFragmentSubcomponent
      extends AndroidInjector<RegisterationFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RegisterationFragment> {}
  }
}
