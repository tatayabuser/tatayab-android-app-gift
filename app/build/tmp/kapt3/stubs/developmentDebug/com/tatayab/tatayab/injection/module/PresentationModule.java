package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a4\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0014H\'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0017H\'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u001dH\'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020 H\'J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020#H\'J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020&H\'J\u0010\u0010\'\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020)H\'J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020,H\'J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020/H\'J\u0010\u00100\u001a\u0002012\u0006\u0010\u000b\u001a\u000202H\'J\u0010\u00103\u001a\u0002042\u0006\u0010\u000b\u001a\u000205H\'J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000207H\'J\u0010\u00108\u001a\u0002092\u0006\u0010\u000b\u001a\u00020:H\'J\u0010\u0010;\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020=H\'J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020@H\'J\u0010\u0010A\u001a\u00020B2\u0006\u0010\u000b\u001a\u00020CH\'J\u0010\u0010D\u001a\u00020E2\u0006\u0010\u000b\u001a\u00020FH\'J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020HH\'J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020JH\'J\u0010\u0010K\u001a\u00020L2\u0006\u0010\u000b\u001a\u00020MH\'J\u0010\u0010N\u001a\u00020O2\u0006\u0010\u000b\u001a\u00020PH\'J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020RH\'J\u0010\u0010S\u001a\u00020T2\u0006\u0010\u000b\u001a\u00020UH\'J\u0010\u0010V\u001a\u00020W2\u0006\u0010\u000b\u001a\u00020XH\'\u00a8\u0006Y"}, d2 = {"Lcom/tatayab/tatayab/injection/module/PresentationModule;", "", "()V", "bindAccountFragmentViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/tatayab/presentation/account/AccountFragmentViewModel;", "bindAddReviewViewModel", "Lcom/tatayab/presentation/addreview/AddReviewViewModel;", "bindAddressFragmentViewModelFactory", "Lcom/tatayab/presentation/address/AddressFragmentViewModelFactory$Factory;", "factory", "Lcom/tatayab/presentation/address/AddressFragmentViewModelFactory_AssistedFactory;", "bindBaseViewModel", "Lcom/tatayab/presentation/base/BaseViewModel;", "bindCartFragmentViewModelFactory", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory_AssistedFactory;", "bindCategoryFragmentViewModelFactory", "Lcom/tatayab/presentation/main/category/CategoryFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/main/category/CategoryFragmentViewModelFactory_AssistedFactory;", "bindCheckoutFragmentViewModelFactory", "Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/checkout/CheckoutFragmentViewModelFactory_AssistedFactory;", "bindConciergeViewModelFactory", "Lcom/tatayab/presentation/addconcierge/ConciergeViewModelFactory$Factory;", "Lcom/tatayab/presentation/addconcierge/ConciergeViewModelFactory_AssistedFactory;", "bindCountriesFragmentViewModelFactory", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/countries/CountriesFragmentViewModelFactory_AssistedFactory;", "bindCurrienciesFragmentViewModelFactory", "Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/curriencies/CurrenciesFragmentViewModelFactory_AssistedFactory;", "bindHomeFragmentViewModelFactory", "Lcom/tatayab/presentation/main/home/HomeFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/main/home/HomeFragmentViewModelFactory_AssistedFactory;", "bindMainActivityViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory_AssistedFactory;", "bindOrderDetailsFragmentFactory", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/orders/OrderDetailsFragmentViewModelFactory_AssistedFactory;", "bindOrderFragmentViewModelFactory", "Lcom/tatayab/presentation/orders/OrdersFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/orders/OrdersFragmentViewModelFactory_AssistedFactory;", "bindProductDetailsFragmentFactory", "Lcom/tatayab/presentation/product/ProductDetailsFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/product/ProductDetailsFragmentViewModelFactory_AssistedFactory;", "bindProductListFragmentFactory", "Lcom/tatayab/presentation/product/ProductListFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/product/ProductListFragmentViewModelFactory_AssistedFactory;", "bindProductReviewsViewModelFactory", "Lcom/tatayab/presentation/product/ProductReviewsViewModelFactory$Factory;", "Lcom/tatayab/presentation/product/ProductReviewsViewModelFactory_AssistedFactory;", "bindProfileFragmentViewModel", "Lcom/tatayab/presentation/profile/ProfileFragmentViewModel;", "bindReferCartFriendViewModelFactory", "Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModelFactory$Factory;", "Lcom/tatayab/presentation/main/cart/ReferCartFriendViewModelFactory_AssistedFactory;", "bindReferFriendSuccessViewModelFactory", "Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModelFactory$Factory;", "Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModelFactory_AssistedFactory;", "bindSearchFragmentFactory", "Lcom/tatayab/presentation/product/SearchFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/product/SearchFragmentViewModelFactory_AssistedFactory;", "bindSplashFragmentViewModelFactory", "Lcom/tatayab/presentation/splash/SplashFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/splash/SplashFragmentViewModelFactory_AssistedFactory;", "bindSuppliersFragmentViewModelFactory", "Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/suppliers/SuppliersFragmentViewModelFactory_AssistedFactory;", "bindUserLoginViewModel", "Lcom/tatayab/presentation/auth/UserLoginViewModel;", "bindUserSocialLoginViewModel", "Lcom/tatayab/presentation/auth/UserSocialLoginViewModel;", "bindUserSocialLoginViewModelFactory", "Lcom/tatayab/presentation/auth/UserSocialLoginViewModelFactory$Factory;", "Lcom/tatayab/presentation/auth/UserSocialLoginViewModelFactory_AssistedFactory;", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/tatayab/tatayab/injection/ViewModelFactory;", "bindWalletFragmentViewModel", "Lcom/tatayab/presentation/wallet/WalletViewModel;", "bindWalletViewModelFactory", "Lcom/tatayab/presentation/wallet/WalletViewModelFactory$Factory;", "Lcom/tatayab/presentation/wallet/WalletViewModelFactory_AssistedFactory;", "bindWishlistFragmentViewModelFactory", "Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModelFactory$Factory;", "Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModelFactory_AssistedFactory;", "app_developmentDebug"})
@dagger.Module
public abstract class PresentationModule {
    
