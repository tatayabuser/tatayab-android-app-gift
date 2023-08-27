package com.tatayab.tatayab.injection.module

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.tatayab.tatayab.util.Language
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.*

@Module
class LocalizationModule {

    @Provides
    @IntoMap
    @LanguageKey(Language.English)
    fun providesEnglishResources(context: Context): Resources =
        getLocalizedResources(context, Language.English.locale)

    @Provides
    @IntoMap
    @LanguageKey(Language.Arabic)
    fun providesArabicResources(context: Context): Resources =
        getLocalizedResources(context, Language.Arabic.locale)

    private fun getLocalizedResources(context: Context, locale: Locale): Resources {
        val conf = Configuration(context.resources.configuration)
        conf.setLocale(locale)
        val localizedContext = context.createConfigurationContext(conf)
        return localizedContext.resources
    }
}
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class LanguageKey(val value: Language)