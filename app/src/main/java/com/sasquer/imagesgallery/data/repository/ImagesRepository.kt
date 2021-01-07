package com.sasquer.imagesgallery.data.repository

import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import io.reactivex.Single

interface ImagesRepository {
    fun getRemoteImages(page: Int): Single<List<ImagesResponse>>

    fun saveImages(images: List<ImageInfo>)

    fun getStoredImages(): LiveData<List<ImageInfo>>
}