package com.tatayab.tatayab.main.categories


import android.R.attr.animationDuration
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.Transformation
import android.widget.LinearLayout
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tatayab.model.responses.*
import com.tatayab.presentation.main.category.CategoryFragmentViewModel
import com.tatayab.presentation.main.category.CategoryFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.deeplink.DeeplinkConstants
import com.tatayab.tatayab.deeplink.DeeplinkEnum
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCategoryListener
import com.tatayab.tatayab.main.categories.adapter.CategorySliderAdapter
import com.tatayab.tatayab.main.categories.adapter.ShopByBrandAdapter
import com.tatayab.tatayab.main.categories.adapter.SubCategoryNewAdapter
import com.tatayab.tatayab.main.categories.response.ListOfBanner
import com.tatayab.tatayab.util.Constants.GRAPH_CATEGORY_ID_KEY
import com.tatayab.tatayab.util.Constants.GRAPH_CATEGORY_UID_KEY
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.toolbar_categories.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class CategoriesFragment : BaseFragment2(), OnCategoryListener {


    lateinit var viewModel: CategoryFragmentViewModel

    @Inject
    lateinit var viewModelFactory: CategoryFragmentViewModelFactory.Factory


    private lateinit var categoryAdapter: MasterCategoryAdapter
    private lateinit var subCategoryAdapter: DetailsCategoryAdapter
    private lateinit var mSubCategoryNewAdapter: SubCategoryNewAdapter

    override fun layoutId(): Int = R.layout.fragment_categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(CategoryFragmentViewModel::class.java)

        categoryAdapter = MasterCategoryAdapter(this)
        subCategoryAdapter = DetailsCategoryAdapter(this)
        mSubCategoryNewAdapter = SubCategoryNewAdapter(this)

        //viewModel.getCategories(App.getPref().currentLanguage.toString())
        lifecycleScope.launch {
            viewModel.getCategories(App.getPref().currentLanguage.toString())
        }


        viewModel.getCategoriesLiveData.observe(this, Observer {

            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    it.data?.let { it1 -> setupViewData(it1) }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        viewModel.getBannersLiveData.observe(this, Observer {

            when (it.status) {
                ResourceState.ERROR -> {
                }
                ResourceState.SUCCESS -> {
//                    it?.data?.let { it1 -> setupBanners(it1) }
                }
                else -> {}
            }
        })


        viewModel.getSubCategoriesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                    setupSubCategoryViewData(ArrayList())
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                   val  subcategories = it.data?.filter { !it.isBanner }.takeIf { !it.isNullOrEmpty() }
                   setupSubCategoryViewData(subcategories)
                    if (it.data?.takeIf { !it.isNullOrEmpty() }?.get(0)?.mCategoryBannerResponse != null && it.data?.get(0)?.isBanner == true)
                        setupFeatures(it.data?.get(0)?.mCategoryBannerResponse!!)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupBanners(mCategoryBannerResponse: CategoryBannerResponse) {
        try {
            if (mCategoryBannerResponse.status == 1) {
                mCategoryBannerResponse?.data?.let {
                    it?.slider_banners?.let {
                        it.catId = mCategoryBannerResponse.data.catId
                        setupFeatures(
                            it
                        )
                    }
                    it?.best_sellers_banners?.let {
                        setupBestSeller(
                            it,
                            mCategoryBannerResponse?.data?.catId!!
                        )
                    }
                    it?.top_selling_banners?.let {
                        setupTopSeller(
                            it,
                            mCategoryBannerResponse?.data?.catId!!
                        )
                    }
                    it?.editor_choice_banners?.let {
                        setupChoiceBanner(
                            it,
                            mCategoryBannerResponse?.data?.catId!!
                        )
                    }
                    it?.shop_by_brand?.let {
                        it.catId = mCategoryBannerResponse.data.catId
                        setupShopByBrandBanner(
                            it
                        )
                    }

                }
            } else {
                rv_sub_categories.visibility = View.VISIBLE
                noItemTextView.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    var currentShopBrandModel: ShopBrandModel? = null
    private fun setupShopByBrandBanner(mShopBrandModel: ShopBrandModel) {
        mShopBrandModel?.let {

            if (it?.content?.isNullOrEmpty()!!) {
                shopBrandView.visibility = View.GONE
                currentShopBrandModel = null
            } else {
                currentShopBrandModel = it
                shopBrandTitle.text = it.title
                shopBrandRecycler.layoutManager = LinearLayoutManager(context)
                shopBrandRecycler.setHasFixedSize(true)
                shopBrandView.visibility = View.VISIBLE
                var mShopByBrandAdapter = ShopByBrandAdapter(this)
                mShopByBrandAdapter.setData(it.content, it.catId)
                shopBrandRecycler.adapter = mShopByBrandAdapter
                shopBrandRecycler.visibility = View.VISIBLE
            }
        }
    }

    private fun setupChoiceBanner(bannerModel: SliderBannersModel, catId: String) {
        if (!bannerModel?.content?.isNullOrEmpty()!!) {
            val childsList = ArrayList<Child>()
            for (banner in bannerModel.content) {
                var model = Child(banner.banner_id, banner.image, banner.banner)
                model.url = banner.url
                childsList.add(model)
            }

            var mSubCategoriesResponse = SubCategoriesResponse(
                name = bannerModel?.title!!,
                hasSubCat = childsList.isNullOrEmpty().not(),
                image_path = "",
                category_id = catId,
                childs = childsList
            )

            mSubCategoriesResponse.categoryType = BannerType.editor_choice_banners

            subCategoryAdapter?.addBannerItem(mSubCategoriesResponse)
            rv_sub_categories.visibility = View.VISIBLE
            noItemTextView.visibility = View.GONE
        }
    }

    private fun setupTopSeller(bannerModel: SliderBannersModel, catId: String) {
        if (!bannerModel?.content?.isNullOrEmpty()!!) {
            val childsList = ArrayList<Child>()
            for (banner in bannerModel.content) {
                var model = Child(banner.banner_id, banner.image, banner.banner)
                model.url = banner.url
                childsList.add(model)
            }

            var mSubCategoriesResponse = SubCategoriesResponse(
                name = bannerModel?.title!!,
                hasSubCat = false,
                image_path = "",
                category_id = catId,
                childs = childsList
            )

            mSubCategoriesResponse.categoryType = BannerType.top_selling_banners

            subCategoryAdapter?.addBannerItem(mSubCategoriesResponse)
            rv_sub_categories.visibility = View.VISIBLE
            noItemTextView.visibility = View.GONE
        }
    }

    private fun setupBestSeller(
        bannerModel: SliderBannersModel,
        catId: String
    ) {
        if (!bannerModel?.content?.isNullOrEmpty()!!) {
            val childsList = ArrayList<Child>()
            for (banner in bannerModel.content) {
                var model = Child(banner.banner_id, banner.image, banner.banner)
                model.url = banner.url
                childsList.add(model)
            }

            var mSubCategoriesResponse = SubCategoriesResponse(
                name = bannerModel?.title!!,
                hasSubCat = false,
                image_path = "",
                category_id = catId,
                childs = childsList
            )
            mSubCategoriesResponse.categoryType = BannerType.best_sellers_banners

            subCategoryAdapter?.addBannerItem(mSubCategoriesResponse)
            rv_sub_categories.visibility = View.VISIBLE
            noItemTextView.visibility = View.GONE
        }
    }

    private var currentSliderBannersModel: SliderBannersModel? = null
    private fun setupFeatures(
        mSliderBannersModel: SliderBannersModel
    ) {

        mSliderBannersModel?.title?.let {
            featureTitle.setText(it)
        }

        if (mSliderBannersModel?.content?.isNullOrEmpty()!!) {
            bannerSliderView.visibility = View.GONE
        } else {
            currentSliderBannersModel = mSliderBannersModel
            bannerSliderView.visibility = View.VISIBLE
            var sliderAdapter = CategorySliderAdapter(this)
            featureViewPager.setBackgroundColor(resources.getColor(R.color.white))
            sliderAdapter.setData(mSliderBannersModel.content, mSliderBannersModel.catId)
            featureViewPager.adapter = sliderAdapter
            featureViewPager.currentItem = 0
            tab_layout.setupWithViewPager(featureViewPager)
            if (App.getPref().currentLanguage.toString().equals("ar", true)) {
                featureViewPager.rotationY = 180F
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_categories.layoutManager = LinearLayoutManager(context)
        rv_categories.setHasFixedSize(true)
        rv_categories.adapter = categoryAdapter
        rv_sub_categories.layoutManager = LinearLayoutManager(context)
        rv_sub_categories.setHasFixedSize(true)
        rv_sub_categories.adapter = mSubCategoryNewAdapter

        iv_search.setSafeOnClickListener {
            findNavController().navigate(R.id.search)
        }
        if (currentSliderBannersModel != null) {
            setupFeatures(currentSliderBannersModel!!)
        }
        if (currentShopBrandModel != null) {
            setupShopByBrandBanner(currentShopBrandModel!!)
        }
        shopBrandArrow.setSafeOnClickListener {
            if (shopBrandRecycler.visibility == View.GONE) {
                shopBrandRecycler.visibility = View.VISIBLE
                expand(shopBrandRecycler)
                rotateShopBrandArrow(360.0f)
            } else {
                collapse(shopBrandRecycler)
                rotateShopBrandArrow(180.0f)
            }

        }
    }

    private fun rotateShopBrandArrow(degree: Float) {
        try {
            val rotateAnimation = RotateAnimation(
                degree,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            rotateAnimation.interpolator = DecelerateInterpolator()
            rotateAnimation.repeatCount = 0
            rotateAnimation.duration = animationDuration.toLong()
            rotateAnimation.fillAfter = true
            shopBrandArrow.startAnimation(rotateAnimation)
        } catch (e: Exception) {
            e.printStackTrace()
        }
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

    private fun setupViewData(data: List<CategoryItem>) {
        currentSliderBannersModel = null
        currentShopBrandModel = null

        if (!data.isNullOrEmpty()) {
            if (!data.any { it.category_id == "0" }) {
                val newList = data.toMutableList()
                newList.add(
                    CategoryItem(
                        name = getString(R.string.fragment_suppliers_title),
                        category_id = "0"
                    )
                )
                categoryAdapter.setData(newList)

            } else
                categoryAdapter.setData(data)
            noItemTextView.visibility = View.GONE
            val categoryId = if(ENABLE_GRAPH_QUERIES_CALLS) data[0].category_uid else  data[0].category_id
            viewModel.getSubCategories(data[0].name ,categoryId ?: "", ENABLE_GRAPH_QUERIES_CALLS)
        } else
            noItemTextView.visibility = View.VISIBLE

    }

    private fun setupSubCategoryViewData(data: List<SubCategoriesResponse>?) {
        subCatNestedScrollView?.scrollTo(0, 0)
        if (!data.isNullOrEmpty()) {
            var filteringData = mergeMainCats(data)
            mSubCategoryNewAdapter.setData(filteringData)
            rv_sub_categories.visibility = View.VISIBLE
            noItemTextView.visibility = View.GONE
        } else {
            mSubCategoryNewAdapter.setData(ArrayList())
            rv_sub_categories.visibility = View.GONE
            noItemTextView.visibility = View.VISIBLE
        }
    }

    private fun mergeMainCats(data: List<SubCategoriesResponse>): List<SubCategoriesResponse> {
        var filterList = ArrayList<SubCategoriesResponse>()
        try{
            var mainCategoriesList= ArrayList<CategoryModel>()
            data?.map {
                if(it?.childs.isNullOrEmpty()){
                    mainCategoriesList?.add(CategoryModel(it?.category_id,it?.category_uid,it?.image_path,it?.name,it?.isBanner,it?.mCategoryBannerResponse))
                }else{
                    filterList.add(SubCategoriesResponse(name = "", mainCategoriesList = mainCategoriesList))
                    mainCategoriesList = ArrayList<CategoryModel>()
                    filterList.add(it)
                }
            }
            if(mainCategoriesList.isEmpty().not()){
                filterList.add(SubCategoriesResponse(name = "", mainCategoriesList = mainCategoriesList))
                mainCategoriesList= ArrayList<CategoryModel>()
            }
        }catch (e:Exception){
            return data
        }
        return filterList
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            CategoriesFragment()
    }

    override fun onCategorySelected(
        categoryId: String,
        categoryName: String
    ) {
        if (!categoryId.isNullOrEmpty() && !categoryId.equals("0")) {
            viewModel.getSubCategories(categoryName,categoryId, ENABLE_GRAPH_QUERIES_CALLS)
            currentSliderBannersModel = null
            currentShopBrandModel = null
            try {
                val params = HashMap<String, Any>()
                params["category_name"] = categoryName
                params["category_id"] = categoryId
                InsiderManager.sendCustomEvent(
                    InsiderManager.CustomEvent.category_visited.toString(),
                    params
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            try {
                rv_sub_categories.visibility = View.GONE
                view?.let {
                    findNavController().navigate(CategoriesFragmentDirections.nextActionSupplier())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onSubCategorySelected(categoryId: String?, categoryName: String?) {
        try {
            var key = GRAPH_CATEGORY_UID_KEY
            if(categoryId?.isDigitsOnly() == true){
                key = GRAPH_CATEGORY_ID_KEY
            }
            val nextAction =
                CategoriesFragmentDirections.nextAction(categoryId,categoryName,"cid",key)
            view?.let {
                findNavController().navigate(nextAction)
            }

            val params = HashMap<String, Any>()
            params["sub_category_name"] = categoryName ?: ""
            params["subcategory_id"] = categoryId ?: ""
            InsiderManager.sendCustomEvent(
                InsiderManager.CustomEvent.subcategory_visited.toString(),
                params
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBannerSelected(categoryId: String?, url: String) {
        (activity as MainActivity).apply {
            if (this.isDeeplinkContainsLocalLogic(url))
                handleBannerURI(url)
        }
    }

    override fun onBannerSeeMoreSelected(
        categoryId: String,
        bannerList: ArrayList<Child>,
        bannerTitle: String,
        bannerType: Int
    ) {
        var mListOfBanner = ListOfBanner(bannerList)
        val nextAction =
            CategoriesFragmentDirections.nextActionShowAllBanners(
                bannerType,
                bannerTitle,
                mListOfBanner
            )
        view?.let {
            findNavController().navigate(nextAction)
        }

        try {
            var params = HashMap<String, Any>()
            params.put("sub_category_name", bannerList)
            params.put("subcategory_id", categoryId)
            InsiderManager.sendCustomEvent(
                InsiderManager.CustomEvent.subcategory_visited.toString(),
                params
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handleBannerURI(link: String) {
        val url = link?.replace("http://tatayab.com", "")!!.trim()
        val bundle = Bundle()
        // /category/13?type=category
        //http://tatayab.com/Categories/50/Mubkhars
        // /Categories/50/Mubkhars?type=category
        if (url != null) {
            val listAfterSplitQuestionMark = url.split("?")
            val list = listAfterSplitQuestionMark.get(0).split("/")
            /* Request code */when {
                url.contains(DeeplinkEnum.products.toString()) || url.contains(DeeplinkEnum.Products.toString()) -> {
                    bundle.putString("productId", list[2])
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains(
                    DeeplinkEnum.Categories.toString(),
                    true
                ) || url.contains(DeeplinkEnum.category.toString(), true) -> {
                    if (url.contains("type", true)) {
                        bundle.putString("categoryId", list[2])
                        if (list.size > 3) {
                            bundle.putString("categoryName", list[3])
                        } else {
                            bundle.putString("categoryName", getString(R.string.product_list))
                        }
                        if (url.contains("type=category", true)) {
                            bundle.putString("categoryType", "cid")
                        } else if (url.contains("type=brand", true)) {
                            bundle.putString("categoryType", "supplier_ids")
                        }
                    } else {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[2])
                        if (list.size > 3) {
                            bundle.putString("categoryName", list[3])
                        } else {
                            bundle.putString("categoryName", getString(R.string.product_list))
                        }
                    }
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains(DeeplinkEnum.supplier.toString()) || url.contains(DeeplinkEnum.suppliers.toString()) || url.contains(
                    DeeplinkEnum.Suppliers.toString()
                ) || url.contains(
                    DeeplinkEnum.brand.toString(),
                    true
                ) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[2])
                    if (list.size > 3) {
                        bundle.putString("categoryName", list[3])
                    } else {
                        bundle.putString("categoryName", getString(R.string.product_list))
                    }
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains(DeeplinkEnum.myorder.toString()) -> {
                    bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[2])
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.ORDER_TYPE_HOLDER
                    )
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains(DeeplinkEnum.myWallet.toString()) || url.contains(
                    DeeplinkEnum.credit.toString(),
                    true
                ) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.WALLET_TYPE_HOLDER
                    )
                    bundle.putBoolean("isHasValue", true)
                }
                url.contains(DeeplinkEnum.mycart.toString(), true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.CART_TYPE_HOLDER
                    )
                    bundle.putBoolean("isHasValue", true)
                }
            }
            if (bundle.containsKey("isHasValue")) {
                (activity as MainActivity).apply {
                    this.handelLocalNavigation(bundle)
                }
            }
        }

    }

}
