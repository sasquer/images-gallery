package com.sasquer.imagesgallery.data.db.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images_table")
data class ImageInfo(
    @PrimaryKey
    val id: String = "",
    val downloads: Long = 0,
    val description: String = "",
    val original: String = "",
    val thumb: String = ""
)
