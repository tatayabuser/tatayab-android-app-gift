package com.tatayab.tatayab.injection.module;

import com.tatayab.tatayab.productreviews.addreview.AddReviewFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(subcomponents = UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class UIModule_ContributeAddReviewFragment {
  private UIModule_ContributeAddReviewFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AddReviewFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddReviewFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface AddReviewFragmentSubcomponent extends AndroidInjector<AddReviewFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AddReviewFragment> {}
  }
}
