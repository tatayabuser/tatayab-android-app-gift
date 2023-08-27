package com.tatayab.tatayab.checkout

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import com.tatayab.model.Product
import com.tatayab.model.ResponseLogOnFireBase
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.responses.*
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.Utils
import com.tatayab.presentation.Utils.CheckOutAction.addressID
import com.tatayab.presentation.Utils.CheckOutAction.dataLoaded
import com.tatayab.presentation.Utils.CheckOutAction.openAddAddress
import com.tatayab.presentation.Utils.CheckOutAction.openLoginOptions
import com.tatayab.presentation.address.AddressFragmentViewModel
import com.tatayab.presentation.address.AddressFragmentViewModelFactory
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.base.MemoryCacheManager.Companion.mGiftModelConstant
import com.tatayab.presentation.checkout.CheckoutFragmentViewModel
import com.tatayab.presentation.checkout.CheckoutFragmentViewModelFactory
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.addresses.AddAddressFragmentArgs
import com.tatayab.tatayab.addresses.AddressesFragmentDirections
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.errorHandling.ExceptionHandler
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCheckoutProductSelected
import com.tatayab.tatayab.util.*
import com.tatayab.tatayab.util.Constants.CREDIT_KEY
import com.tatayab.tatayab.util.Constants.TOTAL_PRICE_KEY
import kotlinx.android.synthetic.main.checkout_layout.*
import kotlinx.android.synthetic.main.fragment_checkout.*
import timber.log.Timber
import javax.inject.Inject
import kotlin.collections.HashMap


class CheckoutFragment : BaseFragment(), PaymentListener, OnCheckoutProductSelected {

    private var paymentMethodSelected: CheckOutPaymentModel? = null
    private var mCheckOutAddressModel: CheckOutAddressModel? = null
    private var mPaymentMethodsAdapter: PaymentMethodsAdapter? = null
    private var mSubTotalForCountriesAdapter: SubtTotalForCountriesAdapter? = null
    private var mSubTotalAdapter: CheckOutLabelsAdapter? = null
    private var mTotalAdapter: CheckOutTotalLabelsAdapter? = null
    private var mProductsForCountriesAdapter: ProductsForCountriesAdapter? = null
    private var totalAmount: String = ""
    lateinit var viewModel: CheckoutFragmentViewModel
    private val addToWishListResultToAdapter = SingleLiveEvent<Resource<AddToWishListResponse>>()

    private val go by lazy {
        arguments?.getBoolean("GiftOptions") ?: false    }

    private var avalAmount = 0f

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    private lateinit var mainViewModel: MainActivityViewModel


    @Inject
    lateinit var viewModelFactoryCheckout: CheckoutFragmentViewModelFactory.Factory

    lateinit var addressViewModel: AddressFragmentViewModel

    @Inject
    lateinit var viewModelFactoryAddress: AddressFragmentViewModelFactory.Factory

    override fun layoutId(): Int {
        return R.layout.fragment_checkout
    }


