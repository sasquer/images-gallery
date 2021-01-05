package com.sasquer.imagesgallery

import android.app.Application
import com.sasquer.imagesgallery.di.components.DaggerAppComponent
import com.sasquer.imagesgallery.utils.NavigationLifecycleCallback
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navigationLifecycleCallback: NavigationLifecycleCallback

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory()
            .create(this)
            .inject(this)

        registerNavigationCallback()
    }

    private fun registerNavigationCallback() {
        registerActivityLifecycleCallbacks(navigationLifecycleCallback)
    }

}