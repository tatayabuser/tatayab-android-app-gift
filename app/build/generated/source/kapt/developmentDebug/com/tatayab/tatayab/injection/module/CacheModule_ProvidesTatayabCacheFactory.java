package com.tatayab.tatayab.injection.module;

import com.tatayab.cache.TatayabCacheImpl;
import com.tatayab.data.repository.TatayabCache;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CacheModule_ProvidesTatayabCacheFactory implements Factory<TatayabCache> {
  private final CacheModule module;

  private final Provider<TatayabCacheImpl> tatayabCacheProvider;

  public CacheModule_ProvidesTatayabCacheFactory(
      CacheModule module, Provider<TatayabCacheImpl> tatayabCacheProvider) {
    this.module = module;
    this.tatayabCacheProvider = tatayabCacheProvider;
  }

  @Override
  public TatayabCache get() {
    return provideInstance(module, tatayabCacheProvider);
  }

  public static TatayabCache provideInstance(
      CacheModule module, Provider<TatayabCacheImpl> tatayabCacheProvider) {
    return proxyProvidesTatayabCache(module, tatayabCacheProvider.get());
  }

  public static CacheModule_ProvidesTatayabCacheFactory create(
      CacheModule module, Provider<TatayabCacheImpl> tatayabCacheProvider) {
    return new CacheModule_ProvidesTatayabCacheFactory(module, tatayabCacheProvider);
  }

  public static TatayabCache proxyProvidesTatayabCache(
      CacheModule instance, TatayabCacheImpl tatayabCache) {
    return Preconditions.checkNotNull(
        instance.providesTatayabCache(tatayabCache),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
