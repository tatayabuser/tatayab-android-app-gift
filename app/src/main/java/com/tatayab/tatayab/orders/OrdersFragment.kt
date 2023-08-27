package com.tatayab.tatayab.orders

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.domain.State
import com.tatayab.model.responses.Order
import com.tatayab.presentation.orders.OrdersFragmentViewModel
import com.tatayab.presentation.orders.OrdersFragmentViewModelFactory
 import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.listener.OnOrderListener
import kotlinx.android.synthetic.main.fragment_orders.*
import javax.inject.Inject

class OrdersFragment : BaseFragment2(), OnOrderListener {

    override fun onOrderTracking(orderId: String, orderDate: String) {
        val nextAction = OrdersFragmentDirections.destinationOrderTracking(orderId, orderDate)
        view?.let {
            findNavController(it).navigate(nextAction)
        }
    }


    override fun onOrderSelected(orderId: String) {
        val nextAction = OrdersFragmentDirections.destinationOrderDetails(orderId)
        view?.let {
            findNavController(it).navigate(nextAction)
        }
    }


    override fun layoutId(): Int = R.layout.fragment_orders


    lateinit var viewModel: OrdersFragmentViewModel

    @Inject
    lateinit var viewModelFactory: OrdersFragmentViewModelFactory.Factory

    lateinit var ordersAdapter: OrdersAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(
            this, viewModelFactory.create(App.getPref().currentLanguage.toString())
        ).get(OrdersFragmentViewModel::class.java)

        ordersAdapter = OrdersAdapter(this, viewModel.getDecimalNumbers())
        rv_orders.layoutManager = LinearLayoutManager(activity)
        rv_orders.adapter = ordersAdapter

        viewModel.ordersLiveData.observe(viewLifecycleOwner, Observer {
            setupViewData(it)
        })

        viewModel.statLiveData.observe(viewLifecycleOwner, Observer {
            when (it.second) {
                State.ERROR ->
                    animationView.visibility = View.GONE
                State.DONE -> {
                    animationView.visibility = View.GONE
                    if (it.first == 0)
                        layout_empty_orders.visibility = View.VISIBLE
                }
                else ->
                    animationView.visibility = View.VISIBLE

            }
        })
    }

    private fun setupViewData(data: PagedList<Order>) {
        ordersAdapter.currencyCode = viewModel.getCurrencyCode()

        ordersAdapter.submitList(data) {
            val layoutManager = rv_orders.layoutManager as LinearLayoutManager
            val position = layoutManager.findFirstCompletelyVisibleItemPosition()
            if (position != RecyclerView.NO_POSITION) {
                rv_orders.scrollToPosition(position)
            }
        }
    }

}
