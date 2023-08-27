package com.tatayab.tatayab.checkout

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ClipData
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import com.tatayab.model.KnetData
import com.tatayab.presentation.Utils
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModel
import com.tatayab.tatayab.checkout.view_model.PaymentFragmentViewModelFactory
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_payment.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class PaymentFragment : BaseFragment() {

    private val file_type = "*/*" // file types to be allowed for upload
    private var multiple_files = true // allowing multiple file upload
    private var cam_file_data: String? = null // for storing camera file information
    private var file_data: ValueCallback<Uri>? = null // data/header received after file selection
    private var file_path: ValueCallback<Array<Uri>>? = null  // received file(s) temp. location
    private val file_req_code = 1

    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var viewModel: PaymentFragmentViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    @Inject
    lateinit var PaymentFragmentViewModelFactor: PaymentFragmentViewModelFactory.Factory
    /*
    * private String cam_file_data = null;        // for storing camera file information
    private ValueCallback<Uri> file_data;       // data/header received after file selection
    private ValueCallback<Uri[]> file_path;     // received file(s) temp. location

    private final static int file_req_code = 1;
    * */

    val logParams = Bundle()
    private val orderData by lazy {
        arguments?.let {
            PaymentFragmentArgs.fromBundle(
                it
            ).orderData
        } ?: null
    }

    val P_Tag = "Payment url: "
    override fun layoutId(): Int {
        return R.layout.fragment_payment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logParams.putString("Start Payment", "true")
        Log.d(P_Tag, "Start Payment Now ")

        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel = activity?.run {
            ViewModelProviders.of(
                this,
                PaymentFragmentViewModelFactor.create(App.getPref().currentLanguage.toString())
            )[PaymentFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        viewModel?.getRestoreCartLiveData!!.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
                    findNavController().popBackStack()
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
                    findNavController().popBackStack()
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

        intComponent()
        initAction()

    }

    private fun initAction() {
        iv_back.setOnClickListener {
//            viewModel?.restoreCart()
            Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
            findNavController().popBackStack()
        }
    }

    var isEntryLoaded = false
    var isPayLoaded = false

    @SuppressLint("SetJavaScriptEnabled")
    private fun intComponent() {

        web_view_payment.settings.javaScriptEnabled = true
        web_view_payment.settings.domStorageEnabled = true
        web_view_payment.settings.builtInZoomControls = true
        web_view_payment.settings.displayZoomControls = false
        web_view_payment.settings.javaScriptCanOpenWindowsAutomatically = true
        web_view_payment.settings.allowContentAccess = true
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(web_view_payment, true)
            web_view_payment.settings.setMixedContentMode(0);
            web_view_payment.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            CookieManager.getInstance().setAcceptCookie(true)
            web_view_payment.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        }
        web_view_payment.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                try {
                    if (file_permission() && Build.VERSION.SDK_INT >= 21) {
                        file_path = filePathCallback;
                        var takePictureIntent: Intent? = null;
                        var includePhoto = false;

                        /*-- checking the accept parameter to determine which intent(s) to include --*/
                        for (acceptTypes in fileChooserParams!!.acceptTypes) {
                            val splitTypes =
                                acceptTypes.split(", ?+".toRegex())
                                    .toTypedArray() // although it's an array, it still seems to be the whole value; split it out into chunks so that we can detect multiple values
                            for (acceptType in splitTypes) {
                                when (acceptType) {
                                    "*/*" -> {
                                        includePhoto = true
                                        return true
                                    }
                                    "image/*" -> includePhoto = true
                                }
                            }
                        }
                        if (fileChooserParams.getAcceptTypes()
                                .isEmpty()
                        ) {   //no `accept` parameter was specified, allow both photo and video
                            includePhoto = true;
                        }

                        if (includePhoto) {
                            takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            if (takePictureIntent.resolveActivity(activity!!.getPackageManager()) != null) {
                                var photoFile: File? = null
                                try {
                                    photoFile = create_image()
                                    takePictureIntent.putExtra("PhotoPath", cam_file_data)
                                } catch (ex: IOException) {
                                    Log.e("WEBVIEW Akl", "Image file creation failed", ex)
                                }
                                if (photoFile != null) {
                                    cam_file_data = "file:" + photoFile.getAbsolutePath()
                                    takePictureIntent.putExtra(
                                        MediaStore.EXTRA_OUTPUT,
                                        Uri.fromFile(photoFile)
                                    )
                                } else {
                                    cam_file_data = null
                                    takePictureIntent = null
                                }
                            }
                        }
                        val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
                        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
                        contentSelectionIntent.type = file_type
                        if (multiple_files) {
                            contentSelectionIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                        }

                        var intentArray: Array<Intent>? = null
                        if (takePictureIntent != null) {
                            var takePictureIntentList = ArrayList<Intent>()
                            takePictureIntentList.add(takePictureIntent)
                            intentArray = takePictureIntentList.toTypedArray()
                        } else {
                            intentArray = ArrayList<Intent>().toTypedArray()
                        }
                        val chooserIntent = Intent(Intent.ACTION_CHOOSER)
                        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
                        chooserIntent.putExtra(Intent.EXTRA_TITLE, "File chooser")
                        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
                        startActivityForResult(chooserIntent, file_req_code)
                        return true
                    } else {
                        return false
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    return false
                }
            }
        }

        println("http: orderData: "+orderData?.orderId)
        if (orderData == null) {
//            viewModel?.restoreCart()
            Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
            findNavController().popBackStack()
            return
        }
        web_view_payment.loadUrl(orderData?.redirectUrl!!)
        logParams.putString("url from backend", orderData?.redirectUrl)
        try {
            web_view_payment.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    setProgress(View.GONE)
                }

                override fun shouldOverrideUrlLoading(
                    webView: WebView?,
                    url: String?
                ): Boolean {
                    logParams.putString("shouldOverrideUrlLoading", url)
                    return shouldOverrideUrlLoading(url)

                }

                @TargetApi(Build.VERSION_CODES.N)
                override fun shouldOverrideUrlLoading(
                    webView: WebView?,
                    request: WebResourceRequest
                ): Boolean {
                    val uri = request.url
                    return shouldOverrideUrlLoading(webView, uri.toString())
                }

                override fun onReceivedError(
                    webView: WebView?,
                    errorCode: Int,
                    description: String,
                    failingUrl: String?
                ) {
                    handleError(errorCode, description, failingUrl)
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }


    private fun decodeBase64(coded: String?): String? {
        var valueDecoded: ByteArray? = ByteArray(0)
        try {
            valueDecoded = Base64.decode(coded?.toByteArray(charset("UTF-8")), Base64.DEFAULT)
        } catch (e: UnsupportedEncodingException) {
        }
        return valueDecoded?.let { String(it) }
    }


    @SuppressLint("InvalidAnalyticsName")
    private fun shouldOverrideUrlLoading(url: String?): Boolean {
        try {
            println("http: shouldOverrideUrlLoading/url: " + url)
            Timber.i("shouldOverrideUrlLoading() URL : $url")
            val uri: Uri = Uri.parse(url)

            // Master card
            if (url?.contains("graphqlpaymentsredirects/redirect/success",true)!!) {
                val action = PaymentFragmentDirections.orderSuccessAction(
                    orderId = orderData?.orderId.toString(),
                    knetData = null, paymentStatus = true
                )
                web_view_payment.stopLoading()
                updateCartId()
                findNavController().navigate(action)
            }else if (url?.contains("redirect/success",true)!!) {
                val action = PaymentFragmentDirections.orderSuccessAction(
                    orderId = orderData?.orderId.toString(),
                    knetData = null, paymentStatus = true
                )
                web_view_payment.stopLoading()
                updateCartId()
                findNavController().navigate(action)
            } else if(url?.contains("redirect/failure/",true)!!||url?.contains("cancel/",true)!!||url?.contains("?ttm_pgstats=CANCELED",true)!!|| url?.contains("/paymentcancel.htm",true)!!){
                activity?.resources?.let {
                    showCustomTopMessage(
                        activity?.resources?.getString(R.string.operation_dailed)
                            .toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                web_view_payment.stopLoading()
//                viewModel?.restoreCart()
                Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
                findNavController().popBackStack()
            }else {
                logParams.putString(" current url ", url)
                Log.d(P_Tag, url.toString())
                val ttmPgstats: String? = uri.getQueryParameter("ttm_pgstats")
                val result: String? = uri.getQueryParameter("result")
                if (ttmPgstats != null || result.isNullOrBlank().not()
                ) {
                    logParams.putString("contain ttmPgstats ", "true")
                    Log.d(P_Tag, ttmPgstats + "|result: " + result)
                    val resultData = checkForSuccess(uri, ttmPgstats, result)
                    if (resultData.first) {
                        Timber.e("Success")
                        (activity as MainActivity).clearCart()
                        var mKnetData: KnetData = KnetData()
                        if (Constants.ENABLE_GRAPH_QUERIES_CALLS) {
                            //https://magento-dev.tatayab.com/kw-en/graphqlpaymentsredirects/redirect/success?
                            // paymentid=100202217722652221&amount=36.72&result=CAPTURED&tranid=202217777280724&
                            // auth=B87811&ref=217710000496&trackid=5000000462&postdate=0627/
                            val paymentId: String? = uri.getQueryParameter("paymentid")
                            val amount: String? = uri.getQueryParameter("amount")
                            val transId: String? = uri.getQueryParameter("tranid")
                            val auth: String? = uri.getQueryParameter("auth")
                            val refId: String? = uri.getQueryParameter("ref")
                            val trackid: String? = uri.getQueryParameter("trackid")
                            val postdate: String? = uri.getQueryParameter("postdate")
                            mKnetData.knetStatus = "Success"
                            mKnetData.tabby_status = "Success"
                            mKnetData.paymentId = paymentId
                            mKnetData.refNo = refId
                            mKnetData.transId = transId
                        } else {
                            val gson = Gson()
                            mKnetData = gson.fromJson(resultData.second, KnetData::class.java)
                        }
                        val action = PaymentFragmentDirections.orderSuccessAction(
                            orderId = orderData?.orderId.toString(),
                            knetData = mKnetData, paymentStatus = true
                        )
                        logParams.putString(
                            "succuess payment with order # :",
                            orderData?.orderId.toString()
                        )
                        Log.d(
                            P_Tag,
                            "succuess payment with order # :" + orderData?.orderId.toString()
                        )

                        FirebaseAnalytics.getInstance(requireContext())
                            .logEvent("Paymnet", logParams)
                        updateCartId()
                        findNavController().navigate(action)
                    } else {
                        logParams.putString(
                            "faild payment with order # :",
                            orderData?.orderId.toString()
                        )
                        Log.d(P_Tag, "faild payment with order # :" + orderData?.orderId.toString())

                        FirebaseAnalytics.getInstance(requireContext())
                            .logEvent("Paymnet", logParams)

                        Timber.e("Fail")
                        //  Toast.makeText(context,getString(R.string.operation_dailed),Toast.LENGTH_LONG).show()
                        activity?.resources?.let {
                            showCustomTopMessage(
                                activity?.resources?.getString(R.string.operation_dailed)
                                    .toString(),
                                DialogUtil.MessageType.ERROR
                            )
                        }
                        val action = PaymentFragmentDirections.orderSuccessAction(
                            orderId = orderData?.orderId.toString(),
                            knetData = null, paymentStatus = false
                        )
//                        viewModel?.restoreCart()
                        Utils.CheckOutAction.action = Utils.CheckActionType.RELOAD_DATA
                        findNavController().popBackStack()
                    }
                    web_view_payment.stopLoading()
                    return true
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false // Load url in the webView itself
    }

    private fun handleError(errorCode: Int, description: String, failingUrl: String?) {
        Timber.e("Error :  $errorCode + ,   $description   URL :   $failingUrl")
        Log.d(P_Tag, "Error :  $errorCode + ,   $description   URL :   $failingUrl")
        println("shouldOverrideUrlLoading Error :  $errorCode  \n desc:  $description   \n URL :   $failingUrl")

    }

    private fun checkForSuccess(
        uri: Uri,
        ttmPgstats: String?,
        result: String?
    ): Pair<Boolean, String?> {
        //val args: Set<String> = uri.queryParameterNames
        logParams.putString("ttmPgstats:", ttmPgstats.toString() + "|" + result.toString())
        Log.d(P_Tag, ttmPgstats.toString())
        var finalResult = ttmPgstats
        if (finalResult.isNullOrBlank()) finalResult = result
        finalResult.let {
            return if (it?.toUpperCase(Locale.US).equals("CAPTURED")) {
                web_view_payment.stopLoading()
                logParams.putString("ttmData:", it)
                Log.d(P_Tag, it.toString())
                Pair(true, decodeBase64(it))
            } else {
                Pair(false, null)
            }
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                var results: Array<Uri>? = null
                /*-- if file request cancelled; exited camera. we need to send null value to make future attempts workable --*/
                if (resultCode == Activity.RESULT_CANCELED) {
                    file_path!!.onReceiveValue(null)
                    return
                }

                /*-- continue if response is positive --*/if (resultCode == Activity.RESULT_OK) {
                    if (null == file_path) {
                        return
                    }
                    var clipData: ClipData?
                    var stringData: String?
                    try {
                        clipData = intent!!.clipData!!
                        stringData = intent.dataString
                    } catch (e: java.lang.Exception) {
                        clipData = null
                        stringData = null
                    }
                    if (clipData == null && stringData == null && cam_file_data != null) {
                        results = arrayOf(Uri.parse(cam_file_data))
                    } else {
                        if (clipData != null) { // checking if multiple files selected or not
                            var resultsLocal = ArrayList<Uri>()
                            for (i in 0 until clipData.itemCount) {
                                resultsLocal.add(clipData.getItemAt(i).uri)
                            }
                            results = resultsLocal.toTypedArray()
                        } else {
                            try {
                                val cam_photo: Bitmap? = intent!!.extras!!["data"] as Bitmap?
                                val bytes = ByteArrayOutputStream()
                                cam_photo?.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
                                stringData = MediaStore.Images.Media.insertImage(
                                    activity?.getContentResolver(),
                                    cam_photo,
                                    null,
                                    null
                                )
                            } catch (ignored: java.lang.Exception) {
                            }
                            /* checking extra data
                           Bundle bundle = intent.getExtras();
                           if (bundle != null) {
                               for (String key : bundle.keySet()) {
                                   Log.w("ExtraData", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
                               }
                           }*/
                            var resultsLocal = ArrayList<Uri>()
                            resultsLocal.add(Uri.parse(stringData))
                            results = resultsLocal.toTypedArray()
                        }
                    }
                }
                file_path!!.onReceiveValue(results)
                file_path = null
            } else {
                if (requestCode == file_req_code) {
                    if (null == file_data) return
                    val result =
                        if (intent == null || resultCode != RESULT_OK) null else intent.data
                    file_data!!.onReceiveValue(result)
                    file_data = null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*-- checking and asking for required file permissions --*/
    fun file_permission(): Boolean {
        return if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) !== PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.CAMERA
            ) !== PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA
                ),
                1
            )
            false
        } else {
            true
        }
    }

    /*-- creating new image file here --*/
    @Throws(IOException::class)
    private fun create_image(): File? {
        @SuppressLint("SimpleDateFormat") val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "img_" + timeStamp + "_"
        val storageDir: File =
            requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(imageFileName, ".jpg", storageDir)
    }

    private fun updateCartId() {
        try {
            if (mainViewModel?.isUserLogin(Constants.ENABLE_GRAPH_QUERIES_CALLS)!!) {
                mainViewModel.createCartForUser()
            } else {
                mainViewModel?.createCartForGuest(null, null, false)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        println("http: payment onBackPressed")
        super.onBackPressed()
    }
}
