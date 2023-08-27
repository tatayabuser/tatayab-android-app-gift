package com.tatayab.tatayab.productdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.Variant
import com.tatayab.presentation.address.ChooseCityActivityViewModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnOptionVariantSelected
import kotlinx.android.synthetic.main.activity_choose_option.*
import kotlinx.android.synthetic.main.toolbar_choose_option.*


class ChooseOptionActivity : BaseActivity(), OnOptionVariantSelected {
    var varientList: List<com.tatayab.model.Variant>? = null
    var clickOption: Int? = 0

    var adapter: OptionsVariantsAdapter? = null
    private lateinit var viewModel: ChooseCityActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_option)
        // Hide tool bar
        val actionBar = supportActionBar
        actionBar?.hide()

        viewModel =
            ViewModelProviders.of(
                this
            ).get(ChooseCityActivityViewModel::class.java)

        if (intent.extras != null) {
            varientList = intent!!.extras!!.getParcelableArrayList<com.tatayab.model.Variant>(
                VARIENTS_LIST_HOLDER
            )
            product_name.text = intent!!.extras!!.getString(PRODUCT_NAME)
            brand_name.text = intent!!.extras!!.getString(BRAND_NAME)
            option_name.text = intent!!.extras!!.getString(OPTION_NAME)
            clickOption = intent!!.extras!!.getInt(OPTION_Click, 0)
//            try {
//                Glide.with(baseContext)
//                    .load(intent!!.extras!!.getString(PRODUCT_IMAGE))
//                    .apply(getPlaceholder())
//                    .into(product_img)
//            } catch (e: Exception) {
//            }

            try {
                Picasso.get()
                    .load( intent!!.extras!!.getString(PRODUCT_IMAGE))
                    .placeholder(R.drawable.default_image2).into(product_img)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

        initView()
    }

    private fun initView() {
        adapter = OptionsVariantsAdapter(this, clickOption!!)
        adapter?.setData(varientList as ArrayList<Variant>)
        varientsRecyclerView.adapter = adapter

        close.setSafeOnClickListener {
            finish()
        }
    }


    companion object {
        val VARIENTS_LIST_HOLDER = "VARIENTS_LIST_HOLDER"
        val VARINBT_INDEX = "VARINBT_INDEX"
        val OPTION_INDEX = "OPTION_INDEX"
        val PRODUCT_NAME = "PRODUCT_NAME"
        val PRODUCT_IMAGE = "PRODUCT_IMAGE"
        val BRAND_NAME = "BRAND_NAME"
        val OPTION_NAME = "OPTION_NAME"
        val OPTION_Click = "OPTION_Click"
        val START_FORE_RESULT_ID_HOLDER = 55555

        fun getInstance(
            activity: Context, variantsList: ArrayList<com.tatayab.model.Variant>?,
            productName: String,
            productImage: String,
            brandName: String,
            optionName: String,
            optionClick: Int
        ): Intent {
            var intent = Intent(activity, ChooseOptionActivity::class.java)
            if (variantsList != null) {
                intent.putParcelableArrayListExtra(VARIENTS_LIST_HOLDER, variantsList)
                intent.putExtra(PRODUCT_NAME, productName)
                intent.putExtra(PRODUCT_IMAGE, productImage)
                intent.putExtra(BRAND_NAME, brandName)
                intent.putExtra(OPTION_NAME, optionName)
                intent.putExtra(OPTION_Click, optionClick)
            }
            return intent;
        }
    }

    override fun onOptionSelected(optionindex: Int, varientindex: Int) {
        val returnIntent = Intent()
        returnIntent.putExtra(VARINBT_INDEX, varientindex)
        returnIntent.putExtra(OPTION_INDEX, optionindex)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

}
