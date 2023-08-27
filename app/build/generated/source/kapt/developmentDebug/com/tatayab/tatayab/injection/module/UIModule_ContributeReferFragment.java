package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.refer.ReferFriendFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeReferFragment {
  private UIModule_ContributeReferFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ReferFriendFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReferFriendFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ReferFriendFragmentSubcomponent extends AndroidInjector<ReferFriendFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ReferFriendFragment> {}
  }
}
