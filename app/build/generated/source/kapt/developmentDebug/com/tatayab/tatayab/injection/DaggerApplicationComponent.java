package com.tatayab.tatayab.injection;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.tatayab.cache.TatayabCacheImpl_Factory;
import com.tatayab.cache.mapper.CachedAddressMapper_Factory;
import com.tatayab.cache.mapper.CachedUserMapper_Factory;
import com.tatayab.cache.mapper.CachedWishItemMapper_Factory;
import com.tatayab.data.TatayabDataRepository;
import com.tatayab.data.TatayabDataRepository_Factory;
import com.tatayab.data.source.TatayabCacheDataSource_Factory;
import com.tatayab.data.source.TatayabDataSourceFactory_Factory;
import com.tatayab.data.source.TatayabRemoteDataSource_Factory;
import com.tatayab.domain.interactor.account.profile.ChangePassword;
import com.tatayab.domain.interactor.account.profile.ChangePassword_Factory;
import com.tatayab.domain.interactor.account.profile.EditProfile;
import com.tatayab.domain.interactor.account.profile.EditProfile_Factory;
import com.tatayab.domain.interactor.account.profile.GetUserProfile;
import com.tatayab.domain.interactor.account.profile.GetUserProfile_Factory;
import com.tatayab.domain.interactor.addconcierge.AddConcierge_Factory;
import com.tatayab.domain.interactor.address.AddAddress_Factory;
import com.tatayab.domain.interactor.address.DeleteAddress_Factory;
import com.tatayab.domain.interactor.address.GetArea_Factory;
import com.tatayab.domain.interactor.address.GetCities_Factory;
import com.tatayab.domain.interactor.address.GetCustomerAddresses_Factory;
import com.tatayab.domain.interactor.address.GetGuestLastAddress_Factory;
import com.tatayab.domain.interactor.address.SaveGuestAddress_Factory;
import com.tatayab.domain.interactor.addreview.AddReviewToProduct;
import com.tatayab.domain.interactor.addreview.AddReviewToProduct_Factory;
import com.tatayab.domain.interactor.auth.ForgetPassword_Factory;
import com.tatayab.domain.interactor.auth.GetUserTokenExecution_Factory;
import com.tatayab.domain.interactor.auth.Login_Factory;
import com.tatayab.domain.interactor.auth.Logout;
import com.tatayab.domain.interactor.auth.Logout_Factory;
import com.tatayab.domain.interactor.auth.Register_Factory;
import com.tatayab.domain.interactor.auth.SocialLoginExecute_Factory;
import com.tatayab.domain.interactor.auth.UpdateUserTokenWithLangaugAndCountryExecution_Factory;
import com.tatayab.domain.interactor.cart.AddBillingAddressToCartExecution_Factory;
import com.tatayab.domain.interactor.cart.AddCouponExecution_Factory;
import com.tatayab.domain.interactor.cart.AddGuestEmailToCartExecution_Factory;
import com.tatayab.domain.interactor.cart.AddItemToCartQueryCartExecution_Factory;
import com.tatayab.domain.interactor.cart.AddOrderToCart_Factory;
import com.tatayab.domain.interactor.cart.AddShippingAddressToCartExecution_Factory;
import com.tatayab.domain.interactor.cart.CashBackExecution_Factory;
import com.tatayab.domain.interactor.cart.CheckTokenExecution_Factory;
import com.tatayab.domain.interactor.cart.CheckoutReviewExecution_Factory;
import com.tatayab.domain.interactor.cart.ClearCachedAndRemoteCart_Factory;
import com.tatayab.domain.interactor.cart.CreateGuestCartExecution_Factory;
import com.tatayab.domain.interactor.cart.CreateOrderExecution_Factory;
import com.tatayab.domain.interactor.cart.CreateUserCartExecution_Factory;
import com.tatayab.domain.interactor.cart.DeleteOrderFromCart_Factory;
import com.tatayab.domain.interactor.cart.GetCartContent_Factory;
import com.tatayab.domain.interactor.cart.GetGeneratedToken_Factory;
import com.tatayab.domain.interactor.cart.GetOrdersCountInCartExecute_Factory;
import com.tatayab.domain.interactor.cart.MergeCartsExecution_Factory;
import com.tatayab.domain.interactor.cart.PaymentMethodExecution_Factory;
import com.tatayab.domain.interactor.cart.RemoveCouponExecution_Factory;
import com.tatayab.domain.interactor.cart.RestoreCartExecution_Factory;
import com.tatayab.domain.interactor.cart.SetShippingMethodExecution_Factory;
import com.tatayab.domain.interactor.cart.ShippingMethodsExecution_Factory;
import com.tatayab.domain.interactor.cart.UpdateCartItemAmount_Factory;
import com.tatayab.domain.interactor.countries.GetCountries_Factory;
import com.tatayab.domain.interactor.curriencies.GetCurrencies_Factory;
import com.tatayab.domain.interactor.filter.GetFilter_Factory;
import com.tatayab.domain.interactor.main.CountryCurrencyExecution_Factory;
import com.tatayab.domain.interactor.main.GetCategoryBanner_Factory;
import com.tatayab.domain.interactor.main.GetCategory_Factory;
import com.tatayab.domain.interactor.main.GetSubCategory_Factory;
import com.tatayab.domain.interactor.orders.GetOrderDetails_Factory;
import com.tatayab.domain.interactor.orders.GetOrderTracking_Factory;
import com.tatayab.domain.interactor.product.GetAddNotifyMeAction_Factory;
import com.tatayab.domain.interactor.product.GetAlsoBoughtProducts_Factory;
import com.tatayab.domain.interactor.product.GetProductDetails_Factory;
import com.tatayab.domain.interactor.product.GetProductReviews_Factory;
import com.tatayab.domain.interactor.product.GetProductsWithSearch_Factory;
import com.tatayab.domain.interactor.product.GetSpecificProducts_Factory;
import com.tatayab.domain.interactor.product.ProductGiftUserCase_Factory;
import com.tatayab.domain.interactor.product.SearchRecommanededProductsListExecution_Factory;
import com.tatayab.domain.interactor.product.SearchSuggestionListExecution_Factory;
import com.tatayab.domain.interactor.productotions.GetProductOptions_Factory;
import com.tatayab.domain.interactor.user.ExtractDeepLinkExecution_Factory;
import com.tatayab.domain.interactor.user.GetCurrentUser;
import com.tatayab.domain.interactor.user.GetCurrentUser_Factory;
import com.tatayab.domain.interactor.user.GetUpgradeChecker_Factory;
import com.tatayab.domain.interactor.user.GetUserSetting;
import com.tatayab.domain.interactor.user.GetUserSetting_Factory;
import com.tatayab.domain.interactor.user.LogoutExecution;
import com.tatayab.domain.interactor.user.LogoutExecution_Factory;
import com.tatayab.domain.interactor.user.PromotionExecution_Factory;
import com.tatayab.domain.interactor.user.SaveCountryExecution_Factory;
import com.tatayab.domain.interactor.user.SaveCurrentLangauge_Factory;
import com.tatayab.domain.interactor.user.SaveFirebaseTokenExecution_Factory;
import com.tatayab.domain.interactor.user.SaveUserAuth_Factory;
import com.tatayab.domain.interactor.user.SaveUserSetting_Factory;
import com.tatayab.domain.interactor.user.SetFirebaseToken_Factory;
import com.tatayab.domain.interactor.wallet.CheckEarnExecution_Factory;
import com.tatayab.domain.interactor.wallet.GetTransactionsHistoryExecution;
import com.tatayab.domain.interactor.wallet.GetTransactionsHistoryExecution_Factory;
import com.tatayab.domain.interactor.wallet.GetWalletExecution;
import com.tatayab.domain.interactor.wallet.GetWalletExecution_Factory;
import com.tatayab.domain.interactor.wallet.InviteFriendExecution_Factory;
import com.tatayab.domain.interactor.wallet.RedeemCodeExecution;
import com.tatayab.domain.interactor.wallet.RedeemCodeExecution_Factory;
import com.tatayab.domain.interactor.wishlist.GetUserWishList_Factory;
import com.tatayab.domain.interactor.wishlist.WishListActions_Factory;
import com.tatayab.presentation.account.AccountFragmentViewModel;
import com.tatayab.presentation.account.AccountFragmentViewModel_Factory;
import com.tatayab.presentation.addconcierge.ConciergeViewModelFactory_AssistedFactory;
import com.tatayab.presentation.address.AddressFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.addreview.AddReviewViewModel;
import com.tatayab.presentation.addreview.AddReviewViewModel_Factory;
import com.tatayab.presentation.auth.UserLoginViewModel;
import com.tatayab.presentation.auth.UserLoginViewModel_Factory;
import com.tatayab.presentation.auth.UserSocialLoginViewModel;
import com.tatayab.presentation.auth.UserSocialLoginViewModelFactory_AssistedFactory;
import com.tatayab.presentation.auth.UserSocialLoginViewModel_Factory;
import com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.main.MainActivityViewModelFactory_AssistedFactory;
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory_AssistedFactory;
import com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.main.home.HomeFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.orders.OrdersFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.product.ProductListFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.product.ProductReviewsViewModelFactory_AssistedFactory;
import com.tatayab.presentation.product.SearchFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.profile.ProfileFragmentViewModel;
import com.tatayab.presentation.profile.ProfileFragmentViewModel_Factory;
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory_AssistedFactory;
import com.tatayab.presentation.splash.SplashFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.suppliers.GetSuppliers_Factory;
import com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory_AssistedFactory;
import com.tatayab.presentation.wallet.WalletViewModel;
import com.tatayab.presentation.wallet.WalletViewModelFactory_AssistedFactory;
import com.tatayab.presentation.wallet.WalletViewModel_Factory;
import com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory_AssistedFactory;
import com.tatayab.remote.TatayabRemoteImpl_Factory;
import com.tatayab.tatayab.App;
import com.tatayab.tatayab.App_MembersInjector;
import com.tatayab.tatayab.MainActivity;
import com.tatayab.tatayab.MainActivity_MembersInjector;
import com.tatayab.tatayab.UIThread;
import com.tatayab.tatayab.UIThread_Factory;
import com.tatayab.tatayab.aboutus.AboutUsFragment;
import com.tatayab.tatayab.aboutus.AboutUsFragment_MembersInjector;
import com.tatayab.tatayab.addresses.AddAddressFragment;
import com.tatayab.tatayab.addresses.AddAddressFragment_MembersInjector;
import com.tatayab.tatayab.addresses.AddressesFragment;
import com.tatayab.tatayab.addresses.AddressesFragment_MembersInjector;
import com.tatayab.tatayab.addresses.ChooseCityActivity;
import com.tatayab.tatayab.auth.ForgetPasswordFragment;
import com.tatayab.tatayab.auth.LoginActivity;
import com.tatayab.tatayab.auth.LoginFragment;
import com.tatayab.tatayab.auth.LoginFragment_MembersInjector;
import com.tatayab.tatayab.auth.LoginOptionActivity;
import com.tatayab.tatayab.auth.RegisterFragment;
import com.tatayab.tatayab.auth.RegisterFragment_MembersInjector;
import com.tatayab.tatayab.auth.RegisterationFragment;
import com.tatayab.tatayab.base.BaseActivity;
import com.tatayab.tatayab.base.BaseActivity_MembersInjector;
import com.tatayab.tatayab.base.BaseFragment;
import com.tatayab.tatayab.base.BaseFragment2;
import com.tatayab.tatayab.base.BaseFragment2_MembersInjector;
import com.tatayab.tatayab.base.BaseFragment_MembersInjector;
import com.tatayab.tatayab.checkout.CheckoutFragment;
import com.tatayab.tatayab.checkout.CheckoutFragment_MembersInjector;
import com.tatayab.tatayab.checkout.GiftOptionsFragment;
import com.tatayab.tatayab.checkout.GiftOptionsFragment_MembersInjector;
import com.tatayab.tatayab.checkout.PaymentFragment;
import com.tatayab.tatayab.checkout.PaymentFragment_MembersInjector;
import com.tatayab.tatayab.checkout.SignInOptionsFragment;
import com.tatayab.tatayab.checkout.SignInOptionsFragment_MembersInjector;
import com.tatayab.tatayab.checkout.UpdateProfileFragment;
import com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory_AssistedFactory;
import com.tatayab.tatayab.contactus.ContactUsFragment;
import com.tatayab.tatayab.contactus.ContactUsFragment_MembersInjector;
import com.tatayab.tatayab.countries.CountriesFragment;
import com.tatayab.tatayab.countries.CountriesFragment_MembersInjector;
import com.tatayab.tatayab.currencies.CurrenciesFragment;
import com.tatayab.tatayab.currencies.CurrenciesFragment_MembersInjector;
import com.tatayab.tatayab.deeplink.DeepLinkActivity;
import com.tatayab.tatayab.deeplink.DeepLinkActivity_MembersInjector;
import com.tatayab.tatayab.errorHandling.ErrorHandlingAct;
import com.tatayab.tatayab.filter.FilterFragment;
import com.tatayab.tatayab.filter.FilterFragment_MembersInjector;
import com.tatayab.tatayab.filter.FilterOptionsFragment;
import com.tatayab.tatayab.filter.SortFragment;
import com.tatayab.tatayab.filter.SortFragment_MembersInjector;
import com.tatayab.tatayab.injection.module.AppSettingsModule;
import com.tatayab.tatayab.injection.module.AppSettingsModule_ProvideAppSettingsFactory;
import com.tatayab.tatayab.injection.module.ApplicationModule;
import com.tatayab.tatayab.injection.module.ApplicationModule_ProvidesContextFactory;
import com.tatayab.tatayab.injection.module.CacheModule;
import com.tatayab.tatayab.injection.module.CacheModule_ProvidesTatayabCacheFactory;
import com.tatayab.tatayab.injection.module.CacheModule_ProvidesTatayabPrefrencesDatabaseFactory;
import com.tatayab.tatayab.injection.module.CacheModule_ProvidesTatayabRoomDatabaseFactory;
import com.tatayab.tatayab.injection.module.RemoteModule;
import com.tatayab.tatayab.injection.module.RemoteModule_BindTatayabRemoteFactory;
import com.tatayab.tatayab.injection.module.RemoteModule_ProvideQraphQlTatayabServiceFactory;
import com.tatayab.tatayab.injection.module.RemoteModule_ProvideTatayabServiceFactory;
import com.tatayab.tatayab.injection.module.RemoteModule_ProvideUserTatayabServiceFactory;
import com.tatayab.tatayab.injection.module.RemoteModule_ProvideWalletTatayabServiceFactory;
import com.tatayab.tatayab.injection.module.UIModule_ContributeAboutUsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeAccountFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeAddAddressFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeAddReviewFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeAddressesFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeBannerSeeMoreFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeBaseActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeBaseFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeBaseFragment2;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCartFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCategoriesFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeChangePasswordFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCheckSignInFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCheckoutReviewPayFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeChooseCityActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeChooseOptionActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeConciergeFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeContactUsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCountriesFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCountryFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeCurrenciesFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeDeepLinkActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeEditProfileFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeFilterFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeFilterOptionsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeForgetPasswordFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeGiftOptionsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeHomeFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeLivechatActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeLivechatFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeLoginActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeLoginFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeLoginOptionActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeMainActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeOrderDetailsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeOrderInvoiceFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeOrderTrackingFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeOrdersFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributePaymentFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributePrivacyFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeProductDetailsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeProductReviewsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeProductsFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeReferCartFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeReferFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeReferFriendSuccessActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeRegisterFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeSearchFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeSharedCartActivity;
import com.tatayab.tatayab.injection.module.UIModule_ContributeSortFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeSplashFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeSuppliersFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeTrackExternalOrderFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeTransactionFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeUpdateProfileFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeWalletFragment;
import com.tatayab.tatayab.injection.module.UIModule_ContributeWishListFragment;
import com.tatayab.tatayab.injection.module.UIModule_ErrorHandlingAct;
import com.tatayab.tatayab.injection.module.UIModule_MRegisterationFragment;
import com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment;
import com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment_MembersInjector;
import com.tatayab.tatayab.livechat.LiveChatActivity;
import com.tatayab.tatayab.livechat.LivechatFragment;
import com.tatayab.tatayab.livechat.LivechatFragment_MembersInjector;
import com.tatayab.tatayab.main.account.AccountFragment;
import com.tatayab.tatayab.main.account.AccountFragment_MembersInjector;
import com.tatayab.tatayab.main.cart.CartFragment;
import com.tatayab.tatayab.main.cart.CartFragment_MembersInjector;
import com.tatayab.tatayab.main.cart.ReferCartFragment;
import com.tatayab.tatayab.main.cart.ReferCartFragment_MembersInjector;
import com.tatayab.tatayab.main.cart.SharedCartActivity;
import com.tatayab.tatayab.main.cart.SharedCartActivity_MembersInjector;
import com.tatayab.tatayab.main.categories.BannerSeeMoreFragment;
import com.tatayab.tatayab.main.categories.CategoriesFragment;
import com.tatayab.tatayab.main.categories.CategoriesFragment_MembersInjector;
import com.tatayab.tatayab.main.concierge.ConciergeFragment;
import com.tatayab.tatayab.main.concierge.ConciergeFragment_MembersInjector;
import com.tatayab.tatayab.main.home.HomeFragment;
import com.tatayab.tatayab.main.home.HomeFragment_MembersInjector;
import com.tatayab.tatayab.orderdetails.OrderDetailsFragment;
import com.tatayab.tatayab.orderdetails.OrderDetailsFragment_MembersInjector;
import com.tatayab.tatayab.orders.OrdersFragment;
import com.tatayab.tatayab.orders.OrdersFragment_MembersInjector;
import com.tatayab.tatayab.ordertracking.OrderTrackingFragment;
import com.tatayab.tatayab.ordertracking.TrackExternalOrderFragment;
import com.tatayab.tatayab.privacy.PrivacyFragment;
import com.tatayab.tatayab.productdetails.ChooseOptionActivity;
import com.tatayab.tatayab.productdetails.ProductDetailsFragment;
import com.tatayab.tatayab.productdetails.ProductDetailsFragment_MembersInjector;
import com.tatayab.tatayab.productlist.ProductListFragment;
import com.tatayab.tatayab.productlist.ProductListFragment_MembersInjector;
import com.tatayab.tatayab.productreviews.ProductReviewsFragment;
import com.tatayab.tatayab.productreviews.ProductReviewsFragment_MembersInjector;
import com.tatayab.tatayab.productreviews.addreview.AddReviewFragment;
import com.tatayab.tatayab.productreviews.addreview.AddReviewFragment_MembersInjector;
import com.tatayab.tatayab.profile.ChangePasswordFragment;
import com.tatayab.tatayab.profile.ChangePasswordFragment_MembersInjector;
import com.tatayab.tatayab.profile.EditProfileFragment;
import com.tatayab.tatayab.profile.EditProfileFragment_MembersInjector;
import com.tatayab.tatayab.refer.ReferFriendFragment;
import com.tatayab.tatayab.refer.ReferFriendFragment_MembersInjector;
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity;
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity_MembersInjector;
import com.tatayab.tatayab.search.SearchFragment;
import com.tatayab.tatayab.search.SearchFragment_MembersInjector;
import com.tatayab.tatayab.splash.CountryFragment;
import com.tatayab.tatayab.splash.CountryFragment_MembersInjector;
import com.tatayab.tatayab.splash.SplashFragment;
import com.tatayab.tatayab.splash.SplashFragment_MembersInjector;
import com.tatayab.tatayab.supplier.SupplierFragment;
import com.tatayab.tatayab.supplier.SupplierFragment_MembersInjector;
import com.tatayab.tatayab.util.SharedPrefAppSettings;
import com.tatayab.tatayab.wallet.TransactionFragment;
import com.tatayab.tatayab.wallet.TransactionFragment_MembersInjector;
import com.tatayab.tatayab.wallet.WalletFragment;
import com.tatayab.tatayab.wallet.WalletFragment_MembersInjector;
import com.tatayab.tatayab.wishlist.WishListFragment;
import com.tatayab.tatayab.wishlist.WishListFragment_MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<UIModule_ContributeBaseActivity.BaseActivitySubcomponent.Builder>
      baseActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeBaseFragment.BaseFragmentSubcomponent.Builder>
      baseFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent.Builder>
      baseFragment2SubcomponentBuilderProvider;

  private Provider<UIModule_ContributeMainActivity.MainActivitySubcomponent.Builder>
      mainActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent.Builder>
      chooseCityActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent.Builder>
      chooseOptionActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent.Builder>
      deepLinkActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent.Builder>
      categoriesFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent.Builder>
      productListFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeLoginActivity.LoginActivitySubcomponent.Builder>
      loginActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent.Builder>
      loginOptionActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeLoginFragment.LoginFragmentSubcomponent.Builder>
      loginFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent.Builder>
      registerFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeSplashFragment.SplashFragmentSubcomponent.Builder>
      splashFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCountryFragment.CountryFragmentSubcomponent.Builder>
      countryFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeHomeFragment.HomeFragmentSubcomponent.Builder>
      homeFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCartFragment.CartFragmentSubcomponent.Builder>
      cartFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeWishListFragment.WishListFragmentSubcomponent.Builder>
      wishListFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeSearchFragment.SearchFragmentSubcomponent.Builder>
      searchFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent.Builder>
      orderTrackingFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent.Builder>
      conciergeFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent.Builder>
      editProfileFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent.Builder>
      forgetPasswordFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeAccountFragment.AccountFragmentSubcomponent.Builder>
      accountFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent.Builder>
      aboutUsFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeWalletFragment.WalletFragmentSubcomponent.Builder>
      walletFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent.Builder>
      bannerSeeMoreFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent.Builder>
      transactionFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent.Builder>
      contactUsFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent.Builder>
      productDetailsFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent.Builder>
      addAddressFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent.Builder>
      addressesFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent.Builder>
      supplierFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent.Builder>
      currenciesFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent.Builder>
      countriesFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent.Builder>
      productReviewsFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent.Builder>
      addReviewFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent.Builder>
      updateProfileFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent.Builder>
      checkoutFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent.Builder>
      signInOptionsFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent.Builder>
      registerationFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent.Builder>
      paymentFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeSortFragment.SortFragmentSubcomponent.Builder>
      sortFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeFilterFragment.FilterFragmentSubcomponent.Builder>
      filterFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent.Builder>
      filterOptionsFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent.Builder>
      privacyFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent.Builder>
      livechatFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent.Builder>
      liveChatActivitySubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeReferFriendSuccessActivity.ReferFriendSuccessActivitySubcomponent
              .Builder>
      referFriendSuccessActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent.Builder>
      sharedCartActivitySubcomponentBuilderProvider;

  private Provider<UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent.Builder>
      errorHandlingActSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent.Builder>
      ordersFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent.Builder>
      orderInvoiceFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent.Builder>
      orderDetailsFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeTrackExternalOrderFragment.TrackExternalOrderFragmentSubcomponent
              .Builder>
      trackExternalOrderFragmentSubcomponentBuilderProvider;

  private Provider<
          UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent.Builder>
      changePasswordFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent.Builder>
      referFriendFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent.Builder>
      referCartFragmentSubcomponentBuilderProvider;

  private Provider<UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent.Builder>
      giftOptionsFragmentSubcomponentBuilderProvider;

  private Provider<Application> applicationProvider;

  private ApplicationModule_ProvidesContextFactory providesContextProvider;

  private Provider<SharedPrefAppSettings> provideAppSettingsProvider;

  private CacheModule_ProvidesTatayabRoomDatabaseFactory providesTatayabRoomDatabaseProvider;

  private CacheModule_ProvidesTatayabPrefrencesDatabaseFactory
      providesTatayabPrefrencesDatabaseProvider;

  private TatayabCacheImpl_Factory tatayabCacheImplProvider;

  private CacheModule_ProvidesTatayabCacheFactory providesTatayabCacheProvider;

  private TatayabCacheDataSource_Factory tatayabCacheDataSourceProvider;

  private RemoteModule_ProvideTatayabServiceFactory provideTatayabServiceProvider;

  private RemoteModule_ProvideWalletTatayabServiceFactory provideWalletTatayabServiceProvider;

  private RemoteModule_ProvideUserTatayabServiceFactory provideUserTatayabServiceProvider;

  private RemoteModule_ProvideQraphQlTatayabServiceFactory provideQraphQlTatayabServiceProvider;

  private TatayabRemoteImpl_Factory tatayabRemoteImplProvider;

  private RemoteModule_BindTatayabRemoteFactory bindTatayabRemoteProvider;

  private TatayabRemoteDataSource_Factory tatayabRemoteDataSourceProvider;

  private TatayabDataSourceFactory_Factory tatayabDataSourceFactoryProvider;

  private Provider<TatayabDataRepository> tatayabDataRepositoryProvider;

  private GetUserProfile_Factory getUserProfileProvider;

  private EditProfile_Factory editProfileProvider;

  private ChangePassword_Factory changePasswordProvider;

  private ProfileFragmentViewModel_Factory profileFragmentViewModelProvider;

  private AddReviewToProduct_Factory addReviewToProductProvider;

  private AddReviewViewModel_Factory addReviewViewModelProvider;

  private Login_Factory loginProvider;

  private Register_Factory registerProvider;

  private ForgetPassword_Factory forgetPasswordProvider;

  private SetFirebaseToken_Factory setFirebaseTokenProvider;

  private SaveFirebaseTokenExecution_Factory saveFirebaseTokenExecutionProvider;

  private UserLoginViewModel_Factory userLoginViewModelProvider;

  private SocialLoginExecute_Factory socialLoginExecuteProvider;

  private UserSocialLoginViewModel_Factory userSocialLoginViewModelProvider;

  private GetWalletExecution_Factory getWalletExecutionProvider;

  private GetTransactionsHistoryExecution_Factory getTransactionsHistoryExecutionProvider;

  private RedeemCodeExecution_Factory redeemCodeExecutionProvider;

  private WalletViewModel_Factory walletViewModelProvider;

  private Logout_Factory logoutProvider;

  private GetCurrentUser_Factory getCurrentUserProvider;

  private GetUserSetting_Factory getUserSettingProvider;

  private LogoutExecution_Factory logoutExecutionProvider;

  private AccountFragmentViewModel_Factory accountFragmentViewModelProvider;

  private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>>
      mapOfClassOfAndProviderOfViewModelProvider;

  private Provider<ViewModelFactory> viewModelFactoryProvider;

  private AddOrderToCart_Factory addOrderToCartProvider;

  private WishListActions_Factory wishListActionsProvider;

  private GetOrdersCountInCartExecute_Factory getOrdersCountInCartExecuteProvider;

  private ClearCachedAndRemoteCart_Factory clearCachedAndRemoteCartProvider;

  private GetGeneratedToken_Factory getGeneratedTokenProvider;

  private ExtractDeepLinkExecution_Factory extractDeepLinkExecutionProvider;

  private GetProductOptions_Factory getProductOptionsProvider;

  private PromotionExecution_Factory promotionExecutionProvider;

  private GetCountries_Factory getCountriesProvider;

  private SaveCountryExecution_Factory saveCountryExecutionProvider;

  private UpdateUserTokenWithLangaugAndCountryExecution_Factory
      updateUserTokenWithLangaugAndCountryExecutionProvider;

  private ProductGiftUserCase_Factory productGiftUserCaseProvider;

  private SaveCurrentLangauge_Factory saveCurrentLangaugeProvider;

  private CreateUserCartExecution_Factory createUserCartExecutionProvider;

  private CreateGuestCartExecution_Factory createGuestCartExecutionProvider;

  private AddItemToCartQueryCartExecution_Factory addItemToCartQueryCartExecutionProvider;

  private RestoreCartExecution_Factory restoreCartExecutionProvider;

  private MergeCartsExecution_Factory mergeCartsExecutionProvider;

  private CountryCurrencyExecution_Factory countryCurrencyExecutionProvider;

  private CheckTokenExecution_Factory checkTokenExecutionProvider;

  private GetCategory_Factory getCategoryProvider;

  private GetSubCategory_Factory getSubCategoryProvider;

  private GetCategoryBanner_Factory getCategoryBannerProvider;

  private GetFilter_Factory getFilterProvider;

  private GetSpecificProducts_Factory getSpecificProductsProvider;

  private GetCities_Factory getCitiesProvider;

  private GetCurrencies_Factory getCurrenciesProvider;

  private GetUpgradeChecker_Factory getUpgradeCheckerProvider;

  private SaveUserSetting_Factory saveUserSettingProvider;

  private GetUserTokenExecution_Factory getUserTokenExecutionProvider;

  private SaveUserAuth_Factory saveUserAuthProvider;

  private AddAddress_Factory addAddressProvider;

  private GetArea_Factory getAreaProvider;

  private GetCustomerAddresses_Factory getCustomerAddressesProvider;

  private DeleteAddress_Factory deleteAddressProvider;

  private GetGuestLastAddress_Factory getGuestLastAddressProvider;

  private SaveGuestAddress_Factory saveGuestAddressProvider;

  private AddShippingAddressToCartExecution_Factory addShippingAddressToCartExecutionProvider;

  private AddBillingAddressToCartExecution_Factory addBillingAddressToCartExecutionProvider;

  private AddGuestEmailToCartExecution_Factory addGuestEmailToCartExecutionProvider;

  private UpdateCartItemAmount_Factory updateCartItemAmountProvider;

  private DeleteOrderFromCart_Factory deleteOrderFromCartProvider;

  private GetCartContent_Factory getCartContentProvider;

  private CashBackExecution_Factory cashBackExecutionProvider;

  private GetUserWishList_Factory getUserWishListProvider;

  private GetProductsWithSearch_Factory getProductsWithSearchProvider;

  private SearchSuggestionListExecution_Factory searchSuggestionListExecutionProvider;

  private SearchRecommanededProductsListExecution_Factory
      searchRecommanededProductsListExecutionProvider;

  private AddConcierge_Factory addConciergeProvider;

  private GetProductDetails_Factory getProductDetailsProvider;

  private GetAlsoBoughtProducts_Factory getAlsoBoughtProductsProvider;

  private GetProductReviews_Factory getProductReviewsProvider;

  private GetAddNotifyMeAction_Factory getAddNotifyMeActionProvider;

  private GetSuppliers_Factory getSuppliersProvider;

  private AddCouponExecution_Factory addCouponExecutionProvider;

  private RemoveCouponExecution_Factory removeCouponExecutionProvider;

  private PaymentMethodExecution_Factory paymentMethodExecutionProvider;

  private CreateOrderExecution_Factory createOrderExecutionProvider;

  private CheckoutReviewExecution_Factory checkoutReviewExecutionProvider;

  private SetShippingMethodExecution_Factory setShippingMethodExecutionProvider;

  private ShippingMethodsExecution_Factory shippingMethodsExecutionProvider;

  private CheckEarnExecution_Factory checkEarnExecutionProvider;

  private InviteFriendExecution_Factory inviteFriendExecutionProvider;

  private GetOrderDetails_Factory getOrderDetailsProvider;

  private GetOrderTracking_Factory getOrderTrackingProvider;

  private DaggerApplicationComponent(Builder builder) {

    initialize(builder);
    initialize2(builder);
  }

  public static ApplicationComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>>
      getMapOfClassOfAndProviderOfFactoryOf() {
    return ImmutableMap.<Class<?>, Provider<AndroidInjector.Factory<?>>>builderWithExpectedSize(59)
        .put(BaseActivity.class, (Provider) baseActivitySubcomponentBuilderProvider)
        .put(BaseFragment.class, (Provider) baseFragmentSubcomponentBuilderProvider)
        .put(BaseFragment2.class, (Provider) baseFragment2SubcomponentBuilderProvider)
        .put(MainActivity.class, (Provider) mainActivitySubcomponentBuilderProvider)
        .put(ChooseCityActivity.class, (Provider) chooseCityActivitySubcomponentBuilderProvider)
        .put(ChooseOptionActivity.class, (Provider) chooseOptionActivitySubcomponentBuilderProvider)
        .put(DeepLinkActivity.class, (Provider) deepLinkActivitySubcomponentBuilderProvider)
        .put(CategoriesFragment.class, (Provider) categoriesFragmentSubcomponentBuilderProvider)
        .put(ProductListFragment.class, (Provider) productListFragmentSubcomponentBuilderProvider)
        .put(LoginActivity.class, (Provider) loginActivitySubcomponentBuilderProvider)
        .put(LoginOptionActivity.class, (Provider) loginOptionActivitySubcomponentBuilderProvider)
        .put(LoginFragment.class, (Provider) loginFragmentSubcomponentBuilderProvider)
        .put(RegisterFragment.class, (Provider) registerFragmentSubcomponentBuilderProvider)
        .put(SplashFragment.class, (Provider) splashFragmentSubcomponentBuilderProvider)
        .put(CountryFragment.class, (Provider) countryFragmentSubcomponentBuilderProvider)
        .put(HomeFragment.class, (Provider) homeFragmentSubcomponentBuilderProvider)
        .put(CartFragment.class, (Provider) cartFragmentSubcomponentBuilderProvider)
        .put(WishListFragment.class, (Provider) wishListFragmentSubcomponentBuilderProvider)
        .put(SearchFragment.class, (Provider) searchFragmentSubcomponentBuilderProvider)
        .put(
            OrderTrackingFragment.class,
            (Provider) orderTrackingFragmentSubcomponentBuilderProvider)
        .put(ConciergeFragment.class, (Provider) conciergeFragmentSubcomponentBuilderProvider)
        .put(EditProfileFragment.class, (Provider) editProfileFragmentSubcomponentBuilderProvider)
        .put(
            ForgetPasswordFragment.class,
            (Provider) forgetPasswordFragmentSubcomponentBuilderProvider)
        .put(AccountFragment.class, (Provider) accountFragmentSubcomponentBuilderProvider)
        .put(AboutUsFragment.class, (Provider) aboutUsFragmentSubcomponentBuilderProvider)
        .put(WalletFragment.class, (Provider) walletFragmentSubcomponentBuilderProvider)
        .put(
            BannerSeeMoreFragment.class,
            (Provider) bannerSeeMoreFragmentSubcomponentBuilderProvider)
        .put(TransactionFragment.class, (Provider) transactionFragmentSubcomponentBuilderProvider)
        .put(ContactUsFragment.class, (Provider) contactUsFragmentSubcomponentBuilderProvider)
        .put(
            ProductDetailsFragment.class,
            (Provider) productDetailsFragmentSubcomponentBuilderProvider)
        .put(AddAddressFragment.class, (Provider) addAddressFragmentSubcomponentBuilderProvider)
        .put(AddressesFragment.class, (Provider) addressesFragmentSubcomponentBuilderProvider)
        .put(SupplierFragment.class, (Provider) supplierFragmentSubcomponentBuilderProvider)
        .put(CurrenciesFragment.class, (Provider) currenciesFragmentSubcomponentBuilderProvider)
        .put(CountriesFragment.class, (Provider) countriesFragmentSubcomponentBuilderProvider)
        .put(
            ProductReviewsFragment.class,
            (Provider) productReviewsFragmentSubcomponentBuilderProvider)
        .put(AddReviewFragment.class, (Provider) addReviewFragmentSubcomponentBuilderProvider)
        .put(
            UpdateProfileFragment.class,
            (Provider) updateProfileFragmentSubcomponentBuilderProvider)
        .put(CheckoutFragment.class, (Provider) checkoutFragmentSubcomponentBuilderProvider)
        .put(
            SignInOptionsFragment.class,
            (Provider) signInOptionsFragmentSubcomponentBuilderProvider)
        .put(
            RegisterationFragment.class,
            (Provider) registerationFragmentSubcomponentBuilderProvider)
        .put(PaymentFragment.class, (Provider) paymentFragmentSubcomponentBuilderProvider)
        .put(SortFragment.class, (Provider) sortFragmentSubcomponentBuilderProvider)
        .put(FilterFragment.class, (Provider) filterFragmentSubcomponentBuilderProvider)
        .put(
            FilterOptionsFragment.class,
            (Provider) filterOptionsFragmentSubcomponentBuilderProvider)
        .put(PrivacyFragment.class, (Provider) privacyFragmentSubcomponentBuilderProvider)
        .put(LivechatFragment.class, (Provider) livechatFragmentSubcomponentBuilderProvider)
        .put(LiveChatActivity.class, (Provider) liveChatActivitySubcomponentBuilderProvider)
        .put(
            ReferFriendSuccessActivity.class,
            (Provider) referFriendSuccessActivitySubcomponentBuilderProvider)
        .put(SharedCartActivity.class, (Provider) sharedCartActivitySubcomponentBuilderProvider)
        .put(ErrorHandlingAct.class, (Provider) errorHandlingActSubcomponentBuilderProvider)
        .put(OrdersFragment.class, (Provider) ordersFragmentSubcomponentBuilderProvider)
        .put(OrderInvoiceFragment.class, (Provider) orderInvoiceFragmentSubcomponentBuilderProvider)
        .put(OrderDetailsFragment.class, (Provider) orderDetailsFragmentSubcomponentBuilderProvider)
        .put(
            TrackExternalOrderFragment.class,
            (Provider) trackExternalOrderFragmentSubcomponentBuilderProvider)
        .put(
            ChangePasswordFragment.class,
            (Provider) changePasswordFragmentSubcomponentBuilderProvider)
        .put(ReferFriendFragment.class, (Provider) referFriendFragmentSubcomponentBuilderProvider)
        .put(ReferCartFragment.class, (Provider) referCartFragmentSubcomponentBuilderProvider)
        .put(GiftOptionsFragment.class, (Provider) giftOptionsFragmentSubcomponentBuilderProvider)
        .build();
  }

  private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        getMapOfClassOfAndProviderOfFactoryOf(),
        ImmutableMap.<String, Provider<AndroidInjector.Factory<?>>>of());
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        getMapOfClassOfAndProviderOfFactoryOf(),
        ImmutableMap.<String, Provider<AndroidInjector.Factory<?>>>of());
  }

  private MainActivityViewModelFactory_AssistedFactory
      getMainActivityViewModelFactory_AssistedFactory() {
    return new MainActivityViewModelFactory_AssistedFactory(
        addOrderToCartProvider,
        wishListActionsProvider,
        getOrdersCountInCartExecuteProvider,
        clearCachedAndRemoteCartProvider,
        (Provider) tatayabDataRepositoryProvider,
        setFirebaseTokenProvider,
        getGeneratedTokenProvider,
        extractDeepLinkExecutionProvider,
        addReviewToProductProvider,
        getProductOptionsProvider,
        promotionExecutionProvider,
        getCountriesProvider,
        saveCountryExecutionProvider,
        updateUserTokenWithLangaugAndCountryExecutionProvider,
        productGiftUserCaseProvider,
        saveCurrentLangaugeProvider,
        createUserCartExecutionProvider,
        createGuestCartExecutionProvider,
        addItemToCartQueryCartExecutionProvider,
        loginProvider,
        restoreCartExecutionProvider,
        mergeCartsExecutionProvider,
        countryCurrencyExecutionProvider,
        getWalletExecutionProvider,
        logoutProvider,
        checkTokenExecutionProvider);
  }

  private CategoryFragmentViewModelFactory_AssistedFactory
      getCategoryFragmentViewModelFactory_AssistedFactory() {
    return new CategoryFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider,
        getCategoryProvider,
        getSubCategoryProvider,
        getCategoryBannerProvider);
  }

  private ProductListFragmentViewModelFactory_AssistedFactory
      getProductListFragmentViewModelFactory_AssistedFactory() {
    return new ProductListFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider, getFilterProvider, getSpecificProductsProvider);
  }

  private SplashFragmentViewModelFactory_AssistedFactory
      getSplashFragmentViewModelFactory_AssistedFactory() {
    return new SplashFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider,
        getUserSettingProvider,
        getCountriesProvider,
        getCitiesProvider,
        getCurrenciesProvider,
        getUpgradeCheckerProvider,
        saveUserSettingProvider,
        getCurrentUserProvider,
        getUserTokenExecutionProvider,
        loginProvider,
        saveUserAuthProvider,
        logoutProvider);
  }

  private AddressFragmentViewModelFactory_AssistedFactory
      getAddressFragmentViewModelFactory_AssistedFactory() {
    return new AddressFragmentViewModelFactory_AssistedFactory(
        addAddressProvider,
        getCitiesProvider,
        getAreaProvider,
        getCustomerAddressesProvider,
        deleteAddressProvider,
        (Provider) tatayabDataRepositoryProvider,
        registerProvider,
        getGuestLastAddressProvider,
        saveGuestAddressProvider,
        addShippingAddressToCartExecutionProvider,
        addBillingAddressToCartExecutionProvider,
        addGuestEmailToCartExecutionProvider);
  }

  private CountriesFragmentViewModelFactory_AssistedFactory
      getCountriesFragmentViewModelFactory_AssistedFactory() {
    return new CountriesFragmentViewModelFactory_AssistedFactory(
        getCountriesProvider,
        getCurrenciesProvider,
        (Provider) tatayabDataRepositoryProvider,
        saveUserSettingProvider,
        getUserSettingProvider,
        mergeCartsExecutionProvider,
        createUserCartExecutionProvider,
        createGuestCartExecutionProvider);
  }

  private HomeFragmentViewModelFactory_AssistedFactory
      getHomeFragmentViewModelFactory_AssistedFactory() {
    return new HomeFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider);
  }

  private CartFragmentViewModelFactory_AssistedFactory
      getCartFragmentViewModelFactory_AssistedFactory() {
    return new CartFragmentViewModelFactory_AssistedFactory(
        updateCartItemAmountProvider,
        deleteOrderFromCartProvider,
        getCartContentProvider,
        getCurrentUserProvider,
        cashBackExecutionProvider,
        addOrderToCartProvider,
        (Provider) tatayabDataRepositoryProvider);
  }

  private WishlistFragmentViewModelFactory_AssistedFactory
      getWishlistFragmentViewModelFactory_AssistedFactory() {
    return new WishlistFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider, wishListActionsProvider, getUserWishListProvider);
  }

  private SearchFragmentViewModelFactory_AssistedFactory
      getSearchFragmentViewModelFactory_AssistedFactory() {
    return new SearchFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider,
        getProductsWithSearchProvider,
        searchSuggestionListExecutionProvider,
        searchRecommanededProductsListExecutionProvider);
  }

  private ConciergeViewModelFactory_AssistedFactory getConciergeViewModelFactory_AssistedFactory() {
    return new ConciergeViewModelFactory_AssistedFactory(
        addConciergeProvider, (Provider) tatayabDataRepositoryProvider);
  }

  private GetUserProfile getGetUserProfile() {
    return new GetUserProfile(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private EditProfile getEditProfile() {
    return new EditProfile(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private ChangePassword getChangePassword() {
    return new ChangePassword(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private ProfileFragmentViewModel getProfileFragmentViewModel() {
    return new ProfileFragmentViewModel(
        getGetUserProfile(),
        getEditProfile(),
        getChangePassword(),
        tatayabDataRepositoryProvider.get());
  }

  private Logout getLogout() {
    return new Logout(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private GetCurrentUser getGetCurrentUser() {
    return new GetCurrentUser(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private GetUserSetting getGetUserSetting() {
    return new GetUserSetting(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private LogoutExecution getLogoutExecution() {
    return new LogoutExecution(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private AccountFragmentViewModel getAccountFragmentViewModel() {
    return new AccountFragmentViewModel(
        getLogout(),
        getGetCurrentUser(),
        getGetUserSetting(),
        getLogoutExecution(),
        tatayabDataRepositoryProvider.get());
  }

  private GetWalletExecution getGetWalletExecution() {
    return new GetWalletExecution(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private GetTransactionsHistoryExecution getGetTransactionsHistoryExecution() {
    return new GetTransactionsHistoryExecution(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private RedeemCodeExecution getRedeemCodeExecution() {
    return new RedeemCodeExecution(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private WalletViewModel getWalletViewModel() {
    return new WalletViewModel(
        getGetWalletExecution(),
        getGetTransactionsHistoryExecution(),
        getRedeemCodeExecution(),
        tatayabDataRepositoryProvider.get());
  }

  private WalletViewModelFactory_AssistedFactory getWalletViewModelFactory_AssistedFactory() {
    return new WalletViewModelFactory_AssistedFactory(
        getWalletExecutionProvider,
        getTransactionsHistoryExecutionProvider,
        redeemCodeExecutionProvider,
        (Provider) tatayabDataRepositoryProvider);
  }

  private ProductDetailsFragmentViewModelFactory_AssistedFactory
      getProductDetailsFragmentViewModelFactory_AssistedFactory() {
    return new ProductDetailsFragmentViewModelFactory_AssistedFactory(
        getProductDetailsProvider,
        getAlsoBoughtProductsProvider,
        getProductReviewsProvider,
        (Provider) tatayabDataRepositoryProvider,
        getAddNotifyMeActionProvider);
  }

  private SuppliersFragmentViewModelFactory_AssistedFactory
      getSuppliersFragmentViewModelFactory_AssistedFactory() {
    return new SuppliersFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider, getSuppliersProvider);
  }

  private CurrenciesFragmentViewModelFactory_AssistedFactory
      getCurrenciesFragmentViewModelFactory_AssistedFactory() {
    return new CurrenciesFragmentViewModelFactory_AssistedFactory(
        getCurrenciesProvider, getUserSettingProvider, saveUserSettingProvider);
  }

  private ProductReviewsViewModelFactory_AssistedFactory
      getProductReviewsViewModelFactory_AssistedFactory() {
    return new ProductReviewsViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider);
  }

  private AddReviewToProduct getAddReviewToProduct() {
    return new AddReviewToProduct(tatayabDataRepositoryProvider.get(), new UIThread());
  }

  private AddReviewViewModel getAddReviewViewModel() {
    return new AddReviewViewModel(getAddReviewToProduct(), tatayabDataRepositoryProvider.get());
  }

  private CheckoutFragmentViewModelFactory_AssistedFactory
      getCheckoutFragmentViewModelFactory_AssistedFactory() {
    return new CheckoutFragmentViewModelFactory_AssistedFactory(
        addCouponExecutionProvider,
        removeCouponExecutionProvider,
        paymentMethodExecutionProvider,
        createOrderExecutionProvider,
        (Provider) tatayabDataRepositoryProvider,
        checkoutReviewExecutionProvider,
        setShippingMethodExecutionProvider,
        shippingMethodsExecutionProvider,
        restoreCartExecutionProvider);
  }

  private UserSocialLoginViewModelFactory_AssistedFactory
      getUserSocialLoginViewModelFactory_AssistedFactory() {
    return new UserSocialLoginViewModelFactory_AssistedFactory(
        socialLoginExecuteProvider,
        saveFirebaseTokenExecutionProvider,
        (Provider) tatayabDataRepositoryProvider);
  }

  private PaymentFragmentViewModelFactory_AssistedFactory
      getPaymentFragmentViewModelFactory_AssistedFactory() {
    return new PaymentFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider, restoreCartExecutionProvider);
  }

  private ReferFriendSuccessViewModelFactory_AssistedFactory
      getReferFriendSuccessViewModelFactory_AssistedFactory() {
    return new ReferFriendSuccessViewModelFactory_AssistedFactory(
        checkEarnExecutionProvider,
        inviteFriendExecutionProvider,
        (Provider) tatayabDataRepositoryProvider);
  }

  private OrdersFragmentViewModelFactory_AssistedFactory
      getOrdersFragmentViewModelFactory_AssistedFactory() {
    return new OrdersFragmentViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider);
  }

  private OrderDetailsFragmentViewModelFactory_AssistedFactory
      getOrderDetailsFragmentViewModelFactory_AssistedFactory() {
    return new OrderDetailsFragmentViewModelFactory_AssistedFactory(
        getOrderDetailsProvider,
        getOrderTrackingProvider,
        (Provider) tatayabDataRepositoryProvider);
  }

  private ReferCartFriendViewModelFactory_AssistedFactory
      getReferCartFriendViewModelFactory_AssistedFactory() {
    return new ReferCartFriendViewModelFactory_AssistedFactory(
        (Provider) tatayabDataRepositoryProvider);
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.baseActivitySubcomponentBuilderProvider =
        new Provider<UIModule_ContributeBaseActivity.BaseActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeBaseActivity.BaseActivitySubcomponent.Builder get() {
            return new BaseActivitySubcomponentBuilder();
          }
        };
    this.baseFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeBaseFragment.BaseFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeBaseFragment.BaseFragmentSubcomponent.Builder get() {
            return new BaseFragmentSubcomponentBuilder();
          }
        };
    this.baseFragment2SubcomponentBuilderProvider =
        new Provider<UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent.Builder>() {
          @Override
          public UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent.Builder get() {
            return new BaseFragment2SubcomponentBuilder();
          }
        };
    this.mainActivitySubcomponentBuilderProvider =
        new Provider<UIModule_ContributeMainActivity.MainActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeMainActivity.MainActivitySubcomponent.Builder get() {
            return new MainActivitySubcomponentBuilder();
          }
        };
    this.chooseCityActivitySubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent.Builder
              get() {
            return new ChooseCityActivitySubcomponentBuilder();
          }
        };
    this.chooseOptionActivitySubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent.Builder
              get() {
            return new ChooseOptionActivitySubcomponentBuilder();
          }
        };
    this.deepLinkActivitySubcomponentBuilderProvider =
        new Provider<UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent.Builder get() {
            return new DeepLinkActivitySubcomponentBuilder();
          }
        };
    this.categoriesFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent.Builder
              get() {
            return new CategoriesFragmentSubcomponentBuilder();
          }
        };
    this.productListFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent.Builder get() {
            return new ProductListFragmentSubcomponentBuilder();
          }
        };
    this.loginActivitySubcomponentBuilderProvider =
        new Provider<UIModule_ContributeLoginActivity.LoginActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeLoginActivity.LoginActivitySubcomponent.Builder get() {
            return new LoginActivitySubcomponentBuilder();
          }
        };
    this.loginOptionActivitySubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent.Builder
              get() {
            return new LoginOptionActivitySubcomponentBuilder();
          }
        };
    this.loginFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeLoginFragment.LoginFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeLoginFragment.LoginFragmentSubcomponent.Builder get() {
            return new LoginFragmentSubcomponentBuilder();
          }
        };
    this.registerFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent.Builder get() {
            return new RegisterFragmentSubcomponentBuilder();
          }
        };
    this.splashFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeSplashFragment.SplashFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeSplashFragment.SplashFragmentSubcomponent.Builder get() {
            return new SplashFragmentSubcomponentBuilder();
          }
        };
    this.countryFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeCountryFragment.CountryFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCountryFragment.CountryFragmentSubcomponent.Builder get() {
            return new CountryFragmentSubcomponentBuilder();
          }
        };
    this.homeFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeHomeFragment.HomeFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeHomeFragment.HomeFragmentSubcomponent.Builder get() {
            return new HomeFragmentSubcomponentBuilder();
          }
        };
    this.cartFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeCartFragment.CartFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCartFragment.CartFragmentSubcomponent.Builder get() {
            return new CartFragmentSubcomponentBuilder();
          }
        };
    this.wishListFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeWishListFragment.WishListFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeWishListFragment.WishListFragmentSubcomponent.Builder get() {
            return new WishListFragmentSubcomponentBuilder();
          }
        };
    this.searchFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeSearchFragment.SearchFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeSearchFragment.SearchFragmentSubcomponent.Builder get() {
            return new SearchFragmentSubcomponentBuilder();
          }
        };
    this.orderTrackingFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent.Builder
              get() {
            return new OrderTrackingFragmentSubcomponentBuilder();
          }
        };
    this.conciergeFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent.Builder get() {
            return new ConciergeFragmentSubcomponentBuilder();
          }
        };
    this.editProfileFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent.Builder
              get() {
            return new EditProfileFragmentSubcomponentBuilder();
          }
        };
    this.forgetPasswordFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent
                  .Builder
              get() {
            return new ForgetPasswordFragmentSubcomponentBuilder();
          }
        };
    this.accountFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeAccountFragment.AccountFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeAccountFragment.AccountFragmentSubcomponent.Builder get() {
            return new AccountFragmentSubcomponentBuilder();
          }
        };
    this.aboutUsFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent.Builder get() {
            return new AboutUsFragmentSubcomponentBuilder();
          }
        };
    this.walletFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeWalletFragment.WalletFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeWalletFragment.WalletFragmentSubcomponent.Builder get() {
            return new WalletFragmentSubcomponentBuilder();
          }
        };
    this.bannerSeeMoreFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent.Builder
              get() {
            return new BannerSeeMoreFragmentSubcomponentBuilder();
          }
        };
    this.transactionFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent.Builder
              get() {
            return new TransactionFragmentSubcomponentBuilder();
          }
        };
    this.contactUsFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent.Builder get() {
            return new ContactUsFragmentSubcomponentBuilder();
          }
        };
    this.productDetailsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent
                  .Builder
              get() {
            return new ProductDetailsFragmentSubcomponentBuilder();
          }
        };
    this.addAddressFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent.Builder
              get() {
            return new AddAddressFragmentSubcomponentBuilder();
          }
        };
    this.addressesFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent.Builder get() {
            return new AddressesFragmentSubcomponentBuilder();
          }
        };
    this.supplierFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent.Builder get() {
            return new SupplierFragmentSubcomponentBuilder();
          }
        };
    this.currenciesFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent.Builder
              get() {
            return new CurrenciesFragmentSubcomponentBuilder();
          }
        };
    this.countriesFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent.Builder get() {
            return new CountriesFragmentSubcomponentBuilder();
          }
        };
    this.productReviewsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent
                  .Builder
              get() {
            return new ProductReviewsFragmentSubcomponentBuilder();
          }
        };
    this.addReviewFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent.Builder get() {
            return new AddReviewFragmentSubcomponentBuilder();
          }
        };
    this.updateProfileFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent.Builder
              get() {
            return new UpdateProfileFragmentSubcomponentBuilder();
          }
        };
    this.checkoutFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent.Builder
              get() {
            return new CheckoutFragmentSubcomponentBuilder();
          }
        };
    this.signInOptionsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent.Builder
              get() {
            return new SignInOptionsFragmentSubcomponentBuilder();
          }
        };
    this.registerationFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent.Builder get() {
            return new RegisterationFragmentSubcomponentBuilder();
          }
        };
    this.paymentFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent.Builder get() {
            return new PaymentFragmentSubcomponentBuilder();
          }
        };
    this.sortFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeSortFragment.SortFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeSortFragment.SortFragmentSubcomponent.Builder get() {
            return new SortFragmentSubcomponentBuilder();
          }
        };
    this.filterFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeFilterFragment.FilterFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeFilterFragment.FilterFragmentSubcomponent.Builder get() {
            return new FilterFragmentSubcomponentBuilder();
          }
        };
    this.filterOptionsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent.Builder
              get() {
            return new FilterOptionsFragmentSubcomponentBuilder();
          }
        };
    this.privacyFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent.Builder get() {
            return new PrivacyFragmentSubcomponentBuilder();
          }
        };
    this.livechatFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent.Builder get() {
            return new LivechatFragmentSubcomponentBuilder();
          }
        };
    this.liveChatActivitySubcomponentBuilderProvider =
        new Provider<UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent.Builder get() {
            return new LiveChatActivitySubcomponentBuilder();
          }
        };
    this.referFriendSuccessActivitySubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeReferFriendSuccessActivity.ReferFriendSuccessActivitySubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeReferFriendSuccessActivity
                  .ReferFriendSuccessActivitySubcomponent.Builder
              get() {
            return new ReferFriendSuccessActivitySubcomponentBuilder();
          }
        };
    this.sharedCartActivitySubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent.Builder>() {
          @Override
          public UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent.Builder
              get() {
            return new SharedCartActivitySubcomponentBuilder();
          }
        };
    this.errorHandlingActSubcomponentBuilderProvider =
        new Provider<UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent.Builder>() {
          @Override
          public UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent.Builder get() {
            return new ErrorHandlingActSubcomponentBuilder();
          }
        };
    this.ordersFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent.Builder get() {
            return new OrdersFragmentSubcomponentBuilder();
          }
        };
    this.orderInvoiceFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent.Builder
              get() {
            return new OrderInvoiceFragmentSubcomponentBuilder();
          }
        };
    this.orderDetailsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent.Builder
              get() {
            return new OrderDetailsFragmentSubcomponentBuilder();
          }
        };
    this.trackExternalOrderFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeTrackExternalOrderFragment.TrackExternalOrderFragmentSubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeTrackExternalOrderFragment
                  .TrackExternalOrderFragmentSubcomponent.Builder
              get() {
            return new TrackExternalOrderFragmentSubcomponentBuilder();
          }
        };
    this.changePasswordFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent
                .Builder>() {
          @Override
          public UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent
                  .Builder
              get() {
            return new ChangePasswordFragmentSubcomponentBuilder();
          }
        };
    this.referFriendFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent.Builder get() {
            return new ReferFriendFragmentSubcomponentBuilder();
          }
        };
    this.referCartFragmentSubcomponentBuilderProvider =
        new Provider<UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent.Builder get() {
            return new ReferCartFragmentSubcomponentBuilder();
          }
        };
    this.giftOptionsFragmentSubcomponentBuilderProvider =
        new Provider<
            UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent.Builder>() {
          @Override
          public UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent.Builder
              get() {
            return new GiftOptionsFragmentSubcomponentBuilder();
          }
        };
    this.applicationProvider = InstanceFactory.create(builder.application);
    this.providesContextProvider =
        ApplicationModule_ProvidesContextFactory.create(
            builder.applicationModule, applicationProvider);
    this.provideAppSettingsProvider =
        DoubleCheck.provider(
            AppSettingsModule_ProvideAppSettingsFactory.create(
                builder.appSettingsModule, providesContextProvider));
    this.providesTatayabRoomDatabaseProvider =
        CacheModule_ProvidesTatayabRoomDatabaseFactory.create(
            builder.cacheModule, providesContextProvider);
    this.providesTatayabPrefrencesDatabaseProvider =
        CacheModule_ProvidesTatayabPrefrencesDatabaseFactory.create(
            builder.cacheModule, providesContextProvider);
    this.tatayabCacheImplProvider =
        TatayabCacheImpl_Factory.create(
            providesTatayabRoomDatabaseProvider,
            providesTatayabPrefrencesDatabaseProvider,
            CachedAddressMapper_Factory.create(),
            CachedUserMapper_Factory.create(),
            CachedWishItemMapper_Factory.create());
    this.providesTatayabCacheProvider =
        CacheModule_ProvidesTatayabCacheFactory.create(
            builder.cacheModule, tatayabCacheImplProvider);
    this.tatayabCacheDataSourceProvider =
        TatayabCacheDataSource_Factory.create(providesTatayabCacheProvider);
    this.provideTatayabServiceProvider =
        RemoteModule_ProvideTatayabServiceFactory.create(
            builder.remoteModule, providesContextProvider, tatayabCacheDataSourceProvider);
    this.provideWalletTatayabServiceProvider =
        RemoteModule_ProvideWalletTatayabServiceFactory.create(
            builder.remoteModule, providesContextProvider, tatayabCacheDataSourceProvider);
    this.provideUserTatayabServiceProvider =
        RemoteModule_ProvideUserTatayabServiceFactory.create(
            builder.remoteModule, providesContextProvider, tatayabCacheDataSourceProvider);
    this.provideQraphQlTatayabServiceProvider =
        RemoteModule_ProvideQraphQlTatayabServiceFactory.create(
            builder.remoteModule, providesContextProvider, tatayabCacheDataSourceProvider);
    this.tatayabRemoteImplProvider =
        TatayabRemoteImpl_Factory.create(
            provideTatayabServiceProvider,
            provideWalletTatayabServiceProvider,
            provideUserTatayabServiceProvider,
            provideQraphQlTatayabServiceProvider);
    this.bindTatayabRemoteProvider =
        RemoteModule_BindTatayabRemoteFactory.create(
            builder.remoteModule, tatayabRemoteImplProvider);
    this.tatayabRemoteDataSourceProvider =
        TatayabRemoteDataSource_Factory.create(bindTatayabRemoteProvider);
    this.tatayabDataSourceFactoryProvider =
        TatayabDataSourceFactory_Factory.create(
            tatayabCacheDataSourceProvider, tatayabRemoteDataSourceProvider);
    this.tatayabDataRepositoryProvider =
        DoubleCheck.provider(
            TatayabDataRepository_Factory.create(
                providesTatayabCacheProvider, tatayabDataSourceFactoryProvider));
    this.getUserProfileProvider =
        GetUserProfile_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.editProfileProvider =
        EditProfile_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.changePasswordProvider =
        ChangePassword_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.profileFragmentViewModelProvider =
        ProfileFragmentViewModel_Factory.create(
            getUserProfileProvider,
            editProfileProvider,
            changePasswordProvider,
            (Provider) tatayabDataRepositoryProvider);
    this.addReviewToProductProvider =
        AddReviewToProduct_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addReviewViewModelProvider =
        AddReviewViewModel_Factory.create(
            addReviewToProductProvider, (Provider) tatayabDataRepositoryProvider);
    this.loginProvider =
        Login_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.registerProvider =
        Register_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.forgetPasswordProvider =
        ForgetPassword_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.setFirebaseTokenProvider =
        SetFirebaseToken_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveFirebaseTokenExecutionProvider =
        SaveFirebaseTokenExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.userLoginViewModelProvider =
        UserLoginViewModel_Factory.create(
            loginProvider,
            registerProvider,
            forgetPasswordProvider,
            setFirebaseTokenProvider,
            saveFirebaseTokenExecutionProvider,
            (Provider) tatayabDataRepositoryProvider);
    this.socialLoginExecuteProvider =
        SocialLoginExecute_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.userSocialLoginViewModelProvider =
        UserSocialLoginViewModel_Factory.create(
            socialLoginExecuteProvider,
            saveFirebaseTokenExecutionProvider,
            (Provider) tatayabDataRepositoryProvider);
    this.getWalletExecutionProvider =
        GetWalletExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getTransactionsHistoryExecutionProvider =
        GetTransactionsHistoryExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.redeemCodeExecutionProvider =
        RedeemCodeExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.walletViewModelProvider =
        WalletViewModel_Factory.create(
            getWalletExecutionProvider,
            getTransactionsHistoryExecutionProvider,
            redeemCodeExecutionProvider,
            (Provider) tatayabDataRepositoryProvider);
    this.logoutProvider =
        Logout_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCurrentUserProvider =
        GetCurrentUser_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getUserSettingProvider =
        GetUserSetting_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.logoutExecutionProvider =
        LogoutExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.accountFragmentViewModelProvider =
        AccountFragmentViewModel_Factory.create(
            logoutProvider,
            getCurrentUserProvider,
            getUserSettingProvider,
            logoutExecutionProvider,
            (Provider) tatayabDataRepositoryProvider);
    this.mapOfClassOfAndProviderOfViewModelProvider =
        MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(6)
            .put(ProfileFragmentViewModel.class, (Provider) profileFragmentViewModelProvider)
            .put(AddReviewViewModel.class, (Provider) addReviewViewModelProvider)
            .put(UserLoginViewModel.class, (Provider) userLoginViewModelProvider)
            .put(UserSocialLoginViewModel.class, (Provider) userSocialLoginViewModelProvider)
            .put(WalletViewModel.class, (Provider) walletViewModelProvider)
            .put(AccountFragmentViewModel.class, (Provider) accountFragmentViewModelProvider)
            .build();
  }

  @SuppressWarnings("unchecked")
  private void initialize2(final Builder builder) {
    this.viewModelFactoryProvider =
        DoubleCheck.provider(
            ViewModelFactory_Factory.create(mapOfClassOfAndProviderOfViewModelProvider));
    this.addOrderToCartProvider =
        AddOrderToCart_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.wishListActionsProvider =
        WishListActions_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getOrdersCountInCartExecuteProvider =
        GetOrdersCountInCartExecute_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.clearCachedAndRemoteCartProvider =
        ClearCachedAndRemoteCart_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getGeneratedTokenProvider =
        GetGeneratedToken_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.extractDeepLinkExecutionProvider =
        ExtractDeepLinkExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getProductOptionsProvider =
        GetProductOptions_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.promotionExecutionProvider =
        PromotionExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCountriesProvider =
        GetCountries_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveCountryExecutionProvider =
        SaveCountryExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.updateUserTokenWithLangaugAndCountryExecutionProvider =
        UpdateUserTokenWithLangaugAndCountryExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.productGiftUserCaseProvider =
        ProductGiftUserCase_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveCurrentLangaugeProvider =
        SaveCurrentLangauge_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.createUserCartExecutionProvider =
        CreateUserCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.createGuestCartExecutionProvider =
        CreateGuestCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addItemToCartQueryCartExecutionProvider =
        AddItemToCartQueryCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.restoreCartExecutionProvider =
        RestoreCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.mergeCartsExecutionProvider =
        MergeCartsExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.countryCurrencyExecutionProvider =
        CountryCurrencyExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.checkTokenExecutionProvider =
        CheckTokenExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCategoryProvider =
        GetCategory_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getSubCategoryProvider =
        GetSubCategory_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCategoryBannerProvider =
        GetCategoryBanner_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getFilterProvider =
        GetFilter_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getSpecificProductsProvider =
        GetSpecificProducts_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCitiesProvider =
        GetCities_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCurrenciesProvider =
        GetCurrencies_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getUpgradeCheckerProvider =
        GetUpgradeChecker_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveUserSettingProvider =
        SaveUserSetting_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getUserTokenExecutionProvider =
        GetUserTokenExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveUserAuthProvider =
        SaveUserAuth_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addAddressProvider =
        AddAddress_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getAreaProvider =
        GetArea_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCustomerAddressesProvider =
        GetCustomerAddresses_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.deleteAddressProvider =
        DeleteAddress_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getGuestLastAddressProvider =
        GetGuestLastAddress_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.saveGuestAddressProvider =
        SaveGuestAddress_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addShippingAddressToCartExecutionProvider =
        AddShippingAddressToCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addBillingAddressToCartExecutionProvider =
        AddBillingAddressToCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addGuestEmailToCartExecutionProvider =
        AddGuestEmailToCartExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.updateCartItemAmountProvider =
        UpdateCartItemAmount_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.deleteOrderFromCartProvider =
        DeleteOrderFromCart_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getCartContentProvider =
        GetCartContent_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.cashBackExecutionProvider =
        CashBackExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getUserWishListProvider =
        GetUserWishList_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getProductsWithSearchProvider =
        GetProductsWithSearch_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.searchSuggestionListExecutionProvider =
        SearchSuggestionListExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.searchRecommanededProductsListExecutionProvider =
        SearchRecommanededProductsListExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addConciergeProvider =
        AddConcierge_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getProductDetailsProvider =
        GetProductDetails_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getAlsoBoughtProductsProvider =
        GetAlsoBoughtProducts_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getProductReviewsProvider =
        GetProductReviews_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getAddNotifyMeActionProvider =
        GetAddNotifyMeAction_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getSuppliersProvider =
        GetSuppliers_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.addCouponExecutionProvider =
        AddCouponExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.removeCouponExecutionProvider =
        RemoveCouponExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.paymentMethodExecutionProvider =
        PaymentMethodExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.createOrderExecutionProvider =
        CreateOrderExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.checkoutReviewExecutionProvider =
        CheckoutReviewExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.setShippingMethodExecutionProvider =
        SetShippingMethodExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.shippingMethodsExecutionProvider =
        ShippingMethodsExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.checkEarnExecutionProvider =
        CheckEarnExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.inviteFriendExecutionProvider =
        InviteFriendExecution_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getOrderDetailsProvider =
        GetOrderDetails_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
    this.getOrderTrackingProvider =
        GetOrderTracking_Factory.create(
            (Provider) tatayabDataRepositoryProvider, (Provider) UIThread_Factory.create());
  }

  @Override
  public void inject(App app) {
    injectApp(app);
  }

  @Override
  public SharedPrefAppSettings getSharedPrefAppSettings() {
    return provideAppSettingsProvider.get();
  }

  @CanIgnoreReturnValue
  private App injectApp(App instance) {
    App_MembersInjector.injectAndroidFragmentInjector(
        instance, getDispatchingAndroidInjectorOfFragment());
    App_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfActivity());
    App_MembersInjector.injectAppSettings(instance, provideAppSettingsProvider.get());
    return instance;
  }

  private static final class Builder implements ApplicationComponent.Builder {
    private AppSettingsModule appSettingsModule;

    private ApplicationModule applicationModule;

    private CacheModule cacheModule;

    private RemoteModule remoteModule;

    private Application application;

    @Override
    public ApplicationComponent build() {
      if (appSettingsModule == null) {
        this.appSettingsModule = new AppSettingsModule();
      }
      if (applicationModule == null) {
        this.applicationModule = new ApplicationModule();
      }
      if (cacheModule == null) {
        this.cacheModule = new CacheModule();
      }
      if (remoteModule == null) {
        this.remoteModule = new RemoteModule();
      }
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerApplicationComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class BaseActivitySubcomponentBuilder
      extends UIModule_ContributeBaseActivity.BaseActivitySubcomponent.Builder {
    private BaseActivity seedInstance;

    @Override
    public UIModule_ContributeBaseActivity.BaseActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, BaseActivity.class);
      return new BaseActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(BaseActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class BaseActivitySubcomponentImpl
      implements UIModule_ContributeBaseActivity.BaseActivitySubcomponent {
    private BaseActivitySubcomponentImpl(BaseActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(BaseActivity arg0) {
      injectBaseActivity(arg0);
    }

    @CanIgnoreReturnValue
    private BaseActivity injectBaseActivity(BaseActivity instance) {
      BaseActivity_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class BaseFragmentSubcomponentBuilder
      extends UIModule_ContributeBaseFragment.BaseFragmentSubcomponent.Builder {
    private BaseFragment seedInstance;

    @Override
    public UIModule_ContributeBaseFragment.BaseFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, BaseFragment.class);
      return new BaseFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(BaseFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class BaseFragmentSubcomponentImpl
      implements UIModule_ContributeBaseFragment.BaseFragmentSubcomponent {
    private BaseFragmentSubcomponentImpl(BaseFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(BaseFragment arg0) {
      injectBaseFragment(arg0);
    }

    @CanIgnoreReturnValue
    private BaseFragment injectBaseFragment(BaseFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class BaseFragment2SubcomponentBuilder
      extends UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent.Builder {
    private BaseFragment2 seedInstance;

    @Override
    public UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, BaseFragment2.class);
      return new BaseFragment2SubcomponentImpl(this);
    }

    @Override
    public void seedInstance(BaseFragment2 arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class BaseFragment2SubcomponentImpl
      implements UIModule_ContributeBaseFragment2.BaseFragment2Subcomponent {
    private BaseFragment2SubcomponentImpl(BaseFragment2SubcomponentBuilder builder) {}

    @Override
    public void inject(BaseFragment2 arg0) {
      injectBaseFragment2(arg0);
    }

    @CanIgnoreReturnValue
    private BaseFragment2 injectBaseFragment2(BaseFragment2 instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class MainActivitySubcomponentBuilder
      extends UIModule_ContributeMainActivity.MainActivitySubcomponent.Builder {
    private MainActivity seedInstance;

    @Override
    public UIModule_ContributeMainActivity.MainActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, MainActivity.class);
      return new MainActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(MainActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl
      implements UIModule_ContributeMainActivity.MainActivitySubcomponent {
    private MainActivitySubcomponentImpl(MainActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity(MainActivity instance) {
      MainActivity_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ChooseCityActivitySubcomponentBuilder
      extends UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent.Builder {
    private ChooseCityActivity seedInstance;

    @Override
    public UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ChooseCityActivity.class);
      return new ChooseCityActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ChooseCityActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ChooseCityActivitySubcomponentImpl
      implements UIModule_ContributeChooseCityActivity.ChooseCityActivitySubcomponent {
    private ChooseCityActivitySubcomponentImpl(ChooseCityActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(ChooseCityActivity arg0) {
      injectChooseCityActivity(arg0);
    }

    @CanIgnoreReturnValue
    private ChooseCityActivity injectChooseCityActivity(ChooseCityActivity instance) {
      BaseActivity_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class ChooseOptionActivitySubcomponentBuilder
      extends UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent.Builder {
    private ChooseOptionActivity seedInstance;

    @Override
    public UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ChooseOptionActivity.class);
      return new ChooseOptionActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ChooseOptionActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ChooseOptionActivitySubcomponentImpl
      implements UIModule_ContributeChooseOptionActivity.ChooseOptionActivitySubcomponent {
    private ChooseOptionActivitySubcomponentImpl(ChooseOptionActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(ChooseOptionActivity arg0) {
      injectChooseOptionActivity(arg0);
    }

    @CanIgnoreReturnValue
    private ChooseOptionActivity injectChooseOptionActivity(ChooseOptionActivity instance) {
      BaseActivity_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class DeepLinkActivitySubcomponentBuilder
      extends UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent.Builder {
    private DeepLinkActivity seedInstance;

    @Override
    public UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, DeepLinkActivity.class);
      return new DeepLinkActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(DeepLinkActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class DeepLinkActivitySubcomponentImpl
      implements UIModule_ContributeDeepLinkActivity.DeepLinkActivitySubcomponent {
    private DeepLinkActivitySubcomponentImpl(DeepLinkActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(DeepLinkActivity arg0) {
      injectDeepLinkActivity(arg0);
    }

    @CanIgnoreReturnValue
    private DeepLinkActivity injectDeepLinkActivity(DeepLinkActivity instance) {
      DeepLinkActivity_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class CategoriesFragmentSubcomponentBuilder
      extends UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent.Builder {
    private CategoriesFragment seedInstance;

    @Override
    public UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CategoriesFragment.class);
      return new CategoriesFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CategoriesFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CategoriesFragmentSubcomponentImpl
      implements UIModule_ContributeCategoriesFragment.CategoriesFragmentSubcomponent {
    private CategoriesFragmentSubcomponentImpl(CategoriesFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CategoriesFragment arg0) {
      injectCategoriesFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CategoriesFragment injectCategoriesFragment(CategoriesFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CategoriesFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getCategoryFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ProductListFragmentSubcomponentBuilder
      extends UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent.Builder {
    private ProductListFragment seedInstance;

    @Override
    public UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ProductListFragment.class);
      return new ProductListFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ProductListFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ProductListFragmentSubcomponentImpl
      implements UIModule_ContributeProductsFragment.ProductListFragmentSubcomponent {
    private ProductListFragmentSubcomponentImpl(ProductListFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ProductListFragment arg0) {
      injectProductListFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ProductListFragment injectProductListFragment(ProductListFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ProductListFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      ProductListFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getProductListFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class LoginActivitySubcomponentBuilder
      extends UIModule_ContributeLoginActivity.LoginActivitySubcomponent.Builder {
    private LoginActivity seedInstance;

    @Override
    public UIModule_ContributeLoginActivity.LoginActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, LoginActivity.class);
      return new LoginActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(LoginActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class LoginActivitySubcomponentImpl
      implements UIModule_ContributeLoginActivity.LoginActivitySubcomponent {
    private LoginActivitySubcomponentImpl(LoginActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(LoginActivity arg0) {}
  }

  private final class LoginOptionActivitySubcomponentBuilder
      extends UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent.Builder {
    private LoginOptionActivity seedInstance;

    @Override
    public UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, LoginOptionActivity.class);
      return new LoginOptionActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(LoginOptionActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class LoginOptionActivitySubcomponentImpl
      implements UIModule_ContributeLoginOptionActivity.LoginOptionActivitySubcomponent {
    private LoginOptionActivitySubcomponentImpl(LoginOptionActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(LoginOptionActivity arg0) {
      injectLoginOptionActivity(arg0);
    }

    @CanIgnoreReturnValue
    private LoginOptionActivity injectLoginOptionActivity(LoginOptionActivity instance) {
      MainActivity_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class LoginFragmentSubcomponentBuilder
      extends UIModule_ContributeLoginFragment.LoginFragmentSubcomponent.Builder {
    private LoginFragment seedInstance;

    @Override
    public UIModule_ContributeLoginFragment.LoginFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, LoginFragment.class);
      return new LoginFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(LoginFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class LoginFragmentSubcomponentImpl
      implements UIModule_ContributeLoginFragment.LoginFragmentSubcomponent {
    private LoginFragmentSubcomponentImpl(LoginFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(LoginFragment arg0) {
      injectLoginFragment(arg0);
    }

    @CanIgnoreReturnValue
    private LoginFragment injectLoginFragment(LoginFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      LoginFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class RegisterFragmentSubcomponentBuilder
      extends UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent.Builder {
    private RegisterFragment seedInstance;

    @Override
    public UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, RegisterFragment.class);
      return new RegisterFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(RegisterFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class RegisterFragmentSubcomponentImpl
      implements UIModule_ContributeRegisterFragment.RegisterFragmentSubcomponent {
    private RegisterFragmentSubcomponentImpl(RegisterFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(RegisterFragment arg0) {
      injectRegisterFragment(arg0);
    }

    @CanIgnoreReturnValue
    private RegisterFragment injectRegisterFragment(RegisterFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      RegisterFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SplashFragmentSubcomponentBuilder
      extends UIModule_ContributeSplashFragment.SplashFragmentSubcomponent.Builder {
    private SplashFragment seedInstance;

    @Override
    public UIModule_ContributeSplashFragment.SplashFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SplashFragment.class);
      return new SplashFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SplashFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SplashFragmentSubcomponentImpl
      implements UIModule_ContributeSplashFragment.SplashFragmentSubcomponent {
    private SplashFragmentSubcomponentImpl(SplashFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(SplashFragment arg0) {
      injectSplashFragment(arg0);
    }

    @CanIgnoreReturnValue
    private SplashFragment injectSplashFragment(SplashFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      SplashFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      SplashFragment_MembersInjector.injectViewModelFactorySplash(
          instance,
          DaggerApplicationComponent.this.getSplashFragmentViewModelFactory_AssistedFactory());
      SplashFragment_MembersInjector.injectViewModelFactoryAddress(
          instance,
          DaggerApplicationComponent.this.getAddressFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class CountryFragmentSubcomponentBuilder
      extends UIModule_ContributeCountryFragment.CountryFragmentSubcomponent.Builder {
    private CountryFragment seedInstance;

    @Override
    public UIModule_ContributeCountryFragment.CountryFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CountryFragment.class);
      return new CountryFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CountryFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CountryFragmentSubcomponentImpl
      implements UIModule_ContributeCountryFragment.CountryFragmentSubcomponent {
    private CountryFragmentSubcomponentImpl(CountryFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CountryFragment arg0) {
      injectCountryFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CountryFragment injectCountryFragment(CountryFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CountryFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      CountryFragment_MembersInjector.injectViewModelFactoryCountries(
          instance,
          DaggerApplicationComponent.this.getCountriesFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class HomeFragmentSubcomponentBuilder
      extends UIModule_ContributeHomeFragment.HomeFragmentSubcomponent.Builder {
    private HomeFragment seedInstance;

    @Override
    public UIModule_ContributeHomeFragment.HomeFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, HomeFragment.class);
      return new HomeFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(HomeFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class HomeFragmentSubcomponentImpl
      implements UIModule_ContributeHomeFragment.HomeFragmentSubcomponent {
    private HomeFragmentSubcomponentImpl(HomeFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(HomeFragment arg0) {
      injectHomeFragment(arg0);
    }

    @CanIgnoreReturnValue
    private HomeFragment injectHomeFragment(HomeFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      HomeFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getHomeFragmentViewModelFactory_AssistedFactory());
      HomeFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class CartFragmentSubcomponentBuilder
      extends UIModule_ContributeCartFragment.CartFragmentSubcomponent.Builder {
    private CartFragment seedInstance;

    @Override
    public UIModule_ContributeCartFragment.CartFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CartFragment.class);
      return new CartFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CartFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CartFragmentSubcomponentImpl
      implements UIModule_ContributeCartFragment.CartFragmentSubcomponent {
    private CartFragmentSubcomponentImpl(CartFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CartFragment arg0) {
      injectCartFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CartFragment injectCartFragment(CartFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CartFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getCartFragmentViewModelFactory_AssistedFactory());
      CartFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class WishListFragmentSubcomponentBuilder
      extends UIModule_ContributeWishListFragment.WishListFragmentSubcomponent.Builder {
    private WishListFragment seedInstance;

    @Override
    public UIModule_ContributeWishListFragment.WishListFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, WishListFragment.class);
      return new WishListFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(WishListFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class WishListFragmentSubcomponentImpl
      implements UIModule_ContributeWishListFragment.WishListFragmentSubcomponent {
    private WishListFragmentSubcomponentImpl(WishListFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(WishListFragment arg0) {
      injectWishListFragment(arg0);
    }

    @CanIgnoreReturnValue
    private WishListFragment injectWishListFragment(WishListFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      WishListFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getWishlistFragmentViewModelFactory_AssistedFactory());
      WishListFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SearchFragmentSubcomponentBuilder
      extends UIModule_ContributeSearchFragment.SearchFragmentSubcomponent.Builder {
    private SearchFragment seedInstance;

    @Override
    public UIModule_ContributeSearchFragment.SearchFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SearchFragment.class);
      return new SearchFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SearchFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SearchFragmentSubcomponentImpl
      implements UIModule_ContributeSearchFragment.SearchFragmentSubcomponent {
    private SearchFragmentSubcomponentImpl(SearchFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(SearchFragment arg0) {
      injectSearchFragment(arg0);
    }

    @CanIgnoreReturnValue
    private SearchFragment injectSearchFragment(SearchFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      SearchFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      SearchFragment_MembersInjector.injectSearchviewModelFactory(
          instance,
          DaggerApplicationComponent.this.getSearchFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class OrderTrackingFragmentSubcomponentBuilder
      extends UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent.Builder {
    private OrderTrackingFragment seedInstance;

    @Override
    public UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, OrderTrackingFragment.class);
      return new OrderTrackingFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(OrderTrackingFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class OrderTrackingFragmentSubcomponentImpl
      implements UIModule_ContributeOrderTrackingFragment.OrderTrackingFragmentSubcomponent {
    private OrderTrackingFragmentSubcomponentImpl(
        OrderTrackingFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(OrderTrackingFragment arg0) {
      injectOrderTrackingFragment(arg0);
    }

    @CanIgnoreReturnValue
    private OrderTrackingFragment injectOrderTrackingFragment(OrderTrackingFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class ConciergeFragmentSubcomponentBuilder
      extends UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent.Builder {
    private ConciergeFragment seedInstance;

    @Override
    public UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ConciergeFragment.class);
      return new ConciergeFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ConciergeFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ConciergeFragmentSubcomponentImpl
      implements UIModule_ContributeConciergeFragment.ConciergeFragmentSubcomponent {
    private ConciergeFragmentSubcomponentImpl(ConciergeFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ConciergeFragment arg0) {
      injectConciergeFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ConciergeFragment injectConciergeFragment(ConciergeFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ConciergeFragment_MembersInjector.injectMConciergeViewModelFactory(
          instance, DaggerApplicationComponent.this.getConciergeViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class EditProfileFragmentSubcomponentBuilder
      extends UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent.Builder {
    private EditProfileFragment seedInstance;

    @Override
    public UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, EditProfileFragment.class);
      return new EditProfileFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(EditProfileFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class EditProfileFragmentSubcomponentImpl
      implements UIModule_ContributeEditProfileFragment.EditProfileFragmentSubcomponent {
    private EditProfileFragmentSubcomponentImpl(EditProfileFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(EditProfileFragment arg0) {
      injectEditProfileFragment(arg0);
    }

    @CanIgnoreReturnValue
    private EditProfileFragment injectEditProfileFragment(EditProfileFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      EditProfileFragment_MembersInjector.injectViewModel(
          instance, DaggerApplicationComponent.this.getProfileFragmentViewModel());
      return instance;
    }
  }

  private final class ForgetPasswordFragmentSubcomponentBuilder
      extends UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent.Builder {
    private ForgetPasswordFragment seedInstance;

    @Override
    public UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ForgetPasswordFragment.class);
      return new ForgetPasswordFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ForgetPasswordFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ForgetPasswordFragmentSubcomponentImpl
      implements UIModule_ContributeForgetPasswordFragment.ForgetPasswordFragmentSubcomponent {
    private ForgetPasswordFragmentSubcomponentImpl(
        ForgetPasswordFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ForgetPasswordFragment arg0) {
      injectForgetPasswordFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ForgetPasswordFragment injectForgetPasswordFragment(ForgetPasswordFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class AccountFragmentSubcomponentBuilder
      extends UIModule_ContributeAccountFragment.AccountFragmentSubcomponent.Builder {
    private AccountFragment seedInstance;

    @Override
    public UIModule_ContributeAccountFragment.AccountFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, AccountFragment.class);
      return new AccountFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(AccountFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class AccountFragmentSubcomponentImpl
      implements UIModule_ContributeAccountFragment.AccountFragmentSubcomponent {
    private AccountFragmentSubcomponentImpl(AccountFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(AccountFragment arg0) {
      injectAccountFragment(arg0);
    }

    @CanIgnoreReturnValue
    private AccountFragment injectAccountFragment(AccountFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      AccountFragment_MembersInjector.injectViewModel(
          instance, DaggerApplicationComponent.this.getAccountFragmentViewModel());
      AccountFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class AboutUsFragmentSubcomponentBuilder
      extends UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent.Builder {
    private AboutUsFragment seedInstance;

    @Override
    public UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, AboutUsFragment.class);
      return new AboutUsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(AboutUsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class AboutUsFragmentSubcomponentImpl
      implements UIModule_ContributeAboutUsFragment.AboutUsFragmentSubcomponent {
    private AboutUsFragmentSubcomponentImpl(AboutUsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(AboutUsFragment arg0) {
      injectAboutUsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private AboutUsFragment injectAboutUsFragment(AboutUsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      AboutUsFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class WalletFragmentSubcomponentBuilder
      extends UIModule_ContributeWalletFragment.WalletFragmentSubcomponent.Builder {
    private WalletFragment seedInstance;

    @Override
    public UIModule_ContributeWalletFragment.WalletFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, WalletFragment.class);
      return new WalletFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(WalletFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class WalletFragmentSubcomponentImpl
      implements UIModule_ContributeWalletFragment.WalletFragmentSubcomponent {
    private WalletFragmentSubcomponentImpl(WalletFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(WalletFragment arg0) {
      injectWalletFragment(arg0);
    }

    @CanIgnoreReturnValue
    private WalletFragment injectWalletFragment(WalletFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      WalletFragment_MembersInjector.injectViewModel(
          instance, DaggerApplicationComponent.this.getWalletViewModel());
      return instance;
    }
  }

  private final class BannerSeeMoreFragmentSubcomponentBuilder
      extends UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent.Builder {
    private BannerSeeMoreFragment seedInstance;

    @Override
    public UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, BannerSeeMoreFragment.class);
      return new BannerSeeMoreFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(BannerSeeMoreFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class BannerSeeMoreFragmentSubcomponentImpl
      implements UIModule_ContributeBannerSeeMoreFragment.BannerSeeMoreFragmentSubcomponent {
    private BannerSeeMoreFragmentSubcomponentImpl(
        BannerSeeMoreFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(BannerSeeMoreFragment arg0) {
      injectBannerSeeMoreFragment(arg0);
    }

    @CanIgnoreReturnValue
    private BannerSeeMoreFragment injectBannerSeeMoreFragment(BannerSeeMoreFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class TransactionFragmentSubcomponentBuilder
      extends UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent.Builder {
    private TransactionFragment seedInstance;

    @Override
    public UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, TransactionFragment.class);
      return new TransactionFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(TransactionFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class TransactionFragmentSubcomponentImpl
      implements UIModule_ContributeTransactionFragment.TransactionFragmentSubcomponent {
    private TransactionFragmentSubcomponentImpl(TransactionFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(TransactionFragment arg0) {
      injectTransactionFragment(arg0);
    }

    @CanIgnoreReturnValue
    private TransactionFragment injectTransactionFragment(TransactionFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      TransactionFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.getWalletViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ContactUsFragmentSubcomponentBuilder
      extends UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent.Builder {
    private ContactUsFragment seedInstance;

    @Override
    public UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ContactUsFragment.class);
      return new ContactUsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ContactUsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ContactUsFragmentSubcomponentImpl
      implements UIModule_ContributeContactUsFragment.ContactUsFragmentSubcomponent {
    private ContactUsFragmentSubcomponentImpl(ContactUsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ContactUsFragment arg0) {
      injectContactUsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ContactUsFragment injectContactUsFragment(ContactUsFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ContactUsFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ProductDetailsFragmentSubcomponentBuilder
      extends UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent.Builder {
    private ProductDetailsFragment seedInstance;

    @Override
    public UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ProductDetailsFragment.class);
      return new ProductDetailsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ProductDetailsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ProductDetailsFragmentSubcomponentImpl
      implements UIModule_ContributeProductDetailsFragment.ProductDetailsFragmentSubcomponent {
    private ProductDetailsFragmentSubcomponentImpl(
        ProductDetailsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ProductDetailsFragment arg0) {
      injectProductDetailsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ProductDetailsFragment injectProductDetailsFragment(ProductDetailsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ProductDetailsFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this
              .getProductDetailsFragmentViewModelFactory_AssistedFactory());
      ProductDetailsFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class AddAddressFragmentSubcomponentBuilder
      extends UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent.Builder {
    private AddAddressFragment seedInstance;

    @Override
    public UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, AddAddressFragment.class);
      return new AddAddressFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(AddAddressFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class AddAddressFragmentSubcomponentImpl
      implements UIModule_ContributeAddAddressFragment.AddAddressFragmentSubcomponent {
    private AddAddressFragmentSubcomponentImpl(AddAddressFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(AddAddressFragment arg0) {
      injectAddAddressFragment(arg0);
    }

    @CanIgnoreReturnValue
    private AddAddressFragment injectAddAddressFragment(AddAddressFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      AddAddressFragment_MembersInjector.injectViewModelFactoryAddress(
          instance,
          DaggerApplicationComponent.this.getAddressFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class AddressesFragmentSubcomponentBuilder
      extends UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent.Builder {
    private AddressesFragment seedInstance;

    @Override
    public UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, AddressesFragment.class);
      return new AddressesFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(AddressesFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class AddressesFragmentSubcomponentImpl
      implements UIModule_ContributeAddressesFragment.AddressesFragmentSubcomponent {
    private AddressesFragmentSubcomponentImpl(AddressesFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(AddressesFragment arg0) {
      injectAddressesFragment(arg0);
    }

    @CanIgnoreReturnValue
    private AddressesFragment injectAddressesFragment(AddressesFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      AddressesFragment_MembersInjector.injectViewModelFactoryaddress(
          instance,
          DaggerApplicationComponent.this.getAddressFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SupplierFragmentSubcomponentBuilder
      extends UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent.Builder {
    private SupplierFragment seedInstance;

    @Override
    public UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SupplierFragment.class);
      return new SupplierFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SupplierFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SupplierFragmentSubcomponentImpl
      implements UIModule_ContributeSuppliersFragment.SupplierFragmentSubcomponent {
    private SupplierFragmentSubcomponentImpl(SupplierFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(SupplierFragment arg0) {
      injectSupplierFragment(arg0);
    }

    @CanIgnoreReturnValue
    private SupplierFragment injectSupplierFragment(SupplierFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      SupplierFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getSuppliersFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class CurrenciesFragmentSubcomponentBuilder
      extends UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent.Builder {
    private CurrenciesFragment seedInstance;

    @Override
    public UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CurrenciesFragment.class);
      return new CurrenciesFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CurrenciesFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CurrenciesFragmentSubcomponentImpl
      implements UIModule_ContributeCurrenciesFragment.CurrenciesFragmentSubcomponent {
    private CurrenciesFragmentSubcomponentImpl(CurrenciesFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CurrenciesFragment arg0) {
      injectCurrenciesFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CurrenciesFragment injectCurrenciesFragment(CurrenciesFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CurrenciesFragment_MembersInjector.injectViewModelFactoryCountries(
          instance,
          DaggerApplicationComponent.this.getCurrenciesFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class CountriesFragmentSubcomponentBuilder
      extends UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent.Builder {
    private CountriesFragment seedInstance;

    @Override
    public UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CountriesFragment.class);
      return new CountriesFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CountriesFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CountriesFragmentSubcomponentImpl
      implements UIModule_ContributeCountriesFragment.CountriesFragmentSubcomponent {
    private CountriesFragmentSubcomponentImpl(CountriesFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CountriesFragment arg0) {
      injectCountriesFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CountriesFragment injectCountriesFragment(CountriesFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CountriesFragment_MembersInjector.injectViewModelFactoryCountries(
          instance,
          DaggerApplicationComponent.this.getCountriesFragmentViewModelFactory_AssistedFactory());
      CountriesFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ProductReviewsFragmentSubcomponentBuilder
      extends UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent.Builder {
    private ProductReviewsFragment seedInstance;

    @Override
    public UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ProductReviewsFragment.class);
      return new ProductReviewsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ProductReviewsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ProductReviewsFragmentSubcomponentImpl
      implements UIModule_ContributeProductReviewsFragment.ProductReviewsFragmentSubcomponent {
    private ProductReviewsFragmentSubcomponentImpl(
        ProductReviewsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ProductReviewsFragment arg0) {
      injectProductReviewsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ProductReviewsFragment injectProductReviewsFragment(ProductReviewsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ProductReviewsFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      ProductReviewsFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getProductReviewsViewModelFactory_AssistedFactory());
      ProductReviewsFragment_MembersInjector.injectDetailsViewModelFactory(
          instance,
          DaggerApplicationComponent.this
              .getProductDetailsFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class AddReviewFragmentSubcomponentBuilder
      extends UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent.Builder {
    private AddReviewFragment seedInstance;

    @Override
    public UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, AddReviewFragment.class);
      return new AddReviewFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(AddReviewFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class AddReviewFragmentSubcomponentImpl
      implements UIModule_ContributeAddReviewFragment.AddReviewFragmentSubcomponent {
    private AddReviewFragmentSubcomponentImpl(AddReviewFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(AddReviewFragment arg0) {
      injectAddReviewFragment(arg0);
    }

    @CanIgnoreReturnValue
    private AddReviewFragment injectAddReviewFragment(AddReviewFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      AddReviewFragment_MembersInjector.injectMViewModel(
          instance, DaggerApplicationComponent.this.getAddReviewViewModel());
      return instance;
    }
  }

  private final class UpdateProfileFragmentSubcomponentBuilder
      extends UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent.Builder {
    private UpdateProfileFragment seedInstance;

    @Override
    public UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, UpdateProfileFragment.class);
      return new UpdateProfileFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(UpdateProfileFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class UpdateProfileFragmentSubcomponentImpl
      implements UIModule_ContributeUpdateProfileFragment.UpdateProfileFragmentSubcomponent {
    private UpdateProfileFragmentSubcomponentImpl(
        UpdateProfileFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(UpdateProfileFragment arg0) {
      injectUpdateProfileFragment(arg0);
    }

    @CanIgnoreReturnValue
    private UpdateProfileFragment injectUpdateProfileFragment(UpdateProfileFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class CheckoutFragmentSubcomponentBuilder
      extends UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent.Builder {
    private CheckoutFragment seedInstance;

    @Override
    public UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, CheckoutFragment.class);
      return new CheckoutFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(CheckoutFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class CheckoutFragmentSubcomponentImpl
      implements UIModule_ContributeCheckoutReviewPayFragment.CheckoutFragmentSubcomponent {
    private CheckoutFragmentSubcomponentImpl(CheckoutFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(CheckoutFragment arg0) {
      injectCheckoutFragment(arg0);
    }

    @CanIgnoreReturnValue
    private CheckoutFragment injectCheckoutFragment(CheckoutFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      CheckoutFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      CheckoutFragment_MembersInjector.injectViewModelFactoryCheckout(
          instance,
          DaggerApplicationComponent.this.getCheckoutFragmentViewModelFactory_AssistedFactory());
      CheckoutFragment_MembersInjector.injectViewModelFactoryAddress(
          instance,
          DaggerApplicationComponent.this.getAddressFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SignInOptionsFragmentSubcomponentBuilder
      extends UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent.Builder {
    private SignInOptionsFragment seedInstance;

    @Override
    public UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SignInOptionsFragment.class);
      return new SignInOptionsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SignInOptionsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SignInOptionsFragmentSubcomponentImpl
      implements UIModule_ContributeCheckSignInFragment.SignInOptionsFragmentSubcomponent {
    private SignInOptionsFragmentSubcomponentImpl(
        SignInOptionsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(SignInOptionsFragment arg0) {
      injectSignInOptionsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private SignInOptionsFragment injectSignInOptionsFragment(SignInOptionsFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      SignInOptionsFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      SignInOptionsFragment_MembersInjector.injectUserSocialLoginViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getUserSocialLoginViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class RegisterationFragmentSubcomponentBuilder
      extends UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent.Builder {
    private RegisterationFragment seedInstance;

    @Override
    public UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, RegisterationFragment.class);
      return new RegisterationFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(RegisterationFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class RegisterationFragmentSubcomponentImpl
      implements UIModule_MRegisterationFragment.RegisterationFragmentSubcomponent {
    private RegisterationFragmentSubcomponentImpl(
        RegisterationFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(RegisterationFragment arg0) {
      injectRegisterationFragment(arg0);
    }

    @CanIgnoreReturnValue
    private RegisterationFragment injectRegisterationFragment(RegisterationFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class PaymentFragmentSubcomponentBuilder
      extends UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent.Builder {
    private PaymentFragment seedInstance;

    @Override
    public UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, PaymentFragment.class);
      return new PaymentFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(PaymentFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class PaymentFragmentSubcomponentImpl
      implements UIModule_ContributePaymentFragment.PaymentFragmentSubcomponent {
    private PaymentFragmentSubcomponentImpl(PaymentFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(PaymentFragment arg0) {
      injectPaymentFragment(arg0);
    }

    @CanIgnoreReturnValue
    private PaymentFragment injectPaymentFragment(PaymentFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      PaymentFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      PaymentFragment_MembersInjector.injectPaymentFragmentViewModelFactor(
          instance,
          DaggerApplicationComponent.this.getPaymentFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SortFragmentSubcomponentBuilder
      extends UIModule_ContributeSortFragment.SortFragmentSubcomponent.Builder {
    private SortFragment seedInstance;

    @Override
    public UIModule_ContributeSortFragment.SortFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SortFragment.class);
      return new SortFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SortFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SortFragmentSubcomponentImpl
      implements UIModule_ContributeSortFragment.SortFragmentSubcomponent {
    private SortFragmentSubcomponentImpl(SortFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(SortFragment arg0) {
      injectSortFragment(arg0);
    }

    @CanIgnoreReturnValue
    private SortFragment injectSortFragment(SortFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      SortFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getProductListFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class FilterFragmentSubcomponentBuilder
      extends UIModule_ContributeFilterFragment.FilterFragmentSubcomponent.Builder {
    private FilterFragment seedInstance;

    @Override
    public UIModule_ContributeFilterFragment.FilterFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, FilterFragment.class);
      return new FilterFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(FilterFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class FilterFragmentSubcomponentImpl
      implements UIModule_ContributeFilterFragment.FilterFragmentSubcomponent {
    private FilterFragmentSubcomponentImpl(FilterFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(FilterFragment arg0) {
      injectFilterFragment(arg0);
    }

    @CanIgnoreReturnValue
    private FilterFragment injectFilterFragment(FilterFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      FilterFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getProductListFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class FilterOptionsFragmentSubcomponentBuilder
      extends UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent.Builder {
    private FilterOptionsFragment seedInstance;

    @Override
    public UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, FilterOptionsFragment.class);
      return new FilterOptionsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(FilterOptionsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class FilterOptionsFragmentSubcomponentImpl
      implements UIModule_ContributeFilterOptionsFragment.FilterOptionsFragmentSubcomponent {
    private FilterOptionsFragmentSubcomponentImpl(
        FilterOptionsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(FilterOptionsFragment arg0) {
      injectFilterOptionsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private FilterOptionsFragment injectFilterOptionsFragment(FilterOptionsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class PrivacyFragmentSubcomponentBuilder
      extends UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent.Builder {
    private PrivacyFragment seedInstance;

    @Override
    public UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, PrivacyFragment.class);
      return new PrivacyFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(PrivacyFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class PrivacyFragmentSubcomponentImpl
      implements UIModule_ContributePrivacyFragment.PrivacyFragmentSubcomponent {
    private PrivacyFragmentSubcomponentImpl(PrivacyFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(PrivacyFragment arg0) {
      injectPrivacyFragment(arg0);
    }

    @CanIgnoreReturnValue
    private PrivacyFragment injectPrivacyFragment(PrivacyFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class LivechatFragmentSubcomponentBuilder
      extends UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent.Builder {
    private LivechatFragment seedInstance;

    @Override
    public UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, LivechatFragment.class);
      return new LivechatFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(LivechatFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class LivechatFragmentSubcomponentImpl
      implements UIModule_ContributeLivechatFragment.LivechatFragmentSubcomponent {
    private LivechatFragmentSubcomponentImpl(LivechatFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(LivechatFragment arg0) {
      injectLivechatFragment(arg0);
    }

    @CanIgnoreReturnValue
    private LivechatFragment injectLivechatFragment(LivechatFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      LivechatFragment_MembersInjector.injectViewModel(
          instance, DaggerApplicationComponent.this.getProfileFragmentViewModel());
      return instance;
    }
  }

  private final class LiveChatActivitySubcomponentBuilder
      extends UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent.Builder {
    private LiveChatActivity seedInstance;

    @Override
    public UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, LiveChatActivity.class);
      return new LiveChatActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(LiveChatActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class LiveChatActivitySubcomponentImpl
      implements UIModule_ContributeLivechatActivity.LiveChatActivitySubcomponent {
    private LiveChatActivitySubcomponentImpl(LiveChatActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(LiveChatActivity arg0) {
      injectLiveChatActivity(arg0);
    }

    @CanIgnoreReturnValue
    private LiveChatActivity injectLiveChatActivity(LiveChatActivity instance) {
      BaseActivity_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class ReferFriendSuccessActivitySubcomponentBuilder
      extends UIModule_ContributeReferFriendSuccessActivity.ReferFriendSuccessActivitySubcomponent
          .Builder {
    private ReferFriendSuccessActivity seedInstance;

    @Override
    public UIModule_ContributeReferFriendSuccessActivity.ReferFriendSuccessActivitySubcomponent
        build() {
      Preconditions.checkBuilderRequirement(seedInstance, ReferFriendSuccessActivity.class);
      return new ReferFriendSuccessActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ReferFriendSuccessActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ReferFriendSuccessActivitySubcomponentImpl
      implements UIModule_ContributeReferFriendSuccessActivity
          .ReferFriendSuccessActivitySubcomponent {
    private ReferFriendSuccessActivitySubcomponentImpl(
        ReferFriendSuccessActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(ReferFriendSuccessActivity arg0) {
      injectReferFriendSuccessActivity(arg0);
    }

    @CanIgnoreReturnValue
    private ReferFriendSuccessActivity injectReferFriendSuccessActivity(
        ReferFriendSuccessActivity instance) {
      ReferFriendSuccessActivity_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getReferFriendSuccessViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class SharedCartActivitySubcomponentBuilder
      extends UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent.Builder {
    private SharedCartActivity seedInstance;

    @Override
    public UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, SharedCartActivity.class);
      return new SharedCartActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(SharedCartActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class SharedCartActivitySubcomponentImpl
      implements UIModule_ContributeSharedCartActivity.SharedCartActivitySubcomponent {
    private SharedCartActivitySubcomponentImpl(SharedCartActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(SharedCartActivity arg0) {
      injectSharedCartActivity(arg0);
    }

    @CanIgnoreReturnValue
    private SharedCartActivity injectSharedCartActivity(SharedCartActivity instance) {
      SharedCartActivity_MembersInjector.injectCartViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getCartFragmentViewModelFactory_AssistedFactory());
      SharedCartActivity_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ErrorHandlingActSubcomponentBuilder
      extends UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent.Builder {
    private ErrorHandlingAct seedInstance;

    @Override
    public UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ErrorHandlingAct.class);
      return new ErrorHandlingActSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ErrorHandlingAct arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ErrorHandlingActSubcomponentImpl
      implements UIModule_ErrorHandlingAct.ErrorHandlingActSubcomponent {
    private ErrorHandlingActSubcomponentImpl(ErrorHandlingActSubcomponentBuilder builder) {}

    @Override
    public void inject(ErrorHandlingAct arg0) {}
  }

  private final class OrdersFragmentSubcomponentBuilder
      extends UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent.Builder {
    private OrdersFragment seedInstance;

    @Override
    public UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, OrdersFragment.class);
      return new OrdersFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(OrdersFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class OrdersFragmentSubcomponentImpl
      implements UIModule_ContributeOrdersFragment.OrdersFragmentSubcomponent {
    private OrdersFragmentSubcomponentImpl(OrdersFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(OrdersFragment arg0) {
      injectOrdersFragment(arg0);
    }

    @CanIgnoreReturnValue
    private OrdersFragment injectOrdersFragment(OrdersFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      OrdersFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getOrdersFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class OrderInvoiceFragmentSubcomponentBuilder
      extends UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent.Builder {
    private OrderInvoiceFragment seedInstance;

    @Override
    public UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, OrderInvoiceFragment.class);
      return new OrderInvoiceFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(OrderInvoiceFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class OrderInvoiceFragmentSubcomponentImpl
      implements UIModule_ContributeOrderInvoiceFragment.OrderInvoiceFragmentSubcomponent {
    private OrderInvoiceFragmentSubcomponentImpl(OrderInvoiceFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(OrderInvoiceFragment arg0) {
      injectOrderInvoiceFragment(arg0);
    }

    @CanIgnoreReturnValue
    private OrderInvoiceFragment injectOrderInvoiceFragment(OrderInvoiceFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      OrderInvoiceFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class OrderDetailsFragmentSubcomponentBuilder
      extends UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent.Builder {
    private OrderDetailsFragment seedInstance;

    @Override
    public UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, OrderDetailsFragment.class);
      return new OrderDetailsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(OrderDetailsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class OrderDetailsFragmentSubcomponentImpl
      implements UIModule_ContributeOrderDetailsFragment.OrderDetailsFragmentSubcomponent {
    private OrderDetailsFragmentSubcomponentImpl(OrderDetailsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(OrderDetailsFragment arg0) {
      injectOrderDetailsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private OrderDetailsFragment injectOrderDetailsFragment(OrderDetailsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      OrderDetailsFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this
              .getOrderDetailsFragmentViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class TrackExternalOrderFragmentSubcomponentBuilder
      extends UIModule_ContributeTrackExternalOrderFragment.TrackExternalOrderFragmentSubcomponent
          .Builder {
    private TrackExternalOrderFragment seedInstance;

    @Override
    public UIModule_ContributeTrackExternalOrderFragment.TrackExternalOrderFragmentSubcomponent
        build() {
      Preconditions.checkBuilderRequirement(seedInstance, TrackExternalOrderFragment.class);
      return new TrackExternalOrderFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(TrackExternalOrderFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class TrackExternalOrderFragmentSubcomponentImpl
      implements UIModule_ContributeTrackExternalOrderFragment
          .TrackExternalOrderFragmentSubcomponent {
    private TrackExternalOrderFragmentSubcomponentImpl(
        TrackExternalOrderFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(TrackExternalOrderFragment arg0) {
      injectTrackExternalOrderFragment(arg0);
    }

    @CanIgnoreReturnValue
    private TrackExternalOrderFragment injectTrackExternalOrderFragment(
        TrackExternalOrderFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class ChangePasswordFragmentSubcomponentBuilder
      extends UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent.Builder {
    private ChangePasswordFragment seedInstance;

    @Override
    public UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ChangePasswordFragment.class);
      return new ChangePasswordFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ChangePasswordFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ChangePasswordFragmentSubcomponentImpl
      implements UIModule_ContributeChangePasswordFragment.ChangePasswordFragmentSubcomponent {
    private ChangePasswordFragmentSubcomponentImpl(
        ChangePasswordFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ChangePasswordFragment arg0) {
      injectChangePasswordFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ChangePasswordFragment injectChangePasswordFragment(ChangePasswordFragment instance) {
      BaseFragment_MembersInjector.injectViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ChangePasswordFragment_MembersInjector.injectViewModel(
          instance, DaggerApplicationComponent.this.getProfileFragmentViewModel());
      return instance;
    }
  }

  private final class ReferFriendFragmentSubcomponentBuilder
      extends UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent.Builder {
    private ReferFriendFragment seedInstance;

    @Override
    public UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ReferFriendFragment.class);
      return new ReferFriendFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ReferFriendFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ReferFriendFragmentSubcomponentImpl
      implements UIModule_ContributeReferFragment.ReferFriendFragmentSubcomponent {
    private ReferFriendFragmentSubcomponentImpl(ReferFriendFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ReferFriendFragment arg0) {
      injectReferFriendFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ReferFriendFragment injectReferFriendFragment(ReferFriendFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ReferFriendFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getReferFriendSuccessViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class ReferCartFragmentSubcomponentBuilder
      extends UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent.Builder {
    private ReferCartFragment seedInstance;

    @Override
    public UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, ReferCartFragment.class);
      return new ReferCartFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(ReferCartFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class ReferCartFragmentSubcomponentImpl
      implements UIModule_ContributeReferCartFragment.ReferCartFragmentSubcomponent {
    private ReferCartFragmentSubcomponentImpl(ReferCartFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(ReferCartFragment arg0) {
      injectReferCartFragment(arg0);
    }

    @CanIgnoreReturnValue
    private ReferCartFragment injectReferCartFragment(ReferCartFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      ReferCartFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getReferCartFriendViewModelFactory_AssistedFactory());
      return instance;
    }
  }

  private final class GiftOptionsFragmentSubcomponentBuilder
      extends UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent.Builder {
    private GiftOptionsFragment seedInstance;

    @Override
    public UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, GiftOptionsFragment.class);
      return new GiftOptionsFragmentSubcomponentImpl(this);
    }

    @Override
    public void seedInstance(GiftOptionsFragment arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class GiftOptionsFragmentSubcomponentImpl
      implements UIModule_ContributeGiftOptionsFragment.GiftOptionsFragmentSubcomponent {
    private GiftOptionsFragmentSubcomponentImpl(GiftOptionsFragmentSubcomponentBuilder builder) {}

    @Override
    public void inject(GiftOptionsFragment arg0) {
      injectGiftOptionsFragment(arg0);
    }

    @CanIgnoreReturnValue
    private GiftOptionsFragment injectGiftOptionsFragment(GiftOptionsFragment instance) {
      BaseFragment2_MembersInjector.injectBaseViewModelFactory(
          instance, DaggerApplicationComponent.this.viewModelFactoryProvider.get());
      GiftOptionsFragment_MembersInjector.injectViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getCartFragmentViewModelFactory_AssistedFactory());
      GiftOptionsFragment_MembersInjector.injectMainViewModelFactory(
          instance,
          DaggerApplicationComponent.this.getMainActivityViewModelFactory_AssistedFactory());
      return instance;
    }
  }
}
