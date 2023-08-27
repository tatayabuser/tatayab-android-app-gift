package com.tatayab.tatayab.main.concierge

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.presentation.addconcierge.ConciergeViewModel
import com.tatayab.presentation.addconcierge.ConciergeViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.isValid
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.ImageUtil
import kotlinx.android.synthetic.main.fragment_concierge.*
import kotlinx.android.synthetic.main.list_item_subcategory2.view.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import javax.inject.Inject


class ConciergeFragment : BaseFragment2() {


    lateinit var viewModel: ConciergeViewModel

    @Inject
    lateinit var mConciergeViewModelFactory: ConciergeViewModelFactory.Factory

    override fun layoutId(): Int {
        return R.layout.fragment_concierge
    }

    private val GALLERY = 1
    private val CAMERA = 2
    private val READ_STORAGE_REQUEST = 111
    private val MY_CAMERA_PERMISSION_CODE = 2124

    val conciergeRequestBody: ConciergeRequestBody = ConciergeRequestBody()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProviders.of(this, mConciergeViewModelFactory.create())
                .get(ConciergeViewModel::class.java)

        viewModel.getconciergeResponseLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     base_loading.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    base_loading.visibility = View.GONE
                    if (it.data?.status.equals("success")) {
                        resetForm()
                        showSuccessAlert()
                        hideKeyboard()
                    } else
                        showCustomTopMessage(
                            getString(R.string.completedata),
                            DialogUtil.MessageType.ERROR
                        )

                }
                else -> {
                    base_loading.visibility = View.VISIBLE

                 }
            }
        })
    }

    private fun resetForm() {
        perfumeNameEditText.setText("")
        commentEditText.setText("")
        nameEditText.setText("")
        phoneEditText.setText("")
        perfumeImageView.setImageDrawable(resources.getDrawable(R.drawable.upload_img))
    }

    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(context)
        pictureDialog.setTitle(R.string.select_perfum_img)
        val pictureDialogItems =
            arrayOf(getText(R.string.select_from_galery), getText(R.string.select_from_camera))
        pictureDialog.setItems(
            pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }


    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, GALLERY)
    }

    private fun takePhotoFromCamera() {
        try {
            // check on permission
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    MY_CAMERA_PERMISSION_CODE
                )
            } else {
               openCamera()
            }

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun openCamera() {
        try{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        perfumeImageView.setSafeOnClickListener {

            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                != PackageManager.PERMISSION_GRANTED
            )
                requestPermissions(
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_STORAGE_REQUEST
                )
            else
                showPictureDialog()
        }

        submitButton.setSafeOnClickListener {
            if (nameEditText.isValid(getText(R.string.name).toString())
                 && perfumeNameEditText.isValid(getText(R.string.hint_Perfume_Name).toString())
                && commentEditText.isValid(getText(R.string.hint_comment).toString())&& validatePhoneNumber(phoneEditText.text.toString())
            ) {
                conciergeRequestBody.comment = commentEditText.text.toString()
                conciergeRequestBody.cust_name = nameEditText.text.toString()
                conciergeRequestBody.perfume_name = perfumeNameEditText.text.toString()
                conciergeRequestBody.phone = phoneEditText.text.toString()
                conciergeRequestBody.country_code = viewModel.getCountryCode()
//                viewModel.addConcierge(conciergeRequestBody)
            }
        }
    }

    private fun validatePhoneNumber(phone: String): Boolean {
        val validateMessage = viewModel.validatePhone(phone)
        if (validateMessage != "1") {
            phoneEditText.error = formatePhoneErrorMessage(validateMessage)
            return false
        } else
            return true
    }
    private fun initView() {
        tv_title.text = getText(R.string.tatayab_concierge)
        phoneCodeEditText.text = viewModel.getCountryPhoneCode()
        iv_back?.setSafeOnClickListener { findNavController().popBackStack() }
        var countryFlag = viewModel.getCountryFlagUrl()
        if(!countryFlag.isNullOrEmpty()) {
            try {
                Picasso.get()
                    .load(countryFlag)
                    .placeholder(R.drawable.default_image2).into(countryFlagImageView)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
//            Glide.with(requireActivity())
//                .load(countryFlag)
//                 .into(countryFlagImageView)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY) {
                val mImageUri = data?.data!!
                perfumeImageView.setImageURI(mImageUri)
                val bitmap =
                    MediaStore.Images.Media.getBitmap(activity?.getContentResolver(), mImageUri)
                conciergeRequestBody.image_data = ImageUtil.getBase64FromBitmab(bitmap)
            } else if (requestCode == CAMERA) {
                val thumbnail = data!!.extras!!.get("data") as Bitmap
                perfumeImageView!!.setImageBitmap(thumbnail)
                conciergeRequestBody.image_data = ImageUtil.getBase64FromBitmab(thumbnail)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == READ_STORAGE_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showPictureDialog()
            } else {
                showCustomTopMessage(
                    getString(R.string.photo_permission_deny),
                    DialogUtil.MessageType.ERROR
                )
            }
        }else if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                showCustomTopMessage(
                    getString(R.string.camera_permission),
                    DialogUtil.MessageType.ERROR
                )
            }
        }
    }

    fun showSuccessAlert() {

        val builder = AlertDialog.Builder(context)

        with(builder)
        {
            setTitle(getString(R.string.success_Concierince_title))
            setMessage(R.string.concierge_process)
            setPositiveButton(
                R.string.close
            ) { dialog: DialogInterface, which: Int ->
                dialog.dismiss()
                onBackPressed()
            }
            show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
