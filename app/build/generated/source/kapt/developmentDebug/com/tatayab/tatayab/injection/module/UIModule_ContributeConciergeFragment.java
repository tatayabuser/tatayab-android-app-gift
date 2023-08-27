package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.concierge.ConciergeFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeConciergeFragment {
  private UIModule_ContributeConciergeFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ConciergeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ConciergeFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ConciergeFragmentSubcomponent extends AndroidInjector<ConciergeFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ConciergeFragment> {}
  }
}
