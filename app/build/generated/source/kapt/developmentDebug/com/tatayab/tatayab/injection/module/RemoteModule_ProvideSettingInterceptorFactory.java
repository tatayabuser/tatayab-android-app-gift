package com.tatayab.tatayab.injection.module;

import com.tatayab.data.source.TatayabCacheDataSource;
import com.tatayab.remote.interceptor.SettingInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_ProvideSettingInterceptorFactory
    implements Factory<SettingInterceptor> {
  private final RemoteModule module;

  private final Provider<TatayabCacheDataSource> repositoryProvider;

  public RemoteModule_ProvideSettingInterceptorFactory(
      RemoteModule module, Provider<TatayabCacheDataSource> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SettingInterceptor get() {
    return provideInstance(module, repositoryProvider);
  }

  public static SettingInterceptor provideInstance(
      RemoteModule module, Provider<TatayabCacheDataSource> repositoryProvider) {
    return proxyProvideSettingInterceptor(module, repositoryProvider.get());
  }

  public static RemoteModule_ProvideSettingInterceptorFactory create(
      RemoteModule module, Provider<TatayabCacheDataSource> repositoryProvider) {
    return new RemoteModule_ProvideSettingInterceptorFactory(module, repositoryProvider);
  }

  public static SettingInterceptor proxyProvideSettingInterceptor(
      RemoteModule instance, TatayabCacheDataSource repository) {
    return Preconditions.checkNotNull(
        instance.provideSettingInterceptor(repository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
