package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.supplier.SupplierFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeSuppliersFragment {
  private UIModule_ContributeSuppliersFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SupplierFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SupplierFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SupplierFragmentSubcomponent extends AndroidInjector<SupplierFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SupplierFragment> {}
  }
}
