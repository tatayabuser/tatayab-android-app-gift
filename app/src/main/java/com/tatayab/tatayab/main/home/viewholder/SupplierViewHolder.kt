package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tatayab.model.Supplier
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSeeMoreSupplierListener
import com.tatayab.tatayab.listener.OnSupplierListener
import com.tatayab.tatayab.main.home.adapter.SuppliersAdapter
import com.tatayab.tatayab.util.TextUtil
 import kotlinx.android.synthetic.main.block_supplier.view.*
import timber.log.Timber


class SupplierViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val seeMore = view.tv_see_more
    private val title = view.tv_title
    private val description = view.tv_description

    val recyclerViewSuppliers: RecyclerView = view.rv_suppliers

    companion object {
        lateinit var layoutManager: LinearLayoutManager
    }

    private lateinit var suppliersAdapter: SuppliersAdapter
    fun bind(
        compositeBlockItem: CompositeBlockItem?,
        listener: OnSupplierListener,
        seeMoreSupplierListener: OnSeeMoreSupplierListener
    ) {
        val context = itemView.context
        var supplierList: List<Supplier>? = compositeBlockItem?.suppliersResponse?.suppliers
        var sectionName = compositeBlockItem?.sectionName
//        val params = itemView.layoutParams
//        params?.height = (((ViewUtil.getScreenWidth()))* 0.48).toInt()
//        itemView.layoutParams = params

        val allDescriptions = TextUtil.splitTitle(sectionName)
        try{
            title.text = allDescriptions?.get(0) ?: ""
            if(compositeBlockItem?.subTitle.isNullOrBlank()) {
                description.text = if (allDescriptions?.size!! > 1) allDescriptions?.get(1) else ""
            }else{
                description.text = compositeBlockItem?.subTitle.toString()
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
//        if (compositeBlockItem?.catId == null || compositeBlockItem?.catId == 0){
//            seeMore.visibility = View.GONE
//        }else{
//            seeMore?.visibility = View.VISIBLE
//        }
        seeMore.setSafeOnClickListener {
            seeMoreSupplierListener.seeMoreSupplier()
        }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerViewSuppliers.setHasFixedSize(true)
        recyclerViewSuppliers.layoutManager = layoutManager
        suppliersAdapter = SuppliersAdapter(listener)
        recyclerViewSuppliers.adapter = suppliersAdapter
        suppliersAdapter.setData(supplierList)
        try {
            if (recyclerViewSuppliers != null) {
                recyclerViewSuppliers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val lastPosition =
                            layoutManager.findLastVisibleItemPosition()
                        compositeBlockItem?.lastPosition = lastPosition
                     }
                })
                if (supplierList != null && supplierList?.size!! > compositeBlockItem?.lastPosition!! && compositeBlockItem?.lastPosition!! > 2
                ) {
                     recyclerViewSuppliers.scrollToPosition(compositeBlockItem?.lastPosition!! - 2)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.d("onScroll$e.")

        }
    }
}