package com.sasquer.imagesgallery.data.mapper

import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.db.enteties.Image
import javax.inject.Inject

class ImageMapper @Inject constructor() : BaseMapper<Image, ImagesResponse> {
    override fun map(from: ImagesResponse): Image = with(from) {
        Image(
            id = id ?: "",
            downloads = downloads ?: 0,
            description = description ?: "",
            original = urls?.regular ?: "",
            thumb = urls?.thumb ?: ""
        )
    }
}