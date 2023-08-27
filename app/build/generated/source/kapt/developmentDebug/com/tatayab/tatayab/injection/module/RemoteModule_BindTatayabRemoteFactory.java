package com.tatayab.tatayab.injection.module;

import com.tatayab.data.repository.TatayabRemote;
import com.tatayab.remote.TatayabRemoteImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_BindTatayabRemoteFactory implements Factory<TatayabRemote> {
  private final RemoteModule module;

  private final Provider<TatayabRemoteImpl> tatayabRemoteProvider;

  public RemoteModule_BindTatayabRemoteFactory(
      RemoteModule module, Provider<TatayabRemoteImpl> tatayabRemoteProvider) {
    this.module = module;
    this.tatayabRemoteProvider = tatayabRemoteProvider;
  }

  @Override
  public TatayabRemote get() {
    return provideInstance(module, tatayabRemoteProvider);
  }

  public static TatayabRemote provideInstance(
      RemoteModule module, Provider<TatayabRemoteImpl> tatayabRemoteProvider) {
    return proxyBindTatayabRemote(module, tatayabRemoteProvider.get());
  }

  public static RemoteModule_BindTatayabRemoteFactory create(
      RemoteModule module, Provider<TatayabRemoteImpl> tatayabRemoteProvider) {
    return new RemoteModule_BindTatayabRemoteFactory(module, tatayabRemoteProvider);
  }

  public static TatayabRemote proxyBindTatayabRemote(
      RemoteModule instance, TatayabRemoteImpl tatayabRemote) {
    return Preconditions.checkNotNull(
        instance.bindTatayabRemote(tatayabRemote),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
