package com.tatayab.domain.interactor.auth

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.CustomerAddress
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class Logout @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Boolean,Nothing>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Nothing?): Observable<Boolean> {
        projectsRepository.removeGuestAddressFromCache()
        return projectsRepository.deleteUserFromCache()
    }
}