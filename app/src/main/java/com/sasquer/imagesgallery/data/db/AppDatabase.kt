package com.sasquer.imagesgallery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sasquer.imagesgallery.data.db.dao.ImagesDao
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo

@Database(entities = [ImageInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}