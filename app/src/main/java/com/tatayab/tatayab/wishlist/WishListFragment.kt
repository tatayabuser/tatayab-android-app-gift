package com.tatayab.tatayab.wishlist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import com.tatayab.model.*
import com.tatayab.model.responses.WishListProduct
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.presentation.wishlist.WishlistFragmentViewModel
import com.tatayab.presentation.wishlist.WishlistFragmentViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCategoryNavigationListener
import com.tatayab.tatayab.listener.OnWishListListener
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.DialogUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.cart_dialog.*
import kotlinx.android.synthetic.main.empty_wishlist_for_login_user.*
import kotlinx.android.synthetic.main.empty_wishlist_for_unlogin_user.*
import kotlinx.android.synthetic.main.fragment_wish_list.*
 import timber.log.Timber
import javax.inject.Inject


class WishListFragment : BaseFragment2(), OnWishListListener {


    @Inject
    lateinit var viewModelFactory: WishlistFragmentViewModelFactory.Factory

    private lateinit var mainViewModel: MainActivityViewModel
    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    lateinit var viewModel: WishlistFragmentViewModel
    private var listener: OnCategoryNavigationListener? = null
    private lateinit var wishlistAdapter: WishListProductsAdapter


    override fun layoutId(): Int {
        return R.layout.fragment_wish_list
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(WishlistFragmentViewModel::class.java)
        viewModel?.isGraphEnabled = com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS
//
//        mainViewModel = activity?.run {
//            ViewModelProviders.of(this, baseViewModelFactory)[MainActivityViewModel::class.java]
//        } ?: throw Exception("Invalid Activity")


        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        wishlistAdapter = WishListProductsAdapter(this, viewModel.getDecimalNumbers())
        viewModel.getWishListLiveData.observe(this, Observer {

            when (it.status) {
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    Timber.e("Success")
                    setupViewData(it?.data!!)
//                    if (it.data != null && it.data!!.isNotEmpty()) viewModel.updateCachedWishList(it.data!!)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }

        })


        viewModel.userNotLogin.observe(this, Observer {
            wishlist_for_unlogin_user.visibility = View.VISIBLE
            layout_empty_wishlist.visibility = View.GONE
            rv_wishlist.visibility = View.GONE
        })

        viewModel.gettotalRowsWishLoadLiveData.observe(this, Observer {
            if (it.second == 0) {
                layout_empty_wishlist.visibility = View.VISIBLE
                wishlist_for_unlogin_user.visibility = View.GONE
                rv_wishlist.visibility = View.GONE
            } else if (it.second > 0) {
                layout_empty_wishlist.visibility = View.GONE
                wishlist_for_unlogin_user.visibility = View.GONE
                rv_wishlist.visibility = View.VISIBLE
            }
            if (!it.first)
                animationView.visibility = View.GONE
            else
                animationView.visibility = View.VISIBLE
        })

        viewModel.getRemoveFromWishListLiveData.observe(this, Observer {
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

                        wishlistAdapter.setRemoveItem(it.data?.productPosition!!)
                        showCustomTopMessage(
                            getString(R.string.remove_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )

//                        deleteWishItemFromCache(it.data?.productID!!)
                        count.text = wishlistAdapter.itemCount.toString().plus(" ")
                            .plus(getText(R.string.wishlist_count))
                        if (wishlistAdapter.itemCount == 0) {
                            layout_empty_wishlist.visibility = View.VISIBLE
                            count.visibility = View.GONE
                        }
                    } else
                        showCustomTopMessage(
                            it.data?.msg,
                            DialogUtil.MessageType.ERROR
                        )
                }
                else -> animationView.visibility = View.GONE
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
                    animationView.visibility = View.GONE
                    if (it.data?.second?.first != null) {
                        showCustomTopMessage(
                            getString(R.string.added_to_cart),
                            DialogUtil.MessageType.SUCCESS
                        )
                        animationView.visibility = View.GONE
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_CODE_LOGIN_ACTIVITY && resultCode == Activity.RESULT_OK && data?.getIntExtra(
                Constants.LOGIN,
                Constants.REQUEST_CODE_LOG_IN
            ) == Constants.REQUEST_CODE_LOG_IN
        ) {

        }

        if (viewModel.isUserLogin(com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS)) {
            viewModel.getWishList()
            animationView.visibility = View.VISIBLE
            wishlist_for_unlogin_user.visibility = View.GONE
            (activity as MainActivity).loginSucceed()
        }
    }

    private fun setupViewData(data: List<WishListProduct?>?) {
        rv_wishlist.visibility = View.VISIBLE

        if (data?.size!! > 0) {
            val wishList = data as ArrayList<WishListProduct>
            wishlistAdapter.currencyCode = viewModel.getCurrencyCode()
            if (data[0].currency != null)
                wishlistAdapter.currencyCode = data[0].currency
            for (item in wishList) {
                if (item.product_id.isNullOrEmpty()) {
                    wishList.remove(item)
                }
            }
            wishlistAdapter.setData(wishList)
            layout_empty_wishlist.visibility = View.GONE
            wishlist_for_unlogin_user.visibility = View.GONE
            rv_wishlist.visibility = View.VISIBLE
            count.visibility = View.VISIBLE
            count.text = data.size.toString().plus(" ").plus(getText(R.string.wishlist_count))

            val params = HashMap<String, Any>()
            InsiderManager.sendCustomEvent(AdjustTracker.ADD_TO_CART_EVENT, params)
        } else {
            layout_empty_wishlist.visibility = View.VISIBLE
            wishlist_for_unlogin_user.visibility = View.GONE
            rv_wishlist.visibility = View.GONE
            count.visibility = View.GONE
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWishList()
        //rv_wishlist.layoutManager = LinearLayoutManager(context)
        rv_wishlist.adapter = wishlistAdapter

        refresh.setOnRefreshListener {
            viewModel.getWishList()
            refresh.isRefreshing = false
        }

        tv_login.setSafeOnClickListener {
            view.let {
                val bundle = Bundle().apply {
                    putInt(Constants.LOGIN, Constants.REQUEST_CODE_LOG_IN)
                }
                val loginIntent = Intent(activity, LoginOptionActivity::class.java)
                loginIntent.putExtras(bundle)
                startActivityForResult(loginIntent, Constants.REQUEST_CODE_LOGIN_ACTIVITY)
            }
        }

        container.setSafeOnClickListener {
            dilaog.visibility = View.GONE
            opacity_view.visibility = View.GONE
        }

        tv_continue_shopping.setSafeOnClickListener {
            opacity_view.visibility = View.GONE
            dilaog.visibility = View.GONE
            container.isEnabled = true
        }

        tv_checkout.setSafeOnClickListener {
            (activity as MainActivity).navigatedToCartFragment()
        }

        btn_view_products.setSafeOnClickListener {
            listener?.navigatedToCategoryFragment()
        }

    }


    override fun onProductDelete(
        options: Map<String, String>?,
        index: Int,
        productID: String,
        productWishListId: String?
    ) {
        viewModel.deleteWishListItem(options, index, productID,productWishListId)

    }

    private fun deleteWishItemFromCache(productId: String) {
        viewModel.deleteFromWishListInCache(productId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({},
                { error -> Log.e("WishAction/delete/Error", error.toString()) })
    }

    override fun onProductClicked(productId: String, options: Map<String, String>?) {
        try {
            val optionsValue = getOptions(options)
            val nextAction =
                WishListFragmentDirections.nextProductDetails(productId, optionsValue, "")
            findNavController().navigate(nextAction)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getOptions(selectedOptions: Map<String, String>?): Array<OptionsMap> {
        val option = arrayListOf<OptionsMap>()
        selectedOptions?.forEach {
            option.add(OptionsMap(it.key, it.value))
        }
        return option.toTypedArray()

    }

    override fun moveToCart(
        product: ProductX,
        options: Map<String, String>?,
        index: Int,
        image: ImageView?
    ) {
        mainViewModel.addToCart(
            product = product,
            selectedOptions = options
        )
    }


    override fun onSupplierSelected(supplier_id: String?, supplier_name: String?) {
        val nextAction =
            WishListFragmentDirections.nextProductList("supplier_ids", supplier_id, supplier_name)
        findNavController().navigate(nextAction)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCategoryNavigationListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnHomeNavigationListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun notifyHomeWithChanges(prductID: String, newStatues: Boolean) {
        val intent = Intent(Constants.CHANGE_WISHLIST_CASE)
        intent.putExtra(Constants.PRODUCT_ID, prductID)
        intent.putExtra(Constants.NEW_STATEUES, newStatues)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }
}
