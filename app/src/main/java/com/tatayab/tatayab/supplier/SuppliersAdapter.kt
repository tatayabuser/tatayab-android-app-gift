package com.tatayab.tatayab.supplier

import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Supplier
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSupplierListener
import kotlinx.android.synthetic.main.list_item_supplier.view.*

class SuppliersAdapter(private val listener: OnSupplierListener) :

    PagedListAdapter<Supplier, SuppliersAdapter.ViewHolder>(SUPPLIER_COMPARATOR) {
    val layoutId: Int = R.layout.list_item_supplier

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position)!!, listener)
    }


    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var supplier: Supplier
        private val image = view.iv_supplier_img
        private val name = view.tv_supplier_name

        fun bind(supplier: Supplier, listener: OnSupplierListener) {

            this.supplier = supplier
            val context = itemView.context
            try {
                name.text = supplier.name
                itemView.setSafeOnClickListener {
                    listener.onSupplierSelected(
                        supplier.supplier_id,
                        if(supplier.name.isNullOrBlank()) " " else supplier.name
                    )
                }
                if (supplier.logo?.icon?.image_path?.isNotEmpty() == true) {
                    image.visibility = View.VISIBLE
                    try {
                        Picasso.get()
                            .load( supplier?.logo?.icon?.image_path)
                            .placeholder(R.drawable.default_image2).into(image)

                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
//                    Glide.with(context).load(supplier?.logo?.icon?.image_path).apply(getPlaceholder()).into(image)
                }else{
                    image.visibility = View.INVISIBLE
                }

            } catch (e: Exception) {
                Log.d("exc", e.toString())
            }
        }
    }

    companion object {

        private val SUPPLIER_COMPARATOR = object : DiffUtil.ItemCallback<Supplier>() {
            override fun areItemsTheSame(oldItem: Supplier, newItem: Supplier): Boolean =
                TextUtils.equals(
                    oldItem.supplier_id,
                    newItem.supplier_id
                ) && TextUtils.equals(oldItem.name, newItem.name)

            override fun areContentsTheSame(
                oldItem: Supplier,
                newItem: Supplier
            ): Boolean =
                oldItem == newItem

        }

    }
}