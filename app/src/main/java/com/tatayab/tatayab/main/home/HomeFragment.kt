package com.tatayab.tatayab.main.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.common.collect.Iterables.skip
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.model.ShareCartListModel
import com.tatayab.model.TrendAction
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.home.ViewTypeLayout
import com.tatayab.presentation.Utils.Companion.DEEP_LINK_URI
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.main.home.HomeFragmentViewModel
import com.tatayab.presentation.main.home.HomeFragmentViewModelFactory
import com.tatayab.presentation.product.Constants
import com.tatayab.presentation.product.Constants.FLASH_SALE
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.BuildConfig
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.deeplink.DeepLinkActivity
import com.tatayab.tatayab.deeplink.DeeplinkConstants
import com.tatayab.tatayab.deeplink.DeeplinkEnum
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.*
import com.tatayab.tatayab.main.cart.SharedCartActivity
import com.tatayab.tatayab.main.home.adapter.BlocksAdapter
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import com.tatayab.tatayab.util.Constants.CHANGE_RECENT_VIEW
import com.tatayab.tatayab.util.Constants.CHANGE_WISHLIST_CASE
import com.tatayab.tatayab.util.Constants.CLEAR_RECENT_VIEW
import com.tatayab.tatayab.util.Constants.GRAPH_BRANDS_KEY
import com.tatayab.tatayab.util.Constants.GRAPH_CATEGORY_ID_KEY
import com.tatayab.tatayab.util.Constants.GRAPH_CATEGORY_UID_KEY
import com.tatayab.tatayab.util.Constants.NEW_STATEUES
import com.tatayab.tatayab.util.Constants.PRODUCT
import com.tatayab.tatayab.util.Constants.PRODUCT_ID
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar_home.*
import timber.log.Timber
import javax.inject.Inject


