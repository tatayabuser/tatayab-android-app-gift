package com.tatayab.tatayab.productlist


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.domain.State
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.product.Constants.FLASH_SALE
import com.tatayab.presentation.product.Constants.RECENT_VIEW
import com.tatayab.presentation.product.ProductListFragmentViewModel
import com.tatayab.presentation.product.ProductListFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnProductListener
import com.tatayab.tatayab.util.AnimationUtil
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.Constants.CHANGE_RECENT_VIEW
import com.tatayab.tatayab.util.Constants.CHANGE_WISHLIST_CASE
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.NavigationResult
import kotlinx.android.synthetic.main.cart_dialog.*
import kotlinx.android.synthetic.main.flash_sale_time.*
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.android.synthetic.main.toolbar_filter.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import timber.log.Timber
import javax.inject.Inject


class ProductListFragment : BaseFragment2(), OnProductListener, NavigationResult {


    override fun onNavigationResult(result: Bundle) {
        Timber.e("res ${result.getString("key").toString()}")
        viewModel.loadProducts(type, categoryId,graphKey)
//        val parameters = result.getSerializable(Constants.PARAMETERS) as Map<String, String>
//        parameters.let {
//                viewModel.loadProductsWithFilter(it)
//        }
    }


    private lateinit var viewModel: ProductListFragmentViewModel


    private lateinit var mainViewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    @Inject
    lateinit var viewModelFactory: ProductListFragmentViewModelFactory.Factory

    private var openFilterbefore = false

    private val categoryId by lazy {
        arguments?.let {
            ProductListFragmentArgs.fromBundle(
                it
            ).categoryId
        } ?:"0"
    }

    private val categoryName by lazy {
        arguments?.let {
            ProductListFragmentArgs.fromBundle(
                it
            ).categoryName
        } ?: ""
    }

    private val type by lazy {
        arguments?.let {
            ProductListFragmentArgs.fromBundle(
                it
            ).categoryType
        } ?: ""
    }

    private val graphKey by lazy {
        arguments?.let {
            ProductListFragmentArgs.fromBundle(
                it
            ).graphKey
        } ?: ""
    }

    private lateinit var productsAdapter: ProductListAdapter

