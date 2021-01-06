package com.sasquer.imagesgallery.data.interactor

import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.repository.ImagesRepository
import io.reactivex.Single
import javax.inject.Inject

class ImagesInteractorImpl @Inject constructor(
    private val repository: ImagesRepository
) : ImagesInteractor {

    override fun getImages(page: Int): Single<List<ImagesResponse>> {
        return repository.getRemoteImages(page = page)
    }
}