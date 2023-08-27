package com.tatayab.tatayab.injection.module;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LocalizationModule_ProvidesArabicResourcesFactory implements Factory<Resources> {
  private final LocalizationModule module;

  private final Provider<Context> contextProvider;

  public LocalizationModule_ProvidesArabicResourcesFactory(
      LocalizationModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Resources get() {
    return provideInstance(module, contextProvider);
  }

  public static Resources provideInstance(
      LocalizationModule module, Provider<Context> contextProvider) {
    return proxyProvidesArabicResources(module, contextProvider.get());
  }

  public static LocalizationModule_ProvidesArabicResourcesFactory create(
      LocalizationModule module, Provider<Context> contextProvider) {
    return new LocalizationModule_ProvidesArabicResourcesFactory(module, contextProvider);
  }

  public static Resources proxyProvidesArabicResources(
      LocalizationModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.providesArabicResources(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
