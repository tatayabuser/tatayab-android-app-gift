package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.productdetails.ChooseOptionActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents = UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeChooseOptionActivity {
  private UIModule_ContributeChooseOptionActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ChooseOptionActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChooseOptionActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface ChooseOptionActivitySubcomponent extends AndroidInjector<ChooseOptionActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChooseOptionActivity> {}
  }
}
