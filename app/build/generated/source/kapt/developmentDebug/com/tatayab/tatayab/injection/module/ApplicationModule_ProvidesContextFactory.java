package com.tatayab.tatayab.injection.module;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvidesContextFactory implements Factory<Context> {
  private final ApplicationModule module;

  private final Provider<Application> applicationProvider;

  public ApplicationModule_ProvidesContextFactory(
      ApplicationModule module, Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return provideInstance(module, applicationProvider);
  }

  public static Context provideInstance(
      ApplicationModule module, Provider<Application> applicationProvider) {
    return proxyProvidesContext(module, applicationProvider.get());
  }

  public static ApplicationModule_ProvidesContextFactory create(
      ApplicationModule module, Provider<Application> applicationProvider) {
    return new ApplicationModule_ProvidesContextFactory(module, applicationProvider);
  }

  public static Context proxyProvidesContext(ApplicationModule instance, Application application) {
    return Preconditions.checkNotNull(
        instance.providesContext(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
