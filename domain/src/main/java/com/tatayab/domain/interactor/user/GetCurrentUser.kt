package com.tatayab.domain.interactor.user


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserProfile
import com.tatayab.model.responses.AuthenticationResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AuthenticationResponse?, Nothing?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Nothing?): Observable<AuthenticationResponse?> {
        return tatayabRepository.getUserFromCache().toObservable()
    }
}
