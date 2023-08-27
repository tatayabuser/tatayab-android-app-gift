package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.checkout.SignInOptionsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCheckSignInFragment {
  private UIModule_ContributeCheckSignInFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SignInOptionsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SignInOptionsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SignInOptionsFragmentSubcomponent
      extends AndroidInjector<SignInOptionsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SignInOptionsFragment> {}
  }
}
