package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.checkout.UpdateProfileFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeUpdateProfileFragment {
  private UIModule_ContributeUpdateProfileFragment() {}

  @Binds
  @IntoMap
  @ClassKey(UpdateProfileFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      UpdateProfileFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface UpdateProfileFragmentSubcomponent
      extends AndroidInjector<UpdateProfileFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UpdateProfileFragment> {}
  }
}
