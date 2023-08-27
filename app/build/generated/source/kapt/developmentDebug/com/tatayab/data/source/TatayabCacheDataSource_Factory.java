package com.tatayab.data.source;

import com.tatayab.data.repository.TatayabCache;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TatayabCacheDataSource_Factory implements Factory<TatayabCacheDataSource> {
  private final Provider<TatayabCache> tatayabCacheProvider;

  public TatayabCacheDataSource_Factory(Provider<TatayabCache> tatayabCacheProvider) {
    this.tatayabCacheProvider = tatayabCacheProvider;
  }

  @Override
  public TatayabCacheDataSource get() {
    return provideInstance(tatayabCacheProvider);
  }

  public static TatayabCacheDataSource provideInstance(
      Provider<TatayabCache> tatayabCacheProvider) {
    return new TatayabCacheDataSource(tatayabCacheProvider.get());
  }

  public static TatayabCacheDataSource_Factory create(Provider<TatayabCache> tatayabCacheProvider) {
    return new TatayabCacheDataSource_Factory(tatayabCacheProvider);
  }

  public static TatayabCacheDataSource newTatayabCacheDataSource(TatayabCache tatayabCache) {
    return new TatayabCacheDataSource(tatayabCache);
  }
}