    fun showLoginDialog() {
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
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showLoginScreen() {
        try {
            val bundle = Bundle().apply {
                putInt(
                    com.tatayab.tatayab.util.Constants.LOGIN,
                    com.tatayab.tatayab.util.Constants.REQUEST_CODE_LOG_IN
                )
            }
            val loginIntent = Intent(activity, LoginOptionActivity::class.java)
            loginIntent.putExtras(bundle)
            startActivityForResult(
                loginIntent,
                com.tatayab.tatayab.util.Constants.REQUEST_CODE_LOGIN_ACTIVITY
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModels()
        initActions()
        mainViewModel?.getLogoutLiveData().observe(this, Observer {
            try {
                (activity as MainActivity).updateCartCount(0)
                showLoginDialog()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
        mainViewModel.getaddtoWishListresult.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    if (it?.message.isNullOrEmpty()) {
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                    } else {
                        if (mainViewModel?.isExpiredMessage(it?.message.toString())) {
                            mainViewModel?.logoutFun()
                        } else {
                            showCustomTopMessage(
                                it?.message.toString() + " ",
                                DialogUtil.MessageType.ERROR
                            )
                        }
                    }
                    it.data?.newStatues = 0
                    addToWishListResultToAdapter.postValue(it)
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        it.data?.newStatues = 1
                        addToWishListResultToAdapter.postValue(it)
                        notifyHomeWithChanges(it?.data?.productID!!, true)
                        showCustomTopMessage(
                            getString(R.string.add_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        it.data?.let {
                            try {
                                val params = HashMap<String, Any>()
                                params["product_name"] = it.productName
                                params["product_id"] = it.productID
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.add_to_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else {
                        it.data?.newStatues = 0
                        addToWishListResultToAdapter.postValue(it)
                        showCustomTopMessage(
                            it.data?.msg!!,
                            DialogUtil.MessageType.ERROR
                        )
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getRemoveFromWishListLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    it.data?.newStatues = 1
                    addToWishListResultToAdapter.postValue(it)
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getString(R.string.error_occure),
                        DialogUtil.MessageType.SUCCESS
                    )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, false)
                        it.data?.newStatues = 0
                        addToWishListResultToAdapter.postValue(it)
                        showCustomTopMessage(
                            getString(R.string.remove_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        it.data?.let {
                            try {
                                val params = HashMap<String, Any>()
                                params.put("product_name", it.categoryName)
                                params.put("product_id", it.productID)
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.remove_from_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else {
                        it.data?.newStatues = 1
                        addToWishListResultToAdapter.postValue(it)
                        showCustomTopMessage(
                            it.data?.msg.toString(),
                            DialogUtil.MessageType.SUCCESS
                        )
                    }
                }
                else -> setProgress(View.GONE)
            }
        })

        addressViewModel.getAddressesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    setProgress(View.VISIBLE)
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    Timber.e("Success")
                    handleAddressesResponse(it.data)
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

        viewModel.getApplayCouponLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgressView(View.GONE)
                    showCustomTopMessage(
                        getString(R.string.invalid_coupon),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.LOADING -> {
                    setProgressView(View.VISIBLE)
                }
                ResourceState.SUCCESS -> {
                    setProgressView(View.GONE)
                    showCustomTopMessage(
                        getString(R.string.coupon_success),
                        DialogUtil.MessageType.SUCCESS
                    )
                    recallCheckoutApi()
//                    handelAndUpdateData(it, ActionName.APPLY_COUPON)
                    try {
                        val params = java.util.HashMap<String, Any>()
                        it.data?.couponModel?.code?.let {
                            params.put("coupon_code", it)
                        }
                        InsiderManager.sendCustomEvent(
                            InsiderManager.CustomEvent.coupon_used.toString(),
                            params
                        )

                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
                }
            }

        })

        viewModel.getBackToCartLiveData.observe(this, Observer {
            findNavController().popBackStack()
        })

        viewModel.getCreateOrderLiveData.observe(this, Observer {

            when (it.status) {
                ResourceState.ERROR -> {
                    checkoutButton.isEnabled = true
                    val fireBaseLog: ResponseLogOnFireBase = ResponseLogOnFireBase
                    fireBaseLog.isGuest = viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)
                    fireBaseLog.userId = viewModel.getUserIdOrGuestUserID()
                    addObjectToFireBase(fireBaseLog, "create_order")
                    setProgressView(View.GONE)
                    var message =
                        it.throwable?.let { it1 ->
                            ExceptionHandler().getMessage(
                                it1,
                                requireContext()
                            )
                        }
                    if (it?.message.isNullOrBlank().not()) {
                        if (mainViewModel?.isExpiredMessage(it?.message.toString())) {
                            mainViewModel?.logoutFun()
                        } else {
                            message = it?.message.toString()
                        }
                    }
                    if (message.isNullOrBlank()) {
                        message = getText(R.string.error_occure).toString()
                    }
                    // check if the error contains tabbi error[Transaction Failed  errror   tabby]
                    if (message.contains("tabby")) {
                        message = getText(R.string.tabby_error).toString()
                    }
                    showCustomTopMessage(
                        message,
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.LOADING -> {
                    setProgressView(View.VISIBLE)
                }
                ResourceState.SUCCESS -> {
                    it.data?.let { orderResponse ->
                        if (orderResponse.redirectUrl.isNullOrBlank()) {
                            if (orderResponse.orderId.isNullOrBlank()) {
                                checkoutButton.isEnabled = true
                                showCustomTopMessage(
                                    getString(R.string.error_occure),
                                    DialogUtil.MessageType.ERROR
                                )
                                viewModel.restoreCart()
                            } else {
                                if (orderResponse?.errorMessage.isNullOrBlank()) {
                                    updateCartId()
                                    returnWithSuccessOrder(orderResponse)
                                    mGiftModelConstant = null
                                    println("AKl://returnWithSuccessOrder in CheckoutFrag ")
//                            setProgressView(View.GONE)
                                } else {
                                    var message = orderResponse?.errorMessage.toString()
                                    checkoutButton.isEnabled = true
                                    if (message.contains("tabby")) {
                                        message = getText(R.string.tabby_error).toString()
                                    }
                                    showCustomTopMessage(
                                        message,
                                        DialogUtil.MessageType.ERROR
                                    )
                                    //{"data":{"placeOrder":{"order":[{"order_number":"5000001375"}],"payment_redirect_url":{"payment_url":"","error":"Transaction Failed, No Payment Link Received becasue of error : tabby_order_amount_too_low","method":"tabby_installments"}}}}
                                    viewModel.restoreCart()
                                }
                            }
                        } else {
                            if (orderResponse?.errorMessage.isNullOrBlank()) {
                                setProgressView(View.GONE)
                                showPaymentScreen(orderResponse)
                            } else {
                                checkoutButton.isEnabled = true
                                showCustomTopMessage(
                                    orderResponse?.errorMessage.toString(),
                                    DialogUtil.MessageType.ERROR
                                )
                                //{"data":{"placeOrder":{"order":[{"order_number":"5000001375"}],"payment_redirect_url":{"payment_url":"","error":"Transaction Failed, No Payment Link Received becasue of error : tabby_order_amount_too_low","method":"tabby_installments"}}}}
                                viewModel.restoreCart()
                            }
                            mGiftModelConstant = null
                        }

                    }
                }
            }
        })
        AdjustTracker.trackEvent(AdjustTracker.CHECK_OUT_EVENT, HashMap())
    }

    private fun recallCheckoutApi() {
         viewModel.getReviewResponse("")
    }

    private fun updateCartId() {
        try {
            println("AKl://updateCartId in CheckoutFrag ")
            try {
                (activity as MainActivity).updateCartCount(0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            mainViewModel?.removeCartIDsFromCache()
//            if(mainViewModel?.isUserLogin()) {
//                mainViewModel.createCartForUser()
//            }else{
//                mainViewModel?.createCartForGuest(null,null,false)
//            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun initActions() {
        openAddAddress = false
        dataLoaded = false
        openLoginOptions = false
        addressID = 0
        Utils.CheckOutAction.action =
            if (viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) Utils.CheckActionType.LOGIN_USER
            else Utils.CheckActionType.UN_LOGIN_USER
    }

    private fun showPaymentScreen(orderResponse: CreateOrderResponse) {
        val nextAction = CheckoutFragmentDirections.orderPayment(orderResponse)
        findNavController().navigate(nextAction)

        /*val nextAction =  AddressesFragmentDirections.orderPayment2(orderResponse)
        findNavController().navigate(nextAction)*/

       /* var args=Bundle()
        args.putParcelable("orderData",orderResponse)
        findNavController().navigate(R.id.action_checkoutFragment_to_paymentFragment,args)*/

    }

    private fun returnWithSuccessOrder(orderResponse: CreateOrderResponse) {
        (activity as MainActivity).clearCart()
       val nextAction =
            CheckoutFragmentDirections.orderSuccessAction(
                orderResponse.orderId.toString(),
                "",
                totalAmount,
                orderResponse.totalUserOrders.toString(),
                true
            )
        findNavController().navigate(nextAction)

       /*var args=Bundle()
        args.putString("orderId",orderResponse.orderId.toString())
        args.putString("deliveryTime","")
        args.putString("amount",totalAmount)
        args.putString("totalUserOrders",orderResponse.totalUserOrders.toString())
        args.putBoolean("paymentStatus",true)
        findNavController().navigate(R.id.action_checkoutFragment_to_cart,args)*/


    }


    private fun checkContinuaOrBack() {
        when {
            (Utils.CheckOutAction.action == Utils.CheckActionType.LOGIN_USER && addressID > 0 && !dataLoaded) ->
                reloadCheckoutData(addressID.toString())

            (Utils.CheckOutAction.action == Utils.CheckActionType.LOGIN_USER && addressID <= 0 && openAddAddress) ->
                findNavController().popBackStack()

            (Utils.CheckOutAction.action == Utils.CheckActionType.LOGIN_USER && addressID <= 0) ->
                addressViewModel.getAddresses()

            (Utils.CheckOutAction.action == Utils.CheckActionType.UN_LOGIN_USER && !openLoginOptions) ->
                navigateToLogin()

            (Utils.CheckOutAction.action == Utils.CheckActionType.UN_LOGIN_USER && openLoginOptions) ->
                findNavController().popBackStack()

            (Utils.CheckOutAction.action == Utils.CheckActionType.ADDRESS_UPDATED && addressID > 0) ->
                reloadCheckoutData(addressID.toString())

            (Utils.CheckOutAction.action == Utils.CheckActionType.NEW_LOGIN) ->
                findNavController().popBackStack()

            (Utils.CheckOutAction.action == Utils.CheckActionType.RELOAD_DATA) ->
                reloadCheckoutData("")

            (Utils.CheckOutAction.action == Utils.CheckActionType.GUEST_USER) ->
                reloadCheckoutData("")
            else ->
                reloadCheckoutData("")


        }
    }

    override fun onResume() {
        super.onResume()
        checkContinuaOrBack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCheckoutReviewLiveData.observe(viewLifecycleOwner, Observer
        {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgressView(View.GONE)
                    animationView.visibility = View.GONE

                    if (mainViewModel?.isExpiredMessage(it?.message.toString())) {
                        mainViewModel?.logoutFun()
                    } else {
                        showCustomTopMessage(
                            it?.message.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                    }
                    val fireBaseLog = ResponseLogOnFireBase
                    fireBaseLog.isGuest = viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)
                    fireBaseLog.userId = viewModel.getUserIdOrGuestUserID()
                    addObjectToFireBase(fireBaseLog, "Pay_Review")
                }
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.SUCCESS -> {
                    setProgressView(View.GONE)
                    animationView.visibility = View.GONE
                    handelAndUpdateData(it, ActionName.REVIEW)
                }
            }
        })

    }

    private fun handleAddressesResponse(addresses: List<AddressRequest>?) {
        if (!addresses.isNullOrEmpty()) {
            val addressId = addresses.filter { it.is_primary.equals("Y", true) }
                .takeIf { it.isNotEmpty() }?.get(0)?.o_address_id

            addressID = addressId?.toInt() ?: addresses[0].o_address_id.toInt()
            // Akl TODO set shipping address
            hideKeyboard()
            if(!go) {
                changeAddress()
            }
//            reloadCheckoutData(addressID.toString())
        } else
            gotoAddAddress()
    }

    private fun gotoAddAddress() {
       val action = CheckoutFragmentDirections.nextAction(
            null,
            isgust = false,
            fromcheckout = true
        )
        findNavController().navigate(action)

      /* var args=Bundle()
        args.putString("address",null)
        args.putBoolean("isgust",false)
        args.putBoolean("fromcheckout",true)
        findNavController().navigate(R.id.action_checkoutFragment_to_destination_addresses,args)*/



    }

    private fun reloadCheckoutData(addressId: String) {
        checkout_views?.visibility = View.GONE
        animationView?.visibility = View.VISIBLE
        viewModel.getReviewResponse(addressId)
    }

    private fun navigateToLogin() {
        val action = CheckoutFragmentDirections.nextLoginOptions(true)
        findNavController().navigate(action)

       /* var args=Bundle()
        args.putBoolean("fromCheckout",true)
        findNavController().navigate(R.id.action_checkoutFragment_to_signin_options,args)*/


    }

    private fun initViewModels() {
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactoryCheckout.create(App.getPref().currentLanguage.toString())
            ).get(CheckoutFragmentViewModel::class.java)
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS =
            com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


//        if (mainViewModel.isUserLogin()) mainViewModel?.getMyWallet()

        mainViewModel.getWalletLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                }
                ResourceState.SUCCESS -> {
                    it?.let {
                        it.data?.let {
                            if (it.status == 1) {
                                it?.mWalletData?.let {
                                    try {
                                        if (it?.avalAmount.isNullOrBlank().not()) {
                                            avalAmount = 100F //it?.avalAmount!!.toFloat()
                                        }
                                    } catch (e: java.lang.Exception) {

                                    }
                                }
                            }
                        }
                    }
                }
                ResourceState.LOADING -> {
                }
            }
        })
        addressViewModel = ViewModelProviders.of(
            this,
            viewModelFactoryAddress.create(App.getPref().currentLanguage.toString())
        ).get(AddressFragmentViewModel::class.java)

        addressViewModel.ENABLE_GRAPH_QUERIES_CALLS =
            com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS

    }

    private fun handelAndUpdateData(it: Resource<ReviewCartResponse>?, mActionName: ActionName) {

        initView()
        setAdapters()
        dataLoaded = true
        animationView?.visibility = View.GONE
        checkout_views?.visibility = View.VISIBLE

        it?.data.let {
            var subtotalWithDiscountExcludingTax = 0f

            if (viewModel?.isShouldShowShippingMethod()!!) {
                shipmentMsgTestView.visibility = View.VISIBLE
            } else {
                shipmentMsgTestView.visibility = View.GONE
            }
            // Total part
            mTotalAdapter =
                CheckOutTotalLabelsAdapter(
                    viewModel.getCurrencyCode(),
                    viewModel.getDecimalNumbers(),
                    it?.notes
                )
            totalRecyclerView.adapter = mTotalAdapter
            //payment Part
            it?.paymentsModel?.let {
                if (mPaymentMethodsAdapter != null) {
                    //TODO Check on the credit amount if it's enough for the order hide all payment methods and show free method
//                    if (totalPrice!=null && avalAmount > totalPrice){
                    var newList = ArrayList<CheckOutPaymentModel>()
                    var freeMethod = getFreeMethod(it)
                    if (freeMethod != null) {
                        newList.add(freeMethod)
                        if (freeMethod.is_selected == 0) {
                            onPaymentMethodSelected(freeMethod)
                        }
                        mPaymentMethodsAdapter!!.setData(newList)
                    } else {
                        mPaymentMethodsAdapter!!.setData(it)
                    }

                }
            }

            // Coupon part
            currentCouponApplayedView.visibility = View.GONE
            couponEditText.clearEditText()
            couponValueTextView.text = ""
            if (it?.couponModel == null && mActionName == ActionName.APPLY_COUPON) {
                showCustomTopMessage(
                    getString(R.string.invalid_coupon),
                    DialogUtil.MessageType.ERROR
                )
            }
            it?.couponModel?.let {
                if (!it.code.isNullOrEmpty()) {
                    if (mActionName == ActionName.APPLY_COUPON) {
                        showCustomTopMessage(
                            getString(R.string.coupon_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                    }
                    couponValueTextView.text = it.code
                    currentCouponApplayedView.visibility = View.VISIBLE
                } else {
                    currentCouponApplayedView.visibility = View.GONE
                    if (mActionName == ActionName.APPLY_COUPON) {
                        showCustomTopMessage(
                            getString(R.string.invalid_coupon),
                            DialogUtil.MessageType.ERROR
                        )
                    }
                }
            }

            // subTotal for countries
            it?.totalsModel?.let {
                it.childTotals.let {
                    if (mSubTotalForCountriesAdapter != null) {
                        mSubTotalForCountriesAdapter!!.setData(it)
                    }
                }


                // order subTotal
                subTotalView.visibility = View.GONE
                it.orderSubtotals?.let {
                    it.let {
                        if (it.labels != null && it.labels!!.isNotEmpty()) {
                            it.labels?.map {
                                if (it.sign.equals("+")) {
                                    subtotalWithDiscountExcludingTax += it?.value!!
                                } else if (it.sign.equals("-")) {
                                    subtotalWithDiscountExcludingTax -= it?.value!!
                                }
                            }
                            subTotalView.visibility = View.VISIBLE
                            if (shouldAddCredit(subtotalWithDiscountExcludingTax!!)) {
                                var creditDiscount = MemoryCacheManager?.walletCredit
                                if (MemoryCacheManager.walletCredit >= subtotalWithDiscountExcludingTax) {
                                    creditDiscount = subtotalWithDiscountExcludingTax
                                }

                                it.labels?.add(
                                    CheckoutLabelModel(
                                        CREDIT_KEY,
                                        creditDiscount,
                                        "",
                                        "-"
                                    )
                                )
                            }
                            if (mSubTotalAdapter != null)
                                mSubTotalAdapter!!.setData(it.labels)
                        } else {
                            subTotalView.visibility = View.GONE
                        }
                    }
                }

                // order Total
                it.orderTotals?.let {
                    it.let {
                        if (it.labels != null && it.labels!!.isNotEmpty()) {

                            var totalCost = 0f
                            for (item in it.labels!!) {
                                if (item.name!!.contains(TOTAL_PRICE_KEY, true)) {
                                    totalCost = item?.value!!.toFloat()
                                    totalAmount = getString(
                                        R.string.currency,
                                        NumbersUtil.formatNumber(
                                            item.value!!.toFloat(),
                                            viewModel.getDecimalNumbers()
                                        ),
                                        viewModel.getCurrencyCode()
                                    )
                                }
                            }
                            if (mTotalAdapter != null)
                                mTotalAdapter!!.setData(it.labels)
                        }

                    }
                }
            }

            //Address
            try {
                it?.addressModel?.let {
                    mCheckOutAddressModel = it
                    val addressBuilder = StringBuilder()
                    if (!it.name.isNullOrEmpty()) {
                        addressBuilder.append(it.name)
                        addressBuilder.append(",\n")
                    }
                    if (!it.country.isNullOrEmpty()) {
                        addressBuilder.append(
                            if (MemoryCacheManager.getCountryNameByCode(it?.country.toString())
                                    .isNullOrBlank()
                            ) {
                                it.country
                            } else {
                                MemoryCacheManager.getCountryNameByCode(it?.country.toString())
                            }
                        )
                        addressBuilder.append(",")
                    }
                    if (!it.city.isNullOrEmpty()) {
                        addressBuilder.append(it.city)
                        addressBuilder.append(",")
                    }
                    if (!it.area.isNullOrEmpty() && it.area.equals(
                            viewModel?.getCountryCode(),
                            true
                        ).not()
                    ) {
                        addressBuilder.append(it.area)
                        addressBuilder.append(",")
                    }
                    cityTextView.text =
                        if (addressBuilder.toString().isNullOrBlank() || addressBuilder.toString()
                                .equals("null", true)
                        ) "" else addressBuilder.toString()
                    addressBuilder.toString()
                    areaTextView.text = if (it.address.isNullOrBlank() || it.address.equals(
                            "null",
                            true
                        )
                    ) "" else it.address
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            //Products
            it?.productsList?.let {
                if (it.isNotEmpty() && mProductsForCountriesAdapter != null) {
                    reviewOrderTitleTextView.visibility = View.VISIBLE
                    mProductsForCountriesAdapter!!.setData(it)
                } else {
                    reviewOrderTitleTextView.visibility = View.GONE
                }
            }

        }

    }

    private fun shouldAddCredit(totalCost: Float): Boolean {
        return (MemoryCacheManager?.walletCredit!! > 0 && totalCost > 0)
    }

    private fun getFreeMethod(it: List<CheckOutPaymentModel>): CheckOutPaymentModel? {
        try {
            it?.map {
                if (it?.code.equals("free", true)) {
                    return it
                }
            }
        } catch (e: java.lang.Exception) {

        }
        return null
    }

    private fun setAdapters() {
        productsRecyclerView.adapter = mProductsForCountriesAdapter
        subTotalRecyclerView.adapter = mSubTotalAdapter
        subTotalForCountriesRecyclerView.adapter = mSubTotalForCountriesAdapter
        paymentRecyclerView.adapter = mPaymentMethodsAdapter
    }

    private fun setProgressView(visible: Int) {
        animationView.visibility = visible
    }


    private fun initView() {
        //Payment method
        mPaymentMethodsAdapter =
            PaymentMethodsAdapter(viewModel.getCurrencyCode(), viewModel.getDecimalNumbers())
        mPaymentMethodsAdapter!!.setListener(this)


        //Coupon action
        couponApplyButton.setSafeOnClickListener {
            hideKeyboard()
            val coupon = couponEditText.text.toString()
            if (!coupon.isNullOrEmpty()) {
                if (coupon.equals(couponValueTextView.text.toString(), true)) {
                    showCustomTopMessage(
                        getString(R.string.used_before),
                        DialogUtil.MessageType.ERROR
                    )

                } else {
                    viewModel.applyCoupon(coupon)
                }
            } else {
                couponEditText.error = getString(R.string.coupon_code)
            }
        }

        removeCouponButton.setSafeOnClickListener {
            viewModel.removeCoupon()
        }


        // SubTotal for countries part
        mSubTotalForCountriesAdapter =
            SubtTotalForCountriesAdapter(viewModel.getCurrencyCode(), viewModel.getDecimalNumbers())

        // subTotal part
        mSubTotalAdapter =
            CheckOutLabelsAdapter(viewModel.getCurrencyCode(), viewModel.getDecimalNumbers())


        //address
        editAddressButton.setSafeOnClickListener {
            hideKeyboard()
            changeAddress()
        }

        // Products
        mProductsForCountriesAdapter =
            ProductsForCountriesAdapter(
                this,
                viewModel.getCurrencyCode(),
                viewModel.getDecimalNumbers(),
                addToWishListResultToAdapter
            )


        // Create Order
        checkoutButton.setSafeOnClickListener {
            hideKeyboard()
            if (paymentMethodSelected != null && (paymentMethodSelected?.id!! > 0 || paymentMethodSelected?.code.isNullOrBlank()
                    .not())
            ) {
                var giftModel = mGiftModelConstant

                checkoutButton.isEnabled = false
//                if (deliveryAsGiftToggle?.isChecked!!)
//                    if (!senderNameEditText.isValid(requireContext())
//                        || !receiverNameEditText.isValid(requireContext())
//                        || !giftMessageEditText.isValid(requireContext())
//                    )
//                        return@setSafeOnClickListener
                var senderName = giftModel?.senderName ?: ""
                var receiverName = giftModel?.receiverName ?: ""
                var message = giftModel?.message ?: ""
                viewModel.createOrder(
                    if (giftModel != null) 1 else 0,
                    senderName,
                    receiverName,
                    message
                )

            } else {
                showCustomTopMessage(
                    getString(R.string.error_message_no_payment_method),
                    DialogUtil.MessageType.ERROR
                )
            }
        }

        deliveryAsGiftToggle?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                giftValueView.visibility = View.VISIBLE
                expand(giftValueView)
            } else {
                collapse(giftValueView)
//                giftValueView.visibility = View.GONE
            }
        }
    }

    private fun changeAddress() {
        if (viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS))
            findNavController().navigate(
                CheckoutFragmentDirections.nextChangeAdress()
            )
        else
            findNavController().navigate(
                CheckoutFragmentDirections.nextAction(
                    null,
                    true
                )
            )

    }

    private fun collapse(v: View) {
        val initialHeight = v.measuredHeight
        val a: Animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                if (interpolatedTime == 1f) {
                    v.visibility = View.GONE
                } else {
                    v.layoutParams.height =
                        initialHeight - (initialHeight * interpolatedTime).toInt()
                    v.requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        // Collapse speed of 1dp/ms
        a.duration = ((initialHeight / v.context.resources.displayMetrics.density).toLong())
        v.startAnimation(a)
    }

    private fun expand(v: View) {
        val matchParentMeasureSpec =
            View.MeasureSpec.makeMeasureSpec((v.parent as View).width, View.MeasureSpec.EXACTLY)
        val wrapContentMeasureSpec =
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
        val targetHeight = v.measuredHeight

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.layoutParams.height = 1
        v.visibility = View.VISIBLE
        val a: Animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                v.layoutParams.height =
                    if (interpolatedTime == 1f) LinearLayout.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
                v.requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        // Expansion speed of 1dp/ms
        a.duration = ((targetHeight / v.context.resources.displayMetrics.density).toLong())
        v.startAnimation(a)
    }

    override fun onPaymentMethodSelected(model: CheckOutPaymentModel) {
        hideKeyboard()
        if (model.id!! > 0 || model.code.isNullOrBlank().not()) {
            animationView.visibility = View.VISIBLE
            viewModel.changePaymentMethod(model.id!!, model?.code)
        }
    }

    override fun onPaymentMethodDefaultSelected(model: CheckOutPaymentModel) {
        this.paymentMethodSelected = model
    }

    enum class ActionName {
        REVIEW,
        APPLY_COUPON
    }


    private fun notifyHomeWithChanges(productID: String, newStatues: Boolean) {
        val intent = Intent(Constants.CHANGE_WISHLIST_CASE)
        intent.putExtra(Constants.PRODUCT_ID, productID)
        intent.putExtra(Constants.NEW_STATEUES, newStatues)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    override fun addToWishList(position: Int, product: Product) {

        if (!product.is_In_WishList) {
            if (mainViewModel.isUserLoginWithOpenLogin()) {
                mainViewModel.addToWishList(
                    if (ENABLE_GRAPH_QUERIES_CALLS) product.product_code
                        ?: "" else product.product_id!!,
                    HashMap(),
                    position,
                    product.product!!
                )
            }
        } else
            mainViewModel.deleteWishListItem(
                HashMap(),
                position,
                if (ENABLE_GRAPH_QUERIES_CALLS) product.product_code
                    ?: "" else product.product_id!!,
                product.product!!
            )
    }

}