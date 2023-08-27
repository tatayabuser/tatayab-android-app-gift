package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.deeplink.DeepLinkActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeDeepLinkActivity {
  private UIModule_ContributeDeepLinkActivity() {}

  @Binds
  @IntoMap
  @ClassKey(DeepLinkActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DeepLinkActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface DeepLinkActivitySubcomponent extends AndroidInjector<DeepLinkActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DeepLinkActivity> {}
  }
}
