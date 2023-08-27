package com.tatayab.tatayab.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SharedPrefAppSettings_Factory implements Factory<SharedPrefAppSettings> {
  private final Provider<Context> contextProvider;

  public SharedPrefAppSettings_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPrefAppSettings get() {
    return provideInstance(contextProvider);
  }

  public static SharedPrefAppSettings provideInstance(Provider<Context> contextProvider) {
    return new SharedPrefAppSettings(contextProvider.get());
  }

  public static SharedPrefAppSettings_Factory create(Provider<Context> contextProvider) {
    return new SharedPrefAppSettings_Factory(contextProvider);
  }

  public static SharedPrefAppSettings newSharedPrefAppSettings(Context context) {
    return new SharedPrefAppSettings(context);
  }
}
