package com.tatayab.tatayab.base;

import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity_Factory implements Factory<BaseActivity> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public BaseActivity_Factory(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public BaseActivity get() {
    return provideInstance(viewModelFactoryProvider);
  }

  public static BaseActivity provideInstance(Provider<ViewModelFactory> viewModelFactoryProvider) {
    BaseActivity instance = new BaseActivity();
    BaseActivity_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    return instance;
  }

  public static BaseActivity_Factory create(Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new BaseActivity_Factory(viewModelFactoryProvider);
  }

  public static BaseActivity newBaseActivity() {
    return new BaseActivity();
  }
}
