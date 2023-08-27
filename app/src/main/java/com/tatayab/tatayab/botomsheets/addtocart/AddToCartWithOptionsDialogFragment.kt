package com.tatayab.tatayab.botomsheets.addtocart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.tatayab.model.ProductX
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.addtocartdialog.OptionsSheetAdapter
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOptionSelectedFromSheet
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.addto_cart_with_options_sheet.*
import kotlinx.android.synthetic.main.list_item_options_sheet.view.*

const val PRODUCT_ITEM = "PRODUCT_ITEM"

class AddToCartWithOptionsDialogFragment(private val mainViewModel: MainActivityViewModel) :
    BottomSheetDialogFragment(), OnOptionSelectedFromSheet {


    private val options: HashMap<String, String> = hashMapOf()
    private lateinit var productId: String
    var optionsSheetAdapter: OptionsSheetAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.addto_cart_with_options_sheet, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.getProductOptionsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.SUCCESS -> {
                    options_progress?.visibility = View.GONE
                    optionsSheetAdapter = OptionsSheetAdapter(this, it.data?.options!!)
                    rv_product_options?.adapter = optionsSheetAdapter
                }
                ResourceState.ERROR ->
                    Snackbar.make(
                        rv_product_options,
                        getText(R.string.error_occure).toString(),
                        Snackbar.LENGTH_SHORT
                    )
                // showCustomTopMessage(message = getText(R.string.error_occure).toString(),mMessageType = DialogUtil.MessageType.ERROR)
                else ->
                    options_progress?.visibility = View.VISIBLE
            }
        })


        mainViewModel.getProductAddedToCartFromSheet.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    options_progress?.visibility = View.GONE
                    add_to_cart_animi.visibility = View.GONE
                    add_to_cart.visibility = View.VISIBLE
                }
                ResourceState.SUCCESS -> {
                    Toast.makeText(context, getText(R.string.added_to_cart), Toast.LENGTH_SHORT)
                        .show()
                    this.dismiss()
                }
                else -> {
                    options_progress?.visibility = View.VISIBLE
                }
            }
        })
    }


    private fun validateOptions(): Boolean {
        try {
            if (optionsSheetAdapter == null && optionsSheetAdapter?.itemCount!! == 0) return false
            for (index in 0 until optionsSheetAdapter?.itemCount!!) {
                if (!optionsSheetAdapter?.optionsitems?.get(index)?.isSelected!!) {
                    val holder =
                        rv_product_options.findViewHolderForAdapterPosition(index) as OptionsSheetAdapter.OptionsViewHolder
                    holder.itemView.tv_option_name.text =
                        holder.itemView.tv_option_name.text.toString().removeSuffix("*").plus("*")
                    holder.itemView.tv_option_name.setTextColor(resources.getColor(R.color.red))
                    holder.itemView.tv_option_name.animation =
                        AnimationUtils.loadAnimation(context, R.anim.pop_enter_slide_up)
                    main_view.post {
                        //  main_view.scrollTo(0, rv_product_options.top)
                        rv_product_options.scrollToPosition(index)
                        holder.itemView.animation =
                            AnimationUtils.loadAnimation(context, R.anim.pop_enter_slide_up)
                        holder.itemView.setBackgroundColor(resources.getColor(R.color.focia))
                        main_view.postDelayed(
                            {
                                holder.itemView.setBackgroundColor(resources.getColor(R.color.white))
                            }, 300
                        )
                    }
                    return false
                }
            }
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product: ProductX? = arguments?.getParcelable<ProductX>(PRODUCT_ITEM)
        productId = product?.product_id!!

        product_name_title.text = product.title
        brand_name.text = product.supplier_name
        tv_product_name.text = product.title
        if (product.discount_perc!! > 0) {
            tv_old_price.visibility = View.VISIBLE
            tv_old_price.text = getString(
                R.string.currency,
                NumbersUtil.formatNumber(
                    product.old_price!!.toFloat(),
                    mainViewModel.getDecimalNumbers()
                ),
                mainViewModel.getCurrencyCode()
            )
            tv_product_price.text = getString(
                R.string.currency,
                NumbersUtil.formatNumber(
                    product.price.toFloat(),
                    mainViewModel.getDecimalNumbers()
                ),
                mainViewModel.getCurrencyCode()
            )
        } else {
            tv_old_price.visibility = View.INVISIBLE
            tv_product_price.text = getString(
                R.string.currency,
                NumbersUtil.formatNumber(
                    product.price.toFloat(),
                    mainViewModel.getDecimalNumbers()
                ),
                mainViewModel.getCurrencyCode()
            )
            tv_product_price.setTextColor(resources.getColor(R.color.dark_blue))
        }
//        try {
//            Glide.with(this)
//                .load(product.image)
//                .into(product_img)
//        } catch (e: Exception) {
//        }

        try {
            Picasso.get()
                .load(product.image)
                .placeholder(R.drawable.default_image2).into(product_img)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        options_progress.visibility = View.VISIBLE
//        mainViewModel.getProductOptions(productId)

        add_to_cart.setSafeOnClickListener {
            if (validateOptions()) {
                mainViewModel.addToCart(
                    product,
                    selectedOptions = options, addedFromSheet = true
                )

                add_to_cart.visibility = View.INVISIBLE
                add_to_cart_animi.visibility = View.VISIBLE
            }
        }

        close.setSafeOnClickListener {
            this.dismiss()
        }
    }

    companion object {
        fun newInstance(
            product: ProductX,
            mainViewModel: MainActivityViewModel
        ): AddToCartWithOptionsDialogFragment =
            AddToCartWithOptionsDialogFragment(mainViewModel).apply {
                arguments = Bundle().apply {
                    putParcelable(PRODUCT_ITEM, product)
                }
            }
    }

    override fun OnOptionSelected(indexPosition: Int, optionId: Int, varaintId: Int) {

        optionsSheetAdapter?.optionsitems?.get(indexPosition)?.isSelected = true
        //optionsSheetAdapter?.notifyItemChanged(indexPosition)
        val holder =
            rv_product_options.findViewHolderForAdapterPosition(indexPosition) as OptionsSheetAdapter.OptionsViewHolder
        holder.itemView.tv_option_name.text =
            holder.itemView.tv_option_name.text.toString().removeSuffix("*")
        holder.itemView.tv_option_name.setTextColor(resources.getColor(R.color.dark_blue))

        options.put(optionId.toString(), varaintId.toString())

    }
}
