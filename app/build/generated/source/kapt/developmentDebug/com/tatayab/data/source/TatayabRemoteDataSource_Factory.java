package com.tatayab.data.source;

import com.tatayab.data.repository.TatayabRemote;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TatayabRemoteDataSource_Factory implements Factory<TatayabRemoteDataSource> {
  private final Provider<TatayabRemote> tatayabRemoteProvider;

  public TatayabRemoteDataSource_Factory(Provider<TatayabRemote> tatayabRemoteProvider) {
    this.tatayabRemoteProvider = tatayabRemoteProvider;
  }

  @Override
  public TatayabRemoteDataSource get() {
    return provideInstance(tatayabRemoteProvider);
  }

  public static TatayabRemoteDataSource provideInstance(
      Provider<TatayabRemote> tatayabRemoteProvider) {
    return new TatayabRemoteDataSource(tatayabRemoteProvider.get());
  }

  public static TatayabRemoteDataSource_Factory create(
      Provider<TatayabRemote> tatayabRemoteProvider) {
    return new TatayabRemoteDataSource_Factory(tatayabRemoteProvider);
  }

  public static TatayabRemoteDataSource newTatayabRemoteDataSource(TatayabRemote tatayabRemote) {
    return new TatayabRemoteDataSource(tatayabRemote);
  }
}
