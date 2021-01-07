package com.sasquer.imagesgallery.data.db.enteties

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageItems(imageList: List<ImageInfo>): List<Long>

    @Query("SELECT * FROM images_table")
    fun getAllImages(): LiveData<List<ImageInfo>>

    @Query("SELECT * FROM images_table WHERE id IN(:imageId)")
    fun getImageById(imageId: String): LiveData<ImageInfo>
}