package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.livechat.LivechatFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeLivechatFragment {
  private UIModule_ContributeLivechatFragment() {}

  @Binds
  @IntoMap
  @ClassKey(LivechatFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LivechatFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface LivechatFragmentSubcomponent extends AndroidInjector<LivechatFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LivechatFragment> {}
  }
}
