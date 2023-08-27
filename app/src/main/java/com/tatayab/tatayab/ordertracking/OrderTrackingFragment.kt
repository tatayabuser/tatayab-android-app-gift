package com.tatayab.tatayab.ordertracking

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.listener.OnProductListenerInOrder
import kotlinx.android.synthetic.main.fragment_order_tracking.*

class OrderTrackingFragment() :  BaseFragment() {


    override fun layoutId(): Int = R.layout.fragment_order_tracking

    private lateinit var trackAdapter: OrderTrackingAdapter

    var  viewModel: OrderDetailsFragmentViewModel? = null
    var  listener: OnProductListenerInOrder? = null


    companion object {
        @JvmStatic
        fun newInstance(detailsViewmodel: OrderDetailsFragmentViewModel?, orderlistener: OnProductListenerInOrder?) = OrderTrackingFragment().apply {
            viewModel  = detailsViewmodel
            listener = orderlistener
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trackAdapter = OrderTrackingAdapter(listener)
        rv_order_statues.adapter = trackAdapter
        viewModel?.getOrderTracking()
        viewModel?.getOrderTrackLiveData()?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    trackAdapter.setData(it.data?.history!!,it.data?.externalShipping?.url)
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

    }

}
