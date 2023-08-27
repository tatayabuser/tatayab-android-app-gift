package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.repository.TatayabRepository
import io.reactivex.Completable
import javax.inject.Inject

class SaveCurrentLangauge @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<SaveCurrentLangauge.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.saveCurrentLanguageToCache(params.lang.toString())
    }

    data class Params constructor(
        val lang: String? = ""
     ) {

        companion object {
            fun forUser(
                  lang: String? = ""

            ): Params {
                return Params(lang)
            }

        }


    }
}