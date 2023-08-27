
package com.tatayab.tatayab.invoiceorder

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.responses.OrderDetailsResponse
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.listener.OnProductListenerInOrder
import com.tatayab.tatayab.orderdetails.OrderDetailsFragmentDirections
import com.tatayab.tatayab.orderdetails.ProductAdapterInOrder
import kotlinx.android.synthetic.main.invoice_order.*
import javax.inject.Inject

class OrderInvoiceFragment : BaseFragment(),
    OnProductListenerInOrder {


    override fun layoutId(): Int = R.layout.invoice_order
      var data: OrderDetailsResponse?=null
    var currencyCode: String = ""
    var decimalDigits: Int = 3 // default is 3 for kuwait
    lateinit var mainViewModel: MainActivityViewModel

    private lateinit var productAdapter: ProductAdapterInOrder

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    companion object {
         fun newInstance(
            details: OrderDetailsResponse,
            currency: String = "",
            decimalNumbers: Int
        ) =
            OrderInvoiceFragment().apply {
                data = details
                currencyCode = currency
                decimalDigits = decimalNumbers
            }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productAdapter = ProductAdapterInOrder(this, decimalDigits)
        setUpData()
    }

    private fun setUpData() {
        try {
            if (data == null || data?.products?.isNullOrEmpty()!!) return
            total_items.text =
                data!!.products.size.toString().plus(" ").plus(getText(R.string.items_ordered))
            rv_order_products.adapter = productAdapter
            productAdapter.setData(mainViewModel?.getCurrencyCode(), data!!.products)
            user_name.text =
                if (data?.shipping_address?.name.isNullOrBlank() || data?.shipping_address?.name!!.contains(
                        "null",
                        true
                    )
                ) {
                    if (mainViewModel?.isUserLogin(Constants.ENABLE_GRAPH_QUERIES_CALLS)!!) mainViewModel?.getUserName()
                        .toString() else ""
                } else {
                    data?.shipping_address?.name
                }
            user_phone.text = data?.shipping_address?.phone
            mail.text =
                if (mainViewModel?.isUserLogin(Constants.ENABLE_GRAPH_QUERIES_CALLS)!!) mainViewModel?.getUserEmail().toString() else ""
            user_address.text =
                data?.shipping_address?.city.plus(",")
                    .plus(data?.shipping_address?.state).plus(data?.shipping_address?.street ?: " ")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onProductSelected(productId: String) {
        try {
            if (productId.isNullOrEmpty()) return
            val action = OrderDetailsFragmentDirections.nextProductDetails(productId)
            findNavController().navigate(action)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    override fun onSupplierSelected(supplier_id: String?, supplier_name: String?) {
        if (supplier_id.isNullOrEmpty()) return

        val action = OrderDetailsFragmentDirections.actionProductsList(
            "supplier_ids",
            supplier_id,
            supplier_name
        )
        view.let { findNavController()?.navigate(action) }
    }

    override fun onTrackExternalOrder(url: String?) {
        TODO("Not yet implemented")
    }

}

