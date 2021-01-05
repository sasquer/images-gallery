package com.sasquer.imagesgallery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.navigation.HasNavController
import com.sasquer.imagesgallery.utils.setupToolbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector, HasNavController {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val destinationChangeListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            invalidateOptionsMenu()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar(toolbar)
        toolbar.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        navController.addOnDestinationChangedListener(destinationChangeListener)
    }

    override fun onStop() {
        super.onStop()
        navController.removeOnDestinationChangedListener(destinationChangeListener)
    }

    override val navController: NavController by lazy(LazyThreadSafetyMode.NONE) {
        findNavController(R.id.nav_host_fragment)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}