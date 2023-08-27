package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.orderdetails.OrderDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeOrderDetailsFragment {
  private UIModule_ContributeOrderDetailsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(OrderDetailsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrderDetailsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface OrderDetailsFragmentSubcomponent extends AndroidInjector<OrderDetailsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderDetailsFragment> {}
  }
}