class HomeFragment : BaseFragment2(), OnTrendListener,
    OnCategoryListenerInHome, OnProductListenerInHome, OnSupplierListener,
    OnSeeMoreSupplierListener,
    OnSeeMoreCategoryListener, OnConciergeListener {
    private var currentAdapter: ProductsAdapter? = null
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var mainViewModel: MainActivityViewModel
    private var isFavoriteIconEvent: Boolean = false

    @Inject
    lateinit var viewModelFactory: HomeFragmentViewModelFactory.Factory
    private lateinit var blocksAdapter: BlocksAdapter

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    private lateinit var linearManager: LinearLayoutManager
    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onResume() {
        super.onResume()
        isFavoriteIconEvent = false
        FirebaseInAppMessaging.getInstance().isAutomaticDataCollectionEnabled = true
        FirebaseInAppMessaging.getInstance().triggerEvent("Home_Event")
        LocalBroadcastManager.getInstance(requireContext())
            .registerReceiver(changeWishListBroadcastReceiver, IntentFilter(CHANGE_WISHLIST_CASE))

        LocalBroadcastManager.getInstance(requireContext())
            .registerReceiver(addToRecentViewBroadcastReceiver, IntentFilter(CHANGE_RECENT_VIEW))

        FirebaseAnalytics.getInstance(requireContext()).logEvent("HomeStart", Bundle())
        if (!mainViewModel.blocksItems.isNullOrEmpty()) {
            mainViewModel?.updateRecentViewItem()
            viewModel.updateRecentViewBlock()
        }

        if (!MemoryCacheManager.getMainBundel().isEmpty) {
            println("Akl/ onResume/")
            for (key in MemoryCacheManager.getMainBundel().keySet()) {
                println("Akl/ " + key + " = " + MemoryCacheManager.getMainBundel().getString(key))
            }
            handelIntent(MemoryCacheManager.getMainBundel())
        }

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            InsiderManager.visitHomePage()
            if (DEEP_LINK_URI != null && !TextUtils.isEmpty(DEEP_LINK_URI.toString())) {
                println("... Adjust tracking / Deep link URL/home page: $DEEP_LINK_URI")
                val intent = Intent(activity, DeepLinkActivity::class.java)
                intent.data = DEEP_LINK_URI
                startActivity(intent)
                DEEP_LINK_URI = null
                println("... Adjust tracking / Deep link URL/home/null/ page: $DEEP_LINK_URI")
                activity?.finish()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        if (!mainViewModel.blocksItems.isNullOrEmpty()) {
            mainViewModel.getHomeBlocks()
        }
//        mainViewModel.getBlocksItemsLiveData.observe(this, Observer {
//            when (it.status) {
//                ResourceState.ERROR -> {
//                  }
//                ResourceState.SUCCESS -> {
//                    if(mainViewModel.blocksItems.isNullOrEmpty().not())viewModel?.updateBlocks(mainViewModel.blocksItems!!)
//                             viewModel?.getBlocksData()
//                }
//                else -> {
//                  }
//            }
//        })
        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        viewModel =
            ViewModelProviders.of(
                requireActivity(),
                viewModelFactory.create(
                    mainViewModel.blocksItems?.toTypedArray(),
                    App.getPref().currentLanguage.toString()
                )
            ).get(HomeFragmentViewModel::class.java)

        mainViewModel?.checkTokenValidation()

        mainViewModel?.getCheckTokenLiveData?.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                 }
                ResourceState.SUCCESS -> {
                    it?.data.let{
                        if(it == false){
                            mainViewModel?.logoutFun()
                        }
                    }
                  }
                else -> {
                 }
            }
        })

       /* mainViewModel?.getLogoutLiveData().observe(this, Observer {
            try {
                (activity as MainActivity).updateCartCount(0)
                showLoginDialog()
            }catch (e:Exception){
                e.printStackTrace()
            }
         })*/
        mainViewModel?.getCreateCartForUserLiveData?.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
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
                        Toast.makeText(context, getText(R.string.added_to_cart), Toast.LENGTH_SHORT)
                            .show()
                        notifyTheInsider(it)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })


        viewModel?.getUpdateRecentBlockLiveData.observe(this) {
            updateRecentView()
        }
        viewModel.getBlocksItemsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    it.data?.let { pairBlockList ->
                        setupViewData(viewModel.getCurrencyCode(), pairBlockList)
                    }
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

        viewModel.getBlockLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    it.data?.let { compositeBlockItemt ->
                        if (compositeBlockItemt.type == FLASH_SALE)
                            mainViewModel.startFlashTime(compositeBlockItemt.flashEndTime.toLong())
                        //updateTimeForFlash(compositeBlockItemt.flashEndTime.toLong())
                        blocksAdapter.setItemData(compositeBlockItemt)
                    }
                }
                else -> {
                    setProgress(View.VISIBLE)
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

                    if (it.data?.success!! == 1) {
                        Toast.makeText(
                            context,
                            getText(R.string.add_wishlist_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        currentAdapter?.changeFav(it.data?.productPosition!!, true)
                        it.data?.let { wishListResponse ->
                            try {
                                val params = HashMap<String, Any>()
                                params["product_name"] = wishListResponse.categoryName
                                params["product_id"] = wishListResponse.productID
                                params["category_id"] = wishListResponse.categoryId
                                params["category_name"] = wishListResponse.categoryName
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.add_to_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }


                    } else
                        Toast.makeText(
                            context,
                            it.data?.msg!!,
                            Toast.LENGTH_SHORT
                        ).show()

                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        mainViewModel.getRemoveFromWishListLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    setProgress(View.VISIBLE)
                }
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it.data?.success == 1 && isFavoriteIconEvent) {
                        currentAdapter?.changeFav(it.data?.productPosition!!, false)
                        Toast.makeText(
                            context,
                            getText(R.string.remove_wishlist_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        it.data?.let { wishlistResponse ->
                            try {
                                val params = HashMap<String, Any>()
                                params["product_name"] = wishlistResponse.categoryName
                                params["product_id"] = wishlistResponse.productID
                                params["category_id"] = wishlistResponse.categoryId
                                params["category_name"] = wishlistResponse.categoryName
                                InsiderManager.sendCustomEvent(
                                    InsiderManager.CustomEvent.remove_from_fav.toString(),
                                    params
                                )
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
                else -> setProgress(View.GONE)
            }
        })

        blocksAdapter = BlocksAdapter(
            this,
            this,
            this,
            this,
            this,
            this,
            mainViewModel.getFlashTimeLiveData,
            viewModel.getDecimalNumbers(),
            this
        )

        blocksAdapter.setData(viewModel.getCurrencyCode(), viewModel.blocksItems?.toList())
    }

    private fun notifyTheInsider(it: Resource<Pair<Boolean, Pair<Product, Float>>>?) {
        try {
            it?.data?.second?.first?.let {
                InsiderManager.addProductToCart(
                    it.product_id,
                    it.product,
                    arrayOf(it.product!!),
                    it.imageLocalForInsider,
                    it.price.toDouble(),
                    viewModel.getCurrencyCode()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onTrendSelected(trendUrl: String?, title: String?) {
        try {
            val trendAction: TrendAction? = TrendAction()
            //https://www.tatayab.com/Suppliers/1939/Oud Lover

            if (trendUrl.isNullOrBlank()) return
            if (trendUrl.contains("tatayab.com")) {
//                val finalUrl = trendUrl?.replace("https://www.tatayab.com/", "")
                 val separated = trendUrl?.split("/")

                if (separated != null) {
                    if (separated.size >= 3) {
                        trendAction?.actionSenderId = separated[4]
                        trendAction?.actionSenderName = separated[3]
                    }
                }
            } else if (trendUrl.startsWith("http") && !trendUrl.contains("tatayab.com")) {
                //http://categories/33/
                var newUrl = trendUrl
                if(newUrl.endsWith("/").not()){
                    newUrl += "/"
                }
                val urlAfterRemoveHttp = newUrl?.replace("http://", "")
                val finalUrl = urlAfterRemoveHttp?.replace("https://", "")
                val separated = finalUrl?.split("/")

                if (separated != null) {
                    if (separated.size >= 3) {
                        trendAction?.actionSenderId = separated[1]
                        trendAction?.actionSenderName = separated[2]
                    }
                }
            }
            if (trendAction?.actionSenderId.isNullOrBlank().not()) {
                when {
                    trendUrl.contains("categories", true) -> {
                        var graphKey = GRAPH_CATEGORY_UID_KEY
                        if (trendAction?.actionSenderId!!.isDigitsOnly()) {
                            graphKey = GRAPH_CATEGORY_ID_KEY
                        }
                        val nextAction = HomeFragmentDirections.nextProductList(
                            "cid",
                            trendAction?.actionSenderId.toString(),
                            if (!title.isNullOrEmpty()) title else trendAction?.actionSenderName,
                            graphKey
                        )

                        view?.let {
                            findNavController().navigate(nextAction)
                        }
                    }

                    trendUrl.contains("products", true) -> {
                        val nextAction = HomeFragmentDirections.nextProductDetails(
                            trendAction?.actionSenderId.toString()
                        )
                        view?.let {
                            findNavController().navigate(nextAction)
                        }
                    }
                    trendUrl.contains("suppliers", true) -> { /// 3 for suppliers
                        val nextAction = HomeFragmentDirections.nextProductList(
                            "supplier_ids",
                            trendAction?.actionSenderId.toString(),
                            if (!title.isNullOrEmpty()) title else trendAction?.actionSenderName,
                            GRAPH_BRANDS_KEY
                        )
                        view?.let {
                            findNavController().navigate(nextAction)
                        }
                    }
                    trendUrl.contains("supplier", true) -> { /// 3 for suppliers
                        val nextAction = HomeFragmentDirections.nextProductList(
                            "supplier_ids",
                            trendAction?.actionSenderId.toString(),
                            if (!title.isNullOrEmpty()) title else trendAction?.actionSenderName,
                            GRAPH_BRANDS_KEY
                        )
                        view?.let {
                            findNavController().navigate(nextAction)
                        }
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            Timber.d("TrendParse Exception$e")
        }
    }


    private fun setupViewData(currencyCode: String, data: List<CompositeBlockItem>?) {
        blocksAdapter.setData(currencyCode, data)
    }

    override fun onSupplierSelected(supplierId: String, supplierName: String) {
        val nextAction =
            HomeFragmentDirections.nextProductList(
                "supplier_ids",
                supplierId,
                supplierName,
                GRAPH_BRANDS_KEY
            )
        view?.let {
            findNavController().navigate(nextAction)
        }
    }

    override fun seeMoreSupplier() {
        findNavController().navigate(HomeFragmentDirections.nextSupplier())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkCachTime()
//        if (!MemoryCacheManager.getMainBundel().isEmpty) {
//            handelIntent(MemoryCacheManager.getMainBundel())
//            println("Akl/ onViewCreated/")
//            for (key in MemoryCacheManager.getMainBundel().keySet()) {
//                println("Akl/ "+key+" = "+MemoryCacheManager.getMainBundel().getString(key))
//
//            }
//        }
        if (!MemoryCacheManager.getReferFriendUrl().isNullOrEmpty()) {
            handleReferFriend(MemoryCacheManager.getReferFriendUrl())
        }
        if (MemoryCacheManager.getShareCartModel() != null) {
            handleShareCartDeeplink(MemoryCacheManager.getShareCartModel())
        }
        tv_search.setSafeOnClickListener {
            findNavController().navigate(R.id.search)
        }

        logoImageView.setSafeOnClickListener {
            if (BuildConfig.DEBUG) {
//                startActivity(Intent(activity, DeveoperSettingsActivity::class.java))
                mainViewModel?.getCountryCurrency()
            }
        }
        try {
            if (rv_blocks != null) {
                linearManager = LinearLayoutManager(activity)
                linearManager.orientation = RecyclerView.VERTICAL
                rv_blocks.layoutManager = linearManager
                //   rv_blocks.isNestedScrollingEnabled = false
                //   rv_blocks.setHasFixedSize(true)
                rv_blocks.adapter = blocksAdapter
//                rv_blocks.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                        super.onScrolled(recyclerView, dx, dy)
//                        val lastPosition =
//                            (rv_blocks.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
//                        if (!blocksAdapter.getItems?.get(lastPosition)?.isLoaded!! && !blocksAdapter.getItems?.get(
//                                lastPosition
//                            )?.isLoadedNow!!
//                        ) {
////                            viewModel.getHomeBlock(
////                                blocksAdapter.getItems?.get(lastPosition)!!,
////                                lastPosition
////                            )
////                            blocksAdapter.getItems?.get(lastPosition)?.isLoadedNow = true
//                        }
//                    }
//
//                })
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.d("onHomeScroll$e.")
        }

//        mainViewModel.getPromotion()

    }

    private fun handleShareCartDeeplink(shareCartModel: ShareCartListModel?) {
        try {
            if (!shareCartModel?.products.isNullOrEmpty()) {
                if (viewModel?.getCountryCode().equals(shareCartModel?.countryCode, true)) {
                    startActivity(Intent(activity, SharedCartActivity::class.java))
                } else {
                    showCustomTopMessage(
                        getString(R.string.share_cart_with_different_country_error).plus(" " + shareCartModel?.countryCode),
                        DialogUtil.MessageType.ERROR
                    )
                    MemoryCacheManager.addShareCartModel(null)
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun handleReferFriend(deepLinkPath: String?) {
        try {
            if (!deepLinkPath.isNullOrEmpty()) {
                var intent = Intent(activity, ReferFriendSuccessActivity::class.java)
                intent.putExtra(
                    ReferFriendSuccessActivity.INVITATION_URL_HOLDER,
                    deepLinkPath
                )
                startActivity(intent)
                MemoryCacheManager.addReferFriendUrl("")
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    override fun onCategorySelected(
        categoryId: String,
        categoryName: String
    ) {
        var key = GRAPH_CATEGORY_UID_KEY
        if(categoryId?.isDigitsOnly() == true){
            key = GRAPH_CATEGORY_ID_KEY
        }
        val nextAction =
            HomeFragmentDirections.nextProductList(
                "cid",
                categoryId,
                categoryName,
                key
            )
        view?.let {
            findNavController().navigate(nextAction)
        }
    }


    override fun onProductSelected(
        productId: String,
        mProductx: ProductX?,
        productsAdapter: ProductsAdapter
    ) {
        try {
            currentAdapter = productsAdapter
            val mProduct = if (mProductx == null) {
                null
            } else {
                convertProductxToProduct(mProductx)
            }
            val nextAction = HomeFragmentDirections.nextProductDetails(
                productId,
                mProductx?.uid.toString(),
                mProduct
            )
            findNavController().navigate(nextAction)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onProductSelected(productId: String, productsAdapter: ProductsAdapter) {

    }

    private fun convertProductxToProduct(mProductx: ProductX): Product? {
        var mProduct: Product? = null
        try {
            val images = ArrayList<String>()
            mProductx?.let {
                images.add(it?.image!!)
                mProduct = Product(
                    product_id = it.product_id,
                    product = it.title,
                    price = it.price!!.toFloat(),
                    supplier_id = it.supplier_id,
                    supplier_name = it.supplier_name,
                    has_options = it.has_options != null && it?.has_options > 0,
                    is_free_delivery = if (it.is_free_delivery != null && it.is_free_delivery == 1) "Y" else "N",
                    is_In_WishList = it.inWishlist != null && it?.inWishlist == 1,
                    productLink = it.productLink,
                    images = images,
                    uid = it?.uid
                )
            }
            return mProduct
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null

    }

    override fun onSeeMoreProduct(type: String, categoryId: String?, categoryName: String?) {
        var key = GRAPH_CATEGORY_UID_KEY
        if (categoryId?.isDigitsOnly() == true) {
            key = GRAPH_CATEGORY_ID_KEY
        }
        val nextAction =
            HomeFragmentDirections.nextProductList(
                type,
                categoryId,
                categoryName, key
            )
        view?.let {
            findNavController().navigate(nextAction)
        }
    }


    override fun addToWishlist(position: Int, product: ProductX, productsAdapter: ProductsAdapter) {
        if (mainViewModel.isUserLoginWithOpenLogin()) {
            currentAdapter = productsAdapter
            mainViewModel.addToWishList(
                product_id = product.product_id,
                position = position,
                productName = product.title!!
            )
        }
    }

    override fun removeFromWishlist(
        position: Int,
        product: ProductX,
        productsAdapter: ProductsAdapter
    ) {
        isFavoriteIconEvent = true
        if (mainViewModel.isUserLoginWithOpenLogin()) {
            mainViewModel.deleteWishListItem(
                null, position, product.product_id, productName = product.title!!
            )
        }
    }


    override fun onAddToCart(product: ProductX, amount: Int, maxQty: Int, image: ImageView?) {
        mainViewModel.addToCart(product)
    }


    override fun seeMoreCategory() {
        (activity as MainActivity).navigatedToCategoryFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(requireContext())
            .unregisterReceiver(changeWishListBroadcastReceiver)
        LocalBroadcastManager.getInstance(requireContext())
            .unregisterReceiver(addToRecentViewBroadcastReceiver)
    }

    private val changeWishListBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            val bundle = intent?.extras
            val productId = bundle?.getString(PRODUCT_ID)
            val newCase = bundle?.getBoolean(NEW_STATEUES, false)
            blocksAdapter.changeWishlist(productId.toString(), newCase!!)
            Timber.d(productId.toString())
        }
    }

    private val addToRecentViewBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            val bundle = intent?.extras
            val product = bundle?.getParcelable<ProductX>(PRODUCT)
            val clearAction = bundle?.getBoolean(CLEAR_RECENT_VIEW, false)
            if (clearAction!!)
                removeRecentViewItem()

            product?.let {
                addToRecentView(
                    product = it
                )
            }
        }
    }


    private fun updateRecentView() {
        try {
             blocksAdapter.items?.forEach { copositItem ->
                if (copositItem.sectionName == Constants.RECENT_VIEW) {
                    var recentView = copositItem.productsResponse?.products as ArrayList<ProductX>
                    copositItem.productsResponse?.products  = recentView
                    blocksAdapter.notifyItemChanged(blocksAdapter.items?.indexOf(copositItem)!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun addToRecentView(
        product: ProductX
    ) {
        var isExists = false
        blocksAdapter.items?.forEach { copositItem ->
            if (copositItem.sectionName == Constants.RECENT_VIEW) {
                isExists = true
                if (copositItem.isLoaded) {
                    var recentView = copositItem.productsResponse?.products as ArrayList<ProductX>
                    if (!checkIfRecentListContainProduct(recentView, product))
//                    if (!(copositItem.productsResponse?.products as ArrayList<*>).contains(
//                            product
//                        ))
                    {
                        (copositItem.productsResponse?.products as ArrayList<ProductX>).add(
                            0,
                            product
                        )
                        if ((copositItem.productsResponse?.products as ArrayList<*>).size > Constants.RECENT_MAX_ITEMS_IN_HOME) {
                            copositItem.catId = 1
                            (copositItem.productsResponse?.products as ArrayList<ProductX>).subList(
                                0,
                                Constants.RECENT_MAX_ITEMS_IN_HOME - 1
                            )
                        }
                        blocksAdapter.notifyItemChanged(blocksAdapter.items?.indexOf(copositItem)!!)
                    }
                } else {
                    copositItem.pid = product.product_id.plus(",").plus(copositItem.pid)
                }
            }
        }

        if (!isExists) {
            val compositeBlockItem = CompositeBlockItem()
            compositeBlockItem.viewTypeLayout = ViewTypeLayout.SLIDE_TWO
            compositeBlockItem.pid = product.product_id
            compositeBlockItem.sectionName = Constants.RECENT_VIEW
            blocksAdapter.items?.add(compositeBlockItem)
            blocksAdapter.notifyDataSetChanged()
            blocksAdapter.items?.indexOf(compositeBlockItem)?.let {
//                viewModel.getHomeBlock(
//                    compositeBlockItem,
//                    it
//                )
            }
        }

    }

    private fun checkIfRecentListContainProduct(
        recentView: java.util.ArrayList<ProductX>,
        product: ProductX
    ): Boolean {
        if (recentView.isNullOrEmpty()) return false
        recentView?.map {
            if (it.product_id.isNullOrBlank().not() && it?.product_id.equals(
                    product?.product_id,
                    true
                )
            ) {
                return true
            }
        }

        return false
    }

    fun handelIntent(bundle: Bundle?) {
        try {
            if (bundle != null) {
                if (bundle.containsKey("categoryId")) {
                    val categoryId = bundle.getString("categoryId")
                    val categoryType = bundle.getString("categoryType")
                    val categoryName = bundle.getString("categoryName")

                    if (categoryId != null && categoryType != null && categoryName != null) {
                        if (categoryType?.contains("supplier", true)) {
                            openProductListforSupplier(categoryType, categoryId, categoryName)
                        } else {
                            openProductList(categoryType, categoryId, categoryName)
                        }
                    }
                } else if (bundle.containsKey("productId")) {
                    val productId = bundle.getString("productId")
                    if (productId != null) {
                        openProductDetails(productId)
                    }
                } else if (bundle.containsKey("url")) {
                    var url = bundle.getString("url")
                    if (isDeeplinkContainsLocalLogic(url.toString())) {
                        handleDeeplinkLocal(url.toString())
                    }
                } else if (bundle.containsKey(DeeplinkConstants.DEEPLINK_TYPE_HOLDER)) {
                    val deeplinkType = bundle.getString(DeeplinkConstants.DEEPLINK_TYPE_HOLDER)
                    if (deeplinkType.equals(DeeplinkConstants.CART_TYPE_HOLDER)) {
                        openMyCart()
                    }
                    if (viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                        if (deeplinkType.equals(DeeplinkConstants.ORDER_TYPE_HOLDER)) {
                            var orderID = bundle.getString(DeeplinkConstants.ORDER_ID_HOLDER)
                            openMyOrder(orderID)
                        } else if (deeplinkType.equals(DeeplinkConstants.WALLET_TYPE_HOLDER)) {
                            openMyWallet()
                        }
                    }

                }

                MemoryCacheManager.addMainBundel(Bundle())
            }

        } catch (e: Exception) {
            base_progress?.visibility = View.GONE
            e.printStackTrace()
        }
    }

    fun isDeeplinkContainsLocalLogic(deepLink: String): Boolean {
        return deepLink.contains(DeeplinkEnum.products.toString(), true) || deepLink.contains(
            DeeplinkEnum.categories.toString(),
            true
        ) || deepLink.contains(
            "product-details",
            true
        ) || deepLink.contains(
            DeeplinkEnum.category.toString(),
            true
        )
                || deepLink.contains(DeeplinkEnum.supplier.toString(), true) || deepLink.contains(
            DeeplinkEnum.suppliers.toString(),
            true
        ) || deepLink.contains(
            DeeplinkEnum.brand.toString(),
            true
        )
                || deepLink.contains(DeeplinkEnum.myWallet.toString(), true) || deepLink.contains(
            DeeplinkEnum.myorder.toString(),
            true
        ) || deepLink.contains(
            DeeplinkEnum.credit.toString(),
            true
        ) || deepLink.contains(
            DeeplinkEnum.mycart.toString(),
            true
        )
    }

    private fun handleDeeplinkLocal(url: String) {

        val url = url?.trim()
        val bundle = Bundle()
        if (url != null) {
            val list = url.split("/")
            /* Request code */when {
                url.contains(DeeplinkEnum.products.toString()) -> {
                    bundle.putString("productId", list[4])
                }
                url.contains(
                    DeeplinkEnum.Categories.toString(),
                    true
                ) || url.contains(DeeplinkEnum.category.toString(), true) -> {
                    bundle.putString("categoryType", "cid")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
                url.contains(DeeplinkEnum.supplier.toString()) || url.contains(DeeplinkEnum.suppliers.toString()) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
                url.contains(DeeplinkEnum.myorder.toString()) -> {
                    bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[4])
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.ORDER_TYPE_HOLDER
                    )
                }
                url.contains(DeeplinkEnum.myWallet.toString()) || url.contains(
                    DeeplinkEnum.credit.toString(),
                    true
                ) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.WALLET_TYPE_HOLDER
                    )
                }
                url.contains(DeeplinkEnum.mycart.toString(), true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.CART_TYPE_HOLDER
                    )
                }
            }
            handelIntent(bundle)
        }
    }

    fun removeRecentViewItem() {
        blocksAdapter.items?.removeAll { it -> it.sectionName == Constants.RECENT_VIEW }
        blocksAdapter.notifyDataSetChanged()
        mainViewModel.clearRecentViewProduct()
    }

    override fun onConciergeButtonClicked() {
        findNavController().navigate(R.id.concierge)
    }

    private fun openMyWallet() {
        val uri = Uri.parse("android-app://www.tatayab.com/wallet")
        findNavController().navigate(uri)
    }

    private fun openMyCart() {
        (activity as MainActivity).apply { this.navigatedToCartFragment() }
    }

    private fun openMyOrder(orderID: String?) {
        val uri = Uri.parse("android-app://www.tatayab.com/order_details/$orderID")
        findNavController().navigate(uri)
    }

    private fun openProductDetails(productId: String) {
        try {
            val uri = Uri.parse("android-app://www.tatayab.com/products/$productId")
            findNavController().navigate(uri)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

    private fun openProductList(
        categoryType: String,
        categoryId: String,
        categoryName: String
    ) {
        try {
            val uri =
                Uri.parse("android-app://www.tatayab.com/product_list/$categoryType/$categoryId/$categoryName/category_uid")
            findNavController().navigate(uri)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun openProductListforSupplier(
        categoryType: String,
        categoryId: String,
        categoryName: String
    ) {
        try {
            val uri =
                Uri.parse("android-app://www.tatayab.com/product_list/$categoryType/$categoryId/$categoryName/ ")
            findNavController().navigate(uri)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}

