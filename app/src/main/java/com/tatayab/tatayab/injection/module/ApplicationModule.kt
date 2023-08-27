package com.tatayab.tatayab.injection.module

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun providesContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideConfiguration(context: Context): Configuration =context.resources.configuration
}
