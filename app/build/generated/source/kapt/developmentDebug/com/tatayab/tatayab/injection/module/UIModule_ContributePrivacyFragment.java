package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.privacy.PrivacyFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributePrivacyFragment {
  private UIModule_ContributePrivacyFragment() {}

  @Binds
  @IntoMap
  @ClassKey(PrivacyFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PrivacyFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface PrivacyFragmentSubcomponent extends AndroidInjector<PrivacyFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PrivacyFragment> {}
  }
}
