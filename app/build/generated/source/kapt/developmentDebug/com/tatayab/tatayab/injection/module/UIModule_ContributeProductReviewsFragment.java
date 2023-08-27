package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.productreviews.ProductReviewsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeProductReviewsFragment {
  private UIModule_ContributeProductReviewsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ProductReviewsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProductReviewsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ProductReviewsFragmentSubcomponent
      extends AndroidInjector<ProductReviewsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProductReviewsFragment> {}
  }
}
