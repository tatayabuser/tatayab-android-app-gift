package com.tatayab.tatayab.main.cart

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.ProductX
import com.tatayab.model.ShareCartListModel
import com.tatayab.model.responses.CartOrderResponse
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.model.responses.SelectedOptionModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.main.cart.CartFragmentViewModel
import com.tatayab.presentation.main.cart.CartFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity2
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.activity_shared_cart.*
import kotlinx.android.synthetic.main.toolbar_main_default.tv_title
import kotlinx.android.synthetic.main.toolbar_main_splash_country.*
import javax.inject.Inject

class SharedCartActivity : BaseActivity2() {

    lateinit var mainViewModel: MainActivityViewModel
    lateinit var viewModel: CartFragmentViewModel
    private lateinit var cartAdapter: SharedCartAdapter
    var currentCartProducts: ArrayList<CartOrderResponse>? = null
    var sharedProductsList = ArrayList<ProductX>()
    var sharedProductsListDummy = ArrayList<ProductX>()
    var mergeItemPosition = 0

    @Inject
    lateinit var cartViewModelFactory: CartFragmentViewModelFactory.Factory

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    private var sharedCartModel: ShareCartListModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_cart)
        // Hide tool bar
        val actionBar = supportActionBar
        actionBar?.hide()
        viewModel =
            ViewModelProviders.of(
                this,
                cartViewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(CartFragmentViewModel::class.java)

        mainViewModel = this?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        }!!
        viewModel.getCart(Constants.ENABLE_GRAPH_QUERIES_CALLS)
        cartAdapter = SharedCartAdapter()
        mainViewModel.getProductsListResponseLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    base_loading.visibility = View.GONE
                    showCustomTopMessage(
                        getString(R.string.error_occure),
                        DialogUtil.MessageType.ERROR
                    )

                }
                ResourceState.SUCCESS -> {
                    base_loading.visibility = View.GONE
                    updateView(it.data)
                }
                else -> {
                    base_loading.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getCartLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {

                }
                ResourceState.SUCCESS -> {
                    it.data?.let { cart ->
                        if (cart.second.products!!.isNotEmpty()) {
                            currentCartProducts =
                                cart.second.products as ArrayList<CartOrderResponse>
                        } else {
                            currentCartProducts = null
                        }
                    }

                }

                else -> {}
            }

        })

        viewModel.getRemoveFromCartLiveData.observe(this, Observer { it ->
            when (it.status) {
                ResourceState.ERROR -> {
                    base_loading.visibility = View.GONE
                    if (!it?.message.isNullOrEmpty()) {
                        showCustomTopMessage(it.message.toString(), DialogUtil.MessageType.ERROR)
                    } else {
                        showCustomTopMessage(
                            getString(R.string.cart_clear_error),
                            DialogUtil.MessageType.ERROR
                        )
                    }
                    handelErrorUI()
                }
                ResourceState.SUCCESS -> {
                    if (!currentCartProducts.isNullOrEmpty()) {
                        currentCartProducts?.removeAt(0)
                    }
                    startClearLogic()
                }
                else -> {}
            }

        })

        mainViewModel.getProductAddeddTocartLiveDataa.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    base_loading.visibility = View.GONE
