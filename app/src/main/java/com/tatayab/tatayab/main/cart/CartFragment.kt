package com.tatayab.tatayab.main.cart

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartlook.sdk.smartlook.Smartlook
import com.tatayab.model.*
import com.tatayab.model.responses.CartOrderResponse
import com.tatayab.model.responses.GetOrdersFromCartResponse
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.model.responses.graph_responses.CartProductPerCountryModel
import com.tatayab.presentation.OperationType
import com.tatayab.presentation.base.GiftModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.base.MemoryCacheManager.Companion.mGiftModelConstant
import com.tatayab.presentation.base.MemoryCacheManager.Companion.walletCredit
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.main.cart.CartFragmentViewModel
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.getQuantityStringWithLocale
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.isValid
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.firebase.FirebaseTrackingManager
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.insiderSDK.InsiderManager.Companion.ITEMS_PURCHASED
import com.tatayab.tatayab.listener.OnCartListener
import com.tatayab.tatayab.listener.OnGiftListener
import com.tatayab.tatayab.listener.OnHomeNavigationListener
import com.tatayab.tatayab.listener.OnUpdateAmountListener
import com.tatayab.tatayab.util.*
import com.tatayab.tatayab.util.Constants.PLACE_ORDER
import com.useinsider.insider.Insider
import com.useinsider.insider.InsiderProduct
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_item_list_dialog_list_dialog_item.view.text
import kotlinx.android.synthetic.main.gift_view.*
import kotlinx.android.synthetic.main.layout_empty_cart.*
import kotlinx.android.synthetic.main.layout_order_status.*
import kotlinx.android.synthetic.main.layout_sub_total.*
import kotlinx.android.synthetic.main.layout_total.tv_sub_total
import kotlinx.android.synthetic.main.layout_total.tv_sub_total_value
import kotlinx.android.synthetic.main.toolbar_main_default.*
import javax.inject.Inject

class CartFragment : BaseFragment2(), OnCartListener, OnUpdateAmountListener, NavigationResult,
    OnGiftListener {


    lateinit var mainViewModel: MainActivityViewModel
    lateinit var viewModel: CartFragmentViewModel
    private var giftProductList = ArrayList<String>()
    private var selectedGiftProduct: ProductX? = null
    private var selectedGiftProductID: String? = null
    private var oldSelectedGiftProductID: String? = ""
    private var unSelectedProductID: String? = null
    private var productGistResponse: ProductsListResponse? = null
    var cartProducts: List<CartOrderResponse>? = null
    var comeFromDelete = false
    var comeFromUpdate = false
    var productGraphID = ""
    var selectProductUIDConnectToGift = ""
    var currentGiftItemId: Int? = 0
    var currentSelectedWrapEntityId: Int? = 0
    var currentSelectedWrapId: Int? = 0
    var nextSelectedGiftId: String? = ""
    var mGiftModelCached: GiftModel? = null


    @Inject
    lateinit var viewModelFactory: CartFragmentViewModelFactory.Factory

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    private var listener: OnHomeNavigationListener? = null


    override fun layoutId(): Int {
        return R.layout.fragment_cart
    }

    private var orderId: String? = null
    private var paymentSuccess: Boolean = false
    private var totalUserOrders: String? = null
    private var amount: String? = ""
    private var deliveryTime: String? = null

    private var knetData: KnetData? = null

    private var totalCount: Int? = null
    private var subTotalPrice: Float? = null
    private lateinit var cartAdapter: CartAdapter
    private lateinit var mGiftAdapter: GiftAdapter
    private lateinit var mGiftAdapter1: GiftAdapter
    private lateinit var mGiftAdapter2: GiftAdapter
    private lateinit var mGiftAdapter3: GiftAdapter

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.oldSelectedGiftProductID = null
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(CartFragmentViewModel::class.java)

        cartAdapter = CartAdapter(this, this)

        mGiftAdapter = GiftAdapter(this, viewModel.getDecimalNumbers())
        mGiftAdapter1 = GiftAdapter(this, viewModel.getDecimalNumbers())
        mGiftAdapter2 = GiftAdapter(this, viewModel.getDecimalNumbers())
        mGiftAdapter3 = GiftAdapter(this, viewModel.getDecimalNumbers())

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        mainViewModel?.getMyWallet()

        mainViewModel?.getProductGiftsLiveData()!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                }
                ResourceState.SUCCESS -> {
                    it.data?.let {
                        it?.second?.let {
                            this.productGistResponse = it
                        }
                    }
                    setupGiftList()
                    setupGiftList1()
                    setupGiftList2()
                    //setupGiftList3()
                }
                else -> {
                }
            }
        })
        viewModel?.getCreateCartForUserLiveDataData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.SUCCESS -> {
                    println("LOGIN ISSUE// createCartForUser ")
                    if (mainViewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS))
                        createCartForUser()
                    else {
                        createCartForaGuest()
                    }
                }
                else -> {
                }
            }
        })
        mainViewModel?.getCreateCartForUserLiveData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    println("LOGIN ISSUE// createCartForUser/ERROR")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    println("LOGIN ISSUE// createCartForUser/SUCCESS")
                    animationView.visibility = View.GONE
                    viewModel?.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        mainViewModel?.getCartLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                }
                ResourceState.SUCCESS -> {
                    it.data?.let { count ->
                        try {
                            (activity as MainActivity).updateCartCount(count.second)
                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }
                }
                ResourceState.ERROR -> {
                }
                else -> {
                }

            }
        })
