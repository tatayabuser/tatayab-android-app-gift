package com.tatayab.tatayab.supplier

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.presentation.state.ResourceState
import com.tatayab.presentation.suppliers.SuppliersFragmentViewModel
import com.tatayab.presentation.suppliers.SuppliersFragmentViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.listener.OnSupplierListener
import com.tatayab.tatayab.util.Constants.GRAPH_BRANDS_KEY
import kotlinx.android.synthetic.main.fragment_supplier.*
import java.util.*
import javax.inject.Inject


class SupplierFragment : BaseFragment2(), OnSupplierListener {

    private var mAdapter: SupplierAdapter? = null

    override fun onSupplierSelected(supplierId: String, supplierName: String) {
        val nextAction = SupplierFragmentDirections.nextProductsInSupplier(
            "supplier_ids",
            supplierId,
            supplierName,
            GRAPH_BRANDS_KEY
        )
        findNavController().navigate(nextAction)
    }

    override fun layoutId(): Int = R.layout.fragment_supplier

    lateinit var viewModel: SuppliersFragmentViewModel

    @Inject
    lateinit var viewModelFactory: SuppliersFragmentViewModelFactory.Factory

    private val suppliersAdapter = SuppliersAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory.create(App.getPref().currentLanguage.toString())
        ).get(SuppliersFragmentViewModel::class.java)
        viewModel.getSuppliersResponseLiveData.observe(this, Observer {
            when (it.status) {

                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    it.data.let {
                        try {
                            if (it.isNullOrEmpty()) {
                                initReyclerView(ArrayList<SupplierResponse>())
                            }else{
                                initReyclerView(moveHashListToLast(it!!))
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            initReyclerView(moveHashListToLast(it!!))
                        }

                    }
                }
            }
        }
        )
    }

    private fun moveHashListToLast(supplierList: ArrayList<SupplierResponse>): ArrayList<SupplierResponse> {
        var LastSuppliersList: ArrayList<SupplierResponse> = ArrayList()
        var hashSuppliersList: ArrayList<SupplierResponse> = ArrayList()
        try {
            for (supplier in supplierList!!) {
                removeSpacesFromName(supplier)
                if (supplier.name.isNullOrBlank() || !isLetters(supplier.name.get(0).toString())) {
                    hashSuppliersList.add(supplier)
                } else {
                    LastSuppliersList.add(supplier)
                }
            }
            Collections.sort(LastSuppliersList, SupplierResponse.titleNameComparator)
            LastSuppliersList.addAll(hashSuppliersList)
        } catch (e: Exception) {
            println(".... exception : " + e.message)
        }
        return LastSuppliersList
    }

    private fun removeSpacesFromName(supplier: SupplierResponse) {
        try {
            if (!supplier.name.isNullOrEmpty()){
                while(supplier.name.startsWith(" ")){
                    supplier.name = supplier.name.drop(1)
                 }
            }

        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun isLetters(char: String): Boolean {
        return char.filter { it in 'A'..'Z' || it in 'a'..'z' }.length == char.length || isArabicChar(
            char
        )
    }

    private fun isArabicChar(chr: String): Boolean {
        val c = chr.codePointAt(0)
        if (c >= 0x0600 && c <= 0x06E0)
            return true

        return false
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_suppliers.layoutManager = GridLayoutManager(activity, 3)
        rv_suppliers.adapter = suppliersAdapter
        viewModel.getSuppliers()
    }

    private fun initReyclerView(mSuppliersList: List<SupplierResponse>) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        mAdapter = SupplierAdapter(this, mSuppliersList, requireActivity())
        recyclerView.adapter = mAdapter
        recyclerView.setIndexTextSize(10)

          recyclerView.setIndexBarTextColor(R.color.white)
        recyclerView.setIndexBarHighLightTextVisibility(true);
        recyclerView.setIndexBarStrokeVisibility(true);
        recyclerView.setIndexbarHighLightTextColor(R.color.colorPrimary)

        recyclerView.setIndexBarVisibility(true)
        recyclerView.setIndexbarMargin(100f)
        recyclerView.setPreviewVisibility(true)
        recyclerView.setIndexBarTransparentValue(1.0.toFloat())
    }


//    private fun setupViewData(data: PagedList<Supplier>) {
//        suppliersAdapter.submitList(data) {
//
//            val layoutManager = rv_suppliers.layoutManager as GridLayoutManager
//            val position = layoutManager.findFirstCompletelyVisibleItemPosition()
//            if (position != RecyclerView.NO_POSITION) {
//                rv_suppliers.scrollToPosition(position)
//            }
//        }
//    }

}
