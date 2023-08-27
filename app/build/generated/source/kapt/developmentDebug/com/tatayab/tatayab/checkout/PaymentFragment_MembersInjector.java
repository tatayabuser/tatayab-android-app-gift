package com.tatayab.tatayab.checkout;

import com.tatayab.presentation.main.MainActivityViewModelFactory;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory;
import com.tatayab.tatayab.injection.ViewModelFactory;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PaymentFragment_MembersInjector implements MembersInjector<PaymentFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private final Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider;

  private final Provider<PaymentFragmentViewModelFactory.Factory>
      paymentFragmentViewModelFactorProvider;

  public PaymentFragment_MembersInjector(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<PaymentFragmentViewModelFactory.Factory> paymentFragmentViewModelFactorProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
    this.mainViewModelFactoryProvider = mainViewModelFactoryProvider;
    this.paymentFragmentViewModelFactorProvider = paymentFragmentViewModelFactorProvider;
  }

  public static MembersInjector<PaymentFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider,
      Provider<MainActivityViewModelFactory.Factory> mainViewModelFactoryProvider,
      Provider<PaymentFragmentViewModelFactory.Factory> paymentFragmentViewModelFactorProvider) {
    return new PaymentFragment_MembersInjector(
        viewModelFactoryProvider,
        mainViewModelFactoryProvider,
        paymentFragmentViewModelFactorProvider);
  }

  @Override
  public void injectMembers(PaymentFragment instance) {
    BaseFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactoryProvider.get());
    injectMainViewModelFactory(instance, mainViewModelFactoryProvider.get());
    injectPaymentFragmentViewModelFactor(instance, paymentFragmentViewModelFactorProvider.get());
  }

  public static void injectMainViewModelFactory(
      PaymentFragment instance, MainActivityViewModelFactory.Factory mainViewModelFactory) {
    instance.mainViewModelFactory = mainViewModelFactory;
  }

  public static void injectPaymentFragmentViewModelFactor(
      PaymentFragment instance,
      PaymentFragmentViewModelFactory.Factory PaymentFragmentViewModelFactor) {
    instance.PaymentFragmentViewModelFactor = PaymentFragmentViewModelFactor;
  }
}
