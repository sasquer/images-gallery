package com.sasquer.imagesgallery.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val interactor: ImagesInteractor
) : BaseViewModel() {
    val images: LiveData<List<ImageInfo>> = interactor.getImages()

    private val updating: MutableLiveData<Boolean> = MutableLiveData()
    val isUpdating: LiveData<Boolean>
        get() = updating

    init {
        loadImages(1)
    }

    fun loadImages(page: Int) {
        addDisposable(
            interactor.getRemoteImages(page = page)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { updating.postValue(true) }
                .doOnSuccess { updating.postValue(false) }
                .doOnError { updating.postValue(false) }
                .subscribe { list, error ->
                    if (!list.isNullOrEmpty())
                        interactor.saveImages(list)
                    error?.localizedMessage?.let { Log.e("error", it) }
                }
        )
    }
}