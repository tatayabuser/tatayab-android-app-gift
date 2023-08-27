package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.data.source.TatayabCacheDataSource;
import com.tatayab.remote.service.QraphQlServiceEndPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideQraphQlTatayabServiceFactory
    implements Factory<QraphQlServiceEndPoint> {
  private final RemoteModule module;

  private final Provider<Context> contextProvider;

  private final Provider<TatayabCacheDataSource> repositoryProvider;

  public RemoteModule_ProvideQraphQlTatayabServiceFactory(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public QraphQlServiceEndPoint get() {
    return provideInstance(module, contextProvider, repositoryProvider);
  }

  public static QraphQlServiceEndPoint provideInstance(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return proxyProvideQraphQlTatayabService(
        module, contextProvider.get(), repositoryProvider.get());
  }

  public static RemoteModule_ProvideQraphQlTatayabServiceFactory create(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return new RemoteModule_ProvideQraphQlTatayabServiceFactory(
        module, contextProvider, repositoryProvider);
  }

  public static QraphQlServiceEndPoint proxyProvideQraphQlTatayabService(
      RemoteModule instance, Context context, TatayabCacheDataSource repository) {
    return Preconditions.checkNotNull(
        instance.provideQraphQlTatayabService(context, repository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
