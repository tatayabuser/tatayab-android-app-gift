package com.tatayab.tatayab.orders;

import com.tatayab.presentation.orders.OrdersFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OrdersFragment_MembersInjector implements MembersInjector<OrdersFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<OrdersFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public OrdersFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<OrdersFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<OrdersFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<OrdersFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new OrdersFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(OrdersFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      OrdersFragment instance, OrdersFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
