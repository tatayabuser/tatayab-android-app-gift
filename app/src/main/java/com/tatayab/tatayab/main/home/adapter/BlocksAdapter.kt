package com.tatayab.tatayab.main.home.adapter

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.home.ViewTypeLayout
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.listener.*
import com.tatayab.tatayab.main.home.viewholder.*


class BlocksAdapter(
    private val productListener: OnProductListenerInHome,
    private val trendListener: OnTrendListener,
    private val categoryListener: OnCategoryListenerInHome,
    private val supplierListener: OnSupplierListener,
    private val seeMoreSupplierListener: OnSeeMoreSupplierListener,
    private val seeMoreCategoryListener: OnSeeMoreCategoryListener,
    private val flashTimeLiveData: LiveData<Pair<Boolean, String>>,
    private val decimalNumber: Int,
    private val mOnConciergeListener: OnConciergeListener
) :
    RecyclerView.Adapter<BlockViewHolder>() {

    var items: MutableList<CompositeBlockItem>? = mutableListOf()
    private var currencyCode: String? = null
    private val viewPool = RecyclerView.RecycledViewPool();


    val getItems: MutableList<CompositeBlockItem>?
        get() = items

    fun setData(currencyCode: String, items: List<CompositeBlockItem>?) {
        items?.let {
            this.items?.addAll(0, items)
        }
        this.currencyCode = currencyCode
        notifyDataSetChanged()
    }


    fun setItemData(item: CompositeBlockItem) {
        this.items?.set(item.position, item)
        notifyItemChanged(item.position)
    }


    fun changeWishlist(productId: String, newStatues: Boolean) {
        var newChange = false //// if product exists notify its block
        this.items?.forEach {
            if (!it.productsResponse?.products.isNullOrEmpty()) {
                it.productsResponse?.products?.map {
                    if (it?.product_id == productId) {
                        if (!newStatues) it.inWishlist = 0 else it.inWishlist = 1
                        newChange = true
                    }
                }
                if (newChange) {
                    notifyItemChanged(items?.indexOf(it)!!)
                    newChange = false
                }
            }
        }
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val compositeBock = items?.get(position)
        when (compositeBock?.viewTypeLayout) {
            ViewTypeLayout.SLIDER -> {
                if (compositeBock.blockLayoutResponse == null) return
                holder.bindToSlider(compositeBock, trendListener)
            }
            ViewTypeLayout.SLIDE_TWO -> {
                holder.bindSlideTwoProducts(
                    currencyCode!!,
                    compositeBock,
                    productListener
                )
            }
            ViewTypeLayout.PRODUCTS -> {
                holder.bindProducts(
                    currencyCode!!,
                    compositeBock,
                    productListener
                )
            }

            ViewTypeLayout.FLASH_SALE -> {
                holder.bindFlashSaleProducts(
                    currencyCode!!,
                    compositeBock,
                    productListener,
                    flashTimeLiveData
                )
            }

            ViewTypeLayout.CATEGORIES -> {
                holder.bindToCategory(
                    compositeBock,
                    categoryListener,
                    seeMoreCategoryListener
                )
            }
            ViewTypeLayout.FREE_DELIVERY -> {
                holder.bindToFreeDelivery(
                    compositeBock.blockLayoutResponse,
                    compositeBock.sectionName
                )
            }
            ViewTypeLayout.ONE_OFFER -> {
                holder.bindToOneOffer(
                    compositeBock.blockLayoutResponse,
                    compositeBock.sectionName,
                    compositeBock.subTitle,
                    trendListener
                )
            }
            ViewTypeLayout.CONCIERGE -> {
                holder.bindConcierge(compositeBock, mOnConciergeListener)
            }
            ViewTypeLayout.MORE_THAN_ONE_OFFER -> {
                holder.bindToMoreThanOneOffer(
                    compositeBock.blockLayoutResponse,
                    compositeBock.sectionName,
                    trendListener
                )
            }
            ViewTypeLayout.SUPPLIER -> {
                holder.bindToSupplier(
                    compositeBock,
                    supplierListener,
                    seeMoreSupplierListener,
                    viewPool
                )
            }
            else -> {
                throw IllegalArgumentException("Illegal value for viewType")
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
         return when (viewType) {
            ViewTypeLayout.MORE_THAN_ONE_OFFER.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.item_block_offer_gridview),
                decimalNumber
            )
            ViewTypeLayout.SLIDER.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_slider),
                decimalNumber
            )
            ViewTypeLayout.CATEGORIES.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_categories),
                decimalNumber
            )
            ViewTypeLayout.SUPPLIER.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_supplier),
                decimalNumber
            )
            ViewTypeLayout.FLASH_SALE.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_flash_products),
                decimalNumber
            )
            ViewTypeLayout.FREE_DELIVERY.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_free_delivery),
                decimalNumber
            )
            ViewTypeLayout.SLIDE_TWO.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_slide_two),
                decimalNumber
            )
            ViewTypeLayout.ONE_OFFER.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_one_offer),
                decimalNumber
            )

            ViewTypeLayout.PRODUCTS.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.block_products),
                decimalNumber
            )
            ViewTypeLayout.CONCIERGE.ordinal -> BlockViewHolder(
                parent.inflate(R.layout.item_concierge),
                decimalNumber
            )
            else -> throw IllegalArgumentException("Illegal value for viewType")
        }
    }


    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return when (items?.get(position)?.viewTypeLayout) {
            ViewTypeLayout.SLIDER -> {
                ViewTypeLayout.SLIDER.ordinal
            }
            ViewTypeLayout.CATEGORIES -> {
                ViewTypeLayout.CATEGORIES.ordinal
            }
            ViewTypeLayout.SUPPLIER -> {
                ViewTypeLayout.SUPPLIER.ordinal
            }
            ViewTypeLayout.FREE_DELIVERY -> {
                ViewTypeLayout.FREE_DELIVERY.ordinal
            }
            ViewTypeLayout.ONE_OFFER -> {
                ViewTypeLayout.ONE_OFFER.ordinal
            }
            ViewTypeLayout.MORE_THAN_ONE_OFFER -> {
                ViewTypeLayout.MORE_THAN_ONE_OFFER.ordinal
            }
            ViewTypeLayout.PRODUCTS -> {
                ViewTypeLayout.PRODUCTS.ordinal
            }
            ViewTypeLayout.FLASH_SALE -> {
                ViewTypeLayout.FLASH_SALE.ordinal
            }
            ViewTypeLayout.CONCIERGE -> {
                ViewTypeLayout.CONCIERGE.ordinal
            }
            else -> {
                ViewTypeLayout.SLIDE_TWO.ordinal
            }
        }
    }

}

