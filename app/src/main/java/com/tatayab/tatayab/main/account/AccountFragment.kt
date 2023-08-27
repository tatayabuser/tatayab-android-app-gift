package com.tatayab.tatayab.main.account

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.account.AccountItem
import com.tatayab.model.account.CompositeAccountItem
import com.tatayab.model.account.ItemValue
import com.tatayab.model.account.ViewTypeAction
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.CountryResponse
import com.tatayab.presentation.account.AccountFragmentViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.base.MemoryCacheManager.Companion.OPEN_WALLET_FLAG
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnAccountItemClick
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.Constants.FROM_REGISTER
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.NavigationResult
import kotlinx.android.synthetic.main.fragment_account.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class AccountFragment : BaseFragment(), NavigationResult, OnAccountItemClick {

    @Inject
    lateinit var viewModel: AccountFragmentViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    lateinit var mainViewModel: MainActivityViewModel
    var adapter: AccountBlockAdapter? = null
    var userName: String = ""
    var userEmail: String = ""
    override fun layoutId(): Int {
        return R.layout.fragment_account
    }

    private var isUpdateToken = false
    private var isUpdateCountry = false


    override fun onNavigationResult(result: Bundle) {
        //Log.e("res", result.getString("key").toString())
        if (result.getInt(Constants.LOGIN) == Constants.REQUEST_CODE_LOG_IN) {
            setAccountFragment(true)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_CODE_LOGIN_ACTIVITY && resultCode == Activity.RESULT_OK) {
            if (data?.extras?.getBoolean(FROM_REGISTER, false)!!)
                showCustomTopMessage(
                    getString(R.string.register_success),
                    DialogUtil.MessageType.SUCCESS
                )

            val userProfile =
                data.extras?.getParcelable<AuthenticationResponse>(Constants.USER_PROFILE)
            userName = userProfile?.firstname?.split(" ")?.get(0).toString()
            userEmail = userProfile?.email.toString()
            setAccountFragment(true)

            (activity as MainActivity).loginSucceed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = AccountBlockAdapter(this)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AccountFragmentViewModel::class.java)
        viewModel.getUserLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setAccountFragment(false)
                }
                ResourceState.SUCCESS -> {

                    userName = it.data?.firstname.toString()
                    userEmail = it.data?.email.toString()
                    setAccountFragment(viewModel?.isUserLogin(com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS)!!)
                    addCustomLogToCrashlytics(
                        viewModel.getCountryCode(),
                        App.getPref().currentLanguage.toString(),
                        it.data?.user_id.toString(),
                        it.data?.email.toString(),
                        it.data?.firstname.toString()
                    )
                }
                else -> {
                }
            }
        })

        viewModel.getUserSetingLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                }
                ResourceState.SUCCESS -> {
                    adapter?.setUserData(
                        CompositeAccountItem(
                            isLogin = it.data?.second!!,
                            countryName = it.data?.first?.country?.name,
                            SettingItems = getItemsForLogin(
                                it.data?.second!!,
                                it.data?.first?.country?.name
                            ),
                            userName = userName,
                            UserEmail = userEmail
                        )
                    )

                }
                else -> {
                }
            }
        })

        viewModel.getLogoutLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                    logoutFun()
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    try {
                        logoutFun()
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE

                }
            }
        })

        mainViewModel.getCountriesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
