package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.contactus.ContactUsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeContactUsFragment {
  private UIModule_ContributeContactUsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ContactUsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ContactUsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ContactUsFragmentSubcomponent extends AndroidInjector<ContactUsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ContactUsFragment> {}
  }
}
