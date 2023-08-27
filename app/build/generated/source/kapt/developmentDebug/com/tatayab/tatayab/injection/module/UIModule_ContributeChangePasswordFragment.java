package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.profile.ChangePasswordFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeChangePasswordFragment {
  private UIModule_ContributeChangePasswordFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ChangePasswordFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChangePasswordFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ChangePasswordFragmentSubcomponent
      extends AndroidInjector<ChangePasswordFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChangePasswordFragment> {}
  }
}