//        mainViewModel?.getIsTokenExpiredLiveData().observe(this, Observer {
//            mainViewModel?.logoutFun()
//        })

        mainViewModel?.getLogoutLiveData().observe(this, Observer {
            try {
                viewModel?.getCart(true)
                (activity as MainActivity).updateCartCount(0)
                showLoginDialog()
            }catch (e:Exception){
                e.printStackTrace()
            }
        })
        mainViewModel?.getCreateCartForGuestLiveData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    println("LOGIN ISSUE// createCartForguestUser/ERROR")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    println("LOGIN ISSUE// createCartForguestUser/SUCCESS")
                    animationView.visibility = View.GONE
                    viewModel?.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        viewModel?.getAddGiftLiveData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        if (!paymentSuccess) {
                            showCustomTopMessage(
                                getString(R.string.your_gift_added),
                                DialogUtil.MessageType.SUCCESS
                            )
                        }
                        if (!senderNameEditText.text.toString().isNullOrEmpty()) {
                            var giftModel = GiftModel(
                                senderNameEditText.text.toString(),
                                receiverNameEditText.text.toString(),
                                giftMessageEditText.text.toString(),
                                giftProductList, it?.data?.cartProductID
                            )
                            mGiftModelCached = giftModel
                            mGiftModelConstant = giftModel
                        } else {
                            mGiftModelCached = null
                            mGiftModelConstant = null
                        }
                        selectedGiftProduct = null
                        nextSelectedGiftId = null
                        selectedGiftProductID = null
                        mainGiftView.visibility = View.GONE
                        appTallbar?.visibility = View.VISIBLE
                        if (activity is MainActivity) {
                            (activity as MainActivity).apply {
                                this.showBottomBar()
                            }
                        }

                        updateGiftText()

                        if (!paymentSuccess) viewModel?.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                    } else {
                        if (!paymentSuccess) {
                            showCustomTopMessage(
                                it?.data?.msg + "",
                                DialogUtil.MessageType.SUCCESS
                            )
                        }
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getaddtoWishListresult.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        notifyHomeWithChanges(it.data?.productID!!, true)
                        showCustomTopMessage(
                            getString(R.string.add_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        cartAdapter.changeWishListState(it.data?.productPosition!!, true)
                        it.data?.let {
                            try {
                                val params = HashMap<String, Any>()
                                params["product_name"] = it.categoryName
                                params["product_id"] = it.productID
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.add_to_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else
                        showCustomTopMessage(
                            it.data?.msg,
                            DialogUtil.MessageType.SUCCESS
                        )
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getRemoveFromWishListLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
//                    setProgress(View.VISIBLE)
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
//                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, false)
                        cartAdapter.changeWishListState(it.data?.productPosition!!, false)
                        showCustomTopMessage(
                            getString(R.string.remove_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        it.data?.let {
                            try {
                                val params = HashMap<String, Any>()
                                params["product_name"] = it.categoryName
                                params["product_id"] = it.productID
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.remove_from_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else
                        showCustomTopMessage(
                            it.data?.msg,
                            DialogUtil.MessageType.SUCCESS
                        )
                }
                else -> {
                    animationView.visibility = View.GONE
//                    setProgress(View.GONE)
                }
            }
        })

        viewModel.getGiftMessageData.observe(this, Observer {
            try {
                if (!it.isNullOrEmpty()) {
                    upSell_message.visibility = View.VISIBLE
                    up_sell_text.text = it
                    val shake: Animation = AnimationUtils.loadAnimation(context, R.anim.shark)
                    upSell_message.startAnimation(shake)
                    val mpPlaySound =
                        MediaPlayer.create(
                            requireContext(),
                            Settings.System.DEFAULT_NOTIFICATION_URI
                        );
                    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(500)
                    mpPlaySound.start()
                } else
                    upSell_message.visibility = View.GONE

            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

        viewModel.getCartLiveData.observe(this, Observer { it ->
            knetData = null
            when (it.status) {
                ResourceState.ERROR -> {
                    val fireBaseLog = ResponseLogOnFireBase
                    fireBaseLog.isGuest = viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)
                    fireBaseLog.userId = viewModel.getUserIdOrGuestUserID()
                    addObjectToFireBase(fireBaseLog, "cart_content")
                    if (it?.message.isNullOrBlank()) {
//                        setProgress(View.GONE)
                        animationView.visibility = View.GONE
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                        println("LOGIN ISSUE//getCart/Error 1")

                    }else if(mainViewModel?.isExpiredMessage(it?.message.toString())){
                        mainViewModel?.logoutFun()
                    } else {
                        println("LOGIN ISSUE//getCart/Error:" + it?.message.toString())
                        showCustomTopMessage(
                            it?.message.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                        var isUserSessionExpired =
                            mainViewModel?.isUserSessionExpired(it?.message.toString())
                        if (!isUserSessionExpired!!) {
//                            setProgress(View.GONE)
                            animationView.visibility = View.GONE
                        }
                    }
                    AdjustTracker.trackEvent(AdjustTracker.VIEW_CART_EVENT, HashMap())
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    println("LOGIN ISSUE//getCart/SUCCESS 1")
                    it.data?.let { cart ->
                        //Show the error with data in the same time
                        if (it?.message.isNullOrBlank().not()) {
                            showCustomTopMessage(
                                it?.message.toString(),
                                DialogUtil.MessageType.ERROR
                            )
                        }
                        if (cart.second.products!!.isNotEmpty()) {
                            println("LOGIN ISSUE//getCart/SUCCESS/products!!.isNotEmpty()")

                            currentGiftItemId = cart?.second?.giftItemId
                            currentSelectedWrapEntityId = cart?.second?.currentSelectedWrapId
                            if (orderId.isNullOrBlank()) {
                                showCartContent(View.VISIBLE)
                                layout_empty_cart.visibility = View.GONE
                                setupWithData(cartContentResponse = cart)
                            }
                            ITEMS_PURCHASED = cart.second.products
                            trackCartByInsider(cart.second.products!!)
                            AdjustTracker.trackEvent(AdjustTracker.VIEW_CART_EVENT, HashMap())
                            cartProducts = cart.second.products
                            checkGiftMessage(cart?.second!!)
                            selectProductUIDConnectToGift =
                                cart?.second?.products?.get(0)?.product_id.toString()
                            productGraphID =
                                cart?.second?.products?.get(0)?.productGraphID.toString()
                        } else {
                            if (orderId.isNullOrBlank()) {
                                showCartContent(View.GONE)
                                layout_empty_cart.visibility = View.VISIBLE
                            }
                            InsiderManager.cartCleared()
                            cartProducts = null
                        }
                        println("AKl://updateCartCount 2 in cartFrag //  "+cart.second.totalCartProducts)
                        (activity as MainActivity).updateCartCount(cart.second.totalCartProducts)
                    }

                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }

            }

        })


        viewModel.getCashBackLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                }

                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it?.let {
                        it?.data?.second?.let {
                            if (it?.status == 1) {
                                cashBackView?.visibility = View.VISIBLE
                                cashBackGiftLottie.playAnimation()
                                it?.mCashBackModel?.let {
                                    cashBackMessageTextView.text = it?.message.toString()
                                }
                            } else {
                                startAppRateLogin()
                            }
                        }
                    }
                }
                else -> {
                }
            }

        })

        viewModel.getRemoveFromCartLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it.data?.let { pair: Pair<Pair<String, Int>, Int> ->
//                        cartAdapter.removeItem(pair.first.second)
//                        (activity as MainActivity).updateCartCount(pair.second)
//                        if (pair.second == 0) {
//                            layout_empty_cart.visibility = View.VISIBLE
//                            showCartContent(View.GONE)
//                        }
                        // Remove product from insider list
                        it.data?.first?.first?.let {
                            if (it?.isNullOrBlank()
                                    .not() && it.equals(selectProductUIDConnectToGift)
                            ) {
                                removeGiftItemDataFromLocal()
                            }
                            InsiderManager.removeProductFromCar(it)
                            FirebaseTrackingManager.removeProductFromCar(requireContext(), it)
                        }
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })
        viewModel.getRemoveGiftFromCartLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    if (selectedGiftProduct != null) {
                        viewModel?.addGiftToCart(
                            selectedGiftProduct!!.product_id,
                            "",
                            senderNameEditText.text.toString(),
                            receiverNameEditText.text.toString(),
                            giftMessageEditText.text.toString(),
                            productGraphID,
                            selectProductUIDConnectToGift
                        )
                    } else {
                        if (senderNameEditText.text.toString().isNullOrEmpty()) {
                            mGiftModelCached = null
                            mGiftModelConstant = null
                            comeFromDelete = true
                            if (ENABLE_GRAPH_QUERIES_CALLS.not()) viewModel?.addGiftToCart(
                                "",
                                "",
                                "",
                                "",
                                "",
                                productGraphID, selectProductUIDConnectToGift
                            )
                        } else {
                            var giftModel = GiftModel(
                                senderNameEditText.text.toString(),
                                receiverNameEditText.text.toString(),
                                giftMessageEditText.text.toString(),
                                giftProductList, selectProductUIDConnectToGift
                            )
                            mGiftModelCached = giftModel
                            mGiftModelConstant = giftModel
                            if (oldSelectedGiftProductID.isNullOrEmpty()) {
                                viewModel?.addGiftToCart(
                                    "",
                                    "",
                                    senderNameEditText.text.toString(),
                                    receiverNameEditText.text.toString(),
                                    giftMessageEditText.text.toString(),
                                    productGraphID,
                                    selectProductUIDConnectToGift
                                )
                            } else {
                                comeFromUpdate = true
                                if (oldSelectedGiftProductID.isNullOrBlank()) oldSelectedGiftProductID =
                                    ""
                                viewModel?.addGiftToCart(
                                    oldSelectedGiftProductID!!,
                                    "",
                                    senderNameEditText.text.toString(),
                                    receiverNameEditText.text.toString(),
                                    giftMessageEditText.text.toString(),
                                    productGraphID,
                                    selectProductUIDConnectToGift
                                )
                            }

                        }
                        mGiftModelCached = null
                        mGiftModelConstant = null
                        selectedGiftProductID = null
                        oldSelectedGiftProductID = null
                        comeFromDelete = false
                        if (comeFromUpdate) {
                            comeFromUpdate = false
                        } else {
                            showCustomTopMessage(
                                getString(R.string.gift_removed),
                                DialogUtil.MessageType.SUCCESS
                            )
                        }
                        mainGiftView.visibility = View.GONE
                        appTallbar?.visibility = View.VISIBLE
                        if (activity is MainActivity) {
                            (activity as MainActivity).apply {
                                this.showBottomBar()
                            }
                        }
                        viewModel.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                    }
                    unSelectedProductID = null
                    updateGiftText()
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })

        viewModel.getCartCountLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
