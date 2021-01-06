package com.sasquer.imagesgallery.data.repository

import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.network.ImagesApi
import io.reactivex.Single
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val apiService: ImagesApi
) : ImagesRepository {

    override fun getRemoteImages(page: Int): Single<List<ImagesResponse>> {
        return apiService.getPhotos(page = page)
    }
}