package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.data.source.TatayabCacheDataSource;
import com.tatayab.remote.service.WalletTatayabServiceEndPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideWalletTatayabServiceFactory
    implements Factory<WalletTatayabServiceEndPoint> {
  private final RemoteModule module;

  private final Provider<Context> contextProvider;

  private final Provider<TatayabCacheDataSource> repositoryProvider;

  public RemoteModule_ProvideWalletTatayabServiceFactory(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public WalletTatayabServiceEndPoint get() {
    return provideInstance(module, contextProvider, repositoryProvider);
  }

  public static WalletTatayabServiceEndPoint provideInstance(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return proxyProvideWalletTatayabService(
        module, contextProvider.get(), repositoryProvider.get());
  }

  public static RemoteModule_ProvideWalletTatayabServiceFactory create(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return new RemoteModule_ProvideWalletTatayabServiceFactory(
        module, contextProvider, repositoryProvider);
  }

  public static WalletTatayabServiceEndPoint proxyProvideWalletTatayabService(
      RemoteModule instance, Context context, TatayabCacheDataSource repository) {
    return Preconditions.checkNotNull(
        instance.provideWalletTatayabService(context, repository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
