package com.tatayab.tatayab.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tatayab.model.ResponseLogOnFireBase
import com.tatayab.model.addresses.AddressType
import com.tatayab.model.responses.CountryResponse
import com.tatayab.remote.util.Constants.Companion.EMAIL_HOLDER
import com.tatayab.remote.util.Constants.Companion.LOG_COUNTRY_HOLDER
import com.tatayab.remote.util.Constants.Companion.LOG_LANG_CODE_HOLDER
import com.tatayab.remote.util.Constants.Companion.USER_ID_HOLDER
import com.tatayab.remote.util.Constants.Companion.USER_NAME_HOLDER
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.errorHandling.ErrorHandlingAct
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.injection.ViewModelFactory
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.DialogUtil
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.toolbar_main_default.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import kotlinx.android.synthetic.main.toolbar_with_back.toolbar
import kotlinx.android.synthetic.main.toolbar_with_back.tv_title
import java.util.*
import javax.inject.Inject


abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var lastKey: String

    companion object {
        var isChooseCountry: Boolean = false
        var currentCountrySelected: CountryResponse? = null
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun goToStore() {
        val appPackageName = "com.tatayab.tatayab"
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (anfe: android.content.ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    abstract fun layoutId(): Int

    /* val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
         (activity?.application as App).appComponent
     }
     */


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareCartButton?.visibility = View.GONE
        val destination = findNavController().currentDestination?.id
        if (destination in Constants.HOME_FRAGMENTS) {
            val appBarConfiguration = AppBarConfiguration
                .Builder(destination!!)
                .build()
            toolbar?.setupWithNavController(findNavController(), appBarConfiguration)
            tv_title?.text = toolbar.title
        } else {
            destination?.let { dest ->
                if (dest !in Constants.CUSTOM_TOOLBAR_FRAGMENTS) {
                    val appBarConfiguration = AppBarConfiguration
                        .Builder(dest)
                        .build()
                    toolbar?.setupWithNavController(findNavController(), appBarConfiguration)
                    tv_title?.text = toolbar.title
                    iv_back?.setSafeOnClickListener { findNavController().popBackStack() }
                }
            }

        }

        if (destination in Constants.HIDE_BOTTOM_NAVIGATION_FRAGMENTS) {
            (activity as? MainActivity)?.hideBottomNavigation()
        } else {
            (activity as? MainActivity)?.showBottomNavigation()
        }
    }


    fun hideBottomNavigation() {
        (activity as? MainActivity)?.hideBottomNavigation()
    }

    fun showBottomNavigatfvion() {
        (activity as? MainActivity)?.showBottomNavigation()
    }

    protected fun setProgress(visibility: Int) {
        progress?.visibility = visibility
    }

    fun addObjectToFireBase(fireBaseLog: ResponseLogOnFireBase, key: String) {
        val database = Firebase.database
        val myRef = database.reference
        val ref = myRef.child("android_Logs").child(key).push()
        ref.setValue(fireBaseLog)
        val name = ref.key
        lastKey = name.toString()
    }

    protected fun formatePhoneErrorMessage(validateMessage: String): String {
        try {
            if (validateMessage.isNullOrEmpty()) return getString(R.string.error_phone_number)

            return getText(R.string.phone_length).toString() + validateMessage.split(
                "&",
                limit = 2
            )[0].replace(",", " " + getText(R.string.or).toString() + " ") + " " +
                    getText(
                        R.string.numbers_and_start
                    ).toString() + " " + validateMessage.split("&", limit = 2)[1].replace(
                ",", " " + getText(
                    R.string.or
                ).toString() + " "
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return getString(R.string.error_phone_number)
        }

    }

    public fun addCustomLogToCrashlytics(
        country: String,
        langCode: String,
        userId: String,
        email: String,
        userName: String
    ) {
        // country lang_code user_data
        val crashlytics = FirebaseCrashlytics.getInstance()

        crashlytics.setCustomKey(LOG_COUNTRY_HOLDER, country)
        crashlytics.setCustomKey(LOG_LANG_CODE_HOLDER, langCode)
        crashlytics.setCustomKey(USER_ID_HOLDER, userId)
        crashlytics.setCustomKey(EMAIL_HOLDER, email)
        crashlytics.setCustomKey(USER_NAME_HOLDER, userName)
    }


    protected fun showErrorDialog(view: View, message: String) {
        try {
            val intent = Intent(activity, ErrorHandlingAct::class.java)
            intent.putExtra(ErrorHandlingAct.MESSAGE_HOLDER, message)
            startActivity(intent)
        } catch (e: Exception) {
            println("Error in showErrorDialog : " + e.message)
        }
    }
    protected fun showCustomSuccessDialog(message: String, mMessageType: DialogUtil.MessageType) {
        DialogUtil().showCustomSuccessDialog(requireContext(), true, message, mMessageType)
    }
    protected fun showCustomTopMessage(message: String, mMessageType: DialogUtil.MessageType) {
        if (activity != null) DialogUtil().showCustomDialog(
            requireActivity(),
            true,
            message,
            mMessageType
        )
    }


//    protected fun progressStatus(viewStatus: Int) =
//        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }


/*internal fun notify(@StringRes message: Int) =
    Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

internal fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
    val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
    snackBar.setAction(actionText) { _ -> action.invoke() }
    snackBar.setActionTextColor(
        ContextCompat.getColor(appContext,
        color.colorPrimary))
    snackBar.show()
}*/

    @SuppressLint("HardwareIds")
    fun getUniqueDeviceID(): String {
        println(
            ".....frag1/getUniqueDeviceID() :  " + Settings.Secure.getString(
                requireContext().contentResolver,
                Settings.Secure.ANDROID_ID
            )
        )
        return Settings.Secure.getString(
            requireContext().contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }

    fun getAddressFromLocation(location: Location?): Address? {
        try {
            val geoCoder = Geocoder(requireContext(), Locale.US)
            var addresses: List<Address> = emptyList()
            return if (location != null) {
                addresses = geoCoder.getFromLocation(
                    location.latitude,
                    location.longitude,
                    1
                )
                if (addresses != null && addresses.isNotEmpty()) {
                    val address = addresses[0]
                    address
                } else {
                    null
                }
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false

    fun getAddressTypes() = listOf(
        AddressType(getString(R.string.select_address_type), "0"),
        AddressType(getString(R.string.house), "1285"),
        AddressType(getString(R.string.apartment), "1286")
    )

    fun getAddressTypesName(typeId: Int) = when (typeId) {
        1285 -> getString(R.string.house)
        else -> getString(R.string.apartment)
    }

}