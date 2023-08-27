package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.cart.SharedCartActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeSharedCartActivity {
  private UIModule_ContributeSharedCartActivity() {}

  @Binds
  @IntoMap
  @ClassKey(SharedCartActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SharedCartActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface SharedCartActivitySubcomponent extends AndroidInjector<SharedCartActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SharedCartActivity> {}
  }
}
