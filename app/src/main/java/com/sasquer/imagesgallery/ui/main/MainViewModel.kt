package com.sasquer.imagesgallery.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val interactor: ImagesInteractor
) : BaseViewModel() {

    val images: LiveData<List<ImageInfo>> = interactor.getImages()

    init {
        loadImages()
    }

    private fun loadImages() {
        addDisposable(
            interactor.getRemoteImages(1)
                .subscribeOn(Schedulers.io())
                .subscribe { list, error ->
                    if (!list.isNullOrEmpty())
                        interactor.saveImages(list)
                    error?.localizedMessage?.let { Log.e("error", it) }
                }
        )
    }
}