    override fun layoutId(): Int = R.layout.fragment_product_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(
                this,
                viewModelFactory.create(
                    categoryId,
                    type,
                    App.getPref().currentLanguage.toString(),
                    graphKey
                )
            )[ProductListFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.resetFilter()

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


        if (type == RECENT_VIEW)
            viewModel.getSpecificProductsByIds(mainViewModel.getRecentViewProductIds())
        else
            viewModel.loadProducts(type, categoryId,graphKey)


        viewModel.productsLiveData.observe(this, Observer {
            setupViewData(it)
            no_result_product.visibility = View.GONE
        })


        mainViewModel.getFlashTimeLiveData.observe(this, Observer { flashTime ->
            if (!flashTime.first) {
                timer.text = flashTime.second
            } else
                flashTimeEnd()
        })


        viewModel.statLiveData.observe(this, Observer {
            when (it.second) {
                State.DONE -> {
                    animationView.visibility = View.GONE
                    if (it.first!! == 0)
                        no_result_product.visibility = View.VISIBLE
                    else
                        no_result_product.visibility = View.GONE

                }
                State.ERROR -> {
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                State.LOADING ->
                    animationView.visibility = View.VISIBLE
                State.EMPTY ->
                    animationView.visibility = View.GONE
            }
        })

        productsAdapter = ProductListAdapter(this, viewModel.getDecimalNumbers())

    }

    private fun flashTimeEnd() {
        findNavController().popBackStack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        tv_title.text = categoryName
        if (viewModel.isReseted) {
            viewModel.loadProducts(type, categoryId,graphKey)
            viewModel.isReseted = false
        }
    }


    private fun initComponent() {

        rv_products?.layoutManager = GridLayoutManager(activity, 2)
        rv_products?.adapter = productsAdapter

        if (type == RECENT_VIEW) {
            filter.visibility = View.GONE
            select_all.visibility = View.VISIBLE
            select_all.text = getText(R.string.clear_list)
            no_result_product.visibility = View.GONE
        } else if (categoryId == FLASH_SALE) {
            filter.visibility = View.INVISIBLE
            flash_time.visibility = View.VISIBLE
            AnimationUtil.showErrorDialogAnimation(flash_time)

        }

        btn_sort.setSafeOnClickListener {
            if (productsAdapter.itemCount > 0 || openFilterbefore) {
                val action = ProductListFragmentDirections.actionSort()
                findNavController().navigate(action)
                openFilterbefore = true
            }
//            else
//                showErrorDialog(btn_sort, getText(R.string.not_sort_empty_list).toString())

        }


        select_all.setSafeOnClickListener {
            notifyClearRecentView()
            findNavController().popBackStack()
        }
        btn_filter.setSafeOnClickListener {
            if (productsAdapter.itemCount > 0 || openFilterbefore) {
                val action = ProductListFragmentDirections.actionFilter(type, categoryId, graphKey)
                view?.let {
                    findNavController().navigate(action)
                }
                openFilterbefore = true
            }
//            else
//                showErrorDialog(btn_filter, getText(R.string.not_filter_empty_list).toString())
        }

        tv_continue_shopping.setSafeOnClickListener {
            opacity_view.visibility = View.GONE
            dilaog.visibility = View.GONE
        }

        tv_checkout.setSafeOnClickListener {
            (activity as MainActivity).navigatedToCartFragment()
        }

        opacity_view.setSafeOnClickListener {
            Log.d("Opacity", "Opacity Click")
        }

    }

    private fun setupViewData(data: PagedList<ProductX>) {
        try {
            productsAdapter.currencyCode = viewModel.getCurrencyCode()
            productsAdapter.submitList(data) {
                // Workaround for an issue where RecyclerView incorrectly uses the loading / spinner
                // item added to the end of the list as an anchor during initial load.
                val layoutManager = rv_products?.layoutManager as GridLayoutManager
                //if (toggle_view.isChecked) (rv_products.layoutManager as GridLayoutManager) else (rv_products.layoutManager as LinearLayoutManager)
                val position = layoutManager.findFirstCompletelyVisibleItemPosition()
                if (position != RecyclerView.NO_POSITION) {
                    rv_products?.scrollToPosition(position)
                }
                no_result_product.visibility = View.GONE
            }
        } catch (e: Exception) {
            println(e.toString())
        }
    }


    override fun onProductSelected(productId: String) {
        try {
            productId?.let {
                val nextAction =
                    ProductListFragmentDirections.nextAction(
                        productId
                    )
                view?.let {
                    findNavController().navigate(nextAction)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("productList", "onDestroyView")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.getProductAddeddTocartLiveDataa.observe(viewLifecycleOwner, Observer {
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
                    if (it.data?.second?.first != null) {
                        animationView.visibility = View.GONE
                        showCustomTopMessage(
                            getString(R.string.added_to_cart),
                            DialogUtil.MessageType.SUCCESS
                        )
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getaddtoWishListresult.observe(viewLifecycleOwner, Observer {
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
                    if (it.data?.success!! == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, true)
                        showCustomTopMessage(
                            getString(R.string.add_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        it.data?.let {
                            try {
                                if (it != null) {
                                    var params = HashMap<String, Any>()
                                    params.put("product_name", it.productName)
                                    params.put("product_id", it.productID)
                                    InsiderManager.sendCustomEvent(
                                        InsiderManager.CustomEvent.add_to_fav.toString(),
                                        params
                                    )
                                }
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else
                        showCustomTopMessage(
                            it.data?.msg!!,
                            DialogUtil.MessageType.ERROR
                        )

                    productsAdapter.changeWishListState(it.data?.productPosition!!, true)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getRemoveFromWishListLiveData.observe(viewLifecycleOwner, Observer {
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
                    if (it.data?.success!! == 1) {
                        notifyHomeWithChanges(it?.data?.productID!!, false)

                        showCustomTopMessage(
                            getString(R.string.remove_wishlist_success),
                            DialogUtil.MessageType.SUCCESS
                        )
                        it.data?.let {
                            try {
                                if (it != null) {
                                    var params = HashMap<String, Any>()
                                    params.put("product_name", it.categoryName)
                                    params.put("product_id", it.productID)
                                    InsiderManager.sendCustomEvent(
                                        InsiderManager.CustomEvent.remove_from_fav.toString(),
                                        params
                                    )
                                }
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else
                        showCustomTopMessage(
                            it.data?.msg!!,
                            DialogUtil.MessageType.ERROR
                        )
                    productsAdapter.changeWishListState(it.data?.productPosition!!, false)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
    }


    override fun addToWishlist(position: Int, product: Product) {
        if (mainViewModel.isUserLoginWithOpenLogin()) {
            if (product.is_In_WishList)
                mainViewModel.deleteWishListItem(
                    options = null,
                    productID = product.product_id!!,
                    index = position,
                    productName = product.product!!
                )
            else
                mainViewModel.addToWishList(
                    product_id = product.product_id!!,
                    position = position,
                    productName = product.product!!
                )
        }
    }


    override fun onAddToCart(product: ProductX) {
        mainViewModel.addToCart(
            product = product
        )
    }

    fun notifyHomeWithChanges(prductID: String, newStatues: Boolean) {
        val intent = Intent(CHANGE_WISHLIST_CASE)
        intent.putExtra(Constants.PRODUCT_ID, prductID)
        intent.putExtra(Constants.NEW_STATEUES, newStatues)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    fun notifyClearRecentView() {
        val intent = Intent(CHANGE_RECENT_VIEW)
        val bundle = Bundle()
        bundle.putBoolean(Constants.CLEAR_RECENT_VIEW, true)
        intent.putExtras(bundle)
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.resetSort()
        viewModel.resetFilter()
    }

}
