package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.errorHandling.ErrorHandlingAct;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ErrorHandlingAct {
  private UIModule_ErrorHandlingAct() {}

  @Binds
  @IntoMap
  @ClassKey(ErrorHandlingAct.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ErrorHandlingActSubcomponent.Builder builder);

  @Subcomponent
  public interface ErrorHandlingActSubcomponent extends AndroidInjector<ErrorHandlingAct> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ErrorHandlingAct> {}
  }
}
