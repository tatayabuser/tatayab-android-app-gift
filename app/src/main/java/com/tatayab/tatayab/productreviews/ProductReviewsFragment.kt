package com.tatayab.tatayab.productreviews

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tatayab.model.Review
import com.tatayab.model.responses.ProductReviewsResponse
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.product.Constants.DESC
import com.tatayab.presentation.product.Constants.SORT_BY_RATE
import com.tatayab.presentation.product.Constants.SORT_BY_TIME
import com.tatayab.presentation.product.ProductDetailsFragmentViewModel
import com.tatayab.presentation.product.ProductDetailsFragmentViewModelFactory
import com.tatayab.presentation.product.ProductReviewsFragmentViewModel
import com.tatayab.presentation.product.ProductReviewsViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.add_review_sheet.view.*
import kotlinx.android.synthetic.main.comparsion_review_values.*
import kotlinx.android.synthetic.main.comparsion_review_values.view.*
import kotlinx.android.synthetic.main.fragment_reviews.*
import kotlinx.android.synthetic.main.fragment_reviews.no_reviwers
import kotlinx.android.synthetic.main.fragment_reviews_in_productdetails.rv_reviews
import kotlinx.android.synthetic.main.view_compare.*
import javax.inject.Inject


class ProductReviewsFragment() : BaseFragment2() {

    override fun layoutId(): Int {
        return R.layout.fragment_reviews
    }

    private lateinit var viewModel: ProductReviewsFragmentViewModel

    private lateinit var detailsViewModel: ProductDetailsFragmentViewModel

    private lateinit var mainViewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    @Inject
    lateinit var viewModelFactory: ProductReviewsViewModelFactory.Factory

    @Inject
    lateinit var detailsViewModelFactory: ProductDetailsFragmentViewModelFactory.Factory


    var selected_comparsion: TextView? = null

    var productId: String? = null
    var productName: String? = null


    var productReview: ProductReviewsResponse? = null
    private var productReviewsAdapter: ReviewsAdapter = ReviewsAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productId = arguments?.let { ProductReviewsFragmentArgs.fromBundle(it).productId }
        productName = arguments?.let { ProductReviewsFragmentArgs.fromBundle(it).productId }
        rv_reviews.layoutManager = LinearLayoutManager(requireActivity())
        rv_reviews.adapter = productReviewsAdapter

        viewModel =
            ViewModelProviders.of(this, viewModelFactory.create(productId!!))
                .get(ProductReviewsFragmentViewModel::class.java)

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        detailsViewModel =
            ViewModelProviders.of(
                this,
                detailsViewModelFactory.create(
                    productId!!,
                    App.getPref().currentLanguage.toString()
                )
            ).get(ProductDetailsFragmentViewModel::class.java)

        detailsViewModel.getProductReviews()
        viewModel.loadReviews(SORT_BY_TIME, DESC)
        viewModel.reviewsLiveData?.observe(viewLifecycleOwner, Observer {
            setProgress(View.GONE)
            setupViewData(it)
        })

        mainViewModel.getAddReviewResponseLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it.data?.first?.product_id!!.toInt() > 0) {
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
                    setProgress(View.VISIBLE)
                }
            }
        })
        detailsViewModel.getProductReviewstLiveData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    setupReviewData(it.data)
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

        comparsion.setSafeOnClickListener {
            val mBottomSheetDialog = BottomSheetDialog(requireActivity())

            val sheetView =
                requireActivity().layoutInflater.inflate(R.layout.comparsion_review_values, null)

            if (compare_value.text.toString() == getText(R.string.last_review))
                sheetView.last_reviews.setTextColor(resources.getColor(R.color.pinkishTan))
            else if (compare_value.text.toString() == getText(R.string.high_review))
                sheetView.high_review.setTextColor(resources.getColor(R.color.pinkishTan))
            else if (compare_value.text.toString() == getText(R.string.low_review))
                sheetView.low_review.setTextColor(resources.getColor(R.color.pinkishTan))

            sheetView.last_reviews.setSafeOnClickListener {
                viewModel.loadReviews(SORT_BY_TIME, DESC)
                selected_comparsion = last_reviews
                compare_value.text = getText(R.string.last_review)
                mBottomSheetDialog.dismiss()
            }

            sheetView.high_review.setSafeOnClickListener {
                viewModel.loadReviews(SORT_BY_RATE, DESC)
                selected_comparsion = high_review
                compare_value.text = getText(R.string.high_review)
                mBottomSheetDialog.hide()
            }

            sheetView.low_review.setSafeOnClickListener {
                viewModel.loadReviews(SORT_BY_RATE, DESC)
                selected_comparsion = low_review
                compare_value.text = getText(R.string.low_review)
                mBottomSheetDialog.dismiss()
            }
            mBottomSheetDialog.setContentView(sheetView)
            mBottomSheetDialog.show()
        }

        add_new_review_btn.setSafeOnClickListener {
            if (mainViewModel.isUserLoginWithOpenLogin()) {
                (activity as MainActivity).showAddProductReview(
                    productId,
                    productName = productName
                )
            }
        }
    }

    private fun setupViewData(data: PagedList<Review>) {
        productReviewsAdapter.submitList(data) {
            val layoutManager = rv_reviews.layoutManager as LinearLayoutManager
            val position = layoutManager.findFirstCompletelyVisibleItemPosition()
            if (position != RecyclerView.NO_POSITION) {
                rv_reviews.scrollToPosition(position)
            }
        }
    }

    private fun setupReviewData(productReviewsResponse: ProductReviewsResponse?) {

        if (!productReviewsResponse?.reviews.isNullOrEmpty()) {
            all_reviews.setText(productReviewsResponse?.total_reviews.toString().plus(" ").plus(getText(R.string.review)))
        } else
            no_reviwers.visibility = View.VISIBLE

    }


}
