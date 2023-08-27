package com.tatayab.presentation.referFriend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.wallet.CheckEarnExecution
import com.tatayab.domain.interactor.wallet.InviteFriendExecution
import com.tatayab.domain.repository.TatayabRepository


@Suppress("UNCHECKED_CAST")
class ReferFriendSuccessViewModelFactory @AssistedInject constructor(
    private val mCheckEarnExecution: CheckEarnExecution,
    private val mInviteFriendExecution: InviteFriendExecution,
    private val repository: TatayabRepository,
    @Assisted val languageCode:String

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReferFriendSuccessViewModel(mCheckEarnExecution,mInviteFriendExecution,repository,languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): ReferFriendSuccessViewModelFactory
    }
}