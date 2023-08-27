package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.data.source.TatayabCacheDataSource;
import com.tatayab.remote.service.TatayabServiceEndPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideTatayabServiceFactory
    implements Factory<TatayabServiceEndPoint> {
  private final RemoteModule module;

  private final Provider<Context> contextProvider;

  private final Provider<TatayabCacheDataSource> repositoryProvider;

  public RemoteModule_ProvideTatayabServiceFactory(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TatayabServiceEndPoint get() {
    return provideInstance(module, contextProvider, repositoryProvider);
  }

  public static TatayabServiceEndPoint provideInstance(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return proxyProvideTatayabService(module, contextProvider.get(), repositoryProvider.get());
  }

  public static RemoteModule_ProvideTatayabServiceFactory create(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return new RemoteModule_ProvideTatayabServiceFactory(
        module, contextProvider, repositoryProvider);
  }

  public static TatayabServiceEndPoint proxyProvideTatayabService(
      RemoteModule instance, Context context, TatayabCacheDataSource repository) {
    return Preconditions.checkNotNull(
        instance.provideTatayabService(context, repository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
