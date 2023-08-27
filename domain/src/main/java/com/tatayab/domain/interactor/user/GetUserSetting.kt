package com.tatayab.domain.interactor.user


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserProfile
import com.tatayab.model.UserSetting
import io.reactivex.Observable
import javax.inject.Inject

class GetUserSetting @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<UserSetting?, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<UserSetting?> {
        return tatayabRepository.getUserSettingFromCache().toObservable()
    }
}
