package com.tatayab.domain.interactor.address

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.Address
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import io.reactivex.Completable
import javax.inject.Inject

class SaveGuestAddress @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<SaveGuestAddress.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.setGuestAddressFromCache(params.address)
    }

    data class Params constructor(
        val address: Address?
    ) {

        companion object {
            fun forGuest(
                address: Address?
            ): Params {
                return Params(address)
            }
        }
    }


}