package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.addresses.ChooseCityActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeChooseCityActivity {
  private UIModule_ContributeChooseCityActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ChooseCityActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChooseCityActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface ChooseCityActivitySubcomponent extends AndroidInjector<ChooseCityActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChooseCityActivity> {}
  }
}
