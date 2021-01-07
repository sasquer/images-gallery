package com.sasquer.imagesgallery.data.interactor

import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import io.reactivex.Single

interface ImagesInteractor {
    fun getRemoteImages(page: Int): Single<List<ImageInfo>>
    fun saveImages(images: List<ImageInfo>)
    fun getImages(): LiveData<List<ImageInfo>>
}