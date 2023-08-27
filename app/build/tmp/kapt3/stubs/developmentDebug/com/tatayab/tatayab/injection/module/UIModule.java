package com.tatayab.tatayab.injection.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00fa\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\'J\b\u0010\t\u001a\u00020\nH\'J\b\u0010\u000b\u001a\u00020\fH\'J\b\u0010\r\u001a\u00020\u000eH\'J\b\u0010\u000f\u001a\u00020\u0010H\'J\b\u0010\u0011\u001a\u00020\u0012H\'J\b\u0010\u0013\u001a\u00020\u0014H\'J\b\u0010\u0015\u001a\u00020\u0016H\'J\b\u0010\u0017\u001a\u00020\u0018H\'J\b\u0010\u0019\u001a\u00020\u001aH\'J\b\u0010\u001b\u001a\u00020\u001cH\'J\b\u0010\u001d\u001a\u00020\u001eH\'J\b\u0010\u001f\u001a\u00020 H\'J\b\u0010!\u001a\u00020\"H\'J\b\u0010#\u001a\u00020$H\'J\b\u0010%\u001a\u00020&H\'J\b\u0010\'\u001a\u00020(H\'J\b\u0010)\u001a\u00020*H\'J\b\u0010+\u001a\u00020,H\'J\b\u0010-\u001a\u00020.H\'J\b\u0010/\u001a\u000200H\'J\b\u00101\u001a\u000202H\'J\b\u00103\u001a\u000204H\'J\b\u00105\u001a\u000206H\'J\b\u00107\u001a\u000208H\'J\b\u00109\u001a\u00020:H\'J\b\u0010;\u001a\u00020<H\'J\b\u0010=\u001a\u00020>H\'J\b\u0010?\u001a\u00020@H\'J\b\u0010A\u001a\u00020BH\'J\b\u0010C\u001a\u00020DH\'J\b\u0010E\u001a\u00020FH\'J\b\u0010G\u001a\u00020HH\'J\b\u0010I\u001a\u00020JH\'J\b\u0010K\u001a\u00020LH\'J\b\u0010M\u001a\u00020NH\'J\b\u0010O\u001a\u00020PH\'J\b\u0010Q\u001a\u00020RH\'J\b\u0010S\u001a\u00020TH\'J\b\u0010U\u001a\u00020VH\'J\b\u0010W\u001a\u00020XH\'J\b\u0010Y\u001a\u00020ZH\'J\b\u0010[\u001a\u00020\\H\'J\b\u0010]\u001a\u00020^H\'J\b\u0010_\u001a\u00020`H\'J\b\u0010a\u001a\u00020bH\'J\b\u0010c\u001a\u00020dH\'J\b\u0010e\u001a\u00020fH\'J\b\u0010g\u001a\u00020hH\'J\b\u0010i\u001a\u00020jH\'J\b\u0010k\u001a\u00020lH\'J\b\u0010m\u001a\u00020nH\'J\b\u0010o\u001a\u00020pH\'J\b\u0010q\u001a\u00020rH\'J\b\u0010s\u001a\u00020tH\'J\b\u0010u\u001a\u00020vH\'J\b\u0010w\u001a\u00020xH\'J\b\u0010y\u001a\u00020zH\'J\b\u0010{\u001a\u00020|H\'\u00a8\u0006}"}, d2 = {"Lcom/tatayab/tatayab/injection/module/UIModule;", "", "()V", "ErrorHandlingAct", "Lcom/tatayab/tatayab/errorHandling/ErrorHandlingAct;", "bindPostExecutionThread", "Lcom/tatayab/domain/executor/PostExecutionThread;", "uiThread", "Lcom/tatayab/tatayab/UIThread;", "contributeAboutUsFragment", "Lcom/tatayab/tatayab/aboutus/AboutUsFragment;", "contributeAccountFragment", "Lcom/tatayab/tatayab/main/account/AccountFragment;", "contributeAddAddressFragment", "Lcom/tatayab/tatayab/addresses/AddAddressFragment;", "contributeAddReviewFragment", "Lcom/tatayab/tatayab/productreviews/addreview/AddReviewFragment;", "contributeAddressesFragment", "Lcom/tatayab/tatayab/addresses/AddressesFragment;", "contributeBannerSeeMoreFragment", "Lcom/tatayab/tatayab/main/categories/BannerSeeMoreFragment;", "contributeBaseActivity", "Lcom/tatayab/tatayab/base/BaseActivity;", "contributeBaseFragment", "Lcom/tatayab/tatayab/base/BaseFragment;", "contributeBaseFragment2", "Lcom/tatayab/tatayab/base/BaseFragment2;", "contributeCartFragment", "Lcom/tatayab/tatayab/main/cart/CartFragment;", "contributeCategoriesFragment", "Lcom/tatayab/tatayab/main/categories/CategoriesFragment;", "contributeChangePasswordFragment", "Lcom/tatayab/tatayab/profile/ChangePasswordFragment;", "contributeCheckSignInFragment", "Lcom/tatayab/tatayab/checkout/SignInOptionsFragment;", "contributeCheckoutReviewPayFragment", "Lcom/tatayab/tatayab/checkout/CheckoutFragment;", "contributeChooseCityActivity", "Lcom/tatayab/tatayab/addresses/ChooseCityActivity;", "contributeChooseOptionActivity", "Lcom/tatayab/tatayab/productdetails/ChooseOptionActivity;", "contributeConciergeFragment", "Lcom/tatayab/tatayab/main/concierge/ConciergeFragment;", "contributeContactUsFragment", "Lcom/tatayab/tatayab/contactus/ContactUsFragment;", "contributeCountriesFragment", "Lcom/tatayab/tatayab/countries/CountriesFragment;", "contributeCountryFragment", "Lcom/tatayab/tatayab/splash/CountryFragment;", "contributeCurrenciesFragment", "Lcom/tatayab/tatayab/currencies/CurrenciesFragment;", "contributeDeepLinkActivity", "Lcom/tatayab/tatayab/deeplink/DeepLinkActivity;", "contributeEditProfileFragment", "Lcom/tatayab/tatayab/profile/EditProfileFragment;", "contributeFilterFragment", "Lcom/tatayab/tatayab/filter/FilterFragment;", "contributeFilterOptionsFragment", "Lcom/tatayab/tatayab/filter/FilterOptionsFragment;", "contributeForgetPasswordFragment", "Lcom/tatayab/tatayab/auth/ForgetPasswordFragment;", "contributeGiftOptionsFragment", "Lcom/tatayab/tatayab/checkout/GiftOptionsFragment;", "contributeHomeFragment", "Lcom/tatayab/tatayab/main/home/HomeFragment;", "contributeLivechatActivity", "Lcom/tatayab/tatayab/livechat/LiveChatActivity;", "contributeLivechatFragment", "Lcom/tatayab/tatayab/livechat/LivechatFragment;", "contributeLoginActivity", "Lcom/tatayab/tatayab/auth/LoginActivity;", "contributeLoginFragment", "Lcom/tatayab/tatayab/auth/LoginFragment;", "contributeLoginOptionActivity", "Lcom/tatayab/tatayab/auth/LoginOptionActivity;", "contributeMainActivity", "Lcom/tatayab/tatayab/MainActivity;", "contributeOrderDetailsFragment", "Lcom/tatayab/tatayab/orderdetails/OrderDetailsFragment;", "contributeOrderInvoiceFragment", "Lcom/tatayab/tatayab/invoiceorder/OrderInvoiceFragment;", "contributeOrderTrackingFragment", "Lcom/tatayab/tatayab/ordertracking/OrderTrackingFragment;", "contributeOrdersFragment", "Lcom/tatayab/tatayab/orders/OrdersFragment;", "contributePaymentFragment", "Lcom/tatayab/tatayab/checkout/PaymentFragment;", "contributePrivacyFragment", "Lcom/tatayab/tatayab/privacy/PrivacyFragment;", "contributeProductDetailsFragment", "Lcom/tatayab/tatayab/productdetails/ProductDetailsFragment;", "contributeProductReviewsFragment", "Lcom/tatayab/tatayab/productreviews/ProductReviewsFragment;", "contributeProductsFragment", "Lcom/tatayab/tatayab/productlist/ProductListFragment;", "contributeReferCartFragment", "Lcom/tatayab/tatayab/main/cart/ReferCartFragment;", "contributeReferFragment", "Lcom/tatayab/tatayab/refer/ReferFriendFragment;", "contributeReferFriendSuccessActivity", "Lcom/tatayab/tatayab/refer/ReferFriendSuccessActivity;", "contributeRegisterFragment", "Lcom/tatayab/tatayab/auth/RegisterFragment;", "contributeSearchFragment", "Lcom/tatayab/tatayab/search/SearchFragment;", "contributeSharedCartActivity", "Lcom/tatayab/tatayab/main/cart/SharedCartActivity;", "contributeSortFragment", "Lcom/tatayab/tatayab/filter/SortFragment;", "contributeSplashFragment", "Lcom/tatayab/tatayab/splash/SplashFragment;", "contributeSuppliersFragment", "Lcom/tatayab/tatayab/supplier/SupplierFragment;", "contributeTrackExternalOrderFragment", "Lcom/tatayab/tatayab/ordertracking/TrackExternalOrderFragment;", "contributeTransactionFragment", "Lcom/tatayab/tatayab/wallet/TransactionFragment;", "contributeUpdateProfileFragment", "Lcom/tatayab/tatayab/checkout/UpdateProfileFragment;", "contributeWalletFragment", "Lcom/tatayab/tatayab/wallet/WalletFragment;", "contributeWishListFragment", "Lcom/tatayab/tatayab/wishlist/WishListFragment;", "mRegisterationFragment", "Lcom/tatayab/tatayab/auth/RegisterationFragment;", "app_developmentDebug"})
@dagger.Module
public abstract class UIModule {
    
