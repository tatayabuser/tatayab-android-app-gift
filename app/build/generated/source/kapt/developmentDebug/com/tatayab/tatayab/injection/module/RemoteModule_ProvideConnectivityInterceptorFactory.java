package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.remote.interceptor.ConnectivityInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideConnectivityInterceptorFactory
    implements Factory<ConnectivityInterceptor> {
  private final RemoteModule module;

  private final Provider<Context> contextProvider;

  public RemoteModule_ProvideConnectivityInterceptorFactory(
      RemoteModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public ConnectivityInterceptor get() {
    return provideInstance(module, contextProvider);
  }

  public static ConnectivityInterceptor provideInstance(
      RemoteModule module, Provider<Context> contextProvider) {
    return proxyProvideConnectivityInterceptor(module, contextProvider.get());
  }

  public static RemoteModule_ProvideConnectivityInterceptorFactory create(
      RemoteModule module, Provider<Context> contextProvider) {
    return new RemoteModule_ProvideConnectivityInterceptorFactory(module, contextProvider);
  }

  public static ConnectivityInterceptor proxyProvideConnectivityInterceptor(
      RemoteModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideConnectivityInterceptor(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
