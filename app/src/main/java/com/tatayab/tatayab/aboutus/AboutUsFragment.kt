package com.tatayab.tatayab.aboutus

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.Constants.BASE_URL
import com.tatayab.tatayab.util.Constants.PRIVACY_POLICY_NEW
import com.tatayab.tatayab.util.Constants.RETURN_POLICY_NEW
import com.tatayab.tatayab.util.Constants.TERMES_CONDITION_NEW
import kotlinx.android.synthetic.main.fragment_about_us.*
import javax.inject.Inject


class AboutUsFragment : BaseFragment2() {


    override fun layoutId(): Int {
        return R.layout.fragment_about_us
    }
    lateinit var mainViewModel: MainActivityViewModel
    @Inject
    lateinit var viewModelFactory: MainActivityViewModelFactory.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(MainActivityViewModel::class.java)
        intComponent()
    }

    private fun intComponent() {



        tv_privacy_policy.setSafeOnClickListener {
            //https://tatayab.com/KW-en/terms
            val url = BASE_URL.plus(mainViewModel.getCountryCode().toLowerCase()).plus("-").plus(App.getPref().currentLanguage.toString())
                .plus(PRIVACY_POLICY_NEW)
            //https://tatayab.com/kw-en/privacy-policy
            //https://tatayab.com/KW-en/privacy
            println("TATAYAB: PRIVACY_POLICY_NEW/ "+url)

            val nextAction =
                AboutUsFragmentDirections.nextActionPrivacy(url, getString(R.string.privacy_policy))
            findNavController().navigate(nextAction)

        }

        tv_return_policy.setSafeOnClickListener {
            val url = BASE_URL.plus(mainViewModel.getCountryCode().toLowerCase()).plus("-").plus(App.getPref().currentLanguage.toString())
                .plus(RETURN_POLICY_NEW)
            println("TATAYAB: RETURN_POLICY_NEW/ "+url)
            val nextAction =
                AboutUsFragmentDirections.nextActionPrivacy(
                    url,
                    getString(R.string.delivery_and_return_policy)
                )
            findNavController().navigate(nextAction)
        }

        tv_termes_condition.setSafeOnClickListener {
            val url = BASE_URL.plus(mainViewModel.getCountryCode().toLowerCase()).plus("-").plus(App.getPref().currentLanguage.toString())
                .plus(TERMES_CONDITION_NEW)
            //https://tatayab.com/KW-en/terms
            //https://tatayab.com/kw-en/terms
            println("TATAYAB: TERMES_CONDITION_NEW/ "+url)

            val nextAction =
                AboutUsFragmentDirections.nextActionPrivacy(
                    url,
                    getString(R.string.termes_condition)
                )
            findNavController().navigate(nextAction)
        }

    }

}
