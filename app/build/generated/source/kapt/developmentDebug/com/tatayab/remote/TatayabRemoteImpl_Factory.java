package com.tatayab.remote;

import com.tatayab.remote.service.QraphQlServiceEndPoint;
import com.tatayab.remote.service.TatayabServiceEndPoint;
import com.tatayab.remote.service.UserTatayabServiceEndPoint;
import com.tatayab.remote.service.WalletTatayabServiceEndPoint;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TatayabRemoteImpl_Factory implements Factory<TatayabRemoteImpl> {
  private final Provider<TatayabServiceEndPoint> serviceProvider;

  private final Provider<WalletTatayabServiceEndPoint> walletServiceProvider;

  private final Provider<UserTatayabServiceEndPoint> userServiceProvider;

  private final Provider<QraphQlServiceEndPoint> graphServiceProvider;

  public TatayabRemoteImpl_Factory(
      Provider<TatayabServiceEndPoint> serviceProvider,
      Provider<WalletTatayabServiceEndPoint> walletServiceProvider,
      Provider<UserTatayabServiceEndPoint> userServiceProvider,
      Provider<QraphQlServiceEndPoint> graphServiceProvider) {
    this.serviceProvider = serviceProvider;
    this.walletServiceProvider = walletServiceProvider;
    this.userServiceProvider = userServiceProvider;
    this.graphServiceProvider = graphServiceProvider;
  }

  @Override
  public TatayabRemoteImpl get() {
    return provideInstance(
        serviceProvider, walletServiceProvider, userServiceProvider, graphServiceProvider);
  }

  public static TatayabRemoteImpl provideInstance(
      Provider<TatayabServiceEndPoint> serviceProvider,
      Provider<WalletTatayabServiceEndPoint> walletServiceProvider,
      Provider<UserTatayabServiceEndPoint> userServiceProvider,
      Provider<QraphQlServiceEndPoint> graphServiceProvider) {
    return new TatayabRemoteImpl(
        serviceProvider.get(),
        walletServiceProvider.get(),
        userServiceProvider.get(),
        graphServiceProvider.get());
  }

  public static TatayabRemoteImpl_Factory create(
      Provider<TatayabServiceEndPoint> serviceProvider,
      Provider<WalletTatayabServiceEndPoint> walletServiceProvider,
      Provider<UserTatayabServiceEndPoint> userServiceProvider,
      Provider<QraphQlServiceEndPoint> graphServiceProvider) {
    return new TatayabRemoteImpl_Factory(
        serviceProvider, walletServiceProvider, userServiceProvider, graphServiceProvider);
  }

  public static TatayabRemoteImpl newTatayabRemoteImpl(
      TatayabServiceEndPoint service,
      WalletTatayabServiceEndPoint walletService,
      UserTatayabServiceEndPoint userService,
      QraphQlServiceEndPoint graphService) {
    return new TatayabRemoteImpl(service, walletService, userService, graphService);
  }
}
