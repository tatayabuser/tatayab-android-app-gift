package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeOrderInvoiceFragment {
  private UIModule_ContributeOrderInvoiceFragment() {}

  @Binds
  @IntoMap
  @ClassKey(OrderInvoiceFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrderInvoiceFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface OrderInvoiceFragmentSubcomponent extends AndroidInjector<OrderInvoiceFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderInvoiceFragment> {}
  }
}
