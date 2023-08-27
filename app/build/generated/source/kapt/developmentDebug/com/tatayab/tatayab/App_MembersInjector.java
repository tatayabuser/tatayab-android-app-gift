package com.tatayab.tatayab;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tatayab.tatayab.util.SharedPrefAppSettings;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<DispatchingAndroidInjector<Fragment>> androidFragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Activity>> androidInjectorProvider;

  private final Provider<SharedPrefAppSettings> appSettingsProvider;

  public App_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> androidFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Activity>> androidInjectorProvider,
      Provider<SharedPrefAppSettings> appSettingsProvider) {
    this.androidFragmentInjectorProvider = androidFragmentInjectorProvider;
    this.androidInjectorProvider = androidInjectorProvider;
    this.appSettingsProvider = appSettingsProvider;
  }

  public static MembersInjector<App> create(
      Provider<DispatchingAndroidInjector<Fragment>> androidFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Activity>> androidInjectorProvider,
      Provider<SharedPrefAppSettings> appSettingsProvider) {
    return new App_MembersInjector(
        androidFragmentInjectorProvider, androidInjectorProvider, appSettingsProvider);
  }

  @Override
  public void injectMembers(App instance) {
    injectAndroidFragmentInjector(instance, androidFragmentInjectorProvider.get());
    injectAndroidInjector(instance, androidInjectorProvider.get());
    injectAppSettings(instance, appSettingsProvider.get());
  }

  public static void injectAndroidFragmentInjector(
      App instance, DispatchingAndroidInjector<Fragment> androidFragmentInjector) {
    instance.androidFragmentInjector = androidFragmentInjector;
  }

  public static void injectAndroidInjector(
      App instance, DispatchingAndroidInjector<Activity> androidInjector) {
    instance.androidInjector = androidInjector;
  }

  public static void injectAppSettings(App instance, SharedPrefAppSettings appSettings) {
    instance.appSettings = appSettings;
  }
}
