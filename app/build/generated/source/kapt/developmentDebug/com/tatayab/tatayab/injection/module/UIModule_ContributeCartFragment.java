package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.cart.CartFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeCartFragment.CartFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCartFragment {
  private UIModule_ContributeCartFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CartFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CartFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CartFragmentSubcomponent extends AndroidInjector<CartFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CartFragment> {}
  }
}
