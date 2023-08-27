package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.SocialLoginRequestBody
import com.tatayab.model.responses.AuthenticationResponse
import io.reactivex.Observable
import javax.inject.Inject

class SocialLoginExecute @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AuthenticationResponse, SocialLoginExecute.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<AuthenticationResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.socialMediaLogin(
            params.languageCode,
            SocialLoginRequestBody(
                deviceId = params.device_id,
                email = params.email,
                phone = params.phone,
                name = params.firstname,
                regType = params.reg_type,
                socialId = params.social_id,
                isGraphEnable = params.isGraphEnable
            )
        )
    }

    data class Params(
        val device_id: String,
        val email: String,
        val phone: String,
        val firstname: String,
        val reg_type: String,
        val social_id: String,
        val languageCode: String,
        val isGraphEnable: Boolean
    ) {
        companion object {
            fun forUser(
                device_id: String,
                email: String,
                phone: String,
                firstname: String,
                reg_type: String,
                social_id: String,
                languageCode: String,
                isGraphEnable:Boolean
            ): Params {
                return Params(device_id, email, phone, firstname, reg_type, social_id, languageCode,isGraphEnable)
            }
        }
    }

}
