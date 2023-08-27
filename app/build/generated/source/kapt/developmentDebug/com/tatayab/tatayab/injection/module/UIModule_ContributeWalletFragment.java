package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.wallet.WalletFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeWalletFragment.WalletFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeWalletFragment {
  private UIModule_ContributeWalletFragment() {}

  @Binds
  @IntoMap
  @ClassKey(WalletFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      WalletFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface WalletFragmentSubcomponent extends AndroidInjector<WalletFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<WalletFragment> {}
  }
}
