package com.tatayab.tatayab.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tatayab.model.Category
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.responses.CategoryItem
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnCategoryListenerInHome
import com.tatayab.tatayab.listener.OnSeeMoreCategoryListener
import com.tatayab.tatayab.main.home.adapter.CategoriesAdapter
import com.tatayab.tatayab.util.TextUtil
import kotlinx.android.synthetic.main.block_categories.view.*
import timber.log.Timber


class CategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    //private val supplierName = view.tv_supplier_name
    private val title = view.tv_title
    private val description = view.tv_description
    private val seeMore = view.tv_see_more

    val recyclerViewCategory: RecyclerView = view.rv_categories

    companion object {
        lateinit var layoutManager: LinearLayoutManager
    }

    private lateinit var categoriesAdapter: CategoriesAdapter
    fun bind(
        compositeBlockItem: CompositeBlockItem?,
        seeMoreListener: OnSeeMoreCategoryListener,
        listener: OnCategoryListenerInHome
    ) {
        var categoryList: ArrayList<CategoryItem>? = compositeBlockItem?.categoryResponse
        var sectionName = compositeBlockItem?.sectionName
        val context = itemView.context
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

//        val params = itemView.layoutParams
//        params?.height = (((ViewUtil.getScreenWidth()))* 0.55).toInt()
//        itemView.layoutParams = params

        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerViewCategory.setHasFixedSize(true)
        recyclerViewCategory.layoutManager = layoutManager
        categoriesAdapter = CategoriesAdapter(listener)
        recyclerViewCategory.adapter = categoriesAdapter
        categoriesAdapter.setData(categoryList ?: ArrayList())
//        if (compositeBlockItem?.catId == null || compositeBlockItem?.catId == 0){
//            seeMore.visibility = View.GONE
//        }else{
//            seeMore?.visibility = View.VISIBLE
//        }
         seeMore.setSafeOnClickListener {
            seeMoreListener.seeMoreCategory()
        }
        try {
            if (recyclerViewCategory != null) {
                recyclerViewCategory.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val lastPosition =
                            layoutManager.findLastVisibleItemPosition()
                        compositeBlockItem?.lastPosition = lastPosition
                     }
                })
                if (categoryList != null && categoryList?.size!! > compositeBlockItem?.lastPosition!! && compositeBlockItem?.lastPosition!! > 4
                ) {
                     recyclerViewCategory.scrollToPosition(compositeBlockItem?.lastPosition!! - 4)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.d("onScroll$e.")

        }

    }
}