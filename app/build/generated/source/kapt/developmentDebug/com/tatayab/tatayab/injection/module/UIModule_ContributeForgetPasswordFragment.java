package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.auth.ForgetPasswordFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeForgetPasswordFragment {
  private UIModule_ContributeForgetPasswordFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ForgetPasswordFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ForgetPasswordFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ForgetPasswordFragmentSubcomponent
      extends AndroidInjector<ForgetPasswordFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ForgetPasswordFragment> {}
  }
}
