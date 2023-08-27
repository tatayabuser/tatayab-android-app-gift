package com.tatayab.tatayab.main.home.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tatayab.model.Supplier
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSupplierListener
import kotlinx.android.synthetic.main.list_item_block_category.view.iv_category_img
import kotlinx.android.synthetic.main.list_item_block_supplier.view.*


class SuppliersAdapter(private val listener: OnSupplierListener) :

    RecyclerView.Adapter<SuppliersAdapter.ViewHolder>() {
    private var items: List<Supplier>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_block_supplier))
    }

    fun setData(items: List<Supplier>?) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { holder.bind(it, listener) }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val supplierName = view.tv_supplier_name
        private val supplierImg = view.iv_supplier_img
        fun bind(
            supplier: Supplier,
            listener: OnSupplierListener
        ) {
            val context = itemView.context
            supplierName.text = supplier.name
            supplierName.visibility=View.GONE
            //supplierImg.visibility=View.GONE
            Log.d("TAG", "bindSupplier: ${supplier?.logo?.icon?.image_path} ${supplier?.logo?.icon?.https_image_path}${supplier?.logo?.icon?.http_image_path}${supplier?.logo?.icon?.image_y}${supplier?.logo?.icon?.relative_path}${supplier?.logo?.icon?.absolute_path}${supplier?.logo?.icon?.image_x}${supplier?.logo?.icon?.url}")
           try {
                Picasso.get()
                    .load(supplier?.logo?.icon?.url)
                    .placeholder(R.drawable.default_image2).into(supplierImg)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            itemView.setSafeOnClickListener {
                listener.onSupplierSelected(supplier.supplier_id?:"", supplier.name?:"")
            }
        }
    }
}