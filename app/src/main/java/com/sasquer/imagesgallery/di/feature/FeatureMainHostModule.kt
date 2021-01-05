package com.sasquer.imagesgallery.di.feature

import com.sasquer.imagesgallery.di.scopes.PerActivity
import com.sasquer.imagesgallery.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeatureMainHostModule {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            FeatureMainModule::class
        ]
    )
    fun mainActivityInjector(): MainActivity

}