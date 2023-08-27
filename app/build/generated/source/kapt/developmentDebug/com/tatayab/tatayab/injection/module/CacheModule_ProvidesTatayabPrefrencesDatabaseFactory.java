package com.tatayab.tatayab.injection.module;

import android.content.Context;
import com.tatayab.cache.db.TatayabPrefrencesDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CacheModule_ProvidesTatayabPrefrencesDatabaseFactory
    implements Factory<TatayabPrefrencesDatabase> {
  private final CacheModule module;

  private final Provider<Context> contextProvider;

  public CacheModule_ProvidesTatayabPrefrencesDatabaseFactory(
      CacheModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public TatayabPrefrencesDatabase get() {
    return provideInstance(module, contextProvider);
  }

  public static TatayabPrefrencesDatabase provideInstance(
      CacheModule module, Provider<Context> contextProvider) {
    return proxyProvidesTatayabPrefrencesDatabase(module, contextProvider.get());
  }

  public static CacheModule_ProvidesTatayabPrefrencesDatabaseFactory create(
      CacheModule module, Provider<Context> contextProvider) {
    return new CacheModule_ProvidesTatayabPrefrencesDatabaseFactory(module, contextProvider);
  }

  public static TatayabPrefrencesDatabase proxyProvidesTatayabPrefrencesDatabase(
      CacheModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.providesTatayabPrefrencesDatabase(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
