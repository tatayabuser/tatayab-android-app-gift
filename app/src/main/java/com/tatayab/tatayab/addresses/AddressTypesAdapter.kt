package com.tatayab.tatayab.addresses

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.addresses.AddressType
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.item_spinner.view.*

class AddressTypesAdapter(val items : List<AddressType>,val context: Context) :
     SpinnerAdapter {
    var inflater: LayoutInflater = LayoutInflater.from(context)

    class AddressTypesViewHolder(val view: View) :
        RecyclerView.ViewHolder(view.rootView)


    override fun registerDataSetObserver(observer: DataSetObserver?) {
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }


    override fun getCount(): Int = items.size


    override fun getItem(position: Int): AddressType {
            return items[position]
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return   LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner, parent, false)
    }

    override fun getItemViewType(position: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int = items.size

    override fun isEmpty(): Boolean = items.isEmpty()

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {

        return   LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner, parent, false)

    }


}