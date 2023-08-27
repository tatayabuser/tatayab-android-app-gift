package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.wishlist.WishListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeWishListFragment.WishListFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeWishListFragment {
  private UIModule_ContributeWishListFragment() {}

  @Binds
  @IntoMap
  @ClassKey(WishListFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      WishListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface WishListFragmentSubcomponent extends AndroidInjector<WishListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<WishListFragment> {}
  }
}
