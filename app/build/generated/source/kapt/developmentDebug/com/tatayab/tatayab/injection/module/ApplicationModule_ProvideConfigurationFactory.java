package com.tatayab.tatayab.injection.module;

import android.content.Context;
import android.content.res.Configuration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideConfigurationFactory implements Factory<Configuration> {
  private final ApplicationModule module;

  private final Provider<Context> contextProvider;

  public ApplicationModule_ProvideConfigurationFactory(
      ApplicationModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Configuration get() {
    return provideInstance(module, contextProvider);
  }

  public static Configuration provideInstance(
      ApplicationModule module, Provider<Context> contextProvider) {
    return proxyProvideConfiguration(module, contextProvider.get());
  }

  public static ApplicationModule_ProvideConfigurationFactory create(
      ApplicationModule module, Provider<Context> contextProvider) {
    return new ApplicationModule_ProvideConfigurationFactory(module, contextProvider);
  }

  public static Configuration proxyProvideConfiguration(
      ApplicationModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideConfiguration(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