//                    animationView.visibility = View.GONE
                    App.getPref().restartApp(activityToBeRestarted = requireActivity())
                }
                ResourceState.SUCCESS -> {
                    it.data?.let {
                        mainViewModel.updateCurrentCountry(it as ArrayList<CountryResponse>)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getUpdateCountryLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    isUpdateToken = true
                    if (isUpdateCountry && isUpdateToken) {
//                        animationView.visibility = View.GONE
                        App.getPref().restartApp(activityToBeRestarted = requireActivity())
                    }
                }
                ResourceState.SUCCESS -> {
                    isUpdateToken = true
                    it.data?.let {
                        if (isUpdateCountry && isUpdateToken){
//                            animationView.visibility = View.GONE
                            App.getPref().restartApp(activityToBeRestarted = requireActivity())
                        }

                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        mainViewModel.getUpdateTokenLiveData.observe(this, Observer {
            try {
                when (it.status) {

                    ResourceState.ERROR -> {
                        isUpdateCountry = true
                        if (isUpdateCountry && isUpdateToken){
//                            animationView.visibility = View.GONE
                            App.getPref().restartApp(activityToBeRestarted = requireActivity())
                        }
                    }
                    ResourceState.SUCCESS -> {
                        isUpdateCountry = true
                        if (isUpdateCountry && isUpdateToken) {
//                            animationView.visibility = View.GONE
                            App.getPref().restartApp(activityToBeRestarted = requireActivity())
                        }
                    }
                    ResourceState.LOADING -> {
                        animationView.visibility = View.VISIBLE
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

    }

    private fun logoutFun() {
        setAccountFragment(false)
        (activity as MainActivity).logout()
        if (mainViewModel != null) {
            mainViewModel.getCartContentFirstTime()
            mainViewModel?.removeGiftFromCache()
            mainViewModel?.removeCartIDsFromCache()
        }
        MemoryCacheManager?.setCartId("")
        var params = HashMap<String, Any>()
        InsiderManager.sendCustomEvent(
            InsiderManager.CustomEvent.logout.toString(),
            params
        )
    }


    private fun rateApp() {
        (activity as MainActivity).apply { this.showRateApp() }
        //com.tatayab.tatayab

        //        val uri = Uri.parse("market://details?id=com.tatayab.tatayab")
//        var intent = Intent(Intent.ACTION_VIEW, uri)
//        intent.addFlags(
//            Intent.FLAG_ACTIVITY_NO_HISTORY or
//                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
//                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
//        )
//
//        if (intent.resolveActivity(activity?.packageManager!!) != null) {
//            startActivity(intent)
//        } else {
//            intent = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("http://play.google.com/store/apps/details?id=com.tatayab.tatayab")
//            )
//            if (intent.resolveActivity(activity?.packageManager!!) != null) {
//                startActivity(intent)
//            } else {
//                showCustomTopMessage(
//                    getString(R.string.no_store_browser),
//                    DialogUtil.MessageType.ERROR
//                )
//            }
//        }
    }


    private fun shareApp() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody =
            getText(R.string.share_des).toString() + "https://play.google.com/store/apps/details?id=com.tatayab.tatayab&hl=en"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.app_name))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()
        block_items.adapter = adapter
        tv_terms.setMovementMethod(LinkMovementMethod.getInstance());

        var termsLink = String.format(
            resources.getString(R.string.agree_to_terms_with_links),
            viewModel.getCountryCode().toLowerCase(),
            App.getPref().currentLanguage.toString(),
            viewModel.getCountryCode().toLowerCase(),
            App.getPref().currentLanguage.toString()
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv_terms.setText(
                Html.fromHtml(
                    termsLink,
                    Html.FROM_HTML_MODE_COMPACT
                )
            )
        } else {
            tv_terms.setText(Html.fromHtml(termsLink))
        }

        if(OPEN_WALLET_FLAG){
            OPEN_WALLET_FLAG= false
            openWalletAutomatic()
        }
    }

    private fun showLogoutConfirmationDialog() {

        val builder = Dialog(requireActivity())
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCancelable(true)
        builder.setContentView(R.layout.logout_dialog)
        builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val confirmButton = builder.findViewById(R.id.confirmButton) as TextView
        val dismissButton = builder.findViewById(R.id.dismissButton) as TextView
        val close = builder.findViewById(R.id.close) as ImageView
        builder.setTitle("")
        confirmButton.setSafeOnClickListener {
            builder.dismiss()
             mainViewModel?.removeCartIDsFromCache()
            viewModel.logout(App.getPref().currentLanguage.toString())
        }
        dismissButton.setSafeOnClickListener {
            builder.dismiss()
        }
        close.setSafeOnClickListener {
            builder.dismiss()
        }
        builder.show()
    }


    private fun setAccountFragment(isLoggedIn: Boolean) {
        viewModel.getUserSetting(isLoggedIn)
    }

    private fun getItemsForLogin(
        isLogin: Boolean,
        countryName: String? = " "
    ): ArrayList<AccountItem> {
        val list = ArrayList<AccountItem>()
        if (isLogin)
            list.add(AccountItem(getText(R.string.my_account).toString(), getAccountItems()))
        list.add(AccountItem(getText(R.string.settings).toString(), getSettingItems(countryName)))
        list.add(AccountItem(getText(R.string.tatayab).toString(), getContactItems()))

        return list
    }

    private fun getSettingItems(countryName: String?): ArrayList<ItemValue> {
        val list = ArrayList<ItemValue>()
        list.add(
            ItemValue(
                getText(R.string.language).toString(),
                getText(R.string.language_text).toString(),
                R.drawable.ic_language,
                ViewTypeAction.LANG
            )
        )
        list.add(
            ItemValue(
                getText(R.string.country_text).toString(),
                countryName!!,
                R.drawable.ic_country,
                ViewTypeAction.COUNTRIES
            )
        )
        return list
    }

    private fun getAccountItems(): ArrayList<ItemValue> {
        val list = ArrayList<ItemValue>()
        list.add(
            ItemValue(
                getText(R.string.profile).toString(),
                "",
                R.drawable.profile,
                ViewTypeAction.PROFILE
            )
        )

        list.add(
            ItemValue(
                getText(R.string.my_orders).toString(),
                "",
                R.drawable.ic_order,
                ViewTypeAction.ORDERS
            )
        )
        list.add(
            ItemValue(
                getText(R.string.saved_address).toString(),
                "",
                R.drawable.ic_addresses,
                ViewTypeAction.ADDRESS
            )
        )
        list.add(
            ItemValue(
                getText(R.string.credit).toString(),
                "",
                R.drawable.wallet_icon,
                ViewTypeAction.WALLET
            )
        )

//        list.add(
//            ItemValue(
//                getText(R.string.refer).toString(),
//                "",
//                R.drawable.refere,
//                ViewTypeAction.REFER
//            )
//        )

        return list
    }

    private fun getContactItems(): ArrayList<ItemValue> {
        val list = ArrayList<ItemValue>()
        list.add(
            ItemValue(
                getText(R.string.aboutus).toString(),
                "",
                R.drawable.shape,
                ViewTypeAction.ABOUTUS
            )
        )
        list.add(
            ItemValue(
                getText(R.string.contactus).toString(),
                "",
                R.drawable.contact,
                ViewTypeAction.CONTACTUS
            )
        )
        return list
    }

    override fun onSettingItemSelected(actionType: ViewTypeAction) {

        when (actionType) {
            ViewTypeAction.ADDRESS -> {
                val nextAction = AccountFragmentDirections.nextActionAddresses()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.WALLET -> {
                val nextAction = AccountFragmentDirections.nextActionWallet()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.ORDERS -> {
                val nextAction = AccountFragmentDirections.nextActionOrders()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.PROFILE -> {
                val nextAction = AccountFragmentDirections.nextActionProfile()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.COUNTRIES -> {
                val nextAction = AccountFragmentDirections.nextActionCountries()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.ABOUTUS -> {
                val nextAction = AccountFragmentDirections.nextActionAboutUs()
                findNavController().navigate(nextAction)
            }
            ViewTypeAction.CONTACTUS -> {
                val nextAction = AccountFragmentDirections.nextActionContactUs("")
                findNavController().navigate(nextAction)
            }

            ViewTypeAction.LOGOUT -> {

                showLogoutConfirmationDialog()
            }
            ViewTypeAction.LOGIN -> {
                findNavController().navigate(AccountFragmentDirections.nextLoginOptions())
            }
            ViewTypeAction.REFER -> {
                findNavController().navigate(AccountFragmentDirections.nextActionRefer())
            }

            ViewTypeAction.LANG -> {
                try {
                    App.getPref().toggleLanguage()
//                    mainViewModel.updateUserTokenWithLangaugAndCountry(
//                        App.getPref().firstUserToken,
//                        viewModel.getCountryCode(),
//                        App.getPref().currentLanguage.toString()
//                    )
                    mainViewModel.updateCurrentLanguageToCache(App.getPref().currentLanguage.toString())
                    mainViewModel.getCountries(App.getPref().currentLanguage.toString())
                    InsiderManager.changeLanguage(App.getPref().currentLanguage.toString())
                    mainViewModel?.loadAllHomeBlocksAgain()
                         App.getPref().restartApp(activityToBeRestarted = requireActivity())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            ViewTypeAction.SHARE -> {
                shareApp()
            }
            ViewTypeAction.RATEAPP -> {
                rateApp()
            }
            else -> {
                Log.d("Error", " Detection Account action")
            }
        }
    }

//    private fun showRemoveCartAlarm() {
//        try{
//            val builder = Dialog(requireActivity())
//            builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            builder.setCancelable(true)
//            builder.setContentView(R.layout.remove_cart_alarm_dialog)
//            builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//            val confirmButton = builder.findViewById(R.id.confirmButton) as AppCompatButton
//            val dismissButton = builder.findViewById(R.id.dismissButton) as AppCompatButton
//             builder.setTitle("")
//            confirmButton.setSafeOnClickListener {
//                builder.dismiss()
//                val nextAction = AccountFragmentDirections.nextActionCountries()
//                findNavController().navigate(nextAction)
//            }
//            dismissButton.setSafeOnClickListener {
//                builder.dismiss()
//            }
//            builder.show()
//        }catch (e: java.lang.Exception){
//            e.printStackTrace()
//        }
//    }

    fun openWalletAutomatic(){
        try{
            val nextAction = AccountFragmentDirections.nextActionWallet()
            findNavController().navigate(nextAction)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

}
