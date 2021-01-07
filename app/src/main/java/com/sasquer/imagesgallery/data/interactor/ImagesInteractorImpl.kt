package com.sasquer.imagesgallery.data.interactor

import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.mapper.ImageMapper
import com.sasquer.imagesgallery.data.repository.ImagesRepository
import io.reactivex.Single
import javax.inject.Inject

class ImagesInteractorImpl @Inject constructor(
    private val repository: ImagesRepository,
    private val mapper: ImageMapper
) : ImagesInteractor {

    override fun getRemoteImages(page: Int): Single<List<ImageInfo>> {
        return repository.getRemoteImages(page)
            .map { list -> mapper.invoke(list) }
    }

    override fun saveImages(images: List<ImageInfo>) {
        repository.saveImages(images)
    }

    override fun getImages(): LiveData<List<ImageInfo>> {
        return repository.getStoredImages()
    }
}