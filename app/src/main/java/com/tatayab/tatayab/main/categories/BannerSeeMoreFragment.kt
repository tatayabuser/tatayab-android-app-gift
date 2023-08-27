package com.tatayab.tatayab.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.deeplink.DeeplinkConstants
import com.tatayab.tatayab.deeplink.DeeplinkEnum
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnBannerSeeMoreListener
import com.tatayab.tatayab.main.categories.adapter.BannerSeeMoreAdapter
import kotlinx.android.synthetic.main.fragment_banner_see_more.*
import kotlinx.android.synthetic.main.toolbar_with_back.*

class BannerSeeMoreFragment : BaseFragment2(), OnBannerSeeMoreListener {

    private val bannerList by lazy {
        arguments?.let { BannerSeeMoreFragmentArgs.fromBundle(it).bannerList }
            ?: throw IllegalArgumentException("Expected arguments")
    }
    private val screenTitle by lazy {
        arguments?.let { BannerSeeMoreFragmentArgs.fromBundle(it).screenTitle }
            ?: throw IllegalArgumentException("Expected arguments")
    }

    // 1 =  best banner  , 2 =top banner , 3 = choice
    private val screenType by lazy {
        arguments?.let { BannerSeeMoreFragmentArgs.fromBundle(it).screenType }
            ?: throw IllegalArgumentException("Expected arguments")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_banner_see_more
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = screenTitle
        iv_back.setSafeOnClickListener {
            findNavController().popBackStack()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        try {
            if (bannerList?.bannerList?.isNullOrEmpty()) {
                noItemsTextView.visibility = View.VISIBLE
                bannerRecyclerView.visibility = View.GONE
                return
            }
            bannerRecyclerView.visibility = View.VISIBLE
            noItemsTextView.visibility = View.GONE
            var layoutManager =
                GridLayoutManager(activity, 3)
            if (screenType == 1) {
                layoutManager =
                    GridLayoutManager(activity, 1)
            } else if (screenType == 2) {
                layoutManager =
                    GridLayoutManager(activity, 2)
            } else if (screenType == 3) {
                layoutManager =
                    GridLayoutManager(activity, 3)
            }
            bannerRecyclerView.layoutManager = layoutManager
            var mBannerSeeMoreAdapter = BannerSeeMoreAdapter(this)
            mBannerSeeMoreAdapter.setData(bannerList.bannerList)
            bannerRecyclerView.adapter = mBannerSeeMoreAdapter

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    override fun onBannerSelected(categoryId: String?, url: String) {
        (activity as MainActivity).apply {
            if (this.isDeeplinkContainsLocalLogic(url))
                handleBannerURI(url)
        }
    }

    private fun handleBannerURI(link: String) {
        val url = link?.replace("http://tatayab.com","")!!.trim()
        val bundle = Bundle()
        // /category/13?type=category
        //http://tatayab.com/Categories/50/Mubkhars
        // /Categories/50/Mubkhars?type=category
        if (url != null) {
            val listAfterSplitQuestionMark = url.split("?")
            val list = listAfterSplitQuestionMark.get(0).split("/")
            /* Request code */when {
                url.contains(
                    DeeplinkEnum.products.toString(),
                    true
                ) || url.contains(DeeplinkEnum.Products.toString(), true) -> {
                    if (list.size > 2) bundle.putString("productId", list[2])
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains("product-details", true) -> {
                    if (list.size > 3)bundle.putString("productId", list[3])
                }
                url.contains(
                    DeeplinkEnum.Categories.toString(),
                    true
                ) || url.contains(DeeplinkEnum.category.toString(), true) -> {
                    try {
                        bundle.putBoolean("isHasValue", true)
                        if (url.contains("type", true) && list.size > 3) {
                            if (list.size > 3) bundle.putString("categoryId", list[3])
                            bundle.putString("categoryName", getString(R.string.product_list))
                            if (url.contains("type=category", true)) {
                                bundle.putString("categoryType", "cid")
                            } else if (url.contains("type=brand", true)) {
                                bundle.putString("categoryType", "supplier_ids")
                            }
                        } else {
                            bundle.putString("categoryType", "cid")
                            if (list.size > 2)bundle.putString("categoryId", list[2])
                            if (list.size > 3) bundle.putString("categoryName", list[3])
                        }
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }

                }
                url.contains(
                    DeeplinkEnum.supplier.toString(),
                    true
                ) || url.contains(DeeplinkEnum.suppliers.toString(), true) || url.contains(
                    DeeplinkEnum.Suppliers.toString()) ||  url.contains(
                    DeeplinkEnum.brand.toString(),
                    true
                )  -> {
                    try {
                        bundle.putString("categoryType", "supplier_ids")
                        if (list.size > 2) bundle.putString("categoryId", list[2])
                        if (list.size > 3)bundle.putString("categoryName", list[3])
                        bundle.putBoolean("isHasValue", true)
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }

                }
                url.contains(DeeplinkEnum.myorder.toString(), true) -> {
                    try {
                        bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[2])
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.ORDER_TYPE_HOLDER
                        )
                        bundle.putBoolean("isHasValue", true)
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }

                }
                url.contains(
                    DeeplinkEnum.myWallet.toString(),
                    true
                ) || url.contains(DeeplinkEnum.credit.toString(), true) -> {
                    try {
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.WALLET_TYPE_HOLDER
                        )
                        bundle.putBoolean("isHasValue", true)
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }

                }
                url.contains(DeeplinkEnum.mycart.toString(),true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.CART_TYPE_HOLDER
                    )
                    bundle.putBoolean("isHasValue", true)
                }
            }
            if (bundle.containsKey("isHasValue")) {
                try {
                    (activity as MainActivity).apply {
                        this.handelLocalNavigation(bundle)
                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }

            }
        }

    }
}