//                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it.data?.let { count ->
                        println("AKl://updateCartCount 1 in cartFrag //  "+count)
                        (activity as MainActivity).updateCartCount(count)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })


        viewModel.getUpdateProductLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    if (!it.message.isNullOrEmpty())
                        showCustomTopMessage(it.message, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it.data?.let { pair: Pair<Pair<String, Int>, Pair<Int, OperationType>> ->
                        cartAdapter.updateItem(
                            pair.second.second,
                            pair.first.first,
                            pair.first.second
                        )
                        (activity as MainActivity).updateCartCount(pair.second.first)
//                        cartAdapter.getData()
//                            ?.let { it1 -> viewModel.getTotalItemsCountWithSubTotal(products = it1) }

                        viewModel.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })

        viewModel.getCartTotalLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
//                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it.data?.let { pair ->
                        setTotal(pair = pair)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })
        viewModel.getUserLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
//                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
//                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    it.data?.let { logged ->
                        //   if (logged) {
                        val cartData =
                            cartAdapter.getData()
                        cartData?.let {
                            val checkoutAction =
                                CartFragmentDirections.nextActionCheckout(
                                    subTotalPrice!!,
                                    cartItems = it.toTypedArray(), loggedIn = logged
                                )
                            findNavController().navigate(checkoutAction)
                        }
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
//                    setProgress(View.VISIBLE)
                }
            }

        })
        mainViewModel.getWalletLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    walletCredit = 0f
                }
                ResourceState.SUCCESS -> {
                    try {
                        it?.data?.mWalletData?.avalAmount?.let {
                            walletCredit = it.toFloat()
                        } ?: run {
                            walletCredit = 0f
                        }
                    } catch (e: java.lang.Exception) {
                        walletCredit = 0f
                    }

                }
                else -> {}
            }
        })
        mainViewModel.getProductAddeddTocartLiveDataa.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    if (!it.message.isNullOrEmpty())
                        showCustomTopMessage(it.message, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getString(R.string.error_occure),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    if (it.data?.first != null) {
                        animationView.visibility = View.GONE
                        showCustomTopMessage(
                            getString(R.string.added_to_cart),
                            DialogUtil.MessageType.SUCCESS
                        )
                    }
                    nestedScrollView?.scrollTo(0, 0)
                    viewModel.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
    }



    private fun removeGiftItemDataFromLocal() {
        try {
            mGiftModelCached = null
            mGiftModelConstant = null
            selectedGiftProductID = null
            oldSelectedGiftProductID = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateGiftViewLayout() {
        giftViewLayout?.visibility =
            if (viewModel?.getCountryCode().isNullOrBlank().not() && (viewModel?.getCountryCode()
                    .equals("KW", true) || viewModel?.getCountryCode()
                    .equals("SA", true))
            ) View.VISIBLE
            else View.GONE
        giftButtonSepretor?.visibility =
            if (giftViewLayout?.visibility == View.VISIBLE) View.VISIBLE else View.GONE

    }

    private fun startAppRateLogin() {
        try {
            if (FirebaseConfigUtil.RATE_APP_FROM_SUCCESS_SCREEN_VALUE) {
                (activity as MainActivity).apply { this.showRateApp() }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun checkGiftMessage(cartResponse: GetOrdersFromCartResponse) {
        cartResponse?.let {
            if (!it?.gift_message.isNullOrEmpty()) {
                var mGiftModel = GiftModel(
                    it?.sender_name.toString(),
                    it?.recipient_name.toString(),
                    it?.gift_message.toString(),
                    giftProductList, selectProductUIDConnectToGift
                )
                mGiftModelCached = mGiftModel
                mGiftModelConstant = mGiftModel
            }
            updateGiftText()
        }

    }

    override fun onResume() {
        super.onResume()
        this.productGistResponse = null
        mGiftModelCached = null
        if (mGiftModelConstant != null) {
            selectProductUIDConnectToGift = mGiftModelConstant?.productID.toString()
            Log.d("TAG", "mMDataonResume: ${selectProductUIDConnectToGift}")
        }
        mGiftModelConstant = null
        this.selectedGiftProduct = null
        this.selectedGiftProductID = null
        this.productGistResponse = null
        if (orderId.isNullOrEmpty()) {
            viewModel?.getCart(ENABLE_GRAPH_QUERIES_CALLS)
        } else {
            try {
                (activity as MainActivity).updateCartCount(0)
            }catch (e:Exception){
                e.printStackTrace()
            }
            animationView.visibility = View.GONE
        }
    }

    private fun trackOrderByInsider() {
        if (!ITEMS_PURCHASED.isNullOrEmpty() && ITEMS_PURCHASED!!.isNotEmpty() && !orderId.isNullOrEmpty()) {
            for (item in ITEMS_PURCHASED!!) {
                try {
                    item.let {
                        InsiderManager.itemPurchased(
                            orderId,
                            it.product_id,
                            it.title,
                            arrayOf(it.title!!),
                            it.image,
                            it.price?.toDouble(),
                            viewModel.getCurrencyCode()
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            ITEMS_PURCHASED = null

        }

    }

    private fun trackCartByInsider(products: List<CartOrderResponse>) {
        try {
            val insiderProductsList = ArrayList<InsiderProduct>()
            if (!products.isNullOrEmpty() && products.isNotEmpty()) {
                for (item in products) {
                    item.let {
                        val insiderProduct = Insider.Instance.createNewProduct(
                            it.product_id,
                            it.title,
                            arrayOf(it.title!!),
                            it.image,
                            it.price?.toDouble()!!,
                            viewModel.getCurrencyCode()
                        )
                        insiderProductsList.add(insiderProduct)
                    }

                }
            }
            InsiderManager.visitCartPage(insiderProductsList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showCartContent(visibility: Int) {
        btn_continue_payment.visibility = visibility
        layout_sub_total.visibility = visibility
        cart_group.visibility = visibility
        layout_order_status.visibility = View.GONE
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // updateGiftViewLayout()

        if (FirebaseConfigUtil.SHARE_CART_ENABLED && !ENABLE_GRAPH_QUERIES_CALLS) {
            shareCartButton.visibility = View.VISIBLE
        } else {
            shareCartButton.visibility = View.INVISIBLE
        }
        mainViewModel.getProductGiftsList()
        orderId = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).orderId
        }

        amount = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).amount
        }
        totalUserOrders = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).totalUserOrders
        }

        deliveryTime = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).deliveryTime
        }

        knetData = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).knetData
        }

        paymentSuccess = arguments?.let {
            CartFragmentArgs.fromBundle(
                it
            ).paymentStatus
        } ?: false


        if (!orderId.isNullOrEmpty() && paymentSuccess!!) {
            layout_order_status.visibility = View.VISIBLE
            cart_group.visibility = View.GONE
            layout_empty_cart.visibility = View.GONE
            val time = deliveryTime?.split("\n")
            if (time?.size == 2) {
                deliveryDateView.visibility = View.VISIBLE
                deliveryDateTextView.text = time.get(0)
                delivery_message.text = time.get(1)
            }
            tv_order_id.text =
                resources.getString(R.string.order_id).plus(" ").plus(orderId)

            // if this is the first time for ordering
            try {
                trackOrderByAdjust()
                trackOrderByInsider()
                checkNoticationPermission()
                Smartlook.trackCustomEvent(PLACE_ORDER)

            } catch (e: Exception) {
                e.printStackTrace()
            }
            arguments?.putString("orderId", null)
            if (!ENABLE_GRAPH_QUERIES_CALLS) viewModel?.checkCashBack(orderId!!)
        } else {
            viewModel.getCart(ENABLE_GRAPH_QUERIES_CALLS)
        }

        knetData?.let {
            group_knet.visibility = View.VISIBLE
            if (!it.knetStatus.isNullOrEmpty()) {
                tv_transaction_id.text =
                    resources.getString(R.string.transaction_id, it.transId)
                tv_reference_no.text =
                    resources.getString(R.string.reference_number, it.refNo)
            } else if (!it.tabby_status.isNullOrEmpty()) {
                tv_transaction_id.text =
                    resources.getString(R.string.transaction_id, it.paymentId)
                tv_reference_no.visibility = View.INVISIBLE
            }
        }

        intComponent()
        updateGiftText()
    }

    private fun updateGiftText() {
        if (mGiftModelCached != null && (!mGiftModelCached?.senderName.isNullOrEmpty() || !oldSelectedGiftProductID.isNullOrBlank())) {
            deliveryAsGiftTextView.text = getString(R.string.edit_as_gift)
        } else {
            deliveryAsGiftTextView.text = getString(R.string.deliver_as_gift)
        }
    }

    var giftProductsList: ArrayList<ProductX>? = null
    var category:String?=""

    private fun setupGiftList() {
        productGistResponse?.let {


            Log.d("TAG", "setupGiftList: ${it.products}")


            if (it?.products.isNullOrEmpty()) {
            //if (giftProductsList.isNullOrEmpty()) {
                giftProductView.visibility = View.GONE
                giftProductsList = null
            } else {
                for(item in it?.products!!){
                    if(item?.category == "CHOCOLATE"){
                        category=item?.category
                    }
                }
                giftProductView.visibility = View.VISIBLE
                giftTitleTextView.text=category

              mGiftAdapter.setData(
                    viewModel.getCurrencyCode(),
                    it?.products?.filter { productX -> productX?.category == "CHOCOLATE" } as ArrayList<ProductX>, oldSelectedGiftProductID
                )
                giftProductsList = it?.products as ArrayList<ProductX>


                if (currentGiftItemId!! > 0) {
                    nextSelectedGiftId = currentGiftItemId.toString()
                    var giftItem = getGiftItemIfExist(currentGiftItemId)
                    try {
                        if (giftItem != null && !giftItem.product_id.equals(cartAdapter?.getGiftIDIfExist())) {
                            cartAdapter.addGiftItem(giftItem)
                        }
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
                }
            }

        }
    }

    var giftProductsList1: ArrayList<ProductX>? = null
    var category1:String?=""
    private fun setupGiftList1() {
        productGistResponse?.let {





            if (it?.products.isNullOrEmpty()) {
            //if (giftProductsList1.isNullOrEmpty()) {
                giftProductView1.visibility = View.GONE
                giftProductsList = null
            } else {
                for(item in it?.products!!){
                    if(item?.category == "NA"){
                        category1=item?.category
                    }
                }
                giftProductView1.visibility = View.VISIBLE
                giftTitleTextView1.text=category1
               mGiftAdapter1.setData(
                    viewModel.getCurrencyCode(),
                    it?.products?.filter { productX -> productX?.category == "NA" } as ArrayList<ProductX>, oldSelectedGiftProductID
                )
                giftProductsList = it?.products as ArrayList<ProductX>

                if (currentGiftItemId!! > 0) {
                    nextSelectedGiftId = currentGiftItemId.toString()
                    var giftItem = getGiftItemIfExist(currentGiftItemId)
                    try {
                        if (giftItem != null && !giftItem.product_id.equals(cartAdapter?.getGiftIDIfExist())) {
                            cartAdapter.addGiftItem(giftItem)
                        }
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
                }
            }

        }
    }

    var giftProductsList2: ArrayList<ProductX>? = null
    var category2:String?=""

    private fun setupGiftList2() {
        productGistResponse?.let {



           if (it?.products.isNullOrEmpty()) {
            //if (giftProductsList2.isNullOrEmpty()) {
                giftProductView2.visibility = View.GONE
                giftProductsList = null
            } else {
               for(item in it?.products!!){
                   if(item?.category == "giftcards"){
                       category2=item?.category
                   }
               }
                giftProductView2.visibility = View.VISIBLE
                giftTitleTextView2.text=category2
                mGiftAdapter2.setData(
                    viewModel.getCurrencyCode(),
                    it?.products?.filter { productX -> productX?.category == "giftcards" } as ArrayList<ProductX>, oldSelectedGiftProductID
                )
                giftProductsList = it?.products as ArrayList<ProductX>
               /* giftProductsList2?.let {
                    mGiftAdapter2.setData(
                        viewModel.getCurrencyCode(),
                        giftProductsList2!!, oldSelectedGiftProductID
                    )
                }*/
                if (currentGiftItemId!! > 0) {
                    nextSelectedGiftId = currentGiftItemId.toString()
                    var giftItem = getGiftItemIfExist(currentGiftItemId)
                    try {
                        if (giftItem != null && !giftItem.product_id.equals(cartAdapter?.getGiftIDIfExist())) {
                            cartAdapter.addGiftItem(giftItem)
                        }
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
                }
            }

        }
    }






    private fun checkNoticationPermission() {
        try {
            if (!NotificationManagerCompat.from(requireActivity())
                    .areNotificationsEnabled()
            ) {
                showNotificationPermissionDialog()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showNotificationPermissionDialog() {
        try {
            val alertDialog =
                AlertDialog.Builder(requireActivity())
            alertDialog.setTitle(getString(R.string.notification_permission_dialog_title))
            alertDialog.setMessage(getString(R.string.notification_permission_dialog_message))
            alertDialog.setPositiveButton(
                getString(R.string.open_settings)
            ) { dialog, which ->
                val settingsIntent: Intent =
                    Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .putExtra(
                            Settings.EXTRA_APP_PACKAGE,
                            requireActivity().getPackageName()
                        )
                requireActivity().startActivity(settingsIntent)
            }
            alertDialog.setNegativeButton(
                getString(R.string.cancel)
            ) { dialog, which -> dialog.cancel() }
            alertDialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun trackOrderByAdjust() {
        val params = HashMap<String, String>()
        params[AdjustTracker.OrderId] = orderId.toString()
        params[AdjustTracker.Total_Paid_Amount] =
            if (amount.isNullOrEmpty()) "0" else amount!!
        if (!totalUserOrders.isNullOrEmpty() && totalUserOrders!!.toInt() == 1) {
            AdjustTracker.trackEvent(AdjustTracker.FIRST_ORDER_EVENT, params)
        }
        AdjustTracker.trackEvent(
            AdjustTracker.PURCHASE_EVENT,
            params,
            viewModel.getCurrencyCode()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        arguments?.putString("orderId", null)
    }

    override fun onNavigationResult(result: Bundle) {
    }

    private fun setupWithData(
        cartContentResponse: Pair<String, GetOrdersFromCartResponse>,
        second: List<CartMap>? = null
    ) {

        if (second == null) {
            println("LOGIN ISSUE//getCart/setupWithData/second == null")
            if (cartContentResponse.second.products.isNullOrEmpty() || cartContentResponse.second.products!!.isEmpty()) {
                layout_empty_cart.visibility = View.VISIBLE
                cart_group.visibility = View.GONE
                println("LOGIN ISSUE//getCart/setupWithData/if (cartContentResponse.second.products.isNullOrEmpty()")

            } else {
                println("LOGIN ISSUE//getCart/setupWithData/else 1 ")
                cart_group.visibility = View.VISIBLE
                if (!cartContentResponse.second.notes?.trim().isNullOrEmpty()) {
                    notes.visibility = View.VISIBLE
                    notes.text = "( " + cartContentResponse.second.notes + " )"
                }
                var giftItem = getGiftItemIfExist(cartContentResponse?.second?.giftItemId)
                var cartItemsList: ArrayList<CartOrderResponse> =
                    (cartContentResponse.second.products as ArrayList<CartOrderResponse>?)!!
                if (giftItem != null) {
                    cartItemsList.add(giftItem)
                } else {
                    oldSelectedGiftProductID = ""
                }
                cartAdapter.setData(
                    cartContentResponse.first,
                    getCartProductPerCountry(cartItemsList!!),
                    viewModel.getDecimalNumbers()
                )
                cartAdapter.notifyDataSetChanged()
                println("LOGIN ISSUE//getCart/setupWithData/notifyDataSetChanged")

                cartItemsList.let {
                    if (it?.size == 1 && it?.get(0)!!.isGift == 1) {
                        println("REMOVE GIFT FROM CART 1")
                        senderNameEditText.setText("")
                        receiverNameEditText.setText("")
                        giftMessageEditText.setText("")
                        viewModel.deleteGiftItemFromCart(
                            existWrapId = currentSelectedWrapEntityId,
                            productId = it?.get(0)!!.product_id!!,
                            senderName = senderNameEditText?.text.toString(),
                            reciverName = receiverNameEditText?.text.toString(),
                            giftMessage = giftMessageEditText?.text.toString(),
                            productGraphID = productGraphID
                        )

                    }
                }
            }
        } else {
            println("LOGIN ISSUE//getCart/setupWithData/else 2 ")
            if (second.isEmpty()) {
                println("LOGIN ISSUE//getCart/setupWithData/if 2 ")
                layout_empty_cart.visibility = View.VISIBLE
                cart_group.visibility = View.GONE
            } else {
                println("LOGIN ISSUE//getCart/setupWithData/else 3 ")
                cart_group.visibility = View.VISIBLE
                cartAdapter.setData(
                    cartContentResponse.first,
                    getCartProductPerCountry(cartContentResponse.second.products!! as java.util.ArrayList<CartOrderResponse>),
                    viewModel.getDecimalNumbers()
                )
            }

        }

    }

    private fun getCartProductPerCountry(cartItemsList: java.util.ArrayList<CartOrderResponse>): List<CartOrderResponse> {
        var finialProductList = ArrayList<CartOrderResponse>()

        var productListPerCountry = ArrayList<CartProductPerCountryModel>()

        if(cartItemsList.isNullOrEmpty()) return  finialProductList

        var currentProductList = ArrayList<CartOrderResponse>()
        currentProductList.addAll(cartItemsList)
//        // For testing, Akl , please remove this
//        currentProductList.mapIndexed { index, cartOrderResponse ->
//            if(index == 0){
//                cartOrderResponse.countryId = "SA"
//            }
//        }
         currentProductList.map {
            if(productListPerCountry.isNullOrEmpty()){
                it?.isFirstItemPerCountry = true
                var productList = ArrayList<CartOrderResponse>()
                productList.add(it)
                productListPerCountry.add(CartProductPerCountryModel(it?.countryId.toString(),productList))
            }else{
                var isAdded = false
                productListPerCountry.mapIndexed { index, cartProductPerCountryModel ->
                    if(cartProductPerCountryModel?.countryCode.equals(it?.countryId)){
                        isAdded = true
                        it?.isFirstItemPerCountry = false
                        cartProductPerCountryModel.productList.add(it)
                    }
                }
                if(!isAdded){
                    it?.isFirstItemPerCountry = true
                    var productList = ArrayList<CartOrderResponse>()
                    productList.add(it)
                    productListPerCountry.add(CartProductPerCountryModel(it?.countryId.toString(),productList))
                } else {
                    // do no thing
                }
            }
        }

        productListPerCountry?.map {

            it?.productList?.mapIndexed { index, cartOrderResponse ->
                finialProductList.add(cartOrderResponse)
            }
        }
        return finialProductList
    }

    private fun getGiftItemIfExist(giftItemId: Int? = 0): CartOrderResponse? {
        try {
            if (giftItemId == null || giftItemId == 0 || giftProductsList.isNullOrEmpty()) {
                return null
            } else {
                giftProductsList?.map {
                    if (it?.product_id?.isNullOrBlank()
                        !!.not() && it?.product_id.equals(giftItemId.toString())
                    ) {
                        selectedGiftProduct = it
                        selectedGiftProductID = it?.product_id
                        return CartOrderResponse(
                            title = it?.title,
                            product_id = it?.product_id,
                            image = it?.image,
                            price = it?.price,
                            isGift = 1,
                            amount = 1
                        )
                    }

                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun getGiftItemPriceIfExist(giftItemId: Int? = 0): Float {
        try {
            if (giftItemId == null || giftItemId == 0 || giftProductsList.isNullOrEmpty()) {
                return 0F
            } else {
                giftProductsList?.map {
                    if (it?.product_id?.isNullOrBlank()
                        !!.not() && it?.product_id.equals(giftItemId.toString())
                    ) {
                        return it?.price!!
                    }

                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return 0F
    }


    private fun setTotal(pair: Pair<String, Pair<Int, Float>>) {
        tv_sub_total.text = resources.getQuantityStringWithLocale(
            R.plurals.number_of_items,
            NumbersUtil.formatNumberDigit(pair.second.first, 1),
            NumbersUtil.formatNumberDigit(pair.second.first, 1)
        )
        var totalPrice = pair.second.second + getGiftItemPriceIfExist(currentGiftItemId)
        var totalPriceAfterCheckCredit = totalPrice
//        if (walletCredit!! >= totalPrice) {
//            totalPriceAfterCheckCredit = 0f
//        }
        tv_sub_total_value.text =
            resources.getString(
                R.string.currency,
                NumbersUtil.formatNumber(totalPriceAfterCheckCredit, viewModel.getDecimalNumbers()),
                pair.first
            )
        totalCount = pair.second.first
        subTotalPrice = totalPrice
    }


    private fun intComponent() {
        try {
            rv_cart.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            rv_cart.adapter = cartAdapter

            giftRecyclerView.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
            giftRecyclerView.adapter = mGiftAdapter

            giftRecyclerView1.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
            giftRecyclerView1.adapter = mGiftAdapter1

            giftRecyclerView2.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
            giftRecyclerView2.adapter = mGiftAdapter2

            /*giftRecyclerView3.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
            giftRecyclerView3.adapter = mGiftAdapter3*/

            btn_continue_payment.setSafeOnClickListener {
                viewModel.continueToPayment()
            }

            shareCartButton.setSafeOnClickListener {
                shareCartWithFriends()
            }

            btn_continue_shopping.setSafeOnClickListener {
                //orderId=null
                //hack for setting orderId
                arguments?.putString("orderId", null)
                arguments?.putParcelable("knetData", null)
                listener?.navigatedToHomeFragment()
            }
            giftViewLayout.setOnClickListener {
               // openMainGiftView()
            }
            removeGiftButton.setOnClickListener {
                try {
                    senderNameEditText.setText("")
                    receiverNameEditText.setText("")
                    giftMessageEditText.setText("")
                    selectedGiftProduct = null
                    selectedGiftProductID = null
                    mGiftModelCached = null
                    mGiftModelConstant = null
                    if (oldSelectedGiftProductID.isNullOrEmpty()) {
                        mainGiftView.visibility = View.GONE
                        appTallbar?.visibility = View.VISIBLE
                        if (activity is MainActivity) {
                            (activity as MainActivity).apply {
                                this.showBottomBar()
                            }
                        }
                        comeFromDelete = true
                        if (ENABLE_GRAPH_QUERIES_CALLS.not()) viewModel?.addGiftToCart(
                            "",
                            "",
                            "",
                            "",
                            "",
                            productGraphID, selectProductUIDConnectToGift
                        )
                        println("REMOVE GIFT message from button")
                        showCustomTopMessage(
                            getString(R.string.gift_removed),
                            DialogUtil.MessageType.SUCCESS
                        )
                    } else {
                        viewModel.deleteGiftItemFromCart(
                            existWrapId = currentSelectedWrapEntityId,
                            senderName = senderNameEditText?.text.toString(),
                            reciverName = receiverNameEditText?.text.toString(),
                            giftMessage = giftMessageEditText?.text.toString(),
                            productGraphID = productGraphID,
                            productId = currentGiftItemId.toString()
                        )
                    }
                    updateGiftText()
                    hideKeyboard()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            submitGiftButton.setOnClickListener {
                try {
                    if (!senderNameEditText.isValid(requireContext())
                        || !receiverNameEditText.isValid(requireContext())
                        || !giftMessageEditText.isValid(requireContext()) || checkGiftProductRequired()
                    ) {
                    } else if (submitGiftButton.text.equals(getString(R.string.edit_gift))) {
                        mGiftModelCached = GiftModel(
                            senderNameEditText.text.toString(),
                            receiverNameEditText.text.toString(),
                            giftMessageEditText.text.toString(),
                            giftProductList, selectProductUIDConnectToGift
                        )
                        comeFromDelete = true
                        viewModel.updateGiftToCart(
                            nextSelectedGiftId!!,
                            "",
                            senderName = senderNameEditText?.text.toString(),
                            reciverName = receiverNameEditText?.text.toString(),
                            giftMessage = giftMessageEditText?.text.toString(),
                            cartProductID = productGraphID,
                            oldGiftId = currentSelectedWrapEntityId,
                            productUID = selectProductUIDConnectToGift
                        )

                    } else {
                        mGiftModelCached = GiftModel(
                            senderNameEditText.text.toString(),
                            receiverNameEditText.text.toString(),
                            giftMessageEditText.text.toString(),
                            giftProductList, selectProductUIDConnectToGift
                        )

                        if (!nextSelectedGiftId.isNullOrEmpty() && !unSelectedProductID.equals(
                                selectedGiftProductID
                            )
                        ) {
                            println("REMOVE GIFT FROM CART 3")
                            comeFromDelete = true
                            viewModel.addGiftToCart(
                                nextSelectedGiftId!!,
                                "",
                                senderName = senderNameEditText?.text.toString(),
                                reciverName = receiverNameEditText?.text.toString(),
                                giftMessage = giftMessageEditText?.text.toString(),
                                cartProductID = productGraphID, selectProductUIDConnectToGift
                            )
                        } else if (!oldSelectedGiftProductID.isNullOrEmpty() && nextSelectedGiftId.isNullOrBlank()
                                .not()
                        ) {
                            println("REMOVE GIFT FROM CART 4")
                            viewModel.addGiftToCart(
                                selectedGiftProduct!!.product_id,
                                "",
                                senderNameEditText.text.toString(),
                                receiverNameEditText.text.toString(),
                                giftMessageEditText.text.toString(),
                                productGraphID,
                                selectProductUIDConnectToGift
                            )
                        } else if (selectedGiftProduct != null) {
                            viewModel.addGiftToCart(
                                selectedGiftProduct!!.product_id,
                                "",
                                senderNameEditText.text.toString(),
                                receiverNameEditText.text.toString(),
                                giftMessageEditText.text.toString(),
                                productGraphID,
                                selectProductUIDConnectToGift
                            )
                        } else {
                            if (oldSelectedGiftProductID.isNullOrEmpty()) {
                                viewModel.addGiftToCart(
                                    "",
                                    "",
                                    senderNameEditText.text.toString(),
                                    receiverNameEditText.text.toString(),
                                    giftMessageEditText.text.toString(),
                                    productGraphID,
                                    selectProductUIDConnectToGift
                                )
                            } else {
                                viewModel.addGiftToCart(
                                    oldSelectedGiftProductID!!,
                                    "",
                                    senderNameEditText.text.toString(),
                                    receiverNameEditText.text.toString(),
                                    giftMessageEditText.text.toString(),
                                    productGraphID,
                                    selectProductUIDConnectToGift
                                )
                            }
                        }
                        updateGiftText()
                    }
                    hideKeyboard()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            closeButton.setOnClickListener {
                mainGiftView.visibility = View.GONE
                appTallbar?.visibility = View.VISIBLE
                if (activity is MainActivity) {
                    (activity as MainActivity).apply {
                        this.showBottomBar()
                    }
                }
                selectedGiftProduct = null
                hideKeyboard()
            }
            closeCashBackViewButton.setOnClickListener {
                cashBackView.visibility = View.GONE
                startAppRateLogin()
            }

            checkBalanceButton.setOnClickListener {
                (activity as MainActivity).apply {
                    this.navigatedToProfileFragment()
                }
                startAppRateLogin()
            }

            btn_view_products.setSafeOnClickListener {
                listener?.navigatedToCategoryFragment()
            }

            refresh.setOnRefreshListener {
                viewModel.getCart(ENABLE_GRAPH_QUERIES_CALLS)
                refresh.isRefreshing = false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun checkGiftProductRequired(): Boolean {
        return if (!giftProductsList.isNullOrEmpty() && selectedGiftProduct == null && (oldSelectedGiftProductID.isNullOrEmpty() || oldSelectedGiftProductID.equals(
                unSelectedProductID
            ))
        ) {
            showCustomTopMessage(
                getString(R.string.gift_product_required),
                DialogUtil.MessageType.ERROR
            )
            true
        } else {
            false
        }
    }


    private fun openMainGiftView() {
        try {
            if (!oldSelectedGiftProductID.isNullOrEmpty()) {
                mGiftAdapter?.updateSelectedGiftProductID(oldSelectedGiftProductID)
            } else {
                mGiftAdapter?.updateSelectedGiftProductID("-1")
            }
            mGiftAdapter?.notifyDataSetChanged()
            mainGiftView.visibility = View.VISIBLE
            appTallbar?.visibility = View.GONE
            if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    this.hideBottomBar()
                }
            }
            setupGiftList()
            giftScrollView.scrollTo(0, 0)
            slideMainGiftViewToAbove()
            senderNameEditText.setError(null)
            receiverNameEditText.setError(null)
            giftMessageEditText.setError(null)
            if (mGiftModelCached != null && !mGiftModelCached?.senderName.isNullOrEmpty()) {
                removeGiftButton.visibility = View.VISIBLE
                submitGiftButton.text = getString(R.string.edit_gift)
                mGiftModelCached?.let {
                    senderNameEditText.setText(it.senderName)
                    receiverNameEditText.setText(it.receiverName)
                    giftMessageEditText.setText(it.message)
//                    if (!it?.giftProductList.isNullOrEmpty()) {
//                        selectedGiftProductID = it?.giftProductList.get(0)
//                        oldSelectedGiftProductID = it?.giftProductList.get(0)
//                    } else {
//                        selectedGiftProductID = null
//                        oldSelectedGiftProductID = null
//                    }
                }
            } else {
                submitGiftButton.text = getString(R.string.save_gift)
                removeGiftButton.visibility = View.GONE
                senderNameEditText.setText("")
                receiverNameEditText.setText("")
                giftMessageEditText.setText("")
            }
            updateGiftText()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onProductDelete(productId: String, product: CartOrderResponse, index: Int) {
        viewModel.deleteCartItem(
            productId = product.product_id!!,
            productIdRemote = productId,
            position = index,
            product = product,
            senderName = senderNameEditText?.text.toString(),
            reciverName = receiverNameEditText?.text.toString(),
            giftMessage = giftMessageEditText?.text.toString(),
            productGraphID = productGraphID
        )
    }

    override fun onProductClicked(
        cartId: String,
        productId: String,
        options: Map<String, String>?
    ) {
        val optionsValue = getOptions(options)
        val nextAction = CartFragmentDirections.nextProductDetails(
            productId, optionsValue, cartId
        )
        view?.let {
            findNavController().navigate(nextAction)
        }

    }

    override fun onOptionsClicked(product: MapValueXXX?) {
        val nextAction = CartFragmentDirections.actionOptionDialog(product!!)
        view?.let {
            findNavController().navigate(nextAction)
        }
    }


    private fun getOptions(selectedOptions: Map<String, String>?): Array<OptionsMap> {
        val option = arrayListOf<OptionsMap>()
        selectedOptions?.forEach {
            option.add(OptionsMap(it.key, it.value))
        }
        return option.toTypedArray()
    }

    override fun addToWishlist(position: Int, product: Product) {
        if (mainViewModel.isUserLoginWithOpenLogin()) {
            try {
                mainViewModel.addToWishList(
                    product.product_id!!,
                    position = position,
                    options = product.selected_options,
                    productName = product.product!!
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun removeFromWishlist(index: Int, product: Product) {
        try {
            if (mainViewModel.isUserLoginWithOpenLogin()) {
                mainViewModel.deleteWishListItem(
                    product.selected_options,
                    index,
                    product.product_id!!,
                    productName = product.product!!
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun updateGiftId(productId: String) {
        oldSelectedGiftProductID = productId
        if (mGiftModelCached == null) {
            giftProductList.clear()
            mGiftModelCached =
                GiftModel(
                    "", "", "",
                    giftProductList, selectProductUIDConnectToGift
                )
        }
        updateGiftText()
        mGiftAdapter?.updateSelectedGiftProductID(productId)
    }

    override fun openGiftView() {
        openMainGiftView()
    }


    override fun onUpdateAmount(
        operationType: OperationType,
        productId: String,
        product: CartOrderResponse,
        value: Int,
        position: Int
    ) {
        animationView.visibility = View.VISIBLE

        if (operationType == OperationType.ADD) {
            if (!ENABLE_GRAPH_QUERIES_CALLS) {
                var mProductX = ProductX(
                    title = product.title,
                    product_id = product?.product_id!!,
                    price = product.price!!,
                    has_options = if (product?.productOptions?.size!! > 0) 1 else 0
                )
                mainViewModel?.addToCart(mProductX, product?.productOptions, false)
            } else {
                viewModel.updateProductAmount(operationType, productId, product, value, position)
            }
        } else {
            if (value == 0) {
                viewModel.deleteCartItem(
                    productId = product.product_id!!,
                    productIdRemote = productId,
                    position = position,
                    product = product,
                    senderName = senderNameEditText?.text.toString(),
                    reciverName = receiverNameEditText?.text.toString(),
                    giftMessage = giftMessageEditText?.text.toString(),
                    productGraphID = productGraphID
                )
            } else {
                viewModel.updateProductAmount(
                    operationType,
                    productId,
                    product,
                    value,
                    position
                )
            }
        }
    }

    override fun getGiftOptions() {
       // TODO("Not yet implemented")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnHomeNavigationListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnHomeNavigationListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun notifyHomeWithChanges(prductID: String, newStatues: Boolean) {
        val intent = Intent(Constants.CHANGE_WISHLIST_CASE)
        intent.putExtra(Constants.PRODUCT_ID, prductID)
        intent.putExtra(Constants.NEW_STATEUES, newStatues)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    override fun onAddButtonClicked(mProductX: ProductX) {
        mProductX?.let {
//            if (oldSelectedGiftProductID.isNullOrEmpty() || !oldSelectedGiftProductID.equals(it?.product_id)) {
            selectedGiftProduct = it
            selectedGiftProductID = it?.product_id
            giftProductList.clear()
//                 if (oldSelectedGiftProductID.isNullOrEmpty()) oldSelectedGiftProductID =
//                    mProductX.product_id
//            }
        }
    }

    override fun updateGift(mProductX: ProductX) {
        mProductX?.let {
            selectedGiftProduct = it
            selectProductUIDConnectToGift = mProductX?.uid.toString()
            selectedGiftProductID = it?.product_id
            giftProductList.clear()
            nextSelectedGiftId = if (mProductX?.product_id.isNullOrBlank()
                    .not()
            ) mProductX?.product_id else ""
        }

    }

    override fun onDeleteButtonClicked(mProductX: String) {
        mProductX?.let {
            selectedGiftProduct = null
            selectedGiftProductID = ""
            if (oldSelectedGiftProductID.equals(mProductX)) {
                unSelectedProductID = mProductX
            }
            giftProductList.clear()
        }
    }

    override fun onGetButtonClicked(mProductID: String) {

    }

    override fun onGetButtonClicked2(mProductID: String) {

    }

    fun slideMainGiftViewToAbove() {
        mainGiftView.clearAnimation()
        val animation = AnimationUtils.loadAnimation(
            activity,
            R.anim.bottom_to_original
        )
        mainGiftView.setAnimation(animation)
    }

    private fun shareCartWithFriends() {
        try {
            if (cartProducts.isNullOrEmpty()) {
                showCustomTopMessage(
                    getText(R.string.no_cart_items).toString(),
                    DialogUtil.MessageType.ERROR
                )
            } else {
                var convertTheListToJson = viewModel?.convertCartListToModel(cartProducts!!)
                if (!convertTheListToJson.isNullOrEmpty()) {
                    val nextAction = CartFragmentDirections.shareCart(convertTheListToJson)
                    view?.let {
                        findNavController().navigate(nextAction)
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun createCartForUser() {
        mainViewModel?.createCartForUser(null, null)
    }

    private fun createCartForaGuest() {
        mainViewModel?.createCartForGuest(null, null)
    }


    fun showLoginDialog(){
        try {
            val builder = Dialog(requireActivity())
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
            builder.setCancelable(true)
            builder.setContentView(R.layout.login_dialog)
            builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val confirmButton = builder.findViewById(R.id.confirmButton) as TextView
            val dismissButton = builder.findViewById(R.id.dismissButton) as TextView
            builder.setTitle("")
            confirmButton.setSafeOnClickListener {
                showLoginScreen()
                builder.dismiss()
            }
            dismissButton.setSafeOnClickListener {
                builder.dismiss()
            }
            builder.show()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun showLoginScreen() {
        try {
            val bundle = Bundle().apply {
                putInt(com.tatayab.tatayab.util.Constants.LOGIN, com.tatayab.tatayab.util.Constants.REQUEST_CODE_LOG_IN)
            }
            val loginIntent = Intent(activity, LoginOptionActivity::class.java)
            loginIntent.putExtras(bundle)
            startActivityForResult(loginIntent, com.tatayab.tatayab.util.Constants.REQUEST_CODE_LOGIN_ACTIVITY)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}
