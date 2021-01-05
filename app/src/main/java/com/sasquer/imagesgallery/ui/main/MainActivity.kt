package com.sasquer.imagesgallery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.navigation.HasNavController
import com.sasquer.imagesgallery.utils.setupToolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HasNavController {

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
}