package com.sasquer.imagesgallery.data.mapper

import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import javax.inject.Inject

class ImageMapper @Inject constructor() : BaseMapper<ImageInfo, ImagesResponse> {
    override fun map(from: ImagesResponse): ImageInfo = with(from) {
        ImageInfo(
            id = id ?: "",
            downloads = downloads ?: 0,
            description = description ?: "",
            original = urls?.regular ?: "",
            thumb = urls?.thumb ?: ""
        )
    }
}