    public PresentationModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.profile.ProfileFragmentViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindProfileFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.profile.ProfileFragmentViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.addreview.AddReviewViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindAddReviewViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.addreview.AddReviewViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.product.SearchFragmentViewModelFactory.Factory bindSearchFragmentFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.SearchFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.auth.UserLoginViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindUserLoginViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.auth.UserLoginViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindBaseViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.base.BaseViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.auth.UserSocialLoginViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindUserSocialLoginViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.auth.UserSocialLoginViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.wallet.WalletViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindWalletFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wallet.WalletViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @ViewModelKey(value = com.tatayab.presentation.account.AccountFragmentViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindAccountFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.account.AccountFragmentViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.main.home.HomeFragmentViewModelFactory.Factory bindHomeFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.home.HomeFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory.Factory bindCategoryFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.countries.CountriesFragmentViewModelFactory.Factory bindCountriesFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.countries.CountriesFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.addconcierge.ConciergeViewModelFactory.Factory bindConciergeViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.addconcierge.ConciergeViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.address.AddressFragmentViewModelFactory.Factory bindAddressFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.address.AddressFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory.Factory bindCurrienciesFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.splash.SplashFragmentViewModelFactory.Factory bindSplashFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.splash.SplashFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory.Factory bindSuppliersFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory.Factory bindWishlistFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.orders.OrdersFragmentViewModelFactory.Factory bindOrderFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrdersFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory.Factory bindProductDetailsFragmentFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory.Factory bindOrderDetailsFragmentFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.product.ProductReviewsViewModelFactory.Factory bindProductReviewsViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.ProductReviewsViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.product.ProductListFragmentViewModelFactory.Factory bindProductListFragmentFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.product.ProductListFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory bindCartFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.CartFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.main.MainActivityViewModelFactory.Factory bindMainActivityViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.wallet.WalletViewModelFactory.Factory bindWalletViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wallet.WalletViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory.Factory bindReferFriendSuccessViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory.Factory bindReferCartFriendViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory.Factory bindCheckoutFragmentViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.presentation.auth.UserSocialLoginViewModelFactory.Factory bindUserSocialLoginViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.auth.UserSocialLoginViewModelFactory_AssistedFactory factory);
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModelProvider.Factory bindViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.injection.ViewModelFactory factory);
}