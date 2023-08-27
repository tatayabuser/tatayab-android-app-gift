package com.tatayab.domain.interactor.address


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserProfile
import com.tatayab.model.UserSetting
import com.tatayab.model.requests.Address
import io.reactivex.Observable
import javax.inject.Inject

class GetGuestLastAddress @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Address?, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<Address?> {
        return tatayabRepository.getGuestAddressFromCache().toObservable()
    }
}
