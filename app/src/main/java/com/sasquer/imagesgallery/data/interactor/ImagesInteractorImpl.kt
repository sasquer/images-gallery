package com.sasquer.imagesgallery.data.interactor

import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.mapper.ImageMapper
import com.sasquer.imagesgallery.data.repository.ImagesRepository
import io.reactivex.Single
import javax.inject.Inject

class ImagesInteractorImpl @Inject constructor(
    private val repository: ImagesRepository,
    private val mapper: ImageMapper
) : ImagesInteractor {

    override fun getImages(page: Int): Single<List<ImageInfo>> {
        return repository.getRemoteImages(page = page)
            .map { list -> mapper.invoke(list) }
    }
}