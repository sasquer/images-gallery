package com.sasquer.imagesgallery.data.interactor

import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import io.reactivex.Single

interface ImagesInteractor {
    fun getImages(page: Int): Single<List<ImageInfo>>
}