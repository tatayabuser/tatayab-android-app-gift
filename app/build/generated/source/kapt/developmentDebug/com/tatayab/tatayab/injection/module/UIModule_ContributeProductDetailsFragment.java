package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.productdetails.ProductDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeProductDetailsFragment {
  private UIModule_ContributeProductDetailsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ProductDetailsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProductDetailsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ProductDetailsFragmentSubcomponent
      extends AndroidInjector<ProductDetailsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProductDetailsFragment> {}
  }
}
