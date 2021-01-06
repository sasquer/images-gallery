package com.sasquer.imagesgallery.data.interactor

import com.sasquer.imagesgallery.data.db.enteties.Image
import io.reactivex.Single

interface ImagesInteractor {
    fun getImages(page: Int): Single<List<Image>>
}