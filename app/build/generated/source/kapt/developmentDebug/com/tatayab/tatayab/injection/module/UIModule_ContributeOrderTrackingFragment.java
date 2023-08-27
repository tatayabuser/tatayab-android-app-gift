package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.ordertracking.OrderTrackingFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeOrderTrackingFragment {
  private UIModule_ContributeOrderTrackingFragment() {}

  @Binds
  @IntoMap
  @ClassKey(OrderTrackingFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrderTrackingFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface OrderTrackingFragmentSubcomponent
      extends AndroidInjector<OrderTrackingFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderTrackingFragment> {}
  }
}
