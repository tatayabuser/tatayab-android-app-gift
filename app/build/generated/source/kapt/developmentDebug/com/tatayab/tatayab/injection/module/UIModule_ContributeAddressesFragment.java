package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.addresses.AddressesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeAddressesFragment {
  private UIModule_ContributeAddressesFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AddressesFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddressesFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface AddressesFragmentSubcomponent extends AndroidInjector<AddressesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AddressesFragment> {}
  }
}
