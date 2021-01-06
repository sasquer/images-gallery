package com.sasquer.imagesgallery.data

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("id") val id: String,
    @SerializedName("downloads") val downloads: Long,
    @SerializedName("description") val description: String,
    @SerializedName("urls") val urls: ImageUrls
)

data class ImageUrls(
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
