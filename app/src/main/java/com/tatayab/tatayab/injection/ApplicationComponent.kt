package com.tatayab.tatayab.injection

import android.app.Application
import android.content.res.Configuration
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.tatayab.tatayab.App
import com.tatayab.tatayab.injection.module.*
import com.tatayab.tatayab.util.SharedPrefAppSettings
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton


@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        UIModule::class,
        PresentationModule::class,
        DataModule::class,
        CacheModule::class,
        RemoteModule::class,
        AssistedInjectModule::class,
        AppSettingsModule::class,
        LocalizationModule::class]
)
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: App)
    val sharedPrefAppSettings:SharedPrefAppSettings


    // Exposes the UserDetailModel.Factory object so we can reference the create()
    // method that takes a User ID String as an argument
    //val productsFragmentViewModelFactory: ProductFragmentViewModel.Factory
}


// Module annotated with "@AssistedModule" that references generated code (AssistedInject_AssistedInjectModule::class)
@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectModule::class])
interface AssistedInjectModule
