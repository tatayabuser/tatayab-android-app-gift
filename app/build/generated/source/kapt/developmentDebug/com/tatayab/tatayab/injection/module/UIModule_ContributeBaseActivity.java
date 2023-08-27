package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.base.BaseActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeBaseActivity.BaseActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeBaseActivity {
  private UIModule_ContributeBaseActivity() {}

  @Binds
  @IntoMap
  @ClassKey(BaseActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface BaseActivitySubcomponent extends AndroidInjector<BaseActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {}
  }
}
