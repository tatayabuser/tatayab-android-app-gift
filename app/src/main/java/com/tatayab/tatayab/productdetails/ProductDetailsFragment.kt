package com.tatayab.tatayab.productdetails

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.iid.FirebaseInstanceId
import com.squareup.picasso.Picasso
import com.tatayab.model.OptionsMap
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.model.Variant
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.requests.ProductActionRequest
import com.tatayab.model.responses.ProductDetailsResponse
import com.tatayab.model.responses.ProductReviewsResponse
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.product.ProductDetailsFragmentViewModel
import com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.*
import com.tatayab.tatayab.firebase.FirebaseTrackingManager
import com.tatayab.tatayab.firebase.FirebaseTrackingManager.Companion.add_to_cart
import com.tatayab.tatayab.firebase.FirebaseTrackingManager.Companion.add_to_wishlist
import com.tatayab.tatayab.firebase.FirebaseTrackingManager.Companion.share_product
import com.tatayab.tatayab.firebase.FirebaseTrackingManager.Companion.shop_by_brand
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnOptionListener
import com.tatayab.tatayab.listener.OnProductListener
import com.tatayab.tatayab.util.*
import com.tatayab.tatayab.util.Constants.NEW_STATEUES
import com.tatayab.tatayab.util.Constants.PRODUCT
import com.tatayab.tatayab.util.Constants.PRODUCT_ID
import com.tatayab.tatayab.webview.WebviewActivity
import com.tatayab.tatayab.webview.WebviewActivity.Companion.URL_HOLDER
import kotlinx.android.synthetic.main.add_review_fragment.*
import kotlinx.android.synthetic.main.add_review_sheet.view.*
import kotlinx.android.synthetic.main.cart_dialog.*
import kotlinx.android.synthetic.main.fragment_base_details.*
 import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.fragment_product_details.progress
import kotlinx.android.synthetic.main.item_product_options.view.*
import kotlinx.android.synthetic.main.product_review.*
import kotlinx.android.synthetic.main.toolbar_product_details.*
import kotlinx.android.synthetic.main.toolbar_product_details.iv_back
import javax.inject.Inject


class ProductDetailsFragment : BaseFragment2(), OnProductListener, OnOptionListener, TabbyListener {

    lateinit var viewModel: ProductDetailsFragmentViewModel

    @Inject
    lateinit var viewModelFactory: ProductDetailsFragmentViewModelFactory.Factory

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    private lateinit var mainViewModel: MainActivityViewModel

    private lateinit var alsoBoughtAdapter: AlsoBoughtAdapter
    private lateinit var imagesAdapter: ImagesAdapter

    private var productOptionsAdapter: ProductOptionsAdapter = ProductOptionsAdapter(this)
    private var mTabbyPaymentMethodAdapter: TabbyPaymentMethodAdapter? = null
    private var productSpecificAdapter: ProductSpecificationsAdapter =
        ProductSpecificationsAdapter()

    private var productReviewersAdapter: ProductReviewsAdapter =
        ProductReviewsAdapter()
    private lateinit var options: HashMap<String, String>
    private var hasReviews: Boolean = true
    var isLayoutInflated: Boolean = false

