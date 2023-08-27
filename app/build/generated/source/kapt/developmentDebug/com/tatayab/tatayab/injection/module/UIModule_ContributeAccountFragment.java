package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.account.AccountFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeAccountFragment.AccountFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeAccountFragment {
  private UIModule_ContributeAccountFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AccountFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AccountFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface AccountFragmentSubcomponent extends AndroidInjector<AccountFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AccountFragment> {}
  }
}
