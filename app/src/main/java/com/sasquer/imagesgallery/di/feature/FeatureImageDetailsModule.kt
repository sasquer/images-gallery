package com.sasquer.imagesgallery.di.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.di.scopes.PerFragment
import com.sasquer.imagesgallery.ui.imagedetails.DetailsArgs
import com.sasquer.imagesgallery.ui.imagedetails.ImageDetailsFragment
import com.sasquer.imagesgallery.ui.imagedetails.ImageDetailsFragmentArgs
import com.sasquer.imagesgallery.ui.imagedetails.ImageDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

@Module
interface FeatureImageDetailsModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [ImageDetailsFragmentModule::class])
    fun contributeImageDetailsFragment(): ImageDetailsFragment
}

@Module
interface ImageDetailsFragmentModule {
    @Binds
    @PerFragment
    fun ImageDetailsViewModelFactory.bindViewModelFactory(): ViewModelProvider.Factory

    companion object {
        @Provides
        @PerFragment
        fun ImageDetailsFragment.provideArgs(): DetailsArgs {
            val navArgs = ImageDetailsFragmentArgs.fromBundle(requireArguments())
            return DetailsArgs(navArgs.imageId)
        }
    }
}

class ImageDetailsViewModelFactory @Inject constructor(
    private val interactor: ImagesInteractor,
    private val args: DetailsArgs
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ImageDetailsViewModel(interactor, args) as T
    }
}