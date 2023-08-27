package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.main.categories.CategoriesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCategoriesFragment {
  private UIModule_ContributeCategoriesFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CategoriesFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CategoriesFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CategoriesFragmentSubcomponent extends AndroidInjector<CategoriesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CategoriesFragment> {}
  }
}
