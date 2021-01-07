package com.sasquer.imagesgallery.navigation

import androidx.navigation.NavController
import com.sasquer.imagesgallery.ui.main.MainFragmentDirections
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {
    private var navController: NavController? = null

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        navController = null
    }

    override fun actionImageDetailsFromMain(imageId: String) {
        val action = MainFragmentDirections.actionMainFragmentToImageDetailsFragment(
            imageId
        )
        navController?.navigate(action)
    }

    override fun actionBackMainFromImageDetails() {
        navController?.popBackStack()
    }
}