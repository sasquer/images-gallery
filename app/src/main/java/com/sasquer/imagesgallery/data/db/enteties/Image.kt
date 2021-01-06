package com.sasquer.imagesgallery.data.db.enteties

data class Image(
    val id: String,
    val downloads: Long,
    val description: String,
    val original: String,
    val thumb: String
)
