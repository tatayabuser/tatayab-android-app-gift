package com.tatayab.tatayab.orderdetails;

import com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OrderDetailsFragment_MembersInjector
    implements MembersInjector<OrderDetailsFragment> {
  private final Provider<ViewModelFactory> baseViewModelFactoryProvider;

  private final Provider<OrderDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider;

  public OrderDetailsFragment_MembersInjector(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<OrderDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    this.baseViewModelFactoryProvider = baseViewModelFactoryProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<OrderDetailsFragment> create(
      Provider<ViewModelFactory> baseViewModelFactoryProvider,
      Provider<OrderDetailsFragmentViewModelFactory.Factory> viewModelFactoryProvider) {
    return new OrderDetailsFragment_MembersInjector(
        baseViewModelFactoryProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(OrderDetailsFragment instance) {
    BaseFragment2_MembersInjector.injectBaseViewModelFactory(
        instance, baseViewModelFactoryProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static void injectViewModelFactory(
      OrderDetailsFragment instance,
      OrderDetailsFragmentViewModelFactory.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
