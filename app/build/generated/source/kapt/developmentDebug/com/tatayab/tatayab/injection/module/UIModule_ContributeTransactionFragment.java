package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.wallet.TransactionFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeTransactionFragment {
  private UIModule_ContributeTransactionFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TransactionFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TransactionFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface TransactionFragmentSubcomponent extends AndroidInjector<TransactionFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TransactionFragment> {}
  }
}
