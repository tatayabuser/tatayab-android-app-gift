package com.tatayab.tatayab.injection.module

import android.content.Context
import android.content.res.Configuration
import android.preference.PreferenceManager
import com.tatayab.tatayab.util.AppSettings
import com.tatayab.tatayab.util.SharedPrefAppSettings
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppSettingsModule {

    @Provides
    @Singleton
    fun provideAppSettings(context: Context): SharedPrefAppSettings = SharedPrefAppSettings(context)
}