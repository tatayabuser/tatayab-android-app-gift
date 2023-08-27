package com.tatayab.domain.interactor.account.profile

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.requests.ProfileActionRequest
import io.reactivex.Observable
import javax.inject.Inject


class EditProfile @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<EditUserProfileResponse, EditProfile.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<EditUserProfileResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.editProfile(editProfileRequestBody = params.editProfileRequestBody)
    }

    data class Params constructor(val editProfileRequestBody: ProfileActionRequest) {
        companion object {
            fun forUserEdit(editRequestBody: ProfileActionRequest): Params {
                return Params(
                    editRequestBody
                )
            }
        }
    }
}

/*
https://devdocs.magento.com/guides/v2.4/graphql/mutations/update-customer.html
*
* mutation {
  updateCustomer(
    input: {
      firstname: "Rob"
      email: "robloblaw@example.com"
    }
  ) {
    customer {
      firstname
      email
    }
  }
}*/
