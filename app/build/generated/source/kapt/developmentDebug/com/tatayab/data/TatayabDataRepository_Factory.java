package com.tatayab.data;

import com.tatayab.data.repository.TatayabCache;
import com.tatayab.data.source.TatayabDataSourceFactory;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TatayabDataRepository_Factory implements Factory<TatayabDataRepository> {
  private final Provider<TatayabCache> cacheProvider;

  private final Provider<TatayabDataSourceFactory> factoryProvider;

  public TatayabDataRepository_Factory(
      Provider<TatayabCache> cacheProvider, Provider<TatayabDataSourceFactory> factoryProvider) {
    this.cacheProvider = cacheProvider;
    this.factoryProvider = factoryProvider;
  }

  @Override
  public TatayabDataRepository get() {
    return provideInstance(cacheProvider, factoryProvider);
  }

  public static TatayabDataRepository provideInstance(
      Provider<TatayabCache> cacheProvider, Provider<TatayabDataSourceFactory> factoryProvider) {
    return new TatayabDataRepository(cacheProvider.get(), factoryProvider.get());
  }

  public static TatayabDataRepository_Factory create(
      Provider<TatayabCache> cacheProvider, Provider<TatayabDataSourceFactory> factoryProvider) {
    return new TatayabDataRepository_Factory(cacheProvider, factoryProvider);
  }

  public static TatayabDataRepository newTatayabDataRepository(
      TatayabCache cache, TatayabDataSourceFactory factory) {
    return new TatayabDataRepository(cache, factory);
  }
}
