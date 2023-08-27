package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.refer.ReferFriendSuccessActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents =
      UIModule_ContributeReferFriendSuccessActivity.ReferFriendSuccessActivitySubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeReferFriendSuccessActivity {
  private UIModule_ContributeReferFriendSuccessActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ReferFriendSuccessActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReferFriendSuccessActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface ReferFriendSuccessActivitySubcomponent
      extends AndroidInjector<ReferFriendSuccessActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ReferFriendSuccessActivity> {}
  }
}
