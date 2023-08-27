package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.checkout.GiftOptionsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeGiftOptionsFragment {
  private UIModule_ContributeGiftOptionsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(GiftOptionsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      GiftOptionsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface GiftOptionsFragmentSubcomponent extends AndroidInjector<GiftOptionsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GiftOptionsFragment> {}
  }
}
