package com.tatayab.tatayab.search

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.model.SearchModel
import com.tatayab.model.SearchProductModel
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.product.SearchFragmentViewModelFactory
import com.tatayab.presentation.search.SearchFragmentViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.firebase.FirebaseTrackingManager
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnProductListenerInHome
import com.tatayab.tatayab.listener.OnSearchListener
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter
import com.tatayab.tatayab.search.adapter.SearchAdapter
import com.tatayab.tatayab.search.adapter.SearchSuggestionAdapter
import com.tatayab.tatayab.util.DialogUtil
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import kotlinx.android.synthetic.main.search_fragment.*
import kotlinx.android.synthetic.main.search_fragment. animationView
import kotlinx.android.synthetic.main.search_layout.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SearchFragment : BaseFragment(), OnSearchListener, OnProductListenerInHome {

    var mRecommendedLayoutManager: LinearLayoutManager? = null
    var mLayoutManager: LinearLayoutManager? = null
    var mSuggestionLayoutManager: LinearLayoutManager? = null

    override fun layoutId(): Int {
        return R.layout.search_fragment
    }

    lateinit var viewModel: SearchFragmentViewModel
    lateinit var mainViewModel: MainActivityViewModel
    private var isFavoriteIconEvent: Boolean = false

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    @Inject
    lateinit var searchviewModelFactory: SearchFragmentViewModelFactory.Factory

    private var searchAdapter: SearchAdapter =
        SearchAdapter(this)
    private var productsAdapter: ProductsAdapter? = null
    private var mSearchSuggestionAdapter: SearchSuggestionAdapter = SearchSuggestionAdapter(this)
    private var loading = false
    private var pastVisiblesItems: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var pageCount: Int = 0
    private var searchText: String = ""


    override fun onResume() {
        super.onResume()
        isFavoriteIconEvent = false
        if (!search_txt?.text?.toString().isNullOrEmpty()) {
            searchText = search_txt?.text.toString()
            if (!loading) {
                viewModel.startSearch(searchText, false, false)
                loading = true
            }
        } else
            if (!isStopPassed) {
                viewModel.getSuggestionSections()
            } else {
                if (currentProductList != null) {
                    activity?.runOnUiThread(Runnable {
                        updateProductListView(currentProductList!!)
                    })
                }
            }
    }

    var isStopPassed = false
    override fun onStop() {
        isStopPassed = true
        super.onStop()
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchSuggestionView.visibility = View.GONE
        updateRecommendedProductsVisibility(false)
        updateSearchSuggestionVisibility(false)
        conciergeButtonAction.setOnClickListener {
            try {
                findNavController().navigate(R.id.open_concierge)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

        if (search_txt.text?.isEmpty() == true)
            rv_search.visibility = View.INVISIBLE

        search_txt.isFocusable = true

        mLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        mSuggestionLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        mRecommendedLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        initRecyclerListener()
        initSearchSuggestionRecycler()
        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            search_txt.addTextChangedListener(@SuppressLint("CheckResult")
            object : TextWatcher {
                @SuppressLint("CheckResult")
                override fun afterTextChanged(s: Editable) {
                    if (s.toString().isNotEmpty()) {
                        searchSuggestionView.visibility = View.GONE
                        updateRecommendedProductsVisibility(false)
                        updateSearchSuggestionVisibility(false)
                        delete_search.visibility = View.VISIBLE
                        try {
                            val params = HashMap<String, Any>()
                            params["keyword"] = s.toString()
                            InsiderManager.sendCustomEvent(
                                InsiderManager.CustomEvent.searched.toString(),
                                params
                            )
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    } else {
                        rv_search.visibility = View.INVISIBLE
                        delete_search.visibility = View.GONE
                    }
                    subscriber.onNext(s.toString())
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                }
            }
            )
        }).map { text -> text.trim() }
            .debounce(900, TimeUnit.MILLISECONDS)
            .subscribe { t: String? ->
                if (t.toString().isNotEmpty()) {
                    pageCount = 0
                    searchText = t.toString()
                    if (!isStopPassed && !loading) {
                        loading = true
                        viewModel.startSearch(searchText, true, true)
                    } else {
                        isStopPassed = false
                    }
                }
            }


        delete_search.setSafeOnClickListener {
            search_txt.setText("")
            no_result_view.visibility = View.GONE
        }

        search_txt?.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (!search_txt.text.toString().isNullOrEmpty()) {
                        val action = SearchFragmentDirections.nextProductList(
                            "q",
                            search_txt.text.toString(),
                            search_txt.text.toString()
                        )
//                        view.let { findNavController().navigate(action) }
                        hideKeyboard()
                    }
                    return true
                }
                return false
            }
        })
    }


    private fun initRecyclerListener() {
        try {
            rv_search.layoutManager = mLayoutManager
            rv_search.adapter = searchAdapter
            rv_search.recycledViewPool.clear()

            rv_search.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        hideKeyboard()
                        //check for scroll down
                        visibleItemCount = mLayoutManager?.childCount!!
                        totalItemCount = mLayoutManager?.itemCount!!
                        pastVisiblesItems = mLayoutManager?.findFirstVisibleItemPosition()!!
                        if (!loading) {
                            if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                                loading = true
                                viewModel.startSearch(searchText, false, true)
                            }
                        }
                    }
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun initSearchSuggestionRecycler() {
        try {
            suggestionSearchRecyclerView.layoutManager = mSuggestionLayoutManager
            recommendedProductsRecyclerView.layoutManager = mRecommendedLayoutManager
            suggestionSearchRecyclerView.adapter = mSearchSuggestionAdapter
            productsAdapter = ProductsAdapter(
                this,
                slideTwo = false,
                multiOffer = true,
                decimalNumbers = viewModel.getDecimalNumbers()
            )
            recommendedProductsRecyclerView.adapter = productsAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onDestroy() {
        hideKeyboard()
        super.onDestroy()
    }

    override fun onPause() {
        hideKeyboard()
        super.onPause()
    }

    override fun onBackPressed() {
        hideKeyboard()
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel =
            ViewModelProviders.of(
                requireActivity(),
                searchviewModelFactory.create(App.getPref().currentLanguage.toString())
            )
                .get(SearchFragmentViewModel::class.java)

        viewModel.getProductsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    loading = false
                     animationView.visibility = View.GONE
                    no_result_view.visibility = View.VISIBLE
                    rv_search.visibility = View.INVISIBLE
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
                    loading = false
                    it.data?.let { it1 -> updateProductListView(it1) }
                }
                else -> {
                    loading = true
                     animationView.visibility = View.VISIBLE
                    no_result_view.visibility = View.GONE
                    rv_search.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getSearchSuggestionsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
                    it.data?.let { searSuggestionList -> displaySearchSuggestion(searSuggestionList) }
                }
                else -> {
                     animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getRecomandedProductsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
                    it.data?.let { productsList -> displayRecomandedProducts(productsList) }
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
                        showCustomTopMessage(it.message!!, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getString(R.string.error_occure),
                            DialogUtil.MessageType.ERROR
                        )

                }
                ResourceState.SUCCESS -> {
                    if (it.data?.second?.first != null) {
                         animationView.visibility = View.GONE
                        Toast.makeText(context, getText(R.string.added_to_cart), Toast.LENGTH_SHORT)
                            .show()
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

                    if (it.data?.success!! == 1) {
                        Toast.makeText(
                            context,
                            getText(R.string.add_wishlist_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        productsAdapter?.changeFav(it.data?.productPosition!!, true)
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
                     animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
                    if (it.data?.success == 1 && isFavoriteIconEvent) {
                        productsAdapter?.changeFav(it.data?.productPosition!!, false)
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
                else ->  animationView.visibility = View.GONE
            }
        })

        FirebaseTrackingManager.visitSearchScreen(requireContext())

    }

    private fun displayRecomandedProducts(productsList: List<ProductX>) {
        if (productsList.isNullOrEmpty()) {
            updateRecommendedProductsVisibility(false)
            productsAdapter?.setData(viewModel.getCurrencyCode(), ArrayList())
            showKeyBoard()
        } else {
            hideKeyboard()
            searchSuggestionView.visibility = View.VISIBLE
            updateRecommendedProductsVisibility(true)
            productsAdapter?.setData(viewModel.getCurrencyCode(), productsList)
        }
    }

    var searchSuggestionTextList = ArrayList<SearchModel>()
    private fun displaySearchSuggestion(searchSuggestionList: List<SearchModel>) {
        if (searchSuggestionList.isNullOrEmpty()) {
            updateSearchSuggestionVisibility(false)
            mSearchSuggestionAdapter.setData(ArrayList())
        } else {
            searchSuggestionTextList.clear()
            searchSuggestionTextList.addAll(searchSuggestionList)
            searchSuggestionView.visibility = View.VISIBLE
            updateSearchSuggestionVisibility(true)
            mSearchSuggestionAdapter.setData(searchSuggestionList)
        }
    }

    override fun onSearchSelected(productId: String, type: String, name: String) {
        hideKeyboard()
        val action = SearchFragmentDirections.nextActionDetails(productId, true)
        findNavController().navigate(action)
    }

    override fun onSearchSuggestionSelected(searchSuggestionText: String) {
        searchSuggestionView.visibility = View.GONE
        updateRecommendedProductsVisibility(false)
        updateSearchSuggestionVisibility(false)
        if (searchSuggestionText.isNotEmpty()) {
            pageCount = 0
            search_txt.setText(searchSuggestionText)
            this.searchText = searchSuggestionText
            if (!loading) {
                viewModel.startSearch(searchText, true, false)
                loading = true
            }
        }
    }

    override fun onRemovedSuggestionClicked(position: Int) {
        searchSuggestionTextList.removeAt(position)
        if (searchSuggestionTextList.isEmpty())
            updateSearchSuggestionVisibility(false)
        viewModel.saveSearchSuggestionListToCache(searchSuggestionTextList)
    }

    var currentProductList: List<SearchProductModel>? = null
    private fun updateProductListView(productList: List<SearchProductModel>) {
        if (productList?.isNotEmpty()!!) {
            searchAdapter.setData(productList, searchText)
            rv_search.visibility = View.VISIBLE
            no_result_view.visibility = View.GONE
            searchSuggestionView.visibility = View.GONE
        } else {
            no_result_view.visibility = View.VISIBLE
            rv_search.visibility = View.INVISIBLE
            searchAdapter.setData(ArrayList<SearchProductModel>(), searchText)
        }
        currentProductList = productList
    }

    fun updateSearchSuggestionVisibility(visible: Boolean) {
        if (visible) {
            recentSearchesTitleTextView.visibility = View.VISIBLE
            suggestionSearchRecyclerView.visibility = View.VISIBLE
        } else {
            recentSearchesTitleTextView.visibility = View.GONE
            suggestionSearchRecyclerView.visibility = View.GONE
        }
    }

    fun updateRecommendedProductsVisibility(visible: Boolean) {
        if (visible) {
            recommendedProductsTitleTextView.visibility = View.VISIBLE
            recommendedProductsRecyclerView.visibility = View.VISIBLE
        } else {
            recommendedProductsTitleTextView.visibility = View.GONE
            recommendedProductsRecyclerView.visibility = View.GONE
        }
    }

    override fun onProductSelected(
        productId: String,
        mProduct: ProductX?,
        productsAdapter: ProductsAdapter
    ) {


    }

    override fun onProductSelected(
        productId: String,
        productsAdapter: ProductsAdapter
    ) {
        try {
            val nextAction = SearchFragmentDirections.nextActionDetails(productId)
            findNavController().navigate(nextAction)
        } catch (e: Exception) {
            e.printStackTrace()
        }
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
                    out_of_stock_actions = if (it.can_buy != null && it.can_buy!! > 0) it.can_buy.toString() else "B",
                    has_options = it.has_options != null && it?.has_options!! > 0,
                    is_free_delivery = if (it.is_free_delivery != null && it.is_free_delivery == 1) "Y" else "N",
                    is_In_WishList = it.inWishlist != null && it?.inWishlist == 1,
                    productLink = it.productLink!!,
                    images = images
                )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return mProduct

    }

    override fun onSeeMoreProduct(type: String, categoryId: String?, categoryName: String?) {
        TODO("Not yet implemented")
    }

    override fun addToWishlist(position: Int, product: ProductX, productsAdapter: ProductsAdapter) {
        if (mainViewModel.isUserLoginWithOpenLogin()) {
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

    fun showKeyBoard() {
        search_txt.requestFocus()
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(search_txt, InputMethodManager.SHOW_IMPLICIT)
    }
}
