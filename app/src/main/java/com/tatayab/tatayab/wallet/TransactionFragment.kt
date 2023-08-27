package com.tatayab.tatayab.wallet

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.presentation.state.ResourceState
import com.tatayab.presentation.wallet.WalletViewModel
import com.tatayab.presentation.wallet.WalletViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_transactions.*
 import kotlinx.android.synthetic.main.toolbar_with_back.*
import javax.inject.Inject

class TransactionFragment : BaseFragment2() {

    @Inject
    lateinit var viewModelFactory: WalletViewModelFactory.Factory

    private lateinit var viewModel: WalletViewModel
    var mTransactionHisyoryAdapter: TransactionHisyoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = run {
            ViewModelProviders.of(
                this,
                viewModelFactory.create()
            )[WalletViewModel::class.java]
        }

        viewModel.getTransactionsHistoryLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    no_transaction.visibility = View.VISIBLE
                    transactionRecyclerView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    it?.let {
                        it?.data?.let {
                            if (it.status == 1) {
                                it?.mTransactionList?.let {
                                    if (it != null && it.size > 0) {
                                        no_transaction.visibility = View.GONE
                                        transactionRecyclerView.visibility = View.VISIBLE
                                        mTransactionHisyoryAdapter?.setData(it)
                                    }else{
                                        no_transaction.visibility = View.VISIBLE
                                        transactionRecyclerView.visibility = View.GONE
                                    }
                                }
                            } else {
                                no_transaction.visibility = View.VISIBLE
                                transactionRecyclerView.visibility = View.GONE
                                showCustomTopMessage( it?.message+"", DialogUtil.MessageType.ERROR)
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
        return R.layout.fragment_transactions
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel?.getTransActionsHistory(
            App.getPref().currentLanguage.toString()
        )
    }

    private fun initView() {
        tv_title.text = getString(R.string.wallet_tranactions)
        mTransactionHisyoryAdapter =
            TransactionHisyoryAdapter(App.getPref().currentLanguage.toString())
        transactionRecyclerView.adapter = mTransactionHisyoryAdapter
        iv_back.setSafeOnClickListener {
            findNavController().popBackStack()
        }
        (activity as? MainActivity)?.hideBottomNavigation()
    }


}