//                    if (!it?.message.isNullOrEmpty()) {
//                        showCustomTopMessage(it.message.toString(), DialogUtil.MessageType.ERROR)
//                    } else {
//                        showCustomTopMessage(
//                            getString(R.string.cart_merging_error),
//                            DialogUtil.MessageType.ERROR
//                        )
//                    }
//                    handelErrorUI()
                    if (!sharedProductsListDummy.isNullOrEmpty()) {
                        sharedProductsListDummy?.removeAt(0)
                        if (mergeItemPosition != -1 && !sharedProductsList.isNullOrEmpty() && sharedProductsList?.size!! > mergeItemPosition) {
                            var currentProduct = sharedProductsList?.get(mergeItemPosition)
                            currentProduct!!.mergingError = it?.message?.toString()
                        }
                    }
                    startMergeCart()

                }
                ResourceState.SUCCESS -> {
                    if (it.data?.first != null) {
                        if (!sharedProductsListDummy.isNullOrEmpty()) {
                            sharedProductsListDummy?.removeAt(0)
                            if (mergeItemPosition != -1 && !sharedProductsList.isNullOrEmpty() && sharedProductsList?.size!! > mergeItemPosition) {
                                var currentProduct = sharedProductsList?.get(mergeItemPosition)
                                currentProduct!!.isMerged = true
                            }
                        }
                    } else {
                        if (!sharedProductsListDummy.isNullOrEmpty()) {
                            sharedProductsListDummy?.removeAt(0)
                        }
                    }
                    startMergeCart()
                }
                else -> {
                }
            }
        })

        initView()
        sharedCartModel = MemoryCacheManager.getShareCartModel()
        if (sharedCartModel != null) {
            handleShareCartDeeplink()
            MemoryCacheManager.addShareCartModel(null)
        }
    }

    private fun initView() {
        tv_title.text = getString(R.string.share_cart)
        sharedItemCountTextView.text = "0 " + getString(R.string.product)
        sharedCartRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        sharedCartRecyclerView.adapter = cartAdapter

        continueButton.setOnClickListener {
            onContinueButtonClicked()
        }
        iv_close.setOnClickListener {
            finish()
        }
        closeButton.setOnClickListener {
            finish()
        }
        closeActionSheetImage.setOnClickListener {
            cartMergeActionsSheetView.visibility = View.GONE
            continueButton.visibility = View.VISIBLE
        }
        mergeCartButton.setOnClickListener {
            cartMergeActionsSheetView.visibility = View.GONE
            startMergeCart()
        }

        clearCurrentCartButton.setOnClickListener {
            cartMergeActionsSheetView.visibility = View.GONE
            startClearLogic()
        }

    }

    private fun startClearLogic() {
        base_loading.visibility = View.VISIBLE
        if (currentCartProducts.isNullOrEmpty()) {
            startMergeCart()
        } else {
            viewModel.deleteCartItem(currentCartProducts?.get(0)?.product_id!!, "", 0, null)
        }
    }

    private fun startMergeCart() {
        base_loading.visibility = View.VISIBLE
        if (sharedProductsListDummy?.isNullOrEmpty()!!) {
            base_loading.visibility = View.GONE
            closeButton.visibility = View.VISIBLE
            continueButton.visibility = View.GONE
            MemoryCacheManager.COMES_FROM_SHARED_CART = true
            cartAdapter?.setDataAfterMerging(sharedProductsList, true)
        } else {
            var product = sharedProductsListDummy.get(0)
            mergeItemPosition = getItemPositionFromsharedProductsList(product?.product_id!!)
            mainViewModel.addToCart(product, product.productOptionsSelected)
        }
    }

    private fun getItemPositionFromsharedProductsList(productId: String): Int {
        var position = -1
        try {
            sharedProductsList.mapIndexed { index, productX ->
                if (productX.product_id.equals(productId)) {
                    position =  index
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return position
    }

    private fun updateView(data: ProductsListResponse?) {
        try {
            // Display the items on UI
            data?.products?.let {
                if (!it?.isNullOrEmpty()!!) {
                    var productListMergedWithSharedCart: List<ProductX?> = mergeWithShardCart(it)
                    cartAdapter?.setData(
                        mainViewModel.getCurrencyCode(),
                        productListMergedWithSharedCart,
                        mainViewModel.getDecimalNumbers()
                    )
                    sharedProductsListDummy.clear()
                    productListMergedWithSharedCart.map {
                        sharedProductsList.add(it!!)
                        sharedProductsListDummy.add(it!!)
                    }
                    var productString = getString(R.string.product)
                    if (!productListMergedWithSharedCart.isNullOrEmpty() && productListMergedWithSharedCart.size > 1) {
                        productString =
                            getString(R.string.products)
                    }
                    sharedItemCountTextView.text =
                        productListMergedWithSharedCart.size.toString()
                            .plus(" " + productString)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun mergeWithShardCart(newProductList: List<ProductX?>): List<ProductX?> {
        try {
            var shaedProductList = sharedCartModel?.products
            if (!shaedProductList.isNullOrEmpty()) {
                newProductList?.map {
                    var newProduct = it
                    shaedProductList?.map {
                        if (it.product_id.equals(newProduct?.product_id)) {
                            newProduct?.productOptionsSelected = convertObjectToHashMap(it?.options!!)
                            newProduct?.amount = it?.amount
                        }
                    }!!
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }

        return newProductList
    }

    private fun convertObjectToHashMap(options: java.util.ArrayList<SelectedOptionModel>): Map<String, String>? {
        var optionsList = HashMap<String, String>()
        if (!options.isNullOrEmpty()) {
            try {
                options.map {
                    optionsList.put(it.variantId, it.optionId)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return optionsList
    }

    private fun handleShareCartDeeplink() {
        //STEPS:
        if (!sharedCartModel?.products.isNullOrEmpty()) {
            sharedCartModel?.senderName?.let {
                var finalText =
                    "<B>" + it + "</B> " + getString(R.string.share_cart_receiver_message)
                sender_message.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(finalText, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(finalText)
                }
            }
            //1- get products id as String
            sharedCartModel?.let {
                var productsIDsList: String = ""
                it?.products!!.map {
                    if (!it?.product_id.isNullOrEmpty()) {
                        productsIDsList = productsIDsList.plus(it?.product_id).plus(",")
                    }
                }
                //2- call APi for get All products
                mainViewModel.getProdcutsByIDs(productsIDsList)
            }
        }
    }

    fun onContinueButtonClicked() {
        //Check on cart counts
        if (!currentCartProducts.isNullOrEmpty()) {
            cartMergeActionsSheetView.visibility = View.VISIBLE
            continueButton.visibility = View.GONE
        } else {
            startMergeCart()
        }
    }

    fun handelErrorUI() {
        //Check on cart counts
        if (!currentCartProducts.isNullOrEmpty()) {
            cartMergeActionsSheetView.visibility = View.VISIBLE
            continueButton.visibility = View.GONE
        } else {
            cartMergeActionsSheetView.visibility = View.GONE
            continueButton.visibility = View.VISIBLE
        }
    }
}