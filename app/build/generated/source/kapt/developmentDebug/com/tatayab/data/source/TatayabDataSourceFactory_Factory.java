package com.tatayab.data.source;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TatayabDataSourceFactory_Factory implements Factory<TatayabDataSourceFactory> {
  private final Provider<TatayabCacheDataSource> tatayabCacheDataSourceProvider;

  private final Provider<TatayabRemoteDataSource> tatayabRemoteDataSourceProvider;

  public TatayabDataSourceFactory_Factory(
      Provider<TatayabCacheDataSource> tatayabCacheDataSourceProvider,
      Provider<TatayabRemoteDataSource> tatayabRemoteDataSourceProvider) {
    this.tatayabCacheDataSourceProvider = tatayabCacheDataSourceProvider;
    this.tatayabRemoteDataSourceProvider = tatayabRemoteDataSourceProvider;
  }

  @Override
  public TatayabDataSourceFactory get() {
    return provideInstance(tatayabCacheDataSourceProvider, tatayabRemoteDataSourceProvider);
  }

  public static TatayabDataSourceFactory provideInstance(
      Provider<TatayabCacheDataSource> tatayabCacheDataSourceProvider,
      Provider<TatayabRemoteDataSource> tatayabRemoteDataSourceProvider) {
    return new TatayabDataSourceFactory(
        tatayabCacheDataSourceProvider.get(), tatayabRemoteDataSourceProvider.get());
  }

  public static TatayabDataSourceFactory_Factory create(
      Provider<TatayabCacheDataSource> tatayabCacheDataSourceProvider,
      Provider<TatayabRemoteDataSource> tatayabRemoteDataSourceProvider) {
    return new TatayabDataSourceFactory_Factory(
        tatayabCacheDataSourceProvider, tatayabRemoteDataSourceProvider);
  }

  public static TatayabDataSourceFactory newTatayabDataSourceFactory(
      TatayabCacheDataSource tatayabCacheDataSource,
      TatayabRemoteDataSource tatayabRemoteDataSource) {
    return new TatayabDataSourceFactory(tatayabCacheDataSource, tatayabRemoteDataSource);
  }
}
