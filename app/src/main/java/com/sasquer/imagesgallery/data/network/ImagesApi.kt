package com.sasquer.imagesgallery.data.network

import com.sasquer.imagesgallery.data.ImagesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

//    /**
//     * Get random photos
//     */
//    @GET("/photos/random")
//    fun getRandomPhotos(): Single<List<ImagesResponse>>

    /**
     * Get all photos
     * valid values for @param orderBy: "latest", "oldest", "popular"; default: "latest"
     */
    @GET("/photos")
    fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20,
        @Query("order_by") orderBy: String = "popular"
    ): Single<List<ImagesResponse>>
}