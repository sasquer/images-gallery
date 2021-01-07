package com.sasquer.imagesgallery.data.repository

import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.db.enteties.ImagesDao
import com.sasquer.imagesgallery.data.network.ImagesApi
import io.reactivex.Single
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val apiService: ImagesApi,
    private val imagesDao: ImagesDao
) : ImagesRepository {

    override fun getRemoteImages(page: Int): Single<List<ImagesResponse>> {
        return apiService.getPhotos(page = page)
    }

    override fun saveImages(images: List<ImageInfo>) {
        imagesDao.insertImageItems(images)
    }

    override fun getStoredImages(): LiveData<List<ImageInfo>> {
        return imagesDao.getAllImages()
    }

    override fun getImageById(imageId: String): LiveData<ImageInfo> {
        return imagesDao.getImageById(imageId = imageId)
    }

}