package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserAuth
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import io.reactivex.Completable
import javax.inject.Inject

class SaveUserAuth @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<SaveUserAuth.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.saveUserAuthToCache(
            UserAuth(token = params.token,session = params.session,devid = params.devid)
        )
    }

    data class Params constructor(
        val token: String? = "",
        val session: String? = "",
        val devid: String? = ""
     ) {

        companion object {
            fun forUser(
                  token: String? = "",
                  session: String? = "",
                  devid: String? = ""
            ): Params {
                return Params(token, session,devid)
            }

        }


    }
}