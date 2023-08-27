package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.ordertracking.TrackExternalOrderFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
  subcomponents =
      UIModule_ContributeTrackExternalOrderFragment.TrackExternalOrderFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeTrackExternalOrderFragment {
  private UIModule_ContributeTrackExternalOrderFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TrackExternalOrderFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TrackExternalOrderFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface TrackExternalOrderFragmentSubcomponent
      extends AndroidInjector<TrackExternalOrderFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrackExternalOrderFragment> {}
  }
}
