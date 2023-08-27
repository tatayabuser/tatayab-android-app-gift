package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.livechat.LiveChatActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeLivechatActivity {
  private UIModule_ContributeLivechatActivity() {}

  @Binds
  @IntoMap
  @ClassKey(LiveChatActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LiveChatActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface LiveChatActivitySubcomponent extends AndroidInjector<LiveChatActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LiveChatActivity> {}
  }
}
