package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.checkout.CheckoutFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCheckoutReviewPayFragment {
  private UIModule_ContributeCheckoutReviewPayFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CheckoutFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CheckoutFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CheckoutFragmentSubcomponent extends AndroidInjector<CheckoutFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CheckoutFragment> {}
  }
}
