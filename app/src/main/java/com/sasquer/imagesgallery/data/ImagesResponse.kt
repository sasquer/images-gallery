package com.sasquer.imagesgallery.data

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("likes") val likes: Long? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("urls") val urls: ImageUrls? = null
)

data class ImageUrls(
    val full: String? = null,
    val regular: String? = null,
    val small: String? = null,
    val thumb: String? = null
)
