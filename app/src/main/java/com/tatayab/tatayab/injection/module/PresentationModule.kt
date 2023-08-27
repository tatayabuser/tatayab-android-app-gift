package com.tatayab.tatayab.injection.module



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tatayab.presentation.account.AccountFragmentViewModel
import com.tatayab.presentation.addconcierge.ConciergeViewModelFactory
import com.tatayab.presentation.addconcierge.ConciergeViewModelFactory_AssistedFactory
import com.tatayab.presentation.address.AddressFragmentViewModelFactory
import com.tatayab.presentation.address.AddressFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.addreview.AddReviewViewModel
import com.tatayab.presentation.auth.UserLoginViewModel
import com.tatayab.presentation.auth.UserSocialLoginViewModel
import com.tatayab.presentation.auth.UserSocialLoginViewModelFactory
import com.tatayab.presentation.auth.UserSocialLoginViewModelFactory_AssistedFactory
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory
import com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory
import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory
import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.main.MainActivityViewModelFactory_AssistedFactory
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory
import com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory_AssistedFactory
import com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory
import com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.main.home.HomeFragmentViewModelFactory
import com.tatayab.presentation.main.home.HomeFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.orders.OrdersFragmentViewModelFactory
import com.tatayab.presentation.orders.OrdersFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.product.*
import com.tatayab.presentation.profile.ProfileFragmentViewModel
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory_AssistedFactory
import com.tatayab.presentation.splash.SplashFragmentViewModelFactory
import com.tatayab.presentation.splash.SplashFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory
import com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory_AssistedFactory
import com.tatayab.presentation.wallet.WalletViewModel
import com.tatayab.presentation.wallet.WalletViewModelFactory
import com.tatayab.presentation.wallet.WalletViewModelFactory_AssistedFactory
import com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory
import com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory_AssistedFactory
import com.tatayab.tatayab.injection.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Module
abstract class PresentationModule {


    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    abstract fun bindProfileFragmentViewModel(viewModel: ProfileFragmentViewModel): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(AddReviewViewModel::class)
    abstract fun bindAddReviewViewModel(viewModel: AddReviewViewModel): ViewModel


    @Binds
    abstract fun bindSearchFragmentFactory(factory: SearchFragmentViewModelFactory_AssistedFactory): SearchFragmentViewModelFactory.Factory


    @Binds
    @IntoMap
    @ViewModelKey(UserLoginViewModel::class)
    abstract fun bindUserLoginViewModel(viewModel: UserLoginViewModel): ViewModel


//
//    @Binds
//    @IntoMap
//    @ViewModelKey(AddressFragmentViewModel::class)
//    abstract fun bindAddressFragmentViewModel(viewModel: AddressFragmentViewModel): ViewModel
//


    @Binds
    abstract fun bindBaseViewModel(viewModel: BaseViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserSocialLoginViewModel::class)
    abstract fun bindUserSocialLoginViewModel(viewModel: UserSocialLoginViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(WalletViewModel::class)
    abstract fun bindWalletFragmentViewModel(viewModel: WalletViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccountFragmentViewModel::class)
    abstract fun bindAccountFragmentViewModel(viewModel: AccountFragmentViewModel): ViewModel


    @Binds
    abstract fun bindHomeFragmentViewModelFactory(factory: HomeFragmentViewModelFactory_AssistedFactory): HomeFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindCategoryFragmentViewModelFactory(factory: CategoryFragmentViewModelFactory_AssistedFactory): CategoryFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindCountriesFragmentViewModelFactory(factory: CountriesFragmentViewModelFactory_AssistedFactory): CountriesFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindConciergeViewModelFactory(factory: ConciergeViewModelFactory_AssistedFactory): ConciergeViewModelFactory.Factory


    @Binds
    abstract fun bindAddressFragmentViewModelFactory(factory: AddressFragmentViewModelFactory_AssistedFactory): AddressFragmentViewModelFactory.Factory


    @Binds
    abstract fun bindCurrienciesFragmentViewModelFactory(factory: CurrenciesFragmentViewModelFactory_AssistedFactory): CurrenciesFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindSplashFragmentViewModelFactory(factory: SplashFragmentViewModelFactory_AssistedFactory): SplashFragmentViewModelFactory.Factory


    @Binds
    abstract fun bindSuppliersFragmentViewModelFactory(factory: SuppliersFragmentViewModelFactory_AssistedFactory): SuppliersFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindWishlistFragmentViewModelFactory(factory: WishlistFragmentViewModelFactory_AssistedFactory): WishlistFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindOrderFragmentViewModelFactory(factory: OrdersFragmentViewModelFactory_AssistedFactory): OrdersFragmentViewModelFactory.Factory


    @Binds
    abstract fun bindProductDetailsFragmentFactory(factory: ProductDetailsFragmentViewModelFactory_AssistedFactory): ProductDetailsFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindOrderDetailsFragmentFactory(factory: OrderDetailsFragmentViewModelFactory_AssistedFactory): OrderDetailsFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindProductReviewsViewModelFactory(factory: ProductReviewsViewModelFactory_AssistedFactory): ProductReviewsViewModelFactory.Factory


    @Binds
    abstract fun bindProductListFragmentFactory(factory: ProductListFragmentViewModelFactory_AssistedFactory): ProductListFragmentViewModelFactory.Factory


    @Binds
    abstract fun bindCartFragmentViewModelFactory(factory: CartFragmentViewModelFactory_AssistedFactory): CartFragmentViewModelFactory.Factory


    @Binds
    abstract fun bindMainActivityViewModelFactory(factory: MainActivityViewModelFactory_AssistedFactory): MainActivityViewModelFactory.Factory

    @Binds
    abstract fun bindWalletViewModelFactory(factory: WalletViewModelFactory_AssistedFactory): WalletViewModelFactory.Factory

    @Binds
    abstract fun bindReferFriendSuccessViewModelFactory(factory: ReferFriendSuccessViewModelFactory_AssistedFactory): ReferFriendSuccessViewModelFactory.Factory

    @Binds
    abstract fun bindReferCartFriendViewModelFactory(factory: ReferCartFriendViewModelFactory_AssistedFactory): ReferCartFriendViewModelFactory.Factory

    @Binds
    abstract fun bindCheckoutFragmentViewModelFactory(factory: CheckoutFragmentViewModelFactory_AssistedFactory): CheckoutFragmentViewModelFactory.Factory

    @Binds
    abstract fun bindUserSocialLoginViewModelFactory(factory: UserSocialLoginViewModelFactory_AssistedFactory): UserSocialLoginViewModelFactory.Factory

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}

@MapKey
@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)