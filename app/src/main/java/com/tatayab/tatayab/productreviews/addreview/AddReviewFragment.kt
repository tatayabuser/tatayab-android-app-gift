package com.tatayab.tatayab.productreviews.addreview

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import android.view.View
 import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.requests.AddReviewRequest
import com.tatayab.presentation.addreview.AddReviewViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.add_review_fragment.*
import javax.inject.Inject

class AddReviewFragment : BaseFragment() {
    override fun layoutId(): Int {
        return R.layout.add_review_fragment
    }

    @Inject
    lateinit var mViewModel: AddReviewViewModel


    private val productId by lazy {
        arguments?.let { AddReviewFragmentArgs.fromBundle(it).productId }
            ?: throw IllegalArgumentException("Expected arguments")
    }

    private val productName by lazy {
        arguments?.let { AddReviewFragmentArgs.fromBundle(it).productName }
            ?: throw IllegalArgumentException("Expected arguments")
    }


    private val productImage by lazy {
        arguments?.let { AddReviewFragmentArgs.fromBundle(it).productImage }
            ?: throw IllegalArgumentException("Expected arguments")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this,viewModelFactory).get(AddReviewViewModel::class.java)


        mViewModel.getaddReviewResponseLiveData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it.data?.product_id!!.toInt() > 0) {
                        hideKeyboard()
                        showCustomTopMessage(getString(R.string.addreviewsuccess) , DialogUtil.MessageType.SUCCESS )
                        ratecomment.setText(" ")
                        ratingBar.rating = 0f
                    }
                    else
                    showCustomTopMessage(getString(R.string.completedata) , DialogUtil.MessageType.ERROR )

                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

        product_name.text = productName

//        Glide.with(context!!)
//            .load(
//                productImage
//            )
//            .into(product_img)
        try {
            Picasso.get()
                .load(productImage)
                .placeholder(R.drawable.default_image2).into(product_img)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        ratesend.setSafeOnClickListener {
            if (ratecomment.text.toString().trim().isNotEmpty()) {
                if (ratingBar.rating>0) {
                    val addReviewRequest =
                        AddReviewRequest(ratecomment.text.toString(), productId, ratingBar.rating)
                    mViewModel.addReview(addReviewRequest)
                }
                else
                    showCustomTopMessage(getText(R.string.add_rate).toString(),DialogUtil.MessageType.ERROR)
            }

            else
                ratecomment.error = getText(R.string.invalid_comment)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}
