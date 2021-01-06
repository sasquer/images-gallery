package com.sasquer.imagesgallery.ui.main

import androidx.lifecycle.MutableLiveData
import com.sasquer.imagesgallery.data.ImagesResponse
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val interactor: ImagesInteractor
) : BaseViewModel() {

    val images: MutableLiveData<List<ImagesResponse>> = MutableLiveData()

    init {
        loadImages()
    }

    private fun loadImages() {
        addDisposable(
            interactor.getImages(1)
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }
}