    public UIModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Binds
    public abstract com.tatayab.domain.executor.PostExecutionThread bindPostExecutionThread(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.UIThread uiThread);
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.base.BaseActivity contributeBaseActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.base.BaseFragment contributeBaseFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.base.BaseFragment2 contributeBaseFragment2();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.MainActivity contributeMainActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.addresses.ChooseCityActivity contributeChooseCityActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.productdetails.ChooseOptionActivity contributeChooseOptionActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.deeplink.DeepLinkActivity contributeDeepLinkActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.categories.CategoriesFragment contributeCategoriesFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.productlist.ProductListFragment contributeProductsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.LoginActivity contributeLoginActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.LoginOptionActivity contributeLoginOptionActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.LoginFragment contributeLoginFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.RegisterFragment contributeRegisterFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.splash.SplashFragment contributeSplashFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.splash.CountryFragment contributeCountryFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.home.HomeFragment contributeHomeFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.cart.CartFragment contributeCartFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.wishlist.WishListFragment contributeWishListFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.search.SearchFragment contributeSearchFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.ordertracking.OrderTrackingFragment contributeOrderTrackingFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.concierge.ConciergeFragment contributeConciergeFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.profile.EditProfileFragment contributeEditProfileFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.ForgetPasswordFragment contributeForgetPasswordFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.account.AccountFragment contributeAccountFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.aboutus.AboutUsFragment contributeAboutUsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.wallet.WalletFragment contributeWalletFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.categories.BannerSeeMoreFragment contributeBannerSeeMoreFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.wallet.TransactionFragment contributeTransactionFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.contactus.ContactUsFragment contributeContactUsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.productdetails.ProductDetailsFragment contributeProductDetailsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.addresses.AddAddressFragment contributeAddAddressFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.addresses.AddressesFragment contributeAddressesFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.supplier.SupplierFragment contributeSuppliersFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.currencies.CurrenciesFragment contributeCurrenciesFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.countries.CountriesFragment contributeCountriesFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.productreviews.ProductReviewsFragment contributeProductReviewsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.productreviews.addreview.AddReviewFragment contributeAddReviewFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.checkout.UpdateProfileFragment contributeUpdateProfileFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.checkout.CheckoutFragment contributeCheckoutReviewPayFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.checkout.SignInOptionsFragment contributeCheckSignInFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.auth.RegisterationFragment mRegisterationFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.checkout.PaymentFragment contributePaymentFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.filter.SortFragment contributeSortFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.filter.FilterFragment contributeFilterFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.filter.FilterOptionsFragment contributeFilterOptionsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.privacy.PrivacyFragment contributePrivacyFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.livechat.LivechatFragment contributeLivechatFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.livechat.LiveChatActivity contributeLivechatActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.refer.ReferFriendSuccessActivity contributeReferFriendSuccessActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.cart.SharedCartActivity contributeSharedCartActivity();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.errorHandling.ErrorHandlingAct ErrorHandlingAct();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.orders.OrdersFragment contributeOrdersFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment contributeOrderInvoiceFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.orderdetails.OrderDetailsFragment contributeOrderDetailsFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.ordertracking.TrackExternalOrderFragment contributeTrackExternalOrderFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.profile.ChangePasswordFragment contributeChangePasswordFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.refer.ReferFriendFragment contributeReferFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.main.cart.ReferCartFragment contributeReferCartFragment();
    
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.tatayab.tatayab.checkout.GiftOptionsFragment contributeGiftOptionsFragment();
}