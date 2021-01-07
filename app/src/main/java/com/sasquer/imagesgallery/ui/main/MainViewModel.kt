package com.sasquer.imagesgallery.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val interactor: ImagesInteractor
) : BaseViewModel() {

    val images: MutableLiveData<List<ImageInfo>> = MutableLiveData()

    init {
        loadImages()
    }

    private fun loadImages() {
        addDisposable(
            interactor.getImages(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list, error ->
                    if (!list.isNullOrEmpty())
                        images.postValue(list)
                    error?.localizedMessage?.let { Log.e("error", it) }
                }
        )
    }
}