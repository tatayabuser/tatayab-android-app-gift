package com.tatayab.tatayab.ordertracking;

import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OrderTrackingFragment_MembersInjector
    implements MembersInjector<OrderTrackingFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  public OrderTrackingFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<OrderTrackingFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new OrderTrackingFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(OrderTrackingFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }
}
