package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.filter.SortFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeSortFragment.SortFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeSortFragment {
  private UIModule_ContributeSortFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SortFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SortFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SortFragmentSubcomponent extends AndroidInjector<SortFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SortFragment> {}
  }
}
