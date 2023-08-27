package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.cache.db.TatayabRoomDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CacheModule_ProvidesTatayabRoomDatabaseFactory
    implements Factory<TatayabRoomDatabase> {
  private final CacheModule module;

  private final Provider<Context> contextProvider;

  public CacheModule_ProvidesTatayabRoomDatabaseFactory(
      CacheModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public TatayabRoomDatabase get() {
    return provideInstance(module, contextProvider);
  }

  public static TatayabRoomDatabase provideInstance(
      CacheModule module, Provider<Context> contextProvider) {
    return proxyProvidesTatayabRoomDatabase(module, contextProvider.get());
  }

  public static CacheModule_ProvidesTatayabRoomDatabaseFactory create(
      CacheModule module, Provider<Context> contextProvider) {
    return new CacheModule_ProvidesTatayabRoomDatabaseFactory(module, contextProvider);
  }

  public static TatayabRoomDatabase proxyProvidesTatayabRoomDatabase(
      CacheModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.providesTatayabRoomDatabase(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
