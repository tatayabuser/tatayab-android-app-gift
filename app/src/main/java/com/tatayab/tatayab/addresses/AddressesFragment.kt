package com.tatayab.tatayab.addresses

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.requests.AddressRequest
import com.tatayab.presentation.Utils
import com.tatayab.presentation.address.AddressFragmentViewModel
import com.tatayab.presentation.address.AddressFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.errorHandling.ExceptionHandler
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnAddressListener
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.NavigationResult
import kotlinx.android.synthetic.main.fragment_addresses.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.layout_no_addresses.*
import timber.log.Timber
import javax.inject.Inject


class AddressesFragment : BaseFragment(), OnAddressListener, NavigationResult {


    lateinit var viewModel: AddressFragmentViewModel

    @Inject
    lateinit var viewModelFactoryaddress: AddressFragmentViewModelFactory.Factory

    private var addressAdapter: AddressesAdapter = AddressesAdapter(this)

    private val go by lazy {
        arguments?.getBoolean("GiftOptions") ?: false    }

    private val fromCheckout by lazy {
        arguments?.let {
            AddressesFragmentArgs.fromBundle(
                it
            ).fromCheckOut
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactoryaddress.create(App.getPref().currentLanguage.toString())
            ).get(AddressFragmentViewModel::class.java)
        addressAdapter.setAreaText(
            if (viewModel.isAnewCountry()) getString(R.string.state) else getString(
                R.string.area
            )
        )
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        viewModel.getAddressesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    showErrorDialog(btn_add_address, getString(R.string.error_occure))
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    Timber.e("Succes")
                    it.data?.let { data ->
                        setupListWithData(data)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getDeleteAddressesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (it.data?.o_address_id!! > 0) {
                        Timber.e("Success")
                        addressAdapter.setRemoveItem(it.data?.itemIndex!!)
                        if (addressAdapter.itemCount == 0)
                            layout_no_addresses.visibility = View.VISIBLE
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getUpdateAddressesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    Timber.e("Succes")
                    animationView.visibility = View.GONE
                    if (it.data?.o_address_id!! > 0) {
                        addressAdapter.changePrimary(it.data?.itemIndex!!)
                        if (fromCheckout) {
                            Utils.CheckOutAction.action = Utils.CheckActionType.ADDRESS_UPDATED
                            findNavController().popBackStack()
                        }
                    }
                    else
                        showCustomTopMessage(
                            it.data?.message.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        viewModel.getBillingAddressLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                    val message =
                        it.throwable?.let { it1 ->
                            ExceptionHandler().getMessage(
                                it1,
                                requireContext()
                            )
                        }
                    if (message != null)
                        showCustomTopMessage(message, DialogUtil.MessageType.ERROR)
                    else if (it?.message.isNullOrBlank().not()) {
                        showCustomTopMessage(it?.message!!, DialogUtil.MessageType.ERROR)
                    } else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (fromCheckout) {
                        Utils.CheckOutAction.action = Utils.CheckActionType.ADDRESS_UPDATED
                        findNavController().popBackStack()
                    } else {
                        viewModel.getAddresses()
                    }
                }
                else -> {
                    animationView.visibility = View.GONE
                }

            }
        })

    }

    private fun setupListWithData(list: List<AddressRequest>) {
        if (list.isNotEmpty()) {
            group_data_exist.visibility = View.VISIBLE
            layout_no_addresses.visibility = View.GONE
            addressAdapter.setData(list as ArrayList<AddressRequest>, getAddressTypes())
        } else {
            group_data_exist.visibility = View.GONE
            layout_no_addresses.visibility = View.VISIBLE
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_addresses
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        viewModel.getAddresses()
        rv_addresses.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv_addresses.adapter = addressAdapter
        hideKeyboard()
        btn_add_address.setSafeOnClickListener {
            val nextAction = AddressesFragmentDirections.nextAction(null)
            findNavController().navigate(nextAction)
        }
        btn_add_new_address.setSafeOnClickListener {
            val nextAction = AddressesFragmentDirections.nextAction(null)
            findNavController().navigate(nextAction)
        }
    }

    override fun onDeleteAddress(
        addressId: String,
        index: Int,
        isPrimary: String,
        isLastAddress: Boolean
    ) {
        if (!isPrimary.equals("Y") && !isLastAddress)
            viewModel.deleteAddress(addressId, index)
        else
            showIsPrimaryDialog()
    }

    private fun showIsPrimaryDialog() {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(R.string.opps)
        dialog.setMessage(R.string.primary_address)
        dialog.setPositiveButton(R.string.ok) { _: DialogInterface, _: Int -> }
        dialog.show()
    }

    override fun onEditAddress(userAddress: AddressRequest) {
        val nextAction = AddressesFragmentDirections.nextAction(userAddress)
        view?.let {
            findNavController().navigate(nextAction)
        }
    }

    override fun onAddressSelected(position: Int, userAddress: AddressRequest) {
        if (fromCheckout)
            changePrimarySelected(position, userAddress)
    }

    override fun onMakeAddressPrimary(position: Int, userAddress: AddressRequest) {
        changePrimarySelected(position, userAddress)
    }

    private fun changePrimarySelected(position: Int, userAddress: AddressRequest) {
        viewModel.updateAddress(
            addressRequest = AddressRequest(
                o_address_id = userAddress.o_address_id,
                o_address_name = userAddress.o_address_name,
                o_address = userAddress.o_address,
                o_area = userAddress.o_area,
                o_area_code = userAddress.o_area_code,
                first_name= userAddress.first_name,
                last_name= userAddress.last_name,
                o_city = userAddress.o_city,
                o_zipcode = userAddress.o_zipcode,
                o_block = userAddress.o_block,
                o_paci = userAddress.o_paci,
                o_phone = userAddress.o_phone,
                o_street = userAddress.o_street,
                o_extra = userAddress.o_extra,
                o_province = "",
                is_primary = "Y",
                cityId = userAddress.cityId,
                areaId = userAddress.areaId,
                o_country_code = "",
                user_id = "",
                update = "Y",
                addr_type = if(ENABLE_GRAPH_QUERIES_CALLS)userAddress.addr_type else ""//,
                //keep_secret = userAddress.keep_secret
            ),
            index = position,
            isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS,
            fromCheckout = fromCheckout

        )
        findNavController().navigate(R.id.action_destination_addresses_to_giftOptionsFragment)
    }

    override fun onNavigationResult(result: Bundle) {
        viewModel.getAddresses()
    }

    override fun showShouldEditAddressMessage() {
        showCustomTopMessage(
            getString(R.string.should_edit_address),
            DialogUtil.MessageType.ERROR
        )
    }

}
