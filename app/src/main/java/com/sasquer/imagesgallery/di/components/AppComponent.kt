package com.sasquer.imagesgallery.di.components

import com.sasquer.imagesgallery.App
import com.sasquer.imagesgallery.di.feature.FeatureMainHostModule
import com.sasquer.imagesgallery.di.modules.NavModule
import com.sasquer.imagesgallery.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FeatureMainHostModule::class,
        NavModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }

    fun inject(app: App)
}