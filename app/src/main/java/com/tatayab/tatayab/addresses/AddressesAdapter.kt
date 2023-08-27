package com.tatayab.tatayab.addresses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.addresses.AddressType
import com.tatayab.model.requests.AddressRequest
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnAddressListener
import kotlinx.android.synthetic.main.list_item_address.view.*


//typealias OnProductListener = (productId) -> Unit

class AddressesAdapter(
    private val listener: OnAddressListener
) : RecyclerView.Adapter<AddressesAdapter.AddressViewHolder>() {

    override fun getItemCount(): Int = items?.size ?: 0

    private var items: ArrayList<AddressRequest>? = null
    private var areaText: String = ""
    private var addressType: List<AddressType>? = null

    fun changePrimary(CurrentPosition: Int) {
        items?.filter { it.is_primary.equals("Y", true) }.takeIf { !it.isNullOrEmpty() }?.map {
            it.is_primary = "N"
        }
        items?.get(CurrentPosition)?.is_primary = "Y"
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val address = items?.get(position)

        with(holder) {
            bindTo(address)
            address?.let { address ->
                itemView.tv_delete.setSafeOnClickListener {
                    var isLastAddress = false
                    if (items!!.size == 1) isLastAddress = true
                    listener.onDeleteAddress(
                        addressId = address.o_address_id,
                        index = position,
                        isPrimary = address.is_primary,
                        isLastAddress = isLastAddress
                    )
                }
                itemView.tv_edit.setSafeOnClickListener {
                    listener.onEditAddress(address)
                }

                itemView.setSafeOnClickListener {
                  //  if (address.getCityId() > 0 || !address.o_city.isNullOrEmpty()) {
                        listener.onAddressSelected(position, address)
                   /* } else {
                        listener.showShouldEditAddressMessage()
                    }*/
                }

                itemView.isprimary.setSafeOnClickListener {
                   // if (address.getCityId() > 0 || !address.o_city.isNullOrEmpty()) {
                        listener.onMakeAddressPrimary(position, address)
                 /*   } else {
                        listener.showShouldEditAddressMessage()
                    }*/
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_address, parent, false)

        return AddressViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setAreaText(areaText: String) {
        this.areaText = areaText;
    }

    fun setData(items: ArrayList<AddressRequest>, types: List<AddressType>) {
        this.items = items
        addressType = types
        notifyDataSetChanged()
    }


    fun setRemoveItem(index: Int) {
        this.items?.removeAt(index)
        notifyItemRemoved(index)
    }

    inner class AddressViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


        private val name = view.tv_name
        private val city = view.tv_city_block
        private val area = view.tv_area
        private val phone = view.tv_phone
        private val isDefault = view.isprimary
        private val edit = view.tv_edit
        private val delete = view.tv_delete


        var address: AddressRequest? = null
        fun bindTo(address: AddressRequest?) {
            this.address = address
            val context = view.context
            name.text = address?.o_address_name

            val cityText : StringBuilder = java.lang.StringBuilder()
            cityText.append(address?.o_city?.plus(address.o_area?:""))
            if (address?.o_block != null)
                cityText.apply {
                    append(",")
                    append(context.getText(R.string.block))
                    append(" ")
                    append(address.o_block)
                }

            city.text = cityText.toString()
            phone.text = address?.o_phone
            area.text =  address?.o_address

//            if (address?.o_area.isNullOrEmpty() || address?.o_area.equals("0")) {
//                area.visibility = View.GONE
//            } else {
//                area.visibility = View.VISIBLE
//                if (areaText.isNullOrEmpty()) areaText = context.getString(R.string.area)
//                area.text =
//                    areaText.plus(" : ").plus(address?.o_area)
//            }
            if (address?.is_primary.equals("Y")) {
                isDefault.setImageResource(
                    R.drawable.is_primary_img
                )
            } else {
                isDefault.setImageResource(
                    R.drawable.not_primary_img
                )
            }
        }
    }


}