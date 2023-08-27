package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.currencies.CurrenciesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeCurrenciesFragment {
  private UIModule_ContributeCurrenciesFragment() {}

  @Binds
  @IntoMap
  @ClassKey(CurrenciesFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CurrenciesFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CurrenciesFragmentSubcomponent extends AndroidInjector<CurrenciesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CurrenciesFragment> {}
  }
}
