package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.profile.EditProfileFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeEditProfileFragment {
  private UIModule_ContributeEditProfileFragment() {}

  @Binds
  @IntoMap
  @ClassKey(EditProfileFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EditProfileFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface EditProfileFragmentSubcomponent extends AndroidInjector<EditProfileFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<EditProfileFragment> {}
  }
}
