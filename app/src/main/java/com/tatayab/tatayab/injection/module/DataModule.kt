package com.tatayab.tatayab.injection.module

import com.tatayab.data.TatayabDataRepository
import com.tatayab.domain.repository.TatayabRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindTatayabRepository(tatayabRepository: TatayabDataRepository): TatayabRepository
}
