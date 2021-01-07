package com.sasquer.imagesgallery.ui.imagedetails

import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.ui.base.BaseViewModel

class ImageDetailsViewModel(
    private val interactor: ImagesInteractor,
    private val args: DetailsArgs
) : BaseViewModel() {

    val imageDetails: LiveData<ImageInfo> = interactor.getImageById(args.imageId)
}

data class DetailsArgs(val imageId: String)