package com.sasquer.imagesgallery.di.modules

import com.sasquer.imagesgallery.di.scopes.PerApplication
import com.sasquer.imagesgallery.navigation.Navigation
import com.sasquer.imagesgallery.navigation.NavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavModule {
    @Binds
    @PerApplication
    fun bindNavigation(impl: NavigationImpl): Navigation
}