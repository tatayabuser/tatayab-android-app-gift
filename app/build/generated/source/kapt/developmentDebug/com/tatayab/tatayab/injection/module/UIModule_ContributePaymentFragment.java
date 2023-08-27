package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.checkout.PaymentFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributePaymentFragment {
  private UIModule_ContributePaymentFragment() {}

  @Binds
  @IntoMap
  @ClassKey(PaymentFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PaymentFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface PaymentFragmentSubcomponent extends AndroidInjector<PaymentFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PaymentFragment> {}
  }
}
