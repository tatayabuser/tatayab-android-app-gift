package com.tatayab.tatayab.filter


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.tatayab.tatayab.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.filter.SortItem
import com.tatayab.model.filter.SortType
import com.tatayab.presentation.product.ProductListFragmentViewModel
import com.tatayab.presentation.product.ProductListFragmentViewModelFactory
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.filter.adapter.SortAdapter
import com.tatayab.tatayab.listener.OnSortListener
import com.tatayab.tatayab.util.Constants
import kotlinx.android.synthetic.main.fragment_sort.*
import javax.inject.Inject


class SortFragment : BaseFragment2(), OnSortListener {


    private lateinit var viewModel: ProductListFragmentViewModel
    @Inject
    lateinit var viewModelFactory: ProductListFragmentViewModelFactory.Factory;
    private val sortAdapter: SortAdapter = SortAdapter(this)

    override fun layoutId(): Int {
        return R.layout.fragment_sort
    }

    private val sortList: List<SortItem> by lazy {
        listOf(
//            SortItem(
//                1,
//                context?.getString(R.string.featured_products),
//                true,
//                "",
//                SortType.ASCENDING
//            ),
            SortItem(
                1,
                context?.getString(R.string.popularity),
                false,
                "",
                SortType.NO_FILTER
            ),
            SortItem(
                2,
                context?.getString(R.string.high_to_low_price).toString(),
                false,
                "price",
                SortType.DESCENDING
            ),
            SortItem(
                3,
                context?.getString(R.string.low_to_high_price).toString(),
                false,
                "price",
                SortType.ASCENDING
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(
                this,
                viewModelFactory.create("0", "", "", "graphKey")
            )[ProductListFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.getSortLiveData.observe(this, Observer { list ->
            list?.let {
                setupViewWithData(it)
            }
        })

        viewModel.getSortOptions(sortList)

    }


    private fun setupViewWithData(list: List<SortItem>) {
        sortAdapter.setSortList(list)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()

    }


    private fun intComponent() {
        rv_sort.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv_sort.adapter = sortAdapter
        (activity as MainActivity).apply {
            this.hideBottomNavigation()
        }
    }

    override fun onSortOptionChecked(sortItem: SortItem) {
        sortItem.checked = !sortItem.checked
        viewModel.setSelectedSortOption(sortItem)


        //  val map: HashMap<String, String> = hashMapOf()
//        if (sortItem.checked) {
//            map["sort_by"] = sortItem.sortOption
//            map["sort_order"] = sortItem.sortType.toString()
//        }
        val bundle = Bundle().apply {
            putInt(Constants.SORT_FRAGMENT, Constants.REQUEST_CODE_SORT)
            //putSerializable(Constants.PARAMETERS, map)
        }
        (activity as MainActivity).navigateBackWithResult(bundle)

    }

}
