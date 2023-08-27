package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.data.source.TatayabCacheDataSource;
import com.tatayab.remote.service.UserTatayabServiceEndPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideUserTatayabServiceFactory
    implements Factory<UserTatayabServiceEndPoint> {
  private final RemoteModule module;

  private final Provider<Context> contextProvider;

  private final Provider<TatayabCacheDataSource> repositoryProvider;

  public RemoteModule_ProvideUserTatayabServiceFactory(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public UserTatayabServiceEndPoint get() {
    return provideInstance(module, contextProvider, repositoryProvider);
  }

  public static UserTatayabServiceEndPoint provideInstance(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return proxyProvideUserTatayabService(module, contextProvider.get(), repositoryProvider.get());
  }

  public static RemoteModule_ProvideUserTatayabServiceFactory create(
      RemoteModule module,
      Provider<Context> contextProvider,
      Provider<TatayabCacheDataSource> repositoryProvider) {
    return new RemoteModule_ProvideUserTatayabServiceFactory(
        module, contextProvider, repositoryProvider);
  }

  public static UserTatayabServiceEndPoint proxyProvideUserTatayabService(
      RemoteModule instance, Context context, TatayabCacheDataSource repository) {
    return Preconditions.checkNotNull(
        instance.provideUserTatayabService(context, repository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
