package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.tatayab.util.SharedPrefAppSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppSettingsModule_ProvideAppSettingsFactory
    implements Factory<SharedPrefAppSettings> {
  private final AppSettingsModule module;

  private final Provider<Context> contextProvider;

  public AppSettingsModule_ProvideAppSettingsFactory(
      AppSettingsModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPrefAppSettings get() {
    return provideInstance(module, contextProvider);
  }

  public static SharedPrefAppSettings provideInstance(
      AppSettingsModule module, Provider<Context> contextProvider) {
    return proxyProvideAppSettings(module, contextProvider.get());
  }

  public static AppSettingsModule_ProvideAppSettingsFactory create(
      AppSettingsModule module, Provider<Context> contextProvider) {
    return new AppSettingsModule_ProvideAppSettingsFactory(module, contextProvider);
  }

  public static SharedPrefAppSettings proxyProvideAppSettings(
      AppSettingsModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideAppSettings(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
