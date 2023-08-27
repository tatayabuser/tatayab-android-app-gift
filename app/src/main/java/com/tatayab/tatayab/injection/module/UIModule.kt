@file:Suppress("unused")

package com.tatayab.tatayab.injection.module


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.tatayab.deeplink.DeepLinkActivity
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.splash.SplashFragment
import com.tatayab.tatayab.UIThread
import com.tatayab.tatayab.aboutus.AboutUsFragment
import com.tatayab.tatayab.addresses.AddAddressFragment
import com.tatayab.tatayab.addresses.AddressesFragment
import com.tatayab.tatayab.addresses.ChooseCityActivity
import com.tatayab.tatayab.productreviews.addreview.AddReviewFragment
import com.tatayab.tatayab.auth.*
import com.tatayab.tatayab.base.BaseActivity
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.auth.LoginActivity
import com.tatayab.tatayab.auth.LoginFragment
import com.tatayab.tatayab.auth.RegisterFragment
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.checkout.*
import com.tatayab.tatayab.contactus.ContactUsFragment
import com.tatayab.tatayab.countries.CountriesFragment
import com.tatayab.tatayab.currencies.CurrenciesFragment
import com.tatayab.tatayab.errorHandling.ErrorHandlingAct
import com.tatayab.tatayab.main.account.AccountFragment
import com.tatayab.tatayab.main.cart.CartFragment
import com.tatayab.tatayab.filter.FilterFragment
import com.tatayab.tatayab.filter.FilterOptionsFragment
import com.tatayab.tatayab.filter.SortFragment
import com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment
import com.tatayab.tatayab.livechat.LiveChatActivity
import com.tatayab.tatayab.livechat.LivechatFragment
import com.tatayab.tatayab.main.cart.ReferCartFragment
import com.tatayab.tatayab.main.cart.SharedCartActivity
import com.tatayab.tatayab.main.categories.BannerSeeMoreFragment
import com.tatayab.tatayab.wallet.WalletFragment
import com.tatayab.tatayab.main.categories.CategoriesFragment
import com.tatayab.tatayab.main.concierge.ConciergeFragment
import com.tatayab.tatayab.profile.EditProfileFragment
import com.tatayab.tatayab.main.home.HomeFragment
import com.tatayab.tatayab.orderdetails.OrderDetailsFragment
import com.tatayab.tatayab.orders.OrdersFragment
import com.tatayab.tatayab.ordertracking.OrderTrackingFragment
import com.tatayab.tatayab.ordertracking.TrackExternalOrderFragment
import com.tatayab.tatayab.productdetails.ProductDetailsFragment
import com.tatayab.tatayab.productlist.ProductListFragment
import com.tatayab.tatayab.productreviews.ProductReviewsFragment
import com.tatayab.tatayab.search.SearchFragment
import com.tatayab.tatayab.privacy.PrivacyFragment
import com.tatayab.tatayab.productdetails.ChooseOptionActivity
import com.tatayab.tatayab.profile.ChangePasswordFragment
import com.tatayab.tatayab.refer.ReferFriendFragment
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import com.tatayab.tatayab.splash.CountryFragment
import com.tatayab.tatayab.supplier.SupplierFragment
import com.tatayab.tatayab.wallet.TransactionFragment
import com.tatayab.tatayab.wishlist.WishListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UIModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun contributeBaseFragment2(): BaseFragment2

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeChooseCityActivity(): ChooseCityActivity

    @ContributesAndroidInjector
    abstract fun contributeChooseOptionActivity(): ChooseOptionActivity


    @ContributesAndroidInjector
    abstract fun contributeDeepLinkActivity(): DeepLinkActivity

    @ContributesAndroidInjector
    abstract fun contributeCategoriesFragment(): CategoriesFragment


    @ContributesAndroidInjector
    abstract fun contributeProductsFragment(): ProductListFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginOptionActivity(): LoginOptionActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment


    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeCountryFragment(): CountryFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment


    @ContributesAndroidInjector
    abstract fun contributeCartFragment(): CartFragment

    @ContributesAndroidInjector
    abstract fun contributeWishListFragment(): WishListFragment


    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeOrderTrackingFragment(): OrderTrackingFragment

    @ContributesAndroidInjector
    abstract fun contributeConciergeFragment(): ConciergeFragment


    @ContributesAndroidInjector
    abstract fun contributeEditProfileFragment(): EditProfileFragment


    @ContributesAndroidInjector
    abstract fun contributeForgetPasswordFragment(): ForgetPasswordFragment

    @ContributesAndroidInjector
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    abstract fun contributeAboutUsFragment(): AboutUsFragment

    @ContributesAndroidInjector
    abstract fun contributeWalletFragment(): WalletFragment

    @ContributesAndroidInjector
    abstract fun contributeBannerSeeMoreFragment(): BannerSeeMoreFragment

    @ContributesAndroidInjector
    abstract fun contributeTransactionFragment(): TransactionFragment

    @ContributesAndroidInjector
    abstract fun contributeContactUsFragment(): ContactUsFragment


    @ContributesAndroidInjector
    abstract fun contributeProductDetailsFragment(): ProductDetailsFragment


    @ContributesAndroidInjector
    abstract fun contributeAddAddressFragment(): AddAddressFragment


    @ContributesAndroidInjector
    abstract fun contributeAddressesFragment(): AddressesFragment


    @ContributesAndroidInjector
    abstract fun contributeSuppliersFragment(): SupplierFragment


    @ContributesAndroidInjector
    abstract fun contributeCurrenciesFragment(): CurrenciesFragment


    @ContributesAndroidInjector
    abstract fun contributeCountriesFragment(): CountriesFragment


    @ContributesAndroidInjector
    abstract fun contributeProductReviewsFragment(): ProductReviewsFragment

    @ContributesAndroidInjector
    abstract fun contributeAddReviewFragment(): AddReviewFragment


    @ContributesAndroidInjector
    abstract fun contributeUpdateProfileFragment(): UpdateProfileFragment


    @ContributesAndroidInjector
    abstract fun contributeCheckoutReviewPayFragment(): CheckoutFragment

    @ContributesAndroidInjector
    abstract fun contributeCheckSignInFragment(): SignInOptionsFragment

    @ContributesAndroidInjector
    abstract fun mRegisterationFragment(): RegisterationFragment

    @ContributesAndroidInjector
    abstract fun contributePaymentFragment(): PaymentFragment

    @ContributesAndroidInjector
    abstract fun contributeSortFragment(): SortFragment

    @ContributesAndroidInjector
    abstract fun contributeFilterFragment(): FilterFragment

    @ContributesAndroidInjector
    abstract fun contributeFilterOptionsFragment(): FilterOptionsFragment


    @ContributesAndroidInjector
    abstract fun contributePrivacyFragment(): PrivacyFragment

    @ContributesAndroidInjector
    abstract fun contributeLivechatFragment(): LivechatFragment

    @ContributesAndroidInjector
    abstract fun contributeLivechatActivity(): LiveChatActivity

    @ContributesAndroidInjector
    abstract fun contributeReferFriendSuccessActivity(): ReferFriendSuccessActivity

    @ContributesAndroidInjector
    abstract fun contributeSharedCartActivity(): SharedCartActivity

    @ContributesAndroidInjector
    abstract fun ErrorHandlingAct(): ErrorHandlingAct


    @ContributesAndroidInjector
    abstract fun contributeOrdersFragment(): OrdersFragment

    @ContributesAndroidInjector
    abstract fun contributeOrderInvoiceFragment(): OrderInvoiceFragment

    @ContributesAndroidInjector
    abstract fun contributeOrderDetailsFragment(): OrderDetailsFragment


    @ContributesAndroidInjector
    abstract fun contributeTrackExternalOrderFragment(): TrackExternalOrderFragment

    @ContributesAndroidInjector
    abstract fun contributeChangePasswordFragment(): ChangePasswordFragment

    @ContributesAndroidInjector
    abstract fun contributeReferFragment(): ReferFriendFragment

    @ContributesAndroidInjector
    abstract fun contributeReferCartFragment(): ReferCartFragment

    @ContributesAndroidInjector
    abstract fun contributeGiftOptionsFragment(): GiftOptionsFragment
}
