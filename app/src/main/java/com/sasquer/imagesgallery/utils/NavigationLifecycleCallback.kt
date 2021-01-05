package com.sasquer.imagesgallery.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.sasquer.imagesgallery.di.Injectable
import com.sasquer.imagesgallery.navigation.HasNavController
import com.sasquer.imagesgallery.navigation.Navigation
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NavigationLifecycleCallback @Inject constructor(
    private val navigator: Navigation
) : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(p0: Activity) {
        navigator.unbind()
    }

    override fun onActivityStarted(p0: Activity) {
        Log.e("NavigationLifecycle", "onActivityStarted " + p0.localClassName)
    }

    override fun onActivityDestroyed(p0: Activity) {
        Log.e("NavigationLifecycle", "onActivityDestroyed " + p0.localClassName)
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

    }

    override fun onActivityStopped(p0: Activity) {

    }

    override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        if (activity is Injectable || activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }
        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentPreAttached(
                    fm: FragmentManager,
                    fragment: Fragment,
                    context: Context
                ) {
                    if (fragment is Injectable) {
                        AndroidSupportInjection.inject(fragment)
                        Log.e(
                            "NavigationLifecycle",
                            "onFragmentPreAttached " + fragment::class.java.name
                        )
                    }
                }
            },
            true
        )
    }

    override fun onActivityResumed(p0: Activity) {
        (p0 as? HasNavController)?.also {
            navigator.bind(it.navController)
        }
    }

}