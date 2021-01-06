package com.sasquer.imagesgallery.data.repository

import com.sasquer.imagesgallery.data.ImagesResponse
import io.reactivex.Single

interface ImagesRepository {
    fun getRemoteImages(page: Int): Single<List<ImagesResponse>>
}