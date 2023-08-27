package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.addresses.AddAddressFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeAddAddressFragment {
  private UIModule_ContributeAddAddressFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AddAddressFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddAddressFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface AddAddressFragmentSubcomponent extends AndroidInjector<AddAddressFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AddAddressFragment> {}
  }
}
