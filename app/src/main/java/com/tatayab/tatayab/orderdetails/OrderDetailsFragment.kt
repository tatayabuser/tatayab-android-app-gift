package com.tatayab.tatayab.orderdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.responses.OrderDetailsResponse
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModel
import com.tatayab.presentation.orders.OrderDetailsFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.invoiceorder.OrderInvoiceFragment
 import com.tatayab.tatayab.listener.OnProductListenerInOrder
import com.tatayab.tatayab.ordertracking.OrderTrackingFragment
import com.tatayab.tatayab.util.NumbersUtil
 import kotlinx.android.synthetic.main.fragment_order_details.*
import javax.inject.Inject

class OrderDetailsFragment : BaseFragment2(), OnProductListenerInOrder {


    lateinit var viewModel: OrderDetailsFragmentViewModel

    @Inject
    lateinit var viewModelFactory: OrderDetailsFragmentViewModelFactory.Factory;

    var lastchecked = R.id.order_invoice


    private val orderId by lazy {
        arguments?.let { OrderDetailsFragmentArgs.fromBundle(it).orderId }
            ?: throw IllegalArgumentException("Expected arguments")
    }


    override fun layoutId(): Int = R.layout.fragment_order_details


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getOrderDetails()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory.create(orderId, App.getPref().currentLanguage.toString())
        ).get(OrderDetailsFragmentViewModel::class.java)
        viewModel.getOrderDetailsLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView?.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView?.visibility = View.GONE
                    setupViewData(it.data!!)
                }
                else -> {
                    animationView?.visibility = View.VISIBLE
                }
            }
        })


    }

    private fun setupViewData(data: OrderDetailsResponse) {
        order_info.visibility = View.VISIBLE
        order_id_value.text = data.order_id

//        if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
            total_without_shipping_value.text = data.total.toString().plus(" ").plus(data.currency)
//        else
//            total_without_shipping_value.text = context?.getString(
//                R.string.currency,
//                NumbersUtil.formatNumber((data.total).toFloat(), viewModel.getDecimalNumbers()),
//                viewModel.getCurrencyCode()
//            )
//        if (Constants.ENABLE_GRAPH_QUERIES_CALLS)
            delivery_charge_value.text = data.delivery_charges.toString().plus(" ").plus(data.currency)
//        else
//            delivery_charge_value.text = context?.getString(
//                R.string.currency,
//                NumbersUtil.formatNumber(
//                    data.delivery_charges.toFloat(),
//                    viewModel.getDecimalNumbers()
//                ),
//                viewModel.getCurrencyCode()
//            )

        order_on_value.text = data.date
        payment_method_value.text = data.payment
        tracking_id_value.text = data.order_id

        /*replaceFragment(
           *//* OrderInvoiceFragment.newInstance(
                data,
                viewModel.getCurrencyCode(),
                viewModel.getDecimalNumbers()
            )*//*
        )*/

        if (lastchecked == R.id.track_order)
            replaceFragment(OrderTrackingFragment.newInstance(viewModel, this))
        else
            replaceFragment(
                OrderInvoiceFragment.newInstance(
                    data,
                    viewModel.getCurrencyCode(),
                    viewModel.getDecimalNumbers()
                )
            )

        rg_details.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.track_order -> {
                    replaceFragment(OrderTrackingFragment.newInstance(viewModel, this))
                    lastchecked = R.id.track_order
                }

                R.id.order_invoice -> {
                     replaceFragment(
                        OrderInvoiceFragment.newInstance(
                            data,
                            viewModel.getCurrencyCode(),
                            viewModel.getDecimalNumbers()
                        )
                    )
                    lastchecked = R.id.order_invoice

                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fm = activity?.getSupportFragmentManager()
        val ft = fm?.beginTransaction()
        ft?.replace(R.id.details_container, fragment)
        ft?.commit()
    }

    override fun onProductSelected(productId: String) {

        val action = OrderDetailsFragmentDirections.nextProductDetails(productId)
        view.let { findNavController().navigate(action) }
    }

    override fun onSupplierSelected(supplier_id: String?, supplier_name: String?) {
        val action = OrderDetailsFragmentDirections.actionProductsList(
            "supplier_ids",
            supplier_id,
            supplier_name
        )
        view.let { findNavController().navigate(action) }
    }

    override fun onTrackExternalOrder(url: String?) {
        val action = OrderDetailsFragmentDirections.destinationTrackExtOrder(url)
        view.let { findNavController().navigate(action) }
    }

}