    private val optionItems by lazy {
        arguments?.let {
            ProductDetailsFragmentArgs.fromBundle(
                it
            ).optionItems
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_base_details
    }

    private var productId: String? = null
    private var productUID: String? = null
     private var isComeFromSearch: Boolean = false


    private var product: Product? = null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = HashMap()

        productId = arguments?.let { ProductDetailsFragmentArgs.fromBundle(it).productId } ?: "0"
        productUID = arguments?.let { ProductDetailsFragmentArgs.fromBundle(it).productUID } ?: ""
        product = arguments?.let { ProductDetailsFragmentArgs.fromBundle(it).productObject }

        isComeFromSearch =
            arguments?.let { ProductDetailsFragmentArgs.fromBundle(it).isComeFromSearch }
                ?: false

        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory.create(productId!!, getLangCode())
        ).get(ProductDetailsFragmentViewModel::class.java)
        viewModel.getProductDetails(productUID)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        mTabbyPaymentMethodAdapter = TabbyPaymentMethodAdapter(viewModel.getDecimalNumbers())
        alsoBoughtAdapter = AlsoBoughtAdapter(this, viewModel.getDecimalNumbers())





    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alsoBoughtAdapter = AlsoBoughtAdapter(this, viewModel.getDecimalNumbers())
        mainViewModel.getaddtoWishListresult.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, true)
                        showCustomTopMessage(
                            getString(R.string.add_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        //insertToWishListInCache(it.data?.productID!!)
                        if (it.data?.productPosition!! >= 0)
                            alsoBoughtAdapter.changeWishListState(it.data?.productPosition!!, true)
                        else {
                            btn_favorite.isChecked = true
                            product?.is_In_WishList = true
                            btn_favorite.makeAnimation()
                        }
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

        mainViewModel.getProductAddeddTocartLiveDataa.observe(this, Observer {
            try {
                when (it.status) {
                    ResourceState.ERROR -> {
                        animationView.visibility = View.GONE
                        if (add_to_cart_animi != null) add_to_cart_animi.visibility = View.GONE
                        if (btn_add_to_cart != null) btn_add_to_cart.visibility = View.VISIBLE
                        if (!it.message.isNullOrEmpty())
                            showCustomTopMessage(it.message, DialogUtil.MessageType.ERROR)
                        else
                            showCustomTopMessage(
                                getString(R.string.error_occure),
                                DialogUtil.MessageType.ERROR
                            )

                    }
                    ResourceState.SUCCESS -> {
                        animationView.visibility = View.GONE
                        add_to_cart_animi?.visibility = View.GONE
                        btn_add_to_cart?.visibility = View.VISIBLE
                        if (it.data?.second?.first != null) {
                            opacity_view.visibility = View.VISIBLE
                            dilaog.visibility = View.VISIBLE
                            if (it.data?.second != null) {
                                tv_total_price.text = getString(
                                    R.string.currency,
                                    NumbersUtil.formatNumber(
                                        it.data?.second?.second!!,
                                        viewModel.getDecimalNumbers()
                                    ),
                                    viewModel.getCurrencyCode()
                                )
                                tv_name.text = it.data?.second!!.first.product.toString()
                            }
                            AnimationUtil.springAnimateAddToCart(dilaog)
                        }

                    }
                    else -> {
                        //  animationView.visibility = View.VISIBLE
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

        viewModel.getCartCountLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    progress.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    it.data?.let { it1 -> (activity as MainActivity).updateCartCount(it1) }
                }
                else -> {
                    progress.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getAddNotifyMeLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    add_to_cart_animi?.visibility = View.INVISIBLE
                    btn_add_to_cart?.visibility = View.VISIBLE
                    if (!it?.data?.msg?.trim().isNullOrEmpty())
                        showCustomTopMessage(it.data?.msg.toString(), DialogUtil.MessageType.ERROR)
                    else if (it.throwable is NoConnectivityException)
                        showCustomTopMessage(
                            getText(R.string.no_connection).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                    else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    add_to_cart_animi?.visibility = View.INVISIBLE
                    btn_add_to_cart?.visibility = View.VISIBLE
                    btn_add_to_cart?.isEnabled = false
                    showCustomTopMessage(it?.data?.msg, DialogUtil.MessageType.SUCCESS)
                }
                else -> {
                    add_to_cart_animi?.visibility = View.VISIBLE
                    btn_add_to_cart?.visibility = View.INVISIBLE
                }
            }
        })


        mainViewModel.getRemoveFromWishListLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.success == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, false)
                        if (it.data?.productPosition!! > 0)
                            alsoBoughtAdapter.changeWishListState(it.data?.productPosition!!, false)
                        else {
                            btn_favorite.isChecked = false
                            btn_favorite.makeAnimation()
                            product?.is_In_WishList = false
                            btn_favorite.isChecked = false
                        }
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
                    } else
                        showCustomTopMessage(
                            it.data?.msg,
                            DialogUtil.MessageType.SUCCESS
                        )
                }
                else -> animationView.visibility = View.GONE
            }
        })

        mainViewModel.getAddReviewResponseLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (!it.data?.first?.product_id.isNullOrEmpty()) {
                        hideKeyboard()
                        showCustomTopMessage(
                            getString(R.string.addreviewsuccess),
                            DialogUtil.MessageType.SUCCESS
                        )
                        (it.data?.second as View).ratecomment.setText(" ")
                        (it.data?.second as View).ratingBar.rating = 0f
                    } else
                        showCustomTopMessage(
                            getString(R.string.completedata),
                            DialogUtil.MessageType.ERROR
                        )
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        isLayoutInflated = false

        viewModel.getProductReviewstLiveData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    setupReviewData(it.data)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })


        viewModel.getProductDetailsLiveData().observe(viewLifecycleOwner, Observer {
            //progressStatus(View.GONE)
            when (it.status) {
                ResourceState.ERROR -> {
                    if (!isLayoutInflated)
                        initComponents()

                    animationView.visibility = View.GONE
                    animationView.visibility = View.GONE
                    if (product == null) {
                        error_message.visibility = View.VISIBLE
                        if (it.throwable is NoConnectivityException)
                            error_message.text = getText(R.string.no_connection)
                        refresh.visibility = View.VISIBLE
                        appbar_actions.visibility = View.INVISIBLE
                    }
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    try {
                        it.data?.second?.product_specs?.let { it1 ->
                            productSpecificAdapter.setData(
                                it1,
                                requireContext()
                            )
                        }
                        viewModel.setCurrencyCode(it.data?.second?.currency)
                        it.data?.second?.warehouse?.let {
                            updateShipmentTime(it)
                        }
                        product = Product(
                            product_id = it.data?.second?.productId.toString(),
                            min_qty = it.data?.second?.minQty,
                            amount = it.data?.second?.amount!!,
                            product = it.data?.second?.product,
                            list_price = it.data?.second?.listPrice,
                            price = it.data?.second?.price!!.toFloat(),
                            main_pair = it.data?.second?.mainPair,
                            supplier_id = it.data?.second?.supplierId,
                            supplier_name = it.data?.second?.supplierName,
                            out_of_stock_actions = it.data?.second?.outOfStockActions,
                            product_options = it.data?.second?.productOptions,
                            has_options = it.data?.second?.hasOptions,
                            is_free_delivery = it.data?.second?.isFreeDelivery,
                            full_description = it.data?.second?.fullDescription,
                            is_In_WishList = it.data?.second?.is_In_WishList!!,
                            productLink = it.data?.second?.productLink!!,
                            notes = it.data?.second?.notes,
                            images = it.data?.second?.images,
                            source = it?.data?.second?.source,
                            percent_off = it?.data?.second?.percent_off
                        )
                        val productx =
                            ProductX(
                                title = product?.product,
                                product_id = product?.product_id!!,
                                image = product?.main_pair?.detailed?.https_image_path,
                                price = product?.price ?: 0f,
                                old_price = product?.list_price?.toFloat() ?: 0f,
                                inWishlist = if (product?.is_In_WishList == true) 1 else 0,
                                has_options = if (product?.has_options == true) 1 else 0,
                                discount_perc = product?.percent_off
                                /*NumbersUtil.calculateOffPercent(
                                    product?.price ?: 0f,
                                    product?.list_price?.toFloat() ?: 0f
                                ).toFloat()*/,
                                supplier_id = product?.supplier_id,
                                supplier_name = product?.supplier_name,
                                is_free_delivery = if (product?.is_free_delivery == "Y") 1 else 0,
                                productLink = product?.productLink,
                                can_buy = if (NumbersUtil.isInStock(
                                        product?.out_of_stock_actions,
                                        product?.amount,
                                        product?.min_qty
                                    )
                                ) 1 else 0
                            )



                        addToRecentView(productx)
                        setupViewData(it.data!!.first, product)
                        notifyTheInsider(product)
                        addDataToAdjust(product)

                        product?.let {
                            if(product?.amount == 0){
                                btn_add_to_cart.text=getText(R.string.notfy_me)
                                out_of_stock.visibility=View.VISIBLE
                            }
                        }

                        productx.let {
                            if(productx.can_buy != 1){
                                btn_add_to_cart.text=getText(R.string.notfy_me)
                                out_of_stock.visibility=View.VISIBLE
                            }
                        }

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getAlsoBoughtLiveData().observe(viewLifecycleOwner, Observer {
            //progressStatus(View.GONE)
            when (it.status) {
                ResourceState.ERROR -> {
                    //progressStatus(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    //progressStatus(View.GONE)
                    setupListWithData(it.data)
                }
                else -> {
                    //progressStatus(View.VISIBLE)
                }
            }
        })

        product?.let {
            setupViewData(viewModel.getCurrencyCode(), it)
        }
        viewModel.getProductDetails(productUID)
    }

    private fun updateShipmentTime(it: ProductDetailsResponse.WareHouseModel) {
        try {
            shipmentTimeView.visibility = View.VISIBLE
            delimeterForShipping.visibility = View.VISIBLE
            shippingTimeTextView.text = getDeliveryDate(it?.deli_from.toString() , it?.deli_to.toString())
//                getString(R.string.delivery_part_1).plus(" ").plus(it?.deli_from.toString())
//                    .plus("-").plus(it?.deli_to.toString()).plus(" ").plus(getString(R.string.delivery_part_3))
            shippingFromTextView.text =
                getString(R.string.shipping_from).plus(getCountryName(it?.country_code.toString(), it?.country!!))
            it.image = getCountryFlag(it?.country_code!!)
            if(!it.image.isNullOrBlank()){
//                var imageFullURL = CURRENT_SERVER_URL+it?.image
//                Glide.with(requireActivity())
//                    .load(it.image)
//                    .apply(RequestOptions.circleCropTransform())
//                    .into(shippingCountryIcon)

                try {
                    Picasso.get()
                        .load(it.image)
                        .placeholder(R.drawable.default_image2).into(shippingCountryIcon)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }else{
                shippingCountryIcon.visibility = View.GONE
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun getDeliveryDate(fromDate : String, toDate: String): String {
        var deliveryDate = ""
        try {
            if(fromDate.isNullOrBlank() && toDate.isNullOrBlank().not()){
                deliveryDate =  getString(R.string.delivery_part_1)
                    .plus(" "+toDate)
            } else  if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank()){
                deliveryDate =  getString(R.string.delivery_part_1)
                    .plus(" "+fromDate)
            }else if(fromDate.isNullOrBlank().not() && toDate.isNullOrBlank().not()){
                deliveryDate =  getString(R.string.delivery_part_1)
                    .plus(" "+fromDate).plus(" - ").plus(toDate)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return deliveryDate
    }

    private fun getCountryName(countryCourseCode: String?, defaultCountry: String): String? {
        //					"source_code": "KW-WH"
        var countryCodeSplitList = countryCourseCode?.split("-")
        var countryCode = if(countryCodeSplitList.isNullOrEmpty()) "" else countryCodeSplitList[0]
        MemoryCacheManager?.countriesList?.map {
            if(countryCode.equals(it?.code)){
                return it?.name
            }
        }
        return defaultCountry
    }

    private fun getCountryFlag(countryCourseCode: String): String {
        //					"source_code": "KW-WH"
        var countryCodeSplitList = countryCourseCode?.split("-")
        var countryCode = if(countryCodeSplitList.isNullOrEmpty()) "" else countryCodeSplitList[0]
        MemoryCacheManager?.countriesList?.map {
            if(countryCode.equals(it?.code)){
                return it?.flag!!
            }
        }
        return ""
    }

    private fun initTabbyView() {
        try {
            if (FirebaseConfigUtil.tabbyCountriesList.isNullOrEmpty()) {
                tabby_view.visibility = View.GONE
            } else {
                for (item in FirebaseConfigUtil.tabbyCountriesList) {
                    if (item.country.equals(viewModel?.getCountryCode(), true)) {
                        var contentList = item.content
                        if (!contentList.isNullOrEmpty() && contentList.size >= 0) {
                            tabby_view.visibility = View.VISIBLE
                            mTabbyPaymentMethodAdapter?.setData(
                                contentList,
                                product?.price!!,
                                viewModel.isArabicLangauge(),
                                viewModel.getCurrencyCode(),
                                this
                            )
                        }
                        return
                    } else {
                        tabby_view.visibility = View.GONE
                    }
                }
                tabby_view.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun addDataToAdjust(product: Product?) {
        val params = HashMap<String, String>()
        params[AdjustTracker.product_ID] = product?.product_id.toString()
        params[AdjustTracker.Product_Price] =
            product?.price.toString().plus(" ").plus(viewModel.getCurrencyCode())
        params[AdjustTracker.Currency] = viewModel.getCurrencyCode()
        AdjustTracker.trackEvent(AdjustTracker.VIEW_PRODUCT_EVENT, params)
    }

    private fun setupReviewData(productReviewsResponse: ProductReviewsResponse?) {
        try {
            if (!isLayoutInflated)
                initComponents()

            if (productReviewsResponse?.average_rating != null) {
                reviews_rate.text =
                    NumbersUtil.formatNumber(
                        productReviewsResponse.average_rating?.toFloat() ?: 0f,
                        1
                    )
                        .toString()

                review_count.text = productReviewsResponse.total_reviews.toString().plus(" ")
                    .plus(getText(R.string.review))

            }
            if (productReviewsResponse?.reviews?.size!! > 0) {
                view_more_reviews_title.visibility = View.VISIBLE
                rv_reviews.visibility = View.VISIBLE
                productReviewersAdapter.setData(productReviewsResponse.reviews)
            } else {
                hasReviews = false
                no_reviwers.visibility = View.VISIBLE
                rv_reviews.visibility = View.GONE
                view_more_reviews_title.visibility = View.INVISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun addToRecentView(product: ProductX) {
        val intent = Intent(Constants.CHANGE_RECENT_VIEW)
        val bundle = Bundle()
        bundle.putParcelable(PRODUCT, product)
        intent.putExtras(bundle)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }


    private fun initComponents() {
        try {
            if (!isLayoutInflated) {
                isLayoutInflated = true
                details?.inflate()
            }
            appbar_actions.visibility = View.VISIBLE
            refresh.visibility = View.GONE
            rv_also_bought.layoutManager =
                LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)

            imagesAdapter = ImagesAdapter()
            tab_indicator.setupWithViewPager(vp_images)

            vp_images.pageMargin = 100
            vp_images.adapter = imagesAdapter
            rv_also_bought.adapter = alsoBoughtAdapter

            iv_back.setSafeOnClickListener {
                findNavController().popBackStack()
            }

            refresh.setOnRefreshListener {
                viewModel.getProductDetails(productUID)
                error_message.visibility = View.GONE
                loading.visibility = View.VISIBLE
                refresh.isRefreshing = false
                //    isLayoutInflated= false
            }
            add_comment.setSafeOnClickListener {
                if (mainViewModel.isUserLoginWithOpenLogin()) {
                    (activity as MainActivity).showAddProductReview(
                        productId,
                        productName = product?.product
                    )
                }
            }

            share.setSafeOnClickListener {
                shareTheProduct()
            }
            opacity_view.setSafeOnClickListener {
                Log.d("Opacity", "Opacity Click")
            }

            view_more_reviews_title.setSafeOnClickListener {
                val action =
                    ProductDetailsFragmentDirections.nextReviewslistAction(
                        viewModel.productId,
                        product?.product
                    )
                findNavController().navigate(action)
            }

            if (App.getPref().currentLanguage.toString().equals("ar", true)) {
                vp_images.rotationY = 180F
            }

            btn_add_to_cart.setSafeOnClickListener {
                try {
                    if (btn_add_to_cart.text.toString()
                            .equals(getText(R.string.notfy_me).toString(), true)
                    ) {
                        if (mainViewModel.isUserLoginWithOpenLogin()) {
                            add_to_cart_animi?.visibility = View.VISIBLE
                            btn_add_to_cart?.visibility = View.INVISIBLE
                            FirebaseInstanceId.getInstance().instanceId
                                .addOnCompleteListener(OnCompleteListener { task ->
                                    if (!task.isSuccessful) {
                                        Log.w(
                                            "tokenFirebase",
                                            "getInstanceId failed",
                                            task.exception
                                        )
                                        return@OnCompleteListener
                                    }
                                    // Get new Instance ID token
                                    val token = task.result?.token
                                    token?.let { firebaseToken ->
                                        viewModel.addNotifyMeForProduct(
                                            ProductActionRequest(
                                                country_code = viewModel.getCountryCode(),
                                                lang_code = getLangCode(),
                                                user_id = viewModel.getUserId(),
                                                product_id = product?.product_id,
                                                device_id = getUniqueDeviceID(),
                                                token = firebaseToken,
                                                email = viewModel.getUserEmail()
                                            )
                                        )
                                    }
                                })

                        }
                    } else {
                        if (validateOptions()) {
                            add_to_cart_animi?.visibility = View.VISIBLE
                            btn_add_to_cart?.visibility = View.INVISIBLE
                            product?.let {
                                mainViewModel.addToCart(
                                    product = ProductX(
                                        title = it.product,
                                        product_id = it.product_id!!,
                                        price = it.price,
                                        has_options = if (it.product_options?.size!! > 0) 1 else 0,
                                        source = it?.source
                                    ),
                                    selectedOptions = options
                                )
                                if (isComeFromSearch) {
                                    FirebaseTrackingManager.trackProductDetailsFromSearch(
                                        requireContext(),
                                        productId!!,
                                        add_to_cart
                                    )
                                }
                            }
                        } else
                            return@setSafeOnClickListener
                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            tv_specifications_title.setSafeOnClickListener {
                if (rc_product_specifications.visibility == View.GONE) {
                    rc_product_specifications.visibility = View.VISIBLE
                    tv_specifications_title.setDrawables(end = resources.getDrawable(R.drawable.arrow_up_layer))
                    (rc_product_specifications as View).clearAnimation()
                    val anim = AnimationUtils.loadAnimation(context, R.anim.slide_up)
                    (rc_product_specifications as View).startAnimation(anim)
                } else {
                    rc_product_specifications.visibility = View.GONE
                    tv_specifications_title.setDrawables(end = resources.getDrawable(R.drawable.arrow_down_layer))
                    (rc_product_specifications as View).clearAnimation()
                    val anim = AnimationUtils.loadAnimation(context, R.anim.slide_down)
                    (rc_product_specifications as View).startAnimation(anim)
                }
            }

            review_title.setSafeOnClickListener {
                if (review_group.visibility == View.GONE) {
                    review_group.visibility = View.VISIBLE
                    review_title.setDrawables(end = resources.getDrawable(R.drawable.arrow_up_layer))
                    (rv_reviews as View).clearAnimation()
                    val anim = AnimationUtils.loadAnimation(context, R.anim.slide_up)
                    (rv_reviews as View).startAnimation(anim)
                    if (!hasReviews)
                        no_reviwers.visibility = View.VISIBLE
                    else view_more_reviews_title.visibility = View.VISIBLE

                } else {
                    review_group.visibility = View.GONE
                    review_title.setDrawables(end = resources.getDrawable(R.drawable.arrow_down_layer))
                    (rv_reviews as View).clearAnimation()
                    val anim = AnimationUtils.loadAnimation(context, R.anim.slide_down)
                    (rv_reviews as View).startAnimation(anim)
                    if (!hasReviews)
                        no_reviwers.visibility = View.GONE

                    view_more_reviews_title.visibility = View.GONE


                }

            }

            main_container.setSafeOnClickListener {
                dilaog.visibility = View.GONE
                opacity_view.visibility = View.GONE
            }

            tv_continue_shopping.setSafeOnClickListener {
                opacity_view.visibility = View.GONE
                dilaog.visibility = View.GONE
                main_container.isEnabled = true
            }

            tv_checkout.setSafeOnClickListener {
                (activity as MainActivity).navigatedToCartFragment()
            }

            btn_favorite.setSafeOnClickListener {
                btn_favorite.isChecked = false
                if (mainViewModel.isUserLoginWithOpenLogin()) {
                    if (validateOptions() && product?.product_id != null) {
                        if (product != null && product!!.is_In_WishList) {
                            mainViewModel.deleteWishListItem(
                                product!!.selected_options,
                                -1,
                                productId!!,
                                product?.product!!
                            )
                        } else {
                            mainViewModel.addToWishList(
                                productId!!,
                                convertSelectedOptionToHashMap(),
                                position = -1,
                                productName = product?.product!!
                            )
                            if (isComeFromSearch) {
                                FirebaseTrackingManager.trackProductDetailsFromSearch(
                                    requireContext(),
                                    productId!!,
                                    add_to_wishlist
                                )
                            }
                        }
                    }
                }
            }

            tv_subblier_name?.setSafeOnClickListener {
                goToBrandProducts()
            }

            tv_brand_section?.setSafeOnClickListener {
                goToBrandProducts()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun goToBrandProducts() {
        val nextAction =
            ProductDetailsFragmentDirections.actionDestinationProductdetailsToProductsList(
                "supplier_ids",
                product?.supplier_id.toString(),
                product?.supplier_name,
                Constants.GRAPH_BRANDS_KEY
            )
        findNavController().navigate(nextAction)
        if (isComeFromSearch) {
            FirebaseTrackingManager.trackProductDetailsFromSearch(
                requireContext(),
                productId!!,
                shop_by_brand
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ChooseOptionActivity.START_FORE_RESULT_ID_HOLDER) {
            if (data != null && data.extras != null && data.extras!!.containsKey(
                    ChooseOptionActivity.OPTION_INDEX
                )
            ) {
                handleSelectOption(data)
            }
        }
    }

    private fun handleSelectOption(data: Intent) {
        try {
            val optionIndex = data.extras?.getInt(ChooseOptionActivity.OPTION_INDEX, 0)
            val variantIndex = data.extras?.getInt(ChooseOptionActivity.VARINBT_INDEX, 0)
            productOptionsAdapter.setVariantValue(optionIndex!!, variantIndex!!)
            options[productOptionsAdapter.items?.get(optionIndex)?.option_id!!] =
                productOptionsAdapter.items?.get(optionIndex)?.variants?.get(variantIndex)?.variant_id.toString()
        } catch (e: Exception) {
            val parameters = Bundle().apply {
                this.putString("action", "select_options")
                this.putString("cause", e.toString())
            }
            FirebaseAnalytics.getInstance(requireContext()).logEvent(
                FirebaseAnalytics.Event.SELECT_ITEM,
                parameters
            )
            print(e.toString())
        }
    }

    private fun shareTheProduct() {
        try {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.setType("text/*")
            sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            val shareBody =
                product?.product + "\n" + getString(R.string.solidby) + product?.supplier_name + "\n" + Html.fromHtml(
                    product?.full_description
                ) + "\n \n \n" + product?.productLink
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
            sharingIntent.putExtra(
                android.content.Intent.EXTRA_SUBJECT,
                getString(R.string.sharing_subject)
            )
            startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_using)))
            if (isComeFromSearch) {
                FirebaseTrackingManager.trackProductDetailsFromSearch(
                    requireContext(),
                    productId!!,
                    share_product
                )
            }
        } catch (e: Exception) {
            println("..... error in sharing: " + e.message)
        }
    }


    private fun convertSelectedOptionToHashMap(): Map<String, String> {
        val selectedOptions = HashMap<String, String>()
        options.forEach { it ->
            selectedOptions[it.key] = it.value
        }
        return selectedOptions
    }

    private fun validateOptions(): Boolean {
        for (index in 0 until productOptionsAdapter.itemCount) {
            if (!productOptionsAdapter.items?.get(index)?.isSelected!!) {
                val holder =
                    rc_product_options.findViewHolderForAdapterPosition(index) as ProductOptionsAdapter.ProductViewHolder
                holder.itemView.option_title.text =
                    holder.itemView.option_title.text.toString().removeSuffix("*").plus("*")
                holder.itemView.option_title.setTextColor(resources.getColor(R.color.red))
                holder.itemView.option_title.animation =
                    AnimationUtils.loadAnimation(context, R.anim.pop_enter_slide_up)

                scroll_container.post {
                    scroll_container.scrollTo(0, rc_product_options.top)
                    holder.itemView.animation =
                        AnimationUtils.loadAnimation(context, R.anim.pop_enter_slide_up)
                    holder.itemView.setBackgroundColor(resources.getColor(R.color.focia))
                    scroll_container.postDelayed(
                        {
                            holder.itemView.setBackgroundColor(resources.getColor(R.color.white))
                        }, 300
                    )
                    // rc_product_options.scrollToPosition(index)
                }
                return false
            }
        }
        return true
    }


    private fun setupListWithData(data: Pair<String, ProductsListResponse>?) {
        if (!isLayoutInflated)
            initComponents()

        if (data?.second?.products.isNullOrEmpty()) {
            customer_group.visibility = View.GONE
        } else {
            customer_group.visibility = View.VISIBLE
            alsoBoughtAdapter.setData(data!!.first, data.second.products!!)
        }
    }


    private fun setupViewData(currencyCode: String, data: Product?) {

        if (!isLayoutInflated)
            initComponents()
        refresh.visibility = View.GONE

        tv_subblier_name?.text = data?.supplier_name
        tv_product_name.text = data?.product
        rc_product_options.adapter = productOptionsAdapter
        rv_reviews.adapter = productReviewersAdapter
        rc_product_specifications.adapter = productSpecificAdapter
        btn_favorite.isChecked = product?.is_In_WishList!!
        tv_brand_section.text = resources.getString(R.string.shop_brand, data?.supplier_name)
        //tabby recycler view
        tabby_recycler_view?.adapter = mTabbyPaymentMethodAdapter

        imagesAdapter.setData(data?.images)
        data?.full_description?.let {
            tv_product_details.text = Html.fromHtml(it)
        }
        if (!product?.notes?.trim().isNullOrEmpty())
            tv_notes.text = "( " + product?.notes + " )"
        data.let { product ->
            product?.product_options?.let { productOptions ->
                if (productOptions.isNotEmpty()) {
                    if (options.isEmpty()) {
                        productOptionsAdapter.setData(
                            productOptions,
                            convertOptionsToMap(optionItems)
                        )
                        options = convertOptionsToMap(optionItems) as HashMap<String, String>
                    } else
                        productOptionsAdapter.setData(productOptions, options)

                    rc_product_options.visibility = View.VISIBLE
                } else {
                    productOptionsAdapter.setData(arrayListOf())
                    rc_product_options.visibility = View.GONE
                }
            }
            product?.out_of_stock_actions?.let { outOfStock ->
                if (!NumbersUtil.isInStock(outOfStock, product.amount, product.min_qty)) {
                    btn_add_to_cart.text = getText(R.string.notfy_me)
                    out_of_stock.visibility = View.VISIBLE
                } else {
                    btn_add_to_cart.text = getText(R.string.add_to_cart)
                }
            } ?: run {
                btn_add_to_cart.text = getText(R.string.add_to_cart)
            }

            // check free delivery
            if (product?.is_free_delivery == "Y") {
                tv_free_delivery.visibility = View.VISIBLE
            } else {
                tv_free_delivery.visibility = View.GONE
            }
            if (NumbersUtil.hasPriceOff(
                    product?.price?.toFloat() ?: 0f,
                    product?.list_price?.toFloat() ?: 0f
                )
            ) {
                tv_price_off.visibility = View.VISIBLE
                var discountPer = product?.percent_off?.toInt()
                tv_price_off.text = getString(R.string.off).plus(" "+discountPer.toString()).plus("%")

                /*tv_price_off.text = getStringLocale(
                    R.string.off,product?.percent_off
                    NumbersUtil.calculateOffPercent(
                        product?.price?.toFloat() ?: 0f,
                        product?.list_price?.toFloat() ?: 0f
                    )
                )*/
                tv_product_price.setTextColor(resources.getColor(R.color.red))

                tv_old_price.visibility = View.VISIBLE
                tv_old_price.text =
                    getString(
                        R.string.currency,
                        NumbersUtil.formatNumber(
                            product?.list_price!!.toFloat(),
                            viewModel.getDecimalNumbers()
                        ),
                        currencyCode
                    )
            } else {
                tv_price_off.visibility = View.GONE
                tv_old_price.visibility = View.INVISIBLE
                tv_product_price.setTextColor(resources.getColor(R.color.dark_blue))
            }

            tv_product_price.text =
                getString(
                    R.string.currency, NumbersUtil.formatNumber(
                        product?.price!!.toFloat(),
                        viewModel.getDecimalNumbers()
                    ), currencyCode
                )
            initTabbyView()
            //itemView.tv_Product_name.text = product.product
            activity?.let {
                try {
                    Picasso.get()
                        .load(product.main_pair?.detailed?.https_image_path)
                        .placeholder(R.drawable.default_image2).into(iv_product_img)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
//                Glide.with(it)
//                    .load(product.main_pair?.detailed?.https_image_path).apply(getPlaceholder())
//                    .into(iv_product_img)
            }
        }
    }

    private fun convertOptionsToMap(optionItems: Array<OptionsMap>?): Map<String, String>? {

        val resultMap: MutableMap<String, String>? = mutableMapOf()
        optionItems?.forEach {
            resultMap?.set(it.optionId, it.variantId)
        }
        return resultMap
    }


    override fun onProductSelected(productId: String) {

        val nextAction =
            ProductDetailsFragmentDirections.actionDestinationProductdetailsSelf(
                productId,productUID,
                null,
                isComeFromSearch
            )
        view?.let {
            findNavController().navigate(nextAction)
        }


    }

    override fun addToWishlist(position: Int, product: Product) {
        try {
            if (mainViewModel.isUserLoginWithOpenLogin()) {
                if (!product.is_In_WishList)
                    mainViewModel.addToWishList(
                        product_id = product.product_id!!,
                        position = position, productName = product.product!!
                    )
                else
                    mainViewModel.deleteWishListItem(
                        options = mapOf(),
                        productID = product.product_id!!,
                        index = position,
                        productName = product.product!!
                    )
            }
            else {
                showCustomTopMessage(
                    getText(R.string.loginfirst).toString(),
                    DialogUtil.MessageType.ERROR
                )            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onAddToCart(product: ProductX) {
        mainViewModel.addToCart(
            product = product
        )
    }

    override fun onOptionItemClick(optionIndex: Int, optionName: String, variants: List<Variant>) {
        startActivityForResult(
            ChooseOptionActivity.getInstance(
                requireActivity(),
                variants as ArrayList<Variant>,
                product?.product!!,
                product?.main_pair?.detailed?.image_path!!,
                product?.supplier_name!!,
                optionName,
                optionIndex
            ),
            ChooseOptionActivity.START_FORE_RESULT_ID_HOLDER
        )
    }


    private fun notifyHomeWithChanges(productID: String, newStatues: Boolean) {
        val intent = Intent(Constants.CHANGE_WISHLIST_CASE)
        intent.putExtra(PRODUCT_ID, productID)
        intent.putExtra(NEW_STATEUES, newStatues)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    private fun notifyTheInsider(it: Product?) {
        try {
            it?.let {
                InsiderManager.openProductDetails(
                    it.product_id,
                    it.product,
                    arrayOf(it.product!!),
                    it.main_pair?.detailed?.https_image_path,
                    it.price.toDouble(),
                    viewModel.getCurrencyCode()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSeeMoreClicked(url: String) {
        val mIntent = Intent(activity, WebviewActivity::class.java)
        mIntent.putExtra(URL_HOLDER, url)
        startActivity(mIntent)
    }

}

