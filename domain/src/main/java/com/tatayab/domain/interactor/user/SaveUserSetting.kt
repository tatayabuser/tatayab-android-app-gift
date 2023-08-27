package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import io.reactivex.Completable
import javax.inject.Inject

class SaveUserSetting @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<SaveUserSetting.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.saveUserSettingToCache(
            UserSetting(country = params.countryResponse)
        )
    }

    data class Params constructor(
        val countryResponse: CountryResponse
    ) {

        companion object {
            fun forUser(
                countryResponse: CountryResponse
            ): Params {
                return Params(countryResponse)
            }

        }


    }
}