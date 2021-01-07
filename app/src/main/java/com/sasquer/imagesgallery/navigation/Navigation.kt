package com.sasquer.imagesgallery.navigation

import androidx.navigation.NavController

interface Navigation {
    fun bind(navController: NavController)
    fun unbind()
    fun actionImageDetailsFromMain(imageId: String)
    fun actionBackMainFromImageDetails()
}