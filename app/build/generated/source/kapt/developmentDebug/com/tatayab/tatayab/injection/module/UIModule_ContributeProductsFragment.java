package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.productlist.ProductListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeProductsFragment {
  private UIModule_ContributeProductsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ProductListFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProductListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ProductListFragmentSubcomponent extends AndroidInjector<ProductListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProductListFragment> {}
  }
}
