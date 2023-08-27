package com.tatayab.tatayab.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.presentation.state.ResourceState
import com.tatayab.presentation.wallet.WalletViewModel
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.frgment_wallet.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import javax.inject.Inject

class WalletFragment : BaseFragment2() {
    @Inject
    lateinit var viewModel: WalletViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, baseViewModelFactory).get(WalletViewModel::class.java)

        viewModel.getWalletLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        it?.message + "",
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    it?.let {
                        it.data?.let {
                            if (it.status == 1) {
                                it?.mWalletData?.let {
                                    var currencyCode = viewModel?.getCurrencyCode().toString()
                                    if(currencyCode .isNullOrBlank()){
                                        currencyCode = it?.currencyCode.toString()}
                                    if(it?.avalAmount!!.contains(currencyCode).not()) it?.avalAmount = it?.avalAmount.plus(" ").plus(currencyCode)
                                    if(it?.penAmount!!.contains(currencyCode).not()) it?.penAmount = it?.penAmount.plus(" ").plus(currencyCode)

                                    balanceTextView?.text = it?.avalAmount
                                    pendingTextView?.text =
                                        getString(R.string.pending_credit) + " " + it?.penAmount
                                }
                            } else {
                                showCustomTopMessage(it?.message + "", DialogUtil.MessageType.ERROR)

                            }
                        }
                    }
                }
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getRedeemCodeLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    showCustomTopMessage(
                        it?.message + "",
                        DialogUtil.MessageType.ERROR
                    )
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    redeemCodeView.visibility = View.GONE
                    promoCodeValue.setText("")
                    animationView.visibility = View.GONE
                    it?.let {
                        it.data?.let {
                            if (it.status == 1) {
                                it?.mRedeemCodeModel?.let {
                                    showCustomTopMessage(
                                        it?.message+"",
                                        DialogUtil.MessageType.ERROR
                                    )
                                }
                                viewModel?.getMyWallet(
                                    App.getPref().currentLanguage.toString()
                                )
                            } else {
                                it?.let {
                                    showCustomTopMessage(
                                        it?.errorMessage + "",
                                        DialogUtil.MessageType.ERROR
                                    )
                                }
                            }
                        }
                    }
                }
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

    }

    override fun layoutId(): Int {
        return R.layout.frgment_wallet
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = getString(R.string.wallet_title)
        viewModel?.getMyWallet(
            App.getPref().currentLanguage.toString()
        )
        seeAllTransactionTextView.setSafeOnClickListener {
            val nextAction = WalletFragmentDirections.nextActionTransaction()
            findNavController().navigate(nextAction)
        }
        redeemCodeCart.setSafeOnClickListener {
            redeemCodeView.visibility = View.VISIBLE
            animationView.visibility = View.GONE
            val animIn = AnimationUtils.loadAnimation(context, R.anim.bottom_to_original)
            redeemCodeView.startAnimation(animIn)
        }

        redeemCloseImageView.setSafeOnClickListener {
//            val animIn = AnimationUtils.loadAnimation(context, R.anim.fragment_fade_exit)
//            redeemCodeView.startAnimation(animIn)
            redeemCodeView.visibility = View.GONE
        }
        redeemCodeButon.setSafeOnClickListener {
            var redeemCode = promoCodeValue.text.toString()
            if (redeemCode.isNullOrEmpty()) {
                promoCodeValue.error = getString(R.string.please_add_redeem_code)
            } else {
                viewModel?.addRedeemCode(
                    redeemCode
                )
            }
        }

        iv_back.setSafeOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}