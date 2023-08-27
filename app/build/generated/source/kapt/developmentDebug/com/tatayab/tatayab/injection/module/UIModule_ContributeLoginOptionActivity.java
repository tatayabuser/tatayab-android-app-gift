package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.auth.LoginOptionActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeLoginOptionActivity {
  private UIModule_ContributeLoginOptionActivity() {}

  @Binds
  @IntoMap
  @ClassKey(LoginOptionActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LoginOptionActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface LoginOptionActivitySubcomponent extends AndroidInjector<LoginOptionActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginOptionActivity> {}
  }
}
