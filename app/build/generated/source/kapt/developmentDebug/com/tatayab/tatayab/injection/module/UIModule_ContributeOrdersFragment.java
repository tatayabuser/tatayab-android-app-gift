package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.orders.OrdersFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeOrdersFragment {
  private UIModule_ContributeOrdersFragment() {}

  @Binds
  @IntoMap
  @ClassKey(OrdersFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrdersFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface OrdersFragmentSubcomponent extends AndroidInjector<OrdersFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<OrdersFragment> {}
  }
}
