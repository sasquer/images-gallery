package com.sasquer.imagesgallery.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {
    private var navController: NavController? = null

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        navController = null